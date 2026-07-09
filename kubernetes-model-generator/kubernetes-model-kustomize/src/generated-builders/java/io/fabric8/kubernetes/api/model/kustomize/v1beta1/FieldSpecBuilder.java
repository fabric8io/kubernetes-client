package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FieldSpecBuilder extends FieldSpecFluent<FieldSpecBuilder> implements VisitableBuilder<FieldSpec,FieldSpecBuilder>{

  FieldSpecFluent<?> fluent;

  public FieldSpecBuilder() {
    this(new FieldSpec());
  }
  
  public FieldSpecBuilder(FieldSpecFluent<?> fluent) {
    this(fluent, new FieldSpec());
  }
  
  public FieldSpecBuilder(FieldSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FieldSpecBuilder(FieldSpecFluent<?> fluent,FieldSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FieldSpec build() {
    FieldSpec buildable = new FieldSpec(fluent.getCreate(), fluent.getGroup(), fluent.getKind(), fluent.getPath(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}