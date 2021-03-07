package com.zeta314.runtime.parsing;

import com.zeta314.exceptions.general.RegistryException;
import com.zeta314.exceptions.runtime.ParserException;
import com.zeta314.runtime.base.Instruction;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Instructions;
import com.zeta314.util.FileUtils;
import com.zeta314.util.Shlex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    public static Instruction[] readInstructions(String path) throws IOException, RegistryException, ParserException {
        String fileData = FileUtils.readFile(path);
        fileData = fileData.trim();
        fileData = fileData.replaceAll(";.*", ""); // Filter out comments
        fileData = fileData.replaceAll("[\r\n \t]", " ");
        fileData = fileData.replaceAll(" +", " "); // Remove repeated whitespaces
        fileData = fileData.trim(); // Remove orphan whitespaces

        String[] splitted = Shlex.shellSplit(fileData);
        List<Instruction> instructions = new ArrayList<>();
        for (int i = 0; i < splitted.length; i++) {
            InstructionDefinition definition = Instructions.getByName(splitted[i].toUpperCase());

            List<Object> arguments = new ArrayList<>();
            if (definition.getArgsCount() > 0) {
                if (definition.getArgsCount() + i >= splitted.length) {
                    throw new ParserException(
                            String.format("Instruction \"%s\" requires %d arguments, but the parser reached EOF.",
                                    definition.getName(), definition.getArgsCount()));
                }

                for (int j = 1; j <= definition.getArgsCount(); j++) {
                    try {
                        arguments.add(ArgumentMatcher.convertArgument(splitted[i + j],
                                definition.getArgsType()[j - 1]));
                    } catch (Exception ex) {
                        throw new ParserException(
                                String.format("Failed to convert argument for instruction \"%s\": %s",
                                        definition.getName(), ex.getMessage()));
                    }
                }
                i += definition.getArgsCount();
            }

            instructions.add(new Instruction(definition, arguments.toArray()));
        }

        return instructions.toArray(new Instruction[0]);
    }
}
