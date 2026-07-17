package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureDNSZoneSpecBuilder extends AzureDNSZoneSpecFluent<AzureDNSZoneSpecBuilder> implements VisitableBuilder<AzureDNSZoneSpec,AzureDNSZoneSpecBuilder>{

  AzureDNSZoneSpecFluent<?> fluent;

  public AzureDNSZoneSpecBuilder() {
    this(new AzureDNSZoneSpec());
  }
  
  public AzureDNSZoneSpecBuilder(AzureDNSZoneSpecFluent<?> fluent) {
    this(fluent, new AzureDNSZoneSpec());
  }
  
  public AzureDNSZoneSpecBuilder(AzureDNSZoneSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureDNSZoneSpecBuilder(AzureDNSZoneSpecFluent<?> fluent,AzureDNSZoneSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureDNSZoneSpec build() {
    AzureDNSZoneSpec buildable = new AzureDNSZoneSpec(fluent.getCloudName(), fluent.buildCredentialsSecretRef(), fluent.getResourceGroupName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}