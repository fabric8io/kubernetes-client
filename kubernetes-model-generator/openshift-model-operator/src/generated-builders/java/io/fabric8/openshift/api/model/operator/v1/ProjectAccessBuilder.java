package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProjectAccessBuilder extends ProjectAccessFluent<ProjectAccessBuilder> implements VisitableBuilder<ProjectAccess,ProjectAccessBuilder>{

  ProjectAccessFluent<?> fluent;

  public ProjectAccessBuilder() {
    this(new ProjectAccess());
  }
  
  public ProjectAccessBuilder(ProjectAccessFluent<?> fluent) {
    this(fluent, new ProjectAccess());
  }
  
  public ProjectAccessBuilder(ProjectAccess instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProjectAccessBuilder(ProjectAccessFluent<?> fluent,ProjectAccess instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProjectAccess build() {
    ProjectAccess buildable = new ProjectAccess(fluent.getAvailableClusterRoles());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}