package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaSinkStatusBuilder extends KafkaSinkStatusFluent<KafkaSinkStatusBuilder> implements VisitableBuilder<KafkaSinkStatus,KafkaSinkStatusBuilder>{

  KafkaSinkStatusFluent<?> fluent;

  public KafkaSinkStatusBuilder() {
    this(new KafkaSinkStatus());
  }
  
  public KafkaSinkStatusBuilder(KafkaSinkStatusFluent<?> fluent) {
    this(fluent, new KafkaSinkStatus());
  }
  
  public KafkaSinkStatusBuilder(KafkaSinkStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaSinkStatusBuilder(KafkaSinkStatusFluent<?> fluent,KafkaSinkStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaSinkStatus build() {
    KafkaSinkStatus buildable = new KafkaSinkStatus(fluent.buildAddressStatus(), fluent.getAnnotations(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.buildPolicies());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}