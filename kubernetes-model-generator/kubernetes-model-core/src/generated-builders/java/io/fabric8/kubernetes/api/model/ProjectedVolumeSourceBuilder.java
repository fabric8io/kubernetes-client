package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProjectedVolumeSourceBuilder extends ProjectedVolumeSourceFluent<ProjectedVolumeSourceBuilder> implements VisitableBuilder<ProjectedVolumeSource,ProjectedVolumeSourceBuilder>{

  ProjectedVolumeSourceFluent<?> fluent;

  public ProjectedVolumeSourceBuilder() {
    this(new ProjectedVolumeSource());
  }
  
  public ProjectedVolumeSourceBuilder(ProjectedVolumeSourceFluent<?> fluent) {
    this(fluent, new ProjectedVolumeSource());
  }
  
  public ProjectedVolumeSourceBuilder(ProjectedVolumeSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProjectedVolumeSourceBuilder(ProjectedVolumeSourceFluent<?> fluent,ProjectedVolumeSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProjectedVolumeSource build() {
    ProjectedVolumeSource buildable = new ProjectedVolumeSource(fluent.getDefaultMode(), fluent.buildSources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}