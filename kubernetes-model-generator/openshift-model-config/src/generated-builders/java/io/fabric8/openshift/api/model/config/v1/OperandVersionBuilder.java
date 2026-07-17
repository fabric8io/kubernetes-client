package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperandVersionBuilder extends OperandVersionFluent<OperandVersionBuilder> implements VisitableBuilder<OperandVersion,OperandVersionBuilder>{

  OperandVersionFluent<?> fluent;

  public OperandVersionBuilder() {
    this(new OperandVersion());
  }
  
  public OperandVersionBuilder(OperandVersionFluent<?> fluent) {
    this(fluent, new OperandVersion());
  }
  
  public OperandVersionBuilder(OperandVersion instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperandVersionBuilder(OperandVersionFluent<?> fluent,OperandVersion instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperandVersion build() {
    OperandVersion buildable = new OperandVersion(fluent.getName(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}