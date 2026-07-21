package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConfigurationBuilder extends ConfigurationFluent<ConfigurationBuilder> implements VisitableBuilder<Configuration,ConfigurationBuilder>{

  ConfigurationFluent<?> fluent;

  public ConfigurationBuilder() {
    this(new Configuration());
  }
  
  public ConfigurationBuilder(ConfigurationFluent<?> fluent) {
    this(fluent, new Configuration());
  }
  
  public ConfigurationBuilder(Configuration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConfigurationBuilder(ConfigurationFluent<?> fluent,Configuration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Configuration build() {
    Configuration buildable = new Configuration(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}