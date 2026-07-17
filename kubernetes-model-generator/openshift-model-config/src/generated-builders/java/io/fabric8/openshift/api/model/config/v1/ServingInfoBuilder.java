package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServingInfoBuilder extends ServingInfoFluent<ServingInfoBuilder> implements VisitableBuilder<ServingInfo,ServingInfoBuilder>{

  ServingInfoFluent<?> fluent;

  public ServingInfoBuilder() {
    this(new ServingInfo());
  }
  
  public ServingInfoBuilder(ServingInfoFluent<?> fluent) {
    this(fluent, new ServingInfo());
  }
  
  public ServingInfoBuilder(ServingInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServingInfoBuilder(ServingInfoFluent<?> fluent,ServingInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServingInfo build() {
    ServingInfo buildable = new ServingInfo(fluent.getBindAddress(), fluent.getBindNetwork(), fluent.getCertFile(), fluent.getCipherSuites(), fluent.getClientCA(), fluent.getKeyFile(), fluent.getMinTLSVersion(), fluent.buildNamedCertificates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}