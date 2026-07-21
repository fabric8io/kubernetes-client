package io.fabric8.knative.sources.v1;

import io.fabric8.knative.duck.v1.CloudEventOverrides;
import io.fabric8.knative.duck.v1.CloudEventOverridesBuilder;
import io.fabric8.knative.duck.v1.CloudEventOverridesFluent;
import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.duck.v1.DestinationBuilder;
import io.fabric8.knative.duck.v1.DestinationFluent;
import io.fabric8.knative.eventing.v1.SubscriptionsAPIFilter;
import io.fabric8.knative.eventing.v1.SubscriptionsAPIFilterBuilder;
import io.fabric8.knative.eventing.v1.SubscriptionsAPIFilterFluent;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ApiServerSourceSpecFluent<A extends io.fabric8.knative.sources.v1.ApiServerSourceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CloudEventOverridesBuilder ceOverrides;
  private ArrayList<SubscriptionsAPIFilterBuilder> filters = new ArrayList<SubscriptionsAPIFilterBuilder>();
  private String mode;
  private LabelSelectorBuilder namespaceSelector;
  private APIVersionKindBuilder owner;
  private ArrayList<APIVersionKindSelectorBuilder> resources = new ArrayList<APIVersionKindSelectorBuilder>();
  private String serviceAccountName;
  private DestinationBuilder sink;

  public ApiServerSourceSpecFluent() {
  }
  
  public ApiServerSourceSpecFluent(ApiServerSourceSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToFilters(Collection<SubscriptionsAPIFilter> items) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("filters").add(builder);
        this.filters.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResources(Collection<APIVersionKindSelector> items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (APIVersionKindSelector item : items) {
        APIVersionKindSelectorBuilder builder = new APIVersionKindSelectorBuilder(item);
        _visitables.get("resources").add(builder);
        this.resources.add(builder);
    }
    return (A) this;
  }
  
  public FiltersNested<A> addNewFilter() {
    return new FiltersNested(-1, null);
  }
  
  public FiltersNested<A> addNewFilterLike(SubscriptionsAPIFilter item) {
    return new FiltersNested(-1, item);
  }
  
  public ResourcesNested<A> addNewResource() {
    return new ResourcesNested(-1, null);
  }
  
  public ResourcesNested<A> addNewResourceLike(APIVersionKindSelector item) {
    return new ResourcesNested(-1, item);
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
  
  public A addToFilters(SubscriptionsAPIFilter... items) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("filters").add(builder);
        this.filters.add(builder);
    }
    return (A) this;
  }
  
  public A addToFilters(int index,SubscriptionsAPIFilter item) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
    if (index < 0 || index >= filters.size()) {
        _visitables.get("filters").add(builder);
        filters.add(builder);
    } else {
        _visitables.get("filters").add(builder);
        filters.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResources(APIVersionKindSelector... items) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    for (APIVersionKindSelector item : items) {
        APIVersionKindSelectorBuilder builder = new APIVersionKindSelectorBuilder(item);
        _visitables.get("resources").add(builder);
        this.resources.add(builder);
    }
    return (A) this;
  }
  
  public A addToResources(int index,APIVersionKindSelector item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    APIVersionKindSelectorBuilder builder = new APIVersionKindSelectorBuilder(item);
    if (index < 0 || index >= resources.size()) {
        _visitables.get("resources").add(builder);
        resources.add(builder);
    } else {
        _visitables.get("resources").add(builder);
        resources.add(index, builder);
    }
    return (A) this;
  }
  
  public CloudEventOverrides buildCeOverrides() {
    return this.ceOverrides != null ? this.ceOverrides.build() : null;
  }
  
  public SubscriptionsAPIFilter buildFilter(int index) {
    return this.filters.get(index).build();
  }
  
  public List<SubscriptionsAPIFilter> buildFilters() {
    return this.filters != null ? build(filters) : null;
  }
  
  public SubscriptionsAPIFilter buildFirstFilter() {
    return this.filters.get(0).build();
  }
  
  public APIVersionKindSelector buildFirstResource() {
    return this.resources.get(0).build();
  }
  
  public SubscriptionsAPIFilter buildLastFilter() {
    return this.filters.get(filters.size() - 1).build();
  }
  
  public APIVersionKindSelector buildLastResource() {
    return this.resources.get(resources.size() - 1).build();
  }
  
  public SubscriptionsAPIFilter buildMatchingFilter(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
      for (SubscriptionsAPIFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public APIVersionKindSelector buildMatchingResource(Predicate<APIVersionKindSelectorBuilder> predicate) {
      for (APIVersionKindSelectorBuilder item : resources) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LabelSelector buildNamespaceSelector() {
    return this.namespaceSelector != null ? this.namespaceSelector.build() : null;
  }
  
  public APIVersionKind buildOwner() {
    return this.owner != null ? this.owner.build() : null;
  }
  
  public APIVersionKindSelector buildResource(int index) {
    return this.resources.get(index).build();
  }
  
  public List<APIVersionKindSelector> buildResources() {
    return this.resources != null ? build(resources) : null;
  }
  
  public Destination buildSink() {
    return this.sink != null ? this.sink.build() : null;
  }
  
  protected void copyInstance(ApiServerSourceSpec instance) {
    instance = instance != null ? instance : new ApiServerSourceSpec();
    if (instance != null) {
        this.withCeOverrides(instance.getCeOverrides());
        this.withFilters(instance.getFilters());
        this.withMode(instance.getMode());
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withOwner(instance.getOwner());
        this.withResources(instance.getResources());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withSink(instance.getSink());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CeOverridesNested<A> editCeOverrides() {
    return this.withNewCeOverridesLike(Optional.ofNullable(this.buildCeOverrides()).orElse(null));
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
  
  public ResourcesNested<A> editFirstResource() {
    if (resources.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resources"));
    }
    return this.setNewResourceLike(0, this.buildResource(0));
  }
  
  public FiltersNested<A> editLastFilter() {
    int index = filters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "filters"));
    }
    return this.setNewFilterLike(index, this.buildFilter(index));
  }
  
  public ResourcesNested<A> editLastResource() {
    int index = resources.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
  }
  
  public FiltersNested<A> editMatchingFilter(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
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
  
  public ResourcesNested<A> editMatchingResource(Predicate<APIVersionKindSelectorBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resources.size();i++) {
      if (predicate.test(resources.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
  }
  
  public NamespaceSelectorNested<A> editNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(null));
  }
  
  public CeOverridesNested<A> editOrNewCeOverrides() {
    return this.withNewCeOverridesLike(Optional.ofNullable(this.buildCeOverrides()).orElse(new CloudEventOverridesBuilder().build()));
  }
  
  public CeOverridesNested<A> editOrNewCeOverridesLike(CloudEventOverrides item) {
    return this.withNewCeOverridesLike(Optional.ofNullable(this.buildCeOverrides()).orElse(item));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelectorLike(LabelSelector item) {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(item));
  }
  
  public OwnerNested<A> editOrNewOwner() {
    return this.withNewOwnerLike(Optional.ofNullable(this.buildOwner()).orElse(new APIVersionKindBuilder().build()));
  }
  
  public OwnerNested<A> editOrNewOwnerLike(APIVersionKind item) {
    return this.withNewOwnerLike(Optional.ofNullable(this.buildOwner()).orElse(item));
  }
  
  public SinkNested<A> editOrNewSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(new DestinationBuilder().build()));
  }
  
  public SinkNested<A> editOrNewSinkLike(Destination item) {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(item));
  }
  
  public OwnerNested<A> editOwner() {
    return this.withNewOwnerLike(Optional.ofNullable(this.buildOwner()).orElse(null));
  }
  
  public ResourcesNested<A> editResource(int index) {
    if (resources.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resources"));
    }
    return this.setNewResourceLike(index, this.buildResource(index));
  }
  
  public SinkNested<A> editSink() {
    return this.withNewSinkLike(Optional.ofNullable(this.buildSink()).orElse(null));
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
    ApiServerSourceSpecFluent that = (ApiServerSourceSpecFluent) o;
    if (!(Objects.equals(ceOverrides, that.ceOverrides))) {
      return false;
    }
    if (!(Objects.equals(filters, that.filters))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(owner, that.owner))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(sink, that.sink))) {
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
  
  public String getMode() {
    return this.mode;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCeOverrides() {
    return this.ceOverrides != null;
  }
  
  public boolean hasFilters() {
    return this.filters != null && !(this.filters.isEmpty());
  }
  
  public boolean hasMatchingFilter(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
      for (SubscriptionsAPIFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResource(Predicate<APIVersionKindSelectorBuilder> predicate) {
      for (APIVersionKindSelectorBuilder item : resources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasOwner() {
    return this.owner != null;
  }
  
  public boolean hasResources() {
    return this.resources != null && !(this.resources.isEmpty());
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasSink() {
    return this.sink != null;
  }
  
  public int hashCode() {
    return Objects.hash(ceOverrides, filters, mode, namespaceSelector, owner, resources, serviceAccountName, sink, additionalProperties);
  }
  
  public A removeAllFromFilters(Collection<SubscriptionsAPIFilter> items) {
    if (this.filters == null) {
      return (A) this;
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("filters").remove(builder);
        this.filters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResources(Collection<APIVersionKindSelector> items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (APIVersionKindSelector item : items) {
        APIVersionKindSelectorBuilder builder = new APIVersionKindSelectorBuilder(item);
        _visitables.get("resources").remove(builder);
        this.resources.remove(builder);
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
  
  public A removeFromFilters(SubscriptionsAPIFilter... items) {
    if (this.filters == null) {
      return (A) this;
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("filters").remove(builder);
        this.filters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResources(APIVersionKindSelector... items) {
    if (this.resources == null) {
      return (A) this;
    }
    for (APIVersionKindSelector item : items) {
        APIVersionKindSelectorBuilder builder = new APIVersionKindSelectorBuilder(item);
        _visitables.get("resources").remove(builder);
        this.resources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFilters(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
    if (filters == null) {
      return (A) this;
    }
    Iterator<SubscriptionsAPIFilterBuilder> each = filters.iterator();
    List visitables = _visitables.get("filters");
    while (each.hasNext()) {
        SubscriptionsAPIFilterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResources(Predicate<APIVersionKindSelectorBuilder> predicate) {
    if (resources == null) {
      return (A) this;
    }
    Iterator<APIVersionKindSelectorBuilder> each = resources.iterator();
    List visitables = _visitables.get("resources");
    while (each.hasNext()) {
        APIVersionKindSelectorBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FiltersNested<A> setNewFilterLike(int index,SubscriptionsAPIFilter item) {
    return new FiltersNested(index, item);
  }
  
  public ResourcesNested<A> setNewResourceLike(int index,APIVersionKindSelector item) {
    return new ResourcesNested(index, item);
  }
  
  public A setToFilters(int index,SubscriptionsAPIFilter item) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
    if (index < 0 || index >= filters.size()) {
        _visitables.get("filters").add(builder);
        filters.add(builder);
    } else {
        _visitables.get("filters").add(builder);
        filters.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResources(int index,APIVersionKindSelector item) {
    if (this.resources == null) {
      this.resources = new ArrayList();
    }
    APIVersionKindSelectorBuilder builder = new APIVersionKindSelectorBuilder(item);
    if (index < 0 || index >= resources.size()) {
        _visitables.get("resources").add(builder);
        resources.add(builder);
    } else {
        _visitables.get("resources").add(builder);
        resources.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ceOverrides == null)) {
        sb.append("ceOverrides:");
        sb.append(ceOverrides);
        sb.append(",");
    }
    if (!(filters == null) && !(filters.isEmpty())) {
        sb.append("filters:");
        sb.append(filters);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(namespaceSelector == null)) {
        sb.append("namespaceSelector:");
        sb.append(namespaceSelector);
        sb.append(",");
    }
    if (!(owner == null)) {
        sb.append("owner:");
        sb.append(owner);
        sb.append(",");
    }
    if (!(resources == null) && !(resources.isEmpty())) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(sink == null)) {
        sb.append("sink:");
        sb.append(sink);
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
  
  public A withCeOverrides(CloudEventOverrides ceOverrides) {
    this._visitables.remove("ceOverrides");
    if (ceOverrides != null) {
        this.ceOverrides = new CloudEventOverridesBuilder(ceOverrides);
        this._visitables.get("ceOverrides").add(this.ceOverrides);
    } else {
        this.ceOverrides = null;
        this._visitables.get("ceOverrides").remove(this.ceOverrides);
    }
    return (A) this;
  }
  
  public A withFilters(List<SubscriptionsAPIFilter> filters) {
    if (this.filters != null) {
      this._visitables.get("filters").clear();
    }
    if (filters != null) {
        this.filters = new ArrayList();
        for (SubscriptionsAPIFilter item : filters) {
          this.addToFilters(item);
        }
    } else {
      this.filters = null;
    }
    return (A) this;
  }
  
  public A withFilters(SubscriptionsAPIFilter... filters) {
    if (this.filters != null) {
        this.filters.clear();
        _visitables.remove("filters");
    }
    if (filters != null) {
      for (SubscriptionsAPIFilter item : filters) {
        this.addToFilters(item);
      }
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public A withNamespaceSelector(LabelSelector namespaceSelector) {
    this._visitables.remove("namespaceSelector");
    if (namespaceSelector != null) {
        this.namespaceSelector = new LabelSelectorBuilder(namespaceSelector);
        this._visitables.get("namespaceSelector").add(this.namespaceSelector);
    } else {
        this.namespaceSelector = null;
        this._visitables.get("namespaceSelector").remove(this.namespaceSelector);
    }
    return (A) this;
  }
  
  public CeOverridesNested<A> withNewCeOverrides() {
    return new CeOverridesNested(null);
  }
  
  public CeOverridesNested<A> withNewCeOverridesLike(CloudEventOverrides item) {
    return new CeOverridesNested(item);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelector() {
    return new NamespaceSelectorNested(null);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelectorLike(LabelSelector item) {
    return new NamespaceSelectorNested(item);
  }
  
  public OwnerNested<A> withNewOwner() {
    return new OwnerNested(null);
  }
  
  public A withNewOwner(String apiVersion,String kind) {
    return (A) this.withOwner(new APIVersionKind(apiVersion, kind));
  }
  
  public OwnerNested<A> withNewOwnerLike(APIVersionKind item) {
    return new OwnerNested(item);
  }
  
  public SinkNested<A> withNewSink() {
    return new SinkNested(null);
  }
  
  public SinkNested<A> withNewSinkLike(Destination item) {
    return new SinkNested(item);
  }
  
  public A withOwner(APIVersionKind owner) {
    this._visitables.remove("owner");
    if (owner != null) {
        this.owner = new APIVersionKindBuilder(owner);
        this._visitables.get("owner").add(this.owner);
    } else {
        this.owner = null;
        this._visitables.get("owner").remove(this.owner);
    }
    return (A) this;
  }
  
  public A withResources(List<APIVersionKindSelector> resources) {
    if (this.resources != null) {
      this._visitables.get("resources").clear();
    }
    if (resources != null) {
        this.resources = new ArrayList();
        for (APIVersionKindSelector item : resources) {
          this.addToResources(item);
        }
    } else {
      this.resources = null;
    }
    return (A) this;
  }
  
  public A withResources(APIVersionKindSelector... resources) {
    if (this.resources != null) {
        this.resources.clear();
        _visitables.remove("resources");
    }
    if (resources != null) {
      for (APIVersionKindSelector item : resources) {
        this.addToResources(item);
      }
    }
    return (A) this;
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  
  public A withSink(Destination sink) {
    this._visitables.remove("sink");
    if (sink != null) {
        this.sink = new DestinationBuilder(sink);
        this._visitables.get("sink").add(this.sink);
    } else {
        this.sink = null;
        this._visitables.get("sink").remove(this.sink);
    }
    return (A) this;
  }
  public class CeOverridesNested<N> extends CloudEventOverridesFluent<CeOverridesNested<N>> implements Nested<N>{
  
    CloudEventOverridesBuilder builder;
  
    CeOverridesNested(CloudEventOverrides item) {
      this.builder = new CloudEventOverridesBuilder(this, item);
    }
  
    public N and() {
      return (N) ApiServerSourceSpecFluent.this.withCeOverrides(builder.build());
    }
    
    public N endCeOverrides() {
      return and();
    }
    
  }
  public class FiltersNested<N> extends SubscriptionsAPIFilterFluent<FiltersNested<N>> implements Nested<N>{
  
    SubscriptionsAPIFilterBuilder builder;
    int index;
  
    FiltersNested(int index,SubscriptionsAPIFilter item) {
      this.index = index;
      this.builder = new SubscriptionsAPIFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) ApiServerSourceSpecFluent.this.setToFilters(index, builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
  public class NamespaceSelectorNested<N> extends LabelSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ApiServerSourceSpecFluent.this.withNamespaceSelector(builder.build());
    }
    
    public N endNamespaceSelector() {
      return and();
    }
    
  }
  public class OwnerNested<N> extends APIVersionKindFluent<OwnerNested<N>> implements Nested<N>{
  
    APIVersionKindBuilder builder;
  
    OwnerNested(APIVersionKind item) {
      this.builder = new APIVersionKindBuilder(this, item);
    }
  
    public N and() {
      return (N) ApiServerSourceSpecFluent.this.withOwner(builder.build());
    }
    
    public N endOwner() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends APIVersionKindSelectorFluent<ResourcesNested<N>> implements Nested<N>{
  
    APIVersionKindSelectorBuilder builder;
    int index;
  
    ResourcesNested(int index,APIVersionKindSelector item) {
      this.index = index;
      this.builder = new APIVersionKindSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ApiServerSourceSpecFluent.this.setToResources(index, builder.build());
    }
    
    public N endResource() {
      return and();
    }
    
  }
  public class SinkNested<N> extends DestinationFluent<SinkNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    SinkNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) ApiServerSourceSpecFluent.this.withSink(builder.build());
    }
    
    public N endSink() {
      return and();
    }
    
  }
}