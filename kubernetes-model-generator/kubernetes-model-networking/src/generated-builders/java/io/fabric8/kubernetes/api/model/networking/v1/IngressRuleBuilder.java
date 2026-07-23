package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressRuleBuilder extends IngressRuleFluent<IngressRuleBuilder> implements VisitableBuilder<IngressRule,IngressRuleBuilder>{

  IngressRuleFluent<?> fluent;

  public IngressRuleBuilder() {
    this(new IngressRule());
  }
  
  public IngressRuleBuilder(IngressRuleFluent<?> fluent) {
    this(fluent, new IngressRule());
  }
  
  public IngressRuleBuilder(IngressRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressRuleBuilder(IngressRuleFluent<?> fluent,IngressRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressRule build() {
    IngressRule buildable = new IngressRule(fluent.getHost(), fluent.buildHttp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}