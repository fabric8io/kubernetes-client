package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StaticIPAMConfigBuilder extends StaticIPAMConfigFluent<StaticIPAMConfigBuilder> implements VisitableBuilder<StaticIPAMConfig,StaticIPAMConfigBuilder>{

  StaticIPAMConfigFluent<?> fluent;

  public StaticIPAMConfigBuilder() {
    this(new StaticIPAMConfig());
  }
  
  public StaticIPAMConfigBuilder(StaticIPAMConfigFluent<?> fluent) {
    this(fluent, new StaticIPAMConfig());
  }
  
  public StaticIPAMConfigBuilder(StaticIPAMConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StaticIPAMConfigBuilder(StaticIPAMConfigFluent<?> fluent,StaticIPAMConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StaticIPAMConfig build() {
    StaticIPAMConfig buildable = new StaticIPAMConfig(fluent.buildAddresses(), fluent.buildDns(), fluent.buildRoutes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}