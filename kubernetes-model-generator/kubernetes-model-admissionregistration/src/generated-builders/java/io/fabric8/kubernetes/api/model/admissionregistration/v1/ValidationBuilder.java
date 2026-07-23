package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ValidationBuilder extends ValidationFluent<ValidationBuilder> implements VisitableBuilder<Validation,ValidationBuilder>{

  ValidationFluent<?> fluent;

  public ValidationBuilder() {
    this(new Validation());
  }
  
  public ValidationBuilder(ValidationFluent<?> fluent) {
    this(fluent, new Validation());
  }
  
  public ValidationBuilder(Validation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ValidationBuilder(ValidationFluent<?> fluent,Validation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Validation build() {
    Validation buildable = new Validation(fluent.getExpression(), fluent.getMessage(), fluent.getMessageExpression(), fluent.getReason());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}