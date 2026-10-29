package code.ins4nity.too.many.packages.duckbucks.items.wallet;

import code.ins4nity.too.many.packages.duckbucks.util.ModComponents;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;

import java.util.ArrayList;
import java.util.List;

public class WalletContainer extends SimpleContainer {
    private final ItemStack walletStack;

    public WalletContainer(ItemStack walletStack) {
        super(10);
        this.walletStack = walletStack;
        this.load();
    }

    public void load() {
        List<ItemStack> contents = this.walletStack.getOrDefault(ModComponents.WALLET_CONTENTS.get(), List.of());
        for (int i = 0; i < this.getContainerSize(); i++) {
            if (i < contents.size()) {
                this.setItem(i, contents.get(i).copy());
            } else {
                this.setItem(i, ItemStack.EMPTY);
            }
        }
    }

    @Override
    public void setChanged() {
        super.setChanged();
        List<ItemStack> contents = new ArrayList<>();
        for (int i = 0; i < this.getContainerSize(); i++) {
            contents.add(this.getItem(i).copy());
        }
        this.walletStack.set(ModComponents.WALLET_CONTENTS.get(), contents);
    }
}
