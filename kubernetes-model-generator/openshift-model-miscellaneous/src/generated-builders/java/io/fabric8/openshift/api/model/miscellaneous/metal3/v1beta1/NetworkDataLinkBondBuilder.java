package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDataLinkBondBuilder extends NetworkDataLinkBondFluent<NetworkDataLinkBondBuilder> implements VisitableBuilder<NetworkDataLinkBond,NetworkDataLinkBondBuilder>{

  NetworkDataLinkBondFluent<?> fluent;

  public NetworkDataLinkBondBuilder() {
    this(new NetworkDataLinkBond());
  }
  
  public NetworkDataLinkBondBuilder(NetworkDataLinkBondFluent<?> fluent) {
    this(fluent, new NetworkDataLinkBond());
  }
  
  public NetworkDataLinkBondBuilder(NetworkDataLinkBond instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDataLinkBondBuilder(NetworkDataLinkBondFluent<?> fluent,NetworkDataLinkBond instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDataLinkBond build() {
    NetworkDataLinkBond buildable = new NetworkDataLinkBond(fluent.getBondLinks(), fluent.getBondMode(), fluent.getBondXmitHashPolicy(), fluent.getId(), fluent.buildMacAddress(), fluent.getMtu(), fluent.getName(), fluent.getParameters());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}