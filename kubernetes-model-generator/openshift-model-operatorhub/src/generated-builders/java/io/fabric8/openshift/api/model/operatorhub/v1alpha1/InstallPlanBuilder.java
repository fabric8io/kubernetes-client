package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InstallPlanBuilder extends InstallPlanFluent<InstallPlanBuilder> implements VisitableBuilder<InstallPlan,InstallPlanBuilder>{

  InstallPlanFluent<?> fluent;

  public InstallPlanBuilder() {
    this(new InstallPlan());
  }
  
  public InstallPlanBuilder(InstallPlanFluent<?> fluent) {
    this(fluent, new InstallPlan());
  }
  
  public InstallPlanBuilder(InstallPlan instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InstallPlanBuilder(InstallPlanFluent<?> fluent,InstallPlan instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InstallPlan build() {
    InstallPlan buildable = new InstallPlan(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}