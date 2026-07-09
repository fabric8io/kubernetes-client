package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodGroupResourceClaimStatusBuilder extends PodGroupResourceClaimStatusFluent<PodGroupResourceClaimStatusBuilder> implements VisitableBuilder<PodGroupResourceClaimStatus,PodGroupResourceClaimStatusBuilder>{

  PodGroupResourceClaimStatusFluent<?> fluent;

  public PodGroupResourceClaimStatusBuilder() {
    this(new PodGroupResourceClaimStatus());
  }
  
  public PodGroupResourceClaimStatusBuilder(PodGroupResourceClaimStatusFluent<?> fluent) {
    this(fluent, new PodGroupResourceClaimStatus());
  }
  
  public PodGroupResourceClaimStatusBuilder(PodGroupResourceClaimStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodGroupResourceClaimStatusBuilder(PodGroupResourceClaimStatusFluent<?> fluent,PodGroupResourceClaimStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodGroupResourceClaimStatus build() {
    PodGroupResourceClaimStatus buildable = new PodGroupResourceClaimStatus(fluent.getName(), fluent.getResourceClaimName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}