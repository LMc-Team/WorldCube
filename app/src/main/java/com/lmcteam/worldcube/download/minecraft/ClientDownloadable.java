package com.lmcteam.worldcube.download.minecraft;

public class ClientDownloadable {
    private String url;
    private String destPath;
    private String hash;
    private long size;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getSize() {
        return size;
    }
}
