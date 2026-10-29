package code.ins4nity.too.many.packages.duckbucks.util;

import code.ins4nity.too.many.packages.duckbucks.Duckbucks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static final TagKey<Item> WALLET_STORABLE = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(Duckbucks.MOD_ID, "wallet_storable")
    );
}
