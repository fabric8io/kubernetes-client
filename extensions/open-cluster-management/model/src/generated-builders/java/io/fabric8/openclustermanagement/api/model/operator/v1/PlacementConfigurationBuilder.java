package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlacementConfigurationBuilder extends PlacementConfigurationFluent<PlacementConfigurationBuilder> implements VisitableBuilder<PlacementConfiguration,PlacementConfigurationBuilder>{

  PlacementConfigurationFluent<?> fluent;

  public PlacementConfigurationBuilder() {
    this(new PlacementConfiguration());
  }
  
  public PlacementConfigurationBuilder(PlacementConfigurationFluent<?> fluent) {
    this(fluent, new PlacementConfiguration());
  }
  
  public PlacementConfigurationBuilder(PlacementConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlacementConfigurationBuilder(PlacementConfigurationFluent<?> fluent,PlacementConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PlacementConfiguration build() {
    PlacementConfiguration buildable = new PlacementConfiguration(fluent.buildFeatureGates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}