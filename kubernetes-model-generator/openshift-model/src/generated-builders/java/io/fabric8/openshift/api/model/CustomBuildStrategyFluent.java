package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.EnvVarFluent;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import java.lang.Boolean;
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
public class CustomBuildStrategyFluent<A extends io.fabric8.openshift.api.model.CustomBuildStrategyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String buildAPIVersion;
  private ArrayList<EnvVarBuilder> env = new ArrayList<EnvVarBuilder>();
  private Boolean exposeDockerSocket;
  private Boolean forcePull;
  private ObjectReferenceBuilder from;
  private LocalObjectReferenceBuilder pullSecret;
  private ArrayList<SecretSpecBuilder> secrets = new ArrayList<SecretSpecBuilder>();

  public CustomBuildStrategyFluent() {
  }
  
  public CustomBuildStrategyFluent(CustomBuildStrategy instance) {
    this.copyInstance(instance);
  }

  public A addAllToEnv(Collection<EnvVar> items) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("env").add(builder);
        this.env.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSecrets(Collection<SecretSpec> items) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    for (SecretSpec item : items) {
        SecretSpecBuilder builder = new SecretSpecBuilder(item);
        _visitables.get("secrets").add(builder);
        this.secrets.add(builder);
    }
    return (A) this;
  }
  
  public EnvNested<A> addNewEnv() {
    return new EnvNested(-1, null);
  }
  
  public EnvNested<A> addNewEnvLike(EnvVar item) {
    return new EnvNested(-1, item);
  }
  
  public SecretsNested<A> addNewSecret() {
    return new SecretsNested(-1, null);
  }
  
  public SecretsNested<A> addNewSecretLike(SecretSpec item) {
    return new SecretsNested(-1, item);
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
  
  public A addToEnv(EnvVar... items) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("env").add(builder);
        this.env.add(builder);
    }
    return (A) this;
  }
  
  public A addToEnv(int index,EnvVar item) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= env.size()) {
        _visitables.get("env").add(builder);
        env.add(builder);
    } else {
        _visitables.get("env").add(builder);
        env.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSecrets(SecretSpec... items) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    for (SecretSpec item : items) {
        SecretSpecBuilder builder = new SecretSpecBuilder(item);
        _visitables.get("secrets").add(builder);
        this.secrets.add(builder);
    }
    return (A) this;
  }
  
  public A addToSecrets(int index,SecretSpec item) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    SecretSpecBuilder builder = new SecretSpecBuilder(item);
    if (index < 0 || index >= secrets.size()) {
        _visitables.get("secrets").add(builder);
        secrets.add(builder);
    } else {
        _visitables.get("secrets").add(builder);
        secrets.add(index, builder);
    }
    return (A) this;
  }
  
  public List<EnvVar> buildEnv() {
    return this.env != null ? build(env) : null;
  }
  
  public EnvVar buildEnv(int index) {
    return this.env.get(index).build();
  }
  
  public EnvVar buildFirstEnv() {
    return this.env.get(0).build();
  }
  
  public SecretSpec buildFirstSecret() {
    return this.secrets.get(0).build();
  }
  
  public ObjectReference buildFrom() {
    return this.from != null ? this.from.build() : null;
  }
  
  public EnvVar buildLastEnv() {
    return this.env.get(env.size() - 1).build();
  }
  
  public SecretSpec buildLastSecret() {
    return this.secrets.get(secrets.size() - 1).build();
  }
  
  public EnvVar buildMatchingEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : env) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SecretSpec buildMatchingSecret(Predicate<SecretSpecBuilder> predicate) {
      for (SecretSpecBuilder item : secrets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LocalObjectReference buildPullSecret() {
    return this.pullSecret != null ? this.pullSecret.build() : null;
  }
  
  public SecretSpec buildSecret(int index) {
    return this.secrets.get(index).build();
  }
  
  public List<SecretSpec> buildSecrets() {
    return this.secrets != null ? build(secrets) : null;
  }
  
  protected void copyInstance(CustomBuildStrategy instance) {
    instance = instance != null ? instance : new CustomBuildStrategy();
    if (instance != null) {
        this.withBuildAPIVersion(instance.getBuildAPIVersion());
        this.withEnv(instance.getEnv());
        this.withExposeDockerSocket(instance.getExposeDockerSocket());
        this.withForcePull(instance.getForcePull());
        this.withFrom(instance.getFrom());
        this.withPullSecret(instance.getPullSecret());
        this.withSecrets(instance.getSecrets());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EnvNested<A> editEnv(int index) {
    if (env.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
  }
  
  public EnvNested<A> editFirstEnv() {
    if (env.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "env"));
    }
    return this.setNewEnvLike(0, this.buildEnv(0));
  }
  
  public SecretsNested<A> editFirstSecret() {
    if (secrets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "secrets"));
    }
    return this.setNewSecretLike(0, this.buildSecret(0));
  }
  
  public FromNested<A> editFrom() {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(null));
  }
  
  public EnvNested<A> editLastEnv() {
    int index = env.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
  }
  
  public SecretsNested<A> editLastSecret() {
    int index = secrets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "secrets"));
    }
    return this.setNewSecretLike(index, this.buildSecret(index));
  }
  
  public EnvNested<A> editMatchingEnv(Predicate<EnvVarBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < env.size();i++) {
      if (predicate.test(env.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "env"));
    }
    return this.setNewEnvLike(index, this.buildEnv(index));
  }
  
  public SecretsNested<A> editMatchingSecret(Predicate<SecretSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < secrets.size();i++) {
      if (predicate.test(secrets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "secrets"));
    }
    return this.setNewSecretLike(index, this.buildSecret(index));
  }
  
  public FromNested<A> editOrNewFrom() {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public FromNested<A> editOrNewFromLike(ObjectReference item) {
    return this.withNewFromLike(Optional.ofNullable(this.buildFrom()).orElse(item));
  }
  
  public PullSecretNested<A> editOrNewPullSecret() {
    return this.withNewPullSecretLike(Optional.ofNullable(this.buildPullSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public PullSecretNested<A> editOrNewPullSecretLike(LocalObjectReference item) {
    return this.withNewPullSecretLike(Optional.ofNullable(this.buildPullSecret()).orElse(item));
  }
  
  public PullSecretNested<A> editPullSecret() {
    return this.withNewPullSecretLike(Optional.ofNullable(this.buildPullSecret()).orElse(null));
  }
  
  public SecretsNested<A> editSecret(int index) {
    if (secrets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "secrets"));
    }
    return this.setNewSecretLike(index, this.buildSecret(index));
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
    CustomBuildStrategyFluent that = (CustomBuildStrategyFluent) o;
    if (!(Objects.equals(buildAPIVersion, that.buildAPIVersion))) {
      return false;
    }
    if (!(Objects.equals(env, that.env))) {
      return false;
    }
    if (!(Objects.equals(exposeDockerSocket, that.exposeDockerSocket))) {
      return false;
    }
    if (!(Objects.equals(forcePull, that.forcePull))) {
      return false;
    }
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(pullSecret, that.pullSecret))) {
      return false;
    }
    if (!(Objects.equals(secrets, that.secrets))) {
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
  
  public String getBuildAPIVersion() {
    return this.buildAPIVersion;
  }
  
  public Boolean getExposeDockerSocket() {
    return this.exposeDockerSocket;
  }
  
  public Boolean getForcePull() {
    return this.forcePull;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBuildAPIVersion() {
    return this.buildAPIVersion != null;
  }
  
  public boolean hasEnv() {
    return this.env != null && !(this.env.isEmpty());
  }
  
  public boolean hasExposeDockerSocket() {
    return this.exposeDockerSocket != null;
  }
  
  public boolean hasForcePull() {
    return this.forcePull != null;
  }
  
  public boolean hasFrom() {
    return this.from != null;
  }
  
  public boolean hasMatchingEnv(Predicate<EnvVarBuilder> predicate) {
      for (EnvVarBuilder item : env) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSecret(Predicate<SecretSpecBuilder> predicate) {
      for (SecretSpecBuilder item : secrets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPullSecret() {
    return this.pullSecret != null;
  }
  
  public boolean hasSecrets() {
    return this.secrets != null && !(this.secrets.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(buildAPIVersion, env, exposeDockerSocket, forcePull, from, pullSecret, secrets, additionalProperties);
  }
  
  public A removeAllFromEnv(Collection<EnvVar> items) {
    if (this.env == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("env").remove(builder);
        this.env.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSecrets(Collection<SecretSpec> items) {
    if (this.secrets == null) {
      return (A) this;
    }
    for (SecretSpec item : items) {
        SecretSpecBuilder builder = new SecretSpecBuilder(item);
        _visitables.get("secrets").remove(builder);
        this.secrets.remove(builder);
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
  
  public A removeFromEnv(EnvVar... items) {
    if (this.env == null) {
      return (A) this;
    }
    for (EnvVar item : items) {
        EnvVarBuilder builder = new EnvVarBuilder(item);
        _visitables.get("env").remove(builder);
        this.env.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSecrets(SecretSpec... items) {
    if (this.secrets == null) {
      return (A) this;
    }
    for (SecretSpec item : items) {
        SecretSpecBuilder builder = new SecretSpecBuilder(item);
        _visitables.get("secrets").remove(builder);
        this.secrets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEnv(Predicate<EnvVarBuilder> predicate) {
    if (env == null) {
      return (A) this;
    }
    Iterator<EnvVarBuilder> each = env.iterator();
    List visitables = _visitables.get("env");
    while (each.hasNext()) {
        EnvVarBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSecrets(Predicate<SecretSpecBuilder> predicate) {
    if (secrets == null) {
      return (A) this;
    }
    Iterator<SecretSpecBuilder> each = secrets.iterator();
    List visitables = _visitables.get("secrets");
    while (each.hasNext()) {
        SecretSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EnvNested<A> setNewEnvLike(int index,EnvVar item) {
    return new EnvNested(index, item);
  }
  
  public SecretsNested<A> setNewSecretLike(int index,SecretSpec item) {
    return new SecretsNested(index, item);
  }
  
  public A setToEnv(int index,EnvVar item) {
    if (this.env == null) {
      this.env = new ArrayList();
    }
    EnvVarBuilder builder = new EnvVarBuilder(item);
    if (index < 0 || index >= env.size()) {
        _visitables.get("env").add(builder);
        env.add(builder);
    } else {
        _visitables.get("env").add(builder);
        env.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSecrets(int index,SecretSpec item) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    SecretSpecBuilder builder = new SecretSpecBuilder(item);
    if (index < 0 || index >= secrets.size()) {
        _visitables.get("secrets").add(builder);
        secrets.add(builder);
    } else {
        _visitables.get("secrets").add(builder);
        secrets.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(buildAPIVersion == null)) {
        sb.append("buildAPIVersion:");
        sb.append(buildAPIVersion);
        sb.append(",");
    }
    if (!(env == null) && !(env.isEmpty())) {
        sb.append("env:");
        sb.append(env);
        sb.append(",");
    }
    if (!(exposeDockerSocket == null)) {
        sb.append("exposeDockerSocket:");
        sb.append(exposeDockerSocket);
        sb.append(",");
    }
    if (!(forcePull == null)) {
        sb.append("forcePull:");
        sb.append(forcePull);
        sb.append(",");
    }
    if (!(from == null)) {
        sb.append("from:");
        sb.append(from);
        sb.append(",");
    }
    if (!(pullSecret == null)) {
        sb.append("pullSecret:");
        sb.append(pullSecret);
        sb.append(",");
    }
    if (!(secrets == null) && !(secrets.isEmpty())) {
        sb.append("secrets:");
        sb.append(secrets);
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
  
  public A withBuildAPIVersion(String buildAPIVersion) {
    this.buildAPIVersion = buildAPIVersion;
    return (A) this;
  }
  
  public A withEnv(List<EnvVar> env) {
    if (this.env != null) {
      this._visitables.get("env").clear();
    }
    if (env != null) {
        this.env = new ArrayList();
        for (EnvVar item : env) {
          this.addToEnv(item);
        }
    } else {
      this.env = null;
    }
    return (A) this;
  }
  
  public A withEnv(EnvVar... env) {
    if (this.env != null) {
        this.env.clear();
        _visitables.remove("env");
    }
    if (env != null) {
      for (EnvVar item : env) {
        this.addToEnv(item);
      }
    }
    return (A) this;
  }
  
  public A withExposeDockerSocket() {
    return withExposeDockerSocket(true);
  }
  
  public A withExposeDockerSocket(Boolean exposeDockerSocket) {
    this.exposeDockerSocket = exposeDockerSocket;
    return (A) this;
  }
  
  public A withForcePull() {
    return withForcePull(true);
  }
  
  public A withForcePull(Boolean forcePull) {
    this.forcePull = forcePull;
    return (A) this;
  }
  
  public A withFrom(ObjectReference from) {
    this._visitables.remove("from");
    if (from != null) {
        this.from = new ObjectReferenceBuilder(from);
        this._visitables.get("from").add(this.from);
    } else {
        this.from = null;
        this._visitables.get("from").remove(this.from);
    }
    return (A) this;
  }
  
  public FromNested<A> withNewFrom() {
    return new FromNested(null);
  }
  
  public FromNested<A> withNewFromLike(ObjectReference item) {
    return new FromNested(item);
  }
  
  public PullSecretNested<A> withNewPullSecret() {
    return new PullSecretNested(null);
  }
  
  public A withNewPullSecret(String name) {
    return (A) this.withPullSecret(new LocalObjectReference(name));
  }
  
  public PullSecretNested<A> withNewPullSecretLike(LocalObjectReference item) {
    return new PullSecretNested(item);
  }
  
  public A withPullSecret(LocalObjectReference pullSecret) {
    this._visitables.remove("pullSecret");
    if (pullSecret != null) {
        this.pullSecret = new LocalObjectReferenceBuilder(pullSecret);
        this._visitables.get("pullSecret").add(this.pullSecret);
    } else {
        this.pullSecret = null;
        this._visitables.get("pullSecret").remove(this.pullSecret);
    }
    return (A) this;
  }
  
  public A withSecrets(List<SecretSpec> secrets) {
    if (this.secrets != null) {
      this._visitables.get("secrets").clear();
    }
    if (secrets != null) {
        this.secrets = new ArrayList();
        for (SecretSpec item : secrets) {
          this.addToSecrets(item);
        }
    } else {
      this.secrets = null;
    }
    return (A) this;
  }
  
  public A withSecrets(SecretSpec... secrets) {
    if (this.secrets != null) {
        this.secrets.clear();
        _visitables.remove("secrets");
    }
    if (secrets != null) {
      for (SecretSpec item : secrets) {
        this.addToSecrets(item);
      }
    }
    return (A) this;
  }
  public class EnvNested<N> extends EnvVarFluent<EnvNested<N>> implements Nested<N>{
  
    EnvVarBuilder builder;
    int index;
  
    EnvNested(int index,EnvVar item) {
      this.index = index;
      this.builder = new EnvVarBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomBuildStrategyFluent.this.setToEnv(index, builder.build());
    }
    
    public N endEnv() {
      return and();
    }
    
  }
  public class FromNested<N> extends ObjectReferenceFluent<FromNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    FromNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomBuildStrategyFluent.this.withFrom(builder.build());
    }
    
    public N endFrom() {
      return and();
    }
    
  }
  public class PullSecretNested<N> extends LocalObjectReferenceFluent<PullSecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    PullSecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomBuildStrategyFluent.this.withPullSecret(builder.build());
    }
    
    public N endPullSecret() {
      return and();
    }
    
  }
  public class SecretsNested<N> extends SecretSpecFluent<SecretsNested<N>> implements Nested<N>{
  
    SecretSpecBuilder builder;
    int index;
  
    SecretsNested(int index,SecretSpec item) {
      this.index = index;
      this.builder = new SecretSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomBuildStrategyFluent.this.setToSecrets(index, builder.build());
    }
    
    public N endSecret() {
      return and();
    }
    
  }
}