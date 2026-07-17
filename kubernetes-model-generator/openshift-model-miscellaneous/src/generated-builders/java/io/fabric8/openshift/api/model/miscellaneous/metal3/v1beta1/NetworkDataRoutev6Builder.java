package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkDataRoutev6Builder extends NetworkDataRoutev6Fluent<NetworkDataRoutev6Builder> implements VisitableBuilder<NetworkDataRoutev6,NetworkDataRoutev6Builder>{

  NetworkDataRoutev6Fluent<?> fluent;

  public NetworkDataRoutev6Builder() {
    this(new NetworkDataRoutev6());
  }
  
  public NetworkDataRoutev6Builder(NetworkDataRoutev6Fluent<?> fluent) {
    this(fluent, new NetworkDataRoutev6());
  }
  
  public NetworkDataRoutev6Builder(NetworkDataRoutev6 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkDataRoutev6Builder(NetworkDataRoutev6Fluent<?> fluent,NetworkDataRoutev6 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkDataRoutev6 build() {
    NetworkDataRoutev6 buildable = new NetworkDataRoutev6(fluent.buildGateway(), fluent.getNetwork(), fluent.getPrefix(), fluent.buildServices());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}