package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricsOverridesBuilder extends MetricsOverridesFluent<MetricsOverridesBuilder> implements VisitableBuilder<MetricsOverrides,MetricsOverridesBuilder>{

  MetricsOverridesFluent<?> fluent;

  public MetricsOverridesBuilder() {
    this(new MetricsOverrides());
  }
  
  public MetricsOverridesBuilder(MetricsOverridesFluent<?> fluent) {
    this(fluent, new MetricsOverrides());
  }
  
  public MetricsOverridesBuilder(MetricsOverrides instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricsOverridesBuilder(MetricsOverridesFluent<?> fluent,MetricsOverrides instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetricsOverrides build() {
    MetricsOverrides buildable = new MetricsOverrides(fluent.getDisabled(), fluent.buildMatch(), fluent.getTagOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}