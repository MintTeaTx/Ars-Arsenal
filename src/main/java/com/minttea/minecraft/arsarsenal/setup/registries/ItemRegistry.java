package com.minttea.minecraft.arsarsenal.setup.registries;

import com.minttea.minecraft.arsarsenal.ArsArsenal;
import com.minttea.minecraft.arsarsenal.client.renderer.item.AirHatRenderer;
import com.minttea.minecraft.arsarsenal.client.renderer.item.AquaHatRenderer;
import com.minttea.minecraft.arsarsenal.client.renderer.item.EarthHatRenderer;
import com.minttea.minecraft.arsarsenal.client.renderer.item.FireHatRenderer;
import com.minttea.minecraft.arsarsenal.common.armor.*;
import com.minttea.minecraft.arsarsenal.common.items.SourceSteelAxe;
import com.minttea.minecraft.arsarsenal.common.items.SourceSteelPick;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;



@Mod.EventBusSubscriber(modid = ArsArsenal.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@Mod(ArsArsenal.MODID)
public class ItemRegistry {


    @ObjectHolder("source_steel_helmet")public static SourceSteelArmor sourceSteelHelmet;
    @ObjectHolder("source_steel_chestplate")public static SourceSteelArmor sourceSteelChestplate;
    @ObjectHolder("source_steel_leggings")public static SourceSteelArmor sourceSteelLeggings;
    @ObjectHolder("source_steel_boots")public static SourceSteelArmor sourceSteelBoots;
    @ObjectHolder("fire_hat")public static FireHat fireHat;
    @ObjectHolder("fire_hood")public static FireRobes fireHood;
    @ObjectHolder("fire_robes")public static FireRobes fireRobe;
    @ObjectHolder("fire_leggings")public static FireRobes fireLegs;
    @ObjectHolder("fire_boots")public static FireRobes fireBoots;
    @ObjectHolder("aqua_hat")public static AquaHat aquaHat;
    @ObjectHolder("aqua_hood")public static AquaRobes aquaHood;
    @ObjectHolder("aqua_robes")public static AquaRobes aquaRobe;
    @ObjectHolder("aqua_leggings")public static AquaRobes aquaLegs;
    @ObjectHolder("aqua_boots")public static AquaRobes aquaBoots;
    @ObjectHolder("earth_hat")public static EarthHat earthHat;
    @ObjectHolder("earth_hood")public static EarthHat earthHood;
    @ObjectHolder("earth_robes")public static EarthRobes earthRobe;
    @ObjectHolder("earth_leggings")public static EarthRobes earthLegs;
    @ObjectHolder("earth_boots")public static EarthRobes earthBoots;
    @ObjectHolder("air_hat")public static AirHat airHat;
    @ObjectHolder("air_hood")public static AirRobes airHood;
    @ObjectHolder("air_robes")public static AirRobes airRobe;
    @ObjectHolder("air_leggings")public static AirRobes airLegs;
    @ObjectHolder("air_boots")public static AirRobes airBoots;
    @ObjectHolder("primed_iron_ingot")public static Item primedIron;
    @ObjectHolder("source_steel_ingot")public static Item sourceSteelIngot;
    @ObjectHolder("sigil_of_pyromancy")public static Item fireSigil;
    @ObjectHolder("sigil_of_aquamancy")public static Item aquaSigil;
    @ObjectHolder("sigil_of_geomancy")public static Item earthSigil;
    @ObjectHolder("sigil_of_aethermancy")public static Item aetherSigil;



    @ObjectHolder("source_steel_axe")public static SourceSteelAxe chargedAxe;
    @ObjectHolder("source_steel_pickaxe")public static SourceSteelPick sourcePick;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {

        final IForgeRegistry<Item> registry = event.getRegistry();

//
//        registry.register(new BloodTome(ISpellTier.Tier.ONE).setRegistryName("blood_tome_one"));
        registry.register(new SourceSteelArmor(EquipmentSlotType.HEAD).setRegistryName("source_steel_helmet"));
        registry.register(new SourceSteelArmor(EquipmentSlotType.CHEST).setRegistryName("source_steel_chestplate"));
        registry.register(new SourceSteelArmor(EquipmentSlotType.LEGS).setRegistryName("source_steel_leggings"));
        registry.register(new SourceSteelArmor(EquipmentSlotType.FEET).setRegistryName("source_steel_boots"));

        registry.register(new FireHat().setRegistryName("fire_hat"));
        registry.register(new FireRobes(EquipmentSlotType.HEAD).setRegistryName("fire_hood"));
        registry.register(new FireRobes(EquipmentSlotType.CHEST).setRegistryName("fire_robes"));
        registry.register(new FireRobes(EquipmentSlotType.LEGS).setRegistryName("fire_leggings"));
        registry.register(new FireRobes(EquipmentSlotType.FEET).setRegistryName("fire_boots"));

        registry.register(new AquaHat().setRegistryName("aqua_hat"));
        registry.register(new AquaRobes(EquipmentSlotType.HEAD).setRegistryName("aqua_hood"));
        registry.register(new AquaRobes(EquipmentSlotType.CHEST).setRegistryName("aqua_robes"));
        registry.register(new AquaRobes(EquipmentSlotType.LEGS).setRegistryName("aqua_leggings"));
        registry.register(new AquaRobes(EquipmentSlotType.FEET).setRegistryName("aqua_boots"));

        registry.register(new EarthHat().setRegistryName("earth_hat"));
        registry.register(new EarthRobes(EquipmentSlotType.HEAD).setRegistryName("earth_hood"));
        registry.register(new EarthRobes(EquipmentSlotType.CHEST).setRegistryName("earth_robes"));
        registry.register(new EarthRobes(EquipmentSlotType.LEGS).setRegistryName("earth_leggings"));
        registry.register(new EarthRobes(EquipmentSlotType.FEET).setRegistryName("earth_boots"));

        registry.register(new AirHat().setRegistryName("air_hat"));
        registry.register(new AirRobes(EquipmentSlotType.HEAD).setRegistryName("air_hood"));
        registry.register(new AirRobes(EquipmentSlotType.CHEST).setRegistryName("air_robes"));
        registry.register(new AirRobes(EquipmentSlotType.LEGS).setRegistryName("air_leggings"));
        registry.register(new AirRobes(EquipmentSlotType.FEET).setRegistryName("air_boots"));

        registry.register(new Item(defaultItemProperties().stacksTo(64)).setRegistryName("primed_iron_ingot"));
        registry.register(new Item(defaultItemProperties().stacksTo(64)).setRegistryName("source_steel_ingot"));

        registry.register(new Item(defaultItemProperties().stacksTo(4)).setRegistryName("sigil_of_pyromancy"));
        registry.register(new Item(defaultItemProperties().stacksTo(4)).setRegistryName("sigil_of_aquamancy"));
        registry.register(new Item(defaultItemProperties().stacksTo(4)).setRegistryName("sigil_of_geomancy"));
        registry.register(new Item(defaultItemProperties().stacksTo(4)).setRegistryName("sigil_of_aethermancy"));

        registry.register(new SourceSteelAxe().setRegistryName("source_steel_axe"));
        registry.register(new SourceSteelPick().setRegistryName("source_steel_pickaxe"));
    }

    public static Item.Properties defaultItemProperties() {
        return new Item.Properties().tab(ArsArsenal.itemGroup);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(final FMLClientSetupEvent event)
    {

        GeoArmorRenderer.registerArmorRenderer(FireHat.class, new FireHatRenderer());
        GeoArmorRenderer.registerArmorRenderer(EarthHat.class, new EarthHatRenderer());
        GeoArmorRenderer.registerArmorRenderer(AquaHat.class, new AquaHatRenderer());
        GeoArmorRenderer.registerArmorRenderer(AirHat.class, new AirHatRenderer());
    }
}
