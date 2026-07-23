package io.fabric8.kubernetes.api.model.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPAddressBuilder extends IPAddressFluent<IPAddressBuilder> implements VisitableBuilder<IPAddress,IPAddressBuilder>{

  IPAddressFluent<?> fluent;

  public IPAddressBuilder() {
    this(new IPAddress());
  }
  
  public IPAddressBuilder(IPAddressFluent<?> fluent) {
    this(fluent, new IPAddress());
  }
  
  public IPAddressBuilder(IPAddress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPAddressBuilder(IPAddressFluent<?> fluent,IPAddress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPAddress build() {
    IPAddress buildable = new IPAddress(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}