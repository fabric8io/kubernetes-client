package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PolicyAutomationListBuilder extends PolicyAutomationListFluent<PolicyAutomationListBuilder> implements VisitableBuilder<PolicyAutomationList,PolicyAutomationListBuilder>{

  PolicyAutomationListFluent<?> fluent;

  public PolicyAutomationListBuilder() {
    this(new PolicyAutomationList());
  }
  
  public PolicyAutomationListBuilder(PolicyAutomationListFluent<?> fluent) {
    this(fluent, new PolicyAutomationList());
  }
  
  public PolicyAutomationListBuilder(PolicyAutomationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PolicyAutomationListBuilder(PolicyAutomationListFluent<?> fluent,PolicyAutomationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PolicyAutomationList build() {
    PolicyAutomationList buildable = new PolicyAutomationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}