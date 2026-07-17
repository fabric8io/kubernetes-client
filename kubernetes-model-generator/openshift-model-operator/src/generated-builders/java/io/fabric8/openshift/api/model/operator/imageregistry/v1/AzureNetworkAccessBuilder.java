package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureNetworkAccessBuilder extends AzureNetworkAccessFluent<AzureNetworkAccessBuilder> implements VisitableBuilder<AzureNetworkAccess,AzureNetworkAccessBuilder>{

  AzureNetworkAccessFluent<?> fluent;

  public AzureNetworkAccessBuilder() {
    this(new AzureNetworkAccess());
  }
  
  public AzureNetworkAccessBuilder(AzureNetworkAccessFluent<?> fluent) {
    this(fluent, new AzureNetworkAccess());
  }
  
  public AzureNetworkAccessBuilder(AzureNetworkAccess instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureNetworkAccessBuilder(AzureNetworkAccessFluent<?> fluent,AzureNetworkAccess instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureNetworkAccess build() {
    AzureNetworkAccess buildable = new AzureNetworkAccess(fluent.buildInternal(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}