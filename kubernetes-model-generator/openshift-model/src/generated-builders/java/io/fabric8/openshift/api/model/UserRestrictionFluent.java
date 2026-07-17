package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class UserRestrictionFluent<A extends io.fabric8.openshift.api.model.UserRestrictionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> groups = new ArrayList<String>();
  private ArrayList<LabelSelectorBuilder> labels = new ArrayList<LabelSelectorBuilder>();
  private List<String> users = new ArrayList<String>();

  public UserRestrictionFluent() {
  }
  
  public UserRestrictionFluent(UserRestriction instance) {
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
  
  public A addAllToLabels(Collection<LabelSelector> items) {
    if (this.labels == null) {
      this.labels = new ArrayList();
    }
    for (LabelSelector item : items) {
        LabelSelectorBuilder builder = new LabelSelectorBuilder(item);
        _visitables.get("labels").add(builder);
        this.labels.add(builder);
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
  
  public LabelsNested<A> addNewLabel() {
    return new LabelsNested(-1, null);
  }
  
  public LabelsNested<A> addNewLabelLike(LabelSelector item) {
    return new LabelsNested(-1, item);
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
  
  public A addToLabels(LabelSelector... items) {
    if (this.labels == null) {
      this.labels = new ArrayList();
    }
    for (LabelSelector item : items) {
        LabelSelectorBuilder builder = new LabelSelectorBuilder(item);
        _visitables.get("labels").add(builder);
        this.labels.add(builder);
    }
    return (A) this;
  }
  
  public A addToLabels(int index,LabelSelector item) {
    if (this.labels == null) {
      this.labels = new ArrayList();
    }
    LabelSelectorBuilder builder = new LabelSelectorBuilder(item);
    if (index < 0 || index >= labels.size()) {
        _visitables.get("labels").add(builder);
        labels.add(builder);
    } else {
        _visitables.get("labels").add(builder);
        labels.add(index, builder);
    }
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
  
  public LabelSelector buildFirstLabel() {
    return this.labels.get(0).build();
  }
  
  public LabelSelector buildLabel(int index) {
    return this.labels.get(index).build();
  }
  
  public List<LabelSelector> buildLabels() {
    return this.labels != null ? build(labels) : null;
  }
  
  public LabelSelector buildLastLabel() {
    return this.labels.get(labels.size() - 1).build();
  }
  
  public LabelSelector buildMatchingLabel(Predicate<LabelSelectorBuilder> predicate) {
      for (LabelSelectorBuilder item : labels) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(UserRestriction instance) {
    instance = instance != null ? instance : new UserRestriction();
    if (instance != null) {
        this.withGroups(instance.getGroups());
        this.withLabels(instance.getLabels());
        this.withUsers(instance.getUsers());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LabelsNested<A> editFirstLabel() {
    if (labels.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "labels"));
    }
    return this.setNewLabelLike(0, this.buildLabel(0));
  }
  
  public LabelsNested<A> editLabel(int index) {
    if (labels.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "labels"));
    }
    return this.setNewLabelLike(index, this.buildLabel(index));
  }
  
  public LabelsNested<A> editLastLabel() {
    int index = labels.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "labels"));
    }
    return this.setNewLabelLike(index, this.buildLabel(index));
  }
  
  public LabelsNested<A> editMatchingLabel(Predicate<LabelSelectorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < labels.size();i++) {
      if (predicate.test(labels.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "labels"));
    }
    return this.setNewLabelLike(index, this.buildLabel(index));
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
    UserRestrictionFluent that = (UserRestrictionFluent) o;
    if (!(Objects.equals(groups, that.groups))) {
      return false;
    }
    if (!(Objects.equals(labels, that.labels))) {
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
  
  public String getUser(int index) {
    return this.users.get(index);
  }
  
  public List<String> getUsers() {
    return this.users;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGroups() {
    return this.groups != null && !(this.groups.isEmpty());
  }
  
  public boolean hasLabels() {
    return this.labels != null && !(this.labels.isEmpty());
  }
  
  public boolean hasMatchingGroup(Predicate<String> predicate) {
      for (String item : groups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingLabel(Predicate<LabelSelectorBuilder> predicate) {
      for (LabelSelectorBuilder item : labels) {
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
  
  public boolean hasUsers() {
    return this.users != null && !(this.users.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(groups, labels, users, additionalProperties);
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
  
  public A removeAllFromLabels(Collection<LabelSelector> items) {
    if (this.labels == null) {
      return (A) this;
    }
    for (LabelSelector item : items) {
        LabelSelectorBuilder builder = new LabelSelectorBuilder(item);
        _visitables.get("labels").remove(builder);
        this.labels.remove(builder);
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
  
  public A removeFromLabels(LabelSelector... items) {
    if (this.labels == null) {
      return (A) this;
    }
    for (LabelSelector item : items) {
        LabelSelectorBuilder builder = new LabelSelectorBuilder(item);
        _visitables.get("labels").remove(builder);
        this.labels.remove(builder);
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
  
  public A removeMatchingFromLabels(Predicate<LabelSelectorBuilder> predicate) {
    if (labels == null) {
      return (A) this;
    }
    Iterator<LabelSelectorBuilder> each = labels.iterator();
    List visitables = _visitables.get("labels");
    while (each.hasNext()) {
        LabelSelectorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public LabelsNested<A> setNewLabelLike(int index,LabelSelector item) {
    return new LabelsNested(index, item);
  }
  
  public A setToGroups(int index,String item) {
    if (this.groups == null) {
      this.groups = new ArrayList();
    }
    this.groups.set(index, item);
    return (A) this;
  }
  
  public A setToLabels(int index,LabelSelector item) {
    if (this.labels == null) {
      this.labels = new ArrayList();
    }
    LabelSelectorBuilder builder = new LabelSelectorBuilder(item);
    if (index < 0 || index >= labels.size()) {
        _visitables.get("labels").add(builder);
        labels.add(builder);
    } else {
        _visitables.get("labels").add(builder);
        labels.set(index, builder);
    }
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
    if (!(groups == null) && !(groups.isEmpty())) {
        sb.append("groups:");
        sb.append(groups);
        sb.append(",");
    }
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
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
  
  public A withLabels(List<LabelSelector> labels) {
    if (this.labels != null) {
      this._visitables.get("labels").clear();
    }
    if (labels != null) {
        this.labels = new ArrayList();
        for (LabelSelector item : labels) {
          this.addToLabels(item);
        }
    } else {
      this.labels = null;
    }
    return (A) this;
  }
  
  public A withLabels(LabelSelector... labels) {
    if (this.labels != null) {
        this.labels.clear();
        _visitables.remove("labels");
    }
    if (labels != null) {
      for (LabelSelector item : labels) {
        this.addToLabels(item);
      }
    }
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
  public class LabelsNested<N> extends LabelSelectorFluent<LabelsNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
    int index;
  
    LabelsNested(int index,LabelSelector item) {
      this.index = index;
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) UserRestrictionFluent.this.setToLabels(index, builder.build());
    }
    
    public N endLabel() {
      return and();
    }
    
  }
}