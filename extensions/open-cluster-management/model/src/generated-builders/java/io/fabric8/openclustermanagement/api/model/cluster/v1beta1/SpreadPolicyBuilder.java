package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SpreadPolicyBuilder extends SpreadPolicyFluent<SpreadPolicyBuilder> implements VisitableBuilder<SpreadPolicy,SpreadPolicyBuilder>{

  SpreadPolicyFluent<?> fluent;

  public SpreadPolicyBuilder() {
    this(new SpreadPolicy());
  }
  
  public SpreadPolicyBuilder(SpreadPolicyFluent<?> fluent) {
    this(fluent, new SpreadPolicy());
  }
  
  public SpreadPolicyBuilder(SpreadPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SpreadPolicyBuilder(SpreadPolicyFluent<?> fluent,SpreadPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SpreadPolicy build() {
    SpreadPolicy buildable = new SpreadPolicy(fluent.buildSpreadConstraints());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}