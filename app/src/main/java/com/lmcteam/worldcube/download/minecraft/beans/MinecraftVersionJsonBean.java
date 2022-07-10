package com.lmcteam.worldcube.download.minecraft.beans;

import java.util.List;

public class MinecraftVersionJsonBean {
    private AssetIndex assetIndex;

    private String assets;

    private int complianceLevel;

    private Downloads downloads;

    private String id;

    private JavaVersion javaVersion;

    private List<Libraries> libraries;

    private Logging logging;

    private String mainClass;

    private String minecraftArguments;

    private int minimumLauncherVersion;

    private String releaseTime;

    private String time;

    private String type;

    public void setAssetIndex(AssetIndex assetIndex) {
        this.assetIndex = assetIndex;
    }

    public AssetIndex getAssetIndex() {
        return assetIndex;
    }

    public void setAssets(String assets) {
        this.assets = assets;
    }

    public String getAssets() {
        return assets;
    }

    public void setComplianceLevel(int complianceLevel) {
        this.complianceLevel = complianceLevel;
    }

    public int getComplianceLevel() {
        return complianceLevel;
    }

    public void setDownloads(Downloads downloads) {
        this.downloads = downloads;
    }

    public Downloads getDownloads() {
        return downloads;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setJavaVersion(JavaVersion javaVersion) {
        this.javaVersion = javaVersion;
    }

    public JavaVersion getJavaVersion() {
        return javaVersion;
    }

    public void setLibraries(List<Libraries> libraries) {
        this.libraries = libraries;
    }

    public List<Libraries> getLibraries() {
        return libraries;
    }

    public void setLogging(Logging logging) {
        this.logging = logging;
    }

    public Logging getLogging() {
        return logging;
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    public String getMainClass() {
        return mainClass;
    }

    public void setMinecraftArguments(String minecraftArguments) {
        this.minecraftArguments = minecraftArguments;
    }

    public String getMinecraftArguments() {
        return minecraftArguments;
    }

    public void setMinimumLauncherVersion(int minimumLauncherVersion) {
        this.minimumLauncherVersion = minimumLauncherVersion;
    }

    public int getMinimumLauncherVersion() {
        return minimumLauncherVersion;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static class AssetIndex {

        private String id;

        private String sha1;

        private int size;

        private int totalSize;

        private String url;

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setSha1(String sha1) {
            this.sha1 = sha1;
        }

        public String getSha1() {
            return sha1;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }

        public void setTotalSize(int totalSize) {
            this.totalSize = totalSize;
        }

        public int getTotalSize() {
            return totalSize;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

    }

    public static class Downloads {

        private Client client;

        private Server server;

        private Windows_server windows_server;

        public void setClient(Client client) {
            this.client = client;
        }

        public Client getClient() {
            return client;
        }

        public void setServer(Server server) {
            this.server = server;
        }

        public Server getServer() {
            return server;
        }

        public void setWindows_server(Windows_server windows_server) {
            this.windows_server = windows_server;
        }

        public Windows_server getWindows_server() {
            return windows_server;
        }

        public static class Client {

            private String sha1;

            private int size;

            private String url;

            public void setSha1(String sha1) {
                this.sha1 = sha1;
            }

            public String getSha1() {
                return sha1;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getSize() {
                return size;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUrl() {
                return url;
            }

        }

        public static class Server {

            private String sha1;

            private int size;

            private String url;

            public void setSha1(String sha1) {
                this.sha1 = sha1;
            }

            public String getSha1() {
                return sha1;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getSize() {
                return size;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUrl() {
                return url;
            }

        }

        public static class Windows_server {

            private String sha1;

            private int size;

            private String url;

            public void setSha1(String sha1) {
                this.sha1 = sha1;
            }

            public String getSha1() {
                return sha1;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getSize() {
                return size;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUrl() {
                return url;
            }

        }

    }

    public static class JavaVersion {

        private String component;

        private int majorVersion;

        public void setComponent(String component) {
            this.component = component;
        }

        public String getComponent() {
            return component;
        }

        public void setMajorVersion(int majorVersion) {
            this.majorVersion = majorVersion;
        }

        public int getMajorVersion() {
            return majorVersion;
        }

    }

    public static class Libraries {

        private Downloads downloads;

        private String name;

        public void setDownloads(Downloads downloads) {
            this.downloads = downloads;
        }

        public Downloads getDownloads() {
            return downloads;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static class Downloads {

            private Artifact artifact;

            public void setArtifact(Artifact artifact) {
                this.artifact = artifact;
            }

            public Artifact getArtifact() {
                return artifact;
            }

            public static class Artifact {

                private String path;

                private String sha1;

                private int size;

                private String url;

                public void setPath(String path) {
                    this.path = path;
                }

                public String getPath() {
                    return path;
                }

                public void setSha1(String sha1) {
                    this.sha1 = sha1;
                }

                public String getSha1() {
                    return sha1;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public int getSize() {
                    return size;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getUrl() {
                    return url;
                }

            }

        }

    }

    public static class Logging {

        private Client client;

        public void setClient(Client client) {
            this.client = client;
        }

        public Client getClient() {
            return client;
        }

        public static class Client {

            private String argument;

            private File file;

            private String type;

            public void setArgument(String argument) {
                this.argument = argument;
            }

            public String getArgument() {
                return argument;
            }

            public void setFile(File file) {
                this.file = file;
            }

            public File getFile() {
                return file;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getType() {
                return type;
            }

            public static class File {

                private String id;

                private String sha1;

                private int size;

                private String url;

                public void setId(String id) {
                    this.id = id;
                }

                public String getId() {
                    return id;
                }

                public void setSha1(String sha1) {
                    this.sha1 = sha1;
                }

                public String getSha1() {
                    return sha1;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public int getSize() {
                    return size;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getUrl() {
                    return url;
                }

            }

        }

    }
}
