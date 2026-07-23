package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureSDKBuilder extends AzureSDKFluent<AzureSDKBuilder> implements VisitableBuilder<AzureSDK,AzureSDKBuilder>{

  AzureSDKFluent<?> fluent;

  public AzureSDKBuilder() {
    this(new AzureSDK());
  }
  
  public AzureSDKBuilder(AzureSDKFluent<?> fluent) {
    this(fluent, new AzureSDK());
  }
  
  public AzureSDKBuilder(AzureSDK instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureSDKBuilder(AzureSDKFluent<?> fluent,AzureSDK instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureSDK build() {
    AzureSDK buildable = new AzureSDK(fluent.getTenantId());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}