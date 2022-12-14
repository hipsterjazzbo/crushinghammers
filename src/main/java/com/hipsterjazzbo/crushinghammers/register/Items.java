package com.hipsterjazzbo.crushinghammers.register;

import com.hipsterjazzbo.crushinghammers.CrushingHammers;
import com.hipsterjazzbo.crushinghammers.HammerBaseItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;

public class Items {
    @Nonnull
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CrushingHammers.MODID);

    public static final RegistryObject<HammerBaseItem> HAMMER_WOOD = ITEMS.register("wooden_hammer", () -> new HammerBaseItem(Tiers.WOOD, 128));
    public static final RegistryObject<HammerBaseItem> HAMMER_STONE = ITEMS.register("stone_hammer", () -> new HammerBaseItem(Tiers.STONE, 256));
    public static final RegistryObject<HammerBaseItem> HAMMER_IRON = ITEMS.register("iron_hammer", () -> new HammerBaseItem(Tiers.IRON, 512));
    public static final RegistryObject<HammerBaseItem> HAMMER_GOLD = ITEMS.register("golden_hammer", () -> new HammerBaseItem(Tiers.GOLD, 64));
    public static final RegistryObject<HammerBaseItem> HAMMER_DIAMOND = ITEMS.register("diamond_hammer", () -> new HammerBaseItem(Tiers.DIAMOND, 4096));
    public static final RegistryObject<HammerBaseItem> HAMMER_NETHERITE = ITEMS.register("netherite_hammer", () -> new HammerBaseItem(Tiers.NETHERITE, 8192));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
