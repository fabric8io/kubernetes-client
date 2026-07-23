package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPServingInfoBuilder extends HTTPServingInfoFluent<HTTPServingInfoBuilder> implements VisitableBuilder<HTTPServingInfo,HTTPServingInfoBuilder>{

  HTTPServingInfoFluent<?> fluent;

  public HTTPServingInfoBuilder() {
    this(new HTTPServingInfo());
  }
  
  public HTTPServingInfoBuilder(HTTPServingInfoFluent<?> fluent) {
    this(fluent, new HTTPServingInfo());
  }
  
  public HTTPServingInfoBuilder(HTTPServingInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPServingInfoBuilder(HTTPServingInfoFluent<?> fluent,HTTPServingInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPServingInfo build() {
    HTTPServingInfo buildable = new HTTPServingInfo(fluent.getBindAddress(), fluent.getBindNetwork(), fluent.getCertFile(), fluent.getCipherSuites(), fluent.getClientCA(), fluent.getKeyFile(), fluent.getMaxRequestsInFlight(), fluent.getMinTLSVersion(), fluent.buildNamedCertificates(), fluent.getRequestTimeoutSeconds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}