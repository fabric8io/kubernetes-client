package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPClusterDeprovisionBuilder extends GCPClusterDeprovisionFluent<GCPClusterDeprovisionBuilder> implements VisitableBuilder<GCPClusterDeprovision,GCPClusterDeprovisionBuilder>{

  GCPClusterDeprovisionFluent<?> fluent;

  public GCPClusterDeprovisionBuilder() {
    this(new GCPClusterDeprovision());
  }
  
  public GCPClusterDeprovisionBuilder(GCPClusterDeprovisionFluent<?> fluent) {
    this(fluent, new GCPClusterDeprovision());
  }
  
  public GCPClusterDeprovisionBuilder(GCPClusterDeprovision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPClusterDeprovisionBuilder(GCPClusterDeprovisionFluent<?> fluent,GCPClusterDeprovision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPClusterDeprovision build() {
    GCPClusterDeprovision buildable = new GCPClusterDeprovision(fluent.buildCredentialsSecretRef(), fluent.getNetworkProjectID(), fluent.getRegion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}