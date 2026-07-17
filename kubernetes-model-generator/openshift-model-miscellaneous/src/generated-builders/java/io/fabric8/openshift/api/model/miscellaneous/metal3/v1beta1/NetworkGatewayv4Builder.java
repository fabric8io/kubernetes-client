package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkGatewayv4Builder extends NetworkGatewayv4Fluent<NetworkGatewayv4Builder> implements VisitableBuilder<NetworkGatewayv4,NetworkGatewayv4Builder>{

  NetworkGatewayv4Fluent<?> fluent;

  public NetworkGatewayv4Builder() {
    this(new NetworkGatewayv4());
  }
  
  public NetworkGatewayv4Builder(NetworkGatewayv4Fluent<?> fluent) {
    this(fluent, new NetworkGatewayv4());
  }
  
  public NetworkGatewayv4Builder(NetworkGatewayv4 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkGatewayv4Builder(NetworkGatewayv4Fluent<?> fluent,NetworkGatewayv4 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkGatewayv4 build() {
    NetworkGatewayv4 buildable = new NetworkGatewayv4(fluent.getFromIPPool(), fluent.buildFromPoolAnnotation(), fluent.getFromPoolRef(), fluent.getString());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}