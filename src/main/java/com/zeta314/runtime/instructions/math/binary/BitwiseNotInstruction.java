package com.zeta314.runtime.instructions.math.binary;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;

import java.lang.reflect.Type;

public class BitwiseNotInstruction extends InstructionDefinition {
    public BitwiseNotInstruction() {
        super("NOT", 1);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register register = (Register) args[0];
        register.setValue(~register.getValue());
    }
}
