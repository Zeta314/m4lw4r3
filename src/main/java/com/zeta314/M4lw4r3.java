package com.zeta314;

import com.zeta314.compiler.ScriptCompiler;
import com.zeta314.exceptions.compiler.CompilerException;
import com.zeta314.exceptions.general.RegistryException;
import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.exceptions.runtime.ParserException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.Instruction;
import com.zeta314.runtime.debugging.DebugUtils;
import com.zeta314.runtime.environment.Registers;
import com.zeta314.runtime.parsing.FileParser;
import com.zeta314.util.FileUtils;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class M4lw4r3 {
    public static void main(String[] args) throws ParserException, IOException, RegistryException {
        Options options = new Options();

        Option inputScript = new Option("file", true, "The input script path");
        inputScript.setRequired(true);
        options.addOption(inputScript);

        options.addOption("compiled", false,
                "The provided script is compiled, hence it cannot be interpreted directly.");

        options.addOption("debug", false, "Print full dump at the end");
        options.addOption("compile", true,
                "Compiles the script and writes it to the given path.");
        options.addOption("decompile", true,
                "Decompiles the script and writes it to the given path.");

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
            formatter.printHelp("m4lw4r3", options);
            return;
        }

        // Decompile the provided script
        if (cmd.hasOption("decompile")) {
            byte[] scriptData;
            try {
                scriptData = FileUtils.readBytes(cmd.getOptionValue("file"));
            } catch (IOException ex) {
                System.err.printf("Error: %s\n", ex.getMessage());
                return;
            }

            Instruction[] instructions;
            try {
                instructions = ScriptCompiler.decompileScript(scriptData);
            } catch (CompilerException ex) {
                System.err.printf("Error: %s\n", ex.getMessage());
                return;
            }

            StringBuilder scriptOutput = new StringBuilder();
            for (Instruction instruction : instructions) {
                scriptOutput.append(instruction.getDefinition().getName());
                for (Object argument : instruction.getArguments()) {
                    if (argument instanceof Register) {
                        scriptOutput.append(((Register) argument).getName());
                    } else if (argument instanceof Integer) {
                        scriptOutput.append(argument);
                    } else if (argument instanceof String) {
                        scriptOutput.append("\"");
                        scriptOutput.append((String) argument);
                        scriptOutput.append("\"");
                    }
                }

                scriptOutput.append("\n");
            }
            String scriptCode = scriptOutput.toString().trim();

            File outputFile = new File(cmd.getOptionValue("decompile"));
            Files.writeString(outputFile.toPath(), scriptCode);
            System.out.printf("%d instructions written.\n", instructions.length);
            return;
        }

        Instruction[] instructions;
        // If the provided script is compiled, decompile it
        if (cmd.hasOption("compiled")) {
            try {
                byte[] bytecode = FileUtils.readBytes(cmd.getOptionValue("file"));
                instructions = ScriptCompiler.decompileScript(bytecode);
            } catch (CompilerException | IOException ex) {
                System.err.printf("Error: %s\n", ex.getMessage());
                return;
            }
        } else {
            try {
                instructions = FileParser.readInstructions(cmd.getOptionValue("file"));
            } catch (IOException | RegistryException | ParserException ex) {
                System.err.printf("Error: %s\n", ex.getMessage());
                return;
            }
        }

        // Compile the provided script
        if (cmd.hasOption("compile")) {
            File outputFile = new File(cmd.getOptionValue("compile"));

            byte[] bytecode = ScriptCompiler.compileScript(instructions);
            Files.write(outputFile.toPath(), bytecode);

            System.out.printf("%d bytes written.\n", bytecode.length);
            return;
        }

        // Preprocess all instructions that need to be
        for (Instruction instruction : instructions) {
            if (instruction.getDefinition().isPreprocessed()) {
                try {
                    instruction.execute();
                } catch (InstructionException ex) {
                    System.err.printf("Failed to execute instruction.\nError: %s\n", ex.getMessage());
                    DebugUtils.dumpEverything();
                    return;
                }
            }

            Registers.INSTRUCTION_POINTER.increment(1);
        }
        Registers.INSTRUCTION_POINTER.setValue(0);

        // Enable the DEBUG register if it's needed
        if (cmd.hasOption("debug"))
            Registers.DEBUG_FLAG.setValue(1);

        // Start executing the code now
        while (Registers.INSTRUCTION_POINTER.getValue() < instructions.length && Registers.HALT_FLAG.getValue() == 0) {
            Instruction instruction = instructions[Registers.INSTRUCTION_POINTER.getValue()];

            if (!instruction.getDefinition().isPreprocessed()) {
                try {
                    instruction.execute();
                } catch (InstructionException ex) {
                    System.err.printf("Failed to execute instruction.\nError: %s\n", ex.getMessage());
                    DebugUtils.dumpEverything();
                    return;
                }
            }

            Registers.INSTRUCTION_POINTER.increment(1);
        }

        if (cmd.hasOption("debug"))
            DebugUtils.dumpEverything();
    }
}
