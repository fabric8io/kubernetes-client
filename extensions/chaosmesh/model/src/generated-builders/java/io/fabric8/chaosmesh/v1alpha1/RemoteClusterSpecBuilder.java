package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RemoteClusterSpecBuilder extends RemoteClusterSpecFluent<RemoteClusterSpecBuilder> implements VisitableBuilder<RemoteClusterSpec,RemoteClusterSpecBuilder>{

  RemoteClusterSpecFluent<?> fluent;

  public RemoteClusterSpecBuilder() {
    this(new RemoteClusterSpec());
  }
  
  public RemoteClusterSpecBuilder(RemoteClusterSpecFluent<?> fluent) {
    this(fluent, new RemoteClusterSpec());
  }
  
  public RemoteClusterSpecBuilder(RemoteClusterSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RemoteClusterSpecBuilder(RemoteClusterSpecFluent<?> fluent,RemoteClusterSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RemoteClusterSpec build() {
    RemoteClusterSpec buildable = new RemoteClusterSpec(fluent.getConfigOverride(), fluent.buildKubeConfig(), fluent.getNamespace(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}