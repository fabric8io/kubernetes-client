package io.fabric8.knative.messaging.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaChannelStatusBuilder extends KafkaChannelStatusFluent<KafkaChannelStatusBuilder> implements VisitableBuilder<KafkaChannelStatus,KafkaChannelStatusBuilder>{

  KafkaChannelStatusFluent<?> fluent;

  public KafkaChannelStatusBuilder() {
    this(new KafkaChannelStatus());
  }
  
  public KafkaChannelStatusBuilder(KafkaChannelStatusFluent<?> fluent) {
    this(fluent, new KafkaChannelStatus());
  }
  
  public KafkaChannelStatusBuilder(KafkaChannelStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaChannelStatusBuilder(KafkaChannelStatusFluent<?> fluent,KafkaChannelStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaChannelStatus build() {
    KafkaChannelStatus buildable = new KafkaChannelStatus(fluent.buildAddress(), fluent.buildAddresses(), fluent.getAnnotations(), fluent.buildConditions(), fluent.getDeadLetterSinkAudience(), fluent.getDeadLetterSinkCACerts(), fluent.getDeadLetterSinkUri(), fluent.getObservedGeneration(), fluent.buildPolicies(), fluent.buildSubscribers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}