package io.fabric8.openclustermanagement.api.model.policy.v1;

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
public class PlacementBindingFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1.PlacementBindingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private BindingOverridesBuilder bindingOverrides;
  private String kind;
  private ObjectMetaBuilder metadata;
  private PlacementSubjectBuilder placementRef;
  private PlacementBindingStatusBuilder status;
  private String subFilter;
  private ArrayList<SubjectBuilder> subjects = new ArrayList<SubjectBuilder>();

  public PlacementBindingFluent() {
  }
  
  public PlacementBindingFluent(PlacementBinding instance) {
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
  
  public A addNewSubject(String apiGroup,String kind,String name) {
    return (A) this.addToSubjects(new Subject(apiGroup, kind, name));
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
  
  public BindingOverrides buildBindingOverrides() {
    return this.bindingOverrides != null ? this.bindingOverrides.build() : null;
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
  
  public PlacementSubject buildPlacementRef() {
    return this.placementRef != null ? this.placementRef.build() : null;
  }
  
  public PlacementBindingStatus buildStatus() {
    return this.status != null ? this.status.build() : null;
  }
  
  public Subject buildSubject(int index) {
    return this.subjects.get(index).build();
  }
  
  public List<Subject> buildSubjects() {
    return this.subjects != null ? build(subjects) : null;
  }
  
  protected void copyInstance(PlacementBinding instance) {
    instance = instance != null ? instance : new PlacementBinding();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withBindingOverrides(instance.getBindingOverrides());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withPlacementRef(instance.getPlacementRef());
        this.withStatus(instance.getStatus());
        this.withSubFilter(instance.getSubFilter());
        this.withSubjects(instance.getSubjects());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BindingOverridesNested<A> editBindingOverrides() {
    return this.withNewBindingOverridesLike(Optional.ofNullable(this.buildBindingOverrides()).orElse(null));
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
  
  public BindingOverridesNested<A> editOrNewBindingOverrides() {
    return this.withNewBindingOverridesLike(Optional.ofNullable(this.buildBindingOverrides()).orElse(new BindingOverridesBuilder().build()));
  }
  
  public BindingOverridesNested<A> editOrNewBindingOverridesLike(BindingOverrides item) {
    return this.withNewBindingOverridesLike(Optional.ofNullable(this.buildBindingOverrides()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public PlacementRefNested<A> editOrNewPlacementRef() {
    return this.withNewPlacementRefLike(Optional.ofNullable(this.buildPlacementRef()).orElse(new PlacementSubjectBuilder().build()));
  }
  
  public PlacementRefNested<A> editOrNewPlacementRefLike(PlacementSubject item) {
    return this.withNewPlacementRefLike(Optional.ofNullable(this.buildPlacementRef()).orElse(item));
  }
  
  public StatusNested<A> editOrNewStatus() {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(new PlacementBindingStatusBuilder().build()));
  }
  
  public StatusNested<A> editOrNewStatusLike(PlacementBindingStatus item) {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(item));
  }
  
  public PlacementRefNested<A> editPlacementRef() {
    return this.withNewPlacementRefLike(Optional.ofNullable(this.buildPlacementRef()).orElse(null));
  }
  
  public StatusNested<A> editStatus() {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(null));
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
    PlacementBindingFluent that = (PlacementBindingFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(bindingOverrides, that.bindingOverrides))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(placementRef, that.placementRef))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
      return false;
    }
    if (!(Objects.equals(subFilter, that.subFilter))) {
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
  
  public String getSubFilter() {
    return this.subFilter;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasBindingOverrides() {
    return this.bindingOverrides != null;
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
  
  public boolean hasPlacementRef() {
    return this.placementRef != null;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public boolean hasSubFilter() {
    return this.subFilter != null;
  }
  
  public boolean hasSubjects() {
    return this.subjects != null && !(this.subjects.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, bindingOverrides, kind, metadata, placementRef, status, subFilter, subjects, additionalProperties);
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
    if (!(bindingOverrides == null)) {
        sb.append("bindingOverrides:");
        sb.append(bindingOverrides);
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
    if (!(placementRef == null)) {
        sb.append("placementRef:");
        sb.append(placementRef);
        sb.append(",");
    }
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
        sb.append(",");
    }
    if (!(subFilter == null)) {
        sb.append("subFilter:");
        sb.append(subFilter);
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
  
  public A withBindingOverrides(BindingOverrides bindingOverrides) {
    this._visitables.remove("bindingOverrides");
    if (bindingOverrides != null) {
        this.bindingOverrides = new BindingOverridesBuilder(bindingOverrides);
        this._visitables.get("bindingOverrides").add(this.bindingOverrides);
    } else {
        this.bindingOverrides = null;
        this._visitables.get("bindingOverrides").remove(this.bindingOverrides);
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
  
  public BindingOverridesNested<A> withNewBindingOverrides() {
    return new BindingOverridesNested(null);
  }
  
  public A withNewBindingOverrides(String remediationAction) {
    return (A) this.withBindingOverrides(new BindingOverrides(remediationAction));
  }
  
  public BindingOverridesNested<A> withNewBindingOverridesLike(BindingOverrides item) {
    return new BindingOverridesNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public PlacementRefNested<A> withNewPlacementRef() {
    return new PlacementRefNested(null);
  }
  
  public A withNewPlacementRef(String apiGroup,String kind,String name) {
    return (A) this.withPlacementRef(new PlacementSubject(apiGroup, kind, name));
  }
  
  public PlacementRefNested<A> withNewPlacementRefLike(PlacementSubject item) {
    return new PlacementRefNested(item);
  }
  
  public StatusNested<A> withNewStatus() {
    return new StatusNested(null);
  }
  
  public StatusNested<A> withNewStatusLike(PlacementBindingStatus item) {
    return new StatusNested(item);
  }
  
  public A withPlacementRef(PlacementSubject placementRef) {
    this._visitables.remove("placementRef");
    if (placementRef != null) {
        this.placementRef = new PlacementSubjectBuilder(placementRef);
        this._visitables.get("placementRef").add(this.placementRef);
    } else {
        this.placementRef = null;
        this._visitables.get("placementRef").remove(this.placementRef);
    }
    return (A) this;
  }
  
  public A withStatus(PlacementBindingStatus status) {
    this._visitables.remove("status");
    if (status != null) {
        this.status = new PlacementBindingStatusBuilder(status);
        this._visitables.get("status").add(this.status);
    } else {
        this.status = null;
        this._visitables.get("status").remove(this.status);
    }
    return (A) this;
  }
  
  public A withSubFilter(String subFilter) {
    this.subFilter = subFilter;
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
  public class BindingOverridesNested<N> extends BindingOverridesFluent<BindingOverridesNested<N>> implements Nested<N>{
  
    BindingOverridesBuilder builder;
  
    BindingOverridesNested(BindingOverrides item) {
      this.builder = new BindingOverridesBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementBindingFluent.this.withBindingOverrides(builder.build());
    }
    
    public N endBindingOverrides() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementBindingFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class PlacementRefNested<N> extends PlacementSubjectFluent<PlacementRefNested<N>> implements Nested<N>{
  
    PlacementSubjectBuilder builder;
  
    PlacementRefNested(PlacementSubject item) {
      this.builder = new PlacementSubjectBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementBindingFluent.this.withPlacementRef(builder.build());
    }
    
    public N endPlacementRef() {
      return and();
    }
    
  }
  public class StatusNested<N> extends PlacementBindingStatusFluent<StatusNested<N>> implements Nested<N>{
  
    PlacementBindingStatusBuilder builder;
  
    StatusNested(PlacementBindingStatus item) {
      this.builder = new PlacementBindingStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementBindingFluent.this.withStatus(builder.build());
    }
    
    public N endStatus() {
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
      return (N) PlacementBindingFluent.this.setToSubjects(index, builder.build());
    }
    
    public N endSubject() {
      return and();
    }
    
  }
}