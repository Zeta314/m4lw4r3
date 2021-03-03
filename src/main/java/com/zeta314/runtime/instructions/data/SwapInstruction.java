package com.zeta314.runtime.instructions.data;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.InstructionDefinition;

import java.lang.reflect.Type;

public class SwapInstruction extends InstructionDefinition {
    public SwapInstruction() {
        super("SWAP", 2);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[]{Register.class, Register.class};
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        Register register1 = (Register) args[1];
        Register register2 = (Register) args[2];
        int tmpValue = register1.getValue();
        register1.setValue(register2.getValue());
        register2.setValue(tmpValue);
    }
}
