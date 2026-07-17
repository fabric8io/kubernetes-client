package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertmanagerSpecBuilder extends AlertmanagerSpecFluent<AlertmanagerSpecBuilder> implements VisitableBuilder<AlertmanagerSpec,AlertmanagerSpecBuilder>{

  AlertmanagerSpecFluent<?> fluent;

  public AlertmanagerSpecBuilder() {
    this(new AlertmanagerSpec());
  }
  
  public AlertmanagerSpecBuilder(AlertmanagerSpecFluent<?> fluent) {
    this(fluent, new AlertmanagerSpec());
  }
  
  public AlertmanagerSpecBuilder(AlertmanagerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertmanagerSpecBuilder(AlertmanagerSpecFluent<?> fluent,AlertmanagerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertmanagerSpec build() {
    AlertmanagerSpec buildable = new AlertmanagerSpec(fluent.buildAdditionalArgs(), fluent.getAdditionalPeers(), fluent.getAffinity(), fluent.buildAlertmanagerConfigMatcherStrategy(), fluent.buildAlertmanagerConfigNamespaceSelector(), fluent.buildAlertmanagerConfigSelector(), fluent.buildAlertmanagerConfiguration(), fluent.getAutomountServiceAccountToken(), fluent.getBaseImage(), fluent.getClusterAdvertiseAddress(), fluent.getClusterGossipInterval(), fluent.getClusterLabel(), fluent.getClusterPeerTimeout(), fluent.getClusterPushpullInterval(), fluent.buildClusterTLS(), fluent.getConfigMaps(), fluent.getConfigSecret(), fluent.buildContainers(), fluent.buildDnsConfig(), fluent.getDnsPolicy(), fluent.getEnableFeatures(), fluent.getEnableServiceLinks(), fluent.getExternalUrl(), fluent.getForceEnableClusterMode(), fluent.buildHostAliases(), fluent.getHostNetwork(), fluent.getHostUsers(), fluent.getImage(), fluent.getImagePullPolicy(), fluent.buildImagePullSecrets(), fluent.buildInitContainers(), fluent.buildLimits(), fluent.getListenLocal(), fluent.getLogFormat(), fluent.getLogLevel(), fluent.getMinReadySeconds(), fluent.getNodeSelector(), fluent.getPaused(), fluent.getPersistentVolumeClaimRetentionPolicy(), fluent.getPodManagementPolicy(), fluent.buildPodMetadata(), fluent.getPortName(), fluent.getPriorityClassName(), fluent.getReplicas(), fluent.buildResources(), fluent.getRetention(), fluent.getRoutePrefix(), fluent.getSchedulerName(), fluent.getSecrets(), fluent.getSecurityContext(), fluent.getServiceAccountName(), fluent.getServiceName(), fluent.getSha(), fluent.buildStorage(), fluent.getTag(), fluent.getTerminationGracePeriodSeconds(), fluent.getTolerations(), fluent.getTopologySpreadConstraints(), fluent.buildUpdateStrategy(), fluent.getVersion(), fluent.buildVolumeMounts(), fluent.buildVolumes(), fluent.buildWeb());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}