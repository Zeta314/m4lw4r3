package com.zeta314.memory.base;

import com.zeta314.exceptions.general.SizeException;
import com.zeta314.exceptions.memory.MemoryException;
import com.zeta314.util.IntegerUtils;

import java.util.Arrays;

public class Memory {
    public final static int BLOCK_SIZE = 4;
    private final byte[] rawData;

    public Memory(int size, int filler) {
        if (size % BLOCK_SIZE != 0) {
            throw new SizeException("Memory size needs to be a multiple of 8.");
        }

        rawData = new byte[size];
        Arrays.fill(rawData, (byte) filler);
    }

    public Memory(int size) {
        this(size, 0);
    }

    public void set(int address, byte value) {
        if (address > rawData.length || address < 0) {
            throw new MemoryException("The provided address is out of bounds.");
        }

        rawData[address] = value;
    }

    public byte get(int address) {
        if (address > rawData.length || address < 0) {
            throw new MemoryException("The provided address is out of bounds.");
        }

        return rawData[address];
    }

    public void setInteger(int address, int value) {
        int i = 0;
        for (byte piece : IntegerUtils.toByteArray(value)) {
            rawData[i] = piece;
            i++;
        }
    }

    public int getInteger(int address) {
        byte[] data = new byte[Memory.BLOCK_SIZE];
        for (int i = 0; i < Memory.BLOCK_SIZE; i++) {
            data[i] = rawData[address + i];
        }

        return IntegerUtils.fromByteArray(data);
    }

    public int getSize() {
        return rawData.length;
    }

    public byte[] dump() {
        return rawData.clone();
    }
}
