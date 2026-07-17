package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDataIPv6Builder extends NetworkDataIPv6Fluent<NetworkDataIPv6Builder> implements VisitableBuilder<NetworkDataIPv6,NetworkDataIPv6Builder>{

  NetworkDataIPv6Fluent<?> fluent;

  public NetworkDataIPv6Builder() {
    this(new NetworkDataIPv6());
  }
  
  public NetworkDataIPv6Builder(NetworkDataIPv6Fluent<?> fluent) {
    this(fluent, new NetworkDataIPv6());
  }
  
  public NetworkDataIPv6Builder(NetworkDataIPv6 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDataIPv6Builder(NetworkDataIPv6Fluent<?> fluent,NetworkDataIPv6 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDataIPv6 build() {
    NetworkDataIPv6 buildable = new NetworkDataIPv6(fluent.buildFromPoolAnnotation(), fluent.getFromPoolRef(), fluent.getId(), fluent.getIpAddressFromIPPool(), fluent.getLink(), fluent.buildRoutes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}