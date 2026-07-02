package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodResourceClaimBuilder extends PodResourceClaimFluent<PodResourceClaimBuilder> implements VisitableBuilder<PodResourceClaim,PodResourceClaimBuilder>{

  PodResourceClaimFluent<?> fluent;

  public PodResourceClaimBuilder() {
    this(new PodResourceClaim());
  }
  
  public PodResourceClaimBuilder(PodResourceClaimFluent<?> fluent) {
    this(fluent, new PodResourceClaim());
  }
  
  public PodResourceClaimBuilder(PodResourceClaim instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodResourceClaimBuilder(PodResourceClaimFluent<?> fluent,PodResourceClaim instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodResourceClaim build() {
    PodResourceClaim buildable = new PodResourceClaim(fluent.getName(), fluent.getResourceClaimName(), fluent.getResourceClaimTemplateName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}