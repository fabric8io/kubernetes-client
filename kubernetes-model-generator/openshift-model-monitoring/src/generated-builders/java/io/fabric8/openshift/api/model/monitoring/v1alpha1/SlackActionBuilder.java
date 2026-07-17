package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SlackActionBuilder extends SlackActionFluent<SlackActionBuilder> implements VisitableBuilder<SlackAction,SlackActionBuilder>{

  SlackActionFluent<?> fluent;

  public SlackActionBuilder() {
    this(new SlackAction());
  }
  
  public SlackActionBuilder(SlackActionFluent<?> fluent) {
    this(fluent, new SlackAction());
  }
  
  public SlackActionBuilder(SlackAction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SlackActionBuilder(SlackActionFluent<?> fluent,SlackAction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SlackAction build() {
    SlackAction buildable = new SlackAction(fluent.buildConfirm(), fluent.getName(), fluent.getStyle(), fluent.getText(), fluent.getType(), fluent.getUrl(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}