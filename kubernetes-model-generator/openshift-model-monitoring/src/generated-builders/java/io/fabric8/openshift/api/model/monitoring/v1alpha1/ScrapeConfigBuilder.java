package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScrapeConfigBuilder extends ScrapeConfigFluent<ScrapeConfigBuilder> implements VisitableBuilder<ScrapeConfig,ScrapeConfigBuilder>{

  ScrapeConfigFluent<?> fluent;

  public ScrapeConfigBuilder() {
    this(new ScrapeConfig());
  }
  
  public ScrapeConfigBuilder(ScrapeConfigFluent<?> fluent) {
    this(fluent, new ScrapeConfig());
  }
  
  public ScrapeConfigBuilder(ScrapeConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScrapeConfigBuilder(ScrapeConfigFluent<?> fluent,ScrapeConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScrapeConfig build() {
    ScrapeConfig buildable = new ScrapeConfig(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}