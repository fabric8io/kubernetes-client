package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WarmupConfigurationBuilder extends WarmupConfigurationFluent<WarmupConfigurationBuilder> implements VisitableBuilder<WarmupConfiguration,WarmupConfigurationBuilder>{

  WarmupConfigurationFluent<?> fluent;

  public WarmupConfigurationBuilder() {
    this(new WarmupConfiguration());
  }
  
  public WarmupConfigurationBuilder(WarmupConfigurationFluent<?> fluent) {
    this(fluent, new WarmupConfiguration());
  }
  
  public WarmupConfigurationBuilder(WarmupConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WarmupConfigurationBuilder(WarmupConfigurationFluent<?> fluent,WarmupConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WarmupConfiguration build() {
    WarmupConfiguration buildable = new WarmupConfiguration(fluent.getAggression(), fluent.getDuration(), fluent.getMinimumPercent());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}