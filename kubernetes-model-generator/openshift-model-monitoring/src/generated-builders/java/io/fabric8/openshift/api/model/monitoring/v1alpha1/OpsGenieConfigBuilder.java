package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpsGenieConfigBuilder extends OpsGenieConfigFluent<OpsGenieConfigBuilder> implements VisitableBuilder<OpsGenieConfig,OpsGenieConfigBuilder>{

  OpsGenieConfigFluent<?> fluent;

  public OpsGenieConfigBuilder() {
    this(new OpsGenieConfig());
  }
  
  public OpsGenieConfigBuilder(OpsGenieConfigFluent<?> fluent) {
    this(fluent, new OpsGenieConfig());
  }
  
  public OpsGenieConfigBuilder(OpsGenieConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpsGenieConfigBuilder(OpsGenieConfigFluent<?> fluent,OpsGenieConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpsGenieConfig build() {
    OpsGenieConfig buildable = new OpsGenieConfig(fluent.getActions(), fluent.getApiKey(), fluent.getApiURL(), fluent.getDescription(), fluent.buildDetails(), fluent.getEntity(), fluent.buildHttpConfig(), fluent.getMessage(), fluent.getNote(), fluent.getPriority(), fluent.buildResponders(), fluent.getSendResolved(), fluent.getSource(), fluent.getTags(), fluent.getUpdateAlerts());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}