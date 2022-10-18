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
package io.fabric8.openshift.client.impl;

import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
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

public class OpenShiftMonitoringAPIGroupClient extends ClientAdapter<OpenShiftMonitoringAPIGroupClient>
    implements OpenShiftMonitoringAPIGroupDSL {

  @Override
  public MixedOperation<AlertmanagerConfig, AlertmanagerConfigList, Resource<AlertmanagerConfig>> alertmanagerConfigs() {
    return resources(AlertmanagerConfig.class, AlertmanagerConfigList.class);
  }

  @Override
  public MixedOperation<Prometheus, PrometheusList, Resource<Prometheus>> prometheuses() {
    return resources(Prometheus.class, PrometheusList.class);
  }

  @Override
  public MixedOperation<PodMonitor, PodMonitorList, Resource<PodMonitor>> podMonitors() {
    return resources(PodMonitor.class, PodMonitorList.class);
  }

  @Override
  public MixedOperation<Probe, ProbeList, Resource<Probe>> probes() {
    return resources(Probe.class, ProbeList.class);
  }

  @Override
  public MixedOperation<Alertmanager, AlertmanagerList, Resource<Alertmanager>> alertmanagers() {
    return resources(Alertmanager.class, AlertmanagerList.class);
  }

  @Override
  public MixedOperation<PrometheusRule, PrometheusRuleList, Resource<PrometheusRule>> prometheusRules() {
    return resources(PrometheusRule.class, PrometheusRuleList.class);
  }

  @Override
  public MixedOperation<ServiceMonitor, ServiceMonitorList, Resource<ServiceMonitor>> serviceMonitors() {
    return resources(ServiceMonitor.class, ServiceMonitorList.class);
  }

  @Override
  public MixedOperation<ThanosRuler, ThanosRulerList, Resource<ThanosRuler>> thanosRulers() {
    return resources(ThanosRuler.class, ThanosRulerList.class);
  }

  @Override
  public OpenShiftMonitoringAPIGroupClient newInstance() {
    return new OpenShiftMonitoringAPIGroupClient();
  }
}
