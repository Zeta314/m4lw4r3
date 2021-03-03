package com.zeta314.runtime.environment;

import com.zeta314.memory.Stack;
import com.zeta314.memory.base.Memory;

public class Memories {
    public static final int MEMORY_SIZE = 256;
    public static final int STACK_SIZE = 256;

    public static final Memory MEMORY = new Memory(MEMORY_SIZE, 0);
    public static final Stack STACK = new Stack(STACK_SIZE, Registers.STACK_POINTER, 0);
}
