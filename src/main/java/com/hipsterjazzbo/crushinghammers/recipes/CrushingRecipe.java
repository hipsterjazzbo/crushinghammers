package com.hipsterjazzbo.crushinghammers.recipes;

import com.hipsterjazzbo.crushinghammers.register.RecipeSerializers;
import com.hipsterjazzbo.crushinghammers.register.RecipeTypes;
import com.hipsterjazzbo.crushinghammers.register.Tags;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public record CrushingRecipe(ResourceLocation id) implements Recipe<Container> {
    public boolean matches(Level world, BlockPos pos) {
        return world.getBlockState(pos).is(Tags.MINEABLE_WITH_HAMMER);
    }

    @Override
    public boolean matches(@NotNull Container inv, @NotNull Level world) {
        return false;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull Container inv) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    @Override
    public @NotNull ItemStack getResultItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return this.id;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return RecipeSerializers.CRUSHING_RECIPE_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return RecipeTypes.CRUSHING_RECIPE_TYPE.get();
    }
}
