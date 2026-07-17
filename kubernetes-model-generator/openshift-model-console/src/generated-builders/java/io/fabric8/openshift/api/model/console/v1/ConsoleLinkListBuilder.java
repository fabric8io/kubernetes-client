package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleLinkListBuilder extends ConsoleLinkListFluent<ConsoleLinkListBuilder> implements VisitableBuilder<ConsoleLinkList,ConsoleLinkListBuilder>{

  ConsoleLinkListFluent<?> fluent;

  public ConsoleLinkListBuilder() {
    this(new ConsoleLinkList());
  }
  
  public ConsoleLinkListBuilder(ConsoleLinkListFluent<?> fluent) {
    this(fluent, new ConsoleLinkList());
  }
  
  public ConsoleLinkListBuilder(ConsoleLinkList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleLinkListBuilder(ConsoleLinkListFluent<?> fluent,ConsoleLinkList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleLinkList build() {
    ConsoleLinkList buildable = new ConsoleLinkList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}