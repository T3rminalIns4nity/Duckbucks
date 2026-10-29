package code.ins4nity.too.many.packages.duckbucks.items.wallet;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class WalletItem extends Item {
    public WalletItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND && player instanceof ServerPlayer serverPlayer) {
            serverPlayer.openMenu(new SimpleMenuProvider(
                    (id, playerInventory, p) -> new WalletMenu(id, playerInventory, new WalletContainer(itemStack)),
                    Component.translatable("item.duckbucks.wallet")
            ));

            return InteractionResultHolder.consume(itemStack);
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> component, TooltipFlag tooltipFlag) {
        Component line1 = Component.translatable(
                "tooltip.duckbucks.wallet",
                Component.keybind("key.use")
        );

        Component line2 = Component.translatable("tooltip.duckbucks.wallet_storable");

        if (Screen.hasShiftDown()) {
            component.add(Component.translatable("tooltip.duckbucks.wallet_active"));
            component.add(line1);
            component.add(line2);
        } else {
            component.add(Component.translatable("tooltip.duckbucks.wallet_inactive"));
        }
    }
}
