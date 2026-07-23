package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusStatusBuilder extends PrometheusStatusFluent<PrometheusStatusBuilder> implements VisitableBuilder<PrometheusStatus,PrometheusStatusBuilder>{

  PrometheusStatusFluent<?> fluent;

  public PrometheusStatusBuilder() {
    this(new PrometheusStatus());
  }
  
  public PrometheusStatusBuilder(PrometheusStatusFluent<?> fluent) {
    this(fluent, new PrometheusStatus());
  }
  
  public PrometheusStatusBuilder(PrometheusStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusStatusBuilder(PrometheusStatusFluent<?> fluent,PrometheusStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrometheusStatus build() {
    PrometheusStatus buildable = new PrometheusStatus(fluent.getAvailableReplicas(), fluent.buildConditions(), fluent.getPaused(), fluent.getReplicas(), fluent.getSelector(), fluent.buildShardStatuses(), fluent.getShards(), fluent.getUnavailableReplicas(), fluent.getUpdatedReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}