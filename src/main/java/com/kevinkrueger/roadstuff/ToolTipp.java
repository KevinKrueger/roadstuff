package com.kevinkrueger.roadstuff;

import com.kevinkrueger.roadstuff.base.BlockBase;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.ITickList;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.AbstractChunkProvider;
import net.minecraft.world.storage.MapData;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ToolTipp
{
    private List<ITextComponent> list;
    public ToolTipp(Block block, String tooltip)
    {
        init();
        list.add(ITextComponent.getTextComponentOrEmpty(tooltip));
        block.addInformation(block.asItem().getDefaultInstance(), block.asItem().getDefaultInstance().getItemFrame().world, list, () -> false);
    }


    private void init(){
        list =  new List<ITextComponent>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<ITextComponent> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(ITextComponent iTextComponent) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends ITextComponent> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends ITextComponent> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public ITextComponent get(int index) {
                return null;
            }

            @Override
            public ITextComponent set(int index, ITextComponent element) {
                return null;
            }

            @Override
            public void add(int index, ITextComponent element) {

            }

            @Override
            public ITextComponent remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<ITextComponent> listIterator() {
                return null;
            }

            @Override
            public ListIterator<ITextComponent> listIterator(int index) {
                return null;
            }

            @Override
            public List<ITextComponent> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
    }
}
