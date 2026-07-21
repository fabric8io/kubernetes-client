package io.fabric8.knative.flows.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SequenceListBuilder extends SequenceListFluent<SequenceListBuilder> implements VisitableBuilder<SequenceList,SequenceListBuilder>{

  SequenceListFluent<?> fluent;

  public SequenceListBuilder() {
    this(new SequenceList());
  }
  
  public SequenceListBuilder(SequenceListFluent<?> fluent) {
    this(fluent, new SequenceList());
  }
  
  public SequenceListBuilder(SequenceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SequenceListBuilder(SequenceListFluent<?> fluent,SequenceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SequenceList build() {
    SequenceList buildable = new SequenceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}