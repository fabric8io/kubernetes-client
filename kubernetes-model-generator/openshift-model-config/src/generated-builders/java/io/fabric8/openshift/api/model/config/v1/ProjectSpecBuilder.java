package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProjectSpecBuilder extends ProjectSpecFluent<ProjectSpecBuilder> implements VisitableBuilder<ProjectSpec,ProjectSpecBuilder>{

  ProjectSpecFluent<?> fluent;

  public ProjectSpecBuilder() {
    this(new ProjectSpec());
  }
  
  public ProjectSpecBuilder(ProjectSpecFluent<?> fluent) {
    this(fluent, new ProjectSpec());
  }
  
  public ProjectSpecBuilder(ProjectSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProjectSpecBuilder(ProjectSpecFluent<?> fluent,ProjectSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProjectSpec build() {
    ProjectSpec buildable = new ProjectSpec(fluent.getProjectRequestMessage(), fluent.buildProjectRequestTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}