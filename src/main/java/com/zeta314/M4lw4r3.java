package com.zeta314;

import com.zeta314.exceptions.general.RegistryException;
import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.exceptions.runtime.ParserException;
import com.zeta314.runtime.base.Instruction;
import com.zeta314.runtime.debugging.DebugUtils;
import com.zeta314.runtime.environment.Registers;
import com.zeta314.runtime.parsing.FileParser;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.util.List;

public class M4lw4r3 {
    public static void main(String[] args) throws ParserException, IOException, RegistryException {
        Options options = new Options();

        Option inputScript = new Option("file", true, "The input script path");
        inputScript.setRequired(true);
        options.addOption(inputScript);

        options.addOption("debug", false, "Print full dump at the end");

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

        List<Instruction> instructions;
        try {
            instructions = FileParser.readInstructions(cmd.getOptionValue("file"));
        } catch (IOException ex) {
            System.err.printf("Error: %s\n", ex.getMessage());
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

        // Start executing the code now
        while (Registers.INSTRUCTION_POINTER.getValue() < instructions.size()) {
            Instruction instruction = instructions.get(Registers.INSTRUCTION_POINTER.getValue());

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
