package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ArbitraryFSAccessThroughSMsConfigBuilder extends ArbitraryFSAccessThroughSMsConfigFluent<ArbitraryFSAccessThroughSMsConfigBuilder> implements VisitableBuilder<ArbitraryFSAccessThroughSMsConfig,ArbitraryFSAccessThroughSMsConfigBuilder>{

  ArbitraryFSAccessThroughSMsConfigFluent<?> fluent;

  public ArbitraryFSAccessThroughSMsConfigBuilder() {
    this(new ArbitraryFSAccessThroughSMsConfig());
  }
  
  public ArbitraryFSAccessThroughSMsConfigBuilder(ArbitraryFSAccessThroughSMsConfigFluent<?> fluent) {
    this(fluent, new ArbitraryFSAccessThroughSMsConfig());
  }
  
  public ArbitraryFSAccessThroughSMsConfigBuilder(ArbitraryFSAccessThroughSMsConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ArbitraryFSAccessThroughSMsConfigBuilder(ArbitraryFSAccessThroughSMsConfigFluent<?> fluent,ArbitraryFSAccessThroughSMsConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ArbitraryFSAccessThroughSMsConfig build() {
    ArbitraryFSAccessThroughSMsConfig buildable = new ArbitraryFSAccessThroughSMsConfig(fluent.getDeny());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}