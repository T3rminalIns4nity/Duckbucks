package code.ins4nity.too.many.packages.duckbucks.items;

import code.ins4nity.too.many.packages.duckbucks.Duckbucks;
import code.ins4nity.too.many.packages.duckbucks.util.ModConfig;
import code.ins4nity.too.many.packages.duckbucks.items.duckbucks.NetheriteDuckbuckItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Duckbucks.MOD_ID);

    public static final Supplier<CreativeModeTab> DUCKBUCKS_TAB = CREATIVE_MODE_TABS.register("duckbucks_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativetab.duckbucks_tab"))
            .icon(() -> new ItemStack(ModItems.COPPER_DUCKBUCK.get()))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.WALLET.get());
                output.accept(ModItems.COPPER_DUCKBUCK.get());
                output.accept(ModItems.IRON_DUCKBUCK.get());
                output.accept(ModItems.GOLD_DUCKBUCK.get());
                output.accept(ModItems.DIAMOND_DUCKBUCK.get());
                if (ModConfig.enableNetheriteDuckbuck.get() && ModItems.NETHERITE_DUCKBUCK.get() instanceof NetheriteDuckbuckItem) {
                    output.accept(ModItems.NETHERITE_DUCKBUCK.get());
                }
                output.accept(ModItems.EMERALD_DUCKBUCK.get());
                output.accept(ModItems.AMETHYST_DUCKBUCK.get());
                output.accept(ModItems.FLINT_DUCKBUCK.get());
                output.accept(ModItems.LAPIS_DUCKBUCK.get());
                output.accept(ModItems.PRISMARINE_DUCKBUCK.get());
                output.accept(ModItems.QUARTZ_DUCKBUCK.get());
                output.accept(ModItems.REDSTONE_DUCKBUCK.get());
            })
            .build()
    );
}
