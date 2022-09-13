package fr.arcane.twitchroulette;

import com.github.philippheuer.events4j.simple.domain.EventSubscriber;
import com.github.twitch4j.chat.events.channel.*;
import com.github.twitch4j.pubsub.events.RewardRedeemedEvent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TwitchRouletteEvent {

    private TwitchRoulette plugin;


    public TwitchRouletteEvent(TwitchRoulette plugin) {
        this.plugin = plugin;
    }





    @EventSubscriber
    public void CheerEvent(CheerEvent event) {
        if (event.getBits() >= plugin.getMinBits()) {
            if (!plugin.getAuto()) {
                TextComponent message = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&d &l> &e" + event.getUser().getName() + "&r &d a donné &e &l" + event.getBits().toString() + "Bits &d<") );
                message.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/roulette" ) );
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    if (all.isOp()) {
                        all.spigot().sendMessage(message);
                    }
                }
            }
            if (plugin.getAuto()) {
                String type = plugin.getRtype();
                if (type == "bonus") {
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette bonus");
                }
                if (type == "malus") {
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette malus");
                }
                if (type == "middle") {
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette middle");
                }
                if (type == "custom") {
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette custom");
                }
            }
        }
    }




    @EventSubscriber
    public void SubscribeEvent(SubscriptionEvent event) {
        if (!plugin.getAuto()) {
            TextComponent message = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&d &l> &e" + event.getUser().getName() + "&r &d a &e &lSub &d<") );
            message.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/roulette" ) );
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                if (all.isOp()) {
                    all.spigot().sendMessage(message);
                }
            }
        }
        if (plugin.getAuto()) {
            String type = plugin.getRtype();
            if (type == "bonus") {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette bonus");
            }
            if (type == "malus") {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette malus");
            }
            if (type == "middle") {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette middle");
            }
            if (type == "custom") {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette custom");
            }
        }
    }
    @EventSubscriber
    public void SubscribeEvent(GiftSubscriptionsEvent event) {
        if (!plugin.getAuto()) {
            TextComponent message = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&d &l> &e" + event.getUser().getName() + "&r &d a &e &lSub &d<") );
            message.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/roulette" ) );
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                if (all.isOp()) {
                    all.spigot().sendMessage(message);
                }
            }
        }
        if (plugin.getAuto()) {
            String type = plugin.getRtype();
            if (type == "bonus") {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette bonus");
            }
            if (type == "malus") {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette malus");
            }
            if (type == "middle") {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette middle");
            }
            if (type == "custom") {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette custom");
            }
        }
    }

    @EventSubscriber
    public void SubscribeEvent(PrimeSubUpgradeEvent event) {
        if (!plugin.getAuto()) {
            TextComponent message = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&d &l> &e" + event.getUser().getName() + "&r &d a &e &lSub &d<") );
            message.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/roulette" ) );
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                if (all.isOp()) {
                    all.spigot().sendMessage(message);
                }
            }
        }
        if (plugin.getAuto()) {
            String type = plugin.getRtype();
            if (type == "bonus") {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette bonus");
            }
            if (type == "malus") {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette malus");
            }
            if (type == "middle") {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette middle");
            }
            if (type == "custom") {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"/roulette custom");
            }
        }
    }


}
