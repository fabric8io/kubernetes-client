package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProfileBuilder extends ProfileFluent<ProfileBuilder> implements VisitableBuilder<Profile,ProfileBuilder>{

  ProfileFluent<?> fluent;

  public ProfileBuilder() {
    this(new Profile());
  }
  
  public ProfileBuilder(ProfileFluent<?> fluent) {
    this(fluent, new Profile());
  }
  
  public ProfileBuilder(Profile instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProfileBuilder(ProfileFluent<?> fluent,Profile instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Profile build() {
    Profile buildable = new Profile(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}