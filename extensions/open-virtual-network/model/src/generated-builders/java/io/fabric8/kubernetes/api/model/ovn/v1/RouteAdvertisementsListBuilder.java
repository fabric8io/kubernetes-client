package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteAdvertisementsListBuilder extends RouteAdvertisementsListFluent<RouteAdvertisementsListBuilder> implements VisitableBuilder<RouteAdvertisementsList,RouteAdvertisementsListBuilder>{

  RouteAdvertisementsListFluent<?> fluent;

  public RouteAdvertisementsListBuilder() {
    this(new RouteAdvertisementsList());
  }
  
  public RouteAdvertisementsListBuilder(RouteAdvertisementsListFluent<?> fluent) {
    this(fluent, new RouteAdvertisementsList());
  }
  
  public RouteAdvertisementsListBuilder(RouteAdvertisementsList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteAdvertisementsListBuilder(RouteAdvertisementsListFluent<?> fluent,RouteAdvertisementsList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteAdvertisementsList build() {
    RouteAdvertisementsList buildable = new RouteAdvertisementsList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}