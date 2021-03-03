package com.zeta314.runtime.base;

import com.zeta314.runtime.environment.Labels;

public class Label {
    private final String name;
    private final int address;

    public Label(String name, int address, boolean autoRegister) {
        this.name = name;
        this.address = address;

        if (autoRegister)
            Labels.LABELS.add(this);
    }

    public Label(String name, int address) {
        this(name, address, false);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Label)) {
            return false;
        }

        Label other = (Label) obj;
        return other.name.equals(name);
    }

    public String getName() {
        return name;
    }

    public int getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("Label(name=\"%s\", address=0x%04x)", name, address);
    }
}
