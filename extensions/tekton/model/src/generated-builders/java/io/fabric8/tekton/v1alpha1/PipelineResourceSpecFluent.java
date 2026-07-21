package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class PipelineResourceSpecFluent<A extends io.fabric8.tekton.v1alpha1.PipelineResourceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String description;
  private ArrayList<ResourceParamBuilder> params = new ArrayList<ResourceParamBuilder>();
  private ArrayList<SecretParamBuilder> secrets = new ArrayList<SecretParamBuilder>();
  private String type;

  public PipelineResourceSpecFluent() {
  }
  
  public PipelineResourceSpecFluent(PipelineResourceSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToParams(Collection<ResourceParam> items) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    for (ResourceParam item : items) {
        ResourceParamBuilder builder = new ResourceParamBuilder(item);
        _visitables.get("params").add(builder);
        this.params.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSecrets(Collection<SecretParam> items) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    for (SecretParam item : items) {
        SecretParamBuilder builder = new SecretParamBuilder(item);
        _visitables.get("secrets").add(builder);
        this.secrets.add(builder);
    }
    return (A) this;
  }
  
  public ParamsNested<A> addNewParam() {
    return new ParamsNested(-1, null);
  }
  
  public A addNewParam(String name,String value) {
    return (A) this.addToParams(new ResourceParam(name, value));
  }
  
  public ParamsNested<A> addNewParamLike(ResourceParam item) {
    return new ParamsNested(-1, item);
  }
  
  public SecretsNested<A> addNewSecret() {
    return new SecretsNested(-1, null);
  }
  
  public A addNewSecret(String fieldName,String secretKey,String secretName) {
    return (A) this.addToSecrets(new SecretParam(fieldName, secretKey, secretName));
  }
  
  public SecretsNested<A> addNewSecretLike(SecretParam item) {
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
  
  public A addToParams(ResourceParam... items) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    for (ResourceParam item : items) {
        ResourceParamBuilder builder = new ResourceParamBuilder(item);
        _visitables.get("params").add(builder);
        this.params.add(builder);
    }
    return (A) this;
  }
  
  public A addToParams(int index,ResourceParam item) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    ResourceParamBuilder builder = new ResourceParamBuilder(item);
    if (index < 0 || index >= params.size()) {
        _visitables.get("params").add(builder);
        params.add(builder);
    } else {
        _visitables.get("params").add(builder);
        params.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSecrets(SecretParam... items) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    for (SecretParam item : items) {
        SecretParamBuilder builder = new SecretParamBuilder(item);
        _visitables.get("secrets").add(builder);
        this.secrets.add(builder);
    }
    return (A) this;
  }
  
  public A addToSecrets(int index,SecretParam item) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    SecretParamBuilder builder = new SecretParamBuilder(item);
    if (index < 0 || index >= secrets.size()) {
        _visitables.get("secrets").add(builder);
        secrets.add(builder);
    } else {
        _visitables.get("secrets").add(builder);
        secrets.add(index, builder);
    }
    return (A) this;
  }
  
  public ResourceParam buildFirstParam() {
    return this.params.get(0).build();
  }
  
  public SecretParam buildFirstSecret() {
    return this.secrets.get(0).build();
  }
  
  public ResourceParam buildLastParam() {
    return this.params.get(params.size() - 1).build();
  }
  
  public SecretParam buildLastSecret() {
    return this.secrets.get(secrets.size() - 1).build();
  }
  
  public ResourceParam buildMatchingParam(Predicate<ResourceParamBuilder> predicate) {
      for (ResourceParamBuilder item : params) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SecretParam buildMatchingSecret(Predicate<SecretParamBuilder> predicate) {
      for (SecretParamBuilder item : secrets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ResourceParam buildParam(int index) {
    return this.params.get(index).build();
  }
  
  public List<ResourceParam> buildParams() {
    return this.params != null ? build(params) : null;
  }
  
  public SecretParam buildSecret(int index) {
    return this.secrets.get(index).build();
  }
  
  public List<SecretParam> buildSecrets() {
    return this.secrets != null ? build(secrets) : null;
  }
  
  protected void copyInstance(PipelineResourceSpec instance) {
    instance = instance != null ? instance : new PipelineResourceSpec();
    if (instance != null) {
        this.withDescription(instance.getDescription());
        this.withParams(instance.getParams());
        this.withSecrets(instance.getSecrets());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ParamsNested<A> editFirstParam() {
    if (params.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(0, this.buildParam(0));
  }
  
  public SecretsNested<A> editFirstSecret() {
    if (secrets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "secrets"));
    }
    return this.setNewSecretLike(0, this.buildSecret(0));
  }
  
  public ParamsNested<A> editLastParam() {
    int index = params.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public SecretsNested<A> editLastSecret() {
    int index = secrets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "secrets"));
    }
    return this.setNewSecretLike(index, this.buildSecret(index));
  }
  
  public ParamsNested<A> editMatchingParam(Predicate<ResourceParamBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < params.size();i++) {
      if (predicate.test(params.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
  }
  
  public SecretsNested<A> editMatchingSecret(Predicate<SecretParamBuilder> predicate) {
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
  
  public ParamsNested<A> editParam(int index) {
    if (params.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "params"));
    }
    return this.setNewParamLike(index, this.buildParam(index));
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
    PipelineResourceSpecFluent that = (PipelineResourceSpecFluent) o;
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(params, that.params))) {
      return false;
    }
    if (!(Objects.equals(secrets, that.secrets))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getDescription() {
    return this.description;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasMatchingParam(Predicate<ResourceParamBuilder> predicate) {
      for (ResourceParamBuilder item : params) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSecret(Predicate<SecretParamBuilder> predicate) {
      for (SecretParamBuilder item : secrets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasParams() {
    return this.params != null && !(this.params.isEmpty());
  }
  
  public boolean hasSecrets() {
    return this.secrets != null && !(this.secrets.isEmpty());
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(description, params, secrets, type, additionalProperties);
  }
  
  public A removeAllFromParams(Collection<ResourceParam> items) {
    if (this.params == null) {
      return (A) this;
    }
    for (ResourceParam item : items) {
        ResourceParamBuilder builder = new ResourceParamBuilder(item);
        _visitables.get("params").remove(builder);
        this.params.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSecrets(Collection<SecretParam> items) {
    if (this.secrets == null) {
      return (A) this;
    }
    for (SecretParam item : items) {
        SecretParamBuilder builder = new SecretParamBuilder(item);
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
  
  public A removeFromParams(ResourceParam... items) {
    if (this.params == null) {
      return (A) this;
    }
    for (ResourceParam item : items) {
        ResourceParamBuilder builder = new ResourceParamBuilder(item);
        _visitables.get("params").remove(builder);
        this.params.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSecrets(SecretParam... items) {
    if (this.secrets == null) {
      return (A) this;
    }
    for (SecretParam item : items) {
        SecretParamBuilder builder = new SecretParamBuilder(item);
        _visitables.get("secrets").remove(builder);
        this.secrets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromParams(Predicate<ResourceParamBuilder> predicate) {
    if (params == null) {
      return (A) this;
    }
    Iterator<ResourceParamBuilder> each = params.iterator();
    List visitables = _visitables.get("params");
    while (each.hasNext()) {
        ResourceParamBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSecrets(Predicate<SecretParamBuilder> predicate) {
    if (secrets == null) {
      return (A) this;
    }
    Iterator<SecretParamBuilder> each = secrets.iterator();
    List visitables = _visitables.get("secrets");
    while (each.hasNext()) {
        SecretParamBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ParamsNested<A> setNewParamLike(int index,ResourceParam item) {
    return new ParamsNested(index, item);
  }
  
  public SecretsNested<A> setNewSecretLike(int index,SecretParam item) {
    return new SecretsNested(index, item);
  }
  
  public A setToParams(int index,ResourceParam item) {
    if (this.params == null) {
      this.params = new ArrayList();
    }
    ResourceParamBuilder builder = new ResourceParamBuilder(item);
    if (index < 0 || index >= params.size()) {
        _visitables.get("params").add(builder);
        params.add(builder);
    } else {
        _visitables.get("params").add(builder);
        params.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSecrets(int index,SecretParam item) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    SecretParamBuilder builder = new SecretParamBuilder(item);
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
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(params == null) && !(params.isEmpty())) {
        sb.append("params:");
        sb.append(params);
        sb.append(",");
    }
    if (!(secrets == null) && !(secrets.isEmpty())) {
        sb.append("secrets:");
        sb.append(secrets);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withParams(List<ResourceParam> params) {
    if (this.params != null) {
      this._visitables.get("params").clear();
    }
    if (params != null) {
        this.params = new ArrayList();
        for (ResourceParam item : params) {
          this.addToParams(item);
        }
    } else {
      this.params = null;
    }
    return (A) this;
  }
  
  public A withParams(ResourceParam... params) {
    if (this.params != null) {
        this.params.clear();
        _visitables.remove("params");
    }
    if (params != null) {
      for (ResourceParam item : params) {
        this.addToParams(item);
      }
    }
    return (A) this;
  }
  
  public A withSecrets(List<SecretParam> secrets) {
    if (this.secrets != null) {
      this._visitables.get("secrets").clear();
    }
    if (secrets != null) {
        this.secrets = new ArrayList();
        for (SecretParam item : secrets) {
          this.addToSecrets(item);
        }
    } else {
      this.secrets = null;
    }
    return (A) this;
  }
  
  public A withSecrets(SecretParam... secrets) {
    if (this.secrets != null) {
        this.secrets.clear();
        _visitables.remove("secrets");
    }
    if (secrets != null) {
      for (SecretParam item : secrets) {
        this.addToSecrets(item);
      }
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ParamsNested<N> extends ResourceParamFluent<ParamsNested<N>> implements Nested<N>{
  
    ResourceParamBuilder builder;
    int index;
  
    ParamsNested(int index,ResourceParam item) {
      this.index = index;
      this.builder = new ResourceParamBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineResourceSpecFluent.this.setToParams(index, builder.build());
    }
    
    public N endParam() {
      return and();
    }
    
  }
  public class SecretsNested<N> extends SecretParamFluent<SecretsNested<N>> implements Nested<N>{
  
    SecretParamBuilder builder;
    int index;
  
    SecretsNested(int index,SecretParam item) {
      this.index = index;
      this.builder = new SecretParamBuilder(this, item);
    }
  
    public N and() {
      return (N) PipelineResourceSpecFluent.this.setToSecrets(index, builder.build());
    }
    
    public N endSecret() {
      return and();
    }
    
  }
}