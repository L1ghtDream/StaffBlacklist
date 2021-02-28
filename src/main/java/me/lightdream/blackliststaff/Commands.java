package me.lightdream.blackliststaff;

import net.md_5.bungee.Util;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class Commands extends Command {

    public Commands(String name, String permission, String... aliases) {
        super(name, permission, aliases);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(args.length >= 2){
            switch (args[0]) {
                case "add":
                    sender.sendMessage(BlacklistStaff.addBlackList(args[1]));
                    break;
                case "remove":
                    sender.sendMessage(BlacklistStaff.removeBlackList(args[1]));
                    break;
                case "check":
                    sender.sendMessage(BlacklistStaff.checkBlackList(args[1]));
                    break;
            }
        }
    }

}
