package io.fabric8.kubernetes.api.model.admissionregistration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MatchConditionBuilder extends MatchConditionFluent<MatchConditionBuilder> implements VisitableBuilder<MatchCondition,MatchConditionBuilder>{

  MatchConditionFluent<?> fluent;

  public MatchConditionBuilder() {
    this(new MatchCondition());
  }
  
  public MatchConditionBuilder(MatchConditionFluent<?> fluent) {
    this(fluent, new MatchCondition());
  }
  
  public MatchConditionBuilder(MatchCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MatchConditionBuilder(MatchConditionFluent<?> fluent,MatchCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MatchCondition build() {
    MatchCondition buildable = new MatchCondition(fluent.getExpression(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}