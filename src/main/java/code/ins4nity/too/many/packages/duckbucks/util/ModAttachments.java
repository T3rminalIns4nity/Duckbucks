package code.ins4nity.too.many.packages.duckbucks.util;

import code.ins4nity.too.many.packages.duckbucks.Duckbucks;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS =
            DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, Duckbucks.MOD_ID);

    public static final Supplier<AttachmentType<PlayerParticleTimer>> TIMER_COUNTDOWN = ATTACHMENTS.register("player_timer",
            () -> AttachmentType.builder(PlayerParticleTimer::new).build());
}
