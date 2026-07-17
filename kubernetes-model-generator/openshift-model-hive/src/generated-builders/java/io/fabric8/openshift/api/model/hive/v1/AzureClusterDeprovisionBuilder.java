package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureClusterDeprovisionBuilder extends AzureClusterDeprovisionFluent<AzureClusterDeprovisionBuilder> implements VisitableBuilder<AzureClusterDeprovision,AzureClusterDeprovisionBuilder>{

  AzureClusterDeprovisionFluent<?> fluent;

  public AzureClusterDeprovisionBuilder() {
    this(new AzureClusterDeprovision());
  }
  
  public AzureClusterDeprovisionBuilder(AzureClusterDeprovisionFluent<?> fluent) {
    this(fluent, new AzureClusterDeprovision());
  }
  
  public AzureClusterDeprovisionBuilder(AzureClusterDeprovision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureClusterDeprovisionBuilder(AzureClusterDeprovisionFluent<?> fluent,AzureClusterDeprovision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureClusterDeprovision build() {
    AzureClusterDeprovision buildable = new AzureClusterDeprovision(fluent.getCloudName(), fluent.buildCredentialsSecretRef(), fluent.getResourceGroupName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}