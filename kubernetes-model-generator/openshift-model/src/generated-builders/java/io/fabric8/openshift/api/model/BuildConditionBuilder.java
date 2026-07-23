package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildConditionBuilder extends BuildConditionFluent<BuildConditionBuilder> implements VisitableBuilder<BuildCondition,BuildConditionBuilder>{

  BuildConditionFluent<?> fluent;

  public BuildConditionBuilder() {
    this(new BuildCondition());
  }
  
  public BuildConditionBuilder(BuildConditionFluent<?> fluent) {
    this(fluent, new BuildCondition());
  }
  
  public BuildConditionBuilder(BuildCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildConditionBuilder(BuildConditionFluent<?> fluent,BuildCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildCondition build() {
    BuildCondition buildable = new BuildCondition(fluent.getLastTransitionTime(), fluent.getLastUpdateTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}