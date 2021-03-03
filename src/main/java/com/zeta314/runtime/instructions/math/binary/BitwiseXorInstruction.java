package com.zeta314.runtime.instructions.math.binary;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;

import java.lang.reflect.Type;

public class BitwiseXorInstruction extends InstructionDefinition {
    public BitwiseXorInstruction() {
        super("XOR", 2);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class, Register.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register register1 = (Register) args[0];
        Register register2 = (Register) args[0];

        register1.setValue(register1.getValue() ^ register2.getValue());
    }
}
