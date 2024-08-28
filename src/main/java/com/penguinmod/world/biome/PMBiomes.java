package com.penguinmod.world.biome;

import com.penguinmod.util.ConvertNamespace;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;

public class PMBiomes {
    static ConvertNamespace cn = new ConvertNamespace();
    public static final RegistryKey<Biome> DDEDEDODEDIAMANTE_PLAINS = register("ddededodediamante_plains");

    public static RegistryKey<Biome> register(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, cn.convertNamespace(name));
    }
}
