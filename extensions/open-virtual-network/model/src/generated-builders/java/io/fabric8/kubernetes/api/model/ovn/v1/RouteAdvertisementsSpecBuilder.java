package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteAdvertisementsSpecBuilder extends RouteAdvertisementsSpecFluent<RouteAdvertisementsSpecBuilder> implements VisitableBuilder<RouteAdvertisementsSpec,RouteAdvertisementsSpecBuilder>{

  RouteAdvertisementsSpecFluent<?> fluent;

  public RouteAdvertisementsSpecBuilder() {
    this(new RouteAdvertisementsSpec());
  }
  
  public RouteAdvertisementsSpecBuilder(RouteAdvertisementsSpecFluent<?> fluent) {
    this(fluent, new RouteAdvertisementsSpec());
  }
  
  public RouteAdvertisementsSpecBuilder(RouteAdvertisementsSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteAdvertisementsSpecBuilder(RouteAdvertisementsSpecFluent<?> fluent,RouteAdvertisementsSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteAdvertisementsSpec build() {
    RouteAdvertisementsSpec buildable = new RouteAdvertisementsSpec(fluent.getAdvertisements(), fluent.buildFrrConfigurationSelector(), fluent.buildNetworkSelectors(), fluent.buildNodeSelector(), fluent.getTargetVRF());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}