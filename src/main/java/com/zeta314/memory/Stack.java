package com.zeta314.memory;

import com.zeta314.exceptions.memory.StackException;
import com.zeta314.memory.base.Memory;
import com.zeta314.memory.base.Register;
import com.zeta314.util.IntegerUtils;
import org.apache.commons.lang3.ArrayUtils;

public class Stack {
    private final Register stackPointer;
    private final Memory memory;

    public Stack(int size, Register stackPointer, int fillValue) {
        memory = new Memory(size, fillValue);
        this.stackPointer = stackPointer;
        stackPointer.setValue(size - 1);
    }

    public Stack(int size, Register stackPointer) {
        this(size, stackPointer, 0);
    }

    public void push(int value) {
        if (stackPointer.getValue() - Memory.BLOCK_SIZE < 0) {
            throw new StackException("Stack maximum size exceeded.");
        }

        for (byte piece : IntegerUtils.toByteArray(value)) {
            memory.set(stackPointer.getValue(), piece);
            stackPointer.decrement(1);
        }
    }

    public int pop() {
        if (stackPointer.getValue() + Memory.BLOCK_SIZE >= memory.getSize()) {
            throw new StackException("There's no value to pop from the stack.");
        }

        byte[] data = new byte[Memory.BLOCK_SIZE];
        for (int i = 0; i < Memory.BLOCK_SIZE; i++) {
            stackPointer.increment(1);
            data[i] = memory.get(stackPointer.getValue());
        }

        return IntegerUtils.fromByteArray(data);
    }

    public int getSize() {
        return memory.getSize();
    }

    public byte[] dump() {
        byte[] dump = memory.dump();
        ArrayUtils.reverse(dump);
        return dump;
    }
}
