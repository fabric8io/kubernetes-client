package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TLSPortConfigBuilder extends TLSPortConfigFluent<TLSPortConfigBuilder> implements VisitableBuilder<TLSPortConfig,TLSPortConfigBuilder>{

  TLSPortConfigFluent<?> fluent;

  public TLSPortConfigBuilder() {
    this(new TLSPortConfig());
  }
  
  public TLSPortConfigBuilder(TLSPortConfigFluent<?> fluent) {
    this(fluent, new TLSPortConfig());
  }
  
  public TLSPortConfigBuilder(TLSPortConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TLSPortConfigBuilder(TLSPortConfigFluent<?> fluent,TLSPortConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TLSPortConfig build() {
    TLSPortConfig buildable = new TLSPortConfig(fluent.getPort(), fluent.buildTls());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}