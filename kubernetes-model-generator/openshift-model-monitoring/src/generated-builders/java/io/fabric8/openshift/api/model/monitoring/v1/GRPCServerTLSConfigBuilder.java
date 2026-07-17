package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GRPCServerTLSConfigBuilder extends GRPCServerTLSConfigFluent<GRPCServerTLSConfigBuilder> implements VisitableBuilder<GRPCServerTLSConfig,GRPCServerTLSConfigBuilder>{

  GRPCServerTLSConfigFluent<?> fluent;

  public GRPCServerTLSConfigBuilder() {
    this(new GRPCServerTLSConfig());
  }
  
  public GRPCServerTLSConfigBuilder(GRPCServerTLSConfigFluent<?> fluent) {
    this(fluent, new GRPCServerTLSConfig());
  }
  
  public GRPCServerTLSConfigBuilder(GRPCServerTLSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GRPCServerTLSConfigBuilder(GRPCServerTLSConfigFluent<?> fluent,GRPCServerTLSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GRPCServerTLSConfig build() {
    GRPCServerTLSConfig buildable = new GRPCServerTLSConfig(fluent.buildCa(), fluent.getCaFile(), fluent.buildCert(), fluent.getCertFile(), fluent.getCipherSuites(), fluent.getCurves(), fluent.getInsecureSkipVerify(), fluent.getKeyFile(), fluent.getKeySecret(), fluent.getMaxVersion(), fluent.getMinVersion(), fluent.getServerName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}