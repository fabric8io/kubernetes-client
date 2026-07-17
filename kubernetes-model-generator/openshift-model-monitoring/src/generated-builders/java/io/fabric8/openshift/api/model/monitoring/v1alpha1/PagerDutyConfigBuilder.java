package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PagerDutyConfigBuilder extends PagerDutyConfigFluent<PagerDutyConfigBuilder> implements VisitableBuilder<PagerDutyConfig,PagerDutyConfigBuilder>{

  PagerDutyConfigFluent<?> fluent;

  public PagerDutyConfigBuilder() {
    this(new PagerDutyConfig());
  }
  
  public PagerDutyConfigBuilder(PagerDutyConfigFluent<?> fluent) {
    this(fluent, new PagerDutyConfig());
  }
  
  public PagerDutyConfigBuilder(PagerDutyConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PagerDutyConfigBuilder(PagerDutyConfigFluent<?> fluent,PagerDutyConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PagerDutyConfig build() {
    PagerDutyConfig buildable = new PagerDutyConfig(fluent.getClassName(), fluent.getClient(), fluent.getClientURL(), fluent.getComponent(), fluent.getDescription(), fluent.buildDetails(), fluent.getGroup(), fluent.buildHttpConfig(), fluent.buildPagerDutyImageConfigs(), fluent.buildPagerDutyLinkConfigs(), fluent.getRoutingKey(), fluent.getSendResolved(), fluent.getServiceKey(), fluent.getSeverity(), fluent.getSource(), fluent.getTimeout(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}