package code.ins4nity.too.many.packages.duckbucks.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties COPPER_DUCKBUCK = new FoodProperties.Builder()
            .alwaysEdible()
            .fast()
            .build();

    public static final FoodProperties IRON_DUCKBUCK = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 1, false, true, true), 1.0f)
            .alwaysEdible()
            .fast()
            .build();

    public static final FoodProperties GOLD_DUCKBUCK = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 2, false, true, true), 1.0f)
            .alwaysEdible()
            .fast()
            .build();

    public static final FoodProperties DIAMOND_DUCKBUCK = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 4, false, true, true), 1.0f)
            .alwaysEdible()
            .fast()
            .build();

    public static final FoodProperties NETHERITE_DUCKBUCK = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 3, false, true, true), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0, false, true, true), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 3, false, true, true), 1.0f)
            .alwaysEdible()
            .fast()
            .build();

    public static final FoodProperties EMERALD_DUCKBUCK = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 1, false, true, true), 1.0f)
            .alwaysEdible()
            .fast()
            .build();

    public static final FoodProperties AMETHYST_DUCKBUCK = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2, 255, false, true, false), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 100, 0, false, false, false), 1.0f)
            .alwaysEdible()
            .fast()
            .build();

    public static final FoodProperties FLINT_DUCKBUCK = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 300, 2, false, true, true), 1.0f)
            .alwaysEdible()
            .fast()
            .build();

    public static final FoodProperties LAPIS_DUCKBUCK = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0, false, true, true), 1.0f)
            .alwaysEdible()
            .fast()
            .build();

    public static final FoodProperties PRISMARINE_DUCKBUCK = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0, false, true, true), 1.0f)
            .alwaysEdible()
            .fast()
            .build();

    public static final FoodProperties QUARTZ_DUCKBUCK = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0, false, true, true), 1.0f)
            .alwaysEdible()
            .fast()
            .build();

    public static final FoodProperties REDSTONE_DUCKBUCK = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 300, 0, false, false, true), 1.0f)
            .alwaysEdible()
            .fast()
            .build();
}
