package com.hipsterjazzbo.crushinghammers;

import com.hipsterjazzbo.crushinghammers.register.Items;
import com.hipsterjazzbo.crushinghammers.register.Tags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.RecipeType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class HammerBaseItem extends DiggerItem {
    public HammerBaseItem(@Nonnull final Tier tier, final int maxDamage) {
        super(0.5F,
                0.5F,
                tier,
                Tags.MINEABLE_WITH_HAMMER,
                new Item.Properties().defaultDurability(maxDamage));
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
