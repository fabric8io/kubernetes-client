package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDataIPv4Builder extends NetworkDataIPv4Fluent<NetworkDataIPv4Builder> implements VisitableBuilder<NetworkDataIPv4,NetworkDataIPv4Builder>{

  NetworkDataIPv4Fluent<?> fluent;

  public NetworkDataIPv4Builder() {
    this(new NetworkDataIPv4());
  }
  
  public NetworkDataIPv4Builder(NetworkDataIPv4Fluent<?> fluent) {
    this(fluent, new NetworkDataIPv4());
  }
  
  public NetworkDataIPv4Builder(NetworkDataIPv4 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDataIPv4Builder(NetworkDataIPv4Fluent<?> fluent,NetworkDataIPv4 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDataIPv4 build() {
    NetworkDataIPv4 buildable = new NetworkDataIPv4(fluent.buildFromPoolAnnotation(), fluent.getFromPoolRef(), fluent.getId(), fluent.getIpAddressFromIPPool(), fluent.getLink(), fluent.buildRoutes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}