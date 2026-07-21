package io.fabric8.openclustermanagement.api.model.observability.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ObservabilityAddonStatusBuilder extends ObservabilityAddonStatusFluent<ObservabilityAddonStatusBuilder> implements VisitableBuilder<ObservabilityAddonStatus,ObservabilityAddonStatusBuilder>{

  ObservabilityAddonStatusFluent<?> fluent;

  public ObservabilityAddonStatusBuilder() {
    this(new ObservabilityAddonStatus());
  }
  
  public ObservabilityAddonStatusBuilder(ObservabilityAddonStatusFluent<?> fluent) {
    this(fluent, new ObservabilityAddonStatus());
  }
  
  public ObservabilityAddonStatusBuilder(ObservabilityAddonStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ObservabilityAddonStatusBuilder(ObservabilityAddonStatusFluent<?> fluent,ObservabilityAddonStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ObservabilityAddonStatus build() {
    ObservabilityAddonStatus buildable = new ObservabilityAddonStatus(fluent.buildConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}