package io.fabric8.openshift.api.model.installer.v1;

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
public class FencingFluent<A extends io.fabric8.openshift.api.model.installer.v1.FencingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<CredentialBuilder> credentials = new ArrayList<CredentialBuilder>();

  public FencingFluent() {
  }
  
  public FencingFluent(Fencing instance) {
    this.copyInstance(instance);
  }

  public A addAllToCredentials(Collection<Credential> items) {
    if (this.credentials == null) {
      this.credentials = new ArrayList();
    }
    for (Credential item : items) {
        CredentialBuilder builder = new CredentialBuilder(item);
        _visitables.get("credentials").add(builder);
        this.credentials.add(builder);
    }
    return (A) this;
  }
  
  public CredentialsNested<A> addNewCredential() {
    return new CredentialsNested(-1, null);
  }
  
  public A addNewCredential(String address,String certificateVerification,String hostName,String password,String username) {
    return (A) this.addToCredentials(new Credential(address, certificateVerification, hostName, password, username));
  }
  
  public CredentialsNested<A> addNewCredentialLike(Credential item) {
    return new CredentialsNested(-1, item);
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
  
  public A addToCredentials(Credential... items) {
    if (this.credentials == null) {
      this.credentials = new ArrayList();
    }
    for (Credential item : items) {
        CredentialBuilder builder = new CredentialBuilder(item);
        _visitables.get("credentials").add(builder);
        this.credentials.add(builder);
    }
    return (A) this;
  }
  
  public A addToCredentials(int index,Credential item) {
    if (this.credentials == null) {
      this.credentials = new ArrayList();
    }
    CredentialBuilder builder = new CredentialBuilder(item);
    if (index < 0 || index >= credentials.size()) {
        _visitables.get("credentials").add(builder);
        credentials.add(builder);
    } else {
        _visitables.get("credentials").add(builder);
        credentials.add(index, builder);
    }
    return (A) this;
  }
  
  public Credential buildCredential(int index) {
    return this.credentials.get(index).build();
  }
  
  public List<Credential> buildCredentials() {
    return this.credentials != null ? build(credentials) : null;
  }
  
  public Credential buildFirstCredential() {
    return this.credentials.get(0).build();
  }
  
  public Credential buildLastCredential() {
    return this.credentials.get(credentials.size() - 1).build();
  }
  
  public Credential buildMatchingCredential(Predicate<CredentialBuilder> predicate) {
      for (CredentialBuilder item : credentials) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(Fencing instance) {
    instance = instance != null ? instance : new Fencing();
    if (instance != null) {
        this.withCredentials(instance.getCredentials());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CredentialsNested<A> editCredential(int index) {
    if (credentials.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "credentials"));
    }
    return this.setNewCredentialLike(index, this.buildCredential(index));
  }
  
  public CredentialsNested<A> editFirstCredential() {
    if (credentials.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "credentials"));
    }
    return this.setNewCredentialLike(0, this.buildCredential(0));
  }
  
  public CredentialsNested<A> editLastCredential() {
    int index = credentials.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "credentials"));
    }
    return this.setNewCredentialLike(index, this.buildCredential(index));
  }
  
  public CredentialsNested<A> editMatchingCredential(Predicate<CredentialBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < credentials.size();i++) {
      if (predicate.test(credentials.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "credentials"));
    }
    return this.setNewCredentialLike(index, this.buildCredential(index));
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
    FencingFluent that = (FencingFluent) o;
    if (!(Objects.equals(credentials, that.credentials))) {
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
  
  public boolean hasCredentials() {
    return this.credentials != null && !(this.credentials.isEmpty());
  }
  
  public boolean hasMatchingCredential(Predicate<CredentialBuilder> predicate) {
      for (CredentialBuilder item : credentials) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(credentials, additionalProperties);
  }
  
  public A removeAllFromCredentials(Collection<Credential> items) {
    if (this.credentials == null) {
      return (A) this;
    }
    for (Credential item : items) {
        CredentialBuilder builder = new CredentialBuilder(item);
        _visitables.get("credentials").remove(builder);
        this.credentials.remove(builder);
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
  
  public A removeFromCredentials(Credential... items) {
    if (this.credentials == null) {
      return (A) this;
    }
    for (Credential item : items) {
        CredentialBuilder builder = new CredentialBuilder(item);
        _visitables.get("credentials").remove(builder);
        this.credentials.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCredentials(Predicate<CredentialBuilder> predicate) {
    if (credentials == null) {
      return (A) this;
    }
    Iterator<CredentialBuilder> each = credentials.iterator();
    List visitables = _visitables.get("credentials");
    while (each.hasNext()) {
        CredentialBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CredentialsNested<A> setNewCredentialLike(int index,Credential item) {
    return new CredentialsNested(index, item);
  }
  
  public A setToCredentials(int index,Credential item) {
    if (this.credentials == null) {
      this.credentials = new ArrayList();
    }
    CredentialBuilder builder = new CredentialBuilder(item);
    if (index < 0 || index >= credentials.size()) {
        _visitables.get("credentials").add(builder);
        credentials.add(builder);
    } else {
        _visitables.get("credentials").add(builder);
        credentials.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(credentials == null) && !(credentials.isEmpty())) {
        sb.append("credentials:");
        sb.append(credentials);
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
  
  public A withCredentials(List<Credential> credentials) {
    if (this.credentials != null) {
      this._visitables.get("credentials").clear();
    }
    if (credentials != null) {
        this.credentials = new ArrayList();
        for (Credential item : credentials) {
          this.addToCredentials(item);
        }
    } else {
      this.credentials = null;
    }
    return (A) this;
  }
  
  public A withCredentials(Credential... credentials) {
    if (this.credentials != null) {
        this.credentials.clear();
        _visitables.remove("credentials");
    }
    if (credentials != null) {
      for (Credential item : credentials) {
        this.addToCredentials(item);
      }
    }
    return (A) this;
  }
  public class CredentialsNested<N> extends CredentialFluent<CredentialsNested<N>> implements Nested<N>{
  
    CredentialBuilder builder;
    int index;
  
    CredentialsNested(int index,Credential item) {
      this.index = index;
      this.builder = new CredentialBuilder(this, item);
    }
  
    public N and() {
      return (N) FencingFluent.this.setToCredentials(index, builder.build());
    }
    
    public N endCredential() {
      return and();
    }
    
  }
}