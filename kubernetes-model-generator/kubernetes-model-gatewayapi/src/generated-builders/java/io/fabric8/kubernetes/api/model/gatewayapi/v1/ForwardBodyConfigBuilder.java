package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ForwardBodyConfigBuilder extends ForwardBodyConfigFluent<ForwardBodyConfigBuilder> implements VisitableBuilder<ForwardBodyConfig,ForwardBodyConfigBuilder>{

  ForwardBodyConfigFluent<?> fluent;

  public ForwardBodyConfigBuilder() {
    this(new ForwardBodyConfig());
  }
  
  public ForwardBodyConfigBuilder(ForwardBodyConfigFluent<?> fluent) {
    this(fluent, new ForwardBodyConfig());
  }
  
  public ForwardBodyConfigBuilder(ForwardBodyConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ForwardBodyConfigBuilder(ForwardBodyConfigFluent<?> fluent,ForwardBodyConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ForwardBodyConfig build() {
    ForwardBodyConfig buildable = new ForwardBodyConfig(fluent.getMaxSize());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}