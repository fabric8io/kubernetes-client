package io.fabric8.kubernetes.api.model.resource.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedResourcesFilterBuilder extends NamedResourcesFilterFluent<NamedResourcesFilterBuilder> implements VisitableBuilder<NamedResourcesFilter,NamedResourcesFilterBuilder>{

  NamedResourcesFilterFluent<?> fluent;

  public NamedResourcesFilterBuilder() {
    this(new NamedResourcesFilter());
  }
  
  public NamedResourcesFilterBuilder(NamedResourcesFilterFluent<?> fluent) {
    this(fluent, new NamedResourcesFilter());
  }
  
  public NamedResourcesFilterBuilder(NamedResourcesFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedResourcesFilterBuilder(NamedResourcesFilterFluent<?> fluent,NamedResourcesFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedResourcesFilter build() {
    NamedResourcesFilter buildable = new NamedResourcesFilter(fluent.getSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}