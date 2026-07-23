package io.fabric8.istio.api.api.security.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UnimplementedIstioCertificateServiceServerBuilder extends UnimplementedIstioCertificateServiceServerFluent<UnimplementedIstioCertificateServiceServerBuilder> implements VisitableBuilder<UnimplementedIstioCertificateServiceServer,UnimplementedIstioCertificateServiceServerBuilder>{

  UnimplementedIstioCertificateServiceServerFluent<?> fluent;

  public UnimplementedIstioCertificateServiceServerBuilder() {
    this(new UnimplementedIstioCertificateServiceServer());
  }
  
  public UnimplementedIstioCertificateServiceServerBuilder(UnimplementedIstioCertificateServiceServerFluent<?> fluent) {
    this(fluent, new UnimplementedIstioCertificateServiceServer());
  }
  
  public UnimplementedIstioCertificateServiceServerBuilder(UnimplementedIstioCertificateServiceServer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UnimplementedIstioCertificateServiceServerBuilder(UnimplementedIstioCertificateServiceServerFluent<?> fluent,UnimplementedIstioCertificateServiceServer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UnimplementedIstioCertificateServiceServer build() {
    UnimplementedIstioCertificateServiceServer buildable = new UnimplementedIstioCertificateServiceServer();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}