package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServerTLSSettingsBuilder extends ServerTLSSettingsFluent<ServerTLSSettingsBuilder> implements VisitableBuilder<ServerTLSSettings,ServerTLSSettingsBuilder>{

  ServerTLSSettingsFluent<?> fluent;

  public ServerTLSSettingsBuilder() {
    this(new ServerTLSSettings());
  }
  
  public ServerTLSSettingsBuilder(ServerTLSSettingsFluent<?> fluent) {
    this(fluent, new ServerTLSSettings());
  }
  
  public ServerTLSSettingsBuilder(ServerTLSSettings instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServerTLSSettingsBuilder(ServerTLSSettingsFluent<?> fluent,ServerTLSSettings instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServerTLSSettings build() {
    ServerTLSSettings buildable = new ServerTLSSettings(fluent.getCaCertCredentialName(), fluent.getCaCertificates(), fluent.getCaCrl(), fluent.getCipherSuites(), fluent.getCredentialName(), fluent.getCredentialNames(), fluent.getHttpsRedirect(), fluent.getMaxProtocolVersion(), fluent.getMinProtocolVersion(), fluent.getMode(), fluent.getPrivateKey(), fluent.getServerCertificate(), fluent.getSubjectAltNames(), fluent.buildTlsCertificates(), fluent.getVerifyCertificateHash(), fluent.getVerifyCertificateSpki());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}