package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CompositeGangSchedulingPolicyBuilder extends CompositeGangSchedulingPolicyFluent<CompositeGangSchedulingPolicyBuilder> implements VisitableBuilder<CompositeGangSchedulingPolicy,CompositeGangSchedulingPolicyBuilder>{

  CompositeGangSchedulingPolicyFluent<?> fluent;

  public CompositeGangSchedulingPolicyBuilder() {
    this(new CompositeGangSchedulingPolicy());
  }
  
  public CompositeGangSchedulingPolicyBuilder(CompositeGangSchedulingPolicyFluent<?> fluent) {
    this(fluent, new CompositeGangSchedulingPolicy());
  }
  
  public CompositeGangSchedulingPolicyBuilder(CompositeGangSchedulingPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CompositeGangSchedulingPolicyBuilder(CompositeGangSchedulingPolicyFluent<?> fluent,CompositeGangSchedulingPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CompositeGangSchedulingPolicy build() {
    CompositeGangSchedulingPolicy buildable = new CompositeGangSchedulingPolicy(fluent.getMinGroupCount());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}