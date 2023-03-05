
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ninjago.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.ninjago.entity.GarmadonEntity;
import net.mcreator.ninjago.entity.DragonEntity;
import net.mcreator.ninjago.NinjagoMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NinjagoModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NinjagoMod.MODID);
	public static final RegistryObject<EntityType<GarmadonEntity>> GARMADON = register("garmadon",
			EntityType.Builder.<GarmadonEntity>of(GarmadonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(GarmadonEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<DragonEntity>> DRAGON = register("dragon",
			EntityType.Builder.<DragonEntity>of(DragonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(DragonEntity::new)

					.sized(2f, 1f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			GarmadonEntity.init();
			DragonEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(GARMADON.get(), GarmadonEntity.createAttributes().build());
		event.put(DRAGON.get(), DragonEntity.createAttributes().build());
	}
}
