package io.fabric8.openshift.api.model.hive.metricsconfig.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricsConfigBuilder extends MetricsConfigFluent<MetricsConfigBuilder> implements VisitableBuilder<MetricsConfig,MetricsConfigBuilder>{

  MetricsConfigFluent<?> fluent;

  public MetricsConfigBuilder() {
    this(new MetricsConfig());
  }
  
  public MetricsConfigBuilder(MetricsConfigFluent<?> fluent) {
    this(fluent, new MetricsConfig());
  }
  
  public MetricsConfigBuilder(MetricsConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricsConfigBuilder(MetricsConfigFluent<?> fluent,MetricsConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetricsConfig build() {
    MetricsConfig buildable = new MetricsConfig(fluent.getAdditionalClusterDeploymentLabels(), fluent.buildMetricsWithDuration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}