package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PortBuilder extends PortFluent<PortBuilder> implements VisitableBuilder<Port,PortBuilder>{

  PortFluent<?> fluent;

  public PortBuilder() {
    this(new Port());
  }
  
  public PortBuilder(PortFluent<?> fluent) {
    this(fluent, new Port());
  }
  
  public PortBuilder(Port instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PortBuilder(PortFluent<?> fluent,Port instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Port build() {
    Port buildable = new Port(fluent.getName(), fluent.getNumber(), fluent.getProtocol(), fluent.getTargetPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}