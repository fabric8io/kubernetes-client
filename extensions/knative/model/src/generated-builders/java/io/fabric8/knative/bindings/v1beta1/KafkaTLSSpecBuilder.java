package io.fabric8.knative.bindings.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaTLSSpecBuilder extends KafkaTLSSpecFluent<KafkaTLSSpecBuilder> implements VisitableBuilder<KafkaTLSSpec,KafkaTLSSpecBuilder>{

  KafkaTLSSpecFluent<?> fluent;

  public KafkaTLSSpecBuilder() {
    this(new KafkaTLSSpec());
  }
  
  public KafkaTLSSpecBuilder(KafkaTLSSpecFluent<?> fluent) {
    this(fluent, new KafkaTLSSpec());
  }
  
  public KafkaTLSSpecBuilder(KafkaTLSSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaTLSSpecBuilder(KafkaTLSSpecFluent<?> fluent,KafkaTLSSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaTLSSpec build() {
    KafkaTLSSpec buildable = new KafkaTLSSpec(fluent.buildCaCert(), fluent.buildCert(), fluent.getEnable(), fluent.buildKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}