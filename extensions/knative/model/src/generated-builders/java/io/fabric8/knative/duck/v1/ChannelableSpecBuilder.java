package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChannelableSpecBuilder extends ChannelableSpecFluent<ChannelableSpecBuilder> implements VisitableBuilder<ChannelableSpec,ChannelableSpecBuilder>{

  ChannelableSpecFluent<?> fluent;

  public ChannelableSpecBuilder() {
    this(new ChannelableSpec());
  }
  
  public ChannelableSpecBuilder(ChannelableSpecFluent<?> fluent) {
    this(fluent, new ChannelableSpec());
  }
  
  public ChannelableSpecBuilder(ChannelableSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChannelableSpecBuilder(ChannelableSpecFluent<?> fluent,ChannelableSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChannelableSpec build() {
    ChannelableSpec buildable = new ChannelableSpec(fluent.buildDelivery(), fluent.buildSubscribers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}