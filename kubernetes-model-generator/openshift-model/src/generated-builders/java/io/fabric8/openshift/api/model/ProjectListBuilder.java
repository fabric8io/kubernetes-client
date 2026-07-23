package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProjectListBuilder extends ProjectListFluent<ProjectListBuilder> implements VisitableBuilder<ProjectList,ProjectListBuilder>{

  ProjectListFluent<?> fluent;

  public ProjectListBuilder() {
    this(new ProjectList());
  }
  
  public ProjectListBuilder(ProjectListFluent<?> fluent) {
    this(fluent, new ProjectList());
  }
  
  public ProjectListBuilder(ProjectList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProjectListBuilder(ProjectListFluent<?> fluent,ProjectList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProjectList build() {
    ProjectList buildable = new ProjectList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}