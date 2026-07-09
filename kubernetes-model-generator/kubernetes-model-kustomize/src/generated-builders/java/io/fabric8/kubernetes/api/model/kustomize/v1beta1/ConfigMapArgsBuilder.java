package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigMapArgsBuilder extends ConfigMapArgsFluent<ConfigMapArgsBuilder> implements VisitableBuilder<ConfigMapArgs,ConfigMapArgsBuilder>{

  ConfigMapArgsFluent<?> fluent;

  public ConfigMapArgsBuilder() {
    this(new ConfigMapArgs());
  }
  
  public ConfigMapArgsBuilder(ConfigMapArgsFluent<?> fluent) {
    this(fluent, new ConfigMapArgs());
  }
  
  public ConfigMapArgsBuilder(ConfigMapArgs instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigMapArgsBuilder(ConfigMapArgsFluent<?> fluent,ConfigMapArgs instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigMapArgs build() {
    ConfigMapArgs buildable = new ConfigMapArgs(fluent.getBehavior(), fluent.getEnv(), fluent.getEnvs(), fluent.getFiles(), fluent.getLiterals(), fluent.getName(), fluent.getNamespace(), fluent.buildOptions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}