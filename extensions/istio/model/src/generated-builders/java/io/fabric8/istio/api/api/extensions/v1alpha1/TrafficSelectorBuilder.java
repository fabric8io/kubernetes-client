package io.fabric8.istio.api.api.extensions.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TrafficSelectorBuilder extends TrafficSelectorFluent<TrafficSelectorBuilder> implements VisitableBuilder<TrafficSelector,TrafficSelectorBuilder>{

  TrafficSelectorFluent<?> fluent;

  public TrafficSelectorBuilder() {
    this(new TrafficSelector());
  }
  
  public TrafficSelectorBuilder(TrafficSelectorFluent<?> fluent) {
    this(fluent, new TrafficSelector());
  }
  
  public TrafficSelectorBuilder(TrafficSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TrafficSelectorBuilder(TrafficSelectorFluent<?> fluent,TrafficSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TrafficSelector build() {
    TrafficSelector buildable = new TrafficSelector(fluent.getMode(), fluent.buildPorts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}