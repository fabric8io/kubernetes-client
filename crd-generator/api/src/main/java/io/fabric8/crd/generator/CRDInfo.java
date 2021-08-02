/**
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

import java.util.Set;

public class CRDInfo {
  private final String crdName;
  private final String crdSpecVersion;
  private final String filePath;
  private final Set<String> dependentClassNames;
  private final String crClassName;
  private final String specClassName;
  private final String statusClassName;

  public CRDInfo(String crdName, String crdSpecVersion, String crClassName, String specClassName, String statusClassName, String filePath, Set<String> dependentClassNames) {
    this.crdName = crdName;
    this.crdSpecVersion = crdSpecVersion;
    this.crClassName = crClassName;
    this.specClassName = specClassName;
    this.statusClassName = statusClassName;
    this.filePath = filePath;
    this.dependentClassNames = dependentClassNames;
  }

  public String getCrClassName() {
    return crClassName;
  }

  public String getSpecClassName() {
    return specClassName;
  }

  public String getStatusClassName() {
    return statusClassName;
  }

  public String getCrdName() {
    return crdName;
  }

  /**
   * @deprecated Use {@link #getCrdSpecVersion()} instead
   * @return the CRD spec version
   */
  public String getVersion() {
    return getCrdSpecVersion();
  }

  public String getCrdSpecVersion() {
    return crdSpecVersion;
  }

  public String getFilePath() {
    return filePath;
  }

  public Set<String> getDependentClassNames() {
    return dependentClassNames;
  }

  @Override
  public String toString() {
    return String
      .format("'%s' %s CRD with %s (spec: %s / status %s)", crdName, crdSpecVersion, crClassName, specClassName, statusClassName);
  }
}
