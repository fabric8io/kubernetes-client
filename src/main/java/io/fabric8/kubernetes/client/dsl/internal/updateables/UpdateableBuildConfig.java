package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.api.model.BuildConfigFluent;

public class UpdateableBuildConfig extends BuildConfigFluent<UpdateableBuildConfig> implements Updateable<BuildConfig> {

  private final BuildConfigBuilder builder;
  private final Update<BuildConfig> update;

  public UpdateableBuildConfig(BuildConfig buildConfig, Update<BuildConfig> update) {
    this.update = update;
    builder = new BuildConfigBuilder(this, buildConfig);
  }

  @Override
  public BuildConfig update() {
    return update.apply(builder.build());
  }
}
