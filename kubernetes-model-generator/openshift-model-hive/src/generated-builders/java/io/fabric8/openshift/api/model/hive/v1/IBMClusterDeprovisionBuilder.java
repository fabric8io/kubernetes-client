package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IBMClusterDeprovisionBuilder extends IBMClusterDeprovisionFluent<IBMClusterDeprovisionBuilder> implements VisitableBuilder<IBMClusterDeprovision,IBMClusterDeprovisionBuilder>{

  IBMClusterDeprovisionFluent<?> fluent;

  public IBMClusterDeprovisionBuilder() {
    this(new IBMClusterDeprovision());
  }
  
  public IBMClusterDeprovisionBuilder(IBMClusterDeprovisionFluent<?> fluent) {
    this(fluent, new IBMClusterDeprovision());
  }
  
  public IBMClusterDeprovisionBuilder(IBMClusterDeprovision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IBMClusterDeprovisionBuilder(IBMClusterDeprovisionFluent<?> fluent,IBMClusterDeprovision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IBMClusterDeprovision build() {
    IBMClusterDeprovision buildable = new IBMClusterDeprovision(fluent.getBaseDomain(), fluent.buildCredentialsSecretRef(), fluent.getRegion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}