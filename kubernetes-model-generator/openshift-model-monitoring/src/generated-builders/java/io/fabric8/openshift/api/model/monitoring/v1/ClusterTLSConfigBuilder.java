package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterTLSConfigBuilder extends ClusterTLSConfigFluent<ClusterTLSConfigBuilder> implements VisitableBuilder<ClusterTLSConfig,ClusterTLSConfigBuilder>{

  ClusterTLSConfigFluent<?> fluent;

  public ClusterTLSConfigBuilder() {
    this(new ClusterTLSConfig());
  }
  
  public ClusterTLSConfigBuilder(ClusterTLSConfigFluent<?> fluent) {
    this(fluent, new ClusterTLSConfig());
  }
  
  public ClusterTLSConfigBuilder(ClusterTLSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterTLSConfigBuilder(ClusterTLSConfigFluent<?> fluent,ClusterTLSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterTLSConfig build() {
    ClusterTLSConfig buildable = new ClusterTLSConfig(fluent.buildClient(), fluent.buildServer());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}