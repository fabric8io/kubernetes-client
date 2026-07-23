package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPAddressSpecBuilder extends IPAddressSpecFluent<IPAddressSpecBuilder> implements VisitableBuilder<IPAddressSpec,IPAddressSpecBuilder>{

  IPAddressSpecFluent<?> fluent;

  public IPAddressSpecBuilder() {
    this(new IPAddressSpec());
  }
  
  public IPAddressSpecBuilder(IPAddressSpecFluent<?> fluent) {
    this(fluent, new IPAddressSpec());
  }
  
  public IPAddressSpecBuilder(IPAddressSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPAddressSpecBuilder(IPAddressSpecFluent<?> fluent,IPAddressSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPAddressSpec build() {
    IPAddressSpec buildable = new IPAddressSpec(fluent.buildParentRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}