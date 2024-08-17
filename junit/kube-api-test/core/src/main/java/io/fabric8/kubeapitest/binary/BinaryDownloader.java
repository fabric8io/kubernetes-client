package io.fabric8.kubeapitest.binary;

import java.io.File;

public interface BinaryDownloader {
  File download(String version);

  File downloadLatest();

  File downloadLatestWildcard(String wildcardVersion);

  String findLatestVersion();

  String findLatestOfWildcard(String wildcardVersion);
}
