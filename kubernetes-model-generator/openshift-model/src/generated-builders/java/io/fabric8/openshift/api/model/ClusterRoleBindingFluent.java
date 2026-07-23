package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class ClusterRoleBindingFluent<A extends io.fabric8.openshift.api.model.ClusterRoleBindingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private List<String> groupNames = new ArrayList<String>();
  private String kind;
  private ObjectMetaBuilder metadata;
  private ObjectReferenceBuilder roleRef;
  private ArrayList<ObjectReferenceBuilder> subjects = new ArrayList<ObjectReferenceBuilder>();
  private List<String> userNames = new ArrayList<String>();

  public ClusterRoleBindingFluent() {
  }
  
  public ClusterRoleBindingFluent(ClusterRoleBinding instance) {
    this.copyInstance(instance);
  }

  public A addAllToGroupNames(Collection<String> items) {
    if (this.groupNames == null) {
      this.groupNames = new ArrayList();
    }
    for (String item : items) {
      this.groupNames.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSubjects(Collection<ObjectReference> items) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("subjects").add(builder);
        this.subjects.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToUserNames(Collection<String> items) {
    if (this.userNames == null) {
      this.userNames = new ArrayList();
    }
    for (String item : items) {
      this.userNames.add(item);
    }
    return (A) this;
  }
  
  public SubjectsNested<A> addNewSubject() {
    return new SubjectsNested(-1, null);
  }
  
  public SubjectsNested<A> addNewSubjectLike(ObjectReference item) {
    return new SubjectsNested(-1, item);
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
  
  public A addToGroupNames(String... items) {
    if (this.groupNames == null) {
      this.groupNames = new ArrayList();
    }
    for (String item : items) {
      this.groupNames.add(item);
    }
    return (A) this;
  }
  
  public A addToGroupNames(int index,String item) {
    if (this.groupNames == null) {
      this.groupNames = new ArrayList();
    }
    this.groupNames.add(index, item);
    return (A) this;
  }
  
  public A addToSubjects(ObjectReference... items) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("subjects").add(builder);
        this.subjects.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubjects(int index,ObjectReference item) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= subjects.size()) {
        _visitables.get("subjects").add(builder);
        subjects.add(builder);
    } else {
        _visitables.get("subjects").add(builder);
        subjects.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToUserNames(String... items) {
    if (this.userNames == null) {
      this.userNames = new ArrayList();
    }
    for (String item : items) {
      this.userNames.add(item);
    }
    return (A) this;
  }
  
  public A addToUserNames(int index,String item) {
    if (this.userNames == null) {
      this.userNames = new ArrayList();
    }
    this.userNames.add(index, item);
    return (A) this;
  }
  
  public ObjectReference buildFirstSubject() {
    return this.subjects.get(0).build();
  }
  
  public ObjectReference buildLastSubject() {
    return this.subjects.get(subjects.size() - 1).build();
  }
  
  public ObjectReference buildMatchingSubject(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : subjects) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public ObjectReference buildRoleRef() {
    return this.roleRef != null ? this.roleRef.build() : null;
  }
  
  public ObjectReference buildSubject(int index) {
    return this.subjects.get(index).build();
  }
  
  public List<ObjectReference> buildSubjects() {
    return this.subjects != null ? build(subjects) : null;
  }
  
  protected void copyInstance(ClusterRoleBinding instance) {
    instance = instance != null ? instance : new ClusterRoleBinding();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withGroupNames(instance.getGroupNames());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withRoleRef(instance.getRoleRef());
        this.withSubjects(instance.getSubjects());
        this.withUserNames(instance.getUserNames());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SubjectsNested<A> editFirstSubject() {
    if (subjects.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "subjects"));
    }
    return this.setNewSubjectLike(0, this.buildSubject(0));
  }
  
  public SubjectsNested<A> editLastSubject() {
    int index = subjects.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "subjects"));
    }
    return this.setNewSubjectLike(index, this.buildSubject(index));
  }
  
  public SubjectsNested<A> editMatchingSubject(Predicate<ObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < subjects.size();i++) {
      if (predicate.test(subjects.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "subjects"));
    }
    return this.setNewSubjectLike(index, this.buildSubject(index));
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
  
  public RoleRefNested<A> editOrNewRoleRef() {
    return this.withNewRoleRefLike(Optional.ofNullable(this.buildRoleRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public RoleRefNested<A> editOrNewRoleRefLike(ObjectReference item) {
    return this.withNewRoleRefLike(Optional.ofNullable(this.buildRoleRef()).orElse(item));
  }
  
  public RoleRefNested<A> editRoleRef() {
    return this.withNewRoleRefLike(Optional.ofNullable(this.buildRoleRef()).orElse(null));
  }
  
  public SubjectsNested<A> editSubject(int index) {
    if (subjects.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "subjects"));
    }
    return this.setNewSubjectLike(index, this.buildSubject(index));
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
    ClusterRoleBindingFluent that = (ClusterRoleBindingFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(groupNames, that.groupNames))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(roleRef, that.roleRef))) {
      return false;
    }
    if (!(Objects.equals(subjects, that.subjects))) {
      return false;
    }
    if (!(Objects.equals(userNames, that.userNames))) {
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
  
  public String getFirstGroupName() {
    return this.groupNames.get(0);
  }
  
  public String getFirstUserName() {
    return this.userNames.get(0);
  }
  
  public String getGroupName(int index) {
    return this.groupNames.get(index);
  }
  
  public List<String> getGroupNames() {
    return this.groupNames;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastGroupName() {
    return this.groupNames.get(groupNames.size() - 1);
  }
  
  public String getLastUserName() {
    return this.userNames.get(userNames.size() - 1);
  }
  
  public String getMatchingGroupName(Predicate<String> predicate) {
      for (String item : groupNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingUserName(Predicate<String> predicate) {
      for (String item : userNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getUserName(int index) {
    return this.userNames.get(index);
  }
  
  public List<String> getUserNames() {
    return this.userNames;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasGroupNames() {
    return this.groupNames != null && !(this.groupNames.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingGroupName(Predicate<String> predicate) {
      for (String item : groupNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSubject(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : subjects) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingUserName(Predicate<String> predicate) {
      for (String item : userNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasRoleRef() {
    return this.roleRef != null;
  }
  
  public boolean hasSubjects() {
    return this.subjects != null && !(this.subjects.isEmpty());
  }
  
  public boolean hasUserNames() {
    return this.userNames != null && !(this.userNames.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, groupNames, kind, metadata, roleRef, subjects, userNames, additionalProperties);
  }
  
  public A removeAllFromGroupNames(Collection<String> items) {
    if (this.groupNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.groupNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSubjects(Collection<ObjectReference> items) {
    if (this.subjects == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("subjects").remove(builder);
        this.subjects.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromUserNames(Collection<String> items) {
    if (this.userNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.userNames.remove(item);
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
  
  public A removeFromGroupNames(String... items) {
    if (this.groupNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.groupNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSubjects(ObjectReference... items) {
    if (this.subjects == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("subjects").remove(builder);
        this.subjects.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromUserNames(String... items) {
    if (this.userNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.userNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubjects(Predicate<ObjectReferenceBuilder> predicate) {
    if (subjects == null) {
      return (A) this;
    }
    Iterator<ObjectReferenceBuilder> each = subjects.iterator();
    List visitables = _visitables.get("subjects");
    while (each.hasNext()) {
        ObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SubjectsNested<A> setNewSubjectLike(int index,ObjectReference item) {
    return new SubjectsNested(index, item);
  }
  
  public A setToGroupNames(int index,String item) {
    if (this.groupNames == null) {
      this.groupNames = new ArrayList();
    }
    this.groupNames.set(index, item);
    return (A) this;
  }
  
  public A setToSubjects(int index,ObjectReference item) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= subjects.size()) {
        _visitables.get("subjects").add(builder);
        subjects.add(builder);
    } else {
        _visitables.get("subjects").add(builder);
        subjects.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToUserNames(int index,String item) {
    if (this.userNames == null) {
      this.userNames = new ArrayList();
    }
    this.userNames.set(index, item);
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
    if (!(groupNames == null) && !(groupNames.isEmpty())) {
        sb.append("groupNames:");
        sb.append(groupNames);
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
    if (!(roleRef == null)) {
        sb.append("roleRef:");
        sb.append(roleRef);
        sb.append(",");
    }
    if (!(subjects == null) && !(subjects.isEmpty())) {
        sb.append("subjects:");
        sb.append(subjects);
        sb.append(",");
    }
    if (!(userNames == null) && !(userNames.isEmpty())) {
        sb.append("userNames:");
        sb.append(userNames);
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
  
  public A withGroupNames(List<String> groupNames) {
    if (groupNames != null) {
        this.groupNames = new ArrayList();
        for (String item : groupNames) {
          this.addToGroupNames(item);
        }
    } else {
      this.groupNames = null;
    }
    return (A) this;
  }
  
  public A withGroupNames(String... groupNames) {
    if (this.groupNames != null) {
        this.groupNames.clear();
        _visitables.remove("groupNames");
    }
    if (groupNames != null) {
      for (String item : groupNames) {
        this.addToGroupNames(item);
      }
    }
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
  
  public RoleRefNested<A> withNewRoleRef() {
    return new RoleRefNested(null);
  }
  
  public RoleRefNested<A> withNewRoleRefLike(ObjectReference item) {
    return new RoleRefNested(item);
  }
  
  public A withRoleRef(ObjectReference roleRef) {
    this._visitables.remove("roleRef");
    if (roleRef != null) {
        this.roleRef = new ObjectReferenceBuilder(roleRef);
        this._visitables.get("roleRef").add(this.roleRef);
    } else {
        this.roleRef = null;
        this._visitables.get("roleRef").remove(this.roleRef);
    }
    return (A) this;
  }
  
  public A withSubjects(List<ObjectReference> subjects) {
    if (this.subjects != null) {
      this._visitables.get("subjects").clear();
    }
    if (subjects != null) {
        this.subjects = new ArrayList();
        for (ObjectReference item : subjects) {
          this.addToSubjects(item);
        }
    } else {
      this.subjects = null;
    }
    return (A) this;
  }
  
  public A withSubjects(ObjectReference... subjects) {
    if (this.subjects != null) {
        this.subjects.clear();
        _visitables.remove("subjects");
    }
    if (subjects != null) {
      for (ObjectReference item : subjects) {
        this.addToSubjects(item);
      }
    }
    return (A) this;
  }
  
  public A withUserNames(List<String> userNames) {
    if (userNames != null) {
        this.userNames = new ArrayList();
        for (String item : userNames) {
          this.addToUserNames(item);
        }
    } else {
      this.userNames = null;
    }
    return (A) this;
  }
  
  public A withUserNames(String... userNames) {
    if (this.userNames != null) {
        this.userNames.clear();
        _visitables.remove("userNames");
    }
    if (userNames != null) {
      for (String item : userNames) {
        this.addToUserNames(item);
      }
    }
    return (A) this;
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterRoleBindingFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class RoleRefNested<N> extends ObjectReferenceFluent<RoleRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    RoleRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterRoleBindingFluent.this.withRoleRef(builder.build());
    }
    
    public N endRoleRef() {
      return and();
    }
    
  }
  public class SubjectsNested<N> extends ObjectReferenceFluent<SubjectsNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
    int index;
  
    SubjectsNested(int index,ObjectReference item) {
      this.index = index;
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterRoleBindingFluent.this.setToSubjects(index, builder.build());
    }
    
    public N endSubject() {
      return and();
    }
    
  }
}