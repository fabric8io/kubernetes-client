package io.fabric8.kubernetes.api.model.scheduling.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GangSchedulingPolicyBuilder extends GangSchedulingPolicyFluent<GangSchedulingPolicyBuilder> implements VisitableBuilder<GangSchedulingPolicy,GangSchedulingPolicyBuilder>{

  GangSchedulingPolicyFluent<?> fluent;

  public GangSchedulingPolicyBuilder() {
    this(new GangSchedulingPolicy());
  }
  
  public GangSchedulingPolicyBuilder(GangSchedulingPolicyFluent<?> fluent) {
    this(fluent, new GangSchedulingPolicy());
  }
  
  public GangSchedulingPolicyBuilder(GangSchedulingPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GangSchedulingPolicyBuilder(GangSchedulingPolicyFluent<?> fluent,GangSchedulingPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GangSchedulingPolicy build() {
    GangSchedulingPolicy buildable = new GangSchedulingPolicy(fluent.getMinCount());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}