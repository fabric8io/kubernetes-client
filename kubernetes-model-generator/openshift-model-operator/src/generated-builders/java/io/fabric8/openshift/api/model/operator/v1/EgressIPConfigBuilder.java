package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressIPConfigBuilder extends EgressIPConfigFluent<EgressIPConfigBuilder> implements VisitableBuilder<EgressIPConfig,EgressIPConfigBuilder>{

  EgressIPConfigFluent<?> fluent;

  public EgressIPConfigBuilder() {
    this(new EgressIPConfig());
  }
  
  public EgressIPConfigBuilder(EgressIPConfigFluent<?> fluent) {
    this(fluent, new EgressIPConfig());
  }
  
  public EgressIPConfigBuilder(EgressIPConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressIPConfigBuilder(EgressIPConfigFluent<?> fluent,EgressIPConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressIPConfig build() {
    EgressIPConfig buildable = new EgressIPConfig(fluent.getReachabilityTotalTimeoutSeconds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}