package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAPIInstallerComponentImageBuilder extends ClusterAPIInstallerComponentImageFluent<ClusterAPIInstallerComponentImageBuilder> implements VisitableBuilder<ClusterAPIInstallerComponentImage,ClusterAPIInstallerComponentImageBuilder>{

  ClusterAPIInstallerComponentImageFluent<?> fluent;

  public ClusterAPIInstallerComponentImageBuilder() {
    this(new ClusterAPIInstallerComponentImage());
  }
  
  public ClusterAPIInstallerComponentImageBuilder(ClusterAPIInstallerComponentImageFluent<?> fluent) {
    this(fluent, new ClusterAPIInstallerComponentImage());
  }
  
  public ClusterAPIInstallerComponentImageBuilder(ClusterAPIInstallerComponentImage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAPIInstallerComponentImageBuilder(ClusterAPIInstallerComponentImageFluent<?> fluent,ClusterAPIInstallerComponentImage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAPIInstallerComponentImage build() {
    ClusterAPIInstallerComponentImage buildable = new ClusterAPIInstallerComponentImage(fluent.getProfile(), fluent.getRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}