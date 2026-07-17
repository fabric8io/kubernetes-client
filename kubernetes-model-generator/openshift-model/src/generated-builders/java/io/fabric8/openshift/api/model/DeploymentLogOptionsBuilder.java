package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeploymentLogOptionsBuilder extends DeploymentLogOptionsFluent<DeploymentLogOptionsBuilder> implements VisitableBuilder<DeploymentLogOptions,DeploymentLogOptionsBuilder>{

  DeploymentLogOptionsFluent<?> fluent;

  public DeploymentLogOptionsBuilder() {
    this(new DeploymentLogOptions());
  }
  
  public DeploymentLogOptionsBuilder(DeploymentLogOptionsFluent<?> fluent) {
    this(fluent, new DeploymentLogOptions());
  }
  
  public DeploymentLogOptionsBuilder(DeploymentLogOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeploymentLogOptionsBuilder(DeploymentLogOptionsFluent<?> fluent,DeploymentLogOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeploymentLogOptions build() {
    DeploymentLogOptions buildable = new DeploymentLogOptions(fluent.getApiVersion(), fluent.getContainer(), fluent.getFollow(), fluent.getKind(), fluent.getLimitBytes(), fluent.getNowait(), fluent.getPrevious(), fluent.getSinceSeconds(), fluent.getSinceTime(), fluent.getTailLines(), fluent.getTimestamps(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}