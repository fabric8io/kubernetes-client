package io.fabric8.openshift.api.model.miscellaneous.helm.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HelmChartRepositoryBuilder extends HelmChartRepositoryFluent<HelmChartRepositoryBuilder> implements VisitableBuilder<HelmChartRepository,HelmChartRepositoryBuilder>{

  HelmChartRepositoryFluent<?> fluent;

  public HelmChartRepositoryBuilder() {
    this(new HelmChartRepository());
  }
  
  public HelmChartRepositoryBuilder(HelmChartRepositoryFluent<?> fluent) {
    this(fluent, new HelmChartRepository());
  }
  
  public HelmChartRepositoryBuilder(HelmChartRepository instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HelmChartRepositoryBuilder(HelmChartRepositoryFluent<?> fluent,HelmChartRepository instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HelmChartRepository build() {
    HelmChartRepository buildable = new HelmChartRepository(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}