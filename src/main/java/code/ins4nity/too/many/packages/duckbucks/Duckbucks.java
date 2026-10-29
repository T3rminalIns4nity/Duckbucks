package code.ins4nity.too.many.packages.duckbucks;

import code.ins4nity.too.many.packages.duckbucks.items.ModCreativeTabs;
import code.ins4nity.too.many.packages.duckbucks.items.ModItems;
import code.ins4nity.too.many.packages.duckbucks.util.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Duckbucks.MOD_ID)
public class Duckbucks {
    public static final String MOD_ID = "duckbucks";
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static String areNetheriteDuckbucksEnabled;

    public Duckbucks(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(net.neoforged.fml.config.ModConfig.Type.STARTUP, ModConfig.spec);

        modEventBus.addListener(this::onConfigLoad);
        modEventBus.addListener(this::onConfigReload);
        modEventBus.addListener(this::commonSetup);

        ModAttachments.ATTACHMENTS.register(modEventBus);
        ModMenus.MENUS.register(modEventBus);
        ModComponents.COMPONENTS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModRecipeConditions.CONDITION_CODECS.register(modEventBus);
    }

    private void onConfigLoad(ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == ModConfig.spec) {
            ModConfig.refresh();
        }
    }

    private void onConfigReload(ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == ModConfig.spec) {
            ModConfig.refresh();
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        if (ModConfig.enableNetheriteDuckbuck.get()) {
            areNetheriteDuckbucksEnabled = "Netherite Duckbucks enabled!";
        } else {
            areNetheriteDuckbucksEnabled = "Netherite Duckbucks disabled!";
        }
        LOGGER.info("Duckbucks initialised, with " + areNetheriteDuckbucksEnabled);
    }
}
