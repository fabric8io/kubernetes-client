package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaSourceBuilder extends KafkaSourceFluent<KafkaSourceBuilder> implements VisitableBuilder<KafkaSource,KafkaSourceBuilder>{

  KafkaSourceFluent<?> fluent;

  public KafkaSourceBuilder() {
    this(new KafkaSource());
  }
  
  public KafkaSourceBuilder(KafkaSourceFluent<?> fluent) {
    this(fluent, new KafkaSource());
  }
  
  public KafkaSourceBuilder(KafkaSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaSourceBuilder(KafkaSourceFluent<?> fluent,KafkaSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaSource build() {
    KafkaSource buildable = new KafkaSource(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}