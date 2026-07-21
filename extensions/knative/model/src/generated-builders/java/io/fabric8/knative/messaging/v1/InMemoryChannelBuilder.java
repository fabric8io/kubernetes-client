package io.fabric8.knative.messaging.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InMemoryChannelBuilder extends InMemoryChannelFluent<InMemoryChannelBuilder> implements VisitableBuilder<InMemoryChannel,InMemoryChannelBuilder>{

  InMemoryChannelFluent<?> fluent;

  public InMemoryChannelBuilder() {
    this(new InMemoryChannel());
  }
  
  public InMemoryChannelBuilder(InMemoryChannelFluent<?> fluent) {
    this(fluent, new InMemoryChannel());
  }
  
  public InMemoryChannelBuilder(InMemoryChannel instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InMemoryChannelBuilder(InMemoryChannelFluent<?> fluent,InMemoryChannel instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InMemoryChannel build() {
    InMemoryChannel buildable = new InMemoryChannel(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}