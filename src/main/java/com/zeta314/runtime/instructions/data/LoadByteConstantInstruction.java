package com.zeta314.runtime.instructions.data;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Memories;

import java.lang.reflect.Type;

public class LoadByteConstantInstruction extends InstructionDefinition {
    public LoadByteConstantInstruction() {
        super("LOADBC", 2);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Integer.class, Register.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register target = (Register) args[1];
        target.setValue(Memories.MEMORY.get((Integer) args[0]));
    }
}
