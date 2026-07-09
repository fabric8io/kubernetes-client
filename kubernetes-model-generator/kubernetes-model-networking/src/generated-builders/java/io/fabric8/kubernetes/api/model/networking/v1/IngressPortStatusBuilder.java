package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressPortStatusBuilder extends IngressPortStatusFluent<IngressPortStatusBuilder> implements VisitableBuilder<IngressPortStatus,IngressPortStatusBuilder>{

  IngressPortStatusFluent<?> fluent;

  public IngressPortStatusBuilder() {
    this(new IngressPortStatus());
  }
  
  public IngressPortStatusBuilder(IngressPortStatusFluent<?> fluent) {
    this(fluent, new IngressPortStatus());
  }
  
  public IngressPortStatusBuilder(IngressPortStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressPortStatusBuilder(IngressPortStatusFluent<?> fluent,IngressPortStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressPortStatus build() {
    IngressPortStatus buildable = new IngressPortStatus(fluent.getError(), fluent.getPort(), fluent.getProtocol());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}