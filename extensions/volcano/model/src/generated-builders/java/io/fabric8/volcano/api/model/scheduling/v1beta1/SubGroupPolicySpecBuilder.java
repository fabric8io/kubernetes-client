package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubGroupPolicySpecBuilder extends SubGroupPolicySpecFluent<SubGroupPolicySpecBuilder> implements VisitableBuilder<SubGroupPolicySpec,SubGroupPolicySpecBuilder>{

  SubGroupPolicySpecFluent<?> fluent;

  public SubGroupPolicySpecBuilder() {
    this(new SubGroupPolicySpec());
  }
  
  public SubGroupPolicySpecBuilder(SubGroupPolicySpecFluent<?> fluent) {
    this(fluent, new SubGroupPolicySpec());
  }
  
  public SubGroupPolicySpecBuilder(SubGroupPolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubGroupPolicySpecBuilder(SubGroupPolicySpecFluent<?> fluent,SubGroupPolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubGroupPolicySpec build() {
    SubGroupPolicySpec buildable = new SubGroupPolicySpec(fluent.buildLabelSelector(), fluent.getMatchLabelKeys(), fluent.getMinSubGroups(), fluent.getName(), fluent.buildNetworkTopology(), fluent.getSubGroupSize());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}