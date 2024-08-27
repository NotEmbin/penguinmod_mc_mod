package com.penguinmod;

import com.mojang.serialization.JsonOps;
import com.penguinmod.util.ConvertNamespace;
import com.penguinmod.util.Tags;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.command.EntityDataObject;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.entity.decoration.painting.PaintingVariants;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.predicate.item.CustomDataPredicate;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryOps;
import net.minecraft.registry.tag.TagBuilder;
import net.minecraft.registry.tag.TagEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.text.TextCodecs;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		public static final Block DDEDEDODEDIAMANTE_BLOCK = register(new Block(AbstractBlock.Settings.create()), "ddededodediamante_block", true);
		public static final Block PUZZLINGGGG_BLOCK = register(new Block(AbstractBlock.Settings.create()), "puzzlingggg_block", true);
		public static final Block JEREMYGAMER13_BLOCK = register(new Block(AbstractBlock.Settings.create()), "jeremygamer13_block", true);
		public static final Block IANYOURGOD_BLOCK = register(new Block(AbstractBlock.Settings.create()), "ianyourgod_block", true);
		public static final Block GODSLAYERAKP_BLOCK = register(new Block(AbstractBlock.Settings.create()), "godslayerakp_block", true);
		public static final Block EVIL_JOE_BLOCK = register(new Block(AbstractBlock.Settings.create()), "evil_joe_block", true);
		public static final Block EVIL_PUZZLINGGGG_BLOCK = register(new Block(AbstractBlock.Settings.create()), "evil_puzzlingggg_block", true);
		public static final Block ALPACALII_BLOCK = register(new Block(AbstractBlock.Settings.create()), "alpacalii_block", true);
		public static final Block SHARKPOOL_BLOCK = register(new Block(AbstractBlock.Settings.create()), "sharkpool_block", true);
		public static final Block CUBEY_BLOCK = register(new Block(AbstractBlock.Settings.create()), "cubey_block", true);
		public static final Block JOHN_FORTNITE_BLOCK = register(new Block(AbstractBlock.Settings.create()), "john_fortnite_block", true);
		public static final Block ELMOBEAR_BLOCK = register(new Block(AbstractBlock.Settings.create()), "elmobear_block", true);
		public static final Block FRESHPENGUIN112_BLOCK = register(new Block(AbstractBlock.Settings.create()), "freshpenguin112_block", true);
		public static final Block ANONYGOOSE_BLOCK = register(new Block(AbstractBlock.Settings.create()), "anonygoose_block", true);
		public static final Block JWKLONG_BLOCK = register(new Block(AbstractBlock.Settings.create()), "jwklong_block", true);
		public static final Block STEVE0GREATNESS_BLOCK = register(new Block(AbstractBlock.Settings.create()), "steve0greatness_block", true);
		public static final Block PENGUINBOT_BLOCK = register(new Block(AbstractBlock.Settings.create()), "penguinbot_block", true);
		public static final Block SHADOWV4ST_BLOCK = register(new Block(AbstractBlock.Settings.create()), "shadowv4st_block", true);
		public static final Block XENDYEX_BLOCK = register(new Block(AbstractBlock.Settings.create()), "xendyex_block", true);
		public static final Block TIM_SWEENEY_BLOCK = register(new Block(AbstractBlock.Settings.create()), "tim_sweeney_block", true);

		public static void init() {}
	}

	public final class PMItems {
		private PMItems() {}

		public static final Item STINKY_ITEM = register("stinky_item", new Item(new Item.Settings()));
		public static final Item TEST_ITEM = register("minecraft:test_item", new Item(new Item.Settings()));

		public static <T extends Item> T register(String path, T item) {
			return Registry.register(Registries.ITEM, cn.convertNamespace(path), item);
		}

		public static void init() {}
	}

	public final class PMItemGroups {
		public static void paintingVariants(
		) {
			//RegistryOps<TagKey> registryops = Registr
		}

		public static final ItemGroup PM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(PMItems.STINKY_ITEM))
			.displayName(Text.translatable("itemGroup.penguinmod"))
			.entries((context, entries) -> {
				entries.add(PMItems.STINKY_ITEM);
				entries.add(PMItems.TEST_ITEM);
				entries.add(PMBlocks.JOE_BLOCK);
				entries.add(PMBlocks.DDEDEDODEDIAMANTE_BLOCK);
				entries.add(PMBlocks.PUZZLINGGGG_BLOCK);
				entries.add(PMBlocks.JEREMYGAMER13_BLOCK);
				entries.add(PMBlocks.IANYOURGOD_BLOCK);
				entries.add(PMBlocks.GODSLAYERAKP_BLOCK);
				entries.add(PMBlocks.EVIL_JOE_BLOCK);
				entries.add(PMBlocks.EVIL_PUZZLINGGGG_BLOCK);
				entries.add(PMBlocks.ALPACALII_BLOCK);
				entries.add(PMBlocks.SHARKPOOL_BLOCK);
				entries.add(PMBlocks.CUBEY_BLOCK);
				entries.add(PMBlocks.JOHN_FORTNITE_BLOCK);
				entries.add(PMBlocks.ELMOBEAR_BLOCK);
				entries.add(PMBlocks.FRESHPENGUIN112_BLOCK);
				entries.add(PMBlocks.ANONYGOOSE_BLOCK);
				entries.add(PMBlocks.JWKLONG_BLOCK);
				entries.add(PMBlocks.STEVE0GREATNESS_BLOCK);
				entries.add(PMBlocks.PENGUINBOT_BLOCK);
				entries.add(PMBlocks.SHADOWV4ST_BLOCK);
				entries.add(PMBlocks.XENDYEX_BLOCK);
				entries.add(PMBlocks.TIM_SWEENEY_BLOCK);
				//entries.add(new ItemStack(Items.PAINTING).set(DataComponentTypes.ENTITY_DATA, NbtComponent.DEFAULT.apply(PaintingVariants.TIDES)));

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