package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PromQLClusterConditionBuilder extends PromQLClusterConditionFluent<PromQLClusterConditionBuilder> implements VisitableBuilder<PromQLClusterCondition,PromQLClusterConditionBuilder>{

  PromQLClusterConditionFluent<?> fluent;

  public PromQLClusterConditionBuilder() {
    this(new PromQLClusterCondition());
  }
  
  public PromQLClusterConditionBuilder(PromQLClusterConditionFluent<?> fluent) {
    this(fluent, new PromQLClusterCondition());
  }
  
  public PromQLClusterConditionBuilder(PromQLClusterCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PromQLClusterConditionBuilder(PromQLClusterConditionFluent<?> fluent,PromQLClusterCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PromQLClusterCondition build() {
    PromQLClusterCondition buildable = new PromQLClusterCondition(fluent.getPromql());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}