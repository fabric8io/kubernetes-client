package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusListBuilder extends PrometheusListFluent<PrometheusListBuilder> implements VisitableBuilder<PrometheusList,PrometheusListBuilder>{

  PrometheusListFluent<?> fluent;

  public PrometheusListBuilder() {
    this(new PrometheusList());
  }
  
  public PrometheusListBuilder(PrometheusListFluent<?> fluent) {
    this(fluent, new PrometheusList());
  }
  
  public PrometheusListBuilder(PrometheusList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusListBuilder(PrometheusListFluent<?> fluent,PrometheusList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrometheusList build() {
    PrometheusList buildable = new PrometheusList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}