package io.fabric8.kubernetes.api.model.apiextensions.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class CustomResourceDefinitionSpecFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CustomResourceConversionBuilder conversion;
  private String group;
  private CustomResourceDefinitionNamesBuilder names;
  private Boolean preserveUnknownFields;
  private String scope;
  private ArrayList<CustomResourceDefinitionVersionBuilder> versions = new ArrayList<CustomResourceDefinitionVersionBuilder>();

  public CustomResourceDefinitionSpecFluent() {
  }
  
  public CustomResourceDefinitionSpecFluent(CustomResourceDefinitionSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToVersions(Collection<CustomResourceDefinitionVersion> items) {
    if (this.versions == null) {
      this.versions = new ArrayList();
    }
    for (CustomResourceDefinitionVersion item : items) {
        CustomResourceDefinitionVersionBuilder builder = new CustomResourceDefinitionVersionBuilder(item);
        _visitables.get("versions").add(builder);
        this.versions.add(builder);
    }
    return (A) this;
  }
  
  public VersionsNested<A> addNewVersion() {
    return new VersionsNested(-1, null);
  }
  
  public VersionsNested<A> addNewVersionLike(CustomResourceDefinitionVersion item) {
    return new VersionsNested(-1, item);
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
  
  public A addToVersions(CustomResourceDefinitionVersion... items) {
    if (this.versions == null) {
      this.versions = new ArrayList();
    }
    for (CustomResourceDefinitionVersion item : items) {
        CustomResourceDefinitionVersionBuilder builder = new CustomResourceDefinitionVersionBuilder(item);
        _visitables.get("versions").add(builder);
        this.versions.add(builder);
    }
    return (A) this;
  }
  
  public A addToVersions(int index,CustomResourceDefinitionVersion item) {
    if (this.versions == null) {
      this.versions = new ArrayList();
    }
    CustomResourceDefinitionVersionBuilder builder = new CustomResourceDefinitionVersionBuilder(item);
    if (index < 0 || index >= versions.size()) {
        _visitables.get("versions").add(builder);
        versions.add(builder);
    } else {
        _visitables.get("versions").add(builder);
        versions.add(index, builder);
    }
    return (A) this;
  }
  
  public CustomResourceConversion buildConversion() {
    return this.conversion != null ? this.conversion.build() : null;
  }
  
  public CustomResourceDefinitionVersion buildFirstVersion() {
    return this.versions.get(0).build();
  }
  
  public CustomResourceDefinitionVersion buildLastVersion() {
    return this.versions.get(versions.size() - 1).build();
  }
  
  public CustomResourceDefinitionVersion buildMatchingVersion(Predicate<CustomResourceDefinitionVersionBuilder> predicate) {
      for (CustomResourceDefinitionVersionBuilder item : versions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public CustomResourceDefinitionNames buildNames() {
    return this.names != null ? this.names.build() : null;
  }
  
  public CustomResourceDefinitionVersion buildVersion(int index) {
    return this.versions.get(index).build();
  }
  
  public List<CustomResourceDefinitionVersion> buildVersions() {
    return this.versions != null ? build(versions) : null;
  }
  
  protected void copyInstance(CustomResourceDefinitionSpec instance) {
    instance = instance != null ? instance : new CustomResourceDefinitionSpec();
    if (instance != null) {
        this.withConversion(instance.getConversion());
        this.withGroup(instance.getGroup());
        this.withNames(instance.getNames());
        this.withPreserveUnknownFields(instance.getPreserveUnknownFields());
        this.withScope(instance.getScope());
        this.withVersions(instance.getVersions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConversionNested<A> editConversion() {
    return this.withNewConversionLike(Optional.ofNullable(this.buildConversion()).orElse(null));
  }
  
  public VersionsNested<A> editFirstVersion() {
    if (versions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "versions"));
    }
    return this.setNewVersionLike(0, this.buildVersion(0));
  }
  
  public VersionsNested<A> editLastVersion() {
    int index = versions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "versions"));
    }
    return this.setNewVersionLike(index, this.buildVersion(index));
  }
  
  public VersionsNested<A> editMatchingVersion(Predicate<CustomResourceDefinitionVersionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < versions.size();i++) {
      if (predicate.test(versions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "versions"));
    }
    return this.setNewVersionLike(index, this.buildVersion(index));
  }
  
  public NamesNested<A> editNames() {
    return this.withNewNamesLike(Optional.ofNullable(this.buildNames()).orElse(null));
  }
  
  public ConversionNested<A> editOrNewConversion() {
    return this.withNewConversionLike(Optional.ofNullable(this.buildConversion()).orElse(new CustomResourceConversionBuilder().build()));
  }
  
  public ConversionNested<A> editOrNewConversionLike(CustomResourceConversion item) {
    return this.withNewConversionLike(Optional.ofNullable(this.buildConversion()).orElse(item));
  }
  
  public NamesNested<A> editOrNewNames() {
    return this.withNewNamesLike(Optional.ofNullable(this.buildNames()).orElse(new CustomResourceDefinitionNamesBuilder().build()));
  }
  
  public NamesNested<A> editOrNewNamesLike(CustomResourceDefinitionNames item) {
    return this.withNewNamesLike(Optional.ofNullable(this.buildNames()).orElse(item));
  }
  
  public VersionsNested<A> editVersion(int index) {
    if (versions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "versions"));
    }
    return this.setNewVersionLike(index, this.buildVersion(index));
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
    CustomResourceDefinitionSpecFluent that = (CustomResourceDefinitionSpecFluent) o;
    if (!(Objects.equals(conversion, that.conversion))) {
      return false;
    }
    if (!(Objects.equals(group, that.group))) {
      return false;
    }
    if (!(Objects.equals(names, that.names))) {
      return false;
    }
    if (!(Objects.equals(preserveUnknownFields, that.preserveUnknownFields))) {
      return false;
    }
    if (!(Objects.equals(scope, that.scope))) {
      return false;
    }
    if (!(Objects.equals(versions, that.versions))) {
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
  
  public String getGroup() {
    return this.group;
  }
  
  public Boolean getPreserveUnknownFields() {
    return this.preserveUnknownFields;
  }
  
  public String getScope() {
    return this.scope;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConversion() {
    return this.conversion != null;
  }
  
  public boolean hasGroup() {
    return this.group != null;
  }
  
  public boolean hasMatchingVersion(Predicate<CustomResourceDefinitionVersionBuilder> predicate) {
      for (CustomResourceDefinitionVersionBuilder item : versions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNames() {
    return this.names != null;
  }
  
  public boolean hasPreserveUnknownFields() {
    return this.preserveUnknownFields != null;
  }
  
  public boolean hasScope() {
    return this.scope != null;
  }
  
  public boolean hasVersions() {
    return this.versions != null && !(this.versions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conversion, group, names, preserveUnknownFields, scope, versions, additionalProperties);
  }
  
  public A removeAllFromVersions(Collection<CustomResourceDefinitionVersion> items) {
    if (this.versions == null) {
      return (A) this;
    }
    for (CustomResourceDefinitionVersion item : items) {
        CustomResourceDefinitionVersionBuilder builder = new CustomResourceDefinitionVersionBuilder(item);
        _visitables.get("versions").remove(builder);
        this.versions.remove(builder);
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
  
  public A removeFromVersions(CustomResourceDefinitionVersion... items) {
    if (this.versions == null) {
      return (A) this;
    }
    for (CustomResourceDefinitionVersion item : items) {
        CustomResourceDefinitionVersionBuilder builder = new CustomResourceDefinitionVersionBuilder(item);
        _visitables.get("versions").remove(builder);
        this.versions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromVersions(Predicate<CustomResourceDefinitionVersionBuilder> predicate) {
    if (versions == null) {
      return (A) this;
    }
    Iterator<CustomResourceDefinitionVersionBuilder> each = versions.iterator();
    List visitables = _visitables.get("versions");
    while (each.hasNext()) {
        CustomResourceDefinitionVersionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public VersionsNested<A> setNewVersionLike(int index,CustomResourceDefinitionVersion item) {
    return new VersionsNested(index, item);
  }
  
  public A setToVersions(int index,CustomResourceDefinitionVersion item) {
    if (this.versions == null) {
      this.versions = new ArrayList();
    }
    CustomResourceDefinitionVersionBuilder builder = new CustomResourceDefinitionVersionBuilder(item);
    if (index < 0 || index >= versions.size()) {
        _visitables.get("versions").add(builder);
        versions.add(builder);
    } else {
        _visitables.get("versions").add(builder);
        versions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conversion == null)) {
        sb.append("conversion:");
        sb.append(conversion);
        sb.append(",");
    }
    if (!(group == null)) {
        sb.append("group:");
        sb.append(group);
        sb.append(",");
    }
    if (!(names == null)) {
        sb.append("names:");
        sb.append(names);
        sb.append(",");
    }
    if (!(preserveUnknownFields == null)) {
        sb.append("preserveUnknownFields:");
        sb.append(preserveUnknownFields);
        sb.append(",");
    }
    if (!(scope == null)) {
        sb.append("scope:");
        sb.append(scope);
        sb.append(",");
    }
    if (!(versions == null) && !(versions.isEmpty())) {
        sb.append("versions:");
        sb.append(versions);
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
  
  public A withConversion(CustomResourceConversion conversion) {
    this._visitables.remove("conversion");
    if (conversion != null) {
        this.conversion = new CustomResourceConversionBuilder(conversion);
        this._visitables.get("conversion").add(this.conversion);
    } else {
        this.conversion = null;
        this._visitables.get("conversion").remove(this.conversion);
    }
    return (A) this;
  }
  
  public A withGroup(String group) {
    this.group = group;
    return (A) this;
  }
  
  public A withNames(CustomResourceDefinitionNames names) {
    this._visitables.remove("names");
    if (names != null) {
        this.names = new CustomResourceDefinitionNamesBuilder(names);
        this._visitables.get("names").add(this.names);
    } else {
        this.names = null;
        this._visitables.get("names").remove(this.names);
    }
    return (A) this;
  }
  
  public ConversionNested<A> withNewConversion() {
    return new ConversionNested(null);
  }
  
  public ConversionNested<A> withNewConversionLike(CustomResourceConversion item) {
    return new ConversionNested(item);
  }
  
  public NamesNested<A> withNewNames() {
    return new NamesNested(null);
  }
  
  public NamesNested<A> withNewNamesLike(CustomResourceDefinitionNames item) {
    return new NamesNested(item);
  }
  
  public A withPreserveUnknownFields() {
    return withPreserveUnknownFields(true);
  }
  
  public A withPreserveUnknownFields(Boolean preserveUnknownFields) {
    this.preserveUnknownFields = preserveUnknownFields;
    return (A) this;
  }
  
  public A withScope(String scope) {
    this.scope = scope;
    return (A) this;
  }
  
  public A withVersions(List<CustomResourceDefinitionVersion> versions) {
    if (this.versions != null) {
      this._visitables.get("versions").clear();
    }
    if (versions != null) {
        this.versions = new ArrayList();
        for (CustomResourceDefinitionVersion item : versions) {
          this.addToVersions(item);
        }
    } else {
      this.versions = null;
    }
    return (A) this;
  }
  
  public A withVersions(CustomResourceDefinitionVersion... versions) {
    if (this.versions != null) {
        this.versions.clear();
        _visitables.remove("versions");
    }
    if (versions != null) {
      for (CustomResourceDefinitionVersion item : versions) {
        this.addToVersions(item);
      }
    }
    return (A) this;
  }
  public class ConversionNested<N> extends CustomResourceConversionFluent<ConversionNested<N>> implements Nested<N>{
  
    CustomResourceConversionBuilder builder;
  
    ConversionNested(CustomResourceConversion item) {
      this.builder = new CustomResourceConversionBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceDefinitionSpecFluent.this.withConversion(builder.build());
    }
    
    public N endConversion() {
      return and();
    }
    
  }
  public class NamesNested<N> extends CustomResourceDefinitionNamesFluent<NamesNested<N>> implements Nested<N>{
  
    CustomResourceDefinitionNamesBuilder builder;
  
    NamesNested(CustomResourceDefinitionNames item) {
      this.builder = new CustomResourceDefinitionNamesBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceDefinitionSpecFluent.this.withNames(builder.build());
    }
    
    public N endNames() {
      return and();
    }
    
  }
  public class VersionsNested<N> extends CustomResourceDefinitionVersionFluent<VersionsNested<N>> implements Nested<N>{
  
    CustomResourceDefinitionVersionBuilder builder;
    int index;
  
    VersionsNested(int index,CustomResourceDefinitionVersion item) {
      this.index = index;
      this.builder = new CustomResourceDefinitionVersionBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceDefinitionSpecFluent.this.setToVersions(index, builder.build());
    }
    
    public N endVersion() {
      return and();
    }
    
  }
}