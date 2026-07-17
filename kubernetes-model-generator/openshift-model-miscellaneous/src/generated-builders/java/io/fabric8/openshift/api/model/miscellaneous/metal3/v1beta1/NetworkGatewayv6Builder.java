package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkGatewayv6Builder extends NetworkGatewayv6Fluent<NetworkGatewayv6Builder> implements VisitableBuilder<NetworkGatewayv6,NetworkGatewayv6Builder>{

  NetworkGatewayv6Fluent<?> fluent;

  public NetworkGatewayv6Builder() {
    this(new NetworkGatewayv6());
  }
  
  public NetworkGatewayv6Builder(NetworkGatewayv6Fluent<?> fluent) {
    this(fluent, new NetworkGatewayv6());
  }
  
  public NetworkGatewayv6Builder(NetworkGatewayv6 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkGatewayv6Builder(NetworkGatewayv6Fluent<?> fluent,NetworkGatewayv6 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkGatewayv6 build() {
    NetworkGatewayv6 buildable = new NetworkGatewayv6(fluent.getFromIPPool(), fluent.buildFromPoolAnnotation(), fluent.getFromPoolRef(), fluent.getString());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}