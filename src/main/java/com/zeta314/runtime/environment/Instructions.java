package com.zeta314.runtime.environment;

import com.zeta314.exceptions.general.RegistryException;
import com.zeta314.runtime.base.InstructionDefinition;
import com.zeta314.runtime.instructions.HaltInstruction;
import com.zeta314.runtime.instructions.NullInstruction;
import com.zeta314.runtime.instructions.comparison.CompareConstantInstruction;
import com.zeta314.runtime.instructions.comparison.CompareInstruction;
import com.zeta314.runtime.instructions.data.*;
import com.zeta314.runtime.instructions.io.*;
import com.zeta314.runtime.instructions.jumps.*;
import com.zeta314.runtime.instructions.labels.*;
import com.zeta314.runtime.instructions.math.*;
import com.zeta314.runtime.instructions.math.binary.*;
import com.zeta314.runtime.instructions.stack.PopInstruction;
import com.zeta314.runtime.instructions.stack.PushConstantInstruction;
import com.zeta314.runtime.instructions.stack.PushInstruction;

import java.util.ArrayList;
import java.util.List;

public class Instructions {
    public static final List<InstructionDefinition> INSTRUCTIONS = new ArrayList<>();

    // Comparison
    public static final InstructionDefinition COMPAREC = new CompareConstantInstruction();
    public static final InstructionDefinition COMPARE = new CompareInstruction();

    // Data manipulation
    public static final InstructionDefinition COPY = new CopyInstruction();
    public static final InstructionDefinition LOADBC = new LoadByteConstantInstruction();
    public static final InstructionDefinition LOADB = new LoadByteInstruction();
    public static final InstructionDefinition LOADIC = new LoadIntegerConstantInstruction();
    public static final InstructionDefinition LOADI = new LoadIntegerInstruction();
    public static final InstructionDefinition SETR = new SetRegisterInstruction();
    public static final InstructionDefinition SWAP = new SwapInstruction();
    public static final InstructionDefinition WRITEBC = new WriteByteConstantInstruction();
    public static final InstructionDefinition WRITEB = new WriteByteInstruction();
    public static final InstructionDefinition WRITEIC = new WriteIntegerConstantInstruction();
    public static final InstructionDefinition WRITEI = new WriteIntegerInstruction();
    public static final InstructionDefinition WRITESC = new WriteStringConstantInstruction();

    // IO
    public static final InstructionDefinition READCM = new ReadCharacterMemoryInstruction();
    public static final InstructionDefinition READC = new ReadCharacterInstruction();
    public static final InstructionDefinition WRITECM = new WriteCharacterMemoryInstruction();
    public static final InstructionDefinition WRITEC = new WriteCharacterInstruction();
    public static final InstructionDefinition WRITES = new WriteStringInstruction();

    // Jumps
    public static final InstructionDefinition FOLLOW = new FollowInstruction();
    public static final InstructionDefinition JUMPE = new JumpEqualInstruction();
    public static final InstructionDefinition JUMPGE = new JumpGreaterEqualInstruction();
    public static final InstructionDefinition JUMPG = new JumpGreaterInstruction();
    public static final InstructionDefinition JUMP = new JumpInstruction();
    public static final InstructionDefinition JUMPNE = new JumpNotEqualInstruction();
    public static final InstructionDefinition JUMPNZ = new JumpNotZeroInstruction();
    public static final InstructionDefinition JUMPSE = new JumpSmallerEqualInstruction();
    public static final InstructionDefinition JUMPS = new JumpSmallerInstruction();
    public static final InstructionDefinition JUMPZ = new JumpZeroInstruction();

    // Labels
    public static final InstructionDefinition CALL = new CallInstruction();
    public static final InstructionDefinition LABEL = new DefineLabelInstruction();
    public static final InstructionDefinition REACHE = new ReachEqualInstruction();
    public static final InstructionDefinition REACHGE = new ReachGreaterEqualInstruction();
    public static final InstructionDefinition REACHG = new ReachGreaterInstruction();
    public static final InstructionDefinition REACH = new ReachInstruction();
    public static final InstructionDefinition REACHNE = new ReachNotEqualInstruction();
    public static final InstructionDefinition REACHNZ = new ReachNotZeroInstruction();
    public static final InstructionDefinition REACHSE = new ReachSmallerEqualInstruction();
    public static final InstructionDefinition REACHS = new ReachSmallerInstruction();
    public static final InstructionDefinition REACHZ = new ReachZeroInstruction();
    public static final InstructionDefinition RETURN = new ReturnInstruction();

    // Binary math
    public static final InstructionDefinition ANDC = new BitwiseAndConstantInstruction();
    public static final InstructionDefinition AND = new BitwiseAndInstruction();
    public static final InstructionDefinition NOT = new BitwiseNotInstruction();
    public static final InstructionDefinition ORC = new BitwiseOrConstantInstruction();
    public static final InstructionDefinition OR = new BitwiseOrInstruction();
    public static final InstructionDefinition XORC = new BitwiseXorConstantInstruction();
    public static final InstructionDefinition XOR = new BitwiseXorInstruction();

    // Math
    public static final InstructionDefinition ADDC = new AddConstantInstruction();
    public static final InstructionDefinition ADD = new AddInstruction();
    public static final InstructionDefinition DIVC = new DivideConstantInstruction();
    public static final InstructionDefinition DIV = new DivideInstruction();
    public static final InstructionDefinition MULTC = new MultiplyConstantInstruction();
    public static final InstructionDefinition MULT = new MultiplyInstruction();
    public static final InstructionDefinition SUBC = new SubtractConstantInstruction();
    public static final InstructionDefinition SUB = new SubtractInstruction();

    // Stack stuff
    public static final InstructionDefinition POP = new PopInstruction();
    public static final InstructionDefinition PUSHC = new PushConstantInstruction();
    public static final InstructionDefinition PUSH = new PushInstruction();

    // Generic or utils
    public static final InstructionDefinition NULL = new NullInstruction();
    public static final InstructionDefinition HALT = new HaltInstruction();

    public static InstructionDefinition getByName(String name) throws RegistryException {
        for (InstructionDefinition instruction : INSTRUCTIONS) {
            if (instruction.getName().equals(name)) {
                return instruction;
            }
        }

        throw new RegistryException(String.format("Instruction with name \"%s\" does not exist.", name));
    }
}
