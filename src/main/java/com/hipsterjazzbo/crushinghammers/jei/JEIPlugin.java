package com.hipsterjazzbo.crushinghammers.jei;

import com.hipsterjazzbo.crushinghammers.CrushingHammers;
import com.hipsterjazzbo.crushinghammers.recipes.CrushingRecipe;
import com.hipsterjazzbo.crushinghammers.register.RecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(CrushingHammers.MODID, "main");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(
                new CrushingRecipeCategory(registry.getJeiHelpers().getGuiHelper())
        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registry) {
        List<CrushingRecipe> recipes = Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(RecipeTypes.CRUSHING_RECIPE_TYPE.get());

        registry.addRecipes(recipes, CrushingRecipeCategory.UID);
    }
}
