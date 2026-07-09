package io.fabric8.kubernetes.api.model.authorization.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LabelSelectorAttributesBuilder extends LabelSelectorAttributesFluent<LabelSelectorAttributesBuilder> implements VisitableBuilder<LabelSelectorAttributes,LabelSelectorAttributesBuilder>{

  LabelSelectorAttributesFluent<?> fluent;

  public LabelSelectorAttributesBuilder() {
    this(new LabelSelectorAttributes());
  }
  
  public LabelSelectorAttributesBuilder(LabelSelectorAttributesFluent<?> fluent) {
    this(fluent, new LabelSelectorAttributes());
  }
  
  public LabelSelectorAttributesBuilder(LabelSelectorAttributes instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LabelSelectorAttributesBuilder(LabelSelectorAttributesFluent<?> fluent,LabelSelectorAttributes instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LabelSelectorAttributes build() {
    LabelSelectorAttributes buildable = new LabelSelectorAttributes(fluent.getRawSelector(), fluent.getRequirements());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}