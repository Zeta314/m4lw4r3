package com.zeta314.runtime.environment;

import com.zeta314.exceptions.general.RegistryException;
import com.zeta314.runtime.base.Label;

import java.util.ArrayList;
import java.util.List;

public class Labels {
    public static final List<Label> LABELS = new ArrayList<>();

    public static final Label SCRIPT_START = new Label("SCRIPT_START", -1, true);

    public static void register(Label label) throws RegistryException {
        if (LABELS.contains(label)) {
            throw new RegistryException(String.format("Label \"%s\" is already registered.", label.getName()));
        }

        LABELS.add(label);
    }

    public static Label getByName(String name) throws RegistryException {
        for (Label label : LABELS) {
            if (label.getName().equals(name)) {
                return label;
            }
        }

        throw new RegistryException(String.format("Label \"%s\" is not registered.", name));
    }
}
