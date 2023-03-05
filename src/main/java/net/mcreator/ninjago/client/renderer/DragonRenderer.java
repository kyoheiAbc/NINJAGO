
package net.mcreator.ninjago.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.ninjago.entity.DragonEntity;
import net.mcreator.ninjago.client.model.Modelcustom_model;

public class DragonRenderer extends MobRenderer<DragonEntity, Modelcustom_model<DragonEntity>> {
	public DragonRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(DragonEntity entity) {
		return new ResourceLocation("ninjago:textures/entities/enderdragon.png");
	}
}
