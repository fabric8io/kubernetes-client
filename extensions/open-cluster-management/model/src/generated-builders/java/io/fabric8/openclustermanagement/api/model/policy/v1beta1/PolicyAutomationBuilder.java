package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyAutomationBuilder extends PolicyAutomationFluent<PolicyAutomationBuilder> implements VisitableBuilder<PolicyAutomation,PolicyAutomationBuilder>{

  PolicyAutomationFluent<?> fluent;

  public PolicyAutomationBuilder() {
    this(new PolicyAutomation());
  }
  
  public PolicyAutomationBuilder(PolicyAutomationFluent<?> fluent) {
    this(fluent, new PolicyAutomation());
  }
  
  public PolicyAutomationBuilder(PolicyAutomation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyAutomationBuilder(PolicyAutomationFluent<?> fluent,PolicyAutomation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyAutomation build() {
    PolicyAutomation buildable = new PolicyAutomation(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}