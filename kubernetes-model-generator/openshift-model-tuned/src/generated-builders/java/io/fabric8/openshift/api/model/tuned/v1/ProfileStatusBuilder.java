package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProfileStatusBuilder extends ProfileStatusFluent<ProfileStatusBuilder> implements VisitableBuilder<ProfileStatus,ProfileStatusBuilder>{

  ProfileStatusFluent<?> fluent;

  public ProfileStatusBuilder() {
    this(new ProfileStatus());
  }
  
  public ProfileStatusBuilder(ProfileStatusFluent<?> fluent) {
    this(fluent, new ProfileStatus());
  }
  
  public ProfileStatusBuilder(ProfileStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProfileStatusBuilder(ProfileStatusFluent<?> fluent,ProfileStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProfileStatus build() {
    ProfileStatus buildable = new ProfileStatus(fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getTunedProfile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}