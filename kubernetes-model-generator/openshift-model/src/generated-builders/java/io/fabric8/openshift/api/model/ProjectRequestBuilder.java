package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProjectRequestBuilder extends ProjectRequestFluent<ProjectRequestBuilder> implements VisitableBuilder<ProjectRequest,ProjectRequestBuilder>{

  ProjectRequestFluent<?> fluent;

  public ProjectRequestBuilder() {
    this(new ProjectRequest());
  }
  
  public ProjectRequestBuilder(ProjectRequestFluent<?> fluent) {
    this(fluent, new ProjectRequest());
  }
  
  public ProjectRequestBuilder(ProjectRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProjectRequestBuilder(ProjectRequestFluent<?> fluent,ProjectRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProjectRequest build() {
    ProjectRequest buildable = new ProjectRequest(fluent.getApiVersion(), fluent.getDescription(), fluent.getDisplayName(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}