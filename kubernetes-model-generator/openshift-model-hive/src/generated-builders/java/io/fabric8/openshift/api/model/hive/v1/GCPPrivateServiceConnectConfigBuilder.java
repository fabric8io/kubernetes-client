package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPPrivateServiceConnectConfigBuilder extends GCPPrivateServiceConnectConfigFluent<GCPPrivateServiceConnectConfigBuilder> implements VisitableBuilder<GCPPrivateServiceConnectConfig,GCPPrivateServiceConnectConfigBuilder>{

  GCPPrivateServiceConnectConfigFluent<?> fluent;

  public GCPPrivateServiceConnectConfigBuilder() {
    this(new GCPPrivateServiceConnectConfig());
  }
  
  public GCPPrivateServiceConnectConfigBuilder(GCPPrivateServiceConnectConfigFluent<?> fluent) {
    this(fluent, new GCPPrivateServiceConnectConfig());
  }
  
  public GCPPrivateServiceConnectConfigBuilder(GCPPrivateServiceConnectConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPPrivateServiceConnectConfigBuilder(GCPPrivateServiceConnectConfigFluent<?> fluent,GCPPrivateServiceConnectConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPPrivateServiceConnectConfig build() {
    GCPPrivateServiceConnectConfig buildable = new GCPPrivateServiceConnectConfig(fluent.buildCredentialsSecretRef(), fluent.buildEndpointVPCInventory());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}