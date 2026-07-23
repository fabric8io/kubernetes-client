package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaSinkBuilder extends KafkaSinkFluent<KafkaSinkBuilder> implements VisitableBuilder<KafkaSink,KafkaSinkBuilder>{

  KafkaSinkFluent<?> fluent;

  public KafkaSinkBuilder() {
    this(new KafkaSink());
  }
  
  public KafkaSinkBuilder(KafkaSinkFluent<?> fluent) {
    this(fluent, new KafkaSink());
  }
  
  public KafkaSinkBuilder(KafkaSink instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaSinkBuilder(KafkaSinkFluent<?> fluent,KafkaSink instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaSink build() {
    KafkaSink buildable = new KafkaSink(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}