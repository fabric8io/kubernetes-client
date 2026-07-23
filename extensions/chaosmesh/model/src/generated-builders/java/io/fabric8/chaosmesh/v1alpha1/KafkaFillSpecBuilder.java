package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaFillSpecBuilder extends KafkaFillSpecFluent<KafkaFillSpecBuilder> implements VisitableBuilder<KafkaFillSpec,KafkaFillSpecBuilder>{

  KafkaFillSpecFluent<?> fluent;

  public KafkaFillSpecBuilder() {
    this(new KafkaFillSpec());
  }
  
  public KafkaFillSpecBuilder(KafkaFillSpecFluent<?> fluent) {
    this(fluent, new KafkaFillSpec());
  }
  
  public KafkaFillSpecBuilder(KafkaFillSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaFillSpecBuilder(KafkaFillSpecFluent<?> fluent,KafkaFillSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaFillSpec build() {
    KafkaFillSpec buildable = new KafkaFillSpec(fluent.getHost(), fluent.getMaxBytes(), fluent.getMessageSize(), fluent.getPassword(), fluent.getPort(), fluent.getReloadCommand(), fluent.getTopic(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}