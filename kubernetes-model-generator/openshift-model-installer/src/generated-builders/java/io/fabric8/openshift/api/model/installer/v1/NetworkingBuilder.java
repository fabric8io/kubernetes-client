package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkingBuilder extends NetworkingFluent<NetworkingBuilder> implements VisitableBuilder<Networking,NetworkingBuilder>{

  NetworkingFluent<?> fluent;

  public NetworkingBuilder() {
    this(new Networking());
  }
  
  public NetworkingBuilder(NetworkingFluent<?> fluent) {
    this(fluent, new Networking());
  }
  
  public NetworkingBuilder(Networking instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkingBuilder(NetworkingFluent<?> fluent,Networking instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Networking build() {
    Networking buildable = new Networking(fluent.buildClusterNetwork(), fluent.getClusterNetworkMTU(), fluent.buildClusterNetworkList(), fluent.getMachineCIDR(), fluent.buildMachineNetwork(), fluent.getNetworkType(), fluent.buildOvnKubernetesConfig(), fluent.getServiceCIDR(), fluent.getServiceNetwork(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}