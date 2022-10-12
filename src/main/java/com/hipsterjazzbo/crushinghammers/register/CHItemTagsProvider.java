package com.hipsterjazzbo.crushinghammers.register;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CHItemTagsProvider extends ItemTagsProvider {
    public CHItemTagsProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(Tags.HAMMER).add(
                Items.HAMMER_WOOD.get(),
                Items.HAMMER_STONE.get(),
                Items.HAMMER_IRON.get(),
                Items.HAMMER_GOLD.get(),
                Items.HAMMER_DIAMOND.get(),
                Items.HAMMER_NETHERITE.get());
    }

    @Override
    public @NotNull String getName() {
        return "CH Tags Provider";
    }
}
