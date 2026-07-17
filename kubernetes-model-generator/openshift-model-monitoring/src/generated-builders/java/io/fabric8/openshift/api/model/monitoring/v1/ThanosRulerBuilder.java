package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ThanosRulerBuilder extends ThanosRulerFluent<ThanosRulerBuilder> implements VisitableBuilder<ThanosRuler,ThanosRulerBuilder>{

  ThanosRulerFluent<?> fluent;

  public ThanosRulerBuilder() {
    this(new ThanosRuler());
  }
  
  public ThanosRulerBuilder(ThanosRulerFluent<?> fluent) {
    this(fluent, new ThanosRuler());
  }
  
  public ThanosRulerBuilder(ThanosRuler instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ThanosRulerBuilder(ThanosRulerFluent<?> fluent,ThanosRuler instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ThanosRuler build() {
    ThanosRuler buildable = new ThanosRuler(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}