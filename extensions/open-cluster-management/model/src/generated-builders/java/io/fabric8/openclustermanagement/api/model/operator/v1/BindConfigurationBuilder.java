package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BindConfigurationBuilder extends BindConfigurationFluent<BindConfigurationBuilder> implements VisitableBuilder<BindConfiguration,BindConfigurationBuilder>{

  BindConfigurationFluent<?> fluent;

  public BindConfigurationBuilder() {
    this(new BindConfiguration());
  }
  
  public BindConfigurationBuilder(BindConfigurationFluent<?> fluent) {
    this(fluent, new BindConfiguration());
  }
  
  public BindConfigurationBuilder(BindConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BindConfigurationBuilder(BindConfigurationFluent<?> fluent,BindConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BindConfiguration build() {
    BindConfiguration buildable = new BindConfiguration(fluent.getHealthProbePort(), fluent.getHostNetwork(), fluent.getMetricsPort(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}