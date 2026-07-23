package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InstallPlanListBuilder extends InstallPlanListFluent<InstallPlanListBuilder> implements VisitableBuilder<InstallPlanList,InstallPlanListBuilder>{

  InstallPlanListFluent<?> fluent;

  public InstallPlanListBuilder() {
    this(new InstallPlanList());
  }
  
  public InstallPlanListBuilder(InstallPlanListFluent<?> fluent) {
    this(fluent, new InstallPlanList());
  }
  
  public InstallPlanListBuilder(InstallPlanList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InstallPlanListBuilder(InstallPlanListFluent<?> fluent,InstallPlanList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InstallPlanList build() {
    InstallPlanList buildable = new InstallPlanList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}