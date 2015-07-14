package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.client.dsl.Updateable;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigFluent;

public class UpdateableBuildConfig extends BuildConfigFluent<UpdateableBuildConfig> implements Updateable<BuildConfig> {

  @Override
  public BuildConfig update() {
    return null;
  }
}
