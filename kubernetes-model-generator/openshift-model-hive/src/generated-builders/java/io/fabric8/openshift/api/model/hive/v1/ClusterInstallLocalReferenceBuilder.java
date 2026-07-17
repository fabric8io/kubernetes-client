package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterInstallLocalReferenceBuilder extends ClusterInstallLocalReferenceFluent<ClusterInstallLocalReferenceBuilder> implements VisitableBuilder<ClusterInstallLocalReference,ClusterInstallLocalReferenceBuilder>{

  ClusterInstallLocalReferenceFluent<?> fluent;

  public ClusterInstallLocalReferenceBuilder() {
    this(new ClusterInstallLocalReference());
  }
  
  public ClusterInstallLocalReferenceBuilder(ClusterInstallLocalReferenceFluent<?> fluent) {
    this(fluent, new ClusterInstallLocalReference());
  }
  
  public ClusterInstallLocalReferenceBuilder(ClusterInstallLocalReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterInstallLocalReferenceBuilder(ClusterInstallLocalReferenceFluent<?> fluent,ClusterInstallLocalReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterInstallLocalReference build() {
    ClusterInstallLocalReference buildable = new ClusterInstallLocalReference(fluent.getGroup(), fluent.getKind(), fluent.getName(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}