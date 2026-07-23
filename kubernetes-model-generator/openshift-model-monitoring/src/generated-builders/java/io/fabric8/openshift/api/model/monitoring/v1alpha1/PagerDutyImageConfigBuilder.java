package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PagerDutyImageConfigBuilder extends PagerDutyImageConfigFluent<PagerDutyImageConfigBuilder> implements VisitableBuilder<PagerDutyImageConfig,PagerDutyImageConfigBuilder>{

  PagerDutyImageConfigFluent<?> fluent;

  public PagerDutyImageConfigBuilder() {
    this(new PagerDutyImageConfig());
  }
  
  public PagerDutyImageConfigBuilder(PagerDutyImageConfigFluent<?> fluent) {
    this(fluent, new PagerDutyImageConfig());
  }
  
  public PagerDutyImageConfigBuilder(PagerDutyImageConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PagerDutyImageConfigBuilder(PagerDutyImageConfigFluent<?> fluent,PagerDutyImageConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PagerDutyImageConfig build() {
    PagerDutyImageConfig buildable = new PagerDutyImageConfig(fluent.getAlt(), fluent.getHref(), fluent.getSrc());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}