package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TargetSelectorBuilder extends TargetSelectorFluent<TargetSelectorBuilder> implements VisitableBuilder<TargetSelector,TargetSelectorBuilder>{

  TargetSelectorFluent<?> fluent;

  public TargetSelectorBuilder() {
    this(new TargetSelector());
  }
  
  public TargetSelectorBuilder(TargetSelectorFluent<?> fluent) {
    this(fluent, new TargetSelector());
  }
  
  public TargetSelectorBuilder(TargetSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TargetSelectorBuilder(TargetSelectorFluent<?> fluent,TargetSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TargetSelector build() {
    TargetSelector buildable = new TargetSelector(fluent.getFieldPaths(), fluent.buildOptions(), fluent.buildReject(), fluent.buildSelect());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}