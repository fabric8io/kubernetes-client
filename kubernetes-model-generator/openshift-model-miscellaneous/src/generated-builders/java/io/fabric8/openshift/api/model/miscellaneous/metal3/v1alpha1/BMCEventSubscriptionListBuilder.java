package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BMCEventSubscriptionListBuilder extends BMCEventSubscriptionListFluent<BMCEventSubscriptionListBuilder> implements VisitableBuilder<BMCEventSubscriptionList,BMCEventSubscriptionListBuilder>{

  BMCEventSubscriptionListFluent<?> fluent;

  public BMCEventSubscriptionListBuilder() {
    this(new BMCEventSubscriptionList());
  }
  
  public BMCEventSubscriptionListBuilder(BMCEventSubscriptionListFluent<?> fluent) {
    this(fluent, new BMCEventSubscriptionList());
  }
  
  public BMCEventSubscriptionListBuilder(BMCEventSubscriptionList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BMCEventSubscriptionListBuilder(BMCEventSubscriptionListFluent<?> fluent,BMCEventSubscriptionList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BMCEventSubscriptionList build() {
    BMCEventSubscriptionList buildable = new BMCEventSubscriptionList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}