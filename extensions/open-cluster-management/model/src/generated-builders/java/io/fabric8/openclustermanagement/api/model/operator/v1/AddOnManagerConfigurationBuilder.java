package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddOnManagerConfigurationBuilder extends AddOnManagerConfigurationFluent<AddOnManagerConfigurationBuilder> implements VisitableBuilder<AddOnManagerConfiguration,AddOnManagerConfigurationBuilder>{

  AddOnManagerConfigurationFluent<?> fluent;

  public AddOnManagerConfigurationBuilder() {
    this(new AddOnManagerConfiguration());
  }
  
  public AddOnManagerConfigurationBuilder(AddOnManagerConfigurationFluent<?> fluent) {
    this(fluent, new AddOnManagerConfiguration());
  }
  
  public AddOnManagerConfigurationBuilder(AddOnManagerConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddOnManagerConfigurationBuilder(AddOnManagerConfigurationFluent<?> fluent,AddOnManagerConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AddOnManagerConfiguration build() {
    AddOnManagerConfiguration buildable = new AddOnManagerConfiguration(fluent.buildFeatureGates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}