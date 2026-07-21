package io.fabric8.certmanager.api.model.v1;

import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorBuilder;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class VaultAuthFluent<A extends io.fabric8.certmanager.api.model.v1.VaultAuthFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VaultAppRoleBuilder appRole;
  private VaultClientCertificateAuthBuilder clientCertificate;
  private VaultKubernetesAuthBuilder kubernetes;
  private SecretKeySelectorBuilder tokenSecretRef;

  public VaultAuthFluent() {
  }
  
  public VaultAuthFluent(VaultAuth instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public VaultAppRole buildAppRole() {
    return this.appRole != null ? this.appRole.build() : null;
  }
  
  public VaultClientCertificateAuth buildClientCertificate() {
    return this.clientCertificate != null ? this.clientCertificate.build() : null;
  }
  
  public VaultKubernetesAuth buildKubernetes() {
    return this.kubernetes != null ? this.kubernetes.build() : null;
  }
  
  public SecretKeySelector buildTokenSecretRef() {
    return this.tokenSecretRef != null ? this.tokenSecretRef.build() : null;
  }
  
  protected void copyInstance(VaultAuth instance) {
    instance = instance != null ? instance : new VaultAuth();
    if (instance != null) {
        this.withAppRole(instance.getAppRole());
        this.withClientCertificate(instance.getClientCertificate());
        this.withKubernetes(instance.getKubernetes());
        this.withTokenSecretRef(instance.getTokenSecretRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AppRoleNested<A> editAppRole() {
    return this.withNewAppRoleLike(Optional.ofNullable(this.buildAppRole()).orElse(null));
  }
  
  public ClientCertificateNested<A> editClientCertificate() {
    return this.withNewClientCertificateLike(Optional.ofNullable(this.buildClientCertificate()).orElse(null));
  }
  
  public KubernetesNested<A> editKubernetes() {
    return this.withNewKubernetesLike(Optional.ofNullable(this.buildKubernetes()).orElse(null));
  }
  
  public AppRoleNested<A> editOrNewAppRole() {
    return this.withNewAppRoleLike(Optional.ofNullable(this.buildAppRole()).orElse(new VaultAppRoleBuilder().build()));
  }
  
  public AppRoleNested<A> editOrNewAppRoleLike(VaultAppRole item) {
    return this.withNewAppRoleLike(Optional.ofNullable(this.buildAppRole()).orElse(item));
  }
  
  public ClientCertificateNested<A> editOrNewClientCertificate() {
    return this.withNewClientCertificateLike(Optional.ofNullable(this.buildClientCertificate()).orElse(new VaultClientCertificateAuthBuilder().build()));
  }
  
  public ClientCertificateNested<A> editOrNewClientCertificateLike(VaultClientCertificateAuth item) {
    return this.withNewClientCertificateLike(Optional.ofNullable(this.buildClientCertificate()).orElse(item));
  }
  
  public KubernetesNested<A> editOrNewKubernetes() {
    return this.withNewKubernetesLike(Optional.ofNullable(this.buildKubernetes()).orElse(new VaultKubernetesAuthBuilder().build()));
  }
  
  public KubernetesNested<A> editOrNewKubernetesLike(VaultKubernetesAuth item) {
    return this.withNewKubernetesLike(Optional.ofNullable(this.buildKubernetes()).orElse(item));
  }
  
  public TokenSecretRefNested<A> editOrNewTokenSecretRef() {
    return this.withNewTokenSecretRefLike(Optional.ofNullable(this.buildTokenSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public TokenSecretRefNested<A> editOrNewTokenSecretRefLike(SecretKeySelector item) {
    return this.withNewTokenSecretRefLike(Optional.ofNullable(this.buildTokenSecretRef()).orElse(item));
  }
  
  public TokenSecretRefNested<A> editTokenSecretRef() {
    return this.withNewTokenSecretRefLike(Optional.ofNullable(this.buildTokenSecretRef()).orElse(null));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    VaultAuthFluent that = (VaultAuthFluent) o;
    if (!(Objects.equals(appRole, that.appRole))) {
      return false;
    }
    if (!(Objects.equals(clientCertificate, that.clientCertificate))) {
      return false;
    }
    if (!(Objects.equals(kubernetes, that.kubernetes))) {
      return false;
    }
    if (!(Objects.equals(tokenSecretRef, that.tokenSecretRef))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAppRole() {
    return this.appRole != null;
  }
  
  public boolean hasClientCertificate() {
    return this.clientCertificate != null;
  }
  
  public boolean hasKubernetes() {
    return this.kubernetes != null;
  }
  
  public boolean hasTokenSecretRef() {
    return this.tokenSecretRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(appRole, clientCertificate, kubernetes, tokenSecretRef, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(appRole == null)) {
        sb.append("appRole:");
        sb.append(appRole);
        sb.append(",");
    }
    if (!(clientCertificate == null)) {
        sb.append("clientCertificate:");
        sb.append(clientCertificate);
        sb.append(",");
    }
    if (!(kubernetes == null)) {
        sb.append("kubernetes:");
        sb.append(kubernetes);
        sb.append(",");
    }
    if (!(tokenSecretRef == null)) {
        sb.append("tokenSecretRef:");
        sb.append(tokenSecretRef);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAppRole(VaultAppRole appRole) {
    this._visitables.remove("appRole");
    if (appRole != null) {
        this.appRole = new VaultAppRoleBuilder(appRole);
        this._visitables.get("appRole").add(this.appRole);
    } else {
        this.appRole = null;
        this._visitables.get("appRole").remove(this.appRole);
    }
    return (A) this;
  }
  
  public A withClientCertificate(VaultClientCertificateAuth clientCertificate) {
    this._visitables.remove("clientCertificate");
    if (clientCertificate != null) {
        this.clientCertificate = new VaultClientCertificateAuthBuilder(clientCertificate);
        this._visitables.get("clientCertificate").add(this.clientCertificate);
    } else {
        this.clientCertificate = null;
        this._visitables.get("clientCertificate").remove(this.clientCertificate);
    }
    return (A) this;
  }
  
  public A withKubernetes(VaultKubernetesAuth kubernetes) {
    this._visitables.remove("kubernetes");
    if (kubernetes != null) {
        this.kubernetes = new VaultKubernetesAuthBuilder(kubernetes);
        this._visitables.get("kubernetes").add(this.kubernetes);
    } else {
        this.kubernetes = null;
        this._visitables.get("kubernetes").remove(this.kubernetes);
    }
    return (A) this;
  }
  
  public AppRoleNested<A> withNewAppRole() {
    return new AppRoleNested(null);
  }
  
  public AppRoleNested<A> withNewAppRoleLike(VaultAppRole item) {
    return new AppRoleNested(item);
  }
  
  public ClientCertificateNested<A> withNewClientCertificate() {
    return new ClientCertificateNested(null);
  }
  
  public A withNewClientCertificate(String mountPath,String name,String secretName) {
    return (A) this.withClientCertificate(new VaultClientCertificateAuth(mountPath, name, secretName));
  }
  
  public ClientCertificateNested<A> withNewClientCertificateLike(VaultClientCertificateAuth item) {
    return new ClientCertificateNested(item);
  }
  
  public KubernetesNested<A> withNewKubernetes() {
    return new KubernetesNested(null);
  }
  
  public KubernetesNested<A> withNewKubernetesLike(VaultKubernetesAuth item) {
    return new KubernetesNested(item);
  }
  
  public TokenSecretRefNested<A> withNewTokenSecretRef() {
    return new TokenSecretRefNested(null);
  }
  
  public A withNewTokenSecretRef(String key,String name) {
    return (A) this.withTokenSecretRef(new SecretKeySelector(key, name));
  }
  
  public TokenSecretRefNested<A> withNewTokenSecretRefLike(SecretKeySelector item) {
    return new TokenSecretRefNested(item);
  }
  
  public A withTokenSecretRef(SecretKeySelector tokenSecretRef) {
    this._visitables.remove("tokenSecretRef");
    if (tokenSecretRef != null) {
        this.tokenSecretRef = new SecretKeySelectorBuilder(tokenSecretRef);
        this._visitables.get("tokenSecretRef").add(this.tokenSecretRef);
    } else {
        this.tokenSecretRef = null;
        this._visitables.get("tokenSecretRef").remove(this.tokenSecretRef);
    }
    return (A) this;
  }
  public class AppRoleNested<N> extends VaultAppRoleFluent<AppRoleNested<N>> implements Nested<N>{
  
    VaultAppRoleBuilder builder;
  
    AppRoleNested(VaultAppRole item) {
      this.builder = new VaultAppRoleBuilder(this, item);
    }
  
    public N and() {
      return (N) VaultAuthFluent.this.withAppRole(builder.build());
    }
    
    public N endAppRole() {
      return and();
    }
    
  }
  public class ClientCertificateNested<N> extends VaultClientCertificateAuthFluent<ClientCertificateNested<N>> implements Nested<N>{
  
    VaultClientCertificateAuthBuilder builder;
  
    ClientCertificateNested(VaultClientCertificateAuth item) {
      this.builder = new VaultClientCertificateAuthBuilder(this, item);
    }
  
    public N and() {
      return (N) VaultAuthFluent.this.withClientCertificate(builder.build());
    }
    
    public N endClientCertificate() {
      return and();
    }
    
  }
  public class KubernetesNested<N> extends VaultKubernetesAuthFluent<KubernetesNested<N>> implements Nested<N>{
  
    VaultKubernetesAuthBuilder builder;
  
    KubernetesNested(VaultKubernetesAuth item) {
      this.builder = new VaultKubernetesAuthBuilder(this, item);
    }
  
    public N and() {
      return (N) VaultAuthFluent.this.withKubernetes(builder.build());
    }
    
    public N endKubernetes() {
      return and();
    }
    
  }
  public class TokenSecretRefNested<N> extends SecretKeySelectorFluent<TokenSecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    TokenSecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) VaultAuthFluent.this.withTokenSecretRef(builder.build());
    }
    
    public N endTokenSecretRef() {
      return and();
    }
    
  }
}