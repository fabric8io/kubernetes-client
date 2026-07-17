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
public class SubjectRulesReviewSpecFluent<A extends io.fabric8.openshift.api.model.SubjectRulesReviewSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> groups = new ArrayList<String>();
  private List<String> scopes = new ArrayList<String>();
  private String user;

  public SubjectRulesReviewSpecFluent() {
  }
  
  public SubjectRulesReviewSpecFluent(SubjectRulesReviewSpec instance) {
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
  
  protected void copyInstance(SubjectRulesReviewSpec instance) {
    instance = instance != null ? instance : new SubjectRulesReviewSpec();
    if (instance != null) {
        this.withGroups(instance.getGroups());
        this.withScopes(instance.getScopes());
        this.withUser(instance.getUser());
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
    SubjectRulesReviewSpecFluent that = (SubjectRulesReviewSpecFluent) o;
    if (!(Objects.equals(groups, that.groups))) {
      return false;
    }
    if (!(Objects.equals(scopes, that.scopes))) {
      return false;
    }
    if (!(Objects.equals(user, that.user))) {
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
  
  public String getFirstGroup() {
    return this.groups.get(0);
  }
  
  public String getFirstScope() {
    return this.scopes.get(0);
  }
  
  public String getGroup(int index) {
    return this.groups.get(index);
  }
  
  public List<String> getGroups() {
    return this.groups;
  }
  
  public String getLastGroup() {
    return this.groups.get(groups.size() - 1);
  }
  
  public String getLastScope() {
    return this.scopes.get(scopes.size() - 1);
  }
  
  public String getMatchingGroup(Predicate<String> predicate) {
      for (String item : groups) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingScope(Predicate<String> predicate) {
      for (String item : scopes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getScope(int index) {
    return this.scopes.get(index);
  }
  
  public List<String> getScopes() {
    return this.scopes;
  }
  
  public String getUser() {
    return this.user;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGroups() {
    return this.groups != null && !(this.groups.isEmpty());
  }
  
  public boolean hasMatchingGroup(Predicate<String> predicate) {
      for (String item : groups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingScope(Predicate<String> predicate) {
      for (String item : scopes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasScopes() {
    return this.scopes != null && !(this.scopes.isEmpty());
  }
  
  public boolean hasUser() {
    return this.user != null;
  }
  
  public int hashCode() {
    return Objects.hash(groups, scopes, user, additionalProperties);
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
  
  public A removeFromGroups(String... items) {
    if (this.groups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.groups.remove(item);
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
  
  public A setToGroups(int index,String item) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    this.groups.set(index, item);
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
    if (!(groups == null) && !(groups.isEmpty())) {
        sb.append("groups:");
        sb.append(groups);
        sb.append(",");
    }
    if (!(scopes == null) && !(scopes.isEmpty())) {
        sb.append("scopes:");
        sb.append(scopes);
        sb.append(",");
    }
    if (!(user == null)) {
        sb.append("user:");
        sb.append(user);
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
  
  public A withUser(String user) {
    this.user = user;
    return (A) this;
  }
  
}