package io.fabric8.kubeapitest.binary;

public class GitHubBinaryIndex {

  private static final String BINARY_INDEX_URL = "https://raw.githubusercontent.com/kubernetes-sigs/controller-tools/HEAD/envtest-releases.yaml";

  




  public static class BinaryArchiveReference {
    private final String os;
    private final String arch;
    private final String version;

    public BinaryArchiveReference(String os, String arch, String version) {
      this.os = os;
      this.arch = arch;
      this.version = version;
    }

    public String getOs() {
      return os;
    }

    public String getArch() {
      return arch;
    }

    public String getVersion() {
      return version;
    }
  }

}
