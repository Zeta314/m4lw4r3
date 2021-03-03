package com.zeta314.runtime.base;

import com.zeta314.exceptions.runtime.InstructionException;
import com.zeta314.runtime.environment.Instructions;

import java.lang.reflect.Type;

public abstract class InstructionDefinition {
    private final String name;
    private final int argsCount;
    private final boolean isPreprocessed;

    public InstructionDefinition(String name, int argsCount, boolean isPreprocessed) {
        this.name = name;
        this.argsCount = argsCount;
        this.isPreprocessed = isPreprocessed;

        Instructions.INSTRUCTIONS.add(this);
    }

    public InstructionDefinition(String name, int argsCount) {
        this(name, argsCount, false);
    }

    public InstructionDefinition(String name) {
        this(name, 0);
    }

    public abstract Type[] getArgsType();

    public abstract void execute(Object[] args) throws InstructionException;

    public String getName() {
        return name;
    }

    public int getArgsCount() {
        return argsCount;
    }

    public boolean isPreprocessed() {
        return isPreprocessed;
    }

    @Override
    public String toString() {
        return String.format("Instruction(name=\"%s\", argsCount=%d, isPreprocessed=%b)",
                name, argsCount, isPreprocessed);
    }
}
