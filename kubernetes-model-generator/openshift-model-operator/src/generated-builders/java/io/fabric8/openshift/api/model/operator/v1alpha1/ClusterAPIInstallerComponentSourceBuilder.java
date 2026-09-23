package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAPIInstallerComponentSourceBuilder extends ClusterAPIInstallerComponentSourceFluent<ClusterAPIInstallerComponentSourceBuilder> implements VisitableBuilder<ClusterAPIInstallerComponentSource,ClusterAPIInstallerComponentSourceBuilder>{

  ClusterAPIInstallerComponentSourceFluent<?> fluent;

  public ClusterAPIInstallerComponentSourceBuilder() {
    this(new ClusterAPIInstallerComponentSource());
  }
  
  public ClusterAPIInstallerComponentSourceBuilder(ClusterAPIInstallerComponentSourceFluent<?> fluent) {
    this(fluent, new ClusterAPIInstallerComponentSource());
  }
  
  public ClusterAPIInstallerComponentSourceBuilder(ClusterAPIInstallerComponentSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAPIInstallerComponentSourceBuilder(ClusterAPIInstallerComponentSourceFluent<?> fluent,ClusterAPIInstallerComponentSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAPIInstallerComponentSource build() {
    ClusterAPIInstallerComponentSource buildable = new ClusterAPIInstallerComponentSource(fluent.buildImage(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}