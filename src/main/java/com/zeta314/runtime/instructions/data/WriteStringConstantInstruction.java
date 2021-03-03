package com.zeta314.runtime.instructions.data;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Memories;

import java.lang.reflect.Type;

public class WriteStringConstantInstruction extends InstructionDefinition {
    public WriteStringConstantInstruction() {
        super("WRITESC", 2);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class, String.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register target = (Register) args[0];
        String string = (String) args[1];

        int i = 0;
        for (; i < string.length(); i++) {
            Memories.MEMORY.set(target.getValue() + i, (byte) string.charAt(i));
        }
        Memories.MEMORY.set(target.getValue() + i + 1, (byte) 0);
    }
}
