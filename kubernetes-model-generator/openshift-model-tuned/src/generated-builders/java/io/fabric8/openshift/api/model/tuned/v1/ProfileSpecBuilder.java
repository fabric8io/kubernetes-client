package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProfileSpecBuilder extends ProfileSpecFluent<ProfileSpecBuilder> implements VisitableBuilder<ProfileSpec,ProfileSpecBuilder>{

  ProfileSpecFluent<?> fluent;

  public ProfileSpecBuilder() {
    this(new ProfileSpec());
  }
  
  public ProfileSpecBuilder(ProfileSpecFluent<?> fluent) {
    this(fluent, new ProfileSpec());
  }
  
  public ProfileSpecBuilder(ProfileSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProfileSpecBuilder(ProfileSpecFluent<?> fluent,ProfileSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProfileSpec build() {
    ProfileSpec buildable = new ProfileSpec(fluent.buildConfig(), fluent.buildProfile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}