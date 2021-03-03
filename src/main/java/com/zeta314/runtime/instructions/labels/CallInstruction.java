package com.zeta314.runtime.instructions.labels;

import com.zeta314.exceptions.general.RegistryException;
import com.zeta314.exceptions.memory.StackException;
import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.base.Label;
import com.zeta314.runtime.environment.Labels;
import com.zeta314.runtime.environment.Memories;
import com.zeta314.runtime.environment.Registers;

import java.lang.reflect.Type;

public class CallInstruction extends InstructionDefinition {
    public CallInstruction() {
        super("CALL", 1);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{String.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        try {
            Label label = Labels.getByName((String) args[0]);
            Memories.STACK.push(Registers.INSTRUCTION_POINTER.getValue());
            Registers.INSTRUCTION_POINTER.setValue(label.getAddress());
        } catch (RegistryException | StackException ex) {
            throw new InstructionException(ex.getMessage());
        }
    }
}
