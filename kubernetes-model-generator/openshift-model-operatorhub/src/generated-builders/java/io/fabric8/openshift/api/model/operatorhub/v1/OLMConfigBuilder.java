package io.fabric8.openshift.api.model.operatorhub.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OLMConfigBuilder extends OLMConfigFluent<OLMConfigBuilder> implements VisitableBuilder<OLMConfig,OLMConfigBuilder>{

  OLMConfigFluent<?> fluent;

  public OLMConfigBuilder() {
    this(new OLMConfig());
  }
  
  public OLMConfigBuilder(OLMConfigFluent<?> fluent) {
    this(fluent, new OLMConfig());
  }
  
  public OLMConfigBuilder(OLMConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OLMConfigBuilder(OLMConfigFluent<?> fluent,OLMConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OLMConfig build() {
    OLMConfig buildable = new OLMConfig(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}