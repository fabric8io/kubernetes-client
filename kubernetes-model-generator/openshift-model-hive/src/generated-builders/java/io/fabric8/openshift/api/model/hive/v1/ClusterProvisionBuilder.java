package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterProvisionBuilder extends ClusterProvisionFluent<ClusterProvisionBuilder> implements VisitableBuilder<ClusterProvision,ClusterProvisionBuilder>{

  ClusterProvisionFluent<?> fluent;

  public ClusterProvisionBuilder() {
    this(new ClusterProvision());
  }
  
  public ClusterProvisionBuilder(ClusterProvisionFluent<?> fluent) {
    this(fluent, new ClusterProvision());
  }
  
  public ClusterProvisionBuilder(ClusterProvision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterProvisionBuilder(ClusterProvisionFluent<?> fluent,ClusterProvision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterProvision build() {
    ClusterProvision buildable = new ClusterProvision(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}