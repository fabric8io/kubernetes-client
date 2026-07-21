package io.fabric8.knative.eventing.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscriptionsAPIFilterBuilder extends SubscriptionsAPIFilterFluent<SubscriptionsAPIFilterBuilder> implements VisitableBuilder<SubscriptionsAPIFilter,SubscriptionsAPIFilterBuilder>{

  SubscriptionsAPIFilterFluent<?> fluent;

  public SubscriptionsAPIFilterBuilder() {
    this(new SubscriptionsAPIFilter());
  }
  
  public SubscriptionsAPIFilterBuilder(SubscriptionsAPIFilterFluent<?> fluent) {
    this(fluent, new SubscriptionsAPIFilter());
  }
  
  public SubscriptionsAPIFilterBuilder(SubscriptionsAPIFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscriptionsAPIFilterBuilder(SubscriptionsAPIFilterFluent<?> fluent,SubscriptionsAPIFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscriptionsAPIFilter build() {
    SubscriptionsAPIFilter buildable = new SubscriptionsAPIFilter(fluent.buildAll(), fluent.buildAny(), fluent.getCesql(), fluent.getExact(), fluent.buildNot(), fluent.getPrefix(), fluent.getSuffix());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}