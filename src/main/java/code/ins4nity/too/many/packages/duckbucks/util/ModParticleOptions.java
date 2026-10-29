package code.ins4nity.too.many.packages.duckbucks.util;

import net.minecraft.core.particles.DustColorTransitionOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import org.joml.Vector3f;

public class ModParticleOptions {
    public static ParticleOptions purpleDust = new DustColorTransitionOptions(
            new Vector3f(0.4f, 0.05f, 0.6f),
            new Vector3f(0.0f, 0.0f, 0.0f),
            4.0f
    );

    public static void amethystDuckbuckParticles(ServerPlayer player) {
        ServerLevel level = player.serverLevel();

        level.sendParticles(
                ModParticleOptions.purpleDust,
                player.getX(),
                player.getY() + 0.5f,
                player.getZ(),
                50,
                0.6,
                0.5,
                0.6,
                1
        );

        level.playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.AMETHYST_BLOCK_HIT,
                SoundSource.PLAYERS
        );
    }
}
