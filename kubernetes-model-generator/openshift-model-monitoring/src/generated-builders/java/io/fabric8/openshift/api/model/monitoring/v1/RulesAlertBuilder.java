package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RulesAlertBuilder extends RulesAlertFluent<RulesAlertBuilder> implements VisitableBuilder<RulesAlert,RulesAlertBuilder>{

  RulesAlertFluent<?> fluent;

  public RulesAlertBuilder() {
    this(new RulesAlert());
  }
  
  public RulesAlertBuilder(RulesAlertFluent<?> fluent) {
    this(fluent, new RulesAlert());
  }
  
  public RulesAlertBuilder(RulesAlert instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RulesAlertBuilder(RulesAlertFluent<?> fluent,RulesAlert instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RulesAlert build() {
    RulesAlert buildable = new RulesAlert(fluent.getForGracePeriod(), fluent.getForOutageTolerance(), fluent.getResendDelay());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}