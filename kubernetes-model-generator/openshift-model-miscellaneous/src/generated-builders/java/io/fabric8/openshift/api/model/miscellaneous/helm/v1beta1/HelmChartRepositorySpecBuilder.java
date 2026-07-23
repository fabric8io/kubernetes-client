package io.fabric8.openshift.api.model.miscellaneous.helm.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HelmChartRepositorySpecBuilder extends HelmChartRepositorySpecFluent<HelmChartRepositorySpecBuilder> implements VisitableBuilder<HelmChartRepositorySpec,HelmChartRepositorySpecBuilder>{

  HelmChartRepositorySpecFluent<?> fluent;

  public HelmChartRepositorySpecBuilder() {
    this(new HelmChartRepositorySpec());
  }
  
  public HelmChartRepositorySpecBuilder(HelmChartRepositorySpecFluent<?> fluent) {
    this(fluent, new HelmChartRepositorySpec());
  }
  
  public HelmChartRepositorySpecBuilder(HelmChartRepositorySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HelmChartRepositorySpecBuilder(HelmChartRepositorySpecFluent<?> fluent,HelmChartRepositorySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HelmChartRepositorySpec build() {
    HelmChartRepositorySpec buildable = new HelmChartRepositorySpec(fluent.buildConnectionConfig(), fluent.getDescription(), fluent.getDisabled(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}