package code.ins4nity.too.many.packages.duckbucks.items.wallet;

import code.ins4nity.too.many.packages.duckbucks.items.ModItems;
import code.ins4nity.too.many.packages.duckbucks.util.ModComponents;
import net.minecraft.ChatFormatting;
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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        int totalDuckBucks = calculateTotalDuckbucks(stack);

        List<ItemStack> contents = stack.getOrDefault(ModComponents.WALLET_CONTENTS.get(), List.of());

        Component walletBalance = Component.translatable("tooltip.duckbucks.wallet_balance")
                .append(Component.literal(String.valueOf(totalDuckBucks))).withStyle(ChatFormatting.GOLD)
                .append(Component.literal("DB").withStyle(ChatFormatting.GRAY));

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

        if (Screen.hasControlDown()) {
            if (Screen.hasAltDown()) {
                component.add(Component.translatable("tooltip.duckbucks.balance_ctrl_alt"));
                boolean empty = true;

                Map<Item, Integer> consolidatedMap = new LinkedHashMap<>();
                for (ItemStack internalStack : contents) {
                    if (!internalStack.isEmpty()) {
                        Item item = internalStack.getItem();
                        consolidatedMap.put(item, consolidatedMap.getOrDefault(item, 0) + internalStack.getCount());
                        empty = false;
                    }
                }

                List<Map.Entry<Item, Integer>> sortedEntries = new ArrayList<>(consolidatedMap.entrySet());
                sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

                for (Map.Entry<Item, Integer> entry : sortedEntries) {
                    ItemStack displayStack = new ItemStack(entry.getKey());
                    int totalCount = entry.getValue();

                    component.add(Component.literal("")
                            .append(displayStack.getHoverName()).withStyle(ChatFormatting.WHITE)
                            .append(Component.literal(" x" + totalCount).withStyle(ChatFormatting.GRAY)));
                }

                if (empty) {
                    component.add(Component.translatable("tooltip.duckbucks.wallet_empty"));
                }

            } else {
                component.add(Component.translatable("tooltip.duckbucks.balance_ctrl"));
                component.add(walletBalance);
            }
        } else {
            component.add(Component.translatable("tooltip.duckbucks.balance_inactive"));
        }
    }

    private int calculateTotalDuckbucks(ItemStack walletStack) {
        List<ItemStack> contents = walletStack.getOrDefault(ModComponents.WALLET_CONTENTS.get(), List.of());
        int total = 0;

        for (ItemStack itemStack : contents) {
            if (!itemStack.isEmpty()) {
                int valuePerItem = getDuckbuckValue(itemStack);
                total += (valuePerItem * itemStack.getCount());
            }
        }

        return total;
    }

    private int getDuckbuckValue(ItemStack itemStack) {
        Item item = itemStack.getItem();

        if (item == ModItems.COPPER_DUCKBUCK.get()) return 1;
        if (item == ModItems.IRON_DUCKBUCK.get()) return 4;
        if (item == ModItems.GOLD_DUCKBUCK.get()) return 16;
        if (item == ModItems.DIAMOND_DUCKBUCK.get()) return 64;
        if (item == ModItems.NETHERITE_DUCKBUCK.get()) return 256;

        return 0;
    }
}
