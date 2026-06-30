package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PreferredSchedulingTermBuilder extends PreferredSchedulingTermFluent<PreferredSchedulingTermBuilder> implements VisitableBuilder<PreferredSchedulingTerm,PreferredSchedulingTermBuilder>{

  PreferredSchedulingTermFluent<?> fluent;

  public PreferredSchedulingTermBuilder() {
    this(new PreferredSchedulingTerm());
  }
  
  public PreferredSchedulingTermBuilder(PreferredSchedulingTermFluent<?> fluent) {
    this(fluent, new PreferredSchedulingTerm());
  }
  
  public PreferredSchedulingTermBuilder(PreferredSchedulingTerm instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PreferredSchedulingTermBuilder(PreferredSchedulingTermFluent<?> fluent,PreferredSchedulingTerm instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PreferredSchedulingTerm build() {
    PreferredSchedulingTerm buildable = new PreferredSchedulingTerm(fluent.buildPreference(), fluent.getWeight());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}