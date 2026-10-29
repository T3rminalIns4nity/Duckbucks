package code.ins4nity.too.many.packages.duckbucks.items.wallet;

import code.ins4nity.too.many.packages.duckbucks.items.ModItems;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class WalletSlot extends Slot {
    private final TagKey<Item> walletStorable;

    public WalletSlot(Container container, int slot, int x, int y, TagKey<Item> walletStorable) {
        super(container, slot, x, y);
        this.walletStorable = walletStorable;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        if (stack.isEmpty() || !stack.is(this.walletStorable)) {
            return false;
        }

        return !stack.is(ModItems.WALLET.get());
    }
}
