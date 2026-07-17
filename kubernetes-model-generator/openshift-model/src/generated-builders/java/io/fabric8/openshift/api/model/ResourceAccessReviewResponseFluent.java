package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ResourceAccessReviewResponseFluent<A extends io.fabric8.openshift.api.model.ResourceAccessReviewResponseFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String evalutionError;
  private List<String> groups = new ArrayList<String>();
  private String kind;
  private String namespace;
  private List<String> users = new ArrayList<String>();

  public ResourceAccessReviewResponseFluent() {
  }
  
  public ResourceAccessReviewResponseFluent(ResourceAccessReviewResponse instance) {
    this.copyInstance(instance);
  }

  public A addAllToGroups(Collection<String> items) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    for (String item : items) {
      this.groups.add(item);
    }
    return (A) this;
  }
  
  public A addAllToUsers(Collection<String> items) {
    if (this.users == null) {
      this.users = new ArrayList();
    }
    for (String item : items) {
      this.users.add(item);
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
  
  public A addToGroups(String... items) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    for (String item : items) {
      this.groups.add(item);
    }
    return (A) this;
  }
  
  public A addToGroups(int index,String item) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    this.groups.add(index, item);
    return (A) this;
  }
  
  public A addToUsers(String... items) {
    if (this.users == null) {
      this.users = new ArrayList();
    }
    for (String item : items) {
      this.users.add(item);
    }
    return (A) this;
  }
  
  public A addToUsers(int index,String item) {
    if (this.users == null) {
      this.users = new ArrayList();
    }
    this.users.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ResourceAccessReviewResponse instance) {
    instance = instance != null ? instance : new ResourceAccessReviewResponse();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withEvalutionError(instance.getEvalutionError());
        this.withGroups(instance.getGroups());
        this.withKind(instance.getKind());
        this.withNamespace(instance.getNamespace());
        this.withUsers(instance.getUsers());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    ResourceAccessReviewResponseFluent that = (ResourceAccessReviewResponseFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(evalutionError, that.evalutionError))) {
      return false;
    }
    if (!(Objects.equals(groups, that.groups))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(users, that.users))) {
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
  
  public String getEvalutionError() {
    return this.evalutionError;
  }
  
  public String getFirstGroup() {
    return this.groups.get(0);
  }
  
  public String getFirstUser() {
    return this.users.get(0);
  }
  
  public String getGroup(int index) {
    return this.groups.get(index);
  }
  
  public List<String> getGroups() {
    return this.groups;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastGroup() {
    return this.groups.get(groups.size() - 1);
  }
  
  public String getLastUser() {
    return this.users.get(users.size() - 1);
  }
  
  public String getMatchingGroup(Predicate<String> predicate) {
      for (String item : groups) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingUser(Predicate<String> predicate) {
      for (String item : users) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getUser(int index) {
    return this.users.get(index);
  }
  
  public List<String> getUsers() {
    return this.users;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasEvalutionError() {
    return this.evalutionError != null;
  }
  
  public boolean hasGroups() {
    return this.groups != null && !(this.groups.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingGroup(Predicate<String> predicate) {
      for (String item : groups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingUser(Predicate<String> predicate) {
      for (String item : users) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasUsers() {
    return this.users != null && !(this.users.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, evalutionError, groups, kind, namespace, users, additionalProperties);
  }
  
  public A removeAllFromGroups(Collection<String> items) {
    if (this.groups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.groups.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromUsers(Collection<String> items) {
    if (this.users == null) {
      return (A) this;
    }
    for (String item : items) {
      this.users.remove(item);
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
  
  public A removeFromGroups(String... items) {
    if (this.groups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.groups.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromUsers(String... items) {
    if (this.users == null) {
      return (A) this;
    }
    for (String item : items) {
      this.users.remove(item);
    }
    return (A) this;
  }
  
  public A setToGroups(int index,String item) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    this.groups.set(index, item);
    return (A) this;
  }
  
  public A setToUsers(int index,String item) {
    if (this.users == null) {
      this.users = new ArrayList();
    }
    this.users.set(index, item);
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
    if (!(evalutionError == null)) {
        sb.append("evalutionError:");
        sb.append(evalutionError);
        sb.append(",");
    }
    if (!(groups == null) && !(groups.isEmpty())) {
        sb.append("groups:");
        sb.append(groups);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(users == null) && !(users.isEmpty())) {
        sb.append("users:");
        sb.append(users);
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
  
  public A withEvalutionError(String evalutionError) {
    this.evalutionError = evalutionError;
    return (A) this;
  }
  
  public A withGroups(List<String> groups) {
    if (groups != null) {
        this.groups = new ArrayList();
        for (String item : groups) {
          this.addToGroups(item);
        }
    } else {
      this.groups = null;
    }
    return (A) this;
  }
  
  public A withGroups(String... groups) {
    if (this.groups != null) {
        this.groups.clear();
        _visitables.remove("groups");
    }
    if (groups != null) {
      for (String item : groups) {
        this.addToGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public A withUsers(List<String> users) {
    if (users != null) {
        this.users = new ArrayList();
        for (String item : users) {
          this.addToUsers(item);
        }
    } else {
      this.users = null;
    }
    return (A) this;
  }
  
  public A withUsers(String... users) {
    if (this.users != null) {
        this.users.clear();
        _visitables.remove("users");
    }
    if (users != null) {
      for (String item : users) {
        this.addToUsers(item);
      }
    }
    return (A) this;
  }
  
}