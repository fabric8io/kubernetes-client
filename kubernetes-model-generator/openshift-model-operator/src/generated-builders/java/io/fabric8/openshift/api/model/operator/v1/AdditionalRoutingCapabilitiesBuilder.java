package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdditionalRoutingCapabilitiesBuilder extends AdditionalRoutingCapabilitiesFluent<AdditionalRoutingCapabilitiesBuilder> implements VisitableBuilder<AdditionalRoutingCapabilities,AdditionalRoutingCapabilitiesBuilder>{

  AdditionalRoutingCapabilitiesFluent<?> fluent;

  public AdditionalRoutingCapabilitiesBuilder() {
    this(new AdditionalRoutingCapabilities());
  }
  
  public AdditionalRoutingCapabilitiesBuilder(AdditionalRoutingCapabilitiesFluent<?> fluent) {
    this(fluent, new AdditionalRoutingCapabilities());
  }
  
  public AdditionalRoutingCapabilitiesBuilder(AdditionalRoutingCapabilities instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdditionalRoutingCapabilitiesBuilder(AdditionalRoutingCapabilitiesFluent<?> fluent,AdditionalRoutingCapabilities instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdditionalRoutingCapabilities build() {
    AdditionalRoutingCapabilities buildable = new AdditionalRoutingCapabilities(fluent.getProviders());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}