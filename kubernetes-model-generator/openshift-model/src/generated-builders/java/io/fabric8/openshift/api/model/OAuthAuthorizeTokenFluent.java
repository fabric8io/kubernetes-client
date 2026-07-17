package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import java.lang.Long;
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
public class OAuthAuthorizeTokenFluent<A extends io.fabric8.openshift.api.model.OAuthAuthorizeTokenFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String clientName;
  private String codeChallenge;
  private String codeChallengeMethod;
  private Long expiresIn;
  private String kind;
  private ObjectMetaBuilder metadata;
  private String redirectURI;
  private List<String> scopes = new ArrayList<String>();
  private String state;
  private String userName;
  private String userUID;

  public OAuthAuthorizeTokenFluent() {
  }
  
  public OAuthAuthorizeTokenFluent(OAuthAuthorizeToken instance) {
    this.copyInstance(instance);
  }

  public A addAllToScopes(Collection<String> items) {
    if (this.scopes == null) {
      this.scopes = new ArrayList();
    }
    for (String item : items) {
      this.scopes.add(item);
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
  
  public A addToScopes(String... items) {
    if (this.scopes == null) {
      this.scopes = new ArrayList();
    }
    for (String item : items) {
      this.scopes.add(item);
    }
    return (A) this;
  }
  
  public A addToScopes(int index,String item) {
    if (this.scopes == null) {
      this.scopes = new ArrayList();
    }
    this.scopes.add(index, item);
    return (A) this;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  protected void copyInstance(OAuthAuthorizeToken instance) {
    instance = instance != null ? instance : new OAuthAuthorizeToken();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withClientName(instance.getClientName());
        this.withCodeChallenge(instance.getCodeChallenge());
        this.withCodeChallengeMethod(instance.getCodeChallengeMethod());
        this.withExpiresIn(instance.getExpiresIn());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withRedirectURI(instance.getRedirectURI());
        this.withScopes(instance.getScopes());
        this.withState(instance.getState());
        this.withUserName(instance.getUserName());
        this.withUserUID(instance.getUserUID());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
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
    OAuthAuthorizeTokenFluent that = (OAuthAuthorizeTokenFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(clientName, that.clientName))) {
      return false;
    }
    if (!(Objects.equals(codeChallenge, that.codeChallenge))) {
      return false;
    }
    if (!(Objects.equals(codeChallengeMethod, that.codeChallengeMethod))) {
      return false;
    }
    if (!(Objects.equals(expiresIn, that.expiresIn))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(redirectURI, that.redirectURI))) {
      return false;
    }
    if (!(Objects.equals(scopes, that.scopes))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
      return false;
    }
    if (!(Objects.equals(userName, that.userName))) {
      return false;
    }
    if (!(Objects.equals(userUID, that.userUID))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getClientName() {
    return this.clientName;
  }
  
  public String getCodeChallenge() {
    return this.codeChallenge;
  }
  
  public String getCodeChallengeMethod() {
    return this.codeChallengeMethod;
  }
  
  public Long getExpiresIn() {
    return this.expiresIn;
  }
  
  public String getFirstScope() {
    return this.scopes.get(0);
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastScope() {
    return this.scopes.get(scopes.size() - 1);
  }
  
  public String getMatchingScope(Predicate<String> predicate) {
      for (String item : scopes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getRedirectURI() {
    return this.redirectURI;
  }
  
  public String getScope(int index) {
    return this.scopes.get(index);
  }
  
  public List<String> getScopes() {
    return this.scopes;
  }
  
  public String getState() {
    return this.state;
  }
  
  public String getUserName() {
    return this.userName;
  }
  
  public String getUserUID() {
    return this.userUID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasClientName() {
    return this.clientName != null;
  }
  
  public boolean hasCodeChallenge() {
    return this.codeChallenge != null;
  }
  
  public boolean hasCodeChallengeMethod() {
    return this.codeChallengeMethod != null;
  }
  
  public boolean hasExpiresIn() {
    return this.expiresIn != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingScope(Predicate<String> predicate) {
      for (String item : scopes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasRedirectURI() {
    return this.redirectURI != null;
  }
  
  public boolean hasScopes() {
    return this.scopes != null && !(this.scopes.isEmpty());
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public boolean hasUserName() {
    return this.userName != null;
  }
  
  public boolean hasUserUID() {
    return this.userUID != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, clientName, codeChallenge, codeChallengeMethod, expiresIn, kind, metadata, redirectURI, scopes, state, userName, userUID, additionalProperties);
  }
  
  public A removeAllFromScopes(Collection<String> items) {
    if (this.scopes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.scopes.remove(item);
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
  
  public A removeFromScopes(String... items) {
    if (this.scopes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.scopes.remove(item);
    }
    return (A) this;
  }
  
  public A setToScopes(int index,String item) {
    if (this.scopes == null) {
      this.scopes = new ArrayList();
    }
    this.scopes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(clientName == null)) {
        sb.append("clientName:");
        sb.append(clientName);
        sb.append(",");
    }
    if (!(codeChallenge == null)) {
        sb.append("codeChallenge:");
        sb.append(codeChallenge);
        sb.append(",");
    }
    if (!(codeChallengeMethod == null)) {
        sb.append("codeChallengeMethod:");
        sb.append(codeChallengeMethod);
        sb.append(",");
    }
    if (!(expiresIn == null)) {
        sb.append("expiresIn:");
        sb.append(expiresIn);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(redirectURI == null)) {
        sb.append("redirectURI:");
        sb.append(redirectURI);
        sb.append(",");
    }
    if (!(scopes == null) && !(scopes.isEmpty())) {
        sb.append("scopes:");
        sb.append(scopes);
        sb.append(",");
    }
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
        sb.append(",");
    }
    if (!(userName == null)) {
        sb.append("userName:");
        sb.append(userName);
        sb.append(",");
    }
    if (!(userUID == null)) {
        sb.append("userUID:");
        sb.append(userUID);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withClientName(String clientName) {
    this.clientName = clientName;
    return (A) this;
  }
  
  public A withCodeChallenge(String codeChallenge) {
    this.codeChallenge = codeChallenge;
    return (A) this;
  }
  
  public A withCodeChallengeMethod(String codeChallengeMethod) {
    this.codeChallengeMethod = codeChallengeMethod;
    return (A) this;
  }
  
  public A withExpiresIn(Long expiresIn) {
    this.expiresIn = expiresIn;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public A withRedirectURI(String redirectURI) {
    this.redirectURI = redirectURI;
    return (A) this;
  }
  
  public A withScopes(List<String> scopes) {
    if (scopes != null) {
        this.scopes = new ArrayList();
        for (String item : scopes) {
          this.addToScopes(item);
        }
    } else {
      this.scopes = null;
    }
    return (A) this;
  }
  
  public A withScopes(String... scopes) {
    if (this.scopes != null) {
        this.scopes.clear();
        _visitables.remove("scopes");
    }
    if (scopes != null) {
      for (String item : scopes) {
        this.addToScopes(item);
      }
    }
    return (A) this;
  }
  
  public A withState(String state) {
    this.state = state;
    return (A) this;
  }
  
  public A withUserName(String userName) {
    this.userName = userName;
    return (A) this;
  }
  
  public A withUserUID(String userUID) {
    this.userUID = userUID;
    return (A) this;
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) OAuthAuthorizeTokenFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
}