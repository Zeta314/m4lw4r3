package com.zeta314.runtime.instructions.io;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Memories;
import com.zeta314.util.RawConsoleInput;

import java.io.IOException;
import java.lang.reflect.Type;

public class ReadCharacterMemoryInstruction extends InstructionDefinition {
    public ReadCharacterMemoryInstruction() {
        super("READCM", 1);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register target = (Register) args[0];
        try {
            Memories.MEMORY.set(target.getValue(), (byte) RawConsoleInput.read(true));
        } catch (IOException ex) {
            throw new InstructionException(ex.getMessage());
        }
    }
}
