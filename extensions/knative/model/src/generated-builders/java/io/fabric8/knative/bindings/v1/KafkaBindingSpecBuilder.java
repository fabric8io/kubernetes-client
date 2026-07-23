package io.fabric8.knative.bindings.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaBindingSpecBuilder extends KafkaBindingSpecFluent<KafkaBindingSpecBuilder> implements VisitableBuilder<KafkaBindingSpec,KafkaBindingSpecBuilder>{

  KafkaBindingSpecFluent<?> fluent;

  public KafkaBindingSpecBuilder() {
    this(new KafkaBindingSpec());
  }
  
  public KafkaBindingSpecBuilder(KafkaBindingSpecFluent<?> fluent) {
    this(fluent, new KafkaBindingSpec());
  }
  
  public KafkaBindingSpecBuilder(KafkaBindingSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaBindingSpecBuilder(KafkaBindingSpecFluent<?> fluent,KafkaBindingSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaBindingSpec build() {
    KafkaBindingSpec buildable = new KafkaBindingSpec(fluent.getBootstrapServers(), fluent.buildNet(), fluent.buildSubject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}