package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenShiftSDNConfigBuilder extends OpenShiftSDNConfigFluent<OpenShiftSDNConfigBuilder> implements VisitableBuilder<OpenShiftSDNConfig,OpenShiftSDNConfigBuilder>{

  OpenShiftSDNConfigFluent<?> fluent;

  public OpenShiftSDNConfigBuilder() {
    this(new OpenShiftSDNConfig());
  }
  
  public OpenShiftSDNConfigBuilder(OpenShiftSDNConfigFluent<?> fluent) {
    this(fluent, new OpenShiftSDNConfig());
  }
  
  public OpenShiftSDNConfigBuilder(OpenShiftSDNConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenShiftSDNConfigBuilder(OpenShiftSDNConfigFluent<?> fluent,OpenShiftSDNConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenShiftSDNConfig build() {
    OpenShiftSDNConfig buildable = new OpenShiftSDNConfig(fluent.getEnableUnidling(), fluent.getMode(), fluent.getMtu(), fluent.getUseExternalOpenvswitch(), fluent.getVxlanPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}