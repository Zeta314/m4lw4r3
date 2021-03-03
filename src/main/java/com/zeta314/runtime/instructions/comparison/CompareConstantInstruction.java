package com.zeta314.runtime.instructions.comparison;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Registers;

import java.lang.reflect.Type;

public class CompareConstantInstruction extends InstructionDefinition {
    public CompareConstantInstruction() {
        super("COMPAREC", 2);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class, Integer.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register register = (Register) args[0];
        Registers.ZERO_FLAG.setValue(register.getValue() - (Integer) args[1]);
    }
}
