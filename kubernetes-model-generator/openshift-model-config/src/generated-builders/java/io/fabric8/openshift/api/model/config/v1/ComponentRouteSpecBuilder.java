package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ComponentRouteSpecBuilder extends ComponentRouteSpecFluent<ComponentRouteSpecBuilder> implements VisitableBuilder<ComponentRouteSpec,ComponentRouteSpecBuilder>{

  ComponentRouteSpecFluent<?> fluent;

  public ComponentRouteSpecBuilder() {
    this(new ComponentRouteSpec());
  }
  
  public ComponentRouteSpecBuilder(ComponentRouteSpecFluent<?> fluent) {
    this(fluent, new ComponentRouteSpec());
  }
  
  public ComponentRouteSpecBuilder(ComponentRouteSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ComponentRouteSpecBuilder(ComponentRouteSpecFluent<?> fluent,ComponentRouteSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ComponentRouteSpec build() {
    ComponentRouteSpec buildable = new ComponentRouteSpec(fluent.getHostname(), fluent.getName(), fluent.getNamespace(), fluent.buildServingCertKeyPairSecret());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}