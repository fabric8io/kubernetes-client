package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyExclusionBuilder extends PolicyExclusionFluent<PolicyExclusionBuilder> implements VisitableBuilder<PolicyExclusion,PolicyExclusionBuilder>{

  PolicyExclusionFluent<?> fluent;

  public PolicyExclusionBuilder() {
    this(new PolicyExclusion());
  }
  
  public PolicyExclusionBuilder(PolicyExclusionFluent<?> fluent) {
    this(fluent, new PolicyExclusion());
  }
  
  public PolicyExclusionBuilder(PolicyExclusion instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyExclusionBuilder(PolicyExclusionFluent<?> fluent,PolicyExclusion instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyExclusion build() {
    PolicyExclusion buildable = new PolicyExclusion(fluent.getClusterName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}