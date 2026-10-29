package code.ins4nity.too.many.packages.duckbucks.items.duckbucks;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class EmeraldDuckbuckItem extends Item {
    public EmeraldDuckbuckItem(Properties propaganda) {
        super(propaganda);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> component, TooltipFlag tooltipFlag) {
        component.add(Component.translatable("tooltip.duckbucks.emerald_duckbuck"));
        super.appendHoverText(stack, context, component, tooltipFlag);
    }
}
