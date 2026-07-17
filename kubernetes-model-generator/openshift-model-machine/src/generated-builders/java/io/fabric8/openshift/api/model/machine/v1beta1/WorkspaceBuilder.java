package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkspaceBuilder extends WorkspaceFluent<WorkspaceBuilder> implements VisitableBuilder<Workspace,WorkspaceBuilder>{

  WorkspaceFluent<?> fluent;

  public WorkspaceBuilder() {
    this(new Workspace());
  }
  
  public WorkspaceBuilder(WorkspaceFluent<?> fluent) {
    this(fluent, new Workspace());
  }
  
  public WorkspaceBuilder(Workspace instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkspaceBuilder(WorkspaceFluent<?> fluent,Workspace instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Workspace build() {
    Workspace buildable = new Workspace(fluent.getDatacenter(), fluent.getDatastore(), fluent.getFolder(), fluent.getResourcePool(), fluent.getServer(), fluent.getVmGroup());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}