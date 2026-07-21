package io.fabric8.knative.bindings.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaAuthSpecBuilder extends KafkaAuthSpecFluent<KafkaAuthSpecBuilder> implements VisitableBuilder<KafkaAuthSpec,KafkaAuthSpecBuilder>{

  KafkaAuthSpecFluent<?> fluent;

  public KafkaAuthSpecBuilder() {
    this(new KafkaAuthSpec());
  }
  
  public KafkaAuthSpecBuilder(KafkaAuthSpecFluent<?> fluent) {
    this(fluent, new KafkaAuthSpec());
  }
  
  public KafkaAuthSpecBuilder(KafkaAuthSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaAuthSpecBuilder(KafkaAuthSpecFluent<?> fluent,KafkaAuthSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaAuthSpec build() {
    KafkaAuthSpec buildable = new KafkaAuthSpec(fluent.getBootstrapServers(), fluent.buildNet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}