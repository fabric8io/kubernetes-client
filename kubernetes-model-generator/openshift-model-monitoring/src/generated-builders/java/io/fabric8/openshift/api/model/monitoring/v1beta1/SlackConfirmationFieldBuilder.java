package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SlackConfirmationFieldBuilder extends SlackConfirmationFieldFluent<SlackConfirmationFieldBuilder> implements VisitableBuilder<SlackConfirmationField,SlackConfirmationFieldBuilder>{

  SlackConfirmationFieldFluent<?> fluent;

  public SlackConfirmationFieldBuilder() {
    this(new SlackConfirmationField());
  }
  
  public SlackConfirmationFieldBuilder(SlackConfirmationFieldFluent<?> fluent) {
    this(fluent, new SlackConfirmationField());
  }
  
  public SlackConfirmationFieldBuilder(SlackConfirmationField instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SlackConfirmationFieldBuilder(SlackConfirmationFieldFluent<?> fluent,SlackConfirmationField instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SlackConfirmationField build() {
    SlackConfirmationField buildable = new SlackConfirmationField(fluent.getDismissText(), fluent.getOkText(), fluent.getText(), fluent.getTitle());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}