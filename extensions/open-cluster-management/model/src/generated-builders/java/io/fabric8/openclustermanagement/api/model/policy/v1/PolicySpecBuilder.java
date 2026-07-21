package io.fabric8.openclustermanagement.api.model.policy.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicySpecBuilder extends PolicySpecFluent<PolicySpecBuilder> implements VisitableBuilder<PolicySpec,PolicySpecBuilder>{

  PolicySpecFluent<?> fluent;

  public PolicySpecBuilder() {
    this(new PolicySpec());
  }
  
  public PolicySpecBuilder(PolicySpecFluent<?> fluent) {
    this(fluent, new PolicySpec());
  }
  
  public PolicySpecBuilder(PolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicySpecBuilder(PolicySpecFluent<?> fluent,PolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicySpec build() {
    PolicySpec buildable = new PolicySpec(fluent.getCopyPolicyMetadata(), fluent.buildDependencies(), fluent.getDisabled(), fluent.buildHubTemplateOptions(), fluent.buildPolicyTemplates(), fluent.getRemediationAction());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}