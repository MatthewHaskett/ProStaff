package me.enderaura.prostaff.common.text;

import org.bukkit.ChatColor;

/**
 * @author Enderaura
 * @since 24/11/2017 17:02.
 */
public enum Text {

    UTIL;

    public String centerTitle(String title) {
        String spacer = "";
        int spaces = 27 - ChatColor.stripColor(title).length();
        for (int i = 0; i < spaces; i++) {
            spacer += " ";
        }
        return spacer + title;
    }

    public String getProgressBar(int current, int max, int totalBars, String symbol, String completedColor, String notCompletedColor){

        float percent = (float) current / max;

        int progressBars = (int) ((int) totalBars * percent);

        int leftOver = (totalBars - progressBars);

        StringBuilder sb = new StringBuilder();
        sb.append(ChatColor.translateAlternateColorCodes('&', completedColor));
        for (int i = 0; i < progressBars; i++) {
            sb.append(symbol);
        }
        sb.append(ChatColor.translateAlternateColorCodes('&', notCompletedColor));
        for (int i = 0; i < leftOver; i++) {
            sb.append(symbol);
        }
        return sb.toString();
    }

}
