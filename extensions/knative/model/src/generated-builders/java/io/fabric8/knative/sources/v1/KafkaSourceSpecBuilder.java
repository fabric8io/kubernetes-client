package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaSourceSpecBuilder extends KafkaSourceSpecFluent<KafkaSourceSpecBuilder> implements VisitableBuilder<KafkaSourceSpec,KafkaSourceSpecBuilder>{

  KafkaSourceSpecFluent<?> fluent;

  public KafkaSourceSpecBuilder() {
    this(new KafkaSourceSpec());
  }
  
  public KafkaSourceSpecBuilder(KafkaSourceSpecFluent<?> fluent) {
    this(fluent, new KafkaSourceSpec());
  }
  
  public KafkaSourceSpecBuilder(KafkaSourceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaSourceSpecBuilder(KafkaSourceSpecFluent<?> fluent,KafkaSourceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaSourceSpec build() {
    KafkaSourceSpec buildable = new KafkaSourceSpec(fluent.getBootstrapServers(), fluent.buildCeOverrides(), fluent.getConsumerGroup(), fluent.getConsumers(), fluent.buildDelivery(), fluent.getInitialOffset(), fluent.buildNet(), fluent.getOrdering(), fluent.buildSink(), fluent.getTopics());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}