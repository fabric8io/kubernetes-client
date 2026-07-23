package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IrreconcilableValidationOverridesBuilder extends IrreconcilableValidationOverridesFluent<IrreconcilableValidationOverridesBuilder> implements VisitableBuilder<IrreconcilableValidationOverrides,IrreconcilableValidationOverridesBuilder>{

  IrreconcilableValidationOverridesFluent<?> fluent;

  public IrreconcilableValidationOverridesBuilder() {
    this(new IrreconcilableValidationOverrides());
  }
  
  public IrreconcilableValidationOverridesBuilder(IrreconcilableValidationOverridesFluent<?> fluent) {
    this(fluent, new IrreconcilableValidationOverrides());
  }
  
  public IrreconcilableValidationOverridesBuilder(IrreconcilableValidationOverrides instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IrreconcilableValidationOverridesBuilder(IrreconcilableValidationOverridesFluent<?> fluent,IrreconcilableValidationOverrides instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IrreconcilableValidationOverrides build() {
    IrreconcilableValidationOverrides buildable = new IrreconcilableValidationOverrides(fluent.getStorage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}