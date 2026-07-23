package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProjectStatusBuilder extends ProjectStatusFluent<ProjectStatusBuilder> implements VisitableBuilder<ProjectStatus,ProjectStatusBuilder>{

  ProjectStatusFluent<?> fluent;

  public ProjectStatusBuilder() {
    this(new ProjectStatus());
  }
  
  public ProjectStatusBuilder(ProjectStatusFluent<?> fluent) {
    this(fluent, new ProjectStatus());
  }
  
  public ProjectStatusBuilder(ProjectStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProjectStatusBuilder(ProjectStatusFluent<?> fluent,ProjectStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProjectStatus build() {
    ProjectStatus buildable = new ProjectStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}