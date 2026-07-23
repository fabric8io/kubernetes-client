package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSFailureDomainPlacementBuilder extends AWSFailureDomainPlacementFluent<AWSFailureDomainPlacementBuilder> implements VisitableBuilder<AWSFailureDomainPlacement,AWSFailureDomainPlacementBuilder>{

  AWSFailureDomainPlacementFluent<?> fluent;

  public AWSFailureDomainPlacementBuilder() {
    this(new AWSFailureDomainPlacement());
  }
  
  public AWSFailureDomainPlacementBuilder(AWSFailureDomainPlacementFluent<?> fluent) {
    this(fluent, new AWSFailureDomainPlacement());
  }
  
  public AWSFailureDomainPlacementBuilder(AWSFailureDomainPlacement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSFailureDomainPlacementBuilder(AWSFailureDomainPlacementFluent<?> fluent,AWSFailureDomainPlacement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSFailureDomainPlacement build() {
    AWSFailureDomainPlacement buildable = new AWSFailureDomainPlacement(fluent.getAvailabilityZone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}