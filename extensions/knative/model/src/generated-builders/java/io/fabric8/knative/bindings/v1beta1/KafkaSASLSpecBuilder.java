package io.fabric8.knative.bindings.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaSASLSpecBuilder extends KafkaSASLSpecFluent<KafkaSASLSpecBuilder> implements VisitableBuilder<KafkaSASLSpec,KafkaSASLSpecBuilder>{

  KafkaSASLSpecFluent<?> fluent;

  public KafkaSASLSpecBuilder() {
    this(new KafkaSASLSpec());
  }
  
  public KafkaSASLSpecBuilder(KafkaSASLSpecFluent<?> fluent) {
    this(fluent, new KafkaSASLSpec());
  }
  
  public KafkaSASLSpecBuilder(KafkaSASLSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaSASLSpecBuilder(KafkaSASLSpecFluent<?> fluent,KafkaSASLSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaSASLSpec build() {
    KafkaSASLSpec buildable = new KafkaSASLSpec(fluent.getEnable(), fluent.buildPassword(), fluent.buildType(), fluent.buildUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}