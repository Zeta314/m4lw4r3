package com.zeta314.runtime.instructions.data;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Memories;

import java.lang.reflect.Type;

public class WriteByteConstantInstruction extends InstructionDefinition {
    public WriteByteConstantInstruction() {
        super("WRITEBC", 2);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class, Integer.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register target = (Register) args[0];
        Memories.MEMORY.set((Integer) args[1], (byte) (target.getValue() & 0xFF));
    }
}
