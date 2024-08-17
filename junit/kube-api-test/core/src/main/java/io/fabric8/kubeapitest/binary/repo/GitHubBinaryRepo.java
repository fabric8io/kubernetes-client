package io.fabric8.kubeapitest.binary.repo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.fabric8.kubeapitest.KubeAPITestException;
import io.fabric8.kubeapitest.binary.OSInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GitHubBinaryRepo {

  private static final Logger log = LoggerFactory.getLogger(BinaryRepo.class);

  private static final String BINARY_INDEX_URL = "https://raw.githubusercontent.com/kubernetes-sigs/controller-tools/HEAD/envtest-releases.yaml";
  private static final ObjectMapper MAPPER = new ObjectMapper(new YAMLFactory());
  private static List<ArchiveDescriptor> objectNames;

  private final OSInfo osInfo;

  public GitHubBinaryRepo(OSInfo osInfo) {
    this.osInfo = osInfo;
  }

  public synchronized Stream<ArchiveDescriptor> listObjectNames() {
    try {
      if (objectNames == null) {
        var index = MAPPER.readValue(new URL(BINARY_INDEX_URL), GitHubIndex.class);
        objectNames = index.getReleases().values().stream().flatMap(v -> v.values().stream()).map(
            a -> mapSelfLinkToArchiveDescriptor(a.getSelfLink()))
            .collect(Collectors.toList());
      }
      return objectNames.stream();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  static ArchiveDescriptor mapSelfLinkToArchiveDescriptor(String selfLink) {
    var versionOsArch = selfLink.split("/")[8]
        .replace("envtest-v", "")
        .replace(".tar.gz", "")
        .split("-");

    return new ArchiveDescriptor(versionOsArch[0], versionOsArch[2], versionOsArch[1]);
  }

  public File downloadVersionToTempFile(String version) {
    try {
      String url = "https://github.com/kubernetes-sigs/controller-tools/releases/download/envtest-v" + version +
          "/envtest-v" + version + "-" + osInfo.getOSName() + "-" + osInfo.getOSArch() + ".tar.gz";

      File tempFile = File.createTempFile("kubebuilder-tools-" + version, ".tar.gz");
      log.debug("Downloading binary from url: {} to Temp file: {}", url, tempFile.getPath());
      copyURLToFile(url, tempFile);
      return tempFile;
    } catch (IOException e) {
      throw new KubeAPITestException(e);
    }
  }

  private void copyURLToFile(String url, File tempFile) throws IOException {
    try (InputStream in = new URL(url).openStream()) {
      Files.copy(in, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
  }
}
