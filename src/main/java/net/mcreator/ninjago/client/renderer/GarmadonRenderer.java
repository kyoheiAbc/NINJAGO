
package net.mcreator.ninjago.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.ninjago.entity.GarmadonEntity;
import net.mcreator.ninjago.client.model.ModelHumanoidModel;

public class GarmadonRenderer extends MobRenderer<GarmadonEntity, ModelHumanoidModel<GarmadonEntity>> {
	public GarmadonRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelHumanoidModel(context.bakeLayer(ModelHumanoidModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GarmadonEntity entity) {
		return new ResourceLocation("ninjago:textures/entities/garmadon.png");
	}
}
