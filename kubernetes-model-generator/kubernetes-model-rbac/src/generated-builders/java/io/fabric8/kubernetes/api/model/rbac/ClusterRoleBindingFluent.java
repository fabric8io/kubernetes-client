package io.fabric8.kubernetes.api.model.rbac;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
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
public class ClusterRoleBindingFluent<A extends io.fabric8.kubernetes.api.model.rbac.ClusterRoleBindingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String kind;
  private ObjectMetaBuilder metadata;
  private RoleRefBuilder roleRef;
  private ArrayList<SubjectBuilder> subjects = new ArrayList<SubjectBuilder>();

  public ClusterRoleBindingFluent() {
  }
  
  public ClusterRoleBindingFluent(ClusterRoleBinding instance) {
    this.copyInstance(instance);
  }

  public A addAllToSubjects(Collection<Subject> items) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    for (Subject item : items) {
        SubjectBuilder builder = new SubjectBuilder(item);
        _visitables.get("subjects").add(builder);
        this.subjects.add(builder);
    }
    return (A) this;
  }
  
  public SubjectsNested<A> addNewSubject() {
    return new SubjectsNested(-1, null);
  }
  
  public A addNewSubject(String apiGroup,String kind,String name,String namespace) {
    return (A) this.addToSubjects(new Subject(apiGroup, kind, name, namespace));
  }
  
  public SubjectsNested<A> addNewSubjectLike(Subject item) {
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
  
  public A addToSubjects(Subject... items) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    for (Subject item : items) {
        SubjectBuilder builder = new SubjectBuilder(item);
        _visitables.get("subjects").add(builder);
        this.subjects.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubjects(int index,Subject item) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    SubjectBuilder builder = new SubjectBuilder(item);
    if (index < 0 || index >= subjects.size()) {
        _visitables.get("subjects").add(builder);
        subjects.add(builder);
    } else {
        _visitables.get("subjects").add(builder);
        subjects.add(index, builder);
    }
    return (A) this;
  }
  
  public Subject buildFirstSubject() {
    return this.subjects.get(0).build();
  }
  
  public Subject buildLastSubject() {
    return this.subjects.get(subjects.size() - 1).build();
  }
  
  public Subject buildMatchingSubject(Predicate<SubjectBuilder> predicate) {
      for (SubjectBuilder item : subjects) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public RoleRef buildRoleRef() {
    return this.roleRef != null ? this.roleRef.build() : null;
  }
  
  public Subject buildSubject(int index) {
    return this.subjects.get(index).build();
  }
  
  public List<Subject> buildSubjects() {
    return this.subjects != null ? build(subjects) : null;
  }
  
  protected void copyInstance(ClusterRoleBinding instance) {
    instance = instance != null ? instance : new ClusterRoleBinding();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withRoleRef(instance.getRoleRef());
        this.withSubjects(instance.getSubjects());
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
  
  public SubjectsNested<A> editMatchingSubject(Predicate<SubjectBuilder> predicate) {
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
    return this.withNewRoleRefLike(Optional.ofNullable(this.buildRoleRef()).orElse(new RoleRefBuilder().build()));
  }
  
  public RoleRefNested<A> editOrNewRoleRefLike(RoleRef item) {
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
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingSubject(Predicate<SubjectBuilder> predicate) {
      for (SubjectBuilder item : subjects) {
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
  
  public int hashCode() {
    return Objects.hash(apiVersion, kind, metadata, roleRef, subjects, additionalProperties);
  }
  
  public A removeAllFromSubjects(Collection<Subject> items) {
    if (this.subjects == null) {
      return (A) this;
    }
    for (Subject item : items) {
        SubjectBuilder builder = new SubjectBuilder(item);
        _visitables.get("subjects").remove(builder);
        this.subjects.remove(builder);
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
  
  public A removeFromSubjects(Subject... items) {
    if (this.subjects == null) {
      return (A) this;
    }
    for (Subject item : items) {
        SubjectBuilder builder = new SubjectBuilder(item);
        _visitables.get("subjects").remove(builder);
        this.subjects.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubjects(Predicate<SubjectBuilder> predicate) {
    if (subjects == null) {
      return (A) this;
    }
    Iterator<SubjectBuilder> each = subjects.iterator();
    List visitables = _visitables.get("subjects");
    while (each.hasNext()) {
        SubjectBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SubjectsNested<A> setNewSubjectLike(int index,Subject item) {
    return new SubjectsNested(index, item);
  }
  
  public A setToSubjects(int index,Subject item) {
    if (this.subjects == null) {
      this.subjects = new ArrayList();
    }
    SubjectBuilder builder = new SubjectBuilder(item);
    if (index < 0 || index >= subjects.size()) {
        _visitables.get("subjects").add(builder);
        subjects.add(builder);
    } else {
        _visitables.get("subjects").add(builder);
        subjects.set(index, builder);
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
  
  public A withNewRoleRef(String apiGroup,String kind,String name) {
    return (A) this.withRoleRef(new RoleRef(apiGroup, kind, name));
  }
  
  public RoleRefNested<A> withNewRoleRefLike(RoleRef item) {
    return new RoleRefNested(item);
  }
  
  public A withRoleRef(RoleRef roleRef) {
    this._visitables.remove("roleRef");
    if (roleRef != null) {
        this.roleRef = new RoleRefBuilder(roleRef);
        this._visitables.get("roleRef").add(this.roleRef);
    } else {
        this.roleRef = null;
        this._visitables.get("roleRef").remove(this.roleRef);
    }
    return (A) this;
  }
  
  public A withSubjects(List<Subject> subjects) {
    if (this.subjects != null) {
      this._visitables.get("subjects").clear();
    }
    if (subjects != null) {
        this.subjects = new ArrayList();
        for (Subject item : subjects) {
          this.addToSubjects(item);
        }
    } else {
      this.subjects = null;
    }
    return (A) this;
  }
  
  public A withSubjects(Subject... subjects) {
    if (this.subjects != null) {
        this.subjects.clear();
        _visitables.remove("subjects");
    }
    if (subjects != null) {
      for (Subject item : subjects) {
        this.addToSubjects(item);
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
  public class RoleRefNested<N> extends RoleRefFluent<RoleRefNested<N>> implements Nested<N>{
  
    RoleRefBuilder builder;
  
    RoleRefNested(RoleRef item) {
      this.builder = new RoleRefBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterRoleBindingFluent.this.withRoleRef(builder.build());
    }
    
    public N endRoleRef() {
      return and();
    }
    
  }
  public class SubjectsNested<N> extends SubjectFluent<SubjectsNested<N>> implements Nested<N>{
  
    SubjectBuilder builder;
    int index;
  
    SubjectsNested(int index,Subject item) {
      this.index = index;
      this.builder = new SubjectBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterRoleBindingFluent.this.setToSubjects(index, builder.build());
    }
    
    public N endSubject() {
      return and();
    }
    
  }
}