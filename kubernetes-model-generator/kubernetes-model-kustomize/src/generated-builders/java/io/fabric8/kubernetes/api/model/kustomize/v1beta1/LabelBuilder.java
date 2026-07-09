package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LabelBuilder extends LabelFluent<LabelBuilder> implements VisitableBuilder<Label,LabelBuilder>{

  LabelFluent<?> fluent;

  public LabelBuilder() {
    this(new Label());
  }
  
  public LabelBuilder(LabelFluent<?> fluent) {
    this(fluent, new Label());
  }
  
  public LabelBuilder(Label instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LabelBuilder(LabelFluent<?> fluent,Label instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Label build() {
    Label buildable = new Label(fluent.buildFields(), fluent.getIncludeSelectors(), fluent.getIncludeTemplates(), fluent.getPairs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}