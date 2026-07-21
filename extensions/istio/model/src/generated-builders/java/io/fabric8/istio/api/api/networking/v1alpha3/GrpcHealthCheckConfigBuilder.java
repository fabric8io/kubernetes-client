package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GrpcHealthCheckConfigBuilder extends GrpcHealthCheckConfigFluent<GrpcHealthCheckConfigBuilder> implements VisitableBuilder<GrpcHealthCheckConfig,GrpcHealthCheckConfigBuilder>{

  GrpcHealthCheckConfigFluent<?> fluent;

  public GrpcHealthCheckConfigBuilder() {
    this(new GrpcHealthCheckConfig());
  }
  
  public GrpcHealthCheckConfigBuilder(GrpcHealthCheckConfigFluent<?> fluent) {
    this(fluent, new GrpcHealthCheckConfig());
  }
  
  public GrpcHealthCheckConfigBuilder(GrpcHealthCheckConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GrpcHealthCheckConfigBuilder(GrpcHealthCheckConfigFluent<?> fluent,GrpcHealthCheckConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GrpcHealthCheckConfig build() {
    GrpcHealthCheckConfig buildable = new GrpcHealthCheckConfig(fluent.getPort(), fluent.getService());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}