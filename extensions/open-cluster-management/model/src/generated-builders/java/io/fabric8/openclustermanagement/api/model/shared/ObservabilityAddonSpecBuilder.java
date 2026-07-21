package io.fabric8.openclustermanagement.api.model.shared;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ObservabilityAddonSpecBuilder extends ObservabilityAddonSpecFluent<ObservabilityAddonSpecBuilder> implements VisitableBuilder<ObservabilityAddonSpec,ObservabilityAddonSpecBuilder>{

  ObservabilityAddonSpecFluent<?> fluent;

  public ObservabilityAddonSpecBuilder() {
    this(new ObservabilityAddonSpec());
  }
  
  public ObservabilityAddonSpecBuilder(ObservabilityAddonSpecFluent<?> fluent) {
    this(fluent, new ObservabilityAddonSpec());
  }
  
  public ObservabilityAddonSpecBuilder(ObservabilityAddonSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ObservabilityAddonSpecBuilder(ObservabilityAddonSpecFluent<?> fluent,ObservabilityAddonSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ObservabilityAddonSpec build() {
    ObservabilityAddonSpec buildable = new ObservabilityAddonSpec(fluent.getEnableMetrics(), fluent.getInterval(), fluent.buildResources(), fluent.getScrapeSizeLimitBytes(), fluent.getWorkers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}