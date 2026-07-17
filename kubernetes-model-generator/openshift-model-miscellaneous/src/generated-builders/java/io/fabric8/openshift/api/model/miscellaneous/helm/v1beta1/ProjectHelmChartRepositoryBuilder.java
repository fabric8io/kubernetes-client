package io.fabric8.openshift.api.model.miscellaneous.helm.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProjectHelmChartRepositoryBuilder extends ProjectHelmChartRepositoryFluent<ProjectHelmChartRepositoryBuilder> implements VisitableBuilder<ProjectHelmChartRepository,ProjectHelmChartRepositoryBuilder>{

  ProjectHelmChartRepositoryFluent<?> fluent;

  public ProjectHelmChartRepositoryBuilder() {
    this(new ProjectHelmChartRepository());
  }
  
  public ProjectHelmChartRepositoryBuilder(ProjectHelmChartRepositoryFluent<?> fluent) {
    this(fluent, new ProjectHelmChartRepository());
  }
  
  public ProjectHelmChartRepositoryBuilder(ProjectHelmChartRepository instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProjectHelmChartRepositoryBuilder(ProjectHelmChartRepositoryFluent<?> fluent,ProjectHelmChartRepository instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProjectHelmChartRepository build() {
    ProjectHelmChartRepository buildable = new ProjectHelmChartRepository(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}