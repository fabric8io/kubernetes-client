package io.fabric8.knative.eventing.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerFilterBuilder extends TriggerFilterFluent<TriggerFilterBuilder> implements VisitableBuilder<TriggerFilter,TriggerFilterBuilder>{

  TriggerFilterFluent<?> fluent;

  public TriggerFilterBuilder() {
    this(new TriggerFilter());
  }
  
  public TriggerFilterBuilder(TriggerFilterFluent<?> fluent) {
    this(fluent, new TriggerFilter());
  }
  
  public TriggerFilterBuilder(TriggerFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerFilterBuilder(TriggerFilterFluent<?> fluent,TriggerFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerFilter build() {
    TriggerFilter buildable = new TriggerFilter(fluent.getAttributes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}