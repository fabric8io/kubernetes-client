package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaIOSpecBuilder extends KafkaIOSpecFluent<KafkaIOSpecBuilder> implements VisitableBuilder<KafkaIOSpec,KafkaIOSpecBuilder>{

  KafkaIOSpecFluent<?> fluent;

  public KafkaIOSpecBuilder() {
    this(new KafkaIOSpec());
  }
  
  public KafkaIOSpecBuilder(KafkaIOSpecFluent<?> fluent) {
    this(fluent, new KafkaIOSpec());
  }
  
  public KafkaIOSpecBuilder(KafkaIOSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaIOSpecBuilder(KafkaIOSpecFluent<?> fluent,KafkaIOSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaIOSpec build() {
    KafkaIOSpec buildable = new KafkaIOSpec(fluent.getConfigFile(), fluent.getNonReadable(), fluent.getNonWritable(), fluent.getTopic());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}