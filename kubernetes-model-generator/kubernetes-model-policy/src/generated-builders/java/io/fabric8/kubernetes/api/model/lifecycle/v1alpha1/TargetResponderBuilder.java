package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TargetResponderBuilder extends TargetResponderFluent<TargetResponderBuilder> implements VisitableBuilder<TargetResponder,TargetResponderBuilder>{

  TargetResponderFluent<?> fluent;

  public TargetResponderBuilder() {
    this(new TargetResponder());
  }
  
  public TargetResponderBuilder(TargetResponderFluent<?> fluent) {
    this(fluent, new TargetResponder());
  }
  
  public TargetResponderBuilder(TargetResponder instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TargetResponderBuilder(TargetResponderFluent<?> fluent,TargetResponder instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TargetResponder build() {
    TargetResponder buildable = new TargetResponder(fluent.getName(), fluent.getPriority(), fluent.getState());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}