package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicySetSpecBuilder extends PolicySetSpecFluent<PolicySetSpecBuilder> implements VisitableBuilder<PolicySetSpec,PolicySetSpecBuilder>{

  PolicySetSpecFluent<?> fluent;

  public PolicySetSpecBuilder() {
    this(new PolicySetSpec());
  }
  
  public PolicySetSpecBuilder(PolicySetSpecFluent<?> fluent) {
    this(fluent, new PolicySetSpec());
  }
  
  public PolicySetSpecBuilder(PolicySetSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicySetSpecBuilder(PolicySetSpecFluent<?> fluent,PolicySetSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicySetSpec build() {
    PolicySetSpec buildable = new PolicySetSpec(fluent.getDescription(), fluent.getPolicies());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}