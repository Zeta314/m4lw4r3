package com.zeta314.runtime.instructions.math;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Registers;

import java.lang.reflect.Type;

public class DivideConstantInstruction extends InstructionDefinition {
    public DivideConstantInstruction() {
        super("DIVC", 2);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class, Integer.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register register = (Register) args[0];

        Registers.CARRY.setValue(register.getValue() % (Integer) args[1]);
        register.setValue(register.getValue() / (Integer) args[1]);
    }
}
