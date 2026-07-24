/*
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubeapitest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class KubeAPIServerConfigBuilder {

  // environment variables
  public static final String KUBE_API_TEST_OFFLINE_MODE = "KUBE_API_TEST_OFFLINE_MODE";
  public static final String KUBE_API_TEST_DIR = "KUBE_API_TEST_DIR";
  public static final String KUBE_API_TEST_API_SERVER_VERSION = "KUBE_API_TEST_API_SERVER_VERSION";
  public static final String KUBE_API_TEST_WAIT_FOR_ETCD_HEALTH_CHECK = "KUBE_API_TEST_WAIT_FOR_ETCD_HEALTH_CHECK";
  public static final String KUBE_API_TEST_STARTUP_TIMEOUT = "KUBE_API_TEST_STARTUP_TIMEOUT";

  public static final String DIRECTORY_NAME = ".kubeapitest";

  private final List<String> apiServerFlags = new ArrayList<>(0);
  private boolean updateKubeConfig = false;

  private String apiTestDir;
  private String apiServerVersion;
  private Boolean offlineMode;
  private Boolean waitForEtcdHealthCheckOnStartup;
  private Integer startupTimeout;

  public KubeAPIServerConfigBuilder() {
  }

  public static KubeAPIServerConfigBuilder anAPIServerConfig() {
    return new KubeAPIServerConfigBuilder();
  }

  public KubeAPIServerConfigBuilder withTestDir(String apiTestDir) {
    this.apiTestDir = apiTestDir;
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
    this.apiTestDir = finalConfigValue(this.apiTestDir, KUBE_API_TEST_DIR,
        new File(System.getProperty("user.home"), DIRECTORY_NAME).getPath());
    this.offlineMode = finalConfigValue(this.offlineMode, KUBE_API_TEST_OFFLINE_MODE, false);
    this.apiServerVersion = finalConfigValue(this.apiServerVersion, KUBE_API_TEST_API_SERVER_VERSION, null);
    this.waitForEtcdHealthCheckOnStartup = finalConfigValue(this.waitForEtcdHealthCheckOnStartup,
        KUBE_API_TEST_WAIT_FOR_ETCD_HEALTH_CHECK, false);
    // 120s: idle startup ~2.6s scales ~20× under -T 1C CI contention (#7807)
    this.startupTimeout = finalConfigValue(this.startupTimeout, KUBE_API_TEST_STARTUP_TIMEOUT, 120_000);

    return new KubeAPIServerConfig(apiTestDir, apiServerVersion, offlineMode, apiServerFlags,
        updateKubeConfig, waitForEtcdHealthCheckOnStartup, startupTimeout);
  }

  private String finalConfigValue(String currentValue, String envVariable, String defaultValue) {
    if (currentValue != null) {
      return currentValue;
    }
    String envValue = System.getenv(envVariable);
    return envValue != null ? envValue : defaultValue;
  }

  private Boolean finalConfigValue(Boolean currentValue, String envVariable, Boolean defaultValue) {
    if (currentValue != null) {
      return currentValue;
    }
    String envValue = System.getenv(envVariable);
    if (envValue == null) {
      return defaultValue;
    }
    if (!"true".equalsIgnoreCase(envValue) && !"false".equalsIgnoreCase(envValue)) {
      throw new KubeAPITestException(
          "Cannot parse environment variable " + envVariable + " value '" + envValue
              + "' as Boolean (expected 'true' or 'false')");
    }
    return parseEnvValue(Boolean.class, envValue);
  }

  private Integer finalConfigValue(Integer currentValue, String envVariable, Integer defaultValue) {
    if (currentValue != null) {
      return currentValue;
    }
    String envValue = System.getenv(envVariable);
    if (envValue == null) {
      return defaultValue;
    }
    try {
      return parseEnvValue(Integer.class, envValue);
    } catch (NumberFormatException e) {
      throw new KubeAPITestException(
          "Cannot parse environment variable " + envVariable + " value '" + envValue + "' as Integer", e);
    }
  }

  @SuppressWarnings("unchecked")
  static <T> T parseEnvValue(Class<T> type, String envValue) {
    if (type == Integer.class) {
      return (T) Integer.valueOf(envValue);
    } else if (type == Boolean.class) {
      return (T) Boolean.valueOf(envValue);
    } else if (type == String.class) {
      return type.cast(envValue);
    }
    throw new IllegalArgumentException("Unsupported type for environment variable parsing: " + type);
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
      throw new KubeAPITestException(
          "Kube API Server flag needs to start with double dash: '--'; Instead found key: " + key);
    }
  }
}
