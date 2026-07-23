package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClientTLSBuilder extends ClientTLSFluent<ClientTLSBuilder> implements VisitableBuilder<ClientTLS,ClientTLSBuilder>{

  ClientTLSFluent<?> fluent;

  public ClientTLSBuilder() {
    this(new ClientTLS());
  }
  
  public ClientTLSBuilder(ClientTLSFluent<?> fluent) {
    this(fluent, new ClientTLS());
  }
  
  public ClientTLSBuilder(ClientTLS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClientTLSBuilder(ClientTLSFluent<?> fluent,ClientTLS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClientTLS build() {
    ClientTLS buildable = new ClientTLS(fluent.getAllowedSubjectPatterns(), fluent.getClientCA(), fluent.getClientCertificatePolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}