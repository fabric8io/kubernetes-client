package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AuditCustomRuleBuilder extends AuditCustomRuleFluent<AuditCustomRuleBuilder> implements VisitableBuilder<AuditCustomRule,AuditCustomRuleBuilder>{

  AuditCustomRuleFluent<?> fluent;

  public AuditCustomRuleBuilder() {
    this(new AuditCustomRule());
  }
  
  public AuditCustomRuleBuilder(AuditCustomRuleFluent<?> fluent) {
    this(fluent, new AuditCustomRule());
  }
  
  public AuditCustomRuleBuilder(AuditCustomRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AuditCustomRuleBuilder(AuditCustomRuleFluent<?> fluent,AuditCustomRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AuditCustomRule build() {
    AuditCustomRule buildable = new AuditCustomRule(fluent.getGroup(), fluent.getProfile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}