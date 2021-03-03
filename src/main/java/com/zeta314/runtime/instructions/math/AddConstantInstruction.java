package com.zeta314.runtime.instructions.math;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;

import java.lang.reflect.Type;

public class AddConstantInstruction extends InstructionDefinition {
    public AddConstantInstruction() {
        super("ADDC", 2);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class, Integer.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register register = (Register) args[0];
        register.increment((Integer) args[1]);
    }
}
