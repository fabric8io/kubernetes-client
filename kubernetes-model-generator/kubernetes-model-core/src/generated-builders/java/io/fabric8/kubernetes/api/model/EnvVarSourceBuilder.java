package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvVarSourceBuilder extends EnvVarSourceFluent<EnvVarSourceBuilder> implements VisitableBuilder<EnvVarSource,EnvVarSourceBuilder>{

  EnvVarSourceFluent<?> fluent;

  public EnvVarSourceBuilder() {
    this(new EnvVarSource());
  }
  
  public EnvVarSourceBuilder(EnvVarSourceFluent<?> fluent) {
    this(fluent, new EnvVarSource());
  }
  
  public EnvVarSourceBuilder(EnvVarSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvVarSourceBuilder(EnvVarSourceFluent<?> fluent,EnvVarSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvVarSource build() {
    EnvVarSource buildable = new EnvVarSource(fluent.buildConfigMapKeyRef(), fluent.buildFieldRef(), fluent.buildFileKeyRef(), fluent.buildResourceFieldRef(), fluent.buildSecretKeyRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}