package io.javaoperatorsdk.jenvtest.binary;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.javaoperatorsdk.jenvtest.JenvtestException;
import io.javaoperatorsdk.jenvtest.KubeAPIServerConfig;
import io.javaoperatorsdk.jenvtest.Utils;

import static io.javaoperatorsdk.jenvtest.Utils.isWildcardVersion;

public class BinaryManager {

  public static final String BINARY_LIST_DIR = "k8s";

  private Binaries binaries;
  private final KubeAPIServerConfig config;
  private final BinaryDownloader downloader;
  private final OSInfo osInfo;

  public BinaryManager(KubeAPIServerConfig config) {
    this.config = config;
    this.osInfo = new OSInfo();
    this.downloader = new BinaryDownloader(config.getJenvtestDir(), osInfo);
  }

  public void initAndDownloadIfRequired() {
    Optional<File> maybeBinaryDir = findTargetBinariesIfAvailable();
    File binaryDir;
    if (maybeBinaryDir.isEmpty()) {
      if (config.isOfflineMode()) {
        throw new JenvtestException("Binaries cannot be found, and download is turned off");
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
      throw new JenvtestException(
          "API Server binary not found at path:" + binaries.getApiServer().getPath());
    }
    if (!binaries.getKubectl().exists()) {
      throw new JenvtestException(
          "Kubectl binary not found at path:" + binaries.getKubectl().getPath());
    }
    if (!binaries.getEtcd().exists()) {
      throw new JenvtestException("Etcd binary not found at path:" + binaries.getEtcd().getPath());
    }
  }

  public Binaries binaries() {
    if (binaries == null) {
      throw new JenvtestException("Binaries not found.");
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
      var targetVersionDir = new File(config.getJenvtestDir(), BINARY_LIST_DIR
          + File.separator + apiServerVersion + platformSuffix);
      if (targetVersionDir.exists()) {
        return Optional.of(targetVersionDir);
      } else {
        return Optional.empty();
      }
    }
    File binariesListDir = new File(config.getJenvtestDir(), BINARY_LIST_DIR);
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
    var filteredDirs =
        dirs.stream().filter(d -> d.startsWith(targetPrefix)).collect(Collectors.toList());
    if (filteredDirs.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(Utils.getLatestVersion(filteredDirs));
  }

  private List<String> listBinaryDirectories() {
    var platformSuffix = Utils.platformSuffix(osInfo);
    File binariesListDir = new File(config.getJenvtestDir(), BINARY_LIST_DIR);
    if (!binariesListDir.exists()) {
      return Collections.emptyList();
    }
    return Stream
        .of(binariesListDir.list((dir, name) -> name != null && name.endsWith(platformSuffix)))
        .map(s -> s.substring(0, s.indexOf(platformSuffix)))
        .collect(Collectors.toList());
  }


}
