package io.fabric8.kubernetes.api.model.apps;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatefulSetConditionBuilder extends StatefulSetConditionFluent<StatefulSetConditionBuilder> implements VisitableBuilder<StatefulSetCondition,StatefulSetConditionBuilder>{

  StatefulSetConditionFluent<?> fluent;

  public StatefulSetConditionBuilder() {
    this(new StatefulSetCondition());
  }
  
  public StatefulSetConditionBuilder(StatefulSetConditionFluent<?> fluent) {
    this(fluent, new StatefulSetCondition());
  }
  
  public StatefulSetConditionBuilder(StatefulSetCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatefulSetConditionBuilder(StatefulSetConditionFluent<?> fluent,StatefulSetCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatefulSetCondition build() {
    StatefulSetCondition buildable = new StatefulSetCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}