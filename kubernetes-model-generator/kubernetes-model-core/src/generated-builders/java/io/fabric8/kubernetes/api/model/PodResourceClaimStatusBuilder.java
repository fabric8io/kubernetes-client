package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodResourceClaimStatusBuilder extends PodResourceClaimStatusFluent<PodResourceClaimStatusBuilder> implements VisitableBuilder<PodResourceClaimStatus,PodResourceClaimStatusBuilder>{

  PodResourceClaimStatusFluent<?> fluent;

  public PodResourceClaimStatusBuilder() {
    this(new PodResourceClaimStatus());
  }
  
  public PodResourceClaimStatusBuilder(PodResourceClaimStatusFluent<?> fluent) {
    this(fluent, new PodResourceClaimStatus());
  }
  
  public PodResourceClaimStatusBuilder(PodResourceClaimStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodResourceClaimStatusBuilder(PodResourceClaimStatusFluent<?> fluent,PodResourceClaimStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodResourceClaimStatus build() {
    PodResourceClaimStatus buildable = new PodResourceClaimStatus(fluent.getName(), fluent.getResourceClaimName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}