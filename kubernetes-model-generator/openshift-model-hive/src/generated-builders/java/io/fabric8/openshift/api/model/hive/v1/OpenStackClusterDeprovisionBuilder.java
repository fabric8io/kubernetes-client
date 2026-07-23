package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenStackClusterDeprovisionBuilder extends OpenStackClusterDeprovisionFluent<OpenStackClusterDeprovisionBuilder> implements VisitableBuilder<OpenStackClusterDeprovision,OpenStackClusterDeprovisionBuilder>{

  OpenStackClusterDeprovisionFluent<?> fluent;

  public OpenStackClusterDeprovisionBuilder() {
    this(new OpenStackClusterDeprovision());
  }
  
  public OpenStackClusterDeprovisionBuilder(OpenStackClusterDeprovisionFluent<?> fluent) {
    this(fluent, new OpenStackClusterDeprovision());
  }
  
  public OpenStackClusterDeprovisionBuilder(OpenStackClusterDeprovision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenStackClusterDeprovisionBuilder(OpenStackClusterDeprovisionFluent<?> fluent,OpenStackClusterDeprovision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenStackClusterDeprovision build() {
    OpenStackClusterDeprovision buildable = new OpenStackClusterDeprovision(fluent.buildCertificatesSecretRef(), fluent.getCloud(), fluent.buildCredentialsSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}