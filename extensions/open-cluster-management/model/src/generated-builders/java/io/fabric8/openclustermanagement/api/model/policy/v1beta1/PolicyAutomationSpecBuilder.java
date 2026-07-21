package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyAutomationSpecBuilder extends PolicyAutomationSpecFluent<PolicyAutomationSpecBuilder> implements VisitableBuilder<PolicyAutomationSpec,PolicyAutomationSpecBuilder>{

  PolicyAutomationSpecFluent<?> fluent;

  public PolicyAutomationSpecBuilder() {
    this(new PolicyAutomationSpec());
  }
  
  public PolicyAutomationSpecBuilder(PolicyAutomationSpecFluent<?> fluent) {
    this(fluent, new PolicyAutomationSpec());
  }
  
  public PolicyAutomationSpecBuilder(PolicyAutomationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyAutomationSpecBuilder(PolicyAutomationSpecFluent<?> fluent,PolicyAutomationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyAutomationSpec build() {
    PolicyAutomationSpec buildable = new PolicyAutomationSpec(fluent.buildAutomationDef(), fluent.getDelayAfterRunSeconds(), fluent.getEventHook(), fluent.getMode(), fluent.getPolicyRef(), fluent.getRescanAfter());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}