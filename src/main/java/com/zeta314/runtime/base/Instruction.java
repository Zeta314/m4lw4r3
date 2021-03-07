package com.zeta314.runtime.base;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.environment.Instructions;
import com.zeta314.runtime.environment.Registers;
import com.zeta314.util.IntegerUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Instruction {
    private final InstructionDefinition definition;
    private final Object[] arguments;

    public Instruction(InstructionDefinition definition, Object[] arguments) {
        this.definition = definition;
        this.arguments = arguments;
    }

    public Instruction(InstructionDefinition definition) {
        this(definition, new Object[0]);
    }

    public void execute() throws InstructionException {
        definition.execute(arguments);
    }

    public InstructionDefinition getDefinition() {
        return definition;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public List<Byte> toBytes() {
        List<Byte> dump = new ArrayList<>();
        dump.add((byte) Instructions.INSTRUCTIONS.indexOf(definition));

        for (int i = 0; i < definition.getArgsCount(); i++) {
            Type argType = definition.getArgsType()[i];

            if (argType.equals(Register.class)) {
                dump.add((byte) Registers.REGISTERS.indexOf((Register) arguments[i]));
            } else if (argType.equals(Integer.class)) {
                for (byte piece : IntegerUtils.toByteArray((Integer) arguments[i])) {
                    dump.add(piece);
                }
            } else if (argType.equals(String.class)) {
                for (byte ch : ((String) arguments[i]).getBytes(StandardCharsets.UTF_8)) {
                    dump.add(ch);
                }
                dump.add((byte) 0x00);
            }
        }

        return dump;
    }

    @Override
    public String toString() {
        return "Instruction(target=" + definition.toString() + ", arguments=" + Arrays.toString(arguments) + ")";
    }
}
