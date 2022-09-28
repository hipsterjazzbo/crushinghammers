package hipsterjazzbo.crushinghammers;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nonnull;

public class CrushingHammersTags {
    @Nonnull
    public static final TagKey<Block> MINEABLE_WITH_HAMMER =
            BlockTags.create(new ResourceLocation("crushinghammers:mineable/hammer"));
}
