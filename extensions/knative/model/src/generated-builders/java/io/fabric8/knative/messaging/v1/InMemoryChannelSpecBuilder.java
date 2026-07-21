package io.fabric8.knative.messaging.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InMemoryChannelSpecBuilder extends InMemoryChannelSpecFluent<InMemoryChannelSpecBuilder> implements VisitableBuilder<InMemoryChannelSpec,InMemoryChannelSpecBuilder>{

  InMemoryChannelSpecFluent<?> fluent;

  public InMemoryChannelSpecBuilder() {
    this(new InMemoryChannelSpec());
  }
  
  public InMemoryChannelSpecBuilder(InMemoryChannelSpecFluent<?> fluent) {
    this(fluent, new InMemoryChannelSpec());
  }
  
  public InMemoryChannelSpecBuilder(InMemoryChannelSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InMemoryChannelSpecBuilder(InMemoryChannelSpecFluent<?> fluent,InMemoryChannelSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InMemoryChannelSpec build() {
    InMemoryChannelSpec buildable = new InMemoryChannelSpec(fluent.buildDelivery(), fluent.buildSubscribers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}