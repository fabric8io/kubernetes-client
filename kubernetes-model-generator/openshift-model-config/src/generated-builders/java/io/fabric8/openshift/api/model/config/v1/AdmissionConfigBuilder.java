package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdmissionConfigBuilder extends AdmissionConfigFluent<AdmissionConfigBuilder> implements VisitableBuilder<AdmissionConfig,AdmissionConfigBuilder>{

  AdmissionConfigFluent<?> fluent;

  public AdmissionConfigBuilder() {
    this(new AdmissionConfig());
  }
  
  public AdmissionConfigBuilder(AdmissionConfigFluent<?> fluent) {
    this(fluent, new AdmissionConfig());
  }
  
  public AdmissionConfigBuilder(AdmissionConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdmissionConfigBuilder(AdmissionConfigFluent<?> fluent,AdmissionConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdmissionConfig build() {
    AdmissionConfig buildable = new AdmissionConfig(fluent.getDisabledPlugins(), fluent.getEnabledPlugins(), fluent.getPluginConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}