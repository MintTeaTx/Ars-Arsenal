package com.minttea.minecraft.arsarsenal.common.items;

import com.hollingsworth.arsnouveau.api.item.ICasterTool;
import com.hollingsworth.arsnouveau.api.spell.*;
import com.hollingsworth.arsnouveau.common.capability.ManaCapability;
import com.hollingsworth.arsnouveau.common.spell.augment.AugmentAOE;
import com.hollingsworth.arsnouveau.common.spell.augment.AugmentAmplify;
import com.hollingsworth.arsnouveau.common.spell.effect.EffectCut;
import com.hollingsworth.arsnouveau.common.spell.effect.EffectFell;
import com.hollingsworth.arsnouveau.common.spell.effect.EffectHarm;
import com.hollingsworth.arsnouveau.common.spell.effect.EffectPickup;
import com.hollingsworth.arsnouveau.common.spell.method.MethodTouch;
import com.hollingsworth.arsnouveau.common.util.PortUtil;
import com.minttea.minecraft.arsarsenal.client.renderer.item.AxeRenderer;
import com.minttea.minecraft.arsarsenal.setup.registries.ItemRegistry;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class SourceSteelAxe extends AxeItem implements ICasterTool, IAnimatable {
    public SourceSteelAxe() {
        super(ItemTier.NETHERITE, 5, -3.1f, ItemRegistry.defaultItemProperties().stacksTo(1).setISTER(() -> AxeRenderer::new));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        super.inventoryTick(stack, world, entity, p_77663_4_, p_77663_5_);
        if(world.isClientSide() || world.getGameTime() % 200 !=  0 || stack.getDamageValue() == 0 || !(entity instanceof PlayerEntity))
            return;

        ManaCapability.getMana((LivingEntity) entity).ifPresent(mana -> {
            if(mana.getCurrentMana() > 20){
                mana.removeMana(20);
                stack.setDamageValue(stack.getDamageValue() - 1);
            }
        });
    }
    @Override
    public boolean isScribedSpellValid(ISpellCaster caster, PlayerEntity player, Hand hand, ItemStack stack, Spell spell) {
        return spell.recipe.stream().noneMatch(s -> s instanceof AbstractCastMethod);
    }

    @Override
    public void sendInvalidMessage(PlayerEntity player) {
        PortUtil.sendMessageNoSpam(player, new TranslationTextComponent("ars_nouveau.sword.invalid"));
    }

    @Override
    public boolean setSpell(ISpellCaster caster, PlayerEntity player, Hand hand, ItemStack stack, Spell spell) {
        ArrayList<AbstractSpellPart> recipe = new ArrayList<>();
        int discount = 0;
        recipe.add(MethodTouch.INSTANCE);
        for (AbstractSpellPart part: spell.recipe
        ) {
            recipe.add(part);
            if ( part instanceof EffectCut)
            {
                recipe.add(AugmentAmplify.INSTANCE);
                recipe.add(AugmentAmplify.INSTANCE);
                recipe.add(AugmentAmplify.INSTANCE);
                recipe.add(AugmentAmplify.INSTANCE);
                discount = AugmentAmplify.INSTANCE.getManaCost() * 4;
            } else if( part instanceof EffectFell)
            {
                recipe.add(AugmentAOE.INSTANCE);
                recipe.add(AugmentAOE.INSTANCE);
                recipe.add(AugmentAOE.INSTANCE);
                recipe.add(AugmentAOE.INSTANCE);
                discount = AugmentAOE.INSTANCE.getManaCost() * 4;
            }else if(part instanceof AbstractEffect)
            {
                recipe.add(AugmentAmplify.INSTANCE);
                recipe.add(AugmentAmplify.INSTANCE);
                discount = AugmentAmplify.INSTANCE.getManaCost() * 2;
            }
        }
        recipe.add(EffectPickup.INSTANCE);
        recipe.add(AugmentAOE.INSTANCE);
        recipe.add(AugmentAOE.INSTANCE);
        recipe.add(AugmentAOE.INSTANCE);
        recipe.add(AugmentAOE.INSTANCE);
        spell.recipe = recipe;

        return ICasterTool.super.setSpell(caster, player, hand, stack, spell);
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);
        ISpellCaster caster = getSpellCaster(stack);
        return caster.castSpell(worldIn, playerIn, handIn, new TranslationTextComponent("ars_nouveau.wand.invalid"));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        if(context.getPlayer().isCrouching())
        {
            return super.useOn(context);
        } else
        {
            return ActionResultType.PASS;
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity player) {

        ISpellCaster caster = getSpellCaster(stack);
        SpellResolver resolver = new SpellResolver(new SpellContext(caster.getSpell(), player).withColors(caster.getColor()));
        EntityRayTraceResult entityRes = new EntityRayTraceResult(target);

        resolver.onCastOnEntity(stack, player, (LivingEntity) entityRes.getEntity(), Hand.MAIN_HAND);

        return super.hurtEnemy(stack, target, player);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip2, ITooltipFlag flagIn) {
        getInformation(stack, worldIn, tooltip2, flagIn);
        super.appendHoverText(stack, worldIn, tooltip2, flagIn);
    }
    @Override
    public void registerControllers(AnimationData animationData) {

    }

    public AnimationFactory factory = new AnimationFactory(this);

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}