package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixPlatformSpecBuilder extends NutanixPlatformSpecFluent<NutanixPlatformSpecBuilder> implements VisitableBuilder<NutanixPlatformSpec,NutanixPlatformSpecBuilder>{

  NutanixPlatformSpecFluent<?> fluent;

  public NutanixPlatformSpecBuilder() {
    this(new NutanixPlatformSpec());
  }
  
  public NutanixPlatformSpecBuilder(NutanixPlatformSpecFluent<?> fluent) {
    this(fluent, new NutanixPlatformSpec());
  }
  
  public NutanixPlatformSpecBuilder(NutanixPlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixPlatformSpecBuilder(NutanixPlatformSpecFluent<?> fluent,NutanixPlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixPlatformSpec build() {
    NutanixPlatformSpec buildable = new NutanixPlatformSpec(fluent.buildFailureDomains(), fluent.buildPrismCentral(), fluent.buildPrismElements());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}