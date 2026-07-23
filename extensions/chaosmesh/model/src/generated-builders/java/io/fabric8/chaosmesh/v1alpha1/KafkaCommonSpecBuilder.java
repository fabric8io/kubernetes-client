package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaCommonSpecBuilder extends KafkaCommonSpecFluent<KafkaCommonSpecBuilder> implements VisitableBuilder<KafkaCommonSpec,KafkaCommonSpecBuilder>{

  KafkaCommonSpecFluent<?> fluent;

  public KafkaCommonSpecBuilder() {
    this(new KafkaCommonSpec());
  }
  
  public KafkaCommonSpecBuilder(KafkaCommonSpecFluent<?> fluent) {
    this(fluent, new KafkaCommonSpec());
  }
  
  public KafkaCommonSpecBuilder(KafkaCommonSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaCommonSpecBuilder(KafkaCommonSpecFluent<?> fluent,KafkaCommonSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaCommonSpec build() {
    KafkaCommonSpec buildable = new KafkaCommonSpec(fluent.getHost(), fluent.getPassword(), fluent.getPort(), fluent.getTopic(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}