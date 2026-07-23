package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusSourceListBuilder extends PrometheusSourceListFluent<PrometheusSourceListBuilder> implements VisitableBuilder<PrometheusSourceList,PrometheusSourceListBuilder>{

  PrometheusSourceListFluent<?> fluent;

  public PrometheusSourceListBuilder() {
    this(new PrometheusSourceList());
  }
  
  public PrometheusSourceListBuilder(PrometheusSourceListFluent<?> fluent) {
    this(fluent, new PrometheusSourceList());
  }
  
  public PrometheusSourceListBuilder(PrometheusSourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusSourceListBuilder(PrometheusSourceListFluent<?> fluent,PrometheusSourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrometheusSourceList build() {
    PrometheusSourceList buildable = new PrometheusSourceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}