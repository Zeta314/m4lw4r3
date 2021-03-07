package com.zeta314.runtime.instructions.jumps;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Registers;

import java.lang.reflect.Type;

public class JumpEqualInstruction extends InstructionDefinition {
    public JumpEqualInstruction() {
        super("JUMPE", 1);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Integer.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        if (Registers.ZERO_FLAG.getValue() == 0) {
            Registers.INSTRUCTION_POINTER.setValue((Integer) args[0]);
        }
    }
}
