package io.fabric8.kubernetes.api.model.resource.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CounterSetBuilder extends CounterSetFluent<CounterSetBuilder> implements VisitableBuilder<CounterSet,CounterSetBuilder>{

  CounterSetFluent<?> fluent;

  public CounterSetBuilder() {
    this(new CounterSet());
  }
  
  public CounterSetBuilder(CounterSetFluent<?> fluent) {
    this(fluent, new CounterSet());
  }
  
  public CounterSetBuilder(CounterSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CounterSetBuilder(CounterSetFluent<?> fluent,CounterSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CounterSet build() {
    CounterSet buildable = new CounterSet(fluent.getCounters(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}