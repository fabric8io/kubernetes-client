package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChannelGateBuilder extends ChannelGateFluent<ChannelGateBuilder> implements VisitableBuilder<ChannelGate,ChannelGateBuilder>{

  ChannelGateFluent<?> fluent;

  public ChannelGateBuilder() {
    this(new ChannelGate());
  }
  
  public ChannelGateBuilder(ChannelGateFluent<?> fluent) {
    this(fluent, new ChannelGate());
  }
  
  public ChannelGateBuilder(ChannelGate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChannelGateBuilder(ChannelGateFluent<?> fluent,ChannelGate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChannelGate build() {
    ChannelGate buildable = new ChannelGate(fluent.getAnnotations(), fluent.buildLabelSelector(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}