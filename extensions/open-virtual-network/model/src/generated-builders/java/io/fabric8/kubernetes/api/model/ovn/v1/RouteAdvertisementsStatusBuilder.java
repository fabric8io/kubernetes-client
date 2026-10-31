package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteAdvertisementsStatusBuilder extends RouteAdvertisementsStatusFluent<RouteAdvertisementsStatusBuilder> implements VisitableBuilder<RouteAdvertisementsStatus,RouteAdvertisementsStatusBuilder>{

  RouteAdvertisementsStatusFluent<?> fluent;

  public RouteAdvertisementsStatusBuilder() {
    this(new RouteAdvertisementsStatus());
  }
  
  public RouteAdvertisementsStatusBuilder(RouteAdvertisementsStatusFluent<?> fluent) {
    this(fluent, new RouteAdvertisementsStatus());
  }
  
  public RouteAdvertisementsStatusBuilder(RouteAdvertisementsStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteAdvertisementsStatusBuilder(RouteAdvertisementsStatusFluent<?> fluent,RouteAdvertisementsStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteAdvertisementsStatus build() {
    RouteAdvertisementsStatus buildable = new RouteAdvertisementsStatus(fluent.getConditions(), fluent.getStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}