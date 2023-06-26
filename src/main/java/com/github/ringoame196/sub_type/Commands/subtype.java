package com.github.ringoame196.sub_type.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class subtype implements CommandExecutor , TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(ChatColor.YELLOW+"特に何もないようだ");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> tab = new ArrayList<>();  // ArrayList を使用した場合
        //プレイヤー以外は作動させない
        if (!(commandSender instanceof Player)) {return tab;}

        //プレイヤーを設定
        Player player = (Player) commandSender;

        //subコマンドが未設定だと実行しない
        if(strings.length==1){return null;}

        Player target = (Player) Bukkit.getPlayer(strings[0]);
        if(target==null)
        {
            player.sendTitle(ChatColor.RED+"エラー", "プレイヤーが見つかりませんでした",20,20,20);
            tab.add("プレイヤーが見つかりません");
            return tab;
        }
        else
        {
            tab.add(target.getName()+"と通信中");
        }
        //表示させる文字を決める
        StringBuilder title = new StringBuilder("<" + player.getName() + "> " + new StringBuilder(strings[1]));
        if(strings.length>=2)
        {
            for (int i = 2;i < strings.length;i++)
            {//複数対策
                title.append(" ").append(strings[i]);
            }
        }
        target.sendTitle(ChatColor.GOLD+"文字受信(/subtype)", title.toString(),20,20,20);
        return tab;
    }
}
