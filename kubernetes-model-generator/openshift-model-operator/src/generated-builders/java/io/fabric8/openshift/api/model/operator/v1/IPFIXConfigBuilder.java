package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPFIXConfigBuilder extends IPFIXConfigFluent<IPFIXConfigBuilder> implements VisitableBuilder<IPFIXConfig,IPFIXConfigBuilder>{

  IPFIXConfigFluent<?> fluent;

  public IPFIXConfigBuilder() {
    this(new IPFIXConfig());
  }
  
  public IPFIXConfigBuilder(IPFIXConfigFluent<?> fluent) {
    this(fluent, new IPFIXConfig());
  }
  
  public IPFIXConfigBuilder(IPFIXConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPFIXConfigBuilder(IPFIXConfigFluent<?> fluent,IPFIXConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPFIXConfig build() {
    IPFIXConfig buildable = new IPFIXConfig(fluent.getCollectors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}