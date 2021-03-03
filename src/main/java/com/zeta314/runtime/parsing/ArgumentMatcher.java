package com.zeta314.runtime.parsing;

import com.zeta314.exceptions.general.RegistryException;
import com.zeta314.exceptions.runtime.ArgumentException;
import com.zeta314.memory.base.Register;
import com.zeta314.runtime.environment.Registers;

import java.lang.reflect.Type;

public class ArgumentMatcher {
    public static Object convertArgument(String argument, Type expectedType) throws ArgumentException,
            RegistryException, NumberFormatException {

        if (Integer.class.equals(expectedType)) {
            return Integer.decode(argument);
        } else if (String.class.equals(expectedType)) {
            return argument;
        } else if (Register.class.equals(expectedType)) {
            return Registers.getByName(argument);
        } else {
            throw new ArgumentException(String.format("Cannot convert argument to type \"%s\".",
                    expectedType.getTypeName()));
        }
    }
}
