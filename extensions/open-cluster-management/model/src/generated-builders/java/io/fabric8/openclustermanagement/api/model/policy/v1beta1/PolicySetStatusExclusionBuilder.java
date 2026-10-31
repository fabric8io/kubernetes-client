package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicySetStatusExclusionBuilder extends PolicySetStatusExclusionFluent<PolicySetStatusExclusionBuilder> implements VisitableBuilder<PolicySetStatusExclusion,PolicySetStatusExclusionBuilder>{

  PolicySetStatusExclusionFluent<?> fluent;

  public PolicySetStatusExclusionBuilder() {
    this(new PolicySetStatusExclusion());
  }
  
  public PolicySetStatusExclusionBuilder(PolicySetStatusExclusionFluent<?> fluent) {
    this(fluent, new PolicySetStatusExclusion());
  }
  
  public PolicySetStatusExclusionBuilder(PolicySetStatusExclusion instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicySetStatusExclusionBuilder(PolicySetStatusExclusionFluent<?> fluent,PolicySetStatusExclusion instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicySetStatusExclusion build() {
    PolicySetStatusExclusion buildable = new PolicySetStatusExclusion(fluent.getClusters(), fluent.getPolicyName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}