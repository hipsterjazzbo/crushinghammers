package com.hipsterjazzbo.crushinghammers.loot_modifiers;

import com.hipsterjazzbo.crushinghammers.recipes.CrushingRecipe;
import com.hipsterjazzbo.crushinghammers.register.RecipeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public class HammerLootModifier extends LootModifier {
    public LootItemCondition[] conditionsIn;

    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    public HammerLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);

        this.conditionsIn = conditionsIn;
    }

    @NotNull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        BlockState blockState = context.getParam(LootContextParams.BLOCK_STATE);
        ServerLevel level = context.getLevel();
        ItemStackHandler itemStackHandler = new ItemStackHandler();

        itemStackHandler.insertItem(0, new ItemStack(blockState.getBlock()), false);

        RecipeWrapper recipeWrapper = new RecipeWrapper(itemStackHandler);

        Optional<CrushingRecipe> crushingRecipe = level.getRecipeManager().getRecipeFor(RecipeTypes.CRUSHING_RECIPE_TYPE.get(), recipeWrapper, level);

        crushingRecipe.ifPresent(foundRecipe -> {
            generatedLoot.clear();
            generatedLoot.add(foundRecipe.getResultItem());
        });

        return generatedLoot;
    }
}
