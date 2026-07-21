package io.fabric8.knative.bindings.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaBindingStatusBuilder extends KafkaBindingStatusFluent<KafkaBindingStatusBuilder> implements VisitableBuilder<KafkaBindingStatus,KafkaBindingStatusBuilder>{

  KafkaBindingStatusFluent<?> fluent;

  public KafkaBindingStatusBuilder() {
    this(new KafkaBindingStatus());
  }
  
  public KafkaBindingStatusBuilder(KafkaBindingStatusFluent<?> fluent) {
    this(fluent, new KafkaBindingStatus());
  }
  
  public KafkaBindingStatusBuilder(KafkaBindingStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaBindingStatusBuilder(KafkaBindingStatusFluent<?> fluent,KafkaBindingStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaBindingStatus build() {
    KafkaBindingStatus buildable = new KafkaBindingStatus(fluent.getAnnotations(), fluent.buildConditions(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}