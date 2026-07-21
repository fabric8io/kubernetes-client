package io.fabric8.knative.messaging.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaChannelBuilder extends KafkaChannelFluent<KafkaChannelBuilder> implements VisitableBuilder<KafkaChannel,KafkaChannelBuilder>{

  KafkaChannelFluent<?> fluent;

  public KafkaChannelBuilder() {
    this(new KafkaChannel());
  }
  
  public KafkaChannelBuilder(KafkaChannelFluent<?> fluent) {
    this(fluent, new KafkaChannel());
  }
  
  public KafkaChannelBuilder(KafkaChannel instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaChannelBuilder(KafkaChannelFluent<?> fluent,KafkaChannel instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaChannel build() {
    KafkaChannel buildable = new KafkaChannel(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}