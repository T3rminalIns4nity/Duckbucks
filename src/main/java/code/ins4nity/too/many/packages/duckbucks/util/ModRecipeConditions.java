package code.ins4nity.too.many.packages.duckbucks.util;

import code.ins4nity.too.many.packages.duckbucks.Duckbucks;
import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModRecipeConditions {
    public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_CODECS =
            DeferredRegister.create(NeoForgeRegistries.Keys.CONDITION_CODECS, Duckbucks.MOD_ID);

    public static final ICondition NETHERITE_DUCKBUCK_ENABLED = new ICondition() {
        @Override
        public boolean test(ICondition.IContext context) {
            return ModConfig.enableNetheriteDuckbuck.get();
        }

        @Override
        public MapCodec<? extends ICondition> codec() {
            return ModRecipeConditions.CODEC.get();
        }
    };

    public static final Supplier<MapCodec<ICondition>> CODEC = CONDITION_CODECS.register("is_netherite_duckbuck_enabled",
            () -> MapCodec.unit(() -> NETHERITE_DUCKBUCK_ENABLED));
}
