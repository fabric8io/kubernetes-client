package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PagerDutyLinkConfigBuilder extends PagerDutyLinkConfigFluent<PagerDutyLinkConfigBuilder> implements VisitableBuilder<PagerDutyLinkConfig,PagerDutyLinkConfigBuilder>{

  PagerDutyLinkConfigFluent<?> fluent;

  public PagerDutyLinkConfigBuilder() {
    this(new PagerDutyLinkConfig());
  }
  
  public PagerDutyLinkConfigBuilder(PagerDutyLinkConfigFluent<?> fluent) {
    this(fluent, new PagerDutyLinkConfig());
  }
  
  public PagerDutyLinkConfigBuilder(PagerDutyLinkConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PagerDutyLinkConfigBuilder(PagerDutyLinkConfigFluent<?> fluent,PagerDutyLinkConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PagerDutyLinkConfig build() {
    PagerDutyLinkConfig buildable = new PagerDutyLinkConfig(fluent.getAlt(), fluent.getHref());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}