package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigBuilder;
import io.fabric8.openshift.api.model.DeploymentConfigFluent;

public class UpdateableDeploymentConfig extends DeploymentConfigFluent<UpdateableDeploymentConfig> implements Updateable<DeploymentConfig> {

  private final DeploymentConfigBuilder builder;
  private final Update<DeploymentConfig> update;

  public UpdateableDeploymentConfig(DeploymentConfig config, Update<DeploymentConfig> update) {
    this.builder = new DeploymentConfigBuilder(this, config);
    this.update = update;
  }

  @Override
  public DeploymentConfig update() {
    return update.apply(builder.build());
  }
}
