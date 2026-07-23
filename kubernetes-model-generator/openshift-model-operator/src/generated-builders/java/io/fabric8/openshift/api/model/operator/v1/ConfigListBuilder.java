package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigListBuilder extends ConfigListFluent<ConfigListBuilder> implements VisitableBuilder<ConfigList,ConfigListBuilder>{

  ConfigListFluent<?> fluent;

  public ConfigListBuilder() {
    this(new ConfigList());
  }
  
  public ConfigListBuilder(ConfigListFluent<?> fluent) {
    this(fluent, new ConfigList());
  }
  
  public ConfigListBuilder(ConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigListBuilder(ConfigListFluent<?> fluent,ConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigList build() {
    ConfigList buildable = new ConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}