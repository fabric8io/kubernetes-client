package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerTemplateSpecBuilder extends TriggerTemplateSpecFluent<TriggerTemplateSpecBuilder> implements VisitableBuilder<TriggerTemplateSpec,TriggerTemplateSpecBuilder>{

  TriggerTemplateSpecFluent<?> fluent;

  public TriggerTemplateSpecBuilder() {
    this(new TriggerTemplateSpec());
  }
  
  public TriggerTemplateSpecBuilder(TriggerTemplateSpecFluent<?> fluent) {
    this(fluent, new TriggerTemplateSpec());
  }
  
  public TriggerTemplateSpecBuilder(TriggerTemplateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerTemplateSpecBuilder(TriggerTemplateSpecFluent<?> fluent,TriggerTemplateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerTemplateSpec build() {
    TriggerTemplateSpec buildable = new TriggerTemplateSpec(fluent.buildParams(), fluent.buildResourcetemplates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}