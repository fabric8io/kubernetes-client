package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAPIInstallerComponentBuilder extends ClusterAPIInstallerComponentFluent<ClusterAPIInstallerComponentBuilder> implements VisitableBuilder<ClusterAPIInstallerComponent,ClusterAPIInstallerComponentBuilder>{

  ClusterAPIInstallerComponentFluent<?> fluent;

  public ClusterAPIInstallerComponentBuilder() {
    this(new ClusterAPIInstallerComponent());
  }
  
  public ClusterAPIInstallerComponentBuilder(ClusterAPIInstallerComponentFluent<?> fluent) {
    this(fluent, new ClusterAPIInstallerComponent());
  }
  
  public ClusterAPIInstallerComponentBuilder(ClusterAPIInstallerComponent instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAPIInstallerComponentBuilder(ClusterAPIInstallerComponentFluent<?> fluent,ClusterAPIInstallerComponent instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAPIInstallerComponent build() {
    ClusterAPIInstallerComponent buildable = new ClusterAPIInstallerComponent(fluent.buildImage(), fluent.getName(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}