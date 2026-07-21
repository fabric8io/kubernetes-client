package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WhenExpressionBuilder extends WhenExpressionFluent<WhenExpressionBuilder> implements VisitableBuilder<WhenExpression,WhenExpressionBuilder>{

  WhenExpressionFluent<?> fluent;

  public WhenExpressionBuilder() {
    this(new WhenExpression());
  }
  
  public WhenExpressionBuilder(WhenExpressionFluent<?> fluent) {
    this(fluent, new WhenExpression());
  }
  
  public WhenExpressionBuilder(WhenExpression instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WhenExpressionBuilder(WhenExpressionFluent<?> fluent,WhenExpression instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WhenExpression build() {
    WhenExpression buildable = new WhenExpression(fluent.getCel(), fluent.getInput(), fluent.getOperator(), fluent.getValues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}