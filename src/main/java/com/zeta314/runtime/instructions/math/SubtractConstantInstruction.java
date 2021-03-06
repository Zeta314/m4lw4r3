package com.zeta314.runtime.instructions.math;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;

import java.lang.reflect.Type;

public class SubtractConstantInstruction extends InstructionDefinition {
    public SubtractConstantInstruction() {
        super("SUBC", 2);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class, Integer.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register register = (Register) args[0];
        register.decrement((Integer) args[1]);
    }
}
