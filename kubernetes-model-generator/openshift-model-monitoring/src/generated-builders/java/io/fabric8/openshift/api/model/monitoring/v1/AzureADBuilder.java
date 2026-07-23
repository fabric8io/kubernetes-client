package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureADBuilder extends AzureADFluent<AzureADBuilder> implements VisitableBuilder<AzureAD,AzureADBuilder>{

  AzureADFluent<?> fluent;

  public AzureADBuilder() {
    this(new AzureAD());
  }
  
  public AzureADBuilder(AzureADFluent<?> fluent) {
    this(fluent, new AzureAD());
  }
  
  public AzureADBuilder(AzureAD instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureADBuilder(AzureADFluent<?> fluent,AzureAD instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureAD build() {
    AzureAD buildable = new AzureAD(fluent.getCloud(), fluent.buildManagedIdentity(), fluent.buildOauth(), fluent.getScope(), fluent.buildSdk(), fluent.buildWorkloadIdentity());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}