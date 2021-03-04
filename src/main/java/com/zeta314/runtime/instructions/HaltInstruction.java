package com.zeta314.runtime.instructions;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Registers;

import java.lang.reflect.Type;

public class HaltInstruction extends InstructionDefinition {
    public HaltInstruction() {
        super("HALT", 0);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[0];
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Registers.HALT_FLAG.setValue(1);
    }
}
