package com.zeta314.runtime.base;

import com.zeta314.exceptions.runtime.InstructionException;

import java.util.Arrays;

public class Instruction {
    private final InstructionDefinition definition;
    private final Object[] arguments;

    public Instruction(InstructionDefinition definition, Object[] arguments) {
        this.definition = definition;
        this.arguments = arguments;
    }

    public Instruction(InstructionDefinition definition) {
        this(definition, new Object[0]);
    }

    public void execute() throws InstructionException {
        definition.execute(arguments);
    }

    public InstructionDefinition getDefinition() {
        return definition;
    }

    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public String toString() {
        return "Instruction(target=" + definition.toString() + ", arguments=" + Arrays.toString(arguments) + ")";
    }
}
