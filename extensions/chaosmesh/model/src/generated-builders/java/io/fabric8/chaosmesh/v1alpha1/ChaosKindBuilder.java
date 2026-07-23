package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChaosKindBuilder extends ChaosKindFluent<ChaosKindBuilder> implements VisitableBuilder<ChaosKind,ChaosKindBuilder>{

  ChaosKindFluent<?> fluent;

  public ChaosKindBuilder() {
    this(new ChaosKind());
  }
  
  public ChaosKindBuilder(ChaosKindFluent<?> fluent) {
    this(fluent, new ChaosKind());
  }
  
  public ChaosKindBuilder(ChaosKind instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChaosKindBuilder(ChaosKindFluent<?> fluent,ChaosKind instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChaosKind build() {
    ChaosKind buildable = new ChaosKind();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}