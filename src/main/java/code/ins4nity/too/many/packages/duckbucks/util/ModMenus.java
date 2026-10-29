package code.ins4nity.too.many.packages.duckbucks.util;

import code.ins4nity.too.many.packages.duckbucks.Duckbucks;
import code.ins4nity.too.many.packages.duckbucks.items.wallet.WalletMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, Duckbucks.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<WalletMenu>> WALLET_MENU =
            MENUS.register("wallet_menu", () -> IMenuTypeExtension.create(WalletMenu::new));
}
