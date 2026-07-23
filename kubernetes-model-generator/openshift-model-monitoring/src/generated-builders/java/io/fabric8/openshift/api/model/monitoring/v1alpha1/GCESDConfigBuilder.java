package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCESDConfigBuilder extends GCESDConfigFluent<GCESDConfigBuilder> implements VisitableBuilder<GCESDConfig,GCESDConfigBuilder>{

  GCESDConfigFluent<?> fluent;

  public GCESDConfigBuilder() {
    this(new GCESDConfig());
  }
  
  public GCESDConfigBuilder(GCESDConfigFluent<?> fluent) {
    this(fluent, new GCESDConfig());
  }
  
  public GCESDConfigBuilder(GCESDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCESDConfigBuilder(GCESDConfigFluent<?> fluent,GCESDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCESDConfig build() {
    GCESDConfig buildable = new GCESDConfig(fluent.getFilter(), fluent.getPort(), fluent.getProject(), fluent.getRefreshInterval(), fluent.getTagSeparator(), fluent.getZone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}