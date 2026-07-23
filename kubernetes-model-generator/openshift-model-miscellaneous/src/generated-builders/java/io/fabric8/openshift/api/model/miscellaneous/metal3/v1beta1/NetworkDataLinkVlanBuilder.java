package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDataLinkVlanBuilder extends NetworkDataLinkVlanFluent<NetworkDataLinkVlanBuilder> implements VisitableBuilder<NetworkDataLinkVlan,NetworkDataLinkVlanBuilder>{

  NetworkDataLinkVlanFluent<?> fluent;

  public NetworkDataLinkVlanBuilder() {
    this(new NetworkDataLinkVlan());
  }
  
  public NetworkDataLinkVlanBuilder(NetworkDataLinkVlanFluent<?> fluent) {
    this(fluent, new NetworkDataLinkVlan());
  }
  
  public NetworkDataLinkVlanBuilder(NetworkDataLinkVlan instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDataLinkVlanBuilder(NetworkDataLinkVlanFluent<?> fluent,NetworkDataLinkVlan instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDataLinkVlan build() {
    NetworkDataLinkVlan buildable = new NetworkDataLinkVlan(fluent.getId(), fluent.buildMacAddress(), fluent.getMtu(), fluent.getName(), fluent.getVlanID(), fluent.getVlanLink());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}