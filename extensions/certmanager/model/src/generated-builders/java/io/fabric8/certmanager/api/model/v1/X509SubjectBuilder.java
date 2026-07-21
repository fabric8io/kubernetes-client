package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class X509SubjectBuilder extends X509SubjectFluent<X509SubjectBuilder> implements VisitableBuilder<X509Subject,X509SubjectBuilder>{

  X509SubjectFluent<?> fluent;

  public X509SubjectBuilder() {
    this(new X509Subject());
  }
  
  public X509SubjectBuilder(X509SubjectFluent<?> fluent) {
    this(fluent, new X509Subject());
  }
  
  public X509SubjectBuilder(X509Subject instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public X509SubjectBuilder(X509SubjectFluent<?> fluent,X509Subject instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public X509Subject build() {
    X509Subject buildable = new X509Subject(fluent.getCountries(), fluent.getLocalities(), fluent.getOrganizationalUnits(), fluent.getOrganizations(), fluent.getPostalCodes(), fluent.getProvinces(), fluent.getSerialNumber(), fluent.getStreetAddresses());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}