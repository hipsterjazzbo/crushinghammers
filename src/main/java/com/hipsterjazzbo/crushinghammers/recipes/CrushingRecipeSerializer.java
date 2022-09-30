package com.hipsterjazzbo.crushinghammers.recipes;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CrushingRecipeSerializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<CrushingRecipe> {

    @Override
    public CrushingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
        return null;
    }

    @Nullable
    @Override
    public CrushingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        return null;
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, CrushingRecipe pRecipe) {

    }
}
