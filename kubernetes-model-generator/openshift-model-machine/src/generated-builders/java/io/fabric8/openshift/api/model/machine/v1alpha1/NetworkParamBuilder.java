package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkParamBuilder extends NetworkParamFluent<NetworkParamBuilder> implements VisitableBuilder<NetworkParam,NetworkParamBuilder>{

  NetworkParamFluent<?> fluent;

  public NetworkParamBuilder() {
    this(new NetworkParam());
  }
  
  public NetworkParamBuilder(NetworkParamFluent<?> fluent) {
    this(fluent, new NetworkParam());
  }
  
  public NetworkParamBuilder(NetworkParam instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkParamBuilder(NetworkParamFluent<?> fluent,NetworkParam instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkParam build() {
    NetworkParam buildable = new NetworkParam(fluent.buildFilter(), fluent.getFixedIp(), fluent.getNoAllowedAddressPairs(), fluent.getPortSecurity(), fluent.getPortTags(), fluent.getProfile(), fluent.buildSubnets(), fluent.getUuid(), fluent.getVnicType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}