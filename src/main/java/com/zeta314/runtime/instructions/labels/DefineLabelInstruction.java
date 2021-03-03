package com.zeta314.runtime.instructions.labels;

import com.zeta314.exceptions.general.RegistryException;
import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.base.Label;
import com.zeta314.runtime.environment.Labels;
import com.zeta314.runtime.environment.Registers;

import java.lang.reflect.Type;

public class DefineLabelInstruction extends InstructionDefinition {
    public DefineLabelInstruction() {
        super("LABEL", 1, true);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{String.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        String labelName = (String) args[0];

        try {
            Labels.register(new Label(labelName, Registers.INSTRUCTION_POINTER.getValue()));
        } catch (RegistryException ex) {
            throw new InstructionException(ex.getMessage());
        }
    }
}
