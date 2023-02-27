package com.github.shiro8613.GetBadgeBot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandEvent extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("ping")) {
            event.reply("ぽんぐ").queue();
        }
    }
}
