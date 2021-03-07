package com.zeta314.runtime.environment;

import com.zeta314.exceptions.general.RegistryException;
import com.zeta314.memory.base.Register;

import java.util.ArrayList;
import java.util.List;

public class Registers {
    public static final List<Register> REGISTERS = new ArrayList<>();

    public static final Register R0 = new Register("R0", 0);
    public static final Register R1 = new Register("R1", 0);
    public static final Register R2 = new Register("R2", 0);
    public static final Register R3 = new Register("R3", 0);
    public static final Register R4 = new Register("R4", 0);
    public static final Register R5 = new Register("R5", 0);
    public static final Register R6 = new Register("R6", 0);

    public static final Register DEBUG_FLAG = new Register("DBG", 0);
    public static final Register HALT_FLAG = new Register("HLT", 0);
    public static final Register CARRY = new Register("CA", 0);
    public static final Register ZERO_FLAG = new Register("ZF", 0);

    public static final Register STACK_POINTER = new Register("SP", 0);
    public static final Register INSTRUCTION_POINTER = new Register("IP", 0);

    public static Register getByName(String name) throws RegistryException {
        for (Register register : REGISTERS) {
            if (register.getName().equals(name)) {
                return register;
            }
        }

        throw new RegistryException(String.format("Register \"%s\" does not exist.", name));
    }
}
