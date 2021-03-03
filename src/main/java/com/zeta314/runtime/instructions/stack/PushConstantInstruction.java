package com.zeta314.runtime.instructions.stack;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Memories;

import java.lang.reflect.Type;

public class PushConstantInstruction extends InstructionDefinition {
    public PushConstantInstruction() {
        super("PUSHC", 1);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Integer.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Memories.STACK.push((Integer) args[0]);
    }
}
