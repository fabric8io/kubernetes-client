package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerTemplateStatusBuilder extends TriggerTemplateStatusFluent<TriggerTemplateStatusBuilder> implements VisitableBuilder<TriggerTemplateStatus,TriggerTemplateStatusBuilder>{

  TriggerTemplateStatusFluent<?> fluent;

  public TriggerTemplateStatusBuilder() {
    this(new TriggerTemplateStatus());
  }
  
  public TriggerTemplateStatusBuilder(TriggerTemplateStatusFluent<?> fluent) {
    this(fluent, new TriggerTemplateStatus());
  }
  
  public TriggerTemplateStatusBuilder(TriggerTemplateStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerTemplateStatusBuilder(TriggerTemplateStatusFluent<?> fluent,TriggerTemplateStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerTemplateStatus build() {
    TriggerTemplateStatus buildable = new TriggerTemplateStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}