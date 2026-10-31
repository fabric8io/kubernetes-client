package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAPIInstallerRevisionBuilder extends ClusterAPIInstallerRevisionFluent<ClusterAPIInstallerRevisionBuilder> implements VisitableBuilder<ClusterAPIInstallerRevision,ClusterAPIInstallerRevisionBuilder>{

  ClusterAPIInstallerRevisionFluent<?> fluent;

  public ClusterAPIInstallerRevisionBuilder() {
    this(new ClusterAPIInstallerRevision());
  }
  
  public ClusterAPIInstallerRevisionBuilder(ClusterAPIInstallerRevisionFluent<?> fluent) {
    this(fluent, new ClusterAPIInstallerRevision());
  }
  
  public ClusterAPIInstallerRevisionBuilder(ClusterAPIInstallerRevision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAPIInstallerRevisionBuilder(ClusterAPIInstallerRevisionFluent<?> fluent,ClusterAPIInstallerRevision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAPIInstallerRevision build() {
    ClusterAPIInstallerRevision buildable = new ClusterAPIInstallerRevision(fluent.buildComponents(), fluent.getContentID(), fluent.buildManifestSubstitutions(), fluent.getName(), fluent.getRevision(), fluent.getUnmanagedCustomResourceDefinitions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}