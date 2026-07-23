package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GenericAPIServerConfigBuilder extends GenericAPIServerConfigFluent<GenericAPIServerConfigBuilder> implements VisitableBuilder<GenericAPIServerConfig,GenericAPIServerConfigBuilder>{

  GenericAPIServerConfigFluent<?> fluent;

  public GenericAPIServerConfigBuilder() {
    this(new GenericAPIServerConfig());
  }
  
  public GenericAPIServerConfigBuilder(GenericAPIServerConfigFluent<?> fluent) {
    this(fluent, new GenericAPIServerConfig());
  }
  
  public GenericAPIServerConfigBuilder(GenericAPIServerConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GenericAPIServerConfigBuilder(GenericAPIServerConfigFluent<?> fluent,GenericAPIServerConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GenericAPIServerConfig build() {
    GenericAPIServerConfig buildable = new GenericAPIServerConfig(fluent.buildAdmission(), fluent.buildAuditConfig(), fluent.getCorsAllowedOrigins(), fluent.buildKubeClientConfig(), fluent.buildServingInfo(), fluent.buildStorageConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}