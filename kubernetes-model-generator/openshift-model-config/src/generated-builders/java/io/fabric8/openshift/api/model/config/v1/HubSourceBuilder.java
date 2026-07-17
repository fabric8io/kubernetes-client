package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HubSourceBuilder extends HubSourceFluent<HubSourceBuilder> implements VisitableBuilder<HubSource,HubSourceBuilder>{

  HubSourceFluent<?> fluent;

  public HubSourceBuilder() {
    this(new HubSource());
  }
  
  public HubSourceBuilder(HubSourceFluent<?> fluent) {
    this(fluent, new HubSource());
  }
  
  public HubSourceBuilder(HubSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HubSourceBuilder(HubSourceFluent<?> fluent,HubSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HubSource build() {
    HubSource buildable = new HubSource(fluent.getDisabled(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}