package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterPoolReferenceBuilder extends ClusterPoolReferenceFluent<ClusterPoolReferenceBuilder> implements VisitableBuilder<ClusterPoolReference,ClusterPoolReferenceBuilder>{

  ClusterPoolReferenceFluent<?> fluent;

  public ClusterPoolReferenceBuilder() {
    this(new ClusterPoolReference());
  }
  
  public ClusterPoolReferenceBuilder(ClusterPoolReferenceFluent<?> fluent) {
    this(fluent, new ClusterPoolReference());
  }
  
  public ClusterPoolReferenceBuilder(ClusterPoolReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterPoolReferenceBuilder(ClusterPoolReferenceFluent<?> fluent,ClusterPoolReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterPoolReference build() {
    ClusterPoolReference buildable = new ClusterPoolReference(fluent.getClaimName(), fluent.getClaimedTimestamp(), fluent.buildClusterDeploymentCustomization(), fluent.getNamespace(), fluent.getPoolName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}