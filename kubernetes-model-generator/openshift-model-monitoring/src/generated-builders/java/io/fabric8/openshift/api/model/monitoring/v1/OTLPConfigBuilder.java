package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OTLPConfigBuilder extends OTLPConfigFluent<OTLPConfigBuilder> implements VisitableBuilder<OTLPConfig,OTLPConfigBuilder>{

  OTLPConfigFluent<?> fluent;

  public OTLPConfigBuilder() {
    this(new OTLPConfig());
  }
  
  public OTLPConfigBuilder(OTLPConfigFluent<?> fluent) {
    this(fluent, new OTLPConfig());
  }
  
  public OTLPConfigBuilder(OTLPConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OTLPConfigBuilder(OTLPConfigFluent<?> fluent,OTLPConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OTLPConfig build() {
    OTLPConfig buildable = new OTLPConfig(fluent.getConvertHistogramsToNHCB(), fluent.getIgnoreResourceAttributes(), fluent.getKeepIdentifyingResourceAttributes(), fluent.getPromoteAllResourceAttributes(), fluent.getPromoteResourceAttributes(), fluent.getPromoteScopeMetadata(), fluent.getTranslationStrategy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}