package io.fabric8.volcano.api.model.nodeinfo.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NumatopologyListBuilder extends NumatopologyListFluent<NumatopologyListBuilder> implements VisitableBuilder<NumatopologyList,NumatopologyListBuilder>{

  NumatopologyListFluent<?> fluent;

  public NumatopologyListBuilder() {
    this(new NumatopologyList());
  }
  
  public NumatopologyListBuilder(NumatopologyListFluent<?> fluent) {
    this(fluent, new NumatopologyList());
  }
  
  public NumatopologyListBuilder(NumatopologyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NumatopologyListBuilder(NumatopologyListFluent<?> fluent,NumatopologyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NumatopologyList build() {
    NumatopologyList buildable = new NumatopologyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}