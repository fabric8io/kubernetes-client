package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.client.dsl.Updateable;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigFluent;

public class UpdateableDeploymentConfig extends DeploymentConfigFluent<UpdateableDeploymentConfig> implements Updateable<DeploymentConfig> {

  @Override
  public DeploymentConfig update() {
    return null;
  }
}
