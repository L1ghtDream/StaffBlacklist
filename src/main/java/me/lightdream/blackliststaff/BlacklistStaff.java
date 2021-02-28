package me.lightdream.blackliststaff;

import net.md_5.bungee.api.plugin.Plugin;

import java.util.List;

public final class BlacklistStaff extends Plugin {

    public static BlacklistStaff INSTANCE;

    private static List<String> blacklist;

    public static final String COMMAND_ALIASES = "bls,bl-s";
    public static final String PERMISSION = "gw.blacklist";

    @Override
    public void onEnable() {
        INSTANCE = this;

        blacklist = Utils.getBlackList();

        getProxy().getPluginManager().registerCommand(this, new Commands("blacklist-staff", PERMISSION, COMMAND_ALIASES.split(",")));
    }

    @Override
    public void onDisable() {
        Utils.setBlackList(blacklist);
    }

    public static String addBlackList(String s){
        if(blacklist.contains(s))
            return "Jucatorul " + s + " are deja blacklist";
        else
        {
            blacklist.add(s);
            return "Jucatorul " + s + " a primit blacklist";
        }

    }

    public static String removeBlackList(String s){
        if(blacklist.contains(s))
        {
            blacklist.remove(s);
            return "Blacklistul jucatorului " + s + " a fost scos";
        }
        else
            return "Jucatorul " + s + " nu are blacklist";

    }

    public static String checkBlackList(String s){
        if(blacklist.contains(s))
            return "Da";
        else
            return "Nu";
    }

    public static List<String> getBlacklist(){
        return blacklist;
    }
}
