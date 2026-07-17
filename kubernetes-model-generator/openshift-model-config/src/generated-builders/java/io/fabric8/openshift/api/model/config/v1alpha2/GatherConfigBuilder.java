package io.fabric8.openshift.api.model.config.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GatherConfigBuilder extends GatherConfigFluent<GatherConfigBuilder> implements VisitableBuilder<GatherConfig,GatherConfigBuilder>{

  GatherConfigFluent<?> fluent;

  public GatherConfigBuilder() {
    this(new GatherConfig());
  }
  
  public GatherConfigBuilder(GatherConfigFluent<?> fluent) {
    this(fluent, new GatherConfig());
  }
  
  public GatherConfigBuilder(GatherConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GatherConfigBuilder(GatherConfigFluent<?> fluent,GatherConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GatherConfig build() {
    GatherConfig buildable = new GatherConfig(fluent.getDataPolicy(), fluent.buildGatherers(), fluent.buildStorage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}