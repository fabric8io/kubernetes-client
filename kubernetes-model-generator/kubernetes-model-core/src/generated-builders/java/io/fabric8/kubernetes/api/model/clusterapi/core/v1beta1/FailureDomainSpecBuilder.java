package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FailureDomainSpecBuilder extends FailureDomainSpecFluent<FailureDomainSpecBuilder> implements VisitableBuilder<FailureDomainSpec,FailureDomainSpecBuilder>{

  FailureDomainSpecFluent<?> fluent;

  public FailureDomainSpecBuilder() {
    this(new FailureDomainSpec());
  }
  
  public FailureDomainSpecBuilder(FailureDomainSpecFluent<?> fluent) {
    this(fluent, new FailureDomainSpec());
  }
  
  public FailureDomainSpecBuilder(FailureDomainSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FailureDomainSpecBuilder(FailureDomainSpecFluent<?> fluent,FailureDomainSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FailureDomainSpec build() {
    FailureDomainSpec buildable = new FailureDomainSpec(fluent.getAttributes(), fluent.getControlPlane());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}