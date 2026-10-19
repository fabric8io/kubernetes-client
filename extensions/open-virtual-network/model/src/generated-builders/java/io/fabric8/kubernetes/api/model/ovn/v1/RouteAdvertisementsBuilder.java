package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RouteAdvertisementsBuilder extends RouteAdvertisementsFluent<RouteAdvertisementsBuilder> implements VisitableBuilder<RouteAdvertisements,RouteAdvertisementsBuilder>{

  RouteAdvertisementsFluent<?> fluent;

  public RouteAdvertisementsBuilder() {
    this(new RouteAdvertisements());
  }
  
  public RouteAdvertisementsBuilder(RouteAdvertisementsFluent<?> fluent) {
    this(fluent, new RouteAdvertisements());
  }
  
  public RouteAdvertisementsBuilder(RouteAdvertisements instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RouteAdvertisementsBuilder(RouteAdvertisementsFluent<?> fluent,RouteAdvertisements instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RouteAdvertisements build() {
    RouteAdvertisements buildable = new RouteAdvertisements(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}