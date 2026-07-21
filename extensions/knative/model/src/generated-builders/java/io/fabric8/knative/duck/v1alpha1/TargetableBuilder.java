package io.fabric8.knative.duck.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TargetableBuilder extends TargetableFluent<TargetableBuilder> implements VisitableBuilder<Targetable,TargetableBuilder>{

  TargetableFluent<?> fluent;

  public TargetableBuilder() {
    this(new Targetable());
  }
  
  public TargetableBuilder(TargetableFluent<?> fluent) {
    this(fluent, new Targetable());
  }
  
  public TargetableBuilder(Targetable instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TargetableBuilder(TargetableFluent<?> fluent,Targetable instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Targetable build() {
    Targetable buildable = new Targetable(fluent.getDomainInternal());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}