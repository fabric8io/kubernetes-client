package io.fabric8.knative.serving.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DomainMappingSpecBuilder extends DomainMappingSpecFluent<DomainMappingSpecBuilder> implements VisitableBuilder<DomainMappingSpec,DomainMappingSpecBuilder>{

  DomainMappingSpecFluent<?> fluent;

  public DomainMappingSpecBuilder() {
    this(new DomainMappingSpec());
  }
  
  public DomainMappingSpecBuilder(DomainMappingSpecFluent<?> fluent) {
    this(fluent, new DomainMappingSpec());
  }
  
  public DomainMappingSpecBuilder(DomainMappingSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DomainMappingSpecBuilder(DomainMappingSpecFluent<?> fluent,DomainMappingSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DomainMappingSpec build() {
    DomainMappingSpec buildable = new DomainMappingSpec(fluent.buildRef(), fluent.buildTls());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}