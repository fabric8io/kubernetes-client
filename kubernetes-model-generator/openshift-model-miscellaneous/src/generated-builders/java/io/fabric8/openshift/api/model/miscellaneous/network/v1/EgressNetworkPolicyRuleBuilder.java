package io.fabric8.openshift.api.model.miscellaneous.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressNetworkPolicyRuleBuilder extends EgressNetworkPolicyRuleFluent<EgressNetworkPolicyRuleBuilder> implements VisitableBuilder<EgressNetworkPolicyRule,EgressNetworkPolicyRuleBuilder>{

  EgressNetworkPolicyRuleFluent<?> fluent;

  public EgressNetworkPolicyRuleBuilder() {
    this(new EgressNetworkPolicyRule());
  }
  
  public EgressNetworkPolicyRuleBuilder(EgressNetworkPolicyRuleFluent<?> fluent) {
    this(fluent, new EgressNetworkPolicyRule());
  }
  
  public EgressNetworkPolicyRuleBuilder(EgressNetworkPolicyRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressNetworkPolicyRuleBuilder(EgressNetworkPolicyRuleFluent<?> fluent,EgressNetworkPolicyRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressNetworkPolicyRule build() {
    EgressNetworkPolicyRule buildable = new EgressNetworkPolicyRule(fluent.buildTo(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}