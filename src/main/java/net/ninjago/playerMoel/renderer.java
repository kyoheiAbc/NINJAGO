package net.ninjago.playerMoel;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.logging.LogUtils;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class renderer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    public model playerModel;

    public renderer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> renderer) {

        super(renderer);
        playerModel = new model(playerModel.LayerDefinitionCreate().bakeRoot());
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource p_116952_, int p_116953_, AbstractClientPlayer p_116954_,
            float p_116955_, float p_116956_, float p_116957_, float p_116958_, float p_116959_, float p_116960_) {

        this.getParentModel().copyPropertiesTo(this.playerModel);

        VertexConsumer vertexConsumer = p_116952_.getBuffer(
                RenderType.entityCutoutNoCull(
                        new ResourceLocation("ninjago:textures/entities/lloyd.png")));

        this.playerModel.renderToBuffer(
                poseStack,
                vertexConsumer,
                p_116953_,
                OverlayTexture.NO_OVERLAY,
                1,
                1,
                1,
                1.0F);
    }

}