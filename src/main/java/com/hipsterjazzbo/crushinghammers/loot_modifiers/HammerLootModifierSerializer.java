package com.hipsterjazzbo.crushinghammers.loot_modifiers;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;

public class HammerLootModifierSerializer extends GlobalLootModifierSerializer<HammerLootModifier> {
    @Override
    public HammerLootModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] conditions) {
        return new HammerLootModifier(conditions);
    }

    @Override
    public JsonObject write(HammerLootModifier instance) {
        return makeConditions(instance.conditionsIn);
    }
}
