package com.zeta314.runtime.instructions.data;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Memories;

import java.lang.reflect.Type;

public class WriteByteInstruction extends InstructionDefinition {
    public WriteByteInstruction() {
        super("WRITEB", 2);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class, Register.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register value = (Register) args[0];
        Register address = (Register) args[1];
        Memories.MEMORY.set(address.getValue(), (byte) (value.getValue() & 0xFF));
    }
}
