package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class OIDCClientConfigFluent<A extends io.fabric8.openshift.api.model.config.v1.OIDCClientConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clientID;
  private SecretNameReferenceBuilder clientSecret;
  private String componentName;
  private String componentNamespace;
  private List<String> extraScopes = new ArrayList<String>();

  public OIDCClientConfigFluent() {
  }
  
  public OIDCClientConfigFluent(OIDCClientConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToExtraScopes(Collection<String> items) {
    if (this.extraScopes == null) {
      this.extraScopes = new ArrayList();
    }
    for (String item : items) {
      this.extraScopes.add(item);
    }
    return (A) this;
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
  
  public A addToExtraScopes(String... items) {
    if (this.extraScopes == null) {
      this.extraScopes = new ArrayList();
    }
    for (String item : items) {
      this.extraScopes.add(item);
    }
    return (A) this;
  }
  
  public A addToExtraScopes(int index,String item) {
    if (this.extraScopes == null) {
      this.extraScopes = new ArrayList();
    }
    this.extraScopes.add(index, item);
    return (A) this;
  }
  
  public SecretNameReference buildClientSecret() {
    return this.clientSecret != null ? this.clientSecret.build() : null;
  }
  
  protected void copyInstance(OIDCClientConfig instance) {
    instance = instance != null ? instance : new OIDCClientConfig();
    if (instance != null) {
        this.withClientID(instance.getClientID());
        this.withClientSecret(instance.getClientSecret());
        this.withComponentName(instance.getComponentName());
        this.withComponentNamespace(instance.getComponentNamespace());
        this.withExtraScopes(instance.getExtraScopes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClientSecretNested<A> editClientSecret() {
    return this.withNewClientSecretLike(Optional.ofNullable(this.buildClientSecret()).orElse(null));
  }
  
  public ClientSecretNested<A> editOrNewClientSecret() {
    return this.withNewClientSecretLike(Optional.ofNullable(this.buildClientSecret()).orElse(new SecretNameReferenceBuilder().build()));
  }
  
  public ClientSecretNested<A> editOrNewClientSecretLike(SecretNameReference item) {
    return this.withNewClientSecretLike(Optional.ofNullable(this.buildClientSecret()).orElse(item));
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
    OIDCClientConfigFluent that = (OIDCClientConfigFluent) o;
    if (!(Objects.equals(clientID, that.clientID))) {
      return false;
    }
    if (!(Objects.equals(clientSecret, that.clientSecret))) {
      return false;
    }
    if (!(Objects.equals(componentName, that.componentName))) {
      return false;
    }
    if (!(Objects.equals(componentNamespace, that.componentNamespace))) {
      return false;
    }
    if (!(Objects.equals(extraScopes, that.extraScopes))) {
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
  
  public String getClientID() {
    return this.clientID;
  }
  
  public String getComponentName() {
    return this.componentName;
  }
  
  public String getComponentNamespace() {
    return this.componentNamespace;
  }
  
  public String getExtraScope(int index) {
    return this.extraScopes.get(index);
  }
  
  public List<String> getExtraScopes() {
    return this.extraScopes;
  }
  
  public String getFirstExtraScope() {
    return this.extraScopes.get(0);
  }
  
  public String getLastExtraScope() {
    return this.extraScopes.get(extraScopes.size() - 1);
  }
  
  public String getMatchingExtraScope(Predicate<String> predicate) {
      for (String item : extraScopes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClientID() {
    return this.clientID != null;
  }
  
  public boolean hasClientSecret() {
    return this.clientSecret != null;
  }
  
  public boolean hasComponentName() {
    return this.componentName != null;
  }
  
  public boolean hasComponentNamespace() {
    return this.componentNamespace != null;
  }
  
  public boolean hasExtraScopes() {
    return this.extraScopes != null && !(this.extraScopes.isEmpty());
  }
  
  public boolean hasMatchingExtraScope(Predicate<String> predicate) {
      for (String item : extraScopes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(clientID, clientSecret, componentName, componentNamespace, extraScopes, additionalProperties);
  }
  
  public A removeAllFromExtraScopes(Collection<String> items) {
    if (this.extraScopes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.extraScopes.remove(item);
    }
    return (A) this;
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
  
  public A removeFromExtraScopes(String... items) {
    if (this.extraScopes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.extraScopes.remove(item);
    }
    return (A) this;
  }
  
  public A setToExtraScopes(int index,String item) {
    if (this.extraScopes == null) {
      this.extraScopes = new ArrayList();
    }
    this.extraScopes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clientID == null)) {
        sb.append("clientID:");
        sb.append(clientID);
        sb.append(",");
    }
    if (!(clientSecret == null)) {
        sb.append("clientSecret:");
        sb.append(clientSecret);
        sb.append(",");
    }
    if (!(componentName == null)) {
        sb.append("componentName:");
        sb.append(componentName);
        sb.append(",");
    }
    if (!(componentNamespace == null)) {
        sb.append("componentNamespace:");
        sb.append(componentNamespace);
        sb.append(",");
    }
    if (!(extraScopes == null) && !(extraScopes.isEmpty())) {
        sb.append("extraScopes:");
        sb.append(extraScopes);
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
  
  public A withClientID(String clientID) {
    this.clientID = clientID;
    return (A) this;
  }
  
  public A withClientSecret(SecretNameReference clientSecret) {
    this._visitables.remove("clientSecret");
    if (clientSecret != null) {
        this.clientSecret = new SecretNameReferenceBuilder(clientSecret);
        this._visitables.get("clientSecret").add(this.clientSecret);
    } else {
        this.clientSecret = null;
        this._visitables.get("clientSecret").remove(this.clientSecret);
    }
    return (A) this;
  }
  
  public A withComponentName(String componentName) {
    this.componentName = componentName;
    return (A) this;
  }
  
  public A withComponentNamespace(String componentNamespace) {
    this.componentNamespace = componentNamespace;
    return (A) this;
  }
  
  public A withExtraScopes(List<String> extraScopes) {
    if (extraScopes != null) {
        this.extraScopes = new ArrayList();
        for (String item : extraScopes) {
          this.addToExtraScopes(item);
        }
    } else {
      this.extraScopes = null;
    }
    return (A) this;
  }
  
  public A withExtraScopes(String... extraScopes) {
    if (this.extraScopes != null) {
        this.extraScopes.clear();
        _visitables.remove("extraScopes");
    }
    if (extraScopes != null) {
      for (String item : extraScopes) {
        this.addToExtraScopes(item);
      }
    }
    return (A) this;
  }
  
  public ClientSecretNested<A> withNewClientSecret() {
    return new ClientSecretNested(null);
  }
  
  public A withNewClientSecret(String name) {
    return (A) this.withClientSecret(new SecretNameReference(name));
  }
  
  public ClientSecretNested<A> withNewClientSecretLike(SecretNameReference item) {
    return new ClientSecretNested(item);
  }
  public class ClientSecretNested<N> extends SecretNameReferenceFluent<ClientSecretNested<N>> implements Nested<N>{
  
    SecretNameReferenceBuilder builder;
  
    ClientSecretNested(SecretNameReference item) {
      this.builder = new SecretNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) OIDCClientConfigFluent.this.withClientSecret(builder.build());
    }
    
    public N endClientSecret() {
      return and();
    }
    
  }
}