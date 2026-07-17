package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BMCEventSubscriptionSpecBuilder extends BMCEventSubscriptionSpecFluent<BMCEventSubscriptionSpecBuilder> implements VisitableBuilder<BMCEventSubscriptionSpec,BMCEventSubscriptionSpecBuilder>{

  BMCEventSubscriptionSpecFluent<?> fluent;

  public BMCEventSubscriptionSpecBuilder() {
    this(new BMCEventSubscriptionSpec());
  }
  
  public BMCEventSubscriptionSpecBuilder(BMCEventSubscriptionSpecFluent<?> fluent) {
    this(fluent, new BMCEventSubscriptionSpec());
  }
  
  public BMCEventSubscriptionSpecBuilder(BMCEventSubscriptionSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BMCEventSubscriptionSpecBuilder(BMCEventSubscriptionSpecFluent<?> fluent,BMCEventSubscriptionSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BMCEventSubscriptionSpec build() {
    BMCEventSubscriptionSpec buildable = new BMCEventSubscriptionSpec(fluent.getContext(), fluent.getDestination(), fluent.getHostName(), fluent.getHttpHeadersRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}