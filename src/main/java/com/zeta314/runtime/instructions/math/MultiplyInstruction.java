package com.zeta314.runtime.instructions.math;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;

import java.lang.reflect.Type;

public class MultiplyInstruction extends InstructionDefinition {
    public MultiplyInstruction() {
        super("MULT", 2);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class, Register.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register register1 = (Register) args[0];
        Register register2 = (Register) args[1];
        register1.setValue(register1.getValue() * register2.getValue());
    }
}
