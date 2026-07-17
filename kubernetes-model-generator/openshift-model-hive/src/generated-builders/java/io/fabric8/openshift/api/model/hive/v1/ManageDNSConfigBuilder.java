package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManageDNSConfigBuilder extends ManageDNSConfigFluent<ManageDNSConfigBuilder> implements VisitableBuilder<ManageDNSConfig,ManageDNSConfigBuilder>{

  ManageDNSConfigFluent<?> fluent;

  public ManageDNSConfigBuilder() {
    this(new ManageDNSConfig());
  }
  
  public ManageDNSConfigBuilder(ManageDNSConfigFluent<?> fluent) {
    this(fluent, new ManageDNSConfig());
  }
  
  public ManageDNSConfigBuilder(ManageDNSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManageDNSConfigBuilder(ManageDNSConfigFluent<?> fluent,ManageDNSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManageDNSConfig build() {
    ManageDNSConfig buildable = new ManageDNSConfig(fluent.buildAws(), fluent.buildAzure(), fluent.getDomains(), fluent.buildGcp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}