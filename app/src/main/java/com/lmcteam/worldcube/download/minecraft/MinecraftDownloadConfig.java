package com.lmcteam.worldcube.download.minecraft;

import com.alibaba.fastjson.JSON;
import com.lmcteam.worldcube.download.DownloadConfig;
import com.lmcteam.worldcube.download.minecraft.assets.NecessaryAssets;
import com.lmcteam.worldcube.download.minecraft.beans.MinecraftAssetsObjects;
import com.lmcteam.worldcube.download.minecraft.beans.MinecraftVersionJsonBean;
import com.lmcteam.worldcube.download.minecraft.libraries.NecessaryLibraries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinecraftDownloadConfig {
    private String version;
    private String url;
    private String api;

    private MinecraftVersionJsonBean minecraftVersionJson;

    public static String TYPE_MOJANG = "mojang";
    public static String TYPE_MCBBS = "https://download.mcbbs.net/";
    public static String TYPE_BMCLAPI = "https://bmclapi2.bangbang93.com/";

    private MinecraftDownloadConfig(String version, String url, String api) {
        this.version = version;
        this.url = url;
        this.api = api;
        this.url = getCurrentUrl(this.url, api);
    }

    public static String getCurrentUrl(String source, String api) {
        if (!api.equals(TYPE_MOJANG) && !source.contains("https://libraries.minecraft.net/") && !source.contains("http://resources.download.minecraft.net/"))
            return source.replace("https://launchermeta.mojang.com/", api).replace("https://launcher.mojang.com/", api).replace("https://piston-meta.mojang.com/", api);
        else if (!api.equals(TYPE_MOJANG) && source.contains("http://resources.download.minecraft.net/"))
            return source.replace("http://resources.download.minecraft.net/", api + "assets");
        else if (!api.equals(TYPE_MOJANG) && source.contains("https://libraries.minecraft.net/"))
            return source.replace("https://libraries.minecraft.net/", api + "maven");
        return source;
    }

    public static MinecraftDownloadConfig create(String versionId, String versionUrl, String api) {
        return new MinecraftDownloadConfig(versionId, versionUrl, api);
    }

    public static MinecraftDownloadConfig create(String versionId, String versionUrl) {
        return create(versionId, versionUrl, TYPE_BMCLAPI);
    }

    public void parseVersionJson(String json) {
        minecraftVersionJson = JSON.parseObject(json, MinecraftVersionJsonBean.class);
    }

    public NecessaryLibraries getLibrariesDownloadUrl() {
        String finalPath = DownloadConfig.defaultDir + "libraries/";

        List<MinecraftDownloadable> libraries = new ArrayList<>();
        NecessaryLibraries necessary = new NecessaryLibraries();
        for (MinecraftVersionJsonBean.Libraries libs : minecraftVersionJson.getLibraries()) {
            MinecraftDownloadable downloadable = new MinecraftDownloadable();
            downloadable.setUrl(getCurrentUrl(libs.getDownloads().getArtifact().getUrl(), api));
            downloadable.setDestPath(finalPath + libs.getDownloads().getArtifact().getPath());
            libraries.add(downloadable);
        }
        necessary.setDownloadable(libraries);
        return necessary;
    }

    public String getAssetsIndex() {
        return minecraftVersionJson.getAssetIndex().getUrl();
    }

    public NecessaryAssets getAssetsDownloadUrl(String assetsIndexJson) {
        String finalPath = DownloadConfig.defaultDir + "assets/";
        NecessaryAssets assets = new NecessaryAssets();
        assets.setAssetsIndexUrl(getAssetsIndex());
        assets.setIndexPath(finalPath + "indexes/");
        List<MinecraftDownloadable> allAssets = new ArrayList<>();
        MinecraftAssetsObjects objects = JSON.parseObject(assetsIndexJson, MinecraftAssetsObjects.class);
        HashMap<String, MinecraftAssetsObjects.Inner> assetsObjects = objects.getObjects();
        while (assetsObjects.keySet().iterator().hasNext()) {
            String key = assetsObjects.keySet().iterator().next();
            MinecraftDownloadable downloadable = new MinecraftDownloadable();
            downloadable.setUrl(getCurrentUrl(getAssetDownloadUrl(assetsObjects.get(key).getHash()), api));
            downloadable.setDestPath(finalPath + "objects/" + getCurrentUrl(getAssetDownloadUrl(assetsObjects.get(key).getHash()), api).replace(api, ""));
            allAssets.add(downloadable);
        }
        assets.setAssetsDownloadable(allAssets);
        return assets;
    }

    public String getAssetDownloadUrl(String hash) {
        return "http://resources.download.minecraft.net/" + hash.split("|")[0] + hash.split("|")[1] + "/" + hash;
    }
    public ClientDownloadable getClientDownloadUrl() {
        String url = minecraftVersionJson.getDownloads().getClient().getUrl();

        ClientDownloadable downloadable = new ClientDownloadable();
        downloadable.setUrl(getCurrentUrl(minecraftVersionJson.getDownloads().getClient().getUrl(), api));
        downloadable.setDestPath(DownloadConfig.defaultDir + "versions/"+url.substring(url.lastIndexOf("/")+1).replace(".jar", "")+"/"+url.substring(url.lastIndexOf("/")+1));
        return downloadable;
    }
}
