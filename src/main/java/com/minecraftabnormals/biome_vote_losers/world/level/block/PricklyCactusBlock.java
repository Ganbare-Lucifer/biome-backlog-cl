package com.minecraftabnormals.biome_vote_losers.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;

public class PricklyCactusBlock extends BushBlock {
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 2);

	public PricklyCactusBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
	}

	public boolean isRandomlyTicking(BlockState p_57284_) {
		return p_57284_.getValue(AGE) < 2;
	}

	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		int i = state.getValue(AGE);
		if (i < 3 && level.getRawBrightness(pos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt(5) == 0)) {
			BlockState blockstate = state.setValue(AGE, Integer.valueOf(i + 1));
			level.setBlock(pos, blockstate, 2);
			level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockstate));
			net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
		}
	}

	public void entityInside(BlockState p_51148_, Level p_51149_, BlockPos p_51150_, Entity p_51151_) {
		if (p_51151_.isPickable()) {
			p_51151_.hurt(DamageSource.CACTUS, 1.0F);
		}
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_51164_) {
		p_51164_.add(AGE);
	}

	public boolean isPathfindable(BlockState p_51143_, BlockGetter p_51144_, BlockPos p_51145_, PathComputationType p_51146_) {
		return false;
	}

	@Override
	public net.minecraftforge.common.PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return net.minecraftforge.common.PlantType.DESERT;
	}


	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter blockGetter, BlockPos pos) {
		return state.is(BlockTags.DIRT) || state.is(BlockTags.SAND);
	}

}
