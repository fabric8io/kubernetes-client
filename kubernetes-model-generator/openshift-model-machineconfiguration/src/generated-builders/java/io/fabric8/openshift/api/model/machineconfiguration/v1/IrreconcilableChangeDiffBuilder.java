package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IrreconcilableChangeDiffBuilder extends IrreconcilableChangeDiffFluent<IrreconcilableChangeDiffBuilder> implements VisitableBuilder<IrreconcilableChangeDiff,IrreconcilableChangeDiffBuilder>{

  IrreconcilableChangeDiffFluent<?> fluent;

  public IrreconcilableChangeDiffBuilder() {
    this(new IrreconcilableChangeDiff());
  }
  
  public IrreconcilableChangeDiffBuilder(IrreconcilableChangeDiffFluent<?> fluent) {
    this(fluent, new IrreconcilableChangeDiff());
  }
  
  public IrreconcilableChangeDiffBuilder(IrreconcilableChangeDiff instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IrreconcilableChangeDiffBuilder(IrreconcilableChangeDiffFluent<?> fluent,IrreconcilableChangeDiff instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IrreconcilableChangeDiff build() {
    IrreconcilableChangeDiff buildable = new IrreconcilableChangeDiff(fluent.getDiff(), fluent.getFieldPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}