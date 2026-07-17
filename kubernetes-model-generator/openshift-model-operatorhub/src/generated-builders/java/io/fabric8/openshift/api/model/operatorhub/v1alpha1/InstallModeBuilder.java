package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InstallModeBuilder extends InstallModeFluent<InstallModeBuilder> implements VisitableBuilder<InstallMode,InstallModeBuilder>{

  InstallModeFluent<?> fluent;

  public InstallModeBuilder() {
    this(new InstallMode());
  }
  
  public InstallModeBuilder(InstallModeFluent<?> fluent) {
    this(fluent, new InstallMode());
  }
  
  public InstallModeBuilder(InstallMode instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InstallModeBuilder(InstallModeFluent<?> fluent,InstallMode instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InstallMode build() {
    InstallMode buildable = new InstallMode(fluent.getSupported(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}