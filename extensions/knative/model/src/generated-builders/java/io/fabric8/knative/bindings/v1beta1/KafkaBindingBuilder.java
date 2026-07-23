package io.fabric8.knative.bindings.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaBindingBuilder extends KafkaBindingFluent<KafkaBindingBuilder> implements VisitableBuilder<KafkaBinding,KafkaBindingBuilder>{

  KafkaBindingFluent<?> fluent;

  public KafkaBindingBuilder() {
    this(new KafkaBinding());
  }
  
  public KafkaBindingBuilder(KafkaBindingFluent<?> fluent) {
    this(fluent, new KafkaBinding());
  }
  
  public KafkaBindingBuilder(KafkaBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaBindingBuilder(KafkaBindingFluent<?> fluent,KafkaBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaBinding build() {
    KafkaBinding buildable = new KafkaBinding(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}