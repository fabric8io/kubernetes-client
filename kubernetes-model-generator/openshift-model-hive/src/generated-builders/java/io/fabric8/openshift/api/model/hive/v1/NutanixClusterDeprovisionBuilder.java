package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixClusterDeprovisionBuilder extends NutanixClusterDeprovisionFluent<NutanixClusterDeprovisionBuilder> implements VisitableBuilder<NutanixClusterDeprovision,NutanixClusterDeprovisionBuilder>{

  NutanixClusterDeprovisionFluent<?> fluent;

  public NutanixClusterDeprovisionBuilder() {
    this(new NutanixClusterDeprovision());
  }
  
  public NutanixClusterDeprovisionBuilder(NutanixClusterDeprovisionFluent<?> fluent) {
    this(fluent, new NutanixClusterDeprovision());
  }
  
  public NutanixClusterDeprovisionBuilder(NutanixClusterDeprovision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixClusterDeprovisionBuilder(NutanixClusterDeprovisionFluent<?> fluent,NutanixClusterDeprovision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixClusterDeprovision build() {
    NutanixClusterDeprovision buildable = new NutanixClusterDeprovision(fluent.buildCertificatesSecretRef(), fluent.buildCredentialsSecretRef(), fluent.buildPrismCentral());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}