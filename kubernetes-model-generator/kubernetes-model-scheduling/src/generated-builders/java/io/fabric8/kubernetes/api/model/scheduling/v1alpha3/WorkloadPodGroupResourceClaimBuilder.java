package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkloadPodGroupResourceClaimBuilder extends WorkloadPodGroupResourceClaimFluent<WorkloadPodGroupResourceClaimBuilder> implements VisitableBuilder<WorkloadPodGroupResourceClaim,WorkloadPodGroupResourceClaimBuilder>{

  WorkloadPodGroupResourceClaimFluent<?> fluent;

  public WorkloadPodGroupResourceClaimBuilder() {
    this(new WorkloadPodGroupResourceClaim());
  }
  
  public WorkloadPodGroupResourceClaimBuilder(WorkloadPodGroupResourceClaimFluent<?> fluent) {
    this(fluent, new WorkloadPodGroupResourceClaim());
  }
  
  public WorkloadPodGroupResourceClaimBuilder(WorkloadPodGroupResourceClaim instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkloadPodGroupResourceClaimBuilder(WorkloadPodGroupResourceClaimFluent<?> fluent,WorkloadPodGroupResourceClaim instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkloadPodGroupResourceClaim build() {
    WorkloadPodGroupResourceClaim buildable = new WorkloadPodGroupResourceClaim(fluent.getName(), fluent.getResourceClaimName(), fluent.getResourceClaimTemplateName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}