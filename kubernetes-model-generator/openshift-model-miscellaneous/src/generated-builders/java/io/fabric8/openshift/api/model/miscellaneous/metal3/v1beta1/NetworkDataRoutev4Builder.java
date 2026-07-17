package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDataRoutev4Builder extends NetworkDataRoutev4Fluent<NetworkDataRoutev4Builder> implements VisitableBuilder<NetworkDataRoutev4,NetworkDataRoutev4Builder>{

  NetworkDataRoutev4Fluent<?> fluent;

  public NetworkDataRoutev4Builder() {
    this(new NetworkDataRoutev4());
  }
  
  public NetworkDataRoutev4Builder(NetworkDataRoutev4Fluent<?> fluent) {
    this(fluent, new NetworkDataRoutev4());
  }
  
  public NetworkDataRoutev4Builder(NetworkDataRoutev4 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDataRoutev4Builder(NetworkDataRoutev4Fluent<?> fluent,NetworkDataRoutev4 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDataRoutev4 build() {
    NetworkDataRoutev4 buildable = new NetworkDataRoutev4(fluent.buildGateway(), fluent.getNetwork(), fluent.getPrefix(), fluent.buildServices());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}