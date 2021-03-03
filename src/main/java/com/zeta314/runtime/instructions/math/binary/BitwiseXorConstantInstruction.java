package com.zeta314.runtime.instructions.math.binary;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;

import java.lang.reflect.Type;

public class BitwiseXorConstantInstruction extends InstructionDefinition {
    public BitwiseXorConstantInstruction() {
        super("XORC", 2);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class, Integer.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register register = (Register) args[0];
        register.setValue(register.getValue() ^ (Integer) args[1]);
    }
}
