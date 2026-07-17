package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProfileListBuilder extends ProfileListFluent<ProfileListBuilder> implements VisitableBuilder<ProfileList,ProfileListBuilder>{

  ProfileListFluent<?> fluent;

  public ProfileListBuilder() {
    this(new ProfileList());
  }
  
  public ProfileListBuilder(ProfileListFluent<?> fluent) {
    this(fluent, new ProfileList());
  }
  
  public ProfileListBuilder(ProfileList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProfileListBuilder(ProfileListFluent<?> fluent,ProfileList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProfileList build() {
    ProfileList buildable = new ProfileList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}