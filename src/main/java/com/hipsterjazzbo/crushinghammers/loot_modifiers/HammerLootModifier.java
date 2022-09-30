package com.hipsterjazzbo.crushinghammers.loot_modifiers;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
//        CrushingHammers.LOGGER.debug(generatedLoot);

        return generatedLoot;
    }
}
