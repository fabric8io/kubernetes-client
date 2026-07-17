package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IPsecConfigBuilder extends IPsecConfigFluent<IPsecConfigBuilder> implements VisitableBuilder<IPsecConfig,IPsecConfigBuilder>{

  IPsecConfigFluent<?> fluent;

  public IPsecConfigBuilder() {
    this(new IPsecConfig());
  }
  
  public IPsecConfigBuilder(IPsecConfigFluent<?> fluent) {
    this(fluent, new IPsecConfig());
  }
  
  public IPsecConfigBuilder(IPsecConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IPsecConfigBuilder(IPsecConfigFluent<?> fluent,IPsecConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IPsecConfig build() {
    IPsecConfig buildable = new IPsecConfig(fluent.buildFull(), fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}