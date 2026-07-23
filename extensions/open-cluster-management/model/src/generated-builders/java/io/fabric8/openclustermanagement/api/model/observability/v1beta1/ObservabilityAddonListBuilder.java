package io.fabric8.openclustermanagement.api.model.observability.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ObservabilityAddonListBuilder extends ObservabilityAddonListFluent<ObservabilityAddonListBuilder> implements VisitableBuilder<ObservabilityAddonList,ObservabilityAddonListBuilder>{

  ObservabilityAddonListFluent<?> fluent;

  public ObservabilityAddonListBuilder() {
    this(new ObservabilityAddonList());
  }
  
  public ObservabilityAddonListBuilder(ObservabilityAddonListFluent<?> fluent) {
    this(fluent, new ObservabilityAddonList());
  }
  
  public ObservabilityAddonListBuilder(ObservabilityAddonList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ObservabilityAddonListBuilder(ObservabilityAddonListFluent<?> fluent,ObservabilityAddonList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ObservabilityAddonList build() {
    ObservabilityAddonList buildable = new ObservabilityAddonList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}