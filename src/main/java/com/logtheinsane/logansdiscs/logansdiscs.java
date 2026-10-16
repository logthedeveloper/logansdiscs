package com.logtheinsane.logansdiscs;

import com.mojang.logging.LogUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(logansdiscs.MODID)
public class logansdiscs {
    public static final String MODID = "logansdiscs";
    public static final Logger LOGGER = LogUtils.getLogger();

    // Deferred Registers
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, MODID);
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Sound Events
    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_BARKFART_SOUND =
            SOUND_EVENTS.register("music_disc.barkfart",
                    () -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath(MODID, "music_disc.barkfart"), 16.0f));

    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_GOLDENBROWN_SOUND =
            SOUND_EVENTS.register("music_disc.goldenbrown",
                    () -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath(MODID, "music_disc.goldenbrown"), 16.0f));
    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_MONKE_SOUND =
            SOUND_EVENTS.register("music_disc.monke",
                    () -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath(MODID, "music_disc.monke"), 16.0f));

    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_ICE_SPIKES_SOUND =
            SOUND_EVENTS.register("music_disc.ice_spikes",
                    () -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath(MODID, "music_disc.ice_spikes"), 16.0f));

    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_VELVET_SOUND =
            SOUND_EVENTS.register("music_disc.velvet",
                    () -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath(MODID, "music_disc.velvet"), 16.0f));

    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_TREES_SOUND =
            SOUND_EVENTS.register("music_disc.trees",
                    () -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath(MODID, "music_disc.trees"), 16.0f));

    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_AUREASOL_SOUND =
            SOUND_EVENTS.register("music_disc.aureasol",
                    () -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath(MODID, "music_disc.aureasol"), 16.0f));

    // Items
    public static final DeferredItem<MusicDiscItem> MUSIC_DISC_BARKFART = ITEMS.registerItem("music_disc_barkfart",
            properties -> new MusicDiscItem(properties
                    .jukeboxPlayable(
                            ResourceKey.create(Registries.JUKEBOX_SONG,
                                    ResourceLocation.fromNamespaceAndPath(MODID, "barkfart"))
                    )
                    .stacksTo(1)
                    .component(DataComponents.LORE, new ItemLore(java.util.List.of(
                            Component.literal("SØLZÉ arr. logtheinsane")
                    )))
            ));

    public static final DeferredItem<MusicDiscItem> MUSIC_DISC_GOLDENBROWN = ITEMS.registerItem("music_disc_goldenbrown",
            properties -> new MusicDiscItem(properties
                    .jukeboxPlayable(
                            ResourceKey.create(Registries.JUKEBOX_SONG,
                                    ResourceLocation.fromNamespaceAndPath(MODID, "goldenbrown"))
                    )
                    .stacksTo(1)
                    .component(DataComponents.LORE, new ItemLore(java.util.List.of(
                            Component.literal("The Stragglers")
                    )))
            ));

    public static final DeferredItem<MusicDiscItem> MUSIC_DISC_AUREASOL = ITEMS.registerItem("music_disc_aureasol",
            properties -> new MusicDiscItem(properties
                    .jukeboxPlayable(
                            ResourceKey.create(Registries.JUKEBOX_SONG,
                                    ResourceLocation.fromNamespaceAndPath(MODID, "aureasol"))
                    )
                    .stacksTo(1)
                    .component(DataComponents.LORE, new ItemLore(java.util.List.of(
                            Component.literal("Delta")
                    )))
            ));

    public static final DeferredItem<MusicDiscItem> MUSIC_DISC_MONKE = ITEMS.registerItem("music_disc_monke",
            properties -> new MusicDiscItem(properties
                    .jukeboxPlayable(
                            ResourceKey.create(Registries.JUKEBOX_SONG,
                                    ResourceLocation.fromNamespaceAndPath(MODID, "monke"))
                    )
                    .stacksTo(1)
                    .component(DataComponents.LORE, new ItemLore(java.util.List.of(
                            Component.literal("Delta")
                    )))
            ));
    public static final DeferredItem<MusicDiscItem> MUSIC_DISC_ICE_SPIKES = ITEMS.registerItem("music_disc_ice_spikes",
            properties -> new MusicDiscItem(properties
                    .jukeboxPlayable(
                            ResourceKey.create(Registries.JUKEBOX_SONG,
                                    ResourceLocation.fromNamespaceAndPath(MODID, "ice_spikes"))
                    )
                    .stacksTo(1)
                    .component(DataComponents.LORE, new ItemLore(java.util.List.of(
                            Component.literal("Delta")
                    )))
            ));

    public static final DeferredItem<MusicDiscItem> MUSIC_DISC_VELVET = ITEMS.registerItem("music_disc_velvet",
            properties -> new MusicDiscItem(properties
                    .jukeboxPlayable(
                            ResourceKey.create(Registries.JUKEBOX_SONG,
                                    ResourceLocation.fromNamespaceAndPath(MODID, "velvet"))
                    )
                    .stacksTo(1)
                    .component(DataComponents.LORE, new ItemLore(java.util.List.of(
                            Component.literal("Delta")
                    )))
            ));

    public static final DeferredItem<MusicDiscItem> MUSIC_DISC_TREES = ITEMS.registerItem("music_disc_trees",
            properties -> new MusicDiscItem(properties
                    .jukeboxPlayable(
                            ResourceKey.create(Registries.JUKEBOX_SONG,
                                    ResourceLocation.fromNamespaceAndPath(MODID, "trees"))
                    )
                    .stacksTo(1)
                    .component(DataComponents.LORE, new ItemLore(java.util.List.of(
                            Component.literal("Delta")
                    )))
            ));






    public static final DeferredItem<Item> MUSIC_DISC_BASE = ITEMS.registerSimpleItem("music_disc_base");


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.logansdiscs"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> MUSIC_DISC_BARKFART.get().getDefaultInstance())
            .displayItems((parameters, output) -> {

                output.accept(MUSIC_DISC_BARKFART.get());
                output.accept(MUSIC_DISC_GOLDENBROWN.get());
                output.accept(MUSIC_DISC_AUREASOL.get());
                output.accept(MUSIC_DISC_BASE.get());
                output.accept(MUSIC_DISC_TREES.get());
                output.accept(MUSIC_DISC_MONKE.get());
                output.accept(MUSIC_DISC_ICE_SPIKES.get());
                output.accept(MUSIC_DISC_VELVET.get());
            }).build());

    public logansdiscs(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        SOUND_EVENTS.register(modEventBus);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {


        // Add music discs to the vanilla Tools and Utilities tab
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(MUSIC_DISC_BARKFART);
            event.accept(MUSIC_DISC_GOLDENBROWN);
            event.accept(MUSIC_DISC_AUREASOL);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
}