package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaFloodSpecBuilder extends KafkaFloodSpecFluent<KafkaFloodSpecBuilder> implements VisitableBuilder<KafkaFloodSpec,KafkaFloodSpecBuilder>{

  KafkaFloodSpecFluent<?> fluent;

  public KafkaFloodSpecBuilder() {
    this(new KafkaFloodSpec());
  }
  
  public KafkaFloodSpecBuilder(KafkaFloodSpecFluent<?> fluent) {
    this(fluent, new KafkaFloodSpec());
  }
  
  public KafkaFloodSpecBuilder(KafkaFloodSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaFloodSpecBuilder(KafkaFloodSpecFluent<?> fluent,KafkaFloodSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaFloodSpec build() {
    KafkaFloodSpec buildable = new KafkaFloodSpec(fluent.getHost(), fluent.getMessageSize(), fluent.getPassword(), fluent.getPort(), fluent.getThreads(), fluent.getTopic(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}