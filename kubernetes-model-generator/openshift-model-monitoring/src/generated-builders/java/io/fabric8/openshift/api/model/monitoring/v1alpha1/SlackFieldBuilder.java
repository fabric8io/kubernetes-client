package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SlackFieldBuilder extends SlackFieldFluent<SlackFieldBuilder> implements VisitableBuilder<SlackField,SlackFieldBuilder>{

  SlackFieldFluent<?> fluent;

  public SlackFieldBuilder() {
    this(new SlackField());
  }
  
  public SlackFieldBuilder(SlackFieldFluent<?> fluent) {
    this(fluent, new SlackField());
  }
  
  public SlackFieldBuilder(SlackField instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SlackFieldBuilder(SlackFieldFluent<?> fluent,SlackField instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SlackField build() {
    SlackField buildable = new SlackField(fluent.getShort(), fluent.getTitle(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}