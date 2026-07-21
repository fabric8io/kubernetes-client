package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.knative.duck.v1.CloudEventOverrides;
import io.fabric8.knative.duck.v1.CloudEventOverridesBuilder;
import io.fabric8.knative.duck.v1.CloudEventOverridesFluent;
import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.duck.v1.DestinationBuilder;
import io.fabric8.knative.duck.v1.DestinationFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class GitHubSourceSpecFluent<A extends io.fabric8.knative.sources.v1alpha1.GitHubSourceSpecFluent<A>> extends BaseFluent<A>{

  private SecretValueFromSourceBuilder accessToken;
  private Map<String,Object> additionalProperties;
  private CloudEventOverridesBuilder ceOverrides;
  private List<String> eventTypes = new ArrayList<String>();
  private String githubAPIURL;
  private String ownerAndRepository;
  private SecretValueFromSourceBuilder secretToken;
  private Boolean secure;
  private String serviceAccountName;
  private DestinationBuilder sink;

  public GitHubSourceSpecFluent() {
  }
  
  public GitHubSourceSpecFluent(GitHubSourceSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToEventTypes(Collection<String> items) {
    if (this.eventTypes == null) {
      this.eventTypes = new ArrayList();
    }
    for (String item : items) {
      this.eventTypes.add(item);
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
  
  public A addToEventTypes(String... items) {
    if (this.eventTypes == null) {
      this.eventTypes = new ArrayList();
    }
    for (String item : items) {
      this.eventTypes.add(item);
    }
    return (A) this;
  }
  
  public A addToEventTypes(int index,String item) {
    if (this.eventTypes == null) {
      this.eventTypes = new ArrayList();
    }
    this.eventTypes.add(index, item);
    return (A) this;
  }
  
  public SecretValueFromSource buildAccessToken() {
    return this.accessToken != null ? this.accessToken.build() : null;
  }
  
  public CloudEventOverrides buildCeOverrides() {
    return this.ceOverrides != null ? this.ceOverrides.build() : null;
  }
  
  public SecretValueFromSource buildSecretToken() {
    return this.secretToken != null ? this.secretToken.build() : null;
  }
  
  public Destination buildSink() {
    return this.sink != null ? this.sink.build() : null;
  }
  
  protected void copyInstance(GitHubSourceSpec instance) {
    instance = instance != null ? instance : new GitHubSourceSpec();
    if (instance != null) {
        this.withAccessToken(instance.getAccessToken());
        this.withCeOverrides(instance.getCeOverrides());
        this.withEventTypes(instance.getEventTypes());
        this.withGithubAPIURL(instance.getGithubAPIURL());
        this.withOwnerAndRepository(instance.getOwnerAndRepository());
        this.withSecretToken(instance.getSecretToken());
        this.withSecure(instance.getSecure());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withSink(instance.getSink());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AccessTokenNested<A> editAccessToken() {
    return this.withNewAccessTokenLike(Optional.ofNullable(this.buildAccessToken()).orElse(null));
  }
  
  public CeOverridesNested<A> editCeOverrides() {
    return this.withNewCeOverridesLike(Optional.ofNullable(this.buildCeOverrides()).orElse(null));
  }
  
  public AccessTokenNested<A> editOrNewAccessToken() {
    return this.withNewAccessTokenLike(Optional.ofNullable(this.buildAccessToken()).orElse(new SecretValueFromSourceBuilder().build()));
  }
  
  public AccessTokenNested<A> editOrNewAccessTokenLike(SecretValueFromSource item) {
    return this.withNewAccessTokenLike(Optional.ofNullable(this.buildAccessToken()).orElse(item));
  }
  
  public CeOverridesNested<A> editOrNewCeOverrides() {
    return this.withNewCeOverridesLike(Optional.ofNullable(this.buildCeOverrides()).orElse(new CloudEventOverridesBuilder().build()));
  }
  
  public CeOverridesNested<A> editOrNewCeOverridesLike(CloudEventOverrides item) {
    return this.withNewCeOverridesLike(Optional.ofNullable(this.buildCeOverrides()).orElse(item));
  }
  
  public SecretTokenNested<A> editOrNewSecretToken() {
    return this.withNewSecretTokenLike(Optional.ofNullable(this.buildSecretToken()).orElse(new SecretValueFromSourceBuilder().build()));
  }
  
  public SecretTokenNested<A> editOrNewSecretTokenLike(SecretValueFromSource item) {
    return this.withNewSecretTokenLike(Optional.ofNullable(this.buildSecretToken()).orElse(item));
  }
  
  public SinkNested<A> editOrNewSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(new DestinationBuilder().build()));
  }
  
  public SinkNested<A> editOrNewSinkLike(Destination item) {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(item));
  }
  
  public SecretTokenNested<A> editSecretToken() {
    return this.withNewSecretTokenLike(Optional.ofNullable(this.buildSecretToken()).orElse(null));
  }
  
  public SinkNested<A> editSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(null));
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
    GitHubSourceSpecFluent that = (GitHubSourceSpecFluent) o;
    if (!(Objects.equals(accessToken, that.accessToken))) {
      return false;
    }
    if (!(Objects.equals(ceOverrides, that.ceOverrides))) {
      return false;
    }
    if (!(Objects.equals(eventTypes, that.eventTypes))) {
      return false;
    }
    if (!(Objects.equals(githubAPIURL, that.githubAPIURL))) {
      return false;
    }
    if (!(Objects.equals(ownerAndRepository, that.ownerAndRepository))) {
      return false;
    }
    if (!(Objects.equals(secretToken, that.secretToken))) {
      return false;
    }
    if (!(Objects.equals(secure, that.secure))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(sink, that.sink))) {
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
  
  public String getEventType(int index) {
    return this.eventTypes.get(index);
  }
  
  public List<String> getEventTypes() {
    return this.eventTypes;
  }
  
  public String getFirstEventType() {
    return this.eventTypes.get(0);
  }
  
  public String getGithubAPIURL() {
    return this.githubAPIURL;
  }
  
  public String getLastEventType() {
    return this.eventTypes.get(eventTypes.size() - 1);
  }
  
  public String getMatchingEventType(Predicate<String> predicate) {
      for (String item : eventTypes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOwnerAndRepository() {
    return this.ownerAndRepository;
  }
  
  public Boolean getSecure() {
    return this.secure;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public boolean hasAccessToken() {
    return this.accessToken != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCeOverrides() {
    return this.ceOverrides != null;
  }
  
  public boolean hasEventTypes() {
    return this.eventTypes != null && !(this.eventTypes.isEmpty());
  }
  
  public boolean hasGithubAPIURL() {
    return this.githubAPIURL != null;
  }
  
  public boolean hasMatchingEventType(Predicate<String> predicate) {
      for (String item : eventTypes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOwnerAndRepository() {
    return this.ownerAndRepository != null;
  }
  
  public boolean hasSecretToken() {
    return this.secretToken != null;
  }
  
  public boolean hasSecure() {
    return this.secure != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasSink() {
    return this.sink != null;
  }
  
  public int hashCode() {
    return Objects.hash(accessToken, ceOverrides, eventTypes, githubAPIURL, ownerAndRepository, secretToken, secure, serviceAccountName, sink, additionalProperties);
  }
  
  public A removeAllFromEventTypes(Collection<String> items) {
    if (this.eventTypes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.eventTypes.remove(item);
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
  
  public A removeFromEventTypes(String... items) {
    if (this.eventTypes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.eventTypes.remove(item);
    }
    return (A) this;
  }
  
  public A setToEventTypes(int index,String item) {
    if (this.eventTypes == null) {
      this.eventTypes = new ArrayList();
    }
    this.eventTypes.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(accessToken == null)) {
        sb.append("accessToken:");
        sb.append(accessToken);
        sb.append(",");
    }
    if (!(ceOverrides == null)) {
        sb.append("ceOverrides:");
        sb.append(ceOverrides);
        sb.append(",");
    }
    if (!(eventTypes == null) && !(eventTypes.isEmpty())) {
        sb.append("eventTypes:");
        sb.append(eventTypes);
        sb.append(",");
    }
    if (!(githubAPIURL == null)) {
        sb.append("githubAPIURL:");
        sb.append(githubAPIURL);
        sb.append(",");
    }
    if (!(ownerAndRepository == null)) {
        sb.append("ownerAndRepository:");
        sb.append(ownerAndRepository);
        sb.append(",");
    }
    if (!(secretToken == null)) {
        sb.append("secretToken:");
        sb.append(secretToken);
        sb.append(",");
    }
    if (!(secure == null)) {
        sb.append("secure:");
        sb.append(secure);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(sink == null)) {
        sb.append("sink:");
        sb.append(sink);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccessToken(SecretValueFromSource accessToken) {
    this._visitables.remove("accessToken");
    if (accessToken != null) {
        this.accessToken = new SecretValueFromSourceBuilder(accessToken);
        this._visitables.get("accessToken").add(this.accessToken);
    } else {
        this.accessToken = null;
        this._visitables.get("accessToken").remove(this.accessToken);
    }
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
  
  public A withCeOverrides(CloudEventOverrides ceOverrides) {
    this._visitables.remove("ceOverrides");
    if (ceOverrides != null) {
        this.ceOverrides = new CloudEventOverridesBuilder(ceOverrides);
        this._visitables.get("ceOverrides").add(this.ceOverrides);
    } else {
        this.ceOverrides = null;
        this._visitables.get("ceOverrides").remove(this.ceOverrides);
    }
    return (A) this;
  }
  
  public A withEventTypes(List<String> eventTypes) {
    if (eventTypes != null) {
        this.eventTypes = new ArrayList();
        for (String item : eventTypes) {
          this.addToEventTypes(item);
        }
    } else {
      this.eventTypes = null;
    }
    return (A) this;
  }
  
  public A withEventTypes(String... eventTypes) {
    if (this.eventTypes != null) {
        this.eventTypes.clear();
        _visitables.remove("eventTypes");
    }
    if (eventTypes != null) {
      for (String item : eventTypes) {
        this.addToEventTypes(item);
      }
    }
    return (A) this;
  }
  
  public A withGithubAPIURL(String githubAPIURL) {
    this.githubAPIURL = githubAPIURL;
    return (A) this;
  }
  
  public AccessTokenNested<A> withNewAccessToken() {
    return new AccessTokenNested(null);
  }
  
  public AccessTokenNested<A> withNewAccessTokenLike(SecretValueFromSource item) {
    return new AccessTokenNested(item);
  }
  
  public CeOverridesNested<A> withNewCeOverrides() {
    return new CeOverridesNested(null);
  }
  
  public CeOverridesNested<A> withNewCeOverridesLike(CloudEventOverrides item) {
    return new CeOverridesNested(item);
  }
  
  public SecretTokenNested<A> withNewSecretToken() {
    return new SecretTokenNested(null);
  }
  
  public SecretTokenNested<A> withNewSecretTokenLike(SecretValueFromSource item) {
    return new SecretTokenNested(item);
  }
  
  public SinkNested<A> withNewSink() {
    return new SinkNested(null);
  }
  
  public SinkNested<A> withNewSinkLike(Destination item) {
    return new SinkNested(item);
  }
  
  public A withOwnerAndRepository(String ownerAndRepository) {
    this.ownerAndRepository = ownerAndRepository;
    return (A) this;
  }
  
  public A withSecretToken(SecretValueFromSource secretToken) {
    this._visitables.remove("secretToken");
    if (secretToken != null) {
        this.secretToken = new SecretValueFromSourceBuilder(secretToken);
        this._visitables.get("secretToken").add(this.secretToken);
    } else {
        this.secretToken = null;
        this._visitables.get("secretToken").remove(this.secretToken);
    }
    return (A) this;
  }
  
  public A withSecure() {
    return withSecure(true);
  }
  
  public A withSecure(Boolean secure) {
    this.secure = secure;
    return (A) this;
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  
  public A withSink(Destination sink) {
    this._visitables.remove("sink");
    if (sink != null) {
        this.sink = new DestinationBuilder(sink);
        this._visitables.get("sink").add(this.sink);
    } else {
        this.sink = null;
        this._visitables.get("sink").remove(this.sink);
    }
    return (A) this;
  }
  public class AccessTokenNested<N> extends SecretValueFromSourceFluent<AccessTokenNested<N>> implements Nested<N>{
  
    SecretValueFromSourceBuilder builder;
  
    AccessTokenNested(SecretValueFromSource item) {
      this.builder = new SecretValueFromSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) GitHubSourceSpecFluent.this.withAccessToken(builder.build());
    }
    
    public N endAccessToken() {
      return and();
    }
    
  }
  public class CeOverridesNested<N> extends CloudEventOverridesFluent<CeOverridesNested<N>> implements Nested<N>{
  
    CloudEventOverridesBuilder builder;
  
    CeOverridesNested(CloudEventOverrides item) {
      this.builder = new CloudEventOverridesBuilder(this, item);
    }
  
    public N and() {
      return (N) GitHubSourceSpecFluent.this.withCeOverrides(builder.build());
    }
    
    public N endCeOverrides() {
      return and();
    }
    
  }
  public class SecretTokenNested<N> extends SecretValueFromSourceFluent<SecretTokenNested<N>> implements Nested<N>{
  
    SecretValueFromSourceBuilder builder;
  
    SecretTokenNested(SecretValueFromSource item) {
      this.builder = new SecretValueFromSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) GitHubSourceSpecFluent.this.withSecretToken(builder.build());
    }
    
    public N endSecretToken() {
      return and();
    }
    
  }
  public class SinkNested<N> extends DestinationFluent<SinkNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    SinkNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) GitHubSourceSpecFluent.this.withSink(builder.build());
    }
    
    public N endSink() {
      return and();
    }
    
  }
}