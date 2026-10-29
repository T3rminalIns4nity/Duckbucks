package code.ins4nity.too.many.packages.duckbucks.util;

import code.ins4nity.too.many.packages.duckbucks.Duckbucks;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = Duckbucks.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class TimerTickHandler {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            PlayerParticleTimer timer = player.getData(ModAttachments.TIMER_COUNTDOWN);

            if (timer.getTicksLeft() > 0) {
                timer.decrement();

                if (timer.getTicksLeft() == 0) {
                    ModParticleOptions.amethystDuckbuckParticles(player);
                }
            }
        }
    }
}
