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
public class VaultIssuerFluent<A extends io.fabric8.certmanager.api.model.v1.VaultIssuerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VaultAuthBuilder auth;
  private String caBundle;
  private SecretKeySelectorBuilder caBundleSecretRef;
  private SecretKeySelectorBuilder clientCertSecretRef;
  private SecretKeySelectorBuilder clientKeySecretRef;
  private String namespace;
  private String path;
  private String server;
  private String serverName;

  public VaultIssuerFluent() {
  }
  
  public VaultIssuerFluent(VaultIssuer instance) {
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
  
  public VaultAuth buildAuth() {
    return this.auth != null ? this.auth.build() : null;
  }
  
  public SecretKeySelector buildCaBundleSecretRef() {
    return this.caBundleSecretRef != null ? this.caBundleSecretRef.build() : null;
  }
  
  public SecretKeySelector buildClientCertSecretRef() {
    return this.clientCertSecretRef != null ? this.clientCertSecretRef.build() : null;
  }
  
  public SecretKeySelector buildClientKeySecretRef() {
    return this.clientKeySecretRef != null ? this.clientKeySecretRef.build() : null;
  }
  
  protected void copyInstance(VaultIssuer instance) {
    instance = instance != null ? instance : new VaultIssuer();
    if (instance != null) {
        this.withAuth(instance.getAuth());
        this.withCaBundle(instance.getCaBundle());
        this.withCaBundleSecretRef(instance.getCaBundleSecretRef());
        this.withClientCertSecretRef(instance.getClientCertSecretRef());
        this.withClientKeySecretRef(instance.getClientKeySecretRef());
        this.withNamespace(instance.getNamespace());
        this.withPath(instance.getPath());
        this.withServer(instance.getServer());
        this.withServerName(instance.getServerName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthNested<A> editAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(null));
  }
  
  public CaBundleSecretRefNested<A> editCaBundleSecretRef() {
    return this.withNewCaBundleSecretRefLike(Optional.ofNullable(this.buildCaBundleSecretRef()).orElse(null));
  }
  
  public ClientCertSecretRefNested<A> editClientCertSecretRef() {
    return this.withNewClientCertSecretRefLike(Optional.ofNullable(this.buildClientCertSecretRef()).orElse(null));
  }
  
  public ClientKeySecretRefNested<A> editClientKeySecretRef() {
    return this.withNewClientKeySecretRefLike(Optional.ofNullable(this.buildClientKeySecretRef()).orElse(null));
  }
  
  public AuthNested<A> editOrNewAuth() {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(new VaultAuthBuilder().build()));
  }
  
  public AuthNested<A> editOrNewAuthLike(VaultAuth item) {
    return this.withNewAuthLike(Optional.ofNullable(this.buildAuth()).orElse(item));
  }
  
  public CaBundleSecretRefNested<A> editOrNewCaBundleSecretRef() {
    return this.withNewCaBundleSecretRefLike(Optional.ofNullable(this.buildCaBundleSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public CaBundleSecretRefNested<A> editOrNewCaBundleSecretRefLike(SecretKeySelector item) {
    return this.withNewCaBundleSecretRefLike(Optional.ofNullable(this.buildCaBundleSecretRef()).orElse(item));
  }
  
  public ClientCertSecretRefNested<A> editOrNewClientCertSecretRef() {
    return this.withNewClientCertSecretRefLike(Optional.ofNullable(this.buildClientCertSecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public ClientCertSecretRefNested<A> editOrNewClientCertSecretRefLike(SecretKeySelector item) {
    return this.withNewClientCertSecretRefLike(Optional.ofNullable(this.buildClientCertSecretRef()).orElse(item));
  }
  
  public ClientKeySecretRefNested<A> editOrNewClientKeySecretRef() {
    return this.withNewClientKeySecretRefLike(Optional.ofNullable(this.buildClientKeySecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public ClientKeySecretRefNested<A> editOrNewClientKeySecretRefLike(SecretKeySelector item) {
    return this.withNewClientKeySecretRefLike(Optional.ofNullable(this.buildClientKeySecretRef()).orElse(item));
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
    VaultIssuerFluent that = (VaultIssuerFluent) o;
    if (!(Objects.equals(auth, that.auth))) {
      return false;
    }
    if (!(Objects.equals(caBundle, that.caBundle))) {
      return false;
    }
    if (!(Objects.equals(caBundleSecretRef, that.caBundleSecretRef))) {
      return false;
    }
    if (!(Objects.equals(clientCertSecretRef, that.clientCertSecretRef))) {
      return false;
    }
    if (!(Objects.equals(clientKeySecretRef, that.clientKeySecretRef))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(server, that.server))) {
      return false;
    }
    if (!(Objects.equals(serverName, that.serverName))) {
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
  
  public String getCaBundle() {
    return this.caBundle;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public String getServer() {
    return this.server;
  }
  
  public String getServerName() {
    return this.serverName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuth() {
    return this.auth != null;
  }
  
  public boolean hasCaBundle() {
    return this.caBundle != null;
  }
  
  public boolean hasCaBundleSecretRef() {
    return this.caBundleSecretRef != null;
  }
  
  public boolean hasClientCertSecretRef() {
    return this.clientCertSecretRef != null;
  }
  
  public boolean hasClientKeySecretRef() {
    return this.clientKeySecretRef != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasServer() {
    return this.server != null;
  }
  
  public boolean hasServerName() {
    return this.serverName != null;
  }
  
  public int hashCode() {
    return Objects.hash(auth, caBundle, caBundleSecretRef, clientCertSecretRef, clientKeySecretRef, namespace, path, server, serverName, additionalProperties);
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
    if (!(auth == null)) {
        sb.append("auth:");
        sb.append(auth);
        sb.append(",");
    }
    if (!(caBundle == null)) {
        sb.append("caBundle:");
        sb.append(caBundle);
        sb.append(",");
    }
    if (!(caBundleSecretRef == null)) {
        sb.append("caBundleSecretRef:");
        sb.append(caBundleSecretRef);
        sb.append(",");
    }
    if (!(clientCertSecretRef == null)) {
        sb.append("clientCertSecretRef:");
        sb.append(clientCertSecretRef);
        sb.append(",");
    }
    if (!(clientKeySecretRef == null)) {
        sb.append("clientKeySecretRef:");
        sb.append(clientKeySecretRef);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(server == null)) {
        sb.append("server:");
        sb.append(server);
        sb.append(",");
    }
    if (!(serverName == null)) {
        sb.append("serverName:");
        sb.append(serverName);
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
  
  public A withAuth(VaultAuth auth) {
    this._visitables.remove("auth");
    if (auth != null) {
        this.auth = new VaultAuthBuilder(auth);
        this._visitables.get("auth").add(this.auth);
    } else {
        this.auth = null;
        this._visitables.get("auth").remove(this.auth);
    }
    return (A) this;
  }
  
  public A withCaBundle(String caBundle) {
    this.caBundle = caBundle;
    return (A) this;
  }
  
  public A withCaBundleSecretRef(SecretKeySelector caBundleSecretRef) {
    this._visitables.remove("caBundleSecretRef");
    if (caBundleSecretRef != null) {
        this.caBundleSecretRef = new SecretKeySelectorBuilder(caBundleSecretRef);
        this._visitables.get("caBundleSecretRef").add(this.caBundleSecretRef);
    } else {
        this.caBundleSecretRef = null;
        this._visitables.get("caBundleSecretRef").remove(this.caBundleSecretRef);
    }
    return (A) this;
  }
  
  public A withClientCertSecretRef(SecretKeySelector clientCertSecretRef) {
    this._visitables.remove("clientCertSecretRef");
    if (clientCertSecretRef != null) {
        this.clientCertSecretRef = new SecretKeySelectorBuilder(clientCertSecretRef);
        this._visitables.get("clientCertSecretRef").add(this.clientCertSecretRef);
    } else {
        this.clientCertSecretRef = null;
        this._visitables.get("clientCertSecretRef").remove(this.clientCertSecretRef);
    }
    return (A) this;
  }
  
  public A withClientKeySecretRef(SecretKeySelector clientKeySecretRef) {
    this._visitables.remove("clientKeySecretRef");
    if (clientKeySecretRef != null) {
        this.clientKeySecretRef = new SecretKeySelectorBuilder(clientKeySecretRef);
        this._visitables.get("clientKeySecretRef").add(this.clientKeySecretRef);
    } else {
        this.clientKeySecretRef = null;
        this._visitables.get("clientKeySecretRef").remove(this.clientKeySecretRef);
    }
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public AuthNested<A> withNewAuth() {
    return new AuthNested(null);
  }
  
  public AuthNested<A> withNewAuthLike(VaultAuth item) {
    return new AuthNested(item);
  }
  
  public CaBundleSecretRefNested<A> withNewCaBundleSecretRef() {
    return new CaBundleSecretRefNested(null);
  }
  
  public A withNewCaBundleSecretRef(String key,String name) {
    return (A) this.withCaBundleSecretRef(new SecretKeySelector(key, name));
  }
  
  public CaBundleSecretRefNested<A> withNewCaBundleSecretRefLike(SecretKeySelector item) {
    return new CaBundleSecretRefNested(item);
  }
  
  public ClientCertSecretRefNested<A> withNewClientCertSecretRef() {
    return new ClientCertSecretRefNested(null);
  }
  
  public A withNewClientCertSecretRef(String key,String name) {
    return (A) this.withClientCertSecretRef(new SecretKeySelector(key, name));
  }
  
  public ClientCertSecretRefNested<A> withNewClientCertSecretRefLike(SecretKeySelector item) {
    return new ClientCertSecretRefNested(item);
  }
  
  public ClientKeySecretRefNested<A> withNewClientKeySecretRef() {
    return new ClientKeySecretRefNested(null);
  }
  
  public A withNewClientKeySecretRef(String key,String name) {
    return (A) this.withClientKeySecretRef(new SecretKeySelector(key, name));
  }
  
  public ClientKeySecretRefNested<A> withNewClientKeySecretRefLike(SecretKeySelector item) {
    return new ClientKeySecretRefNested(item);
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withServer(String server) {
    this.server = server;
    return (A) this;
  }
  
  public A withServerName(String serverName) {
    this.serverName = serverName;
    return (A) this;
  }
  public class AuthNested<N> extends VaultAuthFluent<AuthNested<N>> implements Nested<N>{
  
    VaultAuthBuilder builder;
  
    AuthNested(VaultAuth item) {
      this.builder = new VaultAuthBuilder(this, item);
    }
  
    public N and() {
      return (N) VaultIssuerFluent.this.withAuth(builder.build());
    }
    
    public N endAuth() {
      return and();
    }
    
  }
  public class CaBundleSecretRefNested<N> extends SecretKeySelectorFluent<CaBundleSecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    CaBundleSecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) VaultIssuerFluent.this.withCaBundleSecretRef(builder.build());
    }
    
    public N endCaBundleSecretRef() {
      return and();
    }
    
  }
  public class ClientCertSecretRefNested<N> extends SecretKeySelectorFluent<ClientCertSecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    ClientCertSecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) VaultIssuerFluent.this.withClientCertSecretRef(builder.build());
    }
    
    public N endClientCertSecretRef() {
      return and();
    }
    
  }
  public class ClientKeySecretRefNested<N> extends SecretKeySelectorFluent<ClientKeySecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    ClientKeySecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) VaultIssuerFluent.this.withClientKeySecretRef(builder.build());
    }
    
    public N endClientKeySecretRef() {
      return and();
    }
    
  }
}