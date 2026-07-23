package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class LocalSecretsConfigFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.LocalSecretsConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer hubConnectionTimeoutSeconds;
  private ArrayList<KubeConfigSecretBuilder> kubeConfigSecrets = new ArrayList<KubeConfigSecretBuilder>();

  public LocalSecretsConfigFluent() {
  }
  
  public LocalSecretsConfigFluent(LocalSecretsConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToKubeConfigSecrets(Collection<KubeConfigSecret> items) {
    if (this.kubeConfigSecrets == null) {
      this.kubeConfigSecrets = new ArrayList();
    }
    for (KubeConfigSecret item : items) {
        KubeConfigSecretBuilder builder = new KubeConfigSecretBuilder(item);
        _visitables.get("kubeConfigSecrets").add(builder);
        this.kubeConfigSecrets.add(builder);
    }
    return (A) this;
  }
  
  public KubeConfigSecretsNested<A> addNewKubeConfigSecret() {
    return new KubeConfigSecretsNested(-1, null);
  }
  
  public A addNewKubeConfigSecret(String name) {
    return (A) this.addToKubeConfigSecrets(new KubeConfigSecret(name));
  }
  
  public KubeConfigSecretsNested<A> addNewKubeConfigSecretLike(KubeConfigSecret item) {
    return new KubeConfigSecretsNested(-1, item);
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
  
  public A addToKubeConfigSecrets(KubeConfigSecret... items) {
    if (this.kubeConfigSecrets == null) {
      this.kubeConfigSecrets = new ArrayList();
    }
    for (KubeConfigSecret item : items) {
        KubeConfigSecretBuilder builder = new KubeConfigSecretBuilder(item);
        _visitables.get("kubeConfigSecrets").add(builder);
        this.kubeConfigSecrets.add(builder);
    }
    return (A) this;
  }
  
  public A addToKubeConfigSecrets(int index,KubeConfigSecret item) {
    if (this.kubeConfigSecrets == null) {
      this.kubeConfigSecrets = new ArrayList();
    }
    KubeConfigSecretBuilder builder = new KubeConfigSecretBuilder(item);
    if (index < 0 || index >= kubeConfigSecrets.size()) {
        _visitables.get("kubeConfigSecrets").add(builder);
        kubeConfigSecrets.add(builder);
    } else {
        _visitables.get("kubeConfigSecrets").add(builder);
        kubeConfigSecrets.add(index, builder);
    }
    return (A) this;
  }
  
  public KubeConfigSecret buildFirstKubeConfigSecret() {
    return this.kubeConfigSecrets.get(0).build();
  }
  
  public KubeConfigSecret buildKubeConfigSecret(int index) {
    return this.kubeConfigSecrets.get(index).build();
  }
  
  public List<KubeConfigSecret> buildKubeConfigSecrets() {
    return this.kubeConfigSecrets != null ? build(kubeConfigSecrets) : null;
  }
  
  public KubeConfigSecret buildLastKubeConfigSecret() {
    return this.kubeConfigSecrets.get(kubeConfigSecrets.size() - 1).build();
  }
  
  public KubeConfigSecret buildMatchingKubeConfigSecret(Predicate<KubeConfigSecretBuilder> predicate) {
      for (KubeConfigSecretBuilder item : kubeConfigSecrets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(LocalSecretsConfig instance) {
    instance = instance != null ? instance : new LocalSecretsConfig();
    if (instance != null) {
        this.withHubConnectionTimeoutSeconds(instance.getHubConnectionTimeoutSeconds());
        this.withKubeConfigSecrets(instance.getKubeConfigSecrets());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public KubeConfigSecretsNested<A> editFirstKubeConfigSecret() {
    if (kubeConfigSecrets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "kubeConfigSecrets"));
    }
    return this.setNewKubeConfigSecretLike(0, this.buildKubeConfigSecret(0));
  }
  
  public KubeConfigSecretsNested<A> editKubeConfigSecret(int index) {
    if (kubeConfigSecrets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "kubeConfigSecrets"));
    }
    return this.setNewKubeConfigSecretLike(index, this.buildKubeConfigSecret(index));
  }
  
  public KubeConfigSecretsNested<A> editLastKubeConfigSecret() {
    int index = kubeConfigSecrets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "kubeConfigSecrets"));
    }
    return this.setNewKubeConfigSecretLike(index, this.buildKubeConfigSecret(index));
  }
  
  public KubeConfigSecretsNested<A> editMatchingKubeConfigSecret(Predicate<KubeConfigSecretBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < kubeConfigSecrets.size();i++) {
      if (predicate.test(kubeConfigSecrets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "kubeConfigSecrets"));
    }
    return this.setNewKubeConfigSecretLike(index, this.buildKubeConfigSecret(index));
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
    LocalSecretsConfigFluent that = (LocalSecretsConfigFluent) o;
    if (!(Objects.equals(hubConnectionTimeoutSeconds, that.hubConnectionTimeoutSeconds))) {
      return false;
    }
    if (!(Objects.equals(kubeConfigSecrets, that.kubeConfigSecrets))) {
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
  
  public Integer getHubConnectionTimeoutSeconds() {
    return this.hubConnectionTimeoutSeconds;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHubConnectionTimeoutSeconds() {
    return this.hubConnectionTimeoutSeconds != null;
  }
  
  public boolean hasKubeConfigSecrets() {
    return this.kubeConfigSecrets != null && !(this.kubeConfigSecrets.isEmpty());
  }
  
  public boolean hasMatchingKubeConfigSecret(Predicate<KubeConfigSecretBuilder> predicate) {
      for (KubeConfigSecretBuilder item : kubeConfigSecrets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(hubConnectionTimeoutSeconds, kubeConfigSecrets, additionalProperties);
  }
  
  public A removeAllFromKubeConfigSecrets(Collection<KubeConfigSecret> items) {
    if (this.kubeConfigSecrets == null) {
      return (A) this;
    }
    for (KubeConfigSecret item : items) {
        KubeConfigSecretBuilder builder = new KubeConfigSecretBuilder(item);
        _visitables.get("kubeConfigSecrets").remove(builder);
        this.kubeConfigSecrets.remove(builder);
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
  
  public A removeFromKubeConfigSecrets(KubeConfigSecret... items) {
    if (this.kubeConfigSecrets == null) {
      return (A) this;
    }
    for (KubeConfigSecret item : items) {
        KubeConfigSecretBuilder builder = new KubeConfigSecretBuilder(item);
        _visitables.get("kubeConfigSecrets").remove(builder);
        this.kubeConfigSecrets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromKubeConfigSecrets(Predicate<KubeConfigSecretBuilder> predicate) {
    if (kubeConfigSecrets == null) {
      return (A) this;
    }
    Iterator<KubeConfigSecretBuilder> each = kubeConfigSecrets.iterator();
    List visitables = _visitables.get("kubeConfigSecrets");
    while (each.hasNext()) {
        KubeConfigSecretBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public KubeConfigSecretsNested<A> setNewKubeConfigSecretLike(int index,KubeConfigSecret item) {
    return new KubeConfigSecretsNested(index, item);
  }
  
  public A setToKubeConfigSecrets(int index,KubeConfigSecret item) {
    if (this.kubeConfigSecrets == null) {
      this.kubeConfigSecrets = new ArrayList();
    }
    KubeConfigSecretBuilder builder = new KubeConfigSecretBuilder(item);
    if (index < 0 || index >= kubeConfigSecrets.size()) {
        _visitables.get("kubeConfigSecrets").add(builder);
        kubeConfigSecrets.add(builder);
    } else {
        _visitables.get("kubeConfigSecrets").add(builder);
        kubeConfigSecrets.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(hubConnectionTimeoutSeconds == null)) {
        sb.append("hubConnectionTimeoutSeconds:");
        sb.append(hubConnectionTimeoutSeconds);
        sb.append(",");
    }
    if (!(kubeConfigSecrets == null) && !(kubeConfigSecrets.isEmpty())) {
        sb.append("kubeConfigSecrets:");
        sb.append(kubeConfigSecrets);
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
  
  public A withHubConnectionTimeoutSeconds(Integer hubConnectionTimeoutSeconds) {
    this.hubConnectionTimeoutSeconds = hubConnectionTimeoutSeconds;
    return (A) this;
  }
  
  public A withKubeConfigSecrets(List<KubeConfigSecret> kubeConfigSecrets) {
    if (this.kubeConfigSecrets != null) {
      this._visitables.get("kubeConfigSecrets").clear();
    }
    if (kubeConfigSecrets != null) {
        this.kubeConfigSecrets = new ArrayList();
        for (KubeConfigSecret item : kubeConfigSecrets) {
          this.addToKubeConfigSecrets(item);
        }
    } else {
      this.kubeConfigSecrets = null;
    }
    return (A) this;
  }
  
  public A withKubeConfigSecrets(KubeConfigSecret... kubeConfigSecrets) {
    if (this.kubeConfigSecrets != null) {
        this.kubeConfigSecrets.clear();
        _visitables.remove("kubeConfigSecrets");
    }
    if (kubeConfigSecrets != null) {
      for (KubeConfigSecret item : kubeConfigSecrets) {
        this.addToKubeConfigSecrets(item);
      }
    }
    return (A) this;
  }
  public class KubeConfigSecretsNested<N> extends KubeConfigSecretFluent<KubeConfigSecretsNested<N>> implements Nested<N>{
  
    KubeConfigSecretBuilder builder;
    int index;
  
    KubeConfigSecretsNested(int index,KubeConfigSecret item) {
      this.index = index;
      this.builder = new KubeConfigSecretBuilder(this, item);
    }
  
    public N and() {
      return (N) LocalSecretsConfigFluent.this.setToKubeConfigSecrets(index, builder.build());
    }
    
    public N endKubeConfigSecret() {
      return and();
    }
    
  }
}