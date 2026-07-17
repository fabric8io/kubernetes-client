package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProjectBuilder extends ProjectFluent<ProjectBuilder> implements VisitableBuilder<Project,ProjectBuilder>{

  ProjectFluent<?> fluent;

  public ProjectBuilder() {
    this(new Project());
  }
  
  public ProjectBuilder(ProjectFluent<?> fluent) {
    this(fluent, new Project());
  }
  
  public ProjectBuilder(Project instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProjectBuilder(ProjectFluent<?> fluent,Project instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Project build() {
    Project buildable = new Project(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}