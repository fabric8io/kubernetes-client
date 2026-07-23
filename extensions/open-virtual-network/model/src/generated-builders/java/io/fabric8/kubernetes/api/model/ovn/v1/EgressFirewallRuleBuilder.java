package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressFirewallRuleBuilder extends EgressFirewallRuleFluent<EgressFirewallRuleBuilder> implements VisitableBuilder<EgressFirewallRule,EgressFirewallRuleBuilder>{

  EgressFirewallRuleFluent<?> fluent;

  public EgressFirewallRuleBuilder() {
    this(new EgressFirewallRule());
  }
  
  public EgressFirewallRuleBuilder(EgressFirewallRuleFluent<?> fluent) {
    this(fluent, new EgressFirewallRule());
  }
  
  public EgressFirewallRuleBuilder(EgressFirewallRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressFirewallRuleBuilder(EgressFirewallRuleFluent<?> fluent,EgressFirewallRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressFirewallRule build() {
    EgressFirewallRule buildable = new EgressFirewallRule(fluent.buildPorts(), fluent.buildTo(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}