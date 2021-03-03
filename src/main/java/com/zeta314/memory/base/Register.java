package com.zeta314.memory.base;

import com.zeta314.runtime.environment.Registers;
import com.zeta314.util.IntegerUtils;

public class Register {
    private final String name;
    private int value;

    public Register(String name, int initialValue) {
        this.name = name;
        this.value = initialValue;

        Registers.REGISTERS.add(this);
    }

    public Register(String name) {
        this(name, 0);
    }

    public void increment(int amount) {
        this.value += amount;
    }

    public void decrement(int amount) {
        this.value -= amount;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public byte[] getBytes() {
        return IntegerUtils.toByteArray(value);
    }

    @Override
    public String toString() {
        return String.format("Register(name=\"%s\", value=%d)", name, value);
    }
}
