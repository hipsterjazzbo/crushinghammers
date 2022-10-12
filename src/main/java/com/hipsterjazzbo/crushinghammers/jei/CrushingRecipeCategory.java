package com.hipsterjazzbo.crushinghammers.jei;

import com.hipsterjazzbo.crushinghammers.CrushingHammers;
import com.hipsterjazzbo.crushinghammers.recipes.CrushingRecipe;
import com.hipsterjazzbo.crushinghammers.register.Items;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CrushingRecipeCategory implements IRecipeCategory<CrushingRecipe> {

    private TranslatableComponent title;
    private final IDrawable background;
    private final IDrawable icon;
    public static ResourceLocation UID = new ResourceLocation(CrushingHammers.MODID, "crushing");

    public CrushingRecipeCategory(IGuiHelper guiHelper) {
        title = new TranslatableComponent("crushinghammers.jeititle");
        background = guiHelper.createBlankDrawable(96, 44);
        icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Items.HAMMER_DIAMOND.get()));
    }

    @Override
    public @NotNull Component getTitle() {
        return title;
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return icon;
    }

    @Override
    public @NotNull ResourceLocation getUid() {
        return UID;
    }

    @Override
    public @NotNull Class<? extends CrushingRecipe> getRecipeClass() {
        return CrushingRecipe.class;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull CrushingRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 9)
                .addItemStack(new ItemStack(recipe.getItem()));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 9)
                .addItemStack(recipe.getResultItem());
    }
}
