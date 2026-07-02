package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodSpecBuilder extends PodSpecFluent<PodSpecBuilder> implements VisitableBuilder<PodSpec,PodSpecBuilder>{

  PodSpecFluent<?> fluent;

  public PodSpecBuilder() {
    this(new PodSpec());
  }
  
  public PodSpecBuilder(PodSpecFluent<?> fluent) {
    this(fluent, new PodSpec());
  }
  
  public PodSpecBuilder(PodSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodSpecBuilder(PodSpecFluent<?> fluent,PodSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodSpec build() {
    PodSpec buildable = new PodSpec(fluent.getActiveDeadlineSeconds(), fluent.buildAffinity(), fluent.getAutomountServiceAccountToken(), fluent.buildContainers(), fluent.buildDnsConfig(), fluent.getDnsPolicy(), fluent.getEnableServiceLinks(), fluent.buildEphemeralContainers(), fluent.buildHostAliases(), fluent.getHostIPC(), fluent.getHostNetwork(), fluent.getHostPID(), fluent.getHostUsers(), fluent.getHostname(), fluent.getHostnameOverride(), fluent.buildImagePullSecrets(), fluent.buildInitContainers(), fluent.getNodeName(), fluent.getNodeSelector(), fluent.buildOs(), fluent.getOverhead(), fluent.getPreemptionPolicy(), fluent.getPriority(), fluent.getPriorityClassName(), fluent.buildReadinessGates(), fluent.buildResourceClaims(), fluent.buildResources(), fluent.getRestartPolicy(), fluent.getRuntimeClassName(), fluent.getSchedulerName(), fluent.buildSchedulingGates(), fluent.buildSchedulingGroup(), fluent.buildSecurityContext(), fluent.getServiceAccount(), fluent.getServiceAccountName(), fluent.getSetHostnameAsFQDN(), fluent.getShareProcessNamespace(), fluent.getSubdomain(), fluent.getTerminationGracePeriodSeconds(), fluent.buildTolerations(), fluent.buildTopologySpreadConstraints(), fluent.buildVolumes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}