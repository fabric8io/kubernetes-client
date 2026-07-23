package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyBuilder extends PolicyFluent<PolicyBuilder> implements VisitableBuilder<Policy,PolicyBuilder>{

  PolicyFluent<?> fluent;

  public PolicyBuilder() {
    this(new Policy());
  }
  
  public PolicyBuilder(PolicyFluent<?> fluent) {
    this(fluent, new Policy());
  }
  
  public PolicyBuilder(Policy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyBuilder(PolicyFluent<?> fluent,Policy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Policy build() {
    Policy buildable = new Policy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}