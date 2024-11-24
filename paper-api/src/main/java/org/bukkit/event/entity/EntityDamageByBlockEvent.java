package org.bukkit.event.entity;

import com.google.common.base.Function;
import java.util.Map;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.damage.DamageSource;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called when an entity is damaged by a block
 */
public class EntityDamageByBlockEvent extends EntityDamageEvent {
    private final Block damager;
    private final BlockState damagerState;

    @Deprecated(since = "1.20.4", forRemoval = true)
    public EntityDamageByBlockEvent(@Nullable final Block damager, @NotNull final Entity damagee, @NotNull final DamageCause cause, final double damage) {
        this(damager, (damager != null) ? damager.getState() : null, damagee, cause, (damager != null) ? DamageSource.builder(DamageType.GENERIC).withDamageLocation(damager.getLocation()).build() : DamageSource.builder(DamageType.GENERIC).build(), damage);
    }

    public EntityDamageByBlockEvent(@Nullable final Block damager, @Nullable final BlockState damagerState, @NotNull final Entity damagee, @NotNull final DamageCause cause, @NotNull final DamageSource damageSource, final double damage) {
        super(damagee, cause, damageSource, damage);
        this.damager = damager;
        this.damagerState = damagerState;
    }

    @Deprecated(since = "1.20.4", forRemoval = true)
    public EntityDamageByBlockEvent(@Nullable final Block damager, @NotNull final Entity damagee, @NotNull final DamageCause cause, @NotNull final Map<DamageModifier, Double> modifiers, @NotNull final Map<DamageModifier, ? extends Function<? super Double, Double>> modifierFunctions) {
        this(damager, (damager != null) ? damager.getState() : null, damagee, cause, (damager != null) ? DamageSource.builder(DamageType.GENERIC).withDamageLocation(damager.getLocation()).build() : DamageSource.builder(DamageType.GENERIC).build(), modifiers, modifierFunctions);
    }

    public EntityDamageByBlockEvent(@Nullable final Block damager, @Nullable final BlockState damagerState, @NotNull final Entity damagee, @NotNull final DamageCause cause, @NotNull final DamageSource damageSource, @NotNull final Map<DamageModifier, Double> modifiers, @NotNull final Map<DamageModifier, ? extends Function<? super Double, Double>> modifierFunctions) {
        super(damagee, cause, damageSource, modifiers, modifierFunctions);
        this.damager = damager;
        this.damagerState = damagerState;
    }

    /**
     * Returns the block that damaged the player.
     *
     * @return Block that damaged the player
     */
    @Nullable
    public Block getDamager() {
        return damager;
    }

    /**
     * Returns the captured BlockState of the block that damaged the player.
     *
     * @return the block state
     */
    @Nullable
    public BlockState getDamagerBlockState() {
        return damagerState;
    }
}
