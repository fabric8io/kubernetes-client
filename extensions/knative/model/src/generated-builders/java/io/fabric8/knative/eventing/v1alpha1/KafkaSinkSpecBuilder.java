package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaSinkSpecBuilder extends KafkaSinkSpecFluent<KafkaSinkSpecBuilder> implements VisitableBuilder<KafkaSinkSpec,KafkaSinkSpecBuilder>{

  KafkaSinkSpecFluent<?> fluent;

  public KafkaSinkSpecBuilder() {
    this(new KafkaSinkSpec());
  }
  
  public KafkaSinkSpecBuilder(KafkaSinkSpecFluent<?> fluent) {
    this(fluent, new KafkaSinkSpec());
  }
  
  public KafkaSinkSpecBuilder(KafkaSinkSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaSinkSpecBuilder(KafkaSinkSpecFluent<?> fluent,KafkaSinkSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaSinkSpec build() {
    KafkaSinkSpec buildable = new KafkaSinkSpec(fluent.buildAuth(), fluent.getBootstrapServers(), fluent.getContentMode(), fluent.getNumPartitions(), fluent.getReplicationFactor(), fluent.getTopic());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}