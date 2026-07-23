package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RemoteClusterKubeConfigBuilder extends RemoteClusterKubeConfigFluent<RemoteClusterKubeConfigBuilder> implements VisitableBuilder<RemoteClusterKubeConfig,RemoteClusterKubeConfigBuilder>{

  RemoteClusterKubeConfigFluent<?> fluent;

  public RemoteClusterKubeConfigBuilder() {
    this(new RemoteClusterKubeConfig());
  }
  
  public RemoteClusterKubeConfigBuilder(RemoteClusterKubeConfigFluent<?> fluent) {
    this(fluent, new RemoteClusterKubeConfig());
  }
  
  public RemoteClusterKubeConfigBuilder(RemoteClusterKubeConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RemoteClusterKubeConfigBuilder(RemoteClusterKubeConfigFluent<?> fluent,RemoteClusterKubeConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RemoteClusterKubeConfig build() {
    RemoteClusterKubeConfig buildable = new RemoteClusterKubeConfig(fluent.buildSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}