package io.fabric8.knative.serving.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DomainMappingBuilder extends DomainMappingFluent<DomainMappingBuilder> implements VisitableBuilder<DomainMapping,DomainMappingBuilder>{

  DomainMappingFluent<?> fluent;

  public DomainMappingBuilder() {
    this(new DomainMapping());
  }
  
  public DomainMappingBuilder(DomainMappingFluent<?> fluent) {
    this(fluent, new DomainMapping());
  }
  
  public DomainMappingBuilder(DomainMapping instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DomainMappingBuilder(DomainMappingFluent<?> fluent,DomainMapping instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DomainMapping build() {
    DomainMapping buildable = new DomainMapping(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}