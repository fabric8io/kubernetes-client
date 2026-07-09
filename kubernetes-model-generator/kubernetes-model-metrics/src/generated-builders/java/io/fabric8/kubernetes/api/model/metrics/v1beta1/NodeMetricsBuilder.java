package io.fabric8.kubernetes.api.model.metrics.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NodeMetricsBuilder extends NodeMetricsFluent<NodeMetricsBuilder> implements VisitableBuilder<NodeMetrics,NodeMetricsBuilder>{

  NodeMetricsFluent<?> fluent;

  public NodeMetricsBuilder() {
    this(new NodeMetrics());
  }
  
  public NodeMetricsBuilder(NodeMetricsFluent<?> fluent) {
    this(fluent, new NodeMetrics());
  }
  
  public NodeMetricsBuilder(NodeMetrics instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NodeMetricsBuilder(NodeMetricsFluent<?> fluent,NodeMetrics instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NodeMetrics build() {
    NodeMetrics buildable = new NodeMetrics(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.getTimestamp(), fluent.getUsage(), fluent.getWindow());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}