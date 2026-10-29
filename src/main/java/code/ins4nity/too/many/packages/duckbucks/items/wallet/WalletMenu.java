package code.ins4nity.too.many.packages.duckbucks.items.wallet;

import code.ins4nity.too.many.packages.duckbucks.items.ModItems;
import code.ins4nity.too.many.packages.duckbucks.util.ModMenus;
import code.ins4nity.too.many.packages.duckbucks.util.ModTags;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class WalletMenu extends AbstractContainerMenu {
    private final Container container;

    public WalletMenu(int containerId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(containerId, playerInventory, new WalletContainer(playerInventory.player.getMainHandItem()));
    }

    public WalletMenu(int containerId, Inventory playerInventory, Container container) {
        super(ModMenus.WALLET_MENU.get(), containerId);
        this.container = container;
        container.startOpen(playerInventory.player);

        int slotIndex = 0;

        // Wallet inventory
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 5; col++) {
                this.addSlot(new WalletSlot(container, slotIndex++, 84 + col * 18, 63 + row * 18, ModTags.WALLET_STORABLE));
            }
        }

        // Player inventory
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 48 + col * 18, 129 + row * 18));
            }
        }

        // Hotbar
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, 48 + col * 18, 187));
        }
    }


    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack itemStack1 = slot.getItem();
            itemStack = itemStack1.copy();

            if (index < 10) {
                if (!this.moveItemStackTo(itemStack1, 10, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (!itemStack1.is(ModTags.WALLET_STORABLE) || itemStack1.is(ModItems.WALLET.get())) {
                    return ItemStack.EMPTY;
                }
                if (!this.moveItemStackTo(itemStack1, 0, 10, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (itemStack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return player.getMainHandItem().is(ModItems.WALLET.get()) && this.container.stillValid(player);
    }

    @Override
    public void clicked(int slotId, int button, ClickType clickType, Player player) {
        if (clickType == ClickType.SWAP && button >= 0 && button < 9) {
            ItemStack hotbarStack = player.getInventory().getItem(button);
            if (hotbarStack.is(ModItems.WALLET.get())) {
                return;
            }
        }

        if (slotId >= 0 && slotId < this.slots.size()) {
            Slot slot = this.getSlot(slotId);
            if (slot.hasItem() && slot.getItem().is(ModItems.WALLET.get())) {
                return;
            }
        }

        super.clicked(slotId, button, clickType, player);
    }
}
