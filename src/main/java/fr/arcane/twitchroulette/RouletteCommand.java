package fr.arcane.twitchroulette;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouletteCommand implements CommandExecutor {


    private TwitchRoulette plugin;




    public RouletteCommand(TwitchRoulette twitchRoulette) {
       this.plugin = twitchRoulette;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

            if (args.length == 0) {

                Bukkit.getServer().getOnlinePlayers().forEach(all -> {
                    all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&eVoici les roulettes que tu peux lancer (Clique dessus)"));
                    TextComponent bmessage = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&aLa Roulette Bonus"));
                    bmessage.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roulette bonus"));
                    all.spigot().sendMessage(bmessage);
                    TextComponent mmessage = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&cLa Roulette Malus"));
                    mmessage.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roulette malus"));
                    all.spigot().sendMessage(mmessage);
                    TextComponent midmessage = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&6La Roulette Générale"));
                    midmessage.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roulette middle"));
                    all.spigot().sendMessage(midmessage);
                    TextComponent cmessage = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&9La Roulette Custom"));
                    cmessage.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roulette custom"));
                    all.spigot().sendMessage(cmessage);
                });

            }
            if (args[0].equalsIgnoreCase("bonus")) {
                if (args.length == 1) {
                    Random r = new Random();
                    int c = r.nextInt(12);

                    for (Player all : Bukkit.getServer().getOnlinePlayers()) {


                        switch (c) {

                            case 0:
                                all.getInventory().addItem(new ItemStack(Material.FIREWORK_ROCKET, 20));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&dOuaaaa c'est de toute beauté"));
                                break;

                            case 1:
                                all.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 1));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&3Tout petit boost sah"));
                                break;

                            case 2:
                                all.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 16));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&aPetit Starter Pack"));
                                break;

                            case 3:
                                all.getInventory().addItem(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 5));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&9Mesdames et Messieurs, Le cheat"));
                                break;
                            case 4:
                                all.getInventory().addItem(new ItemStack(Material.TOTEM_OF_UNDYING, 1));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&6LEGENDS NEVER DIIIIE !!"));
                                break;
                            case 5:
                                all.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 15));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&6Heal toi mon reuf"));
                                break;
                            case 6:
                                all.getInventory().addItem(new ItemStack(Material.OAK_LOG, 24));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&2Sah quel Bucheron"));
                                break;
                            case 7:
                                all.getInventory().addItem(new ItemStack(Material.ELYTRA, 1));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&eGo plané sah"));
                                break;
                            case 8:
                                Bukkit.getWorld("world").setGameRule(GameRule.KEEP_INVENTORY, true);
                                Bukkit.getWorld("world_nether").setGameRule(GameRule.KEEP_INVENTORY, true);
                                Bukkit.getWorld("world_the_end").setGameRule(GameRule.KEEP_INVENTORY, true);
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&fMourir ? M'en fou"));
                                break;
                            case 9:
                                double basehealth = all.getHealthScale();
                                all.setHealthScale(basehealth + 10D);
                                all.setHealth(all.getHealth() + 10D);
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&eComme un Loup-Garou Blanc"));
                                break;
                            case 10:
                                all.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 6000, 5));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&9Prêt pour le nether"));
                                break;
                            case 11:
                                all.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 6000, 3));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&9GAS GAS GAS !!!"));
                                break;
                            default:
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4ERROR ! (relancez manuellement la roulette)"));
                                break;
                        }

                    }


                }
                if (args[1].equalsIgnoreCase("on")) {
                    plugin.setAuto(true);
                    plugin.setRouletteType(args[0]);
                }
                if (args[1].equalsIgnoreCase("off")) {
                    plugin.setAuto(false);

                }

            }
            if (args[0].equalsIgnoreCase("malus")) {
                if (args.length == 1) {

                    Random r = new Random();
                    int c = r.nextInt(12);

                    for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                        switch (c) {

                            case 0:
                                double basehealth = all.getHealthScale();
                                all.setHealthScale(basehealth - 10D);
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&eOh comment c'est nul"));
                                break;
                            case 1:
                                Inventory i = all.getInventory();
                                for (ItemStack inven : i.getContents()) {
                                    if (inven.getAmount() > 1) {
                                        double amount = inven.getAmount() / 2;
                                        int arround = (int) amount;
                                        inven.setAmount(arround);
                                    }
                                }
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&4J'ai perdu une moitié de moi la"));
                                break;
                            case 2:
                                Inventory inv = all.getInventory();
                                for (ItemStack item : inv.getContents()) {
                                    all.getInventory().remove(item);
                                    Item itemDropped = all.getWorld().dropItemNaturally(all.getLocation(), item);
                                    itemDropped.setPickupDelay(40);
                                }
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&4Un des Pires malus sah"));
                                break;
                            case 3:
                                all.damage(50);
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&4Ah bah ça c'est pas de chance"));
                                break;
                            case 4:
                                Random random = new Random();
                                int num = r.nextInt(9);
                                all.getInventory().setItem(num, new ItemStack(Material.AIR, 0));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&cOn espère que c'était pas la pioche hein"));
                                break;
                            case 5:
                                Location location = new Location(all.getWorld(), all.getLocation().getX(), all.getLocation().getY() + 30D, all.getLocation().getZ());
                                all.teleport(location);
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&ePetit Baptême de l'air"));
                                break;
                            case 6:
                                Location loc = all.getLocation().add(0, 20, 0);
                                List<Location> locs = new ArrayList<Location>();
                                for (int x = -2; x <= 2; x++) {
                                    for (int z = -2; z <= 2; z++) {
                                        locs.add(loc.add(x, 0, z));
                                    }
                                }
                                for (Location arrowSpot : locs) {
                                    arrowSpot.getWorld().spawnEntity(arrowSpot, EntityType.ARROW);
                                }
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&cAh des indiens"));
                                break;
                            case 7:
                                all.getWorld().createExplosion(all.getLocation(), 8f);
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&cEt ça fait Bim Bam Boum"));
                                break;
                            case 8:
                                all.sendTitle(ChatColor.translateAlternateColorCodes('&', "&4 +1 Chapeau maintenant"), null, 2, 20, 2);
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&0Plus très clair quoi"));
                                break;
                            case 9:
                                all.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1200, 2));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&0Plus très clair quoi"));
                                break;
                            case 10:
                                all.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1200, 2));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&aLa Bouffe de hier était pas fraiche..."));
                                break;
                            case 11:
                                all.getInventory().setHelmet(new ItemStack(Material.DIRT, 1));
                                all.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                                all.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                                all.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&6C'est mieux que rien en soit"));
                                break;
                            default:
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4ERROR ! (relancez manuellement la roulette)"));
                                break;
                        }
                    }


                }
                if (args[1].equalsIgnoreCase("on")) {
                    plugin.setAuto(true);
                    plugin.setRouletteType(args[0]);
                }
                if (args[1].equalsIgnoreCase("off")) {
                    plugin.setAuto(false);
                }


            }
            if (args[0].equalsIgnoreCase("middle")) {
                if (args.length == 1) {
                    Random r = new Random();
                    int c = r.nextInt(12);

                    for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                        switch (c) {
                            case 0:
                                Inventory i = all.getInventory();
                                for (ItemStack inven : i.getContents()) {
                                    if (inven.getAmount() > 1) {
                                        double amount = inven.getAmount() / 2;
                                        int arround = (int) amount;
                                        inven.setAmount(arround);
                                    }
                                }
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&4J'ai perdu une moitié de moi la"));
                                break;
                            case 1:
                                all.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1200, 2));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&0Plus très clair quoi"));
                                break;
                            case 2:
                                Bukkit.getWorld("world").setGameRule(GameRule.KEEP_INVENTORY, true);
                                Bukkit.getWorld("world_nether").setGameRule(GameRule.KEEP_INVENTORY, true);
                                Bukkit.getWorld("world_the_end").setGameRule(GameRule.KEEP_INVENTORY, true);
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&fMourir ? M'en fou"));
                                break;
                            case 3:
                                all.getInventory().addItem(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 5));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&9Mesdames et Messieurs, Le cheat"));
                                break;
                            case 4:
                                double basehealth = all.getHealthScale();
                                all.setHealthScale(basehealth + 10D);
                                all.setHealth(all.getHealth() + 10D);
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&eComme un Loup-Garou Blanc"));
                                break;
                            case 5:
                                all.getInventory().addItem(new ItemStack(Material.TOTEM_OF_UNDYING, 1));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&6LEGENDS NEVER DIIIIE !!"));
                                break;
                            case 6:
                                all.getInventory().setHelmet(new ItemStack(Material.DIRT, 1));
                                all.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                                all.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                                all.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&6C'est mieux que rien en soit"));
                                break;
                            case 7:
                                all.getWorld().createExplosion(all.getLocation(), 8f);
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&cEt ça fait Bim Bam Boum"));
                                break;
                            case 8:
                                all.damage(50);
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&4Ah bah ça c'est pas de chance"));
                                break;
                            case 9:
                                all.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 3));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&3petit boost sah"));
                                break;
                            case 10:
                                all.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 6000, 3));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&9GAS GAS GAS !!!"));
                                break;
                            case 11:
                                all.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1200, 2));
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&aLa Bouffe de hier était pas fraiche..."));
                                break;
                            default:
                                all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4ERROR ! (relancez manuellement la roulette)"));
                                break;

                        }

                    }
                    if (args[1].equalsIgnoreCase("on")) {
                        plugin.setAuto(true);
                        plugin.setRouletteType(args[0]);
                    }
                    if (args[1].equalsIgnoreCase("off")) {
                        plugin.setAuto(false);
                    }


                }
            }
                if (args[0].equalsIgnoreCase("custom")) {
                    if (args.length == 1) {
                        Random r = new Random();
                        int c = r.nextInt(11);

                        for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                            switch (c) {
                                case 0 :
                                    all.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 40, 6));
                                    all.getInventory().addItem(new ItemStack(Material.WATER_BUCKET, 1));
                                    all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&cOn a bien rigolé maintenant faut mlg"));
                                    break;
                                case 1 :
                                    all.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 3600, 2));
                                    all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&1Oh la flemme"));
                                    break;
                                case 2 :
                                    all.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 16));
                                    all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&6Littéralement mangé Gucci"));
                                    break;
                                case 3 :
                                    all.getLocation().getBlock().setType(Material.DIAMOND_BLOCK);
                                    all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&bArgent"));
                                    break;
                                case 4 :
                                    all.giveExpLevels(12);
                                    all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&2Pas mal d'expérience dans le metier oué"));
                                    break;
                                case 5 :
                                    all.getInventory().addItem(new ItemStack(Material.SHIELD, 1));
                                    all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&eHibibdi Hibidi Hop tu me vois plus je te bloque"));
                                    break;
                                case 6 :
                                    all.getWorld().spawnEntity(all.getLocation(), EntityType.CREEPER);
                                    all.getWorld().spawnEntity(all.getLocation(), EntityType.CREEPER);
                                    all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&cOulaaa..."));
                                    break;
                                case 7 :
                                    all.getWorld().spawnEntity(all.getLocation(), EntityType.HORSE);
                                    all.getInventory().addItem(new ItemStack(Material.SADDLE,1));
                                    all.getInventory().addItem(new ItemStack(Material.GOLDEN_HORSE_ARMOR,1));
                                    all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&aAu Galop Chacal"));
                                    break;
                                case 8 :
                                    all.kickPlayer("Tu as été Kick par la roulette");
                                    all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&8Ca dégage"));
                                    break;
                                case 9 :
                                    all.setFireTicks(100);
                                    all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&6Tu t'enflammes un peu la"));
                                    break;
                                case 10 :
                                    Random w = new Random();
                                    int wo = w.nextInt(3);
                                    if (wo == 0) {
                                        Location location = all.getLocation();
                                        Location finalloc = new Location(Bukkit.getWorld("world_nether"), location.getX(), 70,location.getZ());
                                        all.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 35));
                                    }
                                    if (wo == 1) {
                                        Location location = all.getLocation();
                                        Location finalloc = new Location(Bukkit.getWorld("world_the_end"), 0,80,0);
                                        all.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 35));
                                    }
                                    if (wo == 2) {
                                        Location location = all.getLocation();
                                        Location finalloc = new Location(Bukkit.getWorld("world"), location.getX(), 90,location.getZ());
                                        all.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000, 35));
                                    }
                                    all.sendMessage(ChatColor.translateAlternateColorCodes('&', "&l&d[&5TwitchRoulette&d]&r &l&eA travers les dimensions !!"));

                                    break;
                                default :
                                    ChatColor.translateAlternateColorCodes('&', "&4ERROR ! (relancez manuellement la roulette)");
                                    break;

                            }
                        }
                    }
                    if (args[1].equalsIgnoreCase("on")) {
                        plugin.setAuto(true);
                        plugin.setRouletteType(args[0]);
                    }
                    if (args[1].equalsIgnoreCase("off")) {
                        plugin.setAuto(false);
                    }


                }


            return true;


    }

}
