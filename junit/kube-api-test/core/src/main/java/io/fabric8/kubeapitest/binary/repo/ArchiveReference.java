package io.fabric8.kubeapitest.binary.repo;

public class ArchiveReference {

  private String selfLink;
  private String hash;

  public String getSelfLink() {
    return selfLink;
  }

  public void setSelfLink(String selfLink) {
    this.selfLink = selfLink;
  }

  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }
}
