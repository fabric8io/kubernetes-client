package io.fabric8.kubeapitest.binary.repo;

import java.util.Map;

public class GitHubIndex {

  private Map<String, Map<String, ArchiveReference>> releases;

  public Map<String, Map<String, ArchiveReference>> getReleases() {
    return releases;
  }

  public void setReleases(Map<String, Map<String, ArchiveReference>> releases) {
    this.releases = releases;
  }
}
