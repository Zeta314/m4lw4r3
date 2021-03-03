package com.zeta314.runtime.instructions.math;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Registers;

import java.lang.reflect.Type;

public class DivideInstruction extends InstructionDefinition {
    public DivideInstruction() {
        super("DIV", 2);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class, Register.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register register1 = (Register) args[0];
        Register register2 = (Register) args[1];

        Registers.CARRY.setValue(register1.getValue() % register2.getValue());
        register1.setValue(register1.getValue() / register2.getValue());
    }
}
