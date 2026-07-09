package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SupportedFeatureBuilder extends SupportedFeatureFluent<SupportedFeatureBuilder> implements VisitableBuilder<SupportedFeature,SupportedFeatureBuilder>{

  SupportedFeatureFluent<?> fluent;

  public SupportedFeatureBuilder() {
    this(new SupportedFeature());
  }
  
  public SupportedFeatureBuilder(SupportedFeatureFluent<?> fluent) {
    this(fluent, new SupportedFeature());
  }
  
  public SupportedFeatureBuilder(SupportedFeature instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SupportedFeatureBuilder(SupportedFeatureFluent<?> fluent,SupportedFeature instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SupportedFeature build() {
    SupportedFeature buildable = new SupportedFeature(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}