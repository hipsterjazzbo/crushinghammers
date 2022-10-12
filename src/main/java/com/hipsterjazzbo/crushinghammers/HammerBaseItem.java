package com.hipsterjazzbo.crushinghammers;

import com.hipsterjazzbo.crushinghammers.register.Items;
import com.hipsterjazzbo.crushinghammers.register.Tags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.ToolAction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class HammerBaseItem extends DiggerItem {
    public static ToolAction HAMMER_CRUSH = ToolAction.get("crushing");

    public HammerBaseItem(@Nonnull final Tier tier, final int maxDamage) {
        super(0.5F,
                0.5F,
                tier,
                Tags.MINEABLE_WITH_HAMMER,
                new Item.Properties().defaultDurability(maxDamage).tab(CreativeModeTab.TAB_TOOLS));
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return toolAction == HAMMER_CRUSH;
    }

    @Override
    public int getBurnTime(@Nonnull final ItemStack itemStack, @Nullable final RecipeType<?> recipeType) {
        if (itemStack.getItem() == Items.HAMMER_WOOD.get()) {
            return 200;
        } else {
            return 0;
        }
    }
}
