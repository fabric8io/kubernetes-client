/*
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.crd.generator;

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
        .put(version, new CRDInfo(crdName, version, new File(fileURI).getAbsolutePath()));
  }

  public int numberOfGeneratedCRDs() {
    return crdNameToVersionToCRDInfoMap.values().stream().map(Map::size).reduce(Integer::sum).orElse(0);
  }
}
