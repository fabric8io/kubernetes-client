package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
public class ResourceClassParametersFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha2.ResourceClassParametersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private ArrayList<ResourceFilterBuilder> filters = new ArrayList<ResourceFilterBuilder>();
  private ResourceClassParametersReferenceBuilder generatedFrom;
  private String kind;
  private ObjectMetaBuilder metadata;
  private ArrayList<VendorParametersBuilder> vendorParameters = new ArrayList<VendorParametersBuilder>();

  public ResourceClassParametersFluent() {
  }
  
  public ResourceClassParametersFluent(ResourceClassParameters instance) {
    this.copyInstance(instance);
  }

  public A addAllToFilters(Collection<ResourceFilter> items) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    for (ResourceFilter item : items) {
        ResourceFilterBuilder builder = new ResourceFilterBuilder(item);
        _visitables.get("filters").add(builder);
        this.filters.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToVendorParameters(Collection<VendorParameters> items) {
    if (this.vendorParameters == null) {
      this.vendorParameters = new ArrayList();
    }
    for (VendorParameters item : items) {
        VendorParametersBuilder builder = new VendorParametersBuilder(item);
        _visitables.get("vendorParameters").add(builder);
        this.vendorParameters.add(builder);
    }
    return (A) this;
  }
  
  public FiltersNested<A> addNewFilter() {
    return new FiltersNested(-1, null);
  }
  
  public FiltersNested<A> addNewFilterLike(ResourceFilter item) {
    return new FiltersNested(-1, item);
  }
  
  public VendorParametersNested<A> addNewVendorParameter() {
    return new VendorParametersNested(-1, null);
  }
  
  public A addNewVendorParameter(String driverName,Object parameters) {
    return (A) this.addToVendorParameters(new VendorParameters(driverName, parameters));
  }
  
  public VendorParametersNested<A> addNewVendorParameterLike(VendorParameters item) {
    return new VendorParametersNested(-1, item);
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
  
  public A addToFilters(ResourceFilter... items) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    for (ResourceFilter item : items) {
        ResourceFilterBuilder builder = new ResourceFilterBuilder(item);
        _visitables.get("filters").add(builder);
        this.filters.add(builder);
    }
    return (A) this;
  }
  
  public A addToFilters(int index,ResourceFilter item) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    ResourceFilterBuilder builder = new ResourceFilterBuilder(item);
    if (index < 0 || index >= filters.size()) {
        _visitables.get("filters").add(builder);
        filters.add(builder);
    } else {
        _visitables.get("filters").add(builder);
        filters.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToVendorParameters(VendorParameters... items) {
    if (this.vendorParameters == null) {
      this.vendorParameters = new ArrayList();
    }
    for (VendorParameters item : items) {
        VendorParametersBuilder builder = new VendorParametersBuilder(item);
        _visitables.get("vendorParameters").add(builder);
        this.vendorParameters.add(builder);
    }
    return (A) this;
  }
  
  public A addToVendorParameters(int index,VendorParameters item) {
    if (this.vendorParameters == null) {
      this.vendorParameters = new ArrayList();
    }
    VendorParametersBuilder builder = new VendorParametersBuilder(item);
    if (index < 0 || index >= vendorParameters.size()) {
        _visitables.get("vendorParameters").add(builder);
        vendorParameters.add(builder);
    } else {
        _visitables.get("vendorParameters").add(builder);
        vendorParameters.add(index, builder);
    }
    return (A) this;
  }
  
  public ResourceFilter buildFilter(int index) {
    return this.filters.get(index).build();
  }
  
  public List<ResourceFilter> buildFilters() {
    return this.filters != null ? build(filters) : null;
  }
  
  public ResourceFilter buildFirstFilter() {
    return this.filters.get(0).build();
  }
  
  public VendorParameters buildFirstVendorParameter() {
    return this.vendorParameters.get(0).build();
  }
  
  public ResourceClassParametersReference buildGeneratedFrom() {
    return this.generatedFrom != null ? this.generatedFrom.build() : null;
  }
  
  public ResourceFilter buildLastFilter() {
    return this.filters.get(filters.size() - 1).build();
  }
  
  public VendorParameters buildLastVendorParameter() {
    return this.vendorParameters.get(vendorParameters.size() - 1).build();
  }
  
  public ResourceFilter buildMatchingFilter(Predicate<ResourceFilterBuilder> predicate) {
      for (ResourceFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VendorParameters buildMatchingVendorParameter(Predicate<VendorParametersBuilder> predicate) {
      for (VendorParametersBuilder item : vendorParameters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public VendorParameters buildVendorParameter(int index) {
    return this.vendorParameters.get(index).build();
  }
  
  public List<VendorParameters> buildVendorParameters() {
    return this.vendorParameters != null ? build(vendorParameters) : null;
  }
  
  protected void copyInstance(ResourceClassParameters instance) {
    instance = instance != null ? instance : new ResourceClassParameters();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withFilters(instance.getFilters());
        this.withGeneratedFrom(instance.getGeneratedFrom());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withVendorParameters(instance.getVendorParameters());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FiltersNested<A> editFilter(int index) {
    if (filters.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "filters"));
    }
    return this.setNewFilterLike(index, this.buildFilter(index));
  }
  
  public FiltersNested<A> editFirstFilter() {
    if (filters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "filters"));
    }
    return this.setNewFilterLike(0, this.buildFilter(0));
  }
  
  public VendorParametersNested<A> editFirstVendorParameter() {
    if (vendorParameters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "vendorParameters"));
    }
    return this.setNewVendorParameterLike(0, this.buildVendorParameter(0));
  }
  
  public GeneratedFromNested<A> editGeneratedFrom() {
    return this.withNewGeneratedFromLike(Optional.ofNullable(this.buildGeneratedFrom()).orElse(null));
  }
  
  public FiltersNested<A> editLastFilter() {
    int index = filters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "filters"));
    }
    return this.setNewFilterLike(index, this.buildFilter(index));
  }
  
  public VendorParametersNested<A> editLastVendorParameter() {
    int index = vendorParameters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "vendorParameters"));
    }
    return this.setNewVendorParameterLike(index, this.buildVendorParameter(index));
  }
  
  public FiltersNested<A> editMatchingFilter(Predicate<ResourceFilterBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < filters.size();i++) {
      if (predicate.test(filters.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "filters"));
    }
    return this.setNewFilterLike(index, this.buildFilter(index));
  }
  
  public VendorParametersNested<A> editMatchingVendorParameter(Predicate<VendorParametersBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < vendorParameters.size();i++) {
      if (predicate.test(vendorParameters.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "vendorParameters"));
    }
    return this.setNewVendorParameterLike(index, this.buildVendorParameter(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public GeneratedFromNested<A> editOrNewGeneratedFrom() {
    return this.withNewGeneratedFromLike(Optional.ofNullable(this.buildGeneratedFrom()).orElse(new ResourceClassParametersReferenceBuilder().build()));
  }
  
  public GeneratedFromNested<A> editOrNewGeneratedFromLike(ResourceClassParametersReference item) {
    return this.withNewGeneratedFromLike(Optional.ofNullable(this.buildGeneratedFrom()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public VendorParametersNested<A> editVendorParameter(int index) {
    if (vendorParameters.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "vendorParameters"));
    }
    return this.setNewVendorParameterLike(index, this.buildVendorParameter(index));
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
    ResourceClassParametersFluent that = (ResourceClassParametersFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(filters, that.filters))) {
      return false;
    }
    if (!(Objects.equals(generatedFrom, that.generatedFrom))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(vendorParameters, that.vendorParameters))) {
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
  
  public boolean hasFilters() {
    return this.filters != null && !(this.filters.isEmpty());
  }
  
  public boolean hasGeneratedFrom() {
    return this.generatedFrom != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingFilter(Predicate<ResourceFilterBuilder> predicate) {
      for (ResourceFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVendorParameter(Predicate<VendorParametersBuilder> predicate) {
      for (VendorParametersBuilder item : vendorParameters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasVendorParameters() {
    return this.vendorParameters != null && !(this.vendorParameters.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, filters, generatedFrom, kind, metadata, vendorParameters, additionalProperties);
  }
  
  public A removeAllFromFilters(Collection<ResourceFilter> items) {
    if (this.filters == null) {
      return (A) this;
    }
    for (ResourceFilter item : items) {
        ResourceFilterBuilder builder = new ResourceFilterBuilder(item);
        _visitables.get("filters").remove(builder);
        this.filters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromVendorParameters(Collection<VendorParameters> items) {
    if (this.vendorParameters == null) {
      return (A) this;
    }
    for (VendorParameters item : items) {
        VendorParametersBuilder builder = new VendorParametersBuilder(item);
        _visitables.get("vendorParameters").remove(builder);
        this.vendorParameters.remove(builder);
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
  
  public A removeFromFilters(ResourceFilter... items) {
    if (this.filters == null) {
      return (A) this;
    }
    for (ResourceFilter item : items) {
        ResourceFilterBuilder builder = new ResourceFilterBuilder(item);
        _visitables.get("filters").remove(builder);
        this.filters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromVendorParameters(VendorParameters... items) {
    if (this.vendorParameters == null) {
      return (A) this;
    }
    for (VendorParameters item : items) {
        VendorParametersBuilder builder = new VendorParametersBuilder(item);
        _visitables.get("vendorParameters").remove(builder);
        this.vendorParameters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFilters(Predicate<ResourceFilterBuilder> predicate) {
    if (filters == null) {
      return (A) this;
    }
    Iterator<ResourceFilterBuilder> each = filters.iterator();
    List visitables = _visitables.get("filters");
    while (each.hasNext()) {
        ResourceFilterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVendorParameters(Predicate<VendorParametersBuilder> predicate) {
    if (vendorParameters == null) {
      return (A) this;
    }
    Iterator<VendorParametersBuilder> each = vendorParameters.iterator();
    List visitables = _visitables.get("vendorParameters");
    while (each.hasNext()) {
        VendorParametersBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FiltersNested<A> setNewFilterLike(int index,ResourceFilter item) {
    return new FiltersNested(index, item);
  }
  
  public VendorParametersNested<A> setNewVendorParameterLike(int index,VendorParameters item) {
    return new VendorParametersNested(index, item);
  }
  
  public A setToFilters(int index,ResourceFilter item) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    ResourceFilterBuilder builder = new ResourceFilterBuilder(item);
    if (index < 0 || index >= filters.size()) {
        _visitables.get("filters").add(builder);
        filters.add(builder);
    } else {
        _visitables.get("filters").add(builder);
        filters.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToVendorParameters(int index,VendorParameters item) {
    if (this.vendorParameters == null) {
      this.vendorParameters = new ArrayList();
    }
    VendorParametersBuilder builder = new VendorParametersBuilder(item);
    if (index < 0 || index >= vendorParameters.size()) {
        _visitables.get("vendorParameters").add(builder);
        vendorParameters.add(builder);
    } else {
        _visitables.get("vendorParameters").add(builder);
        vendorParameters.set(index, builder);
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
    if (!(filters == null) && !(filters.isEmpty())) {
        sb.append("filters:");
        sb.append(filters);
        sb.append(",");
    }
    if (!(generatedFrom == null)) {
        sb.append("generatedFrom:");
        sb.append(generatedFrom);
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
    if (!(vendorParameters == null) && !(vendorParameters.isEmpty())) {
        sb.append("vendorParameters:");
        sb.append(vendorParameters);
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
  
  public A withFilters(List<ResourceFilter> filters) {
    if (this.filters != null) {
      this._visitables.get("filters").clear();
    }
    if (filters != null) {
        this.filters = new ArrayList();
        for (ResourceFilter item : filters) {
          this.addToFilters(item);
        }
    } else {
      this.filters = null;
    }
    return (A) this;
  }
  
  public A withFilters(ResourceFilter... filters) {
    if (this.filters != null) {
        this.filters.clear();
        _visitables.remove("filters");
    }
    if (filters != null) {
      for (ResourceFilter item : filters) {
        this.addToFilters(item);
      }
    }
    return (A) this;
  }
  
  public A withGeneratedFrom(ResourceClassParametersReference generatedFrom) {
    this._visitables.remove("generatedFrom");
    if (generatedFrom != null) {
        this.generatedFrom = new ResourceClassParametersReferenceBuilder(generatedFrom);
        this._visitables.get("generatedFrom").add(this.generatedFrom);
    } else {
        this.generatedFrom = null;
        this._visitables.get("generatedFrom").remove(this.generatedFrom);
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
  
  public GeneratedFromNested<A> withNewGeneratedFrom() {
    return new GeneratedFromNested(null);
  }
  
  public A withNewGeneratedFrom(String apiGroup,String kind,String name,String namespace) {
    return (A) this.withGeneratedFrom(new ResourceClassParametersReference(apiGroup, kind, name, namespace));
  }
  
  public GeneratedFromNested<A> withNewGeneratedFromLike(ResourceClassParametersReference item) {
    return new GeneratedFromNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public A withVendorParameters(List<VendorParameters> vendorParameters) {
    if (this.vendorParameters != null) {
      this._visitables.get("vendorParameters").clear();
    }
    if (vendorParameters != null) {
        this.vendorParameters = new ArrayList();
        for (VendorParameters item : vendorParameters) {
          this.addToVendorParameters(item);
        }
    } else {
      this.vendorParameters = null;
    }
    return (A) this;
  }
  
  public A withVendorParameters(VendorParameters... vendorParameters) {
    if (this.vendorParameters != null) {
        this.vendorParameters.clear();
        _visitables.remove("vendorParameters");
    }
    if (vendorParameters != null) {
      for (VendorParameters item : vendorParameters) {
        this.addToVendorParameters(item);
      }
    }
    return (A) this;
  }
  public class FiltersNested<N> extends ResourceFilterFluent<FiltersNested<N>> implements Nested<N>{
  
    ResourceFilterBuilder builder;
    int index;
  
    FiltersNested(int index,ResourceFilter item) {
      this.index = index;
      this.builder = new ResourceFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceClassParametersFluent.this.setToFilters(index, builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
  public class GeneratedFromNested<N> extends ResourceClassParametersReferenceFluent<GeneratedFromNested<N>> implements Nested<N>{
  
    ResourceClassParametersReferenceBuilder builder;
  
    GeneratedFromNested(ResourceClassParametersReference item) {
      this.builder = new ResourceClassParametersReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceClassParametersFluent.this.withGeneratedFrom(builder.build());
    }
    
    public N endGeneratedFrom() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceClassParametersFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class VendorParametersNested<N> extends VendorParametersFluent<VendorParametersNested<N>> implements Nested<N>{
  
    VendorParametersBuilder builder;
    int index;
  
    VendorParametersNested(int index,VendorParameters item) {
      this.index = index;
      this.builder = new VendorParametersBuilder(this, item);
    }
  
    public N and() {
      return (N) ResourceClassParametersFluent.this.setToVendorParameters(index, builder.build());
    }
    
    public N endVendorParameter() {
      return and();
    }
    
  }
}