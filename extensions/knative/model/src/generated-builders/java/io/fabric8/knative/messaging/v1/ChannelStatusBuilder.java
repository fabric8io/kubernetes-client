package io.fabric8.knative.messaging.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChannelStatusBuilder extends ChannelStatusFluent<ChannelStatusBuilder> implements VisitableBuilder<ChannelStatus,ChannelStatusBuilder>{

  ChannelStatusFluent<?> fluent;

  public ChannelStatusBuilder() {
    this(new ChannelStatus());
  }
  
  public ChannelStatusBuilder(ChannelStatusFluent<?> fluent) {
    this(fluent, new ChannelStatus());
  }
  
  public ChannelStatusBuilder(ChannelStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChannelStatusBuilder(ChannelStatusFluent<?> fluent,ChannelStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChannelStatus build() {
    ChannelStatus buildable = new ChannelStatus(fluent.buildAddress(), fluent.buildAddresses(), fluent.getAnnotations(), fluent.buildChannel(), fluent.buildConditions(), fluent.getDeadLetterSinkAudience(), fluent.getDeadLetterSinkCACerts(), fluent.getDeadLetterSinkUri(), fluent.getObservedGeneration(), fluent.buildPolicies(), fluent.buildSubscribers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}