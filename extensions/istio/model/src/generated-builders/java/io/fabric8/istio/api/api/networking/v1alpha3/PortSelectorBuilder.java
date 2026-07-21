package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PortSelectorBuilder extends PortSelectorFluent<PortSelectorBuilder> implements VisitableBuilder<PortSelector,PortSelectorBuilder>{

  PortSelectorFluent<?> fluent;

  public PortSelectorBuilder() {
    this(new PortSelector());
  }
  
  public PortSelectorBuilder(PortSelectorFluent<?> fluent) {
    this(fluent, new PortSelector());
  }
  
  public PortSelectorBuilder(PortSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PortSelectorBuilder(PortSelectorFluent<?> fluent,PortSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PortSelector build() {
    PortSelector buildable = new PortSelector(fluent.getNumber());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}