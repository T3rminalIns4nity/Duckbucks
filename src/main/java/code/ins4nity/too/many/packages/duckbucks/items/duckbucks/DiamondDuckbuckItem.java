package code.ins4nity.too.many.packages.duckbucks.items.duckbucks;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class DiamondDuckbuckItem extends Item {
    public DiamondDuckbuckItem(Properties weHasDaDiamond) {
        super(weHasDaDiamond);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> component, TooltipFlag tooltipFlag) {
        component.add(Component.literal("§8[§6 64DB §8]"));

        Component line1 = Component.translatable(
                "tooltip.duckbucks.exchange",
                Component.translatable("item.minecraft.raw_copper"),
                Component.translatable("item.duckbucks.copper_duckbuck"),
                Component.literal("§8x256"),
                Component.literal("§8x64")
        );

        Component line2 = Component.translatable(
                "tooltip.duckbucks.exchange",
                Component.translatable("item.minecraft.raw_iron"),
                Component.translatable("item.duckbucks.iron_duckbuck"),
                Component.literal("§8x64"),
                Component.literal("§8x16")
        );

        Component line3 = Component.translatable(
                "tooltip.duckbucks.exchange",
                Component.translatable("item.minecraft.raw_gold"),
                Component.translatable("item.duckbucks.gold_duckbuck"),
                Component.literal("§8x16"),
                Component.literal("§8x4")
        );

        Component line4 = Component.translatable(
                "tooltip.duckbucks.exchange",
                Component.translatable("item.minecraft.diamond"),
                Component.translatable("item.duckbucks.diamond_duckbuck"),
                Component.literal("§8x1"),
                Component.literal("§8x1")
        );

        if (Screen.hasShiftDown()) {
            component.add(Component.translatable("tooltip.duckbucks.summary_active"));
            component.add(line1);
            component.add(line2);
            component.add(line3);
            component.add(line4);
        } else {
            component.add(Component.translatable("tooltip.duckbucks.summary_inactive"));
        }

        super.appendHoverText(stack, context, component, tooltipFlag);
    }
}
