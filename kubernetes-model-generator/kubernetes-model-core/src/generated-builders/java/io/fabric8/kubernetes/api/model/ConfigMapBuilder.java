package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigMapBuilder extends ConfigMapFluent<ConfigMapBuilder> implements VisitableBuilder<ConfigMap,ConfigMapBuilder>{

  ConfigMapFluent<?> fluent;

  public ConfigMapBuilder() {
    this(new ConfigMap());
  }
  
  public ConfigMapBuilder(ConfigMapFluent<?> fluent) {
    this(fluent, new ConfigMap());
  }
  
  public ConfigMapBuilder(ConfigMap instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigMapBuilder(ConfigMapFluent<?> fluent,ConfigMap instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigMap build() {
    ConfigMap buildable = new ConfigMap(fluent.getApiVersion(), fluent.getBinaryData(), fluent.getData(), fluent.getImmutable(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}