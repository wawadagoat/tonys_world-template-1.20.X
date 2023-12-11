package net.tony.tonys_world.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if (!context.getWorld().isClient) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));
                if (valuableblock(state)) {

                    outputMessage(positionClicked.down(i), player, state.getBlock());
                    foundBlock = true;

                    break;
                }
            }

        }


        return ActionResult.SUCCESS;
    }

    private void outputMessage(BlockPos pos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("found" + block.asItem().getName().getString() + "at (" + pos.getX() + "," + pos.getY() + "," + pos.getZ()), false);
    }

    private boolean valuableblock(BlockState state) {
        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DEEPSLATE_IRON_ORE) || state.isOf(Blocks.DIAMOND_ORE) || state.isOf(Blocks.DEEPSLATE_DIAMOND_ORE);
    }
}
