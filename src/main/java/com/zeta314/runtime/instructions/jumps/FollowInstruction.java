package com.zeta314.runtime.instructions.jumps;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Registers;

import java.lang.reflect.Type;

public class FollowInstruction extends InstructionDefinition {
    public FollowInstruction() {
        super("FOLLOW", 1);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register register = (Register) args[0];
        Registers.INSTRUCTION_POINTER.setValue(register.getValue());
    }
}
