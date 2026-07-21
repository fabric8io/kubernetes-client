package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServerTLSSettingsTLSCertificateBuilder extends ServerTLSSettingsTLSCertificateFluent<ServerTLSSettingsTLSCertificateBuilder> implements VisitableBuilder<ServerTLSSettingsTLSCertificate,ServerTLSSettingsTLSCertificateBuilder>{

  ServerTLSSettingsTLSCertificateFluent<?> fluent;

  public ServerTLSSettingsTLSCertificateBuilder() {
    this(new ServerTLSSettingsTLSCertificate());
  }
  
  public ServerTLSSettingsTLSCertificateBuilder(ServerTLSSettingsTLSCertificateFluent<?> fluent) {
    this(fluent, new ServerTLSSettingsTLSCertificate());
  }
  
  public ServerTLSSettingsTLSCertificateBuilder(ServerTLSSettingsTLSCertificate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServerTLSSettingsTLSCertificateBuilder(ServerTLSSettingsTLSCertificateFluent<?> fluent,ServerTLSSettingsTLSCertificate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServerTLSSettingsTLSCertificate build() {
    ServerTLSSettingsTLSCertificate buildable = new ServerTLSSettingsTLSCertificate(fluent.getCaCertificates(), fluent.getPrivateKey(), fluent.getServerCertificate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}