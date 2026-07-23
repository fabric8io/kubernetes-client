package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExpressionWarningBuilder extends ExpressionWarningFluent<ExpressionWarningBuilder> implements VisitableBuilder<ExpressionWarning,ExpressionWarningBuilder>{

  ExpressionWarningFluent<?> fluent;

  public ExpressionWarningBuilder() {
    this(new ExpressionWarning());
  }
  
  public ExpressionWarningBuilder(ExpressionWarningFluent<?> fluent) {
    this(fluent, new ExpressionWarning());
  }
  
  public ExpressionWarningBuilder(ExpressionWarning instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExpressionWarningBuilder(ExpressionWarningFluent<?> fluent,ExpressionWarning instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExpressionWarning build() {
    ExpressionWarning buildable = new ExpressionWarning(fluent.getFieldRef(), fluent.getWarning());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}