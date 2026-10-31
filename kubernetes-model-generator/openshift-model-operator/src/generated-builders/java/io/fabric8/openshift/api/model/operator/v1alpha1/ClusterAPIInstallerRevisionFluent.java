package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class ClusterAPIInstallerRevisionFluent<A extends io.fabric8.openshift.api.model.operator.v1alpha1.ClusterAPIInstallerRevisionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ClusterAPIInstallerComponentBuilder> components = new ArrayList<ClusterAPIInstallerComponentBuilder>();
  private String contentID;
  private ArrayList<ClusterAPIInstallerRevisionManifestSubstitutionBuilder> manifestSubstitutions = new ArrayList<ClusterAPIInstallerRevisionManifestSubstitutionBuilder>();
  private String name;
  private Long revision;
  private List<String> unmanagedCustomResourceDefinitions = new ArrayList<String>();

  public ClusterAPIInstallerRevisionFluent() {
  }
  
  public ClusterAPIInstallerRevisionFluent(ClusterAPIInstallerRevision instance) {
    this.copyInstance(instance);
  }

  public A addAllToComponents(Collection<ClusterAPIInstallerComponent> items) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    for (ClusterAPIInstallerComponent item : items) {
        ClusterAPIInstallerComponentBuilder builder = new ClusterAPIInstallerComponentBuilder(item);
        _visitables.get("components").add(builder);
        this.components.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToManifestSubstitutions(Collection<ClusterAPIInstallerRevisionManifestSubstitution> items) {
    if (this.manifestSubstitutions == null) {
      this.manifestSubstitutions = new ArrayList();
    }
    for (ClusterAPIInstallerRevisionManifestSubstitution item : items) {
        ClusterAPIInstallerRevisionManifestSubstitutionBuilder builder = new ClusterAPIInstallerRevisionManifestSubstitutionBuilder(item);
        _visitables.get("manifestSubstitutions").add(builder);
        this.manifestSubstitutions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToUnmanagedCustomResourceDefinitions(Collection<String> items) {
    if (this.unmanagedCustomResourceDefinitions == null) {
      this.unmanagedCustomResourceDefinitions = new ArrayList();
    }
    for (String item : items) {
      this.unmanagedCustomResourceDefinitions.add(item);
    }
    return (A) this;
  }
  
  public ComponentsNested<A> addNewComponent() {
    return new ComponentsNested(-1, null);
  }
  
  public ComponentsNested<A> addNewComponentLike(ClusterAPIInstallerComponent item) {
    return new ComponentsNested(-1, item);
  }
  
  public ManifestSubstitutionsNested<A> addNewManifestSubstitution() {
    return new ManifestSubstitutionsNested(-1, null);
  }
  
  public A addNewManifestSubstitution(String key,String value) {
    return (A) this.addToManifestSubstitutions(new ClusterAPIInstallerRevisionManifestSubstitution(key, value));
  }
  
  public ManifestSubstitutionsNested<A> addNewManifestSubstitutionLike(ClusterAPIInstallerRevisionManifestSubstitution item) {
    return new ManifestSubstitutionsNested(-1, item);
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
  
  public A addToComponents(ClusterAPIInstallerComponent... items) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    for (ClusterAPIInstallerComponent item : items) {
        ClusterAPIInstallerComponentBuilder builder = new ClusterAPIInstallerComponentBuilder(item);
        _visitables.get("components").add(builder);
        this.components.add(builder);
    }
    return (A) this;
  }
  
  public A addToComponents(int index,ClusterAPIInstallerComponent item) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    ClusterAPIInstallerComponentBuilder builder = new ClusterAPIInstallerComponentBuilder(item);
    if (index < 0 || index >= components.size()) {
        _visitables.get("components").add(builder);
        components.add(builder);
    } else {
        _visitables.get("components").add(builder);
        components.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToManifestSubstitutions(ClusterAPIInstallerRevisionManifestSubstitution... items) {
    if (this.manifestSubstitutions == null) {
      this.manifestSubstitutions = new ArrayList();
    }
    for (ClusterAPIInstallerRevisionManifestSubstitution item : items) {
        ClusterAPIInstallerRevisionManifestSubstitutionBuilder builder = new ClusterAPIInstallerRevisionManifestSubstitutionBuilder(item);
        _visitables.get("manifestSubstitutions").add(builder);
        this.manifestSubstitutions.add(builder);
    }
    return (A) this;
  }
  
  public A addToManifestSubstitutions(int index,ClusterAPIInstallerRevisionManifestSubstitution item) {
    if (this.manifestSubstitutions == null) {
      this.manifestSubstitutions = new ArrayList();
    }
    ClusterAPIInstallerRevisionManifestSubstitutionBuilder builder = new ClusterAPIInstallerRevisionManifestSubstitutionBuilder(item);
    if (index < 0 || index >= manifestSubstitutions.size()) {
        _visitables.get("manifestSubstitutions").add(builder);
        manifestSubstitutions.add(builder);
    } else {
        _visitables.get("manifestSubstitutions").add(builder);
        manifestSubstitutions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToUnmanagedCustomResourceDefinitions(String... items) {
    if (this.unmanagedCustomResourceDefinitions == null) {
      this.unmanagedCustomResourceDefinitions = new ArrayList();
    }
    for (String item : items) {
      this.unmanagedCustomResourceDefinitions.add(item);
    }
    return (A) this;
  }
  
  public A addToUnmanagedCustomResourceDefinitions(int index,String item) {
    if (this.unmanagedCustomResourceDefinitions == null) {
      this.unmanagedCustomResourceDefinitions = new ArrayList();
    }
    this.unmanagedCustomResourceDefinitions.add(index, item);
    return (A) this;
  }
  
  public ClusterAPIInstallerComponent buildComponent(int index) {
    return this.components.get(index).build();
  }
  
  public List<ClusterAPIInstallerComponent> buildComponents() {
    return this.components != null ? build(components) : null;
  }
  
  public ClusterAPIInstallerComponent buildFirstComponent() {
    return this.components.get(0).build();
  }
  
  public ClusterAPIInstallerRevisionManifestSubstitution buildFirstManifestSubstitution() {
    return this.manifestSubstitutions.get(0).build();
  }
  
  public ClusterAPIInstallerComponent buildLastComponent() {
    return this.components.get(components.size() - 1).build();
  }
  
  public ClusterAPIInstallerRevisionManifestSubstitution buildLastManifestSubstitution() {
    return this.manifestSubstitutions.get(manifestSubstitutions.size() - 1).build();
  }
  
  public ClusterAPIInstallerRevisionManifestSubstitution buildManifestSubstitution(int index) {
    return this.manifestSubstitutions.get(index).build();
  }
  
  public List<ClusterAPIInstallerRevisionManifestSubstitution> buildManifestSubstitutions() {
    return this.manifestSubstitutions != null ? build(manifestSubstitutions) : null;
  }
  
  public ClusterAPIInstallerComponent buildMatchingComponent(Predicate<ClusterAPIInstallerComponentBuilder> predicate) {
      for (ClusterAPIInstallerComponentBuilder item : components) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClusterAPIInstallerRevisionManifestSubstitution buildMatchingManifestSubstitution(Predicate<ClusterAPIInstallerRevisionManifestSubstitutionBuilder> predicate) {
      for (ClusterAPIInstallerRevisionManifestSubstitutionBuilder item : manifestSubstitutions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ClusterAPIInstallerRevision instance) {
    instance = instance != null ? instance : new ClusterAPIInstallerRevision();
    if (instance != null) {
        this.withComponents(instance.getComponents());
        this.withContentID(instance.getContentID());
        this.withManifestSubstitutions(instance.getManifestSubstitutions());
        this.withName(instance.getName());
        this.withRevision(instance.getRevision());
        this.withUnmanagedCustomResourceDefinitions(instance.getUnmanagedCustomResourceDefinitions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ComponentsNested<A> editComponent(int index) {
    if (components.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "components"));
    }
    return this.setNewComponentLike(index, this.buildComponent(index));
  }
  
  public ComponentsNested<A> editFirstComponent() {
    if (components.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "components"));
    }
    return this.setNewComponentLike(0, this.buildComponent(0));
  }
  
  public ManifestSubstitutionsNested<A> editFirstManifestSubstitution() {
    if (manifestSubstitutions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "manifestSubstitutions"));
    }
    return this.setNewManifestSubstitutionLike(0, this.buildManifestSubstitution(0));
  }
  
  public ComponentsNested<A> editLastComponent() {
    int index = components.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "components"));
    }
    return this.setNewComponentLike(index, this.buildComponent(index));
  }
  
  public ManifestSubstitutionsNested<A> editLastManifestSubstitution() {
    int index = manifestSubstitutions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "manifestSubstitutions"));
    }
    return this.setNewManifestSubstitutionLike(index, this.buildManifestSubstitution(index));
  }
  
  public ManifestSubstitutionsNested<A> editManifestSubstitution(int index) {
    if (manifestSubstitutions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "manifestSubstitutions"));
    }
    return this.setNewManifestSubstitutionLike(index, this.buildManifestSubstitution(index));
  }
  
  public ComponentsNested<A> editMatchingComponent(Predicate<ClusterAPIInstallerComponentBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < components.size();i++) {
      if (predicate.test(components.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "components"));
    }
    return this.setNewComponentLike(index, this.buildComponent(index));
  }
  
  public ManifestSubstitutionsNested<A> editMatchingManifestSubstitution(Predicate<ClusterAPIInstallerRevisionManifestSubstitutionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < manifestSubstitutions.size();i++) {
      if (predicate.test(manifestSubstitutions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "manifestSubstitutions"));
    }
    return this.setNewManifestSubstitutionLike(index, this.buildManifestSubstitution(index));
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
    ClusterAPIInstallerRevisionFluent that = (ClusterAPIInstallerRevisionFluent) o;
    if (!(Objects.equals(components, that.components))) {
      return false;
    }
    if (!(Objects.equals(contentID, that.contentID))) {
      return false;
    }
    if (!(Objects.equals(manifestSubstitutions, that.manifestSubstitutions))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(revision, that.revision))) {
      return false;
    }
    if (!(Objects.equals(unmanagedCustomResourceDefinitions, that.unmanagedCustomResourceDefinitions))) {
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
  
  public String getContentID() {
    return this.contentID;
  }
  
  public String getFirstUnmanagedCustomResourceDefinition() {
    return this.unmanagedCustomResourceDefinitions.get(0);
  }
  
  public String getLastUnmanagedCustomResourceDefinition() {
    return this.unmanagedCustomResourceDefinitions.get(unmanagedCustomResourceDefinitions.size() - 1);
  }
  
  public String getMatchingUnmanagedCustomResourceDefinition(Predicate<String> predicate) {
      for (String item : unmanagedCustomResourceDefinitions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Long getRevision() {
    return this.revision;
  }
  
  public String getUnmanagedCustomResourceDefinition(int index) {
    return this.unmanagedCustomResourceDefinitions.get(index);
  }
  
  public List<String> getUnmanagedCustomResourceDefinitions() {
    return this.unmanagedCustomResourceDefinitions;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasComponents() {
    return this.components != null && !(this.components.isEmpty());
  }
  
  public boolean hasContentID() {
    return this.contentID != null;
  }
  
  public boolean hasManifestSubstitutions() {
    return this.manifestSubstitutions != null && !(this.manifestSubstitutions.isEmpty());
  }
  
  public boolean hasMatchingComponent(Predicate<ClusterAPIInstallerComponentBuilder> predicate) {
      for (ClusterAPIInstallerComponentBuilder item : components) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingManifestSubstitution(Predicate<ClusterAPIInstallerRevisionManifestSubstitutionBuilder> predicate) {
      for (ClusterAPIInstallerRevisionManifestSubstitutionBuilder item : manifestSubstitutions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingUnmanagedCustomResourceDefinition(Predicate<String> predicate) {
      for (String item : unmanagedCustomResourceDefinitions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasRevision() {
    return this.revision != null;
  }
  
  public boolean hasUnmanagedCustomResourceDefinitions() {
    return this.unmanagedCustomResourceDefinitions != null && !(this.unmanagedCustomResourceDefinitions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(components, contentID, manifestSubstitutions, name, revision, unmanagedCustomResourceDefinitions, additionalProperties);
  }
  
  public A removeAllFromComponents(Collection<ClusterAPIInstallerComponent> items) {
    if (this.components == null) {
      return (A) this;
    }
    for (ClusterAPIInstallerComponent item : items) {
        ClusterAPIInstallerComponentBuilder builder = new ClusterAPIInstallerComponentBuilder(item);
        _visitables.get("components").remove(builder);
        this.components.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromManifestSubstitutions(Collection<ClusterAPIInstallerRevisionManifestSubstitution> items) {
    if (this.manifestSubstitutions == null) {
      return (A) this;
    }
    for (ClusterAPIInstallerRevisionManifestSubstitution item : items) {
        ClusterAPIInstallerRevisionManifestSubstitutionBuilder builder = new ClusterAPIInstallerRevisionManifestSubstitutionBuilder(item);
        _visitables.get("manifestSubstitutions").remove(builder);
        this.manifestSubstitutions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromUnmanagedCustomResourceDefinitions(Collection<String> items) {
    if (this.unmanagedCustomResourceDefinitions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.unmanagedCustomResourceDefinitions.remove(item);
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
  
  public A removeFromComponents(ClusterAPIInstallerComponent... items) {
    if (this.components == null) {
      return (A) this;
    }
    for (ClusterAPIInstallerComponent item : items) {
        ClusterAPIInstallerComponentBuilder builder = new ClusterAPIInstallerComponentBuilder(item);
        _visitables.get("components").remove(builder);
        this.components.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromManifestSubstitutions(ClusterAPIInstallerRevisionManifestSubstitution... items) {
    if (this.manifestSubstitutions == null) {
      return (A) this;
    }
    for (ClusterAPIInstallerRevisionManifestSubstitution item : items) {
        ClusterAPIInstallerRevisionManifestSubstitutionBuilder builder = new ClusterAPIInstallerRevisionManifestSubstitutionBuilder(item);
        _visitables.get("manifestSubstitutions").remove(builder);
        this.manifestSubstitutions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromUnmanagedCustomResourceDefinitions(String... items) {
    if (this.unmanagedCustomResourceDefinitions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.unmanagedCustomResourceDefinitions.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromComponents(Predicate<ClusterAPIInstallerComponentBuilder> predicate) {
    if (components == null) {
      return (A) this;
    }
    Iterator<ClusterAPIInstallerComponentBuilder> each = components.iterator();
    List visitables = _visitables.get("components");
    while (each.hasNext()) {
        ClusterAPIInstallerComponentBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromManifestSubstitutions(Predicate<ClusterAPIInstallerRevisionManifestSubstitutionBuilder> predicate) {
    if (manifestSubstitutions == null) {
      return (A) this;
    }
    Iterator<ClusterAPIInstallerRevisionManifestSubstitutionBuilder> each = manifestSubstitutions.iterator();
    List visitables = _visitables.get("manifestSubstitutions");
    while (each.hasNext()) {
        ClusterAPIInstallerRevisionManifestSubstitutionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ComponentsNested<A> setNewComponentLike(int index,ClusterAPIInstallerComponent item) {
    return new ComponentsNested(index, item);
  }
  
  public ManifestSubstitutionsNested<A> setNewManifestSubstitutionLike(int index,ClusterAPIInstallerRevisionManifestSubstitution item) {
    return new ManifestSubstitutionsNested(index, item);
  }
  
  public A setToComponents(int index,ClusterAPIInstallerComponent item) {
    if (this.components == null) {
      this.components = new ArrayList();
    }
    ClusterAPIInstallerComponentBuilder builder = new ClusterAPIInstallerComponentBuilder(item);
    if (index < 0 || index >= components.size()) {
        _visitables.get("components").add(builder);
        components.add(builder);
    } else {
        _visitables.get("components").add(builder);
        components.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToManifestSubstitutions(int index,ClusterAPIInstallerRevisionManifestSubstitution item) {
    if (this.manifestSubstitutions == null) {
      this.manifestSubstitutions = new ArrayList();
    }
    ClusterAPIInstallerRevisionManifestSubstitutionBuilder builder = new ClusterAPIInstallerRevisionManifestSubstitutionBuilder(item);
    if (index < 0 || index >= manifestSubstitutions.size()) {
        _visitables.get("manifestSubstitutions").add(builder);
        manifestSubstitutions.add(builder);
    } else {
        _visitables.get("manifestSubstitutions").add(builder);
        manifestSubstitutions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToUnmanagedCustomResourceDefinitions(int index,String item) {
    if (this.unmanagedCustomResourceDefinitions == null) {
      this.unmanagedCustomResourceDefinitions = new ArrayList();
    }
    this.unmanagedCustomResourceDefinitions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(components == null) && !(components.isEmpty())) {
        sb.append("components:");
        sb.append(components);
        sb.append(",");
    }
    if (!(contentID == null)) {
        sb.append("contentID:");
        sb.append(contentID);
        sb.append(",");
    }
    if (!(manifestSubstitutions == null) && !(manifestSubstitutions.isEmpty())) {
        sb.append("manifestSubstitutions:");
        sb.append(manifestSubstitutions);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(revision == null)) {
        sb.append("revision:");
        sb.append(revision);
        sb.append(",");
    }
    if (!(unmanagedCustomResourceDefinitions == null) && !(unmanagedCustomResourceDefinitions.isEmpty())) {
        sb.append("unmanagedCustomResourceDefinitions:");
        sb.append(unmanagedCustomResourceDefinitions);
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
  
  public A withComponents(List<ClusterAPIInstallerComponent> components) {
    if (this.components != null) {
      this._visitables.get("components").clear();
    }
    if (components != null) {
        this.components = new ArrayList();
        for (ClusterAPIInstallerComponent item : components) {
          this.addToComponents(item);
        }
    } else {
      this.components = null;
    }
    return (A) this;
  }
  
  public A withComponents(ClusterAPIInstallerComponent... components) {
    if (this.components != null) {
        this.components.clear();
        _visitables.remove("components");
    }
    if (components != null) {
      for (ClusterAPIInstallerComponent item : components) {
        this.addToComponents(item);
      }
    }
    return (A) this;
  }
  
  public A withContentID(String contentID) {
    this.contentID = contentID;
    return (A) this;
  }
  
  public A withManifestSubstitutions(List<ClusterAPIInstallerRevisionManifestSubstitution> manifestSubstitutions) {
    if (this.manifestSubstitutions != null) {
      this._visitables.get("manifestSubstitutions").clear();
    }
    if (manifestSubstitutions != null) {
        this.manifestSubstitutions = new ArrayList();
        for (ClusterAPIInstallerRevisionManifestSubstitution item : manifestSubstitutions) {
          this.addToManifestSubstitutions(item);
        }
    } else {
      this.manifestSubstitutions = null;
    }
    return (A) this;
  }
  
  public A withManifestSubstitutions(ClusterAPIInstallerRevisionManifestSubstitution... manifestSubstitutions) {
    if (this.manifestSubstitutions != null) {
        this.manifestSubstitutions.clear();
        _visitables.remove("manifestSubstitutions");
    }
    if (manifestSubstitutions != null) {
      for (ClusterAPIInstallerRevisionManifestSubstitution item : manifestSubstitutions) {
        this.addToManifestSubstitutions(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withRevision(Long revision) {
    this.revision = revision;
    return (A) this;
  }
  
  public A withUnmanagedCustomResourceDefinitions(List<String> unmanagedCustomResourceDefinitions) {
    if (unmanagedCustomResourceDefinitions != null) {
        this.unmanagedCustomResourceDefinitions = new ArrayList();
        for (String item : unmanagedCustomResourceDefinitions) {
          this.addToUnmanagedCustomResourceDefinitions(item);
        }
    } else {
      this.unmanagedCustomResourceDefinitions = null;
    }
    return (A) this;
  }
  
  public A withUnmanagedCustomResourceDefinitions(String... unmanagedCustomResourceDefinitions) {
    if (this.unmanagedCustomResourceDefinitions != null) {
        this.unmanagedCustomResourceDefinitions.clear();
        _visitables.remove("unmanagedCustomResourceDefinitions");
    }
    if (unmanagedCustomResourceDefinitions != null) {
      for (String item : unmanagedCustomResourceDefinitions) {
        this.addToUnmanagedCustomResourceDefinitions(item);
      }
    }
    return (A) this;
  }
  public class ComponentsNested<N> extends ClusterAPIInstallerComponentFluent<ComponentsNested<N>> implements Nested<N>{
  
    ClusterAPIInstallerComponentBuilder builder;
    int index;
  
    ComponentsNested(int index,ClusterAPIInstallerComponent item) {
      this.index = index;
      this.builder = new ClusterAPIInstallerComponentBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterAPIInstallerRevisionFluent.this.setToComponents(index, builder.build());
    }
    
    public N endComponent() {
      return and();
    }
    
  }
  public class ManifestSubstitutionsNested<N> extends ClusterAPIInstallerRevisionManifestSubstitutionFluent<ManifestSubstitutionsNested<N>> implements Nested<N>{
  
    ClusterAPIInstallerRevisionManifestSubstitutionBuilder builder;
    int index;
  
    ManifestSubstitutionsNested(int index,ClusterAPIInstallerRevisionManifestSubstitution item) {
      this.index = index;
      this.builder = new ClusterAPIInstallerRevisionManifestSubstitutionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterAPIInstallerRevisionFluent.this.setToManifestSubstitutions(index, builder.build());
    }
    
    public N endManifestSubstitution() {
      return and();
    }
    
  }
}