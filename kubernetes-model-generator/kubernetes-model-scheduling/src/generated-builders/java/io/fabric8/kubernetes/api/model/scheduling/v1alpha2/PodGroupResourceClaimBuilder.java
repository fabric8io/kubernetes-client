package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodGroupResourceClaimBuilder extends PodGroupResourceClaimFluent<PodGroupResourceClaimBuilder> implements VisitableBuilder<PodGroupResourceClaim,PodGroupResourceClaimBuilder>{

  PodGroupResourceClaimFluent<?> fluent;

  public PodGroupResourceClaimBuilder() {
    this(new PodGroupResourceClaim());
  }
  
  public PodGroupResourceClaimBuilder(PodGroupResourceClaimFluent<?> fluent) {
    this(fluent, new PodGroupResourceClaim());
  }
  
  public PodGroupResourceClaimBuilder(PodGroupResourceClaim instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodGroupResourceClaimBuilder(PodGroupResourceClaimFluent<?> fluent,PodGroupResourceClaim instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodGroupResourceClaim build() {
    PodGroupResourceClaim buildable = new PodGroupResourceClaim(fluent.getName(), fluent.getResourceClaimName(), fluent.getResourceClaimTemplateName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}