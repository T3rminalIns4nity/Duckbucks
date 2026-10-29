package code.ins4nity.too.many.packages.duckbucks.items;

import code.ins4nity.too.many.packages.duckbucks.Duckbucks;
import code.ins4nity.too.many.packages.duckbucks.items.ducktokens.GenericDuckbuckItem;
import code.ins4nity.too.many.packages.duckbucks.items.wallet.WalletItem;
import code.ins4nity.too.many.packages.duckbucks.util.ModConfig;
import code.ins4nity.too.many.packages.duckbucks.items.duckbucks.*;
import code.ins4nity.too.many.packages.duckbucks.items.ducktokens.AmethystDuckbuckItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Duckbucks.MOD_ID);


    // Duckbucks
    public static final DeferredHolder<Item, CopperDuckbuckItem> COPPER_DUCKBUCK = ITEMS.register("copper_duckbuck",
            () -> new CopperDuckbuckItem(new Item.Properties().food(ModFoodProperties.COPPER_DUCKBUCK).fireResistant()));

    public static final DeferredHolder<Item, IronDuckbuckItem> IRON_DUCKBUCK = ITEMS.register("iron_duckbuck",
            () -> new IronDuckbuckItem(new Item.Properties().food(ModFoodProperties.IRON_DUCKBUCK).fireResistant()));

    public static final DeferredHolder<Item, GoldDuckbuckItem> GOLD_DUCKBUCK = ITEMS.register("gold_duckbuck",
            () -> new GoldDuckbuckItem(new Item.Properties().food(ModFoodProperties.GOLD_DUCKBUCK).fireResistant()));

    public static final DeferredHolder<Item, DiamondDuckbuckItem> DIAMOND_DUCKBUCK = ITEMS.register("diamond_duckbuck",
            () -> new DiamondDuckbuckItem(new Item.Properties().food(ModFoodProperties.DIAMOND_DUCKBUCK).fireResistant()));

    public static final DeferredHolder<Item, ? extends Item> NETHERITE_DUCKBUCK = ITEMS.register("netherite_duckbuck",
            () -> ModConfig.enableNetheriteDuckbuck.get()
                    ? new NetheriteDuckbuckItem(new Item.Properties().food(ModFoodProperties.NETHERITE_DUCKBUCK).fireResistant())
                    : new Item(new Item.Properties().stacksTo(0)));

    public static final DeferredHolder<Item, EmeraldDuckbuckItem> EMERALD_DUCKBUCK = ITEMS.register("emerald_duckbuck",
            () -> new EmeraldDuckbuckItem(new Item.Properties().food(ModFoodProperties.EMERALD_DUCKBUCK).fireResistant()));


    // Ducktokens
    public static final DeferredHolder<Item, AmethystDuckbuckItem> AMETHYST_DUCKBUCK = ITEMS.register("amethyst_duckbuck",
            () -> new AmethystDuckbuckItem(new Item.Properties().food(ModFoodProperties.AMETHYST_DUCKBUCK).fireResistant()));

    public static final DeferredHolder<Item, GenericDuckbuckItem> FLINT_DUCKBUCK = ITEMS.register("flint_duckbuck",
            () -> new GenericDuckbuckItem(new Item.Properties().food(ModFoodProperties.FLINT_DUCKBUCK).fireResistant()));

    public static final DeferredHolder<Item, GenericDuckbuckItem> LAPIS_DUCKBUCK = ITEMS.register("lapis_duckbuck",
            () -> new GenericDuckbuckItem(new Item.Properties().food(ModFoodProperties.LAPIS_DUCKBUCK).fireResistant()));

    public static final DeferredHolder<Item, GenericDuckbuckItem> PRISMARINE_DUCKBUCK = ITEMS.register("prismarine_duckbuck",
            () -> new GenericDuckbuckItem(new Item.Properties().food(ModFoodProperties.PRISMARINE_DUCKBUCK).fireResistant()));

    public static final DeferredHolder<Item, GenericDuckbuckItem> QUARTZ_DUCKBUCK = ITEMS.register("quartz_duckbuck",
            () -> new GenericDuckbuckItem(new Item.Properties().food(ModFoodProperties.QUARTZ_DUCKBUCK).fireResistant()));

    public static final DeferredHolder<Item, GenericDuckbuckItem> REDSTONE_DUCKBUCK = ITEMS.register("redstone_duckbuck",
            () -> new GenericDuckbuckItem(new Item.Properties().food(ModFoodProperties.REDSTONE_DUCKBUCK).fireResistant()));


    // Wallet
    public static final DeferredHolder<Item, WalletItem> WALLET = ITEMS.register("wallet",
            () -> new WalletItem(new Item.Properties().stacksTo(1).fireResistant()));
}
