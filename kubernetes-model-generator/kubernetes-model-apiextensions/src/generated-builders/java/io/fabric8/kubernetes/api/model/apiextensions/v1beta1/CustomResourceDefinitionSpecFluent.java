package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

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
public class CustomResourceDefinitionSpecFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionSpecFluent<A>> extends BaseFluent<A>{

  private ArrayList<CustomResourceColumnDefinitionBuilder> additionalPrinterColumns = new ArrayList<CustomResourceColumnDefinitionBuilder>();
  private Map<String,Object> additionalProperties;
  private CustomResourceConversionBuilder conversion;
  private String group;
  private CustomResourceDefinitionNamesBuilder names;
  private Boolean preserveUnknownFields;
  private String scope;
  private CustomResourceSubresourcesBuilder subresources;
  private CustomResourceValidationBuilder validation;
  private String version;
  private ArrayList<CustomResourceDefinitionVersionBuilder> versions = new ArrayList<CustomResourceDefinitionVersionBuilder>();

  public CustomResourceDefinitionSpecFluent() {
  }
  
  public CustomResourceDefinitionSpecFluent(CustomResourceDefinitionSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalPrinterColumns(Collection<CustomResourceColumnDefinition> items) {
    if (this.additionalPrinterColumns == null) {
      this.additionalPrinterColumns = new ArrayList();
    }
    for (CustomResourceColumnDefinition item : items) {
        CustomResourceColumnDefinitionBuilder builder = new CustomResourceColumnDefinitionBuilder(item);
        _visitables.get("additionalPrinterColumns").add(builder);
        this.additionalPrinterColumns.add(builder);
    }
    return (A) this;
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
  
  public AdditionalPrinterColumnsNested<A> addNewAdditionalPrinterColumn() {
    return new AdditionalPrinterColumnsNested(-1, null);
  }
  
  public AdditionalPrinterColumnsNested<A> addNewAdditionalPrinterColumnLike(CustomResourceColumnDefinition item) {
    return new AdditionalPrinterColumnsNested(-1, item);
  }
  
  public VersionsNested<A> addNewVersion() {
    return new VersionsNested(-1, null);
  }
  
  public VersionsNested<A> addNewVersionLike(CustomResourceDefinitionVersion item) {
    return new VersionsNested(-1, item);
  }
  
  public A addToAdditionalPrinterColumns(CustomResourceColumnDefinition... items) {
    if (this.additionalPrinterColumns == null) {
      this.additionalPrinterColumns = new ArrayList();
    }
    for (CustomResourceColumnDefinition item : items) {
        CustomResourceColumnDefinitionBuilder builder = new CustomResourceColumnDefinitionBuilder(item);
        _visitables.get("additionalPrinterColumns").add(builder);
        this.additionalPrinterColumns.add(builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalPrinterColumns(int index,CustomResourceColumnDefinition item) {
    if (this.additionalPrinterColumns == null) {
      this.additionalPrinterColumns = new ArrayList();
    }
    CustomResourceColumnDefinitionBuilder builder = new CustomResourceColumnDefinitionBuilder(item);
    if (index < 0 || index >= additionalPrinterColumns.size()) {
        _visitables.get("additionalPrinterColumns").add(builder);
        additionalPrinterColumns.add(builder);
    } else {
        _visitables.get("additionalPrinterColumns").add(builder);
        additionalPrinterColumns.add(index, builder);
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
  
  public CustomResourceColumnDefinition buildAdditionalPrinterColumn(int index) {
    return this.additionalPrinterColumns.get(index).build();
  }
  
  public List<CustomResourceColumnDefinition> buildAdditionalPrinterColumns() {
    return this.additionalPrinterColumns != null ? build(additionalPrinterColumns) : null;
  }
  
  public CustomResourceConversion buildConversion() {
    return this.conversion != null ? this.conversion.build() : null;
  }
  
  public CustomResourceColumnDefinition buildFirstAdditionalPrinterColumn() {
    return this.additionalPrinterColumns.get(0).build();
  }
  
  public CustomResourceDefinitionVersion buildFirstVersion() {
    return this.versions.get(0).build();
  }
  
  public CustomResourceColumnDefinition buildLastAdditionalPrinterColumn() {
    return this.additionalPrinterColumns.get(additionalPrinterColumns.size() - 1).build();
  }
  
  public CustomResourceDefinitionVersion buildLastVersion() {
    return this.versions.get(versions.size() - 1).build();
  }
  
  public CustomResourceColumnDefinition buildMatchingAdditionalPrinterColumn(Predicate<CustomResourceColumnDefinitionBuilder> predicate) {
      for (CustomResourceColumnDefinitionBuilder item : additionalPrinterColumns) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
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
  
  public CustomResourceSubresources buildSubresources() {
    return this.subresources != null ? this.subresources.build() : null;
  }
  
  public CustomResourceValidation buildValidation() {
    return this.validation != null ? this.validation.build() : null;
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
        this.withAdditionalPrinterColumns(instance.getAdditionalPrinterColumns());
        this.withConversion(instance.getConversion());
        this.withGroup(instance.getGroup());
        this.withNames(instance.getNames());
        this.withPreserveUnknownFields(instance.getPreserveUnknownFields());
        this.withScope(instance.getScope());
        this.withSubresources(instance.getSubresources());
        this.withValidation(instance.getValidation());
        this.withVersion(instance.getVersion());
        this.withVersions(instance.getVersions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdditionalPrinterColumnsNested<A> editAdditionalPrinterColumn(int index) {
    if (additionalPrinterColumns.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "additionalPrinterColumns"));
    }
    return this.setNewAdditionalPrinterColumnLike(index, this.buildAdditionalPrinterColumn(index));
  }
  
  public ConversionNested<A> editConversion() {
    return this.withNewConversionLike(Optional.ofNullable(this.buildConversion()).orElse(null));
  }
  
  public AdditionalPrinterColumnsNested<A> editFirstAdditionalPrinterColumn() {
    if (additionalPrinterColumns.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "additionalPrinterColumns"));
    }
    return this.setNewAdditionalPrinterColumnLike(0, this.buildAdditionalPrinterColumn(0));
  }
  
  public VersionsNested<A> editFirstVersion() {
    if (versions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "versions"));
    }
    return this.setNewVersionLike(0, this.buildVersion(0));
  }
  
  public AdditionalPrinterColumnsNested<A> editLastAdditionalPrinterColumn() {
    int index = additionalPrinterColumns.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "additionalPrinterColumns"));
    }
    return this.setNewAdditionalPrinterColumnLike(index, this.buildAdditionalPrinterColumn(index));
  }
  
  public VersionsNested<A> editLastVersion() {
    int index = versions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "versions"));
    }
    return this.setNewVersionLike(index, this.buildVersion(index));
  }
  
  public AdditionalPrinterColumnsNested<A> editMatchingAdditionalPrinterColumn(Predicate<CustomResourceColumnDefinitionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < additionalPrinterColumns.size();i++) {
      if (predicate.test(additionalPrinterColumns.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "additionalPrinterColumns"));
    }
    return this.setNewAdditionalPrinterColumnLike(index, this.buildAdditionalPrinterColumn(index));
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
  
  public SubresourcesNested<A> editOrNewSubresources() {
    return this.withNewSubresourcesLike(Optional.ofNullable(this.buildSubresources()).orElse(new CustomResourceSubresourcesBuilder().build()));
  }
  
  public SubresourcesNested<A> editOrNewSubresourcesLike(CustomResourceSubresources item) {
    return this.withNewSubresourcesLike(Optional.ofNullable(this.buildSubresources()).orElse(item));
  }
  
  public ValidationNested<A> editOrNewValidation() {
    return this.withNewValidationLike(Optional.ofNullable(this.buildValidation()).orElse(new CustomResourceValidationBuilder().build()));
  }
  
  public ValidationNested<A> editOrNewValidationLike(CustomResourceValidation item) {
    return this.withNewValidationLike(Optional.ofNullable(this.buildValidation()).orElse(item));
  }
  
  public SubresourcesNested<A> editSubresources() {
    return this.withNewSubresourcesLike(Optional.ofNullable(this.buildSubresources()).orElse(null));
  }
  
  public ValidationNested<A> editValidation() {
    return this.withNewValidationLike(Optional.ofNullable(this.buildValidation()).orElse(null));
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
    if (!(Objects.equals(additionalPrinterColumns, that.additionalPrinterColumns))) {
      return false;
    }
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
    if (!(Objects.equals(subresources, that.subresources))) {
      return false;
    }
    if (!(Objects.equals(validation, that.validation))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalPrinterColumns() {
    return this.additionalPrinterColumns != null && !(this.additionalPrinterColumns.isEmpty());
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
  
  public boolean hasMatchingAdditionalPrinterColumn(Predicate<CustomResourceColumnDefinitionBuilder> predicate) {
      for (CustomResourceColumnDefinitionBuilder item : additionalPrinterColumns) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
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
  
  public boolean hasSubresources() {
    return this.subresources != null;
  }
  
  public boolean hasValidation() {
    return this.validation != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public boolean hasVersions() {
    return this.versions != null && !(this.versions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(additionalPrinterColumns, conversion, group, names, preserveUnknownFields, scope, subresources, validation, version, versions, additionalProperties);
  }
  
  public A removeAllFromAdditionalPrinterColumns(Collection<CustomResourceColumnDefinition> items) {
    if (this.additionalPrinterColumns == null) {
      return (A) this;
    }
    for (CustomResourceColumnDefinition item : items) {
        CustomResourceColumnDefinitionBuilder builder = new CustomResourceColumnDefinitionBuilder(item);
        _visitables.get("additionalPrinterColumns").remove(builder);
        this.additionalPrinterColumns.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromAdditionalPrinterColumns(CustomResourceColumnDefinition... items) {
    if (this.additionalPrinterColumns == null) {
      return (A) this;
    }
    for (CustomResourceColumnDefinition item : items) {
        CustomResourceColumnDefinitionBuilder builder = new CustomResourceColumnDefinitionBuilder(item);
        _visitables.get("additionalPrinterColumns").remove(builder);
        this.additionalPrinterColumns.remove(builder);
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
  
  public A removeMatchingFromAdditionalPrinterColumns(Predicate<CustomResourceColumnDefinitionBuilder> predicate) {
    if (additionalPrinterColumns == null) {
      return (A) this;
    }
    Iterator<CustomResourceColumnDefinitionBuilder> each = additionalPrinterColumns.iterator();
    List visitables = _visitables.get("additionalPrinterColumns");
    while (each.hasNext()) {
        CustomResourceColumnDefinitionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
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
  
  public AdditionalPrinterColumnsNested<A> setNewAdditionalPrinterColumnLike(int index,CustomResourceColumnDefinition item) {
    return new AdditionalPrinterColumnsNested(index, item);
  }
  
  public VersionsNested<A> setNewVersionLike(int index,CustomResourceDefinitionVersion item) {
    return new VersionsNested(index, item);
  }
  
  public A setToAdditionalPrinterColumns(int index,CustomResourceColumnDefinition item) {
    if (this.additionalPrinterColumns == null) {
      this.additionalPrinterColumns = new ArrayList();
    }
    CustomResourceColumnDefinitionBuilder builder = new CustomResourceColumnDefinitionBuilder(item);
    if (index < 0 || index >= additionalPrinterColumns.size()) {
        _visitables.get("additionalPrinterColumns").add(builder);
        additionalPrinterColumns.add(builder);
    } else {
        _visitables.get("additionalPrinterColumns").add(builder);
        additionalPrinterColumns.set(index, builder);
    }
    return (A) this;
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
    if (!(additionalPrinterColumns == null) && !(additionalPrinterColumns.isEmpty())) {
        sb.append("additionalPrinterColumns:");
        sb.append(additionalPrinterColumns);
        sb.append(",");
    }
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
    if (!(subresources == null)) {
        sb.append("subresources:");
        sb.append(subresources);
        sb.append(",");
    }
    if (!(validation == null)) {
        sb.append("validation:");
        sb.append(validation);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public A withAdditionalPrinterColumns(List<CustomResourceColumnDefinition> additionalPrinterColumns) {
    if (this.additionalPrinterColumns != null) {
      this._visitables.get("additionalPrinterColumns").clear();
    }
    if (additionalPrinterColumns != null) {
        this.additionalPrinterColumns = new ArrayList();
        for (CustomResourceColumnDefinition item : additionalPrinterColumns) {
          this.addToAdditionalPrinterColumns(item);
        }
    } else {
      this.additionalPrinterColumns = null;
    }
    return (A) this;
  }
  
  public A withAdditionalPrinterColumns(CustomResourceColumnDefinition... additionalPrinterColumns) {
    if (this.additionalPrinterColumns != null) {
        this.additionalPrinterColumns.clear();
        _visitables.remove("additionalPrinterColumns");
    }
    if (additionalPrinterColumns != null) {
      for (CustomResourceColumnDefinition item : additionalPrinterColumns) {
        this.addToAdditionalPrinterColumns(item);
      }
    }
    return (A) this;
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
  
  public SubresourcesNested<A> withNewSubresources() {
    return new SubresourcesNested(null);
  }
  
  public SubresourcesNested<A> withNewSubresourcesLike(CustomResourceSubresources item) {
    return new SubresourcesNested(item);
  }
  
  public ValidationNested<A> withNewValidation() {
    return new ValidationNested(null);
  }
  
  public ValidationNested<A> withNewValidationLike(CustomResourceValidation item) {
    return new ValidationNested(item);
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
  
  public A withSubresources(CustomResourceSubresources subresources) {
    this._visitables.remove("subresources");
    if (subresources != null) {
        this.subresources = new CustomResourceSubresourcesBuilder(subresources);
        this._visitables.get("subresources").add(this.subresources);
    } else {
        this.subresources = null;
        this._visitables.get("subresources").remove(this.subresources);
    }
    return (A) this;
  }
  
  public A withValidation(CustomResourceValidation validation) {
    this._visitables.remove("validation");
    if (validation != null) {
        this.validation = new CustomResourceValidationBuilder(validation);
        this._visitables.get("validation").add(this.validation);
    } else {
        this.validation = null;
        this._visitables.get("validation").remove(this.validation);
    }
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
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
  public class AdditionalPrinterColumnsNested<N> extends CustomResourceColumnDefinitionFluent<AdditionalPrinterColumnsNested<N>> implements Nested<N>{
  
    CustomResourceColumnDefinitionBuilder builder;
    int index;
  
    AdditionalPrinterColumnsNested(int index,CustomResourceColumnDefinition item) {
      this.index = index;
      this.builder = new CustomResourceColumnDefinitionBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceDefinitionSpecFluent.this.setToAdditionalPrinterColumns(index, builder.build());
    }
    
    public N endAdditionalPrinterColumn() {
      return and();
    }
    
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
  public class SubresourcesNested<N> extends CustomResourceSubresourcesFluent<SubresourcesNested<N>> implements Nested<N>{
  
    CustomResourceSubresourcesBuilder builder;
  
    SubresourcesNested(CustomResourceSubresources item) {
      this.builder = new CustomResourceSubresourcesBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceDefinitionSpecFluent.this.withSubresources(builder.build());
    }
    
    public N endSubresources() {
      return and();
    }
    
  }
  public class ValidationNested<N> extends CustomResourceValidationFluent<ValidationNested<N>> implements Nested<N>{
  
    CustomResourceValidationBuilder builder;
  
    ValidationNested(CustomResourceValidation item) {
      this.builder = new CustomResourceValidationBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceDefinitionSpecFluent.this.withValidation(builder.build());
    }
    
    public N endValidation() {
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