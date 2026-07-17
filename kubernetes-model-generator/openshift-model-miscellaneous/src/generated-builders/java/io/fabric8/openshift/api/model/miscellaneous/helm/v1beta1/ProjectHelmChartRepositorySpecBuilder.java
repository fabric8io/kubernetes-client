package io.fabric8.openshift.api.model.miscellaneous.helm.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProjectHelmChartRepositorySpecBuilder extends ProjectHelmChartRepositorySpecFluent<ProjectHelmChartRepositorySpecBuilder> implements VisitableBuilder<ProjectHelmChartRepositorySpec,ProjectHelmChartRepositorySpecBuilder>{

  ProjectHelmChartRepositorySpecFluent<?> fluent;

  public ProjectHelmChartRepositorySpecBuilder() {
    this(new ProjectHelmChartRepositorySpec());
  }
  
  public ProjectHelmChartRepositorySpecBuilder(ProjectHelmChartRepositorySpecFluent<?> fluent) {
    this(fluent, new ProjectHelmChartRepositorySpec());
  }
  
  public ProjectHelmChartRepositorySpecBuilder(ProjectHelmChartRepositorySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProjectHelmChartRepositorySpecBuilder(ProjectHelmChartRepositorySpecFluent<?> fluent,ProjectHelmChartRepositorySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProjectHelmChartRepositorySpec build() {
    ProjectHelmChartRepositorySpec buildable = new ProjectHelmChartRepositorySpec(fluent.buildConnectionConfig(), fluent.getDescription(), fluent.getDisabled(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}