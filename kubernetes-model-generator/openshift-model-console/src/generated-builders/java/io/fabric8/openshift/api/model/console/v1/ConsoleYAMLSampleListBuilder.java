package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleYAMLSampleListBuilder extends ConsoleYAMLSampleListFluent<ConsoleYAMLSampleListBuilder> implements VisitableBuilder<ConsoleYAMLSampleList,ConsoleYAMLSampleListBuilder>{

  ConsoleYAMLSampleListFluent<?> fluent;

  public ConsoleYAMLSampleListBuilder() {
    this(new ConsoleYAMLSampleList());
  }
  
  public ConsoleYAMLSampleListBuilder(ConsoleYAMLSampleListFluent<?> fluent) {
    this(fluent, new ConsoleYAMLSampleList());
  }
  
  public ConsoleYAMLSampleListBuilder(ConsoleYAMLSampleList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleYAMLSampleListBuilder(ConsoleYAMLSampleListFluent<?> fluent,ConsoleYAMLSampleList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleYAMLSampleList build() {
    ConsoleYAMLSampleList buildable = new ConsoleYAMLSampleList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}