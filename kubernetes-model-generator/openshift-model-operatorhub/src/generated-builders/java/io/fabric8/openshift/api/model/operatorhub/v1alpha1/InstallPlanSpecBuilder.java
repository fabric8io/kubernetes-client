package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InstallPlanSpecBuilder extends InstallPlanSpecFluent<InstallPlanSpecBuilder> implements VisitableBuilder<InstallPlanSpec,InstallPlanSpecBuilder>{

  InstallPlanSpecFluent<?> fluent;

  public InstallPlanSpecBuilder() {
    this(new InstallPlanSpec());
  }
  
  public InstallPlanSpecBuilder(InstallPlanSpecFluent<?> fluent) {
    this(fluent, new InstallPlanSpec());
  }
  
  public InstallPlanSpecBuilder(InstallPlanSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InstallPlanSpecBuilder(InstallPlanSpecFluent<?> fluent,InstallPlanSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InstallPlanSpec build() {
    InstallPlanSpec buildable = new InstallPlanSpec(fluent.getApproval(), fluent.getApproved(), fluent.getClusterServiceVersionNames(), fluent.getGeneration(), fluent.getSource(), fluent.getSourceNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}