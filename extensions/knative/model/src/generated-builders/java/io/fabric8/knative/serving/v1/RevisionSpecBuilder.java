package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RevisionSpecBuilder extends RevisionSpecFluent<RevisionSpecBuilder> implements VisitableBuilder<RevisionSpec,RevisionSpecBuilder>{

  RevisionSpecFluent<?> fluent;

  public RevisionSpecBuilder() {
    this(new RevisionSpec());
  }
  
  public RevisionSpecBuilder(RevisionSpecFluent<?> fluent) {
    this(fluent, new RevisionSpec());
  }
  
  public RevisionSpecBuilder(RevisionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RevisionSpecBuilder(RevisionSpecFluent<?> fluent,RevisionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RevisionSpec build() {
    RevisionSpec buildable = new RevisionSpec(fluent.getActiveDeadlineSeconds(), fluent.getAffinity(), fluent.getAutomountServiceAccountToken(), fluent.getContainerConcurrency(), fluent.buildContainers(), fluent.getDnsConfig(), fluent.getDnsPolicy(), fluent.getEnableServiceLinks(), fluent.getEphemeralContainers(), fluent.getHostAliases(), fluent.getHostIPC(), fluent.getHostNetwork(), fluent.getHostPID(), fluent.getHostUsers(), fluent.getHostname(), fluent.getHostnameOverride(), fluent.getIdleTimeoutSeconds(), fluent.buildImagePullSecrets(), fluent.buildInitContainers(), fluent.getNodeName(), fluent.getNodeSelector(), fluent.getOs(), fluent.getOverhead(), fluent.getPreemptionPolicy(), fluent.getPriority(), fluent.getPriorityClassName(), fluent.getReadinessGates(), fluent.getResourceClaims(), fluent.buildResources(), fluent.getResponseStartTimeoutSeconds(), fluent.getRestartPolicy(), fluent.getRuntimeClassName(), fluent.getSchedulerName(), fluent.getSchedulingGates(), fluent.getSecurityContext(), fluent.getServiceAccount(), fluent.getServiceAccountName(), fluent.getSetHostnameAsFQDN(), fluent.getShareProcessNamespace(), fluent.getSubdomain(), fluent.getTerminationGracePeriodSeconds(), fluent.getTimeoutSeconds(), fluent.getTolerations(), fluent.getTopologySpreadConstraints(), fluent.buildVolumes(), fluent.getWorkloadRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}