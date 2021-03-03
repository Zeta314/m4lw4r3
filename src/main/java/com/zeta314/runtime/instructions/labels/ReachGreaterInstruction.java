package com.zeta314.runtime.instructions.labels;

import com.zeta314.exceptions.general.RegistryException;
import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.base.Label;
import com.zeta314.runtime.environment.Labels;
import com.zeta314.runtime.environment.Registers;

import java.lang.reflect.Type;

public class ReachGreaterInstruction extends InstructionDefinition {
    public ReachGreaterInstruction() {
        super("REACHG", 1);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{String.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        try {
            Label label = Labels.getByName((String) args[0]);

            if (Registers.ZERO_FLAG.getValue() > 0)
                Registers.INSTRUCTION_POINTER.setValue(label.getAddress());
        } catch (RegistryException ex) {
            throw new InstructionException(ex.getMessage());
        }
    }
}
