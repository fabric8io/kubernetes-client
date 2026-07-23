package io.fabric8.openclustermanagement.api.model.observability.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ObservabilityAddonBuilder extends ObservabilityAddonFluent<ObservabilityAddonBuilder> implements VisitableBuilder<ObservabilityAddon,ObservabilityAddonBuilder>{

  ObservabilityAddonFluent<?> fluent;

  public ObservabilityAddonBuilder() {
    this(new ObservabilityAddon());
  }
  
  public ObservabilityAddonBuilder(ObservabilityAddonFluent<?> fluent) {
    this(fluent, new ObservabilityAddon());
  }
  
  public ObservabilityAddonBuilder(ObservabilityAddon instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ObservabilityAddonBuilder(ObservabilityAddonFluent<?> fluent,ObservabilityAddon instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ObservabilityAddon build() {
    ObservabilityAddon buildable = new ObservabilityAddon(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}