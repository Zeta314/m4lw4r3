package com.zeta314.runtime.instructions.io;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Memories;

import java.lang.reflect.Type;

public class WriteCharacterMemoryInstruction extends InstructionDefinition {
    public WriteCharacterMemoryInstruction() {
        super("WRITECM", 1);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register target = (Register) args[0];
        System.out.print((char) Memories.MEMORY.get(target.getValue()));
        System.out.flush();
    }
}
