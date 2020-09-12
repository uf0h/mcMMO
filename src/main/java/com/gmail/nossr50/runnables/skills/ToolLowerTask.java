package com.gmail.nossr50.runnables.skills;

import com.gmail.nossr50.util.player.NotificationManager;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.nossr50.config.Config;
import com.gmail.nossr50.datatypes.player.McMMOPlayer;
import com.gmail.nossr50.datatypes.skills.ToolType;

public class ToolLowerTask extends BukkitRunnable {
  private McMMOPlayer mcMMOPlayer;
  private ToolType tool;

  public ToolLowerTask(McMMOPlayer mcMMOPlayer, ToolType tool) {
    this.mcMMOPlayer = mcMMOPlayer;
    this.tool = tool;
  }

  @Override
  public void run() {
    if (!mcMMOPlayer.getToolPreparationMode(tool)) {
      return;
    }

    mcMMOPlayer.setToolPreparationMode(tool, false);

    if (Config.getInstance().getAbilityMessagesEnabled()) {
      NotificationManager.sendPlayerActionBarMessage(mcMMOPlayer.getPlayer(), tool.getLowerTool());
    }
  }
}
