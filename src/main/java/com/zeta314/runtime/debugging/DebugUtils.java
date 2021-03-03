package com.zeta314.runtime.debugging;

import com.zeta314.memory.base.Register;
import com.zeta314.runtime.base.Label;
import com.zeta314.runtime.environment.Labels;
import com.zeta314.runtime.environment.Memories;
import com.zeta314.runtime.environment.Registers;

public class DebugUtils {
    public static int MEMORY_DUMP_LINE_COUNT = 32;

    public static void dumpRegisters() {
        System.out.println("Registers:");
        for (Register register : Registers.REGISTERS) {
            System.out.printf(" - %s\t0x%08x (%d)\n", register.getName(), register.getValue(), register.getValue());
        }
    }

    public static void dumpLabels() {
        System.out.println("Labels:");
        int max_label_size = 15;
        for (Label label : Labels.LABELS) {
            if (label.getName().length() > max_label_size) {
                max_label_size = label.getName().length();
            }
        }
        max_label_size += 5;

        for (Label label : Labels.LABELS) {
            System.out.printf(" - %-" + max_label_size + "s0x%08x (%d)\n", label.getName(), label.getAddress(), label.getAddress());
        }
    }

    public static void dumpMemory() {
        System.out.println("Memory:");

        byte[] dump = Memories.MEMORY.dump();
        for (int i = 0; i < dump.length; i++) {
            System.out.printf("%02x ", dump[i]);

            if ((i + 1) % MEMORY_DUMP_LINE_COUNT == 0) {
                System.out.print("\n");
            }
        }
    }

    public static void dumpStack() {
        System.out.println("Stack:");

        byte[] dump = Memories.STACK.dump();
        for (int i = 0; i < dump.length; i++) {
            System.out.printf("%02x ", dump[i]);

            if ((i + 1) % MEMORY_DUMP_LINE_COUNT == 0) {
                System.out.print("\n");
            }
        }
    }

    public static void dumpEverything() {
        dumpRegisters();
        System.out.print("\n");
        dumpLabels();
        System.out.print("\n");
        dumpMemory();
        System.out.print("\n");
        dumpStack();
    }
}
