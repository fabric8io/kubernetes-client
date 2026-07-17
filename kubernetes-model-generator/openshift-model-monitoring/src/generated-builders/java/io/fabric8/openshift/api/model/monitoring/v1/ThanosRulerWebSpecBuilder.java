package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ThanosRulerWebSpecBuilder extends ThanosRulerWebSpecFluent<ThanosRulerWebSpecBuilder> implements VisitableBuilder<ThanosRulerWebSpec,ThanosRulerWebSpecBuilder>{

  ThanosRulerWebSpecFluent<?> fluent;

  public ThanosRulerWebSpecBuilder() {
    this(new ThanosRulerWebSpec());
  }
  
  public ThanosRulerWebSpecBuilder(ThanosRulerWebSpecFluent<?> fluent) {
    this(fluent, new ThanosRulerWebSpec());
  }
  
  public ThanosRulerWebSpecBuilder(ThanosRulerWebSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ThanosRulerWebSpecBuilder(ThanosRulerWebSpecFluent<?> fluent,ThanosRulerWebSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ThanosRulerWebSpec build() {
    ThanosRulerWebSpec buildable = new ThanosRulerWebSpec(fluent.buildHttpConfig(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}