package divinerpg.client.renders.entity.projectile;

import com.mojang.blaze3d.matrix.MatrixStack;

import divinerpg.registries.BlockRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderWatcherShot extends EntityRenderer<AbstractFireballEntity> {

    public RenderWatcherShot(EntityRendererManager renderManager) {
        super(renderManager);
    }
//TODO - render watcher shot as sprite instead of blaze pumpkin
    @Override
    public ResourceLocation getEntityTexture(AbstractFireballEntity entity) {
        return AtlasTexture.LOCATION_BLOCKS_TEXTURE;
    }

    @Override
    public void render(AbstractFireballEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
        matrixStackIn.push();
        matrixStackIn.translate(0.0D, 0.5D, 0.0D);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(-90.0F));
        matrixStackIn.translate(-0.5D, -0.5D, 0.5D);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90.0F));
        Minecraft.getInstance().getBlockRendererDispatcher().renderBlock(BlockRegistry.blazePumpkin.getDefaultState(), matrixStackIn, bufferIn, packedLightIn, OverlayTexture.NO_OVERLAY);
        matrixStackIn.pop();
    }

}