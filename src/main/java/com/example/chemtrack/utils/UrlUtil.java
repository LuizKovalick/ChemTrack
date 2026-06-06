package com.example.chemtrack.utils;

public class UrlUtil {
// serve para arrumar os links do youtube
    public static String extractVideoId(String youtubeUrl) {
        if (youtubeUrl == null || !youtubeUrl.contains("v=")) {
            return null;
        }
        int startIndex = youtubeUrl.indexOf("v=") + 2;
        int endIndex = youtubeUrl.indexOf("&", startIndex);
        if (endIndex == -1) {
            return youtubeUrl.substring(startIndex);
        }
        return youtubeUrl.substring(startIndex, endIndex);
    }
}