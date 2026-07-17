package io.fabric8.openshift.api.model.tuned.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProfileConfigBuilder extends ProfileConfigFluent<ProfileConfigBuilder> implements VisitableBuilder<ProfileConfig,ProfileConfigBuilder>{

  ProfileConfigFluent<?> fluent;

  public ProfileConfigBuilder() {
    this(new ProfileConfig());
  }
  
  public ProfileConfigBuilder(ProfileConfigFluent<?> fluent) {
    this(fluent, new ProfileConfig());
  }
  
  public ProfileConfigBuilder(ProfileConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProfileConfigBuilder(ProfileConfigFluent<?> fluent,ProfileConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProfileConfig build() {
    ProfileConfig buildable = new ProfileConfig(fluent.getDebug(), fluent.getProviderName(), fluent.buildTunedConfig(), fluent.getTunedProfile(), fluent.getVerbosity());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}