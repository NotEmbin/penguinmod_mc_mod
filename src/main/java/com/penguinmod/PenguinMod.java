package com.penguinmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.penguinmod.ConvertNamespace;

public class PenguinMod implements ModInitializer {
	public static final String MOD_ID = "penguinmod";
	static ConvertNamespace cn = new ConvertNamespace();

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public class PMBlocks {
		public static Block register(Block block, String name, boolean should_register_item) {
			Identifier id = cn.convertNamespace(name);
			if (should_register_item) {
				BlockItem blockItem = new BlockItem(block, new Item.Settings());
				Registry.register(Registries.ITEM, id, blockItem);
			}

			return Registry.register(Registries.BLOCK, id, block);
		}

		public static final Block JOE_BLOCK = register(new Block(AbstractBlock.Settings.create()), "joe_block", true);

		public static void init() {
		}
	}

	public final class PMItems {
		private PMItems() {}

		public static final Item STINKY_ITEM = register("stinky_item", new Item(new Item.Settings()));

		public static <T extends Item> T register(String path, T item) {
			return Registry.register(Registries.ITEM, cn.convertNamespace(path), item);
		}

		public static void init() {
		}
	}

	public final class PMItemGroups {
		public static final ItemGroup PM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(PMItems.STINKY_ITEM))
			.displayName(Text.translatable("itemGroup.penguinmod.pm_group"))
			.entries((context, entries) -> {
				entries.add(PMItems.STINKY_ITEM);
				entries.add(PMBlocks.JOE_BLOCK);
			})
			.build();

		public static void init() {
			Registry.register(Registries.ITEM_GROUP, Identifier.of("penguinmod","pm_group"), PM_GROUP);
		}
	}

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		PMBlocks.init();
		PMItems.init();
		PMItemGroups.init();

		/*
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
			content.add(PMItems.STINKY_ITEM);
		});
		*/

		LOGGER.info("Hello Fabric world!");
	}
}