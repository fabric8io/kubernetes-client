package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDataLinkBuilder extends NetworkDataLinkFluent<NetworkDataLinkBuilder> implements VisitableBuilder<NetworkDataLink,NetworkDataLinkBuilder>{

  NetworkDataLinkFluent<?> fluent;

  public NetworkDataLinkBuilder() {
    this(new NetworkDataLink());
  }
  
  public NetworkDataLinkBuilder(NetworkDataLinkFluent<?> fluent) {
    this(fluent, new NetworkDataLink());
  }
  
  public NetworkDataLinkBuilder(NetworkDataLink instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDataLinkBuilder(NetworkDataLinkFluent<?> fluent,NetworkDataLink instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDataLink build() {
    NetworkDataLink buildable = new NetworkDataLink(fluent.buildBonds(), fluent.buildEthernets(), fluent.buildVlans());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}