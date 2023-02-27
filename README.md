# GetBadgeBot

#Discordアクティブデベロッパーバッジを取得するためのBot

1. まず[GithubRelease](https://github.com/shiro8613/GetBadgeBot/releases)から最新の`GetBadgeBot.jar`を落とします。

2. 次に以下の通りに設定ファイルを作成します。

```json
{
  "token": "ここにBotのトークンを入力"
}
```

3. `settings.json`としてダウンロードしたJarと同じ場所に保存します。

4. 以下のコマンドで実行します。

```cmd
java -jar GetBadgeBot.jar settings.json
```

5. DiscordにBotを入れたらBotを作成したユーザーとは違うユーザーで`/ping`を実行します。すると`ぽんぐ`が帰ってきます。

6. 後は公式ドキュメントに従ってバッジを取得してください。
