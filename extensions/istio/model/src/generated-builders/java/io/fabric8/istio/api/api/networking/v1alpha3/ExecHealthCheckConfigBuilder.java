package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExecHealthCheckConfigBuilder extends ExecHealthCheckConfigFluent<ExecHealthCheckConfigBuilder> implements VisitableBuilder<ExecHealthCheckConfig,ExecHealthCheckConfigBuilder>{

  ExecHealthCheckConfigFluent<?> fluent;

  public ExecHealthCheckConfigBuilder() {
    this(new ExecHealthCheckConfig());
  }
  
  public ExecHealthCheckConfigBuilder(ExecHealthCheckConfigFluent<?> fluent) {
    this(fluent, new ExecHealthCheckConfig());
  }
  
  public ExecHealthCheckConfigBuilder(ExecHealthCheckConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExecHealthCheckConfigBuilder(ExecHealthCheckConfigFluent<?> fluent,ExecHealthCheckConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExecHealthCheckConfig build() {
    ExecHealthCheckConfig buildable = new ExecHealthCheckConfig(fluent.getCommand());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}