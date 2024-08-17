package io.fabric8.kubeapitest.binary.repo;

public class ArchiveDescriptor {

  private final String version;
  private final String arch;
  private final String os;

  public ArchiveDescriptor(String version, String arch, String os) {
    this.version = version;
    this.arch = arch;
    this.os = os;
  }

  public String getVersion() {
    return version;
  }

  public String getArch() {
    return arch;
  }

  public String getOs() {
    return os;
  }
}
