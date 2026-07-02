package io.fabric8.kubernetes.api.model;

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
public class APIGroupListFluent<A extends io.fabric8.kubernetes.api.model.APIGroupListFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private ArrayList<APIGroupBuilder> groups = new ArrayList<APIGroupBuilder>();
  private String kind;

  public APIGroupListFluent() {
  }
  
  public APIGroupListFluent(APIGroupList instance) {
    this.copyInstance(instance);
  }

  public A addAllToGroups(Collection<APIGroup> items) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    for (APIGroup item : items) {
        APIGroupBuilder builder = new APIGroupBuilder(item);
        _visitables.get("groups").add(builder);
        this.groups.add(builder);
    }
    return (A) this;
  }
  
  public GroupsNested<A> addNewGroup() {
    return new GroupsNested(-1, null);
  }
  
  public GroupsNested<A> addNewGroupLike(APIGroup item) {
    return new GroupsNested(-1, item);
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
  
  public A addToGroups(APIGroup... items) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    for (APIGroup item : items) {
        APIGroupBuilder builder = new APIGroupBuilder(item);
        _visitables.get("groups").add(builder);
        this.groups.add(builder);
    }
    return (A) this;
  }
  
  public A addToGroups(int index,APIGroup item) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    APIGroupBuilder builder = new APIGroupBuilder(item);
    if (index < 0 || index >= groups.size()) {
        _visitables.get("groups").add(builder);
        groups.add(builder);
    } else {
        _visitables.get("groups").add(builder);
        groups.add(index, builder);
    }
    return (A) this;
  }
  
  public APIGroup buildFirstGroup() {
    return this.groups.get(0).build();
  }
  
  public APIGroup buildGroup(int index) {
    return this.groups.get(index).build();
  }
  
  public List<APIGroup> buildGroups() {
    return this.groups != null ? build(groups) : null;
  }
  
  public APIGroup buildLastGroup() {
    return this.groups.get(groups.size() - 1).build();
  }
  
  public APIGroup buildMatchingGroup(Predicate<APIGroupBuilder> predicate) {
      for (APIGroupBuilder item : groups) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(APIGroupList instance) {
    instance = instance != null ? instance : new APIGroupList();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withGroups(instance.getGroups());
        this.withKind(instance.getKind());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GroupsNested<A> editFirstGroup() {
    if (groups.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "groups"));
    }
    return this.setNewGroupLike(0, this.buildGroup(0));
  }
  
  public GroupsNested<A> editGroup(int index) {
    if (groups.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "groups"));
    }
    return this.setNewGroupLike(index, this.buildGroup(index));
  }
  
  public GroupsNested<A> editLastGroup() {
    int index = groups.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "groups"));
    }
    return this.setNewGroupLike(index, this.buildGroup(index));
  }
  
  public GroupsNested<A> editMatchingGroup(Predicate<APIGroupBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < groups.size();i++) {
      if (predicate.test(groups.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "groups"));
    }
    return this.setNewGroupLike(index, this.buildGroup(index));
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
    APIGroupListFluent that = (APIGroupListFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(groups, that.groups))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
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
  
  public String getKind() {
    return this.kind;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasGroups() {
    return this.groups != null && !(this.groups.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingGroup(Predicate<APIGroupBuilder> predicate) {
      for (APIGroupBuilder item : groups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, groups, kind, additionalProperties);
  }
  
  public A removeAllFromGroups(Collection<APIGroup> items) {
    if (this.groups == null) {
      return (A) this;
    }
    for (APIGroup item : items) {
        APIGroupBuilder builder = new APIGroupBuilder(item);
        _visitables.get("groups").remove(builder);
        this.groups.remove(builder);
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
  
  public A removeFromGroups(APIGroup... items) {
    if (this.groups == null) {
      return (A) this;
    }
    for (APIGroup item : items) {
        APIGroupBuilder builder = new APIGroupBuilder(item);
        _visitables.get("groups").remove(builder);
        this.groups.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromGroups(Predicate<APIGroupBuilder> predicate) {
    if (groups == null) {
      return (A) this;
    }
    Iterator<APIGroupBuilder> each = groups.iterator();
    List visitables = _visitables.get("groups");
    while (each.hasNext()) {
        APIGroupBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public GroupsNested<A> setNewGroupLike(int index,APIGroup item) {
    return new GroupsNested(index, item);
  }
  
  public A setToGroups(int index,APIGroup item) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    APIGroupBuilder builder = new APIGroupBuilder(item);
    if (index < 0 || index >= groups.size()) {
        _visitables.get("groups").add(builder);
        groups.add(builder);
    } else {
        _visitables.get("groups").add(builder);
        groups.set(index, builder);
    }
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
  
  public A withGroups(List<APIGroup> groups) {
    if (this.groups != null) {
      this._visitables.get("groups").clear();
    }
    if (groups != null) {
        this.groups = new ArrayList();
        for (APIGroup item : groups) {
          this.addToGroups(item);
        }
    } else {
      this.groups = null;
    }
    return (A) this;
  }
  
  public A withGroups(APIGroup... groups) {
    if (this.groups != null) {
        this.groups.clear();
        _visitables.remove("groups");
    }
    if (groups != null) {
      for (APIGroup item : groups) {
        this.addToGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  public class GroupsNested<N> extends APIGroupFluent<GroupsNested<N>> implements Nested<N>{
  
    APIGroupBuilder builder;
    int index;
  
    GroupsNested(int index,APIGroup item) {
      this.index = index;
      this.builder = new APIGroupBuilder(this, item);
    }
  
    public N and() {
      return (N) APIGroupListFluent.this.setToGroups(index, builder.build());
    }
    
    public N endGroup() {
      return and();
    }
    
  }
}