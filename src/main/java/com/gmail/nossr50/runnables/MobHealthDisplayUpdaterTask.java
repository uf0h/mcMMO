package com.gmail.nossr50.runnables;

import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.nossr50.mcMMO;

public class MobHealthDisplayUpdaterTask extends BukkitRunnable {
  private final LivingEntity target;

  public MobHealthDisplayUpdaterTask(final LivingEntity target) {
    this.target = target;
  }

  @Override
  public void run() {
    if (target.hasMetadata(mcMMO.customNameKey)) {
      target.setCustomName(target.getMetadata(mcMMO.customNameKey).get(0).asString());
      target.removeMetadata(mcMMO.customNameKey, mcMMO.p);
    }

    if (target.hasMetadata(mcMMO.customVisibleKey)) {
      target.setCustomNameVisible(target.getMetadata(mcMMO.customVisibleKey).get(0).asBoolean());
      target.removeMetadata(mcMMO.customVisibleKey, mcMMO.p);
    }
  }
}
