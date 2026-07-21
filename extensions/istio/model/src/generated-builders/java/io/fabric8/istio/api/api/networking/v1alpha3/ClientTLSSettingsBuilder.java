package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClientTLSSettingsBuilder extends ClientTLSSettingsFluent<ClientTLSSettingsBuilder> implements VisitableBuilder<ClientTLSSettings,ClientTLSSettingsBuilder>{

  ClientTLSSettingsFluent<?> fluent;

  public ClientTLSSettingsBuilder() {
    this(new ClientTLSSettings());
  }
  
  public ClientTLSSettingsBuilder(ClientTLSSettingsFluent<?> fluent) {
    this(fluent, new ClientTLSSettings());
  }
  
  public ClientTLSSettingsBuilder(ClientTLSSettings instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClientTLSSettingsBuilder(ClientTLSSettingsFluent<?> fluent,ClientTLSSettings instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClientTLSSettings build() {
    ClientTLSSettings buildable = new ClientTLSSettings(fluent.getCaCertificates(), fluent.getCaCrl(), fluent.getClientCertificate(), fluent.getCredentialName(), fluent.getInsecureSkipVerify(), fluent.getMode(), fluent.getPrivateKey(), fluent.getSni(), fluent.getSubjectAltNames());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}