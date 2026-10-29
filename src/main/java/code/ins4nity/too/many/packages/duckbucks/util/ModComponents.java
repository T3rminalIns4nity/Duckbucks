package code.ins4nity.too.many.packages.duckbucks.util;

import code.ins4nity.too.many.packages.duckbucks.Duckbucks;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModComponents {
    public static final DeferredRegister<DataComponentType<?>> COMPONENTS =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, Duckbucks.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<ItemStack>>> WALLET_CONTENTS =
            COMPONENTS.register("wallet_contents", () -> DataComponentType.<List<ItemStack>>builder()
                    .persistent(Codec.list(ItemStack.OPTIONAL_CODEC))
                    .build());
}
