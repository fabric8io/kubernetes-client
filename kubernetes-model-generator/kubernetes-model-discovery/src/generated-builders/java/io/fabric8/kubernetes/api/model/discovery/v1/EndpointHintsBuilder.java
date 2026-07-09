package io.fabric8.kubernetes.api.model.discovery.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EndpointHintsBuilder extends EndpointHintsFluent<EndpointHintsBuilder> implements VisitableBuilder<EndpointHints,EndpointHintsBuilder>{

  EndpointHintsFluent<?> fluent;

  public EndpointHintsBuilder() {
    this(new EndpointHints());
  }
  
  public EndpointHintsBuilder(EndpointHintsFluent<?> fluent) {
    this(fluent, new EndpointHints());
  }
  
  public EndpointHintsBuilder(EndpointHints instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EndpointHintsBuilder(EndpointHintsFluent<?> fluent,EndpointHints instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EndpointHints build() {
    EndpointHints buildable = new EndpointHints(fluent.buildForNodes(), fluent.buildForZones());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}