package io.fabric8.knative.messaging.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChannelSpecBuilder extends ChannelSpecFluent<ChannelSpecBuilder> implements VisitableBuilder<ChannelSpec,ChannelSpecBuilder>{

  ChannelSpecFluent<?> fluent;

  public ChannelSpecBuilder() {
    this(new ChannelSpec());
  }
  
  public ChannelSpecBuilder(ChannelSpecFluent<?> fluent) {
    this(fluent, new ChannelSpec());
  }
  
  public ChannelSpecBuilder(ChannelSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChannelSpecBuilder(ChannelSpecFluent<?> fluent,ChannelSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChannelSpec build() {
    ChannelSpec buildable = new ChannelSpec(fluent.buildChannelTemplate(), fluent.buildDelivery(), fluent.buildSubscribers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}