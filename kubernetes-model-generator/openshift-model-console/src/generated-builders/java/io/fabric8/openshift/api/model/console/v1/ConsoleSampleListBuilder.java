package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleSampleListBuilder extends ConsoleSampleListFluent<ConsoleSampleListBuilder> implements VisitableBuilder<ConsoleSampleList,ConsoleSampleListBuilder>{

  ConsoleSampleListFluent<?> fluent;

  public ConsoleSampleListBuilder() {
    this(new ConsoleSampleList());
  }
  
  public ConsoleSampleListBuilder(ConsoleSampleListFluent<?> fluent) {
    this(fluent, new ConsoleSampleList());
  }
  
  public ConsoleSampleListBuilder(ConsoleSampleList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleSampleListBuilder(ConsoleSampleListFluent<?> fluent,ConsoleSampleList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleSampleList build() {
    ConsoleSampleList buildable = new ConsoleSampleList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}