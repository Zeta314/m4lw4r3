package com.zeta314.runtime.instructions.io;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;

import java.lang.reflect.Type;

public class WriteCharacterInstruction extends InstructionDefinition {
    public WriteCharacterInstruction() {
        super("WRITEC", 1);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register target = (Register) args[0];
        System.out.print((char) target.getValue());
        System.out.flush();
    }
}
