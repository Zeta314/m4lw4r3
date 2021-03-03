package com.zeta314.runtime.instructions;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.runtime.base.InstructionDefinition;

import java.lang.reflect.Type;

public class NullInstruction extends InstructionDefinition {
    public NullInstruction() {
        super("NULL", 0);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[0];
    }

    @Override
    public void execute(Object[] args) throws InstructionException {

    }
}
