package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureDiagnosticsBuilder extends AzureDiagnosticsFluent<AzureDiagnosticsBuilder> implements VisitableBuilder<AzureDiagnostics,AzureDiagnosticsBuilder>{

  AzureDiagnosticsFluent<?> fluent;

  public AzureDiagnosticsBuilder() {
    this(new AzureDiagnostics());
  }
  
  public AzureDiagnosticsBuilder(AzureDiagnosticsFluent<?> fluent) {
    this(fluent, new AzureDiagnostics());
  }
  
  public AzureDiagnosticsBuilder(AzureDiagnostics instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureDiagnosticsBuilder(AzureDiagnosticsFluent<?> fluent,AzureDiagnostics instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureDiagnostics build() {
    AzureDiagnostics buildable = new AzureDiagnostics(fluent.buildBoot());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}