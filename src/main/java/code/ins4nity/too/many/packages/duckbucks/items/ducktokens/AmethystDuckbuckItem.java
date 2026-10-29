package code.ins4nity.too.many.packages.duckbucks.items.ducktokens;

import code.ins4nity.too.many.packages.duckbucks.util.ModAttachments;
import code.ins4nity.too.many.packages.duckbucks.util.ModParticleOptions;
import code.ins4nity.too.many.packages.duckbucks.util.PlayerParticleTimer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class AmethystDuckbuckItem extends Item {
    public AmethystDuckbuckItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> component, TooltipFlag tooltipFlag) {
        component.add(Component.translatable("tooltip.duckbucks.ducktoken"));
        super.appendHoverText(stack, context, component, tooltipFlag);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if (!level.isClientSide) {
            if (livingEntity instanceof ServerPlayer player) {
                player.getCooldowns().addCooldown(this, 100);

                ModParticleOptions.amethystDuckbuckParticles(player);

                PlayerParticleTimer timer = player.getData(ModAttachments.TIMER_COUNTDOWN);
                timer.setTicksLeft(100);
            }
        }

        return super.finishUsingItem(stack, level, livingEntity);
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity livingEntity) {
        return 1;
    }
}
