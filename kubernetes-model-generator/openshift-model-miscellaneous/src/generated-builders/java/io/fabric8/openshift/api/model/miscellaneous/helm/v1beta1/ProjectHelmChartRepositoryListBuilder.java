package io.fabric8.openshift.api.model.miscellaneous.helm.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProjectHelmChartRepositoryListBuilder extends ProjectHelmChartRepositoryListFluent<ProjectHelmChartRepositoryListBuilder> implements VisitableBuilder<ProjectHelmChartRepositoryList,ProjectHelmChartRepositoryListBuilder>{

  ProjectHelmChartRepositoryListFluent<?> fluent;

  public ProjectHelmChartRepositoryListBuilder() {
    this(new ProjectHelmChartRepositoryList());
  }
  
  public ProjectHelmChartRepositoryListBuilder(ProjectHelmChartRepositoryListFluent<?> fluent) {
    this(fluent, new ProjectHelmChartRepositoryList());
  }
  
  public ProjectHelmChartRepositoryListBuilder(ProjectHelmChartRepositoryList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProjectHelmChartRepositoryListBuilder(ProjectHelmChartRepositoryListFluent<?> fluent,ProjectHelmChartRepositoryList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProjectHelmChartRepositoryList build() {
    ProjectHelmChartRepositoryList buildable = new ProjectHelmChartRepositoryList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}