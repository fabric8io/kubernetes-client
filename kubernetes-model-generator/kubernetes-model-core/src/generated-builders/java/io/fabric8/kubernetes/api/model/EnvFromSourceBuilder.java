package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvFromSourceBuilder extends EnvFromSourceFluent<EnvFromSourceBuilder> implements VisitableBuilder<EnvFromSource,EnvFromSourceBuilder>{

  EnvFromSourceFluent<?> fluent;

  public EnvFromSourceBuilder() {
    this(new EnvFromSource());
  }
  
  public EnvFromSourceBuilder(EnvFromSourceFluent<?> fluent) {
    this(fluent, new EnvFromSource());
  }
  
  public EnvFromSourceBuilder(EnvFromSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvFromSourceBuilder(EnvFromSourceFluent<?> fluent,EnvFromSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvFromSource build() {
    EnvFromSource buildable = new EnvFromSource(fluent.buildConfigMapRef(), fluent.getPrefix(), fluent.buildSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}