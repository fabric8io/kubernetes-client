package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodExtendedResourceClaimStatusBuilder extends PodExtendedResourceClaimStatusFluent<PodExtendedResourceClaimStatusBuilder> implements VisitableBuilder<PodExtendedResourceClaimStatus,PodExtendedResourceClaimStatusBuilder>{

  PodExtendedResourceClaimStatusFluent<?> fluent;

  public PodExtendedResourceClaimStatusBuilder() {
    this(new PodExtendedResourceClaimStatus());
  }
  
  public PodExtendedResourceClaimStatusBuilder(PodExtendedResourceClaimStatusFluent<?> fluent) {
    this(fluent, new PodExtendedResourceClaimStatus());
  }
  
  public PodExtendedResourceClaimStatusBuilder(PodExtendedResourceClaimStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodExtendedResourceClaimStatusBuilder(PodExtendedResourceClaimStatusFluent<?> fluent,PodExtendedResourceClaimStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodExtendedResourceClaimStatus build() {
    PodExtendedResourceClaimStatus buildable = new PodExtendedResourceClaimStatus(fluent.buildRequestMappings(), fluent.getResourceClaimName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}