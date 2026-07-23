package io.fabric8.openshift.api.model.miscellaneous.helm.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConnectionConfigNamespaceScopedBuilder extends ConnectionConfigNamespaceScopedFluent<ConnectionConfigNamespaceScopedBuilder> implements VisitableBuilder<ConnectionConfigNamespaceScoped,ConnectionConfigNamespaceScopedBuilder>{

  ConnectionConfigNamespaceScopedFluent<?> fluent;

  public ConnectionConfigNamespaceScopedBuilder() {
    this(new ConnectionConfigNamespaceScoped());
  }
  
  public ConnectionConfigNamespaceScopedBuilder(ConnectionConfigNamespaceScopedFluent<?> fluent) {
    this(fluent, new ConnectionConfigNamespaceScoped());
  }
  
  public ConnectionConfigNamespaceScopedBuilder(ConnectionConfigNamespaceScoped instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConnectionConfigNamespaceScopedBuilder(ConnectionConfigNamespaceScopedFluent<?> fluent,ConnectionConfigNamespaceScoped instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConnectionConfigNamespaceScoped build() {
    ConnectionConfigNamespaceScoped buildable = new ConnectionConfigNamespaceScoped(fluent.getBasicAuthConfig(), fluent.getCa(), fluent.getTlsClientConfig(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}