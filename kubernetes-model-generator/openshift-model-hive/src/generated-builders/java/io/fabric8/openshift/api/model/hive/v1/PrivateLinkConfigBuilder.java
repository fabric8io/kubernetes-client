package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrivateLinkConfigBuilder extends PrivateLinkConfigFluent<PrivateLinkConfigBuilder> implements VisitableBuilder<PrivateLinkConfig,PrivateLinkConfigBuilder>{

  PrivateLinkConfigFluent<?> fluent;

  public PrivateLinkConfigBuilder() {
    this(new PrivateLinkConfig());
  }
  
  public PrivateLinkConfigBuilder(PrivateLinkConfigFluent<?> fluent) {
    this(fluent, new PrivateLinkConfig());
  }
  
  public PrivateLinkConfigBuilder(PrivateLinkConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrivateLinkConfigBuilder(PrivateLinkConfigFluent<?> fluent,PrivateLinkConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrivateLinkConfig build() {
    PrivateLinkConfig buildable = new PrivateLinkConfig(fluent.buildGcp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}