package io.fabric8.openshift.api.model.insights.v1alpha2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GathererConfigBuilder extends GathererConfigFluent<GathererConfigBuilder> implements VisitableBuilder<GathererConfig,GathererConfigBuilder>{

  GathererConfigFluent<?> fluent;

  public GathererConfigBuilder() {
    this(new GathererConfig());
  }
  
  public GathererConfigBuilder(GathererConfigFluent<?> fluent) {
    this(fluent, new GathererConfig());
  }
  
  public GathererConfigBuilder(GathererConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GathererConfigBuilder(GathererConfigFluent<?> fluent,GathererConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GathererConfig build() {
    GathererConfig buildable = new GathererConfig(fluent.getName(), fluent.getState());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}