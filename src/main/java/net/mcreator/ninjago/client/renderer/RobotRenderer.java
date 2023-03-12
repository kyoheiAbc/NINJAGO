
package net.mcreator.ninjago.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.ninjago.entity.RobotEntity;
import net.mcreator.ninjago.client.model.Modelcustom_model;

public class RobotRenderer extends MobRenderer<RobotEntity, Modelcustom_model<RobotEntity>> {
	public RobotRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(RobotEntity entity) {
		return new ResourceLocation("ninjago:textures/entities/texture.png");
	}
}
