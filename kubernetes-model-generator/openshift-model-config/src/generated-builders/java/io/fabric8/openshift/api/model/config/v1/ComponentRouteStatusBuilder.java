package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ComponentRouteStatusBuilder extends ComponentRouteStatusFluent<ComponentRouteStatusBuilder> implements VisitableBuilder<ComponentRouteStatus,ComponentRouteStatusBuilder>{

  ComponentRouteStatusFluent<?> fluent;

  public ComponentRouteStatusBuilder() {
    this(new ComponentRouteStatus());
  }
  
  public ComponentRouteStatusBuilder(ComponentRouteStatusFluent<?> fluent) {
    this(fluent, new ComponentRouteStatus());
  }
  
  public ComponentRouteStatusBuilder(ComponentRouteStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ComponentRouteStatusBuilder(ComponentRouteStatusFluent<?> fluent,ComponentRouteStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ComponentRouteStatus build() {
    ComponentRouteStatus buildable = new ComponentRouteStatus(fluent.getConditions(), fluent.getConsumingUsers(), fluent.getCurrentHostnames(), fluent.getDefaultHostname(), fluent.getName(), fluent.getNamespace(), fluent.buildRelatedObjects());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}