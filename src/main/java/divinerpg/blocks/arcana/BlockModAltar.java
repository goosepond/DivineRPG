package divinerpg.blocks.arcana;

import divinerpg.block_entities.bosses.*;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.*;
import javax.annotation.Nullable;

public class BlockModAltar extends BaseEntityBlock {
    public BlockModAltar(MapColor color) {super(BlockBehaviour.Properties.of().mapColor(color).strength(-1F, 3600000F).noLootTable().instrument(NoteBlockInstrument.BASEDRUM).noOcclusion());}
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {return Shapes.create(new AABB(0, 0, 0, 1, .9, 1));}
    @Nullable @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return this == BlockRegistry.dramixAltar.get() ? new DramixAltarBlockEntity(pos, state) : new ParasectaAltarBlockEntity(pos, state);}
}