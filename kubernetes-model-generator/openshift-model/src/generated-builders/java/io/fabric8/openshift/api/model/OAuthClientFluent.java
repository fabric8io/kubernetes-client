package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class OAuthClientFluent<A extends io.fabric8.openshift.api.model.OAuthClientFluent<A>> extends BaseFluent<A>{

  private Integer accessTokenInactivityTimeoutSeconds;
  private Integer accessTokenMaxAgeSeconds;
  private Map<String,Object> additionalProperties;
  private List<String> additionalSecrets = new ArrayList<String>();
  private String apiVersion;
  private String grantMethod;
  private String kind;
  private ObjectMetaBuilder metadata;
  private List<String> redirectURIs = new ArrayList<String>();
  private Boolean respondWithChallenges;
  private ArrayList<ScopeRestrictionBuilder> scopeRestrictions = new ArrayList<ScopeRestrictionBuilder>();
  private String secret;

  public OAuthClientFluent() {
  }
  
  public OAuthClientFluent(OAuthClient instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalSecrets(Collection<String> items) {
    if (this.additionalSecrets == null) {
      this.additionalSecrets = new ArrayList();
    }
    for (String item : items) {
      this.additionalSecrets.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRedirectURIs(Collection<String> items) {
    if (this.redirectURIs == null) {
      this.redirectURIs = new ArrayList();
    }
    for (String item : items) {
      this.redirectURIs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToScopeRestrictions(Collection<ScopeRestriction> items) {
    if (this.scopeRestrictions == null) {
      this.scopeRestrictions = new ArrayList();
    }
    for (ScopeRestriction item : items) {
        ScopeRestrictionBuilder builder = new ScopeRestrictionBuilder(item);
        _visitables.get("scopeRestrictions").add(builder);
        this.scopeRestrictions.add(builder);
    }
    return (A) this;
  }
  
  public ScopeRestrictionsNested<A> addNewScopeRestriction() {
    return new ScopeRestrictionsNested(-1, null);
  }
  
  public ScopeRestrictionsNested<A> addNewScopeRestrictionLike(ScopeRestriction item) {
    return new ScopeRestrictionsNested(-1, item);
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
  
  public A addToAdditionalSecrets(String... items) {
    if (this.additionalSecrets == null) {
      this.additionalSecrets = new ArrayList();
    }
    for (String item : items) {
      this.additionalSecrets.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalSecrets(int index,String item) {
    if (this.additionalSecrets == null) {
      this.additionalSecrets = new ArrayList();
    }
    this.additionalSecrets.add(index, item);
    return (A) this;
  }
  
  public A addToRedirectURIs(String... items) {
    if (this.redirectURIs == null) {
      this.redirectURIs = new ArrayList();
    }
    for (String item : items) {
      this.redirectURIs.add(item);
    }
    return (A) this;
  }
  
  public A addToRedirectURIs(int index,String item) {
    if (this.redirectURIs == null) {
      this.redirectURIs = new ArrayList();
    }
    this.redirectURIs.add(index, item);
    return (A) this;
  }
  
  public A addToScopeRestrictions(ScopeRestriction... items) {
    if (this.scopeRestrictions == null) {
      this.scopeRestrictions = new ArrayList();
    }
    for (ScopeRestriction item : items) {
        ScopeRestrictionBuilder builder = new ScopeRestrictionBuilder(item);
        _visitables.get("scopeRestrictions").add(builder);
        this.scopeRestrictions.add(builder);
    }
    return (A) this;
  }
  
  public A addToScopeRestrictions(int index,ScopeRestriction item) {
    if (this.scopeRestrictions == null) {
      this.scopeRestrictions = new ArrayList();
    }
    ScopeRestrictionBuilder builder = new ScopeRestrictionBuilder(item);
    if (index < 0 || index >= scopeRestrictions.size()) {
        _visitables.get("scopeRestrictions").add(builder);
        scopeRestrictions.add(builder);
    } else {
        _visitables.get("scopeRestrictions").add(builder);
        scopeRestrictions.add(index, builder);
    }
    return (A) this;
  }
  
  public ScopeRestriction buildFirstScopeRestriction() {
    return this.scopeRestrictions.get(0).build();
  }
  
  public ScopeRestriction buildLastScopeRestriction() {
    return this.scopeRestrictions.get(scopeRestrictions.size() - 1).build();
  }
  
  public ScopeRestriction buildMatchingScopeRestriction(Predicate<ScopeRestrictionBuilder> predicate) {
      for (ScopeRestrictionBuilder item : scopeRestrictions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public ScopeRestriction buildScopeRestriction(int index) {
    return this.scopeRestrictions.get(index).build();
  }
  
  public List<ScopeRestriction> buildScopeRestrictions() {
    return this.scopeRestrictions != null ? build(scopeRestrictions) : null;
  }
  
  protected void copyInstance(OAuthClient instance) {
    instance = instance != null ? instance : new OAuthClient();
    if (instance != null) {
        this.withAccessTokenInactivityTimeoutSeconds(instance.getAccessTokenInactivityTimeoutSeconds());
        this.withAccessTokenMaxAgeSeconds(instance.getAccessTokenMaxAgeSeconds());
        this.withAdditionalSecrets(instance.getAdditionalSecrets());
        this.withApiVersion(instance.getApiVersion());
        this.withGrantMethod(instance.getGrantMethod());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withRedirectURIs(instance.getRedirectURIs());
        this.withRespondWithChallenges(instance.getRespondWithChallenges());
        this.withScopeRestrictions(instance.getScopeRestrictions());
        this.withSecret(instance.getSecret());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ScopeRestrictionsNested<A> editFirstScopeRestriction() {
    if (scopeRestrictions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "scopeRestrictions"));
    }
    return this.setNewScopeRestrictionLike(0, this.buildScopeRestriction(0));
  }
  
  public ScopeRestrictionsNested<A> editLastScopeRestriction() {
    int index = scopeRestrictions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "scopeRestrictions"));
    }
    return this.setNewScopeRestrictionLike(index, this.buildScopeRestriction(index));
  }
  
  public ScopeRestrictionsNested<A> editMatchingScopeRestriction(Predicate<ScopeRestrictionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < scopeRestrictions.size();i++) {
      if (predicate.test(scopeRestrictions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "scopeRestrictions"));
    }
    return this.setNewScopeRestrictionLike(index, this.buildScopeRestriction(index));
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
  
  public ScopeRestrictionsNested<A> editScopeRestriction(int index) {
    if (scopeRestrictions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "scopeRestrictions"));
    }
    return this.setNewScopeRestrictionLike(index, this.buildScopeRestriction(index));
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
    OAuthClientFluent that = (OAuthClientFluent) o;
    if (!(Objects.equals(accessTokenInactivityTimeoutSeconds, that.accessTokenInactivityTimeoutSeconds))) {
      return false;
    }
    if (!(Objects.equals(accessTokenMaxAgeSeconds, that.accessTokenMaxAgeSeconds))) {
      return false;
    }
    if (!(Objects.equals(additionalSecrets, that.additionalSecrets))) {
      return false;
    }
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(grantMethod, that.grantMethod))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(redirectURIs, that.redirectURIs))) {
      return false;
    }
    if (!(Objects.equals(respondWithChallenges, that.respondWithChallenges))) {
      return false;
    }
    if (!(Objects.equals(scopeRestrictions, that.scopeRestrictions))) {
      return false;
    }
    if (!(Objects.equals(secret, that.secret))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Integer getAccessTokenInactivityTimeoutSeconds() {
    return this.accessTokenInactivityTimeoutSeconds;
  }
  
  public Integer getAccessTokenMaxAgeSeconds() {
    return this.accessTokenMaxAgeSeconds;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getAdditionalSecret(int index) {
    return this.additionalSecrets.get(index);
  }
  
  public List<String> getAdditionalSecrets() {
    return this.additionalSecrets;
  }
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getFirstAdditionalSecret() {
    return this.additionalSecrets.get(0);
  }
  
  public String getFirstRedirectURI() {
    return this.redirectURIs.get(0);
  }
  
  public String getGrantMethod() {
    return this.grantMethod;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastAdditionalSecret() {
    return this.additionalSecrets.get(additionalSecrets.size() - 1);
  }
  
  public String getLastRedirectURI() {
    return this.redirectURIs.get(redirectURIs.size() - 1);
  }
  
  public String getMatchingAdditionalSecret(Predicate<String> predicate) {
      for (String item : additionalSecrets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingRedirectURI(Predicate<String> predicate) {
      for (String item : redirectURIs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getRedirectURI(int index) {
    return this.redirectURIs.get(index);
  }
  
  public List<String> getRedirectURIs() {
    return this.redirectURIs;
  }
  
  public Boolean getRespondWithChallenges() {
    return this.respondWithChallenges;
  }
  
  public String getSecret() {
    return this.secret;
  }
  
  public boolean hasAccessTokenInactivityTimeoutSeconds() {
    return this.accessTokenInactivityTimeoutSeconds != null;
  }
  
  public boolean hasAccessTokenMaxAgeSeconds() {
    return this.accessTokenMaxAgeSeconds != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdditionalSecrets() {
    return this.additionalSecrets != null && !(this.additionalSecrets.isEmpty());
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasGrantMethod() {
    return this.grantMethod != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingAdditionalSecret(Predicate<String> predicate) {
      for (String item : additionalSecrets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRedirectURI(Predicate<String> predicate) {
      for (String item : redirectURIs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingScopeRestriction(Predicate<ScopeRestrictionBuilder> predicate) {
      for (ScopeRestrictionBuilder item : scopeRestrictions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasRedirectURIs() {
    return this.redirectURIs != null && !(this.redirectURIs.isEmpty());
  }
  
  public boolean hasRespondWithChallenges() {
    return this.respondWithChallenges != null;
  }
  
  public boolean hasScopeRestrictions() {
    return this.scopeRestrictions != null && !(this.scopeRestrictions.isEmpty());
  }
  
  public boolean hasSecret() {
    return this.secret != null;
  }
  
  public int hashCode() {
    return Objects.hash(accessTokenInactivityTimeoutSeconds, accessTokenMaxAgeSeconds, additionalSecrets, apiVersion, grantMethod, kind, metadata, redirectURIs, respondWithChallenges, scopeRestrictions, secret, additionalProperties);
  }
  
  public A removeAllFromAdditionalSecrets(Collection<String> items) {
    if (this.additionalSecrets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalSecrets.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRedirectURIs(Collection<String> items) {
    if (this.redirectURIs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.redirectURIs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromScopeRestrictions(Collection<ScopeRestriction> items) {
    if (this.scopeRestrictions == null) {
      return (A) this;
    }
    for (ScopeRestriction item : items) {
        ScopeRestrictionBuilder builder = new ScopeRestrictionBuilder(item);
        _visitables.get("scopeRestrictions").remove(builder);
        this.scopeRestrictions.remove(builder);
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
  
  public A removeFromAdditionalSecrets(String... items) {
    if (this.additionalSecrets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalSecrets.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRedirectURIs(String... items) {
    if (this.redirectURIs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.redirectURIs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromScopeRestrictions(ScopeRestriction... items) {
    if (this.scopeRestrictions == null) {
      return (A) this;
    }
    for (ScopeRestriction item : items) {
        ScopeRestrictionBuilder builder = new ScopeRestrictionBuilder(item);
        _visitables.get("scopeRestrictions").remove(builder);
        this.scopeRestrictions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromScopeRestrictions(Predicate<ScopeRestrictionBuilder> predicate) {
    if (scopeRestrictions == null) {
      return (A) this;
    }
    Iterator<ScopeRestrictionBuilder> each = scopeRestrictions.iterator();
    List visitables = _visitables.get("scopeRestrictions");
    while (each.hasNext()) {
        ScopeRestrictionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ScopeRestrictionsNested<A> setNewScopeRestrictionLike(int index,ScopeRestriction item) {
    return new ScopeRestrictionsNested(index, item);
  }
  
  public A setToAdditionalSecrets(int index,String item) {
    if (this.additionalSecrets == null) {
      this.additionalSecrets = new ArrayList();
    }
    this.additionalSecrets.set(index, item);
    return (A) this;
  }
  
  public A setToRedirectURIs(int index,String item) {
    if (this.redirectURIs == null) {
      this.redirectURIs = new ArrayList();
    }
    this.redirectURIs.set(index, item);
    return (A) this;
  }
  
  public A setToScopeRestrictions(int index,ScopeRestriction item) {
    if (this.scopeRestrictions == null) {
      this.scopeRestrictions = new ArrayList();
    }
    ScopeRestrictionBuilder builder = new ScopeRestrictionBuilder(item);
    if (index < 0 || index >= scopeRestrictions.size()) {
        _visitables.get("scopeRestrictions").add(builder);
        scopeRestrictions.add(builder);
    } else {
        _visitables.get("scopeRestrictions").add(builder);
        scopeRestrictions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(accessTokenInactivityTimeoutSeconds == null)) {
        sb.append("accessTokenInactivityTimeoutSeconds:");
        sb.append(accessTokenInactivityTimeoutSeconds);
        sb.append(",");
    }
    if (!(accessTokenMaxAgeSeconds == null)) {
        sb.append("accessTokenMaxAgeSeconds:");
        sb.append(accessTokenMaxAgeSeconds);
        sb.append(",");
    }
    if (!(additionalSecrets == null) && !(additionalSecrets.isEmpty())) {
        sb.append("additionalSecrets:");
        sb.append(additionalSecrets);
        sb.append(",");
    }
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(grantMethod == null)) {
        sb.append("grantMethod:");
        sb.append(grantMethod);
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
    if (!(redirectURIs == null) && !(redirectURIs.isEmpty())) {
        sb.append("redirectURIs:");
        sb.append(redirectURIs);
        sb.append(",");
    }
    if (!(respondWithChallenges == null)) {
        sb.append("respondWithChallenges:");
        sb.append(respondWithChallenges);
        sb.append(",");
    }
    if (!(scopeRestrictions == null) && !(scopeRestrictions.isEmpty())) {
        sb.append("scopeRestrictions:");
        sb.append(scopeRestrictions);
        sb.append(",");
    }
    if (!(secret == null)) {
        sb.append("secret:");
        sb.append(secret);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccessTokenInactivityTimeoutSeconds(Integer accessTokenInactivityTimeoutSeconds) {
    this.accessTokenInactivityTimeoutSeconds = accessTokenInactivityTimeoutSeconds;
    return (A) this;
  }
  
  public A withAccessTokenMaxAgeSeconds(Integer accessTokenMaxAgeSeconds) {
    this.accessTokenMaxAgeSeconds = accessTokenMaxAgeSeconds;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAdditionalSecrets(List<String> additionalSecrets) {
    if (additionalSecrets != null) {
        this.additionalSecrets = new ArrayList();
        for (String item : additionalSecrets) {
          this.addToAdditionalSecrets(item);
        }
    } else {
      this.additionalSecrets = null;
    }
    return (A) this;
  }
  
  public A withAdditionalSecrets(String... additionalSecrets) {
    if (this.additionalSecrets != null) {
        this.additionalSecrets.clear();
        _visitables.remove("additionalSecrets");
    }
    if (additionalSecrets != null) {
      for (String item : additionalSecrets) {
        this.addToAdditionalSecrets(item);
      }
    }
    return (A) this;
  }
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withGrantMethod(String grantMethod) {
    this.grantMethod = grantMethod;
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
  
  public A withRedirectURIs(List<String> redirectURIs) {
    if (redirectURIs != null) {
        this.redirectURIs = new ArrayList();
        for (String item : redirectURIs) {
          this.addToRedirectURIs(item);
        }
    } else {
      this.redirectURIs = null;
    }
    return (A) this;
  }
  
  public A withRedirectURIs(String... redirectURIs) {
    if (this.redirectURIs != null) {
        this.redirectURIs.clear();
        _visitables.remove("redirectURIs");
    }
    if (redirectURIs != null) {
      for (String item : redirectURIs) {
        this.addToRedirectURIs(item);
      }
    }
    return (A) this;
  }
  
  public A withRespondWithChallenges() {
    return withRespondWithChallenges(true);
  }
  
  public A withRespondWithChallenges(Boolean respondWithChallenges) {
    this.respondWithChallenges = respondWithChallenges;
    return (A) this;
  }
  
  public A withScopeRestrictions(List<ScopeRestriction> scopeRestrictions) {
    if (this.scopeRestrictions != null) {
      this._visitables.get("scopeRestrictions").clear();
    }
    if (scopeRestrictions != null) {
        this.scopeRestrictions = new ArrayList();
        for (ScopeRestriction item : scopeRestrictions) {
          this.addToScopeRestrictions(item);
        }
    } else {
      this.scopeRestrictions = null;
    }
    return (A) this;
  }
  
  public A withScopeRestrictions(ScopeRestriction... scopeRestrictions) {
    if (this.scopeRestrictions != null) {
        this.scopeRestrictions.clear();
        _visitables.remove("scopeRestrictions");
    }
    if (scopeRestrictions != null) {
      for (ScopeRestriction item : scopeRestrictions) {
        this.addToScopeRestrictions(item);
      }
    }
    return (A) this;
  }
  
  public A withSecret(String secret) {
    this.secret = secret;
    return (A) this;
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) OAuthClientFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class ScopeRestrictionsNested<N> extends ScopeRestrictionFluent<ScopeRestrictionsNested<N>> implements Nested<N>{
  
    ScopeRestrictionBuilder builder;
    int index;
  
    ScopeRestrictionsNested(int index,ScopeRestriction item) {
      this.index = index;
      this.builder = new ScopeRestrictionBuilder(this, item);
    }
  
    public N and() {
      return (N) OAuthClientFluent.this.setToScopeRestrictions(index, builder.build());
    }
    
    public N endScopeRestriction() {
      return and();
    }
    
  }
}