package io.fabric8.crd.generator;

import io.fabric8.crd.generator.visitor.ClassDependenciesVisitor;

import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class CRDGenerationInfo {

  static final CRDGenerationInfo EMPTY = new CRDGenerationInfo();
  private final Map<String, Map<String, CRDInfo>> crdNameToVersionToCRDInfoMap = new HashMap<>();

  public Map<String, CRDInfo> getCRDInfos(String crdName) {
    return crdNameToVersionToCRDInfoMap.get(crdName);
  }

  public Map<String, Map<String, CRDInfo>> getCRDDetailsPerNameAndVersion() {
    return crdNameToVersionToCRDInfoMap;
  }

  void add(String crdName, String version, URI fileURI) {
    crdNameToVersionToCRDInfoMap.computeIfAbsent(crdName, k -> new HashMap<>())
      .put(version, new CRDInfo(crdName, version, new File(fileURI).getAbsolutePath(), ClassDependenciesVisitor.getDependentClassesFromCRDName(crdName)));
  }

  public int numberOfGeneratedCRDs() {
    final int[] result = new int[1];
    crdNameToVersionToCRDInfoMap.forEach((k, v) -> result[0] += v.size());
    return result[0];
  }
}
