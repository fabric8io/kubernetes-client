package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressQoSRuleBuilder extends EgressQoSRuleFluent<EgressQoSRuleBuilder> implements VisitableBuilder<EgressQoSRule,EgressQoSRuleBuilder>{

  EgressQoSRuleFluent<?> fluent;

  public EgressQoSRuleBuilder() {
    this(new EgressQoSRule());
  }
  
  public EgressQoSRuleBuilder(EgressQoSRuleFluent<?> fluent) {
    this(fluent, new EgressQoSRule());
  }
  
  public EgressQoSRuleBuilder(EgressQoSRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressQoSRuleBuilder(EgressQoSRuleFluent<?> fluent,EgressQoSRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressQoSRule build() {
    EgressQoSRule buildable = new EgressQoSRule(fluent.getDscp(), fluent.getDstCIDR(), fluent.buildPodSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}