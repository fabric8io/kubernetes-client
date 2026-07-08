package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigMapListBuilder extends ConfigMapListFluent<ConfigMapListBuilder> implements VisitableBuilder<ConfigMapList,ConfigMapListBuilder>{

  ConfigMapListFluent<?> fluent;

  public ConfigMapListBuilder() {
    this(new ConfigMapList());
  }
  
  public ConfigMapListBuilder(ConfigMapListFluent<?> fluent) {
    this(fluent, new ConfigMapList());
  }
  
  public ConfigMapListBuilder(ConfigMapList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigMapListBuilder(ConfigMapListFluent<?> fluent,ConfigMapList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigMapList build() {
    ConfigMapList buildable = new ConfigMapList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}