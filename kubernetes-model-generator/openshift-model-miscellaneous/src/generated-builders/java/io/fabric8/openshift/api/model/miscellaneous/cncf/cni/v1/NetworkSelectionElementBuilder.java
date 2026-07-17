package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkSelectionElementBuilder extends NetworkSelectionElementFluent<NetworkSelectionElementBuilder> implements VisitableBuilder<NetworkSelectionElement,NetworkSelectionElementBuilder>{

  NetworkSelectionElementFluent<?> fluent;

  public NetworkSelectionElementBuilder() {
    this(new NetworkSelectionElement());
  }
  
  public NetworkSelectionElementBuilder(NetworkSelectionElementFluent<?> fluent) {
    this(fluent, new NetworkSelectionElement());
  }
  
  public NetworkSelectionElementBuilder(NetworkSelectionElement instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkSelectionElementBuilder(NetworkSelectionElementFluent<?> fluent,NetworkSelectionElement instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkSelectionElement build() {
    NetworkSelectionElement buildable = new NetworkSelectionElement(fluent.buildBandwidth(), fluent.getCniArgs(), fluent.getDefaultRoute(), fluent.getInfinibandGuid(), fluent.getInterface(), fluent.getIpamClaimReference(), fluent.getIps(), fluent.getMac(), fluent.getName(), fluent.getNamespace(), fluent.buildPortMappings());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}