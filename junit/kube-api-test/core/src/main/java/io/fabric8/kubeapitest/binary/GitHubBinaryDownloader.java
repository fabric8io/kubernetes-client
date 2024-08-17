package io.fabric8.kubeapitest.binary;

import java.io.File;

public class GitHubBinaryDownloader implements BinaryDownloader {


  @Override
  public File download(String version) {


    return null;
  }

  @Override
  public File downloadLatest() {
    return null;
  }

  @Override
  public File downloadLatestWildcard(String wildcardVersion) {
    return null;
  }

  @Override
  public String findLatestVersion() {
    return "";
  }

  @Override
  public String findLatestOfWildcard(String wildcardVersion) {
    return "";
  }
}
