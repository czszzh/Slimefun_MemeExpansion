package me.czssj_.meme_expansion.Expansion.Utils;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class msgUtils 
{
    public static void sendActionBar(Player player, String msg) 
    {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg));
    }
}
