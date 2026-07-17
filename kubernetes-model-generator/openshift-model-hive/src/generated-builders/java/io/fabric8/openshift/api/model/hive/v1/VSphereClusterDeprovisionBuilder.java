package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSphereClusterDeprovisionBuilder extends VSphereClusterDeprovisionFluent<VSphereClusterDeprovisionBuilder> implements VisitableBuilder<VSphereClusterDeprovision,VSphereClusterDeprovisionBuilder>{

  VSphereClusterDeprovisionFluent<?> fluent;

  public VSphereClusterDeprovisionBuilder() {
    this(new VSphereClusterDeprovision());
  }
  
  public VSphereClusterDeprovisionBuilder(VSphereClusterDeprovisionFluent<?> fluent) {
    this(fluent, new VSphereClusterDeprovision());
  }
  
  public VSphereClusterDeprovisionBuilder(VSphereClusterDeprovision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSphereClusterDeprovisionBuilder(VSphereClusterDeprovisionFluent<?> fluent,VSphereClusterDeprovision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSphereClusterDeprovision build() {
    VSphereClusterDeprovision buildable = new VSphereClusterDeprovision(fluent.buildCertificatesSecretRef(), fluent.buildCredentialsSecretRef(), fluent.getVCenter());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}