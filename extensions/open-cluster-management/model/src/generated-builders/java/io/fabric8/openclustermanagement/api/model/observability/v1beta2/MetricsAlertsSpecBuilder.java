package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MetricsAlertsSpecBuilder extends MetricsAlertsSpecFluent<MetricsAlertsSpecBuilder> implements VisitableBuilder<MetricsAlertsSpec,MetricsAlertsSpecBuilder>{

  MetricsAlertsSpecFluent<?> fluent;

  public MetricsAlertsSpecBuilder() {
    this(new MetricsAlertsSpec());
  }
  
  public MetricsAlertsSpecBuilder(MetricsAlertsSpecFluent<?> fluent) {
    this(fluent, new MetricsAlertsSpec());
  }
  
  public MetricsAlertsSpecBuilder(MetricsAlertsSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MetricsAlertsSpecBuilder(MetricsAlertsSpecFluent<?> fluent,MetricsAlertsSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MetricsAlertsSpec build() {
    MetricsAlertsSpec buildable = new MetricsAlertsSpec(fluent.getEnabled());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}