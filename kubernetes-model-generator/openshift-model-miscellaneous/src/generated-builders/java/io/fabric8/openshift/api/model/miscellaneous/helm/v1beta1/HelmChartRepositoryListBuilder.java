package io.fabric8.openshift.api.model.miscellaneous.helm.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HelmChartRepositoryListBuilder extends HelmChartRepositoryListFluent<HelmChartRepositoryListBuilder> implements VisitableBuilder<HelmChartRepositoryList,HelmChartRepositoryListBuilder>{

  HelmChartRepositoryListFluent<?> fluent;

  public HelmChartRepositoryListBuilder() {
    this(new HelmChartRepositoryList());
  }
  
  public HelmChartRepositoryListBuilder(HelmChartRepositoryListFluent<?> fluent) {
    this(fluent, new HelmChartRepositoryList());
  }
  
  public HelmChartRepositoryListBuilder(HelmChartRepositoryList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HelmChartRepositoryListBuilder(HelmChartRepositoryListFluent<?> fluent,HelmChartRepositoryList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HelmChartRepositoryList build() {
    HelmChartRepositoryList buildable = new HelmChartRepositoryList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}