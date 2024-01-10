package io.javaoperatorsdk.jenvtest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class KubeAPIServerConfigBuilder {

  // environment variables
  public static final String JENVTEST_OFFLINE_MODE = "JENVTEST_OFFLINE_MODE";
  public static final String JENVTEST_DIR = "JENVTEST_DIR";
  public static final String JENVTEST_KUBE_API_SERVER_VERSION = "JENVTEST_KUBE_API_SERVER_VERSION";
  public static final String JENVTEST_WAIT_FOR_ETCD_HEALTH_CHECK =
      "JENVTEST_WAIT_FOR_ETCD_HEALTH_CHECK";
  public static final String JENVTEST_STARTUP_TIMEOUT = "JENVTEST_STARTUP_TIMEOUT";

  public static final String DIRECTORY_NAME = ".jenvtest";

  private final List<String> apiServerFlags = new ArrayList<>(0);
  private boolean updateKubeConfig = false;

  private String jenvtestDir;
  private String apiServerVersion;
  private Boolean offlineMode;
  private Boolean waitForEtcdHealthCheckOnStartup;
  private Integer startupTimeout;

  public KubeAPIServerConfigBuilder() {}

  public static KubeAPIServerConfigBuilder anAPIServerConfig() {
    return new KubeAPIServerConfigBuilder();
  }

  public KubeAPIServerConfigBuilder withJenvtestDir(String jenvtestDir) {
    this.jenvtestDir = jenvtestDir;
    return this;
  }

  public KubeAPIServerConfigBuilder withApiServerVersion(String apiServerVersion) {
    this.apiServerVersion = apiServerVersion;
    return this;
  }

  public KubeAPIServerConfigBuilder withOfflineMode(boolean downloadBinaries) {
    this.offlineMode = downloadBinaries;
    return this;
  }

  public KubeAPIServerConfig build() {
    this.jenvtestDir = finalConfigValue(this.jenvtestDir, JENVTEST_DIR,
        new File(System.getProperty("user.home"), DIRECTORY_NAME).getPath());
    this.offlineMode = finalConfigValue(this.offlineMode, JENVTEST_OFFLINE_MODE, false);
    this.apiServerVersion =
        finalConfigValue(this.apiServerVersion, JENVTEST_KUBE_API_SERVER_VERSION, null);
    this.waitForEtcdHealthCheckOnStartup = finalConfigValue(this.waitForEtcdHealthCheckOnStartup,
        JENVTEST_WAIT_FOR_ETCD_HEALTH_CHECK, false);
    this.startupTimeout = finalConfigValue(this.startupTimeout, JENVTEST_STARTUP_TIMEOUT, 60_000);

    return new KubeAPIServerConfig(jenvtestDir, apiServerVersion, offlineMode, apiServerFlags,
        updateKubeConfig, waitForEtcdHealthCheckOnStartup, startupTimeout);
  }

  private String finalConfigValue(String currentValue, String envVariable, String defaultValue) {
    return finalConfigValue(String.class, currentValue, envVariable, defaultValue);
  }

  private Boolean finalConfigValue(Boolean currentValue, String envVariable, Boolean defaultValue) {
    return finalConfigValue(Boolean.class, currentValue, envVariable, defaultValue);
  }

  private Integer finalConfigValue(Integer currentValue, String envVariable, Integer defaultValue) {
    return finalConfigValue(Integer.class, currentValue, envVariable, defaultValue);
  }

  private <T> T finalConfigValue(Class<T> type, T currentValue, String envVariable,
      T defaultValue) {
    if (currentValue != null) {
      return currentValue;
    }
    var envValue = System.getenv(envVariable);
    if (envValue != null) {
      return type.cast(envValue);
    } else {
      return defaultValue;
    }
  }

  public KubeAPIServerConfigBuilder withUpdateKubeConfig(boolean updateKubeConfig) {
    this.updateKubeConfig = updateKubeConfig;
    return this;
  }

  public KubeAPIServerConfigBuilder withApiServerFlags(List<String> flags) {
    apiServerFlags.addAll(flags);
    return this;
  }

  public KubeAPIServerConfigBuilder withApiServerFlag(String key, String value) {
    checkKeyPrefix(key);
    apiServerFlags.add(key);
    apiServerFlags.add(value);
    return this;
  }

  public KubeAPIServerConfigBuilder withApiServerFlag(String key) {
    checkKeyPrefix(key);
    apiServerFlags.add(key);
    return this;
  }

  public KubeAPIServerConfigBuilder withStartupTimeout(Integer startupTimeout) {
    this.startupTimeout = startupTimeout;
    return this;
  }

  public KubeAPIServerConfigBuilder withWaitForEtcdHealthCheckOnStartup(
      boolean waitForEtcdHealthCheckOnStartup) {
    this.waitForEtcdHealthCheckOnStartup = waitForEtcdHealthCheckOnStartup;
    return this;
  }

  private void checkKeyPrefix(String key) {
    if (!key.startsWith("--")) {
      throw new JenvtestException(
          "Kube API Server flag needs to start with double dash: '--'; Instead found key: " + key);
    }
  }
}
