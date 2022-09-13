package fr.arcane.twitchroulette;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.philippheuer.events4j.core.EventManager;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.ITwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class TwitchRoulette extends JavaPlugin {

    public boolean automatic = true;
    public String rtype;
    private ITwitchClient twitchClient;

    @Override
    public void onEnable() {

        this.saveDefaultConfig();
        FileConfiguration config = getConfig();

        int minBits = config.getInt("bits_minimum");

        String token = config.getString("oauth_token");
        OAuth2Credential credential = StringUtils.isNotBlank(token) ? new OAuth2Credential("twitch", token) : null;


        EventManager eventManager = new EventManager();
        eventManager.autoDiscovery();


        twitchClient = TwitchClientBuilder.builder()
                .withClientId(config.getString("client_id"))
                .withClientSecret(config.getString("client_secret"))
                .withEnableChat(true)
                .withChatAccount(credential)
                .withEnableHelix(true)
                .withEnablePubSub(true)
                .withDefaultAuthToken(credential)
                .build();



            twitchClient.getChat().joinChannel("PokeDracoOff");
            twitchClient.getClientHelper().enableStreamEventListener("PokeDracoOff");
            twitchClient.getClientHelper().enableFollowEventListener("PokeDracoOff");

            twitchClient.getChat().joinChannel("MontanaBlack88");
            twitchClient.getClientHelper().enableStreamEventListener("MontanaBlack88");
            twitchClient.getClientHelper().enableFollowEventListener("MontanaBlack88");


        twitchClient.getEventManager().getEventHandler(SimpleEventHandler.class).registerListener(new TwitchRouletteEvent(this));
        twitchClient.getPubSub().listenForSubscriptionEvents(credential, "142111177");
        twitchClient.getPubSub().listenForChannelSubGiftsEvents(credential, "142111177");
        twitchClient.getPubSub().listenForCheerEvents(credential, "142111177");

        twitchClient.getPubSub().listenForSubscriptionEvents(credential, "45044816");
        twitchClient.getPubSub().listenForChannelSubGiftsEvents(credential, "45044816");
        twitchClient.getPubSub().listenForCheerEvents(credential, "45044816");
        getCommand("roulette").setExecutor(new RouletteCommand(this));

    }

    @Override
    public void onDisable() {
        if (twitchClient != null)
            twitchClient.close();

    }

    public ITwitchClient getTwitchClient() {
        return this.twitchClient;
    }


    public int getMinBits() {
        this.saveDefaultConfig();
        FileConfiguration config = getConfig();

        int minBits = config.getInt("bits_minimum");
        return minBits;
    }

    public boolean getAuto() {
        return automatic;
    }

    public void setAuto(boolean bool) {
        automatic = bool;
    }

    public String getRtype(){
        return rtype;
    }

    public void setRouletteType(String type) {
        rtype = type;
    }

}
