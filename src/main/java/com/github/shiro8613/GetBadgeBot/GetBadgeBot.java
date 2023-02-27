package com.github.shiro8613.GetBadgeBot;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.shiro8613.GetBadgeBot.commands.CommandEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class GetBadgeBot {

    public static void main(String[] args) throws IOException {

        String filePath = "";
        Config config = new Config();

        try {
            filePath = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("設定ファイルのパスを指定してください。");
            System.exit(1);
        }

        try {
            config = LoadConfig(Paths.get("./" + filePath));
        } catch (FileNotFoundException e) {
            System.err.println(filePath+"が見つかりません。");
            System.exit(1);
        }

        if(config.Token.isEmpty()) {
            System.err.println("tokenがセットされていません。");
            System.exit(1);
        }

        CommandEvent commandEvent = new CommandEvent();

        JDA jda = JDABuilder.createDefault(config.Token)
                .addEventListeners(commandEvent)
                .build();

        jda.updateCommands().addCommands(
                Commands.slash("ping", "ping飛ばしまーーす。")
        ).queue();

    }

    private static Config LoadConfig(Path path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json = objectMapper.readTree(path.toFile());

        Config config1 = new Config();
        config1.Token = json.get("token").asText();

        return config1;
    }
}
