package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPAMConfigBuilder extends IPAMConfigFluent<IPAMConfigBuilder> implements VisitableBuilder<IPAMConfig,IPAMConfigBuilder>{

  IPAMConfigFluent<?> fluent;

  public IPAMConfigBuilder() {
    this(new IPAMConfig());
  }
  
  public IPAMConfigBuilder(IPAMConfigFluent<?> fluent) {
    this(fluent, new IPAMConfig());
  }
  
  public IPAMConfigBuilder(IPAMConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPAMConfigBuilder(IPAMConfigFluent<?> fluent,IPAMConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPAMConfig build() {
    IPAMConfig buildable = new IPAMConfig(fluent.buildStaticIPAMConfig(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}