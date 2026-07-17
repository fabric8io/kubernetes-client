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
public class OpenIDIdentityProviderFluent<A extends io.fabric8.openshift.api.model.config.v1.OpenIDIdentityProviderFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConfigMapNameReferenceBuilder ca;
  private OpenIDClaimsBuilder claims;
  private String clientID;
  private SecretNameReferenceBuilder clientSecret;
  private Map<String,String> extraAuthorizeParameters;
  private List<String> extraScopes = new ArrayList<String>();
  private String issuer;

  public OpenIDIdentityProviderFluent() {
  }
  
  public OpenIDIdentityProviderFluent(OpenIDIdentityProvider instance) {
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
  
  public A addToExtraAuthorizeParameters(Map<String,String> map) {
    if (this.extraAuthorizeParameters == null && map != null) {
      this.extraAuthorizeParameters = new LinkedHashMap();
    }
    if (map != null) {
      this.extraAuthorizeParameters.putAll(map);
    }
    return (A) this;
  }
  
  public A addToExtraAuthorizeParameters(String key,String value) {
    if (this.extraAuthorizeParameters == null && key != null && value != null) {
      this.extraAuthorizeParameters = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.extraAuthorizeParameters.put(key, value);
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
  
  public ConfigMapNameReference buildCa() {
    return this.ca != null ? this.ca.build() : null;
  }
  
  public OpenIDClaims buildClaims() {
    return this.claims != null ? this.claims.build() : null;
  }
  
  public SecretNameReference buildClientSecret() {
    return this.clientSecret != null ? this.clientSecret.build() : null;
  }
  
  protected void copyInstance(OpenIDIdentityProvider instance) {
    instance = instance != null ? instance : new OpenIDIdentityProvider();
    if (instance != null) {
        this.withCa(instance.getCa());
        this.withClaims(instance.getClaims());
        this.withClientID(instance.getClientID());
        this.withClientSecret(instance.getClientSecret());
        this.withExtraAuthorizeParameters(instance.getExtraAuthorizeParameters());
        this.withExtraScopes(instance.getExtraScopes());
        this.withIssuer(instance.getIssuer());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CaNested<A> editCa() {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(null));
  }
  
  public ClaimsNested<A> editClaims() {
    return this.withNewClaimsLike(Optional.ofNullable(this.buildClaims()).orElse(null));
  }
  
  public ClientSecretNested<A> editClientSecret() {
    return this.withNewClientSecretLike(Optional.ofNullable(this.buildClientSecret()).orElse(null));
  }
  
  public CaNested<A> editOrNewCa() {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(new ConfigMapNameReferenceBuilder().build()));
  }
  
  public CaNested<A> editOrNewCaLike(ConfigMapNameReference item) {
    return this.withNewCaLike(Optional.ofNullable(this.buildCa()).orElse(item));
  }
  
  public ClaimsNested<A> editOrNewClaims() {
    return this.withNewClaimsLike(Optional.ofNullable(this.buildClaims()).orElse(new OpenIDClaimsBuilder().build()));
  }
  
  public ClaimsNested<A> editOrNewClaimsLike(OpenIDClaims item) {
    return this.withNewClaimsLike(Optional.ofNullable(this.buildClaims()).orElse(item));
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
    OpenIDIdentityProviderFluent that = (OpenIDIdentityProviderFluent) o;
    if (!(Objects.equals(ca, that.ca))) {
      return false;
    }
    if (!(Objects.equals(claims, that.claims))) {
      return false;
    }
    if (!(Objects.equals(clientID, that.clientID))) {
      return false;
    }
    if (!(Objects.equals(clientSecret, that.clientSecret))) {
      return false;
    }
    if (!(Objects.equals(extraAuthorizeParameters, that.extraAuthorizeParameters))) {
      return false;
    }
    if (!(Objects.equals(extraScopes, that.extraScopes))) {
      return false;
    }
    if (!(Objects.equals(issuer, that.issuer))) {
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
  
  public Map<String,String> getExtraAuthorizeParameters() {
    return this.extraAuthorizeParameters;
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
  
  public String getIssuer() {
    return this.issuer;
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
  
  public boolean hasCa() {
    return this.ca != null;
  }
  
  public boolean hasClaims() {
    return this.claims != null;
  }
  
  public boolean hasClientID() {
    return this.clientID != null;
  }
  
  public boolean hasClientSecret() {
    return this.clientSecret != null;
  }
  
  public boolean hasExtraAuthorizeParameters() {
    return this.extraAuthorizeParameters != null;
  }
  
  public boolean hasExtraScopes() {
    return this.extraScopes != null && !(this.extraScopes.isEmpty());
  }
  
  public boolean hasIssuer() {
    return this.issuer != null;
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
    return Objects.hash(ca, claims, clientID, clientSecret, extraAuthorizeParameters, extraScopes, issuer, additionalProperties);
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
  
  public A removeFromExtraAuthorizeParameters(String key) {
    if (this.extraAuthorizeParameters == null) {
      return (A) this;
    }
    if (key != null && this.extraAuthorizeParameters != null) {
      this.extraAuthorizeParameters.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromExtraAuthorizeParameters(Map<String,String> map) {
    if (this.extraAuthorizeParameters == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.extraAuthorizeParameters != null) {
          this.extraAuthorizeParameters.remove(key);
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
    if (!(ca == null)) {
        sb.append("ca:");
        sb.append(ca);
        sb.append(",");
    }
    if (!(claims == null)) {
        sb.append("claims:");
        sb.append(claims);
        sb.append(",");
    }
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
    if (!(extraAuthorizeParameters == null) && !(extraAuthorizeParameters.isEmpty())) {
        sb.append("extraAuthorizeParameters:");
        sb.append(extraAuthorizeParameters);
        sb.append(",");
    }
    if (!(extraScopes == null) && !(extraScopes.isEmpty())) {
        sb.append("extraScopes:");
        sb.append(extraScopes);
        sb.append(",");
    }
    if (!(issuer == null)) {
        sb.append("issuer:");
        sb.append(issuer);
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
  
  public A withCa(ConfigMapNameReference ca) {
    this._visitables.remove("ca");
    if (ca != null) {
        this.ca = new ConfigMapNameReferenceBuilder(ca);
        this._visitables.get("ca").add(this.ca);
    } else {
        this.ca = null;
        this._visitables.get("ca").remove(this.ca);
    }
    return (A) this;
  }
  
  public A withClaims(OpenIDClaims claims) {
    this._visitables.remove("claims");
    if (claims != null) {
        this.claims = new OpenIDClaimsBuilder(claims);
        this._visitables.get("claims").add(this.claims);
    } else {
        this.claims = null;
        this._visitables.get("claims").remove(this.claims);
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
  
  public <K,V>A withExtraAuthorizeParameters(Map<String,String> extraAuthorizeParameters) {
    if (extraAuthorizeParameters == null) {
      this.extraAuthorizeParameters = null;
    } else {
      this.extraAuthorizeParameters = new LinkedHashMap(extraAuthorizeParameters);
    }
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
  
  public A withIssuer(String issuer) {
    this.issuer = issuer;
    return (A) this;
  }
  
  public CaNested<A> withNewCa() {
    return new CaNested(null);
  }
  
  public A withNewCa(String name) {
    return (A) this.withCa(new ConfigMapNameReference(name));
  }
  
  public CaNested<A> withNewCaLike(ConfigMapNameReference item) {
    return new CaNested(item);
  }
  
  public ClaimsNested<A> withNewClaims() {
    return new ClaimsNested(null);
  }
  
  public ClaimsNested<A> withNewClaimsLike(OpenIDClaims item) {
    return new ClaimsNested(item);
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
  public class CaNested<N> extends ConfigMapNameReferenceFluent<CaNested<N>> implements Nested<N>{
  
    ConfigMapNameReferenceBuilder builder;
  
    CaNested(ConfigMapNameReference item) {
      this.builder = new ConfigMapNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenIDIdentityProviderFluent.this.withCa(builder.build());
    }
    
    public N endCa() {
      return and();
    }
    
  }
  public class ClaimsNested<N> extends OpenIDClaimsFluent<ClaimsNested<N>> implements Nested<N>{
  
    OpenIDClaimsBuilder builder;
  
    ClaimsNested(OpenIDClaims item) {
      this.builder = new OpenIDClaimsBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenIDIdentityProviderFluent.this.withClaims(builder.build());
    }
    
    public N endClaims() {
      return and();
    }
    
  }
  public class ClientSecretNested<N> extends SecretNameReferenceFluent<ClientSecretNested<N>> implements Nested<N>{
  
    SecretNameReferenceBuilder builder;
  
    ClientSecretNested(SecretNameReference item) {
      this.builder = new SecretNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) OpenIDIdentityProviderFluent.this.withClientSecret(builder.build());
    }
    
    public N endClientSecret() {
      return and();
    }
    
  }
}