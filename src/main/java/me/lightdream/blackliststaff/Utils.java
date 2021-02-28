package me.lightdream.blackliststaff;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> getBlackList(){
        try {
            Configuration configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(BlacklistStaff.INSTANCE.getDataFolder(), "BlackList.yml"));
            return configuration.getStringList("List");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setBlackList(List<String> list){
        Configuration configuration = null;
        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(BlacklistStaff.INSTANCE.getDataFolder(), "BlackList.yml"));
            configuration.set("List", list);
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, new File(BlacklistStaff.INSTANCE.getDataFolder(), "BlackList.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
