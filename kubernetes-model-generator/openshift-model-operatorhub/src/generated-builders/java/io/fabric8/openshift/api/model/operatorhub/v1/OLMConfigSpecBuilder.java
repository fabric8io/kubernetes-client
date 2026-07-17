package io.fabric8.openshift.api.model.operatorhub.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OLMConfigSpecBuilder extends OLMConfigSpecFluent<OLMConfigSpecBuilder> implements VisitableBuilder<OLMConfigSpec,OLMConfigSpecBuilder>{

  OLMConfigSpecFluent<?> fluent;

  public OLMConfigSpecBuilder() {
    this(new OLMConfigSpec());
  }
  
  public OLMConfigSpecBuilder(OLMConfigSpecFluent<?> fluent) {
    this(fluent, new OLMConfigSpec());
  }
  
  public OLMConfigSpecBuilder(OLMConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OLMConfigSpecBuilder(OLMConfigSpecFluent<?> fluent,OLMConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OLMConfigSpec build() {
    OLMConfigSpec buildable = new OLMConfigSpec(fluent.buildFeatures());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}