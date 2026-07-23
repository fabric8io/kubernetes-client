package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OvirtClusterDeprovisionBuilder extends OvirtClusterDeprovisionFluent<OvirtClusterDeprovisionBuilder> implements VisitableBuilder<OvirtClusterDeprovision,OvirtClusterDeprovisionBuilder>{

  OvirtClusterDeprovisionFluent<?> fluent;

  public OvirtClusterDeprovisionBuilder() {
    this(new OvirtClusterDeprovision());
  }
  
  public OvirtClusterDeprovisionBuilder(OvirtClusterDeprovisionFluent<?> fluent) {
    this(fluent, new OvirtClusterDeprovision());
  }
  
  public OvirtClusterDeprovisionBuilder(OvirtClusterDeprovision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OvirtClusterDeprovisionBuilder(OvirtClusterDeprovisionFluent<?> fluent,OvirtClusterDeprovision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OvirtClusterDeprovision build() {
    OvirtClusterDeprovision buildable = new OvirtClusterDeprovision(fluent.buildCertificatesSecretRef(), fluent.getClusterID(), fluent.buildCredentialsSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}