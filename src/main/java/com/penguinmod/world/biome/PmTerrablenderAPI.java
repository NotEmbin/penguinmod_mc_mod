package com.penguinmod.world.biome;

import com.penguinmod.PenguinMod;
import com.penguinmod.util.ConvertNamespace;
import net.minecraft.util.Identifier;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class PmTerrablenderAPI implements TerraBlenderApi {
    static ConvertNamespace cn = new ConvertNamespace();
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new PmRegions(cn.convertNamespace("penguinmod:overworld"), RegionType.OVERWORLD, 4));
    }
}
