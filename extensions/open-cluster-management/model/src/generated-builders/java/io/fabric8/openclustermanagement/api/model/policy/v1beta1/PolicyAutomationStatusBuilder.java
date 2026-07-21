package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyAutomationStatusBuilder extends PolicyAutomationStatusFluent<PolicyAutomationStatusBuilder> implements VisitableBuilder<PolicyAutomationStatus,PolicyAutomationStatusBuilder>{

  PolicyAutomationStatusFluent<?> fluent;

  public PolicyAutomationStatusBuilder() {
    this(new PolicyAutomationStatus());
  }
  
  public PolicyAutomationStatusBuilder(PolicyAutomationStatusFluent<?> fluent) {
    this(fluent, new PolicyAutomationStatus());
  }
  
  public PolicyAutomationStatusBuilder(PolicyAutomationStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyAutomationStatusBuilder(PolicyAutomationStatusFluent<?> fluent,PolicyAutomationStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyAutomationStatus build() {
    PolicyAutomationStatus buildable = new PolicyAutomationStatus(fluent.getClustersWithEvent());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}