package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigurationListBuilder extends ConfigurationListFluent<ConfigurationListBuilder> implements VisitableBuilder<ConfigurationList,ConfigurationListBuilder>{

  ConfigurationListFluent<?> fluent;

  public ConfigurationListBuilder() {
    this(new ConfigurationList());
  }
  
  public ConfigurationListBuilder(ConfigurationListFluent<?> fluent) {
    this(fluent, new ConfigurationList());
  }
  
  public ConfigurationListBuilder(ConfigurationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigurationListBuilder(ConfigurationListFluent<?> fluent,ConfigurationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigurationList build() {
    ConfigurationList buildable = new ConfigurationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}