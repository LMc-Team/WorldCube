package com.lmcteam.worldcube.download.minecraft.assets;
import com.lmcteam.worldcube.download.minecraft.MinecraftDownloadable;
import java.util.List;

public class NecessaryAssets {
	private String assetsIndexUrl;
	private String indexPath;
	private List<MinecraftDownloadable> assetsDownloadable;

	public void setIndexPath(String indexPath) {
		this.indexPath = indexPath;
	}

	public String getIndexPath() {
		return indexPath;
	}

	public void setAssetsIndexUrl(String assetsIndexUrl) {
		this.assetsIndexUrl = assetsIndexUrl;
	}

	public String getAssetsIndexUrl() {
		return assetsIndexUrl;
	}

	public void setAssetsDownloadable(List<MinecraftDownloadable> assetsDownloadable) {
		this.assetsDownloadable = assetsDownloadable;
	}

	public List<MinecraftDownloadable> getAssetsDownloadable() {
		return assetsDownloadable;
	}

}
