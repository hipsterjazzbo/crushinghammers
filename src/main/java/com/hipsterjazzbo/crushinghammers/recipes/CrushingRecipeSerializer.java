package com.hipsterjazzbo.crushinghammers.recipes;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CrushingRecipeSerializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<CrushingRecipe> {

    @Override
    public @NotNull CrushingRecipe fromJson(@NotNull ResourceLocation pRecipeId, @NotNull JsonObject pSerializedRecipe) {
        JsonObject result = pSerializedRecipe.getAsJsonObject("result");

        ItemStack itemStack = CraftingHelper.getItemStack(result, true);

        return new CrushingRecipe(pRecipeId, itemStack);
    }

    @Nullable
    @Override
    public CrushingRecipe fromNetwork(@NotNull ResourceLocation pRecipeId, @NotNull FriendlyByteBuf pBuffer) {
        return null;
    }

    @Override
    public void toNetwork(@NotNull FriendlyByteBuf pBuffer, @NotNull CrushingRecipe pRecipe) {

    }
}
