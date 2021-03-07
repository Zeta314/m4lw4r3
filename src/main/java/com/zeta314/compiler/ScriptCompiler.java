package com.zeta314.compiler;

import com.zeta314.exceptions.compiler.CompilerException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.Instruction;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Instructions;
import com.zeta314.runtime.environment.Registers;
import com.zeta314.util.IntegerUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ScriptCompiler {
    public static byte[] compileScript(Instruction[] instructions) {
        List<Byte> compiledInstructions = new ArrayList<>();

        for (Instruction instruction : instructions) {
            compiledInstructions.addAll(instruction.toBytes());
        }

        return ArrayUtils.toPrimitive(compiledInstructions.toArray(new Byte[0]));
    }

    public static Instruction[] decompileScript(byte[] bytecode) throws CompilerException {
        List<Instruction> decompiledInstructions = new ArrayList<>();

        int bytecodeOffset = 0;
        while (bytecodeOffset < bytecode.length) {
            if (bytecode[bytecodeOffset] > Instructions.INSTRUCTIONS.size() || bytecode[bytecodeOffset] < 0) {
                throw new CompilerException(
                        String.format("Invalid instruction with byte code: %02x.", bytecode[bytecodeOffset]));
            }

            InstructionDefinition definition = Instructions.INSTRUCTIONS.get(bytecode[bytecodeOffset]);
            bytecodeOffset++;

            List<Object> decompiledArguments = new ArrayList<>();
            int byteArgOffset = 0;
            for (int argumentOffset = 0; argumentOffset < definition.getArgsCount(); argumentOffset++) {
                Type argType = definition.getArgsType()[argumentOffset];

                if (argType.equals(Register.class)) {
                    decompiledArguments.add(Registers.REGISTERS.get(bytecode[bytecodeOffset + byteArgOffset]));
                    byteArgOffset++;
                } else if (argType.equals(Integer.class)) {
                    byte[] integerData = new byte[4];
                    for (int i = 0; i < integerData.length; i++) {
                        integerData[i] = bytecode[bytecodeOffset + byteArgOffset + i];
                    }
                    ArrayUtils.reverse(integerData);

                    decompiledArguments.add(IntegerUtils.fromByteArray(integerData));
                    byteArgOffset += integerData.length;
                } else if (argType.equals(String.class)) {
                    StringBuilder string = new StringBuilder();
                    while (bytecode[bytecodeOffset + byteArgOffset] != 0x00) {
                        string.append((char) bytecode[bytecodeOffset + byteArgOffset]);
                        byteArgOffset++;
                    }
                    byteArgOffset++;

                    decompiledArguments.add(string.toString());
                }
            }

            decompiledInstructions.add(new Instruction(definition, decompiledArguments.toArray()));
            bytecodeOffset += byteArgOffset;
        }

        return decompiledInstructions.toArray(new Instruction[0]);
    }
}
