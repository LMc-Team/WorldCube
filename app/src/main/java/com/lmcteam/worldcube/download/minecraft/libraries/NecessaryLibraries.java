package com.lmcteam.worldcube.download.minecraft.libraries;
import com.lmcteam.worldcube.download.minecraft.MinecraftDownloadable;
import java.util.List;

public class NecessaryLibraries {
	private List<MinecraftDownloadable> downloadable;


	public void setDownloadable(List<MinecraftDownloadable> downloadable) {
		this.downloadable = downloadable;
	}

	public List<MinecraftDownloadable> getDownloadable() {
		return downloadable;
	}
}
