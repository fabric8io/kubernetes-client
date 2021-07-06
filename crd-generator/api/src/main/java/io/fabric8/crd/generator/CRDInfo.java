package io.fabric8.crd.generator;

import java.util.Set;

public class CRDInfo {
  private final String crdName;
  private final String version;
  private final String filePath;
  private final Set<String> dependentClassNames;

  public CRDInfo(String crdName, String version, String filePath, Set<String> dependentClassNames) {
    this.crdName = crdName;
    this.version = version;
    this.filePath = filePath;
    this.dependentClassNames = dependentClassNames;
  }

  public String getCrdName() {
    return crdName;
  }

  public String getVersion() {
    return version;
  }

  public String getFilePath() {
    return filePath;
  }

  public Set<String> getDependentClassNames() {
    return dependentClassNames;
  }
}
