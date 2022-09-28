package hipsterjazzbo.crushinghammers;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class HammerBaseItem extends DiggerItem {
    public HammerBaseItem(@Nonnull final Tier tier, final int maxDamage) {
        super(0.5F, 0.5F, tier, CrushingHammersTags.MINEABLE_WITH_HAMMER,
                new Item.Properties().defaultDurability(maxDamage));
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction);
    }

    @Override
    public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
        if (!world.isClientSide && blockstate.getDestroySpeed(world, pos) != 0.0F) {
            itemstack.hurtAndBreak(1, entity, (onBroken) -> {
                onBroken.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    @Override
    public int getBurnTime(@Nonnull final ItemStack itemStack, @Nullable final RecipeType<?> recipeType) {
        if (itemStack.getItem() == CrushingHammers.HAMMER_WOOD.get()) {
            return 200;
        } else {
            return 0;
        }
    }
}
