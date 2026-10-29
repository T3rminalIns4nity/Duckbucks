package code.ins4nity.too.many.packages.duckbucks.util;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ModConfig {
    public static final ModConfigSpec spec;
    public static final ModConfigSpec.BooleanValue enableNetheriteDuckbuck;

    public static boolean isNetheriteDuckbuckEnabled;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        enableNetheriteDuckbuck = builder
                .comment("Enables or disables the Netherite Duckbuck\nThis wasn't in the original mod, so I thought I'd make it configurable\n\n(note: the system currently only initialises the netherite duckbuck as a basic item with no special properties and a stack size of 0 if disabled, so netherite duckbucks do persist between config changes, you just can't do anything with them and they vanish if the ever get dropped)\n\n[requires restart]")
                .define("enableNetheriteDuckbucks", true);

        spec = builder.build();
    }

    public static void refresh() {
        isNetheriteDuckbuckEnabled = enableNetheriteDuckbuck.get();
    }
}
