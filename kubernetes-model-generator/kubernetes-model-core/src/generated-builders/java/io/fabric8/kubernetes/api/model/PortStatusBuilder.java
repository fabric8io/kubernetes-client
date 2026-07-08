package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PortStatusBuilder extends PortStatusFluent<PortStatusBuilder> implements VisitableBuilder<PortStatus,PortStatusBuilder>{

  PortStatusFluent<?> fluent;

  public PortStatusBuilder() {
    this(new PortStatus());
  }
  
  public PortStatusBuilder(PortStatusFluent<?> fluent) {
    this(fluent, new PortStatus());
  }
  
  public PortStatusBuilder(PortStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PortStatusBuilder(PortStatusFluent<?> fluent,PortStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PortStatus build() {
    PortStatus buildable = new PortStatus(fluent.getError(), fluent.getPort(), fluent.getProtocol());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}