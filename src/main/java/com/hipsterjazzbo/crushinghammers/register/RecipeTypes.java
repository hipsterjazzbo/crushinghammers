package com.hipsterjazzbo.crushinghammers.register;

import com.hipsterjazzbo.crushinghammers.CrushingHammers;
import com.hipsterjazzbo.crushinghammers.recipes.CrushingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class RecipeTypes {
    private static final DeferredRegister<RecipeType<?>> TYPE_REGISTER = DeferredRegister.create(Registry.RECIPE_TYPE_REGISTRY, CrushingHammers.MODID);

    public static final RegistryObject<RecipeType<CrushingRecipe>> CRUSHING_RECIPE_TYPE = TYPE_REGISTER.register("crushing", () -> new RecipeType<>() {});

    public static void register(IEventBus modEventBus) {
        TYPE_REGISTER.register(modEventBus);
    }
}
