package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChannelableStatusBuilder extends ChannelableStatusFluent<ChannelableStatusBuilder> implements VisitableBuilder<ChannelableStatus,ChannelableStatusBuilder>{

  ChannelableStatusFluent<?> fluent;

  public ChannelableStatusBuilder() {
    this(new ChannelableStatus());
  }
  
  public ChannelableStatusBuilder(ChannelableStatusFluent<?> fluent) {
    this(fluent, new ChannelableStatus());
  }
  
  public ChannelableStatusBuilder(ChannelableStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChannelableStatusBuilder(ChannelableStatusFluent<?> fluent,ChannelableStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChannelableStatus build() {
    ChannelableStatus buildable = new ChannelableStatus(fluent.buildAddress(), fluent.buildAddresses(), fluent.getAnnotations(), fluent.buildConditions(), fluent.getDeadLetterSinkAudience(), fluent.getDeadLetterSinkCACerts(), fluent.getDeadLetterSinkUri(), fluent.getObservedGeneration(), fluent.buildPolicies(), fluent.buildSubscribers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}