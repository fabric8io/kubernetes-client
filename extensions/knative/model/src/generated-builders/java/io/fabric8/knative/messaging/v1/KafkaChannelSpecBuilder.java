package io.fabric8.knative.messaging.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaChannelSpecBuilder extends KafkaChannelSpecFluent<KafkaChannelSpecBuilder> implements VisitableBuilder<KafkaChannelSpec,KafkaChannelSpecBuilder>{

  KafkaChannelSpecFluent<?> fluent;

  public KafkaChannelSpecBuilder() {
    this(new KafkaChannelSpec());
  }
  
  public KafkaChannelSpecBuilder(KafkaChannelSpecFluent<?> fluent) {
    this(fluent, new KafkaChannelSpec());
  }
  
  public KafkaChannelSpecBuilder(KafkaChannelSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaChannelSpecBuilder(KafkaChannelSpecFluent<?> fluent,KafkaChannelSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaChannelSpec build() {
    KafkaChannelSpec buildable = new KafkaChannelSpec(fluent.buildDelivery(), fluent.getNumPartitions(), fluent.getReplicationFactor(), fluent.getRetentionDuration(), fluent.buildSubscribers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}