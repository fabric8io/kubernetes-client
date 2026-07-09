package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ValidationRuleBuilder extends ValidationRuleFluent<ValidationRuleBuilder> implements VisitableBuilder<ValidationRule,ValidationRuleBuilder>{

  ValidationRuleFluent<?> fluent;

  public ValidationRuleBuilder() {
    this(new ValidationRule());
  }
  
  public ValidationRuleBuilder(ValidationRuleFluent<?> fluent) {
    this(fluent, new ValidationRule());
  }
  
  public ValidationRuleBuilder(ValidationRule instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ValidationRuleBuilder(ValidationRuleFluent<?> fluent,ValidationRule instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ValidationRule build() {
    ValidationRule buildable = new ValidationRule(fluent.getFieldPath(), fluent.getMessage(), fluent.getMessageExpression(), fluent.getOptionalOldSelf(), fluent.getReason(), fluent.getRule());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}