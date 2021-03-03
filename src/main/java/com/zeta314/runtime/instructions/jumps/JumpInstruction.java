package com.zeta314.runtime.instructions.jumps;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Registers;

import java.lang.reflect.Type;

public class JumpInstruction extends InstructionDefinition {
    public JumpInstruction() {
        super("JUMP", 1);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{String.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Registers.INSTRUCTION_POINTER.setValue((Integer) args[0]);
    }
}
