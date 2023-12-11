package net.tony.tonys_world.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.tony.tonys_world.Tonys_world;

public class ModBlocks {

    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block RAW_RUBY_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block RUBY_ORE = new ExperienceDroppingBlock(UniformIntProvider.create(5, 9), AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM).requiresTool().strength(3.0f, 3.0f));
    public static final Block DEEPSLATE_RUBY_ORE = new ExperienceDroppingBlock(UniformIntProvider.create(5, 9), AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM).requiresTool().strength(3.5f, 3.5f));


    private static void registerBlockItem(Block block, String name) {
        Registry.register(Registries.BLOCK, new Identifier(Tonys_world.modId, name), block);
        Registry.register(Registries.ITEM, new Identifier(Tonys_world.modId, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Tonys_world.LOGGER.info("Registering mod blocks for" + Tonys_world.modId);
        registerBlockItem(RUBY_BLOCK, "ruby_block");
        registerBlockItem(RAW_RUBY_BLOCK, "raw_ruby_block");
        registerBlockItem(RUBY_ORE, "ruby_ore");
        registerBlockItem(DEEPSLATE_RUBY_ORE, "deepslate_ruby_ore");
    }
}
