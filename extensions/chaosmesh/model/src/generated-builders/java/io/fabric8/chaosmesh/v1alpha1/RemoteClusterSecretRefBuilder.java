package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RemoteClusterSecretRefBuilder extends RemoteClusterSecretRefFluent<RemoteClusterSecretRefBuilder> implements VisitableBuilder<RemoteClusterSecretRef,RemoteClusterSecretRefBuilder>{

  RemoteClusterSecretRefFluent<?> fluent;

  public RemoteClusterSecretRefBuilder() {
    this(new RemoteClusterSecretRef());
  }
  
  public RemoteClusterSecretRefBuilder(RemoteClusterSecretRefFluent<?> fluent) {
    this(fluent, new RemoteClusterSecretRef());
  }
  
  public RemoteClusterSecretRefBuilder(RemoteClusterSecretRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RemoteClusterSecretRefBuilder(RemoteClusterSecretRefFluent<?> fluent,RemoteClusterSecretRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RemoteClusterSecretRef build() {
    RemoteClusterSecretRef buildable = new RemoteClusterSecretRef(fluent.getKey(), fluent.getName(), fluent.getNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}