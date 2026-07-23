package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdmissionPluginConfigBuilder extends AdmissionPluginConfigFluent<AdmissionPluginConfigBuilder> implements VisitableBuilder<AdmissionPluginConfig,AdmissionPluginConfigBuilder>{

  AdmissionPluginConfigFluent<?> fluent;

  public AdmissionPluginConfigBuilder() {
    this(new AdmissionPluginConfig());
  }
  
  public AdmissionPluginConfigBuilder(AdmissionPluginConfigFluent<?> fluent) {
    this(fluent, new AdmissionPluginConfig());
  }
  
  public AdmissionPluginConfigBuilder(AdmissionPluginConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdmissionPluginConfigBuilder(AdmissionPluginConfigFluent<?> fluent,AdmissionPluginConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdmissionPluginConfig build() {
    AdmissionPluginConfig buildable = new AdmissionPluginConfig(fluent.getConfiguration(), fluent.getLocation());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}