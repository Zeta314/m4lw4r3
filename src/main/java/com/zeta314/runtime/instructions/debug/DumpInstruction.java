package com.zeta314.runtime.instructions.debug;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.debugging.DebugUtils;
import com.zeta314.runtime.environment.Registers;

import java.lang.reflect.Type;

public class DumpInstruction extends InstructionDefinition {
    public DumpInstruction() {
        super("DBGDUMP", 0);
    }

    @Override
    public Type[] getArgsType() {
        return new Type[0];
    }

    @Override
    public void execute(Object[] args) throws InstructionException {
        if (Registers.DEBUG_FLAG.getValue() > 0)
            DebugUtils.dumpEverything();
    }
}
