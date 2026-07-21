package io.fabric8.istio.api.api.telemetry.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricsOverridesTagOverrideBuilder extends MetricsOverridesTagOverrideFluent<MetricsOverridesTagOverrideBuilder> implements VisitableBuilder<MetricsOverridesTagOverride,MetricsOverridesTagOverrideBuilder>{

  MetricsOverridesTagOverrideFluent<?> fluent;

  public MetricsOverridesTagOverrideBuilder() {
    this(new MetricsOverridesTagOverride());
  }
  
  public MetricsOverridesTagOverrideBuilder(MetricsOverridesTagOverrideFluent<?> fluent) {
    this(fluent, new MetricsOverridesTagOverride());
  }
  
  public MetricsOverridesTagOverrideBuilder(MetricsOverridesTagOverride instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricsOverridesTagOverrideBuilder(MetricsOverridesTagOverrideFluent<?> fluent,MetricsOverridesTagOverride instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetricsOverridesTagOverride build() {
    MetricsOverridesTagOverride buildable = new MetricsOverridesTagOverride(fluent.getOperation(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}