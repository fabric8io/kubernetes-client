package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProfileCustomizationsBuilder extends ProfileCustomizationsFluent<ProfileCustomizationsBuilder> implements VisitableBuilder<ProfileCustomizations,ProfileCustomizationsBuilder>{

  ProfileCustomizationsFluent<?> fluent;

  public ProfileCustomizationsBuilder() {
    this(new ProfileCustomizations());
  }
  
  public ProfileCustomizationsBuilder(ProfileCustomizationsFluent<?> fluent) {
    this(fluent, new ProfileCustomizations());
  }
  
  public ProfileCustomizationsBuilder(ProfileCustomizations instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProfileCustomizationsBuilder(ProfileCustomizationsFluent<?> fluent,ProfileCustomizations instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProfileCustomizations build() {
    ProfileCustomizations buildable = new ProfileCustomizations(fluent.getDynamicResourceAllocation());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}