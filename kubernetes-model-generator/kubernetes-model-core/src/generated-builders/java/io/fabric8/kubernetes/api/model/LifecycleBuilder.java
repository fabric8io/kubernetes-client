package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LifecycleBuilder extends LifecycleFluent<LifecycleBuilder> implements VisitableBuilder<Lifecycle,LifecycleBuilder>{

  LifecycleFluent<?> fluent;

  public LifecycleBuilder() {
    this(new Lifecycle());
  }
  
  public LifecycleBuilder(LifecycleFluent<?> fluent) {
    this(fluent, new Lifecycle());
  }
  
  public LifecycleBuilder(Lifecycle instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LifecycleBuilder(LifecycleFluent<?> fluent,Lifecycle instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Lifecycle build() {
    Lifecycle buildable = new Lifecycle(fluent.buildPostStart(), fluent.buildPreStop(), fluent.getStopSignal());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}