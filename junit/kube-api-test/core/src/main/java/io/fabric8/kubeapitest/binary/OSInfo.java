package io.fabric8.kubeapitest.binary;

public class OSInfo {
  private final String os;
  private final String arch;

  public OSInfo() {
    final var osArch = System.getProperty("os.arch").toLowerCase();
    switch (osArch) {
      case "ppc64":
        arch = "ppc64le";
        break;
      case "aarch64":
        arch = "arm64";
        break;
      default:
        arch = "amd64";
    }

    final var os = System.getProperty("os.name").toLowerCase();
    if (os.contains("win")) {
      this.os = "windows";
    } else if (os.contains("mac")) {
      this.os = "darwin";
    } else {
      this.os = os;
    }
  }

  public String getOSName() {
    return os;
  }

  public String getOSArch() {
    return arch;
  }
}
