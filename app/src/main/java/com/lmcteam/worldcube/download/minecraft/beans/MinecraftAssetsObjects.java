package com.lmcteam.worldcube.download.minecraft.beans;

import java.util.HashMap;

public class MinecraftAssetsObjects 
{
	
	public HashMap<String,Inner> objects;

	public void setObjects(HashMap<String, Inner> objects) {
		this.objects = objects;
	}

	public HashMap<String, Inner> getObjects() {
		return objects;
	}
	
	public static class Inner {
		String hash;
		long size;

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
}
