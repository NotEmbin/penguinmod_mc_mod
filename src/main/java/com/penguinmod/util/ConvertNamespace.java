package com.penguinmod.util;

import com.penguinmod.PenguinMod;
import net.minecraft.util.Identifier;

public class ConvertNamespace {
    public Identifier convertNamespace(String namespace) {
        String[] splitted = namespace.split(":");
        if (splitted.length == 1) {
            return Identifier.of(PenguinMod.MOD_ID, namespace);
        }
        return Identifier.of(splitted[0],splitted[1]);
    }
}
