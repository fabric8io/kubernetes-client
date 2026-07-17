package io.fabric8.openshift.api.model.operator.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class L4RedirectRuleBuilder extends L4RedirectRuleFluent<L4RedirectRuleBuilder> implements VisitableBuilder<L4RedirectRule,L4RedirectRuleBuilder>{

  L4RedirectRuleFluent<?> fluent;

  public L4RedirectRuleBuilder() {
    this(new L4RedirectRule());
  }
  
  public L4RedirectRuleBuilder(L4RedirectRuleFluent<?> fluent) {
    this(fluent, new L4RedirectRule());
  }
  
  public L4RedirectRuleBuilder(L4RedirectRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public L4RedirectRuleBuilder(L4RedirectRuleFluent<?> fluent,L4RedirectRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public L4RedirectRule build() {
    L4RedirectRule buildable = new L4RedirectRule(fluent.getDestinationIP(), fluent.getPort(), fluent.getProtocol(), fluent.getTargetPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}