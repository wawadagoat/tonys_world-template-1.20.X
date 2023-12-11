package net.tony.tonys_world;

import net.fabricmc.api.ModInitializer;
import net.tony.tonys_world.block.ModBlocks;
import net.tony.tonys_world.item.ModItemGroups;
import net.tony.tonys_world.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tonys_world implements ModInitializer {
    public static String modId = "tonys_world";
    public static final Logger LOGGER = LoggerFactory.getLogger(modId);

    @Override
    public void onInitialize() {

        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();

        ModBlocks.registerModBlocks();
    }
}