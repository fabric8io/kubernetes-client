package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodStatusBuilder extends PodStatusFluent<PodStatusBuilder> implements VisitableBuilder<PodStatus,PodStatusBuilder>{

  PodStatusFluent<?> fluent;

  public PodStatusBuilder() {
    this(new PodStatus());
  }
  
  public PodStatusBuilder(PodStatusFluent<?> fluent) {
    this(fluent, new PodStatus());
  }
  
  public PodStatusBuilder(PodStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodStatusBuilder(PodStatusFluent<?> fluent,PodStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodStatus build() {
    PodStatus buildable = new PodStatus(fluent.getAllocatedResources(), fluent.buildConditions(), fluent.buildContainerStatuses(), fluent.buildEphemeralContainerStatuses(), fluent.buildExtendedResourceClaimStatus(), fluent.getHostIP(), fluent.buildHostIPs(), fluent.buildInitContainerStatuses(), fluent.getMessage(), fluent.buildNodeAllocatableResourceClaimStatuses(), fluent.getNominatedNodeName(), fluent.getObservedGeneration(), fluent.getPhase(), fluent.getPodIP(), fluent.buildPodIPs(), fluent.getQosClass(), fluent.getReason(), fluent.getResize(), fluent.buildResourceClaimStatuses(), fluent.buildResources(), fluent.getStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}