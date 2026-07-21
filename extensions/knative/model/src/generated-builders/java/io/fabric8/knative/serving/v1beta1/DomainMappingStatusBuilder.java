package io.fabric8.knative.serving.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DomainMappingStatusBuilder extends DomainMappingStatusFluent<DomainMappingStatusBuilder> implements VisitableBuilder<DomainMappingStatus,DomainMappingStatusBuilder>{

  DomainMappingStatusFluent<?> fluent;

  public DomainMappingStatusBuilder() {
    this(new DomainMappingStatus());
  }
  
  public DomainMappingStatusBuilder(DomainMappingStatusFluent<?> fluent) {
    this(fluent, new DomainMappingStatus());
  }
  
  public DomainMappingStatusBuilder(DomainMappingStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DomainMappingStatusBuilder(DomainMappingStatusFluent<?> fluent,DomainMappingStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DomainMappingStatus build() {
    DomainMappingStatus buildable = new DomainMappingStatus(fluent.buildAddress(), fluent.getAnnotations(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}