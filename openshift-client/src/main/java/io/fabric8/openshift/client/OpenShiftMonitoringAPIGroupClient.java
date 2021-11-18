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
package io.fabric8.openshift.client;

import io.fabric8.kubernetes.client.ClientState;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.monitoring.v1.Alertmanager;
import io.fabric8.openshift.api.model.monitoring.v1.AlertmanagerList;
import io.fabric8.openshift.api.model.monitoring.v1.PodMonitor;
import io.fabric8.openshift.api.model.monitoring.v1.PodMonitorList;
import io.fabric8.openshift.api.model.monitoring.v1.Probe;
import io.fabric8.openshift.api.model.monitoring.v1.ProbeList;
import io.fabric8.openshift.api.model.monitoring.v1.Prometheus;
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusList;
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusRule;
import io.fabric8.openshift.api.model.monitoring.v1.PrometheusRuleList;
import io.fabric8.openshift.api.model.monitoring.v1.ServiceMonitor;
import io.fabric8.openshift.api.model.monitoring.v1.ServiceMonitorList;
import io.fabric8.openshift.api.model.monitoring.v1.ThanosRuler;
import io.fabric8.openshift.api.model.monitoring.v1.ThanosRulerList;
import io.fabric8.openshift.api.model.monitoring.v1alpha1.AlertmanagerConfig;
import io.fabric8.openshift.api.model.monitoring.v1alpha1.AlertmanagerConfigList;
import io.fabric8.openshift.client.dsl.OpenShiftMonitoringAPIGroupDSL;

public class OpenShiftMonitoringAPIGroupClient extends BaseOpenShiftClient implements OpenShiftMonitoringAPIGroupDSL {
  public OpenShiftMonitoringAPIGroupClient() {
    super();
  }

  public OpenShiftMonitoringAPIGroupClient(ClientState clientState) {
    super(clientState);
  }

  @Override
  public MixedOperation<AlertmanagerConfig, AlertmanagerConfigList, Resource<AlertmanagerConfig>> alertmanagerConfigs() {
    return OpenShiftHandlers.getOperation(AlertmanagerConfig.class, AlertmanagerConfigList.class, this);
  }

  @Override
  public MixedOperation<Prometheus, PrometheusList, Resource<Prometheus>> prometheuses() {
    return OpenShiftHandlers.getOperation(Prometheus.class, PrometheusList.class, this);
  }

  @Override
  public MixedOperation<PodMonitor, PodMonitorList, Resource<PodMonitor>> podMonitors() {
    return OpenShiftHandlers.getOperation(PodMonitor.class, PodMonitorList.class, this);
  }

  @Override
  public MixedOperation<Probe, ProbeList, Resource<Probe>> probes() {
    return OpenShiftHandlers.getOperation(Probe.class, ProbeList.class, this);
  }

  @Override
  public MixedOperation<Alertmanager, AlertmanagerList, Resource<Alertmanager>> alertmanagers() {
    return OpenShiftHandlers.getOperation(Alertmanager.class, AlertmanagerList.class, this);
  }

  @Override
  public MixedOperation<PrometheusRule, PrometheusRuleList, Resource<PrometheusRule>> prometheusRules() {
    return OpenShiftHandlers.getOperation(PrometheusRule.class, PrometheusRuleList.class, this);
  }

  @Override
  public MixedOperation<ServiceMonitor, ServiceMonitorList, Resource<ServiceMonitor>> serviceMonitors() {
    return OpenShiftHandlers.getOperation(ServiceMonitor.class, ServiceMonitorList.class, this);
  }

  @Override
  public MixedOperation<ThanosRuler, ThanosRulerList, Resource<ThanosRuler>> thanosRulers() {
    return OpenShiftHandlers.getOperation(ThanosRuler.class, ThanosRulerList.class, this);
  }
}
