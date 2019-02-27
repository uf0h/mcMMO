package com.gmail.nossr50.commands.party;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.nossr50.datatypes.player.McMMOPlayer;
import com.gmail.nossr50.locale.LocaleLoader;
import com.gmail.nossr50.party.PartyManager;
import com.gmail.nossr50.util.player.UserManager;

public class PartyAcceptCommand implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    switch (args.length) {
      case 1:
        Player player = (Player) sender;
        McMMOPlayer mcMMOPlayer = UserManager.getPlayer(player);

        if (!mcMMOPlayer.hasPartyInvite()) {
          sender.sendMessage(LocaleLoader.getString("mcMMO.NoInvites"));
          return true;
        }

        // Changing parties
        if (!PartyManager.changeOrJoinParty(mcMMOPlayer, mcMMOPlayer.getPartyInvite().getName())) {
          return true;
        }

        PartyManager.joinInvitedParty(mcMMOPlayer);
        return true;

      default:
        sender.sendMessage(LocaleLoader.getString("Commands.Usage.1", "party", "accept"));
        return true;
    }
  }
}
