package code.ins4nity.too.many.packages.duckbucks.items.ducktokens;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class GenericDuckbuckItem extends Item {
    public GenericDuckbuckItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> component, TooltipFlag tooltipFlag) {
        component.add(Component.translatable("tooltip.duckbucks.ducktoken"));
        super.appendHoverText(stack, context, component, tooltipFlag);
    }
}
