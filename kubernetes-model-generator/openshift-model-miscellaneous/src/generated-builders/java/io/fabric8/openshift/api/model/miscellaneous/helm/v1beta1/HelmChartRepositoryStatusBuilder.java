package io.fabric8.openshift.api.model.miscellaneous.helm.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HelmChartRepositoryStatusBuilder extends HelmChartRepositoryStatusFluent<HelmChartRepositoryStatusBuilder> implements VisitableBuilder<HelmChartRepositoryStatus,HelmChartRepositoryStatusBuilder>{

  HelmChartRepositoryStatusFluent<?> fluent;

  public HelmChartRepositoryStatusBuilder() {
    this(new HelmChartRepositoryStatus());
  }
  
  public HelmChartRepositoryStatusBuilder(HelmChartRepositoryStatusFluent<?> fluent) {
    this(fluent, new HelmChartRepositoryStatus());
  }
  
  public HelmChartRepositoryStatusBuilder(HelmChartRepositoryStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HelmChartRepositoryStatusBuilder(HelmChartRepositoryStatusFluent<?> fluent,HelmChartRepositoryStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HelmChartRepositoryStatus build() {
    HelmChartRepositoryStatus buildable = new HelmChartRepositoryStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}