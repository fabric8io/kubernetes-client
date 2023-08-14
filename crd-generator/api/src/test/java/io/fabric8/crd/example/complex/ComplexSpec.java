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
package io.fabric8.crd.example.complex;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("LombokGetterMayBeUsed")
public class ComplexSpec {
  private StatefulSetConfiguration statefulSet = new StatefulSetConfiguration();
  private List<ServiceConfiguration> services = new ArrayList<>();

  private String configMapName = "example-configuration";

  private int actuatorPort;
  private int metricsPort;
  private String metricsPath = "/";

  public StatefulSetConfiguration getStatefulSet() {
    return statefulSet;
  }

  public void setStatefulSet(StatefulSetConfiguration statefulSet) {
    this.statefulSet = statefulSet;
  }

  public List<ServiceConfiguration> getServices() {
    return services;
  }

  public void setServices(List<ServiceConfiguration> services) {
    this.services = services;
  }

  public String getConfigMapName() {
    return configMapName;
  }

  public void setConfigMapName(String configMapName) {
    this.configMapName = configMapName;
  }

  public int getActuatorPort() {
    return actuatorPort;
  }

  public void setActuatorPort(int actuatorPort) {
    this.actuatorPort = actuatorPort;
  }

  public int getMetricsPort() {
    return metricsPort;
  }

  public void setMetricsPort(int metricsPort) {
    this.metricsPort = metricsPort;
  }

  public String getMetricsPath() {
    return metricsPath;
  }

  public void setMetricsPath(String metricsPath) {
    this.metricsPath = metricsPath;
  }
}
