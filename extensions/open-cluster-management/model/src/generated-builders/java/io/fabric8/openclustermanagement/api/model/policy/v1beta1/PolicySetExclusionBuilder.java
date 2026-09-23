package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicySetExclusionBuilder extends PolicySetExclusionFluent<PolicySetExclusionBuilder> implements VisitableBuilder<PolicySetExclusion,PolicySetExclusionBuilder>{

  PolicySetExclusionFluent<?> fluent;

  public PolicySetExclusionBuilder() {
    this(new PolicySetExclusion());
  }
  
  public PolicySetExclusionBuilder(PolicySetExclusionFluent<?> fluent) {
    this(fluent, new PolicySetExclusion());
  }
  
  public PolicySetExclusionBuilder(PolicySetExclusion instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicySetExclusionBuilder(PolicySetExclusionFluent<?> fluent,PolicySetExclusion instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicySetExclusion build() {
    PolicySetExclusion buildable = new PolicySetExclusion(fluent.getClusterNames(), fluent.getPolicyName(), fluent.getReason());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}