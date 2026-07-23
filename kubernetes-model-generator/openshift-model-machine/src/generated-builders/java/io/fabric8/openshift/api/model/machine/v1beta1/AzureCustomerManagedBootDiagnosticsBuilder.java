package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureCustomerManagedBootDiagnosticsBuilder extends AzureCustomerManagedBootDiagnosticsFluent<AzureCustomerManagedBootDiagnosticsBuilder> implements VisitableBuilder<AzureCustomerManagedBootDiagnostics,AzureCustomerManagedBootDiagnosticsBuilder>{

  AzureCustomerManagedBootDiagnosticsFluent<?> fluent;

  public AzureCustomerManagedBootDiagnosticsBuilder() {
    this(new AzureCustomerManagedBootDiagnostics());
  }
  
  public AzureCustomerManagedBootDiagnosticsBuilder(AzureCustomerManagedBootDiagnosticsFluent<?> fluent) {
    this(fluent, new AzureCustomerManagedBootDiagnostics());
  }
  
  public AzureCustomerManagedBootDiagnosticsBuilder(AzureCustomerManagedBootDiagnostics instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureCustomerManagedBootDiagnosticsBuilder(AzureCustomerManagedBootDiagnosticsFluent<?> fluent,AzureCustomerManagedBootDiagnostics instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureCustomerManagedBootDiagnostics build() {
    AzureCustomerManagedBootDiagnostics buildable = new AzureCustomerManagedBootDiagnostics(fluent.getStorageAccountURI());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}