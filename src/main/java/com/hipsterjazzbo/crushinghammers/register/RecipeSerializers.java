package com.hipsterjazzbo.crushinghammers.register;

import com.hipsterjazzbo.crushinghammers.CrushingHammers;
import com.hipsterjazzbo.crushinghammers.recipes.CrushingRecipeSerializer;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class RecipeSerializers {
    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER_REGISTER =
            DeferredRegister.create(Registry.RECIPE_SERIALIZER_REGISTRY, CrushingHammers.MODID);

    public static final RegistryObject<CrushingRecipeSerializer> CRUSHING_RECIPE_SERIALIZER =
            RECIPE_SERIALIZER_REGISTER.register("crushing", CrushingRecipeSerializer::new);

    public static void register(IEventBus modEventBus) {
        RECIPE_SERIALIZER_REGISTER.register(modEventBus);
    }
}
