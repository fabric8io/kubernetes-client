package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InstallPlanConditionBuilder extends InstallPlanConditionFluent<InstallPlanConditionBuilder> implements VisitableBuilder<InstallPlanCondition,InstallPlanConditionBuilder>{

  InstallPlanConditionFluent<?> fluent;

  public InstallPlanConditionBuilder() {
    this(new InstallPlanCondition());
  }
  
  public InstallPlanConditionBuilder(InstallPlanConditionFluent<?> fluent) {
    this(fluent, new InstallPlanCondition());
  }
  
  public InstallPlanConditionBuilder(InstallPlanCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InstallPlanConditionBuilder(InstallPlanConditionFluent<?> fluent,InstallPlanCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InstallPlanCondition build() {
    InstallPlanCondition buildable = new InstallPlanCondition(fluent.getLastTransitionTime(), fluent.getLastUpdateTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}