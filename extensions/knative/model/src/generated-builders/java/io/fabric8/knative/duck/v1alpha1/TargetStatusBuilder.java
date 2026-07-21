package io.fabric8.knative.duck.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TargetStatusBuilder extends TargetStatusFluent<TargetStatusBuilder> implements VisitableBuilder<TargetStatus,TargetStatusBuilder>{

  TargetStatusFluent<?> fluent;

  public TargetStatusBuilder() {
    this(new TargetStatus());
  }
  
  public TargetStatusBuilder(TargetStatusFluent<?> fluent) {
    this(fluent, new TargetStatus());
  }
  
  public TargetStatusBuilder(TargetStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TargetStatusBuilder(TargetStatusFluent<?> fluent,TargetStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TargetStatus build() {
    TargetStatus buildable = new TargetStatus(fluent.buildTargetable());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}