package com.zeta314.runtime.instructions.data;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;

import java.lang.reflect.Type;

public class SetRegisterInstruction extends InstructionDefinition {
    public SetRegisterInstruction() {
        super("SETR", 2);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class, Integer.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register target = (Register) args[0];
        target.setValue((Integer) args[1]);
    }
}
