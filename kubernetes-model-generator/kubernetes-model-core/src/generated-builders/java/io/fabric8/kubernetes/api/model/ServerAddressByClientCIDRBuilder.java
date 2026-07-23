package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServerAddressByClientCIDRBuilder extends ServerAddressByClientCIDRFluent<ServerAddressByClientCIDRBuilder> implements VisitableBuilder<ServerAddressByClientCIDR,ServerAddressByClientCIDRBuilder>{

  ServerAddressByClientCIDRFluent<?> fluent;

  public ServerAddressByClientCIDRBuilder() {
    this(new ServerAddressByClientCIDR());
  }
  
  public ServerAddressByClientCIDRBuilder(ServerAddressByClientCIDRFluent<?> fluent) {
    this(fluent, new ServerAddressByClientCIDR());
  }
  
  public ServerAddressByClientCIDRBuilder(ServerAddressByClientCIDR instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServerAddressByClientCIDRBuilder(ServerAddressByClientCIDRFluent<?> fluent,ServerAddressByClientCIDR instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServerAddressByClientCIDR build() {
    ServerAddressByClientCIDR buildable = new ServerAddressByClientCIDR(fluent.getClientCIDR(), fluent.getServerAddress());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}