package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAPIInstallerRevisionManifestSubstitutionBuilder extends ClusterAPIInstallerRevisionManifestSubstitutionFluent<ClusterAPIInstallerRevisionManifestSubstitutionBuilder> implements VisitableBuilder<ClusterAPIInstallerRevisionManifestSubstitution,ClusterAPIInstallerRevisionManifestSubstitutionBuilder>{

  ClusterAPIInstallerRevisionManifestSubstitutionFluent<?> fluent;

  public ClusterAPIInstallerRevisionManifestSubstitutionBuilder() {
    this(new ClusterAPIInstallerRevisionManifestSubstitution());
  }
  
  public ClusterAPIInstallerRevisionManifestSubstitutionBuilder(ClusterAPIInstallerRevisionManifestSubstitutionFluent<?> fluent) {
    this(fluent, new ClusterAPIInstallerRevisionManifestSubstitution());
  }
  
  public ClusterAPIInstallerRevisionManifestSubstitutionBuilder(ClusterAPIInstallerRevisionManifestSubstitution instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAPIInstallerRevisionManifestSubstitutionBuilder(ClusterAPIInstallerRevisionManifestSubstitutionFluent<?> fluent,ClusterAPIInstallerRevisionManifestSubstitution instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAPIInstallerRevisionManifestSubstitution build() {
    ClusterAPIInstallerRevisionManifestSubstitution buildable = new ClusterAPIInstallerRevisionManifestSubstitution(fluent.getKey(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}