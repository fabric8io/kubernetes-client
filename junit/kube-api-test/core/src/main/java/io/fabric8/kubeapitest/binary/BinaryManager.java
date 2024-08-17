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
package io.fabric8.kubeapitest.binary;

import io.fabric8.kubeapitest.KubeAPIServerConfig;
import io.fabric8.kubeapitest.KubeAPITestException;
import io.fabric8.kubeapitest.Utils;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.fabric8.kubeapitest.Utils.isWildcardVersion;

public class BinaryManager {

  public static final String BINARY_LIST_DIR = "k8s";

  private Binaries binaries;
  private final KubeAPIServerConfig config;
  private final BinaryDownloader downloader;
  private final OSInfo osInfo;

  public BinaryManager(KubeAPIServerConfig config) {
    this.config = config;
    this.osInfo = new OSInfo();
    this.downloader = new CloudStorageBinaryBinaryDownloader(config.getKubeAPITestDir(), osInfo);
  }

  public void initAndDownloadIfRequired() {
    Optional<File> maybeBinaryDir = findTargetBinariesIfAvailable();
    File binaryDir;
    if (maybeBinaryDir.isEmpty()) {
      if (config.isOfflineMode()) {
        throw new KubeAPITestException("Binaries cannot be found, and download is turned off");
      }
      binaryDir = downloadBinary();
    } else {
      binaryDir = maybeBinaryDir.orElseThrow();
    }
    initBinariesPojo(binaryDir);
  }

  private File downloadBinary() {
    if (config.getApiServerVersion().isEmpty()) {
      return downloader.downloadLatest();
    } else {
      String version = config.getApiServerVersion().orElseThrow();
      if (Utils.isWildcardVersion(version)) {
        return downloader.downloadLatestWildcard(version);
      } else {
        return downloader.download(version);
      }
    }
  }

  private void initBinariesPojo(File binaryDir) {
    this.binaries = new Binaries(new File(binaryDir, Binaries.ETCD_BINARY_NAME),
        new File(binaryDir, Binaries.API_SERVER_BINARY_NAME),
        new File(binaryDir, Binaries.KUBECTL_BINARY_NAME));
    if (!binaries.getApiServer().exists()) {
      throw new KubeAPITestException(
          "API Server binary not found at path:" + binaries.getApiServer().getPath());
    }
    if (!binaries.getKubectl().exists()) {
      throw new KubeAPITestException(
          "Kubectl binary not found at path:" + binaries.getKubectl().getPath());
    }
    if (!binaries.getEtcd().exists()) {
      throw new KubeAPITestException("Etcd binary not found at path:" + binaries.getEtcd().getPath());
    }
  }

  public Binaries binaries() {
    if (binaries == null) {
      throw new KubeAPITestException("Binaries not found.");
    }
    return binaries;
  }

  private Optional<File> findTargetBinariesIfAvailable() {
    var platformSuffix = Utils.platformSuffix(osInfo);
    var apiServerVersion = config.getApiServerVersion().orElse(null);
    if (apiServerVersion != null) {
      if (isWildcardVersion(apiServerVersion)) {
        var targetWildcardVersion = findLatestVersionForWildcard(apiServerVersion);
        if (targetWildcardVersion.isEmpty()) {
          return Optional.empty();
        } else {
          apiServerVersion = targetWildcardVersion.orElseThrow();
        }
      }
      var targetVersionDir = new File(config.getKubeAPITestDir(), BINARY_LIST_DIR
          + File.separator + apiServerVersion + platformSuffix);
      if (targetVersionDir.exists()) {
        return Optional.of(targetVersionDir);
      } else {
        return Optional.empty();
      }
    }
    File binariesListDir = new File(config.getKubeAPITestDir(), BINARY_LIST_DIR);
    var dirVersionList = listBinaryDirectories();
    if (dirVersionList.isEmpty()) {
      return Optional.empty();
    }
    String latest = Utils.getLatestVersion(dirVersionList) + platformSuffix;
    return Optional.of(new File(binariesListDir, latest));
  }

  private Optional<String> findLatestVersionForWildcard(String wildcardVersion) {
    var targetPrefix = Utils.wildcardToPrefix(wildcardVersion);
    var dirs = listBinaryDirectories();
    var filteredDirs = dirs.stream().filter(d -> d.startsWith(targetPrefix)).collect(Collectors.toList());
    if (filteredDirs.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(Utils.getLatestVersion(filteredDirs));
  }

  private List<String> listBinaryDirectories() {
    var platformSuffix = Utils.platformSuffix(osInfo);
    File binariesListDir = new File(config.getKubeAPITestDir(), BINARY_LIST_DIR);
    if (!binariesListDir.exists()) {
      return Collections.emptyList();
    }
    return Stream
        .of(binariesListDir.list((dir, name) -> name != null && name.endsWith(platformSuffix)))
        .map(s -> s.substring(0, s.indexOf(platformSuffix)))
        .collect(Collectors.toList());
  }

}
