package com.hipsterjazzbo.crushinghammers;

import com.hipsterjazzbo.crushinghammers.loot_modifiers.HammerLootModifier;
import com.hipsterjazzbo.crushinghammers.loot_modifiers.HammerLootModifierSerializer;
import com.hipsterjazzbo.crushinghammers.recipes.CrushingRecipe;
import com.hipsterjazzbo.crushinghammers.register.*;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.CanToolPerformAction;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CrushingHammers.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CrushingHammers {
    public static final String MODID = "crushinghammers";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static IEventBus modEventBus;


    private static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, MODID);

    private static final RegistryObject<HammerLootModifierSerializer> CRUSHING = GLM.register("crushing", HammerLootModifierSerializer::new);

    public CrushingHammers() {
        modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Items.register(modEventBus);
        RecipeTypes.register(modEventBus);
        RecipeSerializers.register(modEventBus);

        GLM.register(modEventBus);
    }

    private static class DataProvider extends GlobalLootModifierProvider {
        public DataProvider(DataGenerator gen, String modid) {
            super(gen, modid);
        }

        @Override
        protected void start() {
            add("crushing", CRUSHING.get(), new HammerLootModifier(
                    new LootItemCondition[]{
                            MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.HAMMER)).build(),
                            CanToolPerformAction.canToolPerformAction(HammerBaseItem.HAMMER_CRUSH).build()
                    })
            );
        }
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();

        event.getGenerator().addProvider(new DataProvider(gen, MODID));

        if (event.includeServer()) {
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
            BlockTagsProvider blockTags = new CHBlockTagsProvider(gen, MODID, existingFileHelper);
            gen.addProvider(blockTags);
            gen.addProvider(new CHItemTagsProvider(gen, blockTags, MODID, existingFileHelper));
        }
    }
}
