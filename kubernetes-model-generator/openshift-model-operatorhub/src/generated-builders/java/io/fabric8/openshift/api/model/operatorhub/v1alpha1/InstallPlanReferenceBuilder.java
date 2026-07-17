package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InstallPlanReferenceBuilder extends InstallPlanReferenceFluent<InstallPlanReferenceBuilder> implements VisitableBuilder<InstallPlanReference,InstallPlanReferenceBuilder>{

  InstallPlanReferenceFluent<?> fluent;

  public InstallPlanReferenceBuilder() {
    this(new InstallPlanReference());
  }
  
  public InstallPlanReferenceBuilder(InstallPlanReferenceFluent<?> fluent) {
    this(fluent, new InstallPlanReference());
  }
  
  public InstallPlanReferenceBuilder(InstallPlanReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InstallPlanReferenceBuilder(InstallPlanReferenceFluent<?> fluent,InstallPlanReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InstallPlanReference build() {
    InstallPlanReference buildable = new InstallPlanReference(fluent.getApiVersion(), fluent.getKind(), fluent.getName(), fluent.getUuid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}