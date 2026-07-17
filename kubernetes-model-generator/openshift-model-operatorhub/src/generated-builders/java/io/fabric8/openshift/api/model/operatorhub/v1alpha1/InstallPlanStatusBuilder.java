package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InstallPlanStatusBuilder extends InstallPlanStatusFluent<InstallPlanStatusBuilder> implements VisitableBuilder<InstallPlanStatus,InstallPlanStatusBuilder>{

  InstallPlanStatusFluent<?> fluent;

  public InstallPlanStatusBuilder() {
    this(new InstallPlanStatus());
  }
  
  public InstallPlanStatusBuilder(InstallPlanStatusFluent<?> fluent) {
    this(fluent, new InstallPlanStatus());
  }
  
  public InstallPlanStatusBuilder(InstallPlanStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InstallPlanStatusBuilder(InstallPlanStatusFluent<?> fluent,InstallPlanStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InstallPlanStatus build() {
    InstallPlanStatus buildable = new InstallPlanStatus(fluent.buildAttenuatedServiceAccountRef(), fluent.buildBundleLookups(), fluent.getCatalogSources(), fluent.buildConditions(), fluent.getMessage(), fluent.getPhase(), fluent.buildPlan(), fluent.getStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}