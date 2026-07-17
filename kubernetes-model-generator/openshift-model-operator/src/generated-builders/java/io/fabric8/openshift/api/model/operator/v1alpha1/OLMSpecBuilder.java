package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OLMSpecBuilder extends OLMSpecFluent<OLMSpecBuilder> implements VisitableBuilder<OLMSpec,OLMSpecBuilder>{

  OLMSpecFluent<?> fluent;

  public OLMSpecBuilder() {
    this(new OLMSpec());
  }
  
  public OLMSpecBuilder(OLMSpecFluent<?> fluent) {
    this(fluent, new OLMSpec());
  }
  
  public OLMSpecBuilder(OLMSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OLMSpecBuilder(OLMSpecFluent<?> fluent,OLMSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OLMSpec build() {
    OLMSpec buildable = new OLMSpec(fluent.getLogLevel(), fluent.getManagementState(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}