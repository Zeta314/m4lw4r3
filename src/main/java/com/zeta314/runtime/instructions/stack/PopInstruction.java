package com.zeta314.runtime.instructions.stack;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.environment.Memories;

import java.lang.reflect.Type;

public class PopInstruction extends InstructionDefinition {
    public PopInstruction() {
        super("POP", 1);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register register = (Register) args[0];
        register.setValue(Memories.STACK.pop());
    }
}
