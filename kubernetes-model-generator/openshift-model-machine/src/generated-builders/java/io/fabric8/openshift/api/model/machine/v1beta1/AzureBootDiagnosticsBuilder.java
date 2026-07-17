package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureBootDiagnosticsBuilder extends AzureBootDiagnosticsFluent<AzureBootDiagnosticsBuilder> implements VisitableBuilder<AzureBootDiagnostics,AzureBootDiagnosticsBuilder>{

  AzureBootDiagnosticsFluent<?> fluent;

  public AzureBootDiagnosticsBuilder() {
    this(new AzureBootDiagnostics());
  }
  
  public AzureBootDiagnosticsBuilder(AzureBootDiagnosticsFluent<?> fluent) {
    this(fluent, new AzureBootDiagnostics());
  }
  
  public AzureBootDiagnosticsBuilder(AzureBootDiagnostics instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureBootDiagnosticsBuilder(AzureBootDiagnosticsFluent<?> fluent,AzureBootDiagnostics instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureBootDiagnostics build() {
    AzureBootDiagnostics buildable = new AzureBootDiagnostics(fluent.buildCustomerManaged(), fluent.getStorageAccountType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}