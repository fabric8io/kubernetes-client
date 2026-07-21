package io.fabric8.knative.sources.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaSourceStatusBuilder extends KafkaSourceStatusFluent<KafkaSourceStatusBuilder> implements VisitableBuilder<KafkaSourceStatus,KafkaSourceStatusBuilder>{

  KafkaSourceStatusFluent<?> fluent;

  public KafkaSourceStatusBuilder() {
    this(new KafkaSourceStatus());
  }
  
  public KafkaSourceStatusBuilder(KafkaSourceStatusFluent<?> fluent) {
    this(fluent, new KafkaSourceStatus());
  }
  
  public KafkaSourceStatusBuilder(KafkaSourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaSourceStatusBuilder(KafkaSourceStatusFluent<?> fluent,KafkaSourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaSourceStatus build() {
    KafkaSourceStatus buildable = new KafkaSourceStatus(fluent.getAnnotations(), fluent.buildAuth(), fluent.buildCeAttributes(), fluent.getClaims(), fluent.buildConditions(), fluent.getConsumers(), fluent.getMaxAllowedVReplicas(), fluent.getObservedGeneration(), fluent.buildPlacements(), fluent.getSelector(), fluent.getSinkAudience(), fluent.getSinkCACerts(), fluent.getSinkUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}