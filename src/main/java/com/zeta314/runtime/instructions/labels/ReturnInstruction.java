package com.zeta314.runtime.instructions.labels;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Memories;
import com.zeta314.runtime.environment.Registers;

import java.lang.reflect.Type;

public class ReturnInstruction extends InstructionDefinition {
    public ReturnInstruction() {
        super("RETURN", 0);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[0];
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Registers.INSTRUCTION_POINTER.setValue(Memories.STACK.pop());
    }
}
