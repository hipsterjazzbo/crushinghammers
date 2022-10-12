package com.hipsterjazzbo.crushinghammers.register;

import com.hipsterjazzbo.crushinghammers.CrushingHammers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nonnull;

public class Tags {
    @Nonnull
    public static final TagKey<Item> HAMMER = ItemTags.create(new ResourceLocation(CrushingHammers.MODID, "hammer"));
    @Nonnull
    public static final TagKey<Block> MINEABLE_WITH_HAMMER = BlockTags.create(new ResourceLocation(CrushingHammers.MODID, "mineable/hammer"));
}
