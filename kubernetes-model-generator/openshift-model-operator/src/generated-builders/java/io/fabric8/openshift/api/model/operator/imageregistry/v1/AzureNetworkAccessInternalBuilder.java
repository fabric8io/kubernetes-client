package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureNetworkAccessInternalBuilder extends AzureNetworkAccessInternalFluent<AzureNetworkAccessInternalBuilder> implements VisitableBuilder<AzureNetworkAccessInternal,AzureNetworkAccessInternalBuilder>{

  AzureNetworkAccessInternalFluent<?> fluent;

  public AzureNetworkAccessInternalBuilder() {
    this(new AzureNetworkAccessInternal());
  }
  
  public AzureNetworkAccessInternalBuilder(AzureNetworkAccessInternalFluent<?> fluent) {
    this(fluent, new AzureNetworkAccessInternal());
  }
  
  public AzureNetworkAccessInternalBuilder(AzureNetworkAccessInternal instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureNetworkAccessInternalBuilder(AzureNetworkAccessInternalFluent<?> fluent,AzureNetworkAccessInternal instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureNetworkAccessInternal build() {
    AzureNetworkAccessInternal buildable = new AzureNetworkAccessInternal(fluent.getNetworkResourceGroupName(), fluent.getPrivateEndpointName(), fluent.getSubnetName(), fluent.getVnetName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}