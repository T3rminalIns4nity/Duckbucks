package code.ins4nity.too.many.packages.duckbucks.items.duckbucks;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class CopperDuckbuckItem extends Item {
    public CopperDuckbuckItem(Properties plorp) {
        super(plorp);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if (livingEntity instanceof Player player) {
            player.getCooldowns().addCooldown(this, 10);
        }

        if (!level.isClientSide && livingEntity instanceof Player player) {
            player.push(0.0D, 0.8D, 0.0D);
            player.hurtMarked = true;
        }

        return super.finishUsingItem(stack, level, livingEntity);
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity livingEntity) {
        return 1;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> component, TooltipFlag tooltipFlag) {
        component.add(Component.literal("§8[§6 1DB §8]"));

        Component line1 = Component.translatable(
                "tooltip.duckbucks.exchange",
                Component.translatable("item.minecraft.raw_copper"),
                Component.translatable("item.duckbucks.copper_duckbuck"),
                Component.literal("§8x4"),
                Component.literal("§8x1")
        );

        if (Screen.hasShiftDown()) {
            component.add(Component.translatable("tooltip.duckbucks.summary_active"));
            component.add(line1);
        } else {
            component.add(Component.translatable("tooltip.duckbucks.summary_inactive"));
        }

        super.appendHoverText(stack, context, component, tooltipFlag);
    }
}
