package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkLinkEthernetMacFromAnnotationBuilder extends NetworkLinkEthernetMacFromAnnotationFluent<NetworkLinkEthernetMacFromAnnotationBuilder> implements VisitableBuilder<NetworkLinkEthernetMacFromAnnotation,NetworkLinkEthernetMacFromAnnotationBuilder>{

  NetworkLinkEthernetMacFromAnnotationFluent<?> fluent;

  public NetworkLinkEthernetMacFromAnnotationBuilder() {
    this(new NetworkLinkEthernetMacFromAnnotation());
  }
  
  public NetworkLinkEthernetMacFromAnnotationBuilder(NetworkLinkEthernetMacFromAnnotationFluent<?> fluent) {
    this(fluent, new NetworkLinkEthernetMacFromAnnotation());
  }
  
  public NetworkLinkEthernetMacFromAnnotationBuilder(NetworkLinkEthernetMacFromAnnotation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkLinkEthernetMacFromAnnotationBuilder(NetworkLinkEthernetMacFromAnnotationFluent<?> fluent,NetworkLinkEthernetMacFromAnnotation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkLinkEthernetMacFromAnnotation build() {
    NetworkLinkEthernetMacFromAnnotation buildable = new NetworkLinkEthernetMacFromAnnotation(fluent.getAnnotation(), fluent.getObject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}