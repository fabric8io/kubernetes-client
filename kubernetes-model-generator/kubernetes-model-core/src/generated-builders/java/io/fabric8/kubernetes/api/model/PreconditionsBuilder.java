package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PreconditionsBuilder extends PreconditionsFluent<PreconditionsBuilder> implements VisitableBuilder<Preconditions,PreconditionsBuilder>{

  PreconditionsFluent<?> fluent;

  public PreconditionsBuilder() {
    this(new Preconditions());
  }
  
  public PreconditionsBuilder(PreconditionsFluent<?> fluent) {
    this(fluent, new Preconditions());
  }
  
  public PreconditionsBuilder(Preconditions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PreconditionsBuilder(PreconditionsFluent<?> fluent,Preconditions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Preconditions build() {
    Preconditions buildable = new Preconditions(fluent.getResourceVersion(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}