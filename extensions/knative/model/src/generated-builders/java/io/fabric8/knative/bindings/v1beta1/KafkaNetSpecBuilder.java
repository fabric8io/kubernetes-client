package io.fabric8.knative.bindings.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaNetSpecBuilder extends KafkaNetSpecFluent<KafkaNetSpecBuilder> implements VisitableBuilder<KafkaNetSpec,KafkaNetSpecBuilder>{

  KafkaNetSpecFluent<?> fluent;

  public KafkaNetSpecBuilder() {
    this(new KafkaNetSpec());
  }
  
  public KafkaNetSpecBuilder(KafkaNetSpecFluent<?> fluent) {
    this(fluent, new KafkaNetSpec());
  }
  
  public KafkaNetSpecBuilder(KafkaNetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaNetSpecBuilder(KafkaNetSpecFluent<?> fluent,KafkaNetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaNetSpec build() {
    KafkaNetSpec buildable = new KafkaNetSpec(fluent.buildSasl(), fluent.buildTls());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}