package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerTemplateListBuilder extends TriggerTemplateListFluent<TriggerTemplateListBuilder> implements VisitableBuilder<TriggerTemplateList,TriggerTemplateListBuilder>{

  TriggerTemplateListFluent<?> fluent;

  public TriggerTemplateListBuilder() {
    this(new TriggerTemplateList());
  }
  
  public TriggerTemplateListBuilder(TriggerTemplateListFluent<?> fluent) {
    this(fluent, new TriggerTemplateList());
  }
  
  public TriggerTemplateListBuilder(TriggerTemplateList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerTemplateListBuilder(TriggerTemplateListFluent<?> fluent,TriggerTemplateList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerTemplateList build() {
    TriggerTemplateList buildable = new TriggerTemplateList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}