package io.fabric8.knative.flows.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SequenceBuilder extends SequenceFluent<SequenceBuilder> implements VisitableBuilder<Sequence,SequenceBuilder>{

  SequenceFluent<?> fluent;

  public SequenceBuilder() {
    this(new Sequence());
  }
  
  public SequenceBuilder(SequenceFluent<?> fluent) {
    this(fluent, new Sequence());
  }
  
  public SequenceBuilder(Sequence instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SequenceBuilder(SequenceFluent<?> fluent,Sequence instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Sequence build() {
    Sequence buildable = new Sequence(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}