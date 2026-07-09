package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CounterBuilder extends CounterFluent<CounterBuilder> implements VisitableBuilder<Counter,CounterBuilder>{

  CounterFluent<?> fluent;

  public CounterBuilder() {
    this(new Counter());
  }
  
  public CounterBuilder(CounterFluent<?> fluent) {
    this(fluent, new Counter());
  }
  
  public CounterBuilder(Counter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CounterBuilder(CounterFluent<?> fluent,Counter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Counter build() {
    Counter buildable = new Counter(fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}