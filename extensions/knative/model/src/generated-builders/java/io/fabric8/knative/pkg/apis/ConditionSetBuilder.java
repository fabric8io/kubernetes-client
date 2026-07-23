package io.fabric8.knative.pkg.apis;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConditionSetBuilder extends ConditionSetFluent<ConditionSetBuilder> implements VisitableBuilder<ConditionSet,ConditionSetBuilder>{

  ConditionSetFluent<?> fluent;

  public ConditionSetBuilder() {
    this(new ConditionSet());
  }
  
  public ConditionSetBuilder(ConditionSetFluent<?> fluent) {
    this(fluent, new ConditionSet());
  }
  
  public ConditionSetBuilder(ConditionSet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConditionSetBuilder(ConditionSetFluent<?> fluent,ConditionSet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConditionSet build() {
    ConditionSet buildable = new ConditionSet();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}