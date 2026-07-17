package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HubSourceStatusBuilder extends HubSourceStatusFluent<HubSourceStatusBuilder> implements VisitableBuilder<HubSourceStatus,HubSourceStatusBuilder>{

  HubSourceStatusFluent<?> fluent;

  public HubSourceStatusBuilder() {
    this(new HubSourceStatus());
  }
  
  public HubSourceStatusBuilder(HubSourceStatusFluent<?> fluent) {
    this(fluent, new HubSourceStatus());
  }
  
  public HubSourceStatusBuilder(HubSourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HubSourceStatusBuilder(HubSourceStatusFluent<?> fluent,HubSourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HubSourceStatus build() {
    HubSourceStatus buildable = new HubSourceStatus(fluent.getDisabled(), fluent.getMessage(), fluent.getName(), fluent.getStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}