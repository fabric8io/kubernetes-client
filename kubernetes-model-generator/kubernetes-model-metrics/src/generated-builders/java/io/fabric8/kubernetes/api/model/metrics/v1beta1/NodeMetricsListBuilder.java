package io.fabric8.kubernetes.api.model.metrics.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeMetricsListBuilder extends NodeMetricsListFluent<NodeMetricsListBuilder> implements VisitableBuilder<NodeMetricsList,NodeMetricsListBuilder>{

  NodeMetricsListFluent<?> fluent;

  public NodeMetricsListBuilder() {
    this(new NodeMetricsList());
  }
  
  public NodeMetricsListBuilder(NodeMetricsListFluent<?> fluent) {
    this(fluent, new NodeMetricsList());
  }
  
  public NodeMetricsListBuilder(NodeMetricsList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeMetricsListBuilder(NodeMetricsListFluent<?> fluent,NodeMetricsList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeMetricsList build() {
    NodeMetricsList buildable = new NodeMetricsList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}