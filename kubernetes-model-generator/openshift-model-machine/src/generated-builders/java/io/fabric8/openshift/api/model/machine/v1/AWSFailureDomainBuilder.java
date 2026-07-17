package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSFailureDomainBuilder extends AWSFailureDomainFluent<AWSFailureDomainBuilder> implements VisitableBuilder<AWSFailureDomain,AWSFailureDomainBuilder>{

  AWSFailureDomainFluent<?> fluent;

  public AWSFailureDomainBuilder() {
    this(new AWSFailureDomain());
  }
  
  public AWSFailureDomainBuilder(AWSFailureDomainFluent<?> fluent) {
    this(fluent, new AWSFailureDomain());
  }
  
  public AWSFailureDomainBuilder(AWSFailureDomain instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSFailureDomainBuilder(AWSFailureDomainFluent<?> fluent,AWSFailureDomain instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSFailureDomain build() {
    AWSFailureDomain buildable = new AWSFailureDomain(fluent.buildPlacement(), fluent.buildSubnet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}