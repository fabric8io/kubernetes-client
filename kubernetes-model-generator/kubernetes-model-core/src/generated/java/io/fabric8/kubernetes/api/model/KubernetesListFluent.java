package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class KubernetesListFluent<A extends io.fabric8.kubernetes.api.model.KubernetesListFluent<A>> extends BaseFluent<A>{

  private String apiVersion;
  private ArrayList<VisitableBuilder<? extends HasMetadata,?>> items = new ArrayList<VisitableBuilder<? extends HasMetadata,?>>();
  private String kind;
  private ListMetaBuilder metadata;

  public KubernetesListFluent() {
  }
  
  public KubernetesListFluent(KubernetesList instance) {
    this.copyInstance(instance);
  }

  public A addAllToItems(Collection<HasMetadata> items) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    for (HasMetadata item : items) {
        VisitableBuilder<? extends HasMetadata,?> builder = builder(item);
        _visitables.get("items").add(builder);
        this.items.add(builder);
    }
    return (A) this;
  }
  
  public APIServiceItemsNested<A> addNewAPIServiceItem() {
    return new APIServiceItemsNested(-1, null);
  }
  
  public APIServiceItemsNested<A> addNewAPIServiceItemLike(APIService item) {
    return new APIServiceItemsNested(-1, item);
  }
  
  public BindingItemsNested<A> addNewBindingItem() {
    return new BindingItemsNested(-1, null);
  }
  
  public BindingItemsNested<A> addNewBindingItemLike(Binding item) {
    return new BindingItemsNested(-1, item);
  }
  
  public ComponentStatusItemsNested<A> addNewComponentStatusItem() {
    return new ComponentStatusItemsNested(-1, null);
  }
  
  public ComponentStatusItemsNested<A> addNewComponentStatusItemLike(ComponentStatus item) {
    return new ComponentStatusItemsNested(-1, item);
  }
  
  public ConfigMapItemsNested<A> addNewConfigMapItem() {
    return new ConfigMapItemsNested(-1, null);
  }
  
  public ConfigMapItemsNested<A> addNewConfigMapItemLike(ConfigMap item) {
    return new ConfigMapItemsNested(-1, item);
  }
  
  public EndpointsItemsNested<A> addNewEndpointsItem() {
    return new EndpointsItemsNested(-1, null);
  }
  
  public EndpointsItemsNested<A> addNewEndpointsItemLike(Endpoints item) {
    return new EndpointsItemsNested(-1, item);
  }
  
  public EventItemsNested<A> addNewEventItem() {
    return new EventItemsNested(-1, null);
  }
  
  public EventItemsNested<A> addNewEventItemLike(Event item) {
    return new EventItemsNested(-1, item);
  }
  
  public GenericKubernetesResourceItemsNested<A> addNewGenericKubernetesResourceItem() {
    return new GenericKubernetesResourceItemsNested(-1, null);
  }
  
  public GenericKubernetesResourceItemsNested<A> addNewGenericKubernetesResourceItemLike(GenericKubernetesResource item) {
    return new GenericKubernetesResourceItemsNested(-1, item);
  }
  
  public LimitRangeItemsNested<A> addNewLimitRangeItem() {
    return new LimitRangeItemsNested(-1, null);
  }
  
  public LimitRangeItemsNested<A> addNewLimitRangeItemLike(LimitRange item) {
    return new LimitRangeItemsNested(-1, item);
  }
  
  public NamespaceItemsNested<A> addNewNamespaceItem() {
    return new NamespaceItemsNested(-1, null);
  }
  
  public NamespaceItemsNested<A> addNewNamespaceItemLike(Namespace item) {
    return new NamespaceItemsNested(-1, item);
  }
  
  public NodeItemsNested<A> addNewNodeItem() {
    return new NodeItemsNested(-1, null);
  }
  
  public NodeItemsNested<A> addNewNodeItemLike(Node item) {
    return new NodeItemsNested(-1, item);
  }
  
  public PersistentVolumeClaimItemsNested<A> addNewPersistentVolumeClaimItem() {
    return new PersistentVolumeClaimItemsNested(-1, null);
  }
  
  public PersistentVolumeClaimItemsNested<A> addNewPersistentVolumeClaimItemLike(PersistentVolumeClaim item) {
    return new PersistentVolumeClaimItemsNested(-1, item);
  }
  
  public PersistentVolumeItemsNested<A> addNewPersistentVolumeItem() {
    return new PersistentVolumeItemsNested(-1, null);
  }
  
  public PersistentVolumeItemsNested<A> addNewPersistentVolumeItemLike(PersistentVolume item) {
    return new PersistentVolumeItemsNested(-1, item);
  }
  
  public PodItemsNested<A> addNewPodItem() {
    return new PodItemsNested(-1, null);
  }
  
  public PodItemsNested<A> addNewPodItemLike(Pod item) {
    return new PodItemsNested(-1, item);
  }
  
  public PodTemplateItemsNested<A> addNewPodTemplateItem() {
    return new PodTemplateItemsNested(-1, null);
  }
  
  public PodTemplateItemsNested<A> addNewPodTemplateItemLike(PodTemplate item) {
    return new PodTemplateItemsNested(-1, item);
  }
  
  public ReplicationControllerItemsNested<A> addNewReplicationControllerItem() {
    return new ReplicationControllerItemsNested(-1, null);
  }
  
  public ReplicationControllerItemsNested<A> addNewReplicationControllerItemLike(ReplicationController item) {
    return new ReplicationControllerItemsNested(-1, item);
  }
  
  public ResourceQuotaItemsNested<A> addNewResourceQuotaItem() {
    return new ResourceQuotaItemsNested(-1, null);
  }
  
  public ResourceQuotaItemsNested<A> addNewResourceQuotaItemLike(ResourceQuota item) {
    return new ResourceQuotaItemsNested(-1, item);
  }
  
  public SecretItemsNested<A> addNewSecretItem() {
    return new SecretItemsNested(-1, null);
  }
  
  public SecretItemsNested<A> addNewSecretItemLike(Secret item) {
    return new SecretItemsNested(-1, item);
  }
  
  public ServiceAccountItemsNested<A> addNewServiceAccountItem() {
    return new ServiceAccountItemsNested(-1, null);
  }
  
  public ServiceAccountItemsNested<A> addNewServiceAccountItemLike(ServiceAccount item) {
    return new ServiceAccountItemsNested(-1, item);
  }
  
  public ServiceItemsNested<A> addNewServiceItem() {
    return new ServiceItemsNested(-1, null);
  }
  
  public ServiceItemsNested<A> addNewServiceItemLike(Service item) {
    return new ServiceItemsNested(-1, item);
  }
  
  public A addToItems(VisitableBuilder<? extends HasMetadata,?> builder) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    _visitables.get("items").add(builder);
    this.items.add(builder);
    return (A) this;
  }
  
  public A addToItems(HasMetadata... items) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    for (HasMetadata item : items) {
        VisitableBuilder<? extends HasMetadata,?> builder = builder(item);
        _visitables.get("items").add(builder);
        this.items.add(builder);
    }
    return (A) this;
  }
  
  public A addToItems(int index,VisitableBuilder<? extends HasMetadata,?> builder) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    if (index < 0 || index >= items.size()) {
        _visitables.get("items").add(builder);
        items.add(builder);
    } else {
        _visitables.get("items").add(builder);
        items.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToItems(int index,HasMetadata item) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    VisitableBuilder<? extends HasMetadata,?> builder = builder(item);
    if (index < 0 || index >= items.size()) {
        _visitables.get("items").add(builder);
        items.add(builder);
    } else {
        _visitables.get("items").add(builder);
        items.add(index, builder);
    }
    return (A) this;
  }
  
  public HasMetadata buildFirstItem() {
    return this.items.get(0).build();
  }
  
  public HasMetadata buildItem(int index) {
    return this.items.get(index).build();
  }
  
  public List<HasMetadata> buildItems() {
    return build(items);
  }
  
  public HasMetadata buildLastItem() {
    return this.items.get(items.size() - 1).build();
  }
  
  public HasMetadata buildMatchingItem(Predicate<VisitableBuilder<? extends HasMetadata,?>> predicate) {
      for (VisitableBuilder<? extends HasMetadata,?> item : items) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ListMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  protected static <T>VisitableBuilder<T,?> builder(Object item) {
    switch (item.getClass().getName()) {
      case "LimitRange":
    
          return (VisitableBuilder<T,?>) new LimitRangeBuilder((LimitRange) item);
    
      case "APIService":
    
          return (VisitableBuilder<T,?>) new APIServiceBuilder((APIService) item);
    
      case "Namespace":
    
          return (VisitableBuilder<T,?>) new NamespaceBuilder((Namespace) item);
    
      case "Service":
    
          return (VisitableBuilder<T,?>) new ServiceBuilder((Service) item);
    
      case "ReplicationController":
    
          return (VisitableBuilder<T,?>) new ReplicationControllerBuilder((ReplicationController) item);
    
      case "PodTemplate":
    
          return (VisitableBuilder<T,?>) new PodTemplateBuilder((PodTemplate) item);
    
      case "Event":
    
          return (VisitableBuilder<T,?>) new EventBuilder((Event) item);
    
      case "PersistentVolume":
    
          return (VisitableBuilder<T,?>) new PersistentVolumeBuilder((PersistentVolume) item);
    
      case "PersistentVolumeClaim":
    
          return (VisitableBuilder<T,?>) new PersistentVolumeClaimBuilder((PersistentVolumeClaim) item);
    
      case "GenericKubernetesResource":
    
          return (VisitableBuilder<T,?>) new GenericKubernetesResourceBuilder((GenericKubernetesResource) item);
    
      case "Endpoints":
    
          return (VisitableBuilder<T,?>) new EndpointsBuilder((Endpoints) item);
    
      case "Pod":
    
          return (VisitableBuilder<T,?>) new PodBuilder((Pod) item);
    
      case "ConfigMap":
    
          return (VisitableBuilder<T,?>) new ConfigMapBuilder((ConfigMap) item);
    
      case "ComponentStatus":
    
          return (VisitableBuilder<T,?>) new ComponentStatusBuilder((ComponentStatus) item);
    
      case "Binding":
    
          return (VisitableBuilder<T,?>) new BindingBuilder((Binding) item);
    
      case "ResourceQuota":
    
          return (VisitableBuilder<T,?>) new ResourceQuotaBuilder((ResourceQuota) item);
    
      case "Secret":
    
          return (VisitableBuilder<T,?>) new SecretBuilder((Secret) item);
    
      case "Node":
    
          return (VisitableBuilder<T,?>) new NodeBuilder((Node) item);
    
      case "ServiceAccount":
    
          return (VisitableBuilder<T,?>) new ServiceAccountBuilder((ServiceAccount) item);
    
      default:
    
          return (VisitableBuilder<T,?>) builderOf(item);
    
    }
  }
  
  protected void copyInstance(KubernetesList instance) {
    instance = instance != null ? instance : new KubernetesList();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withItems(instance.getItems());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
    }
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ListMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ListMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
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
    KubernetesListFluent that = (KubernetesListFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(items, that.items))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    return true;
  }
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasItems() {
    return this.items != null && !(this.items.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingItem(Predicate<VisitableBuilder<? extends HasMetadata,?>> predicate) {
      for (VisitableBuilder<? extends HasMetadata,?> item : items) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, items, kind, metadata);
  }
  
  public A removeAllFromItems(Collection<HasMetadata> items) {
    if (this.items == null) {
      return (A) this;
    }
    for (HasMetadata item : items) {
        VisitableBuilder<? extends HasMetadata,?> builder = builder(item);
        _visitables.get("items").remove(builder);
        this.items.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromItems(VisitableBuilder<? extends HasMetadata,?> builder) {
    if (this.items == null) {
      return (A) this;
    }
    _visitables.get("items").remove(builder);
    this.items.remove(builder);
    return (A) this;
  }
  
  public A removeFromItems(HasMetadata... items) {
    if (this.items == null) {
      return (A) this;
    }
    for (HasMetadata item : items) {
        VisitableBuilder<? extends HasMetadata,?> builder = builder(item);
        _visitables.get("items").remove(builder);
        this.items.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromItems(Predicate<VisitableBuilder<? extends HasMetadata,?>> predicate) {
    if (items == null) {
      return (A) this;
    }
    Iterator<VisitableBuilder<? extends HasMetadata,?>> each = items.iterator();
    List visitables = _visitables.get("items");
    while (each.hasNext()) {
        VisitableBuilder<? extends HasMetadata,?> builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public APIServiceItemsNested<A> setNewAPIServiceItemLike(int index,APIService item) {
    return new APIServiceItemsNested(index, item);
  }
  
  public BindingItemsNested<A> setNewBindingItemLike(int index,Binding item) {
    return new BindingItemsNested(index, item);
  }
  
  public ComponentStatusItemsNested<A> setNewComponentStatusItemLike(int index,ComponentStatus item) {
    return new ComponentStatusItemsNested(index, item);
  }
  
  public ConfigMapItemsNested<A> setNewConfigMapItemLike(int index,ConfigMap item) {
    return new ConfigMapItemsNested(index, item);
  }
  
  public EndpointsItemsNested<A> setNewEndpointsItemLike(int index,Endpoints item) {
    return new EndpointsItemsNested(index, item);
  }
  
  public EventItemsNested<A> setNewEventItemLike(int index,Event item) {
    return new EventItemsNested(index, item);
  }
  
  public GenericKubernetesResourceItemsNested<A> setNewGenericKubernetesResourceItemLike(int index,GenericKubernetesResource item) {
    return new GenericKubernetesResourceItemsNested(index, item);
  }
  
  public LimitRangeItemsNested<A> setNewLimitRangeItemLike(int index,LimitRange item) {
    return new LimitRangeItemsNested(index, item);
  }
  
  public NamespaceItemsNested<A> setNewNamespaceItemLike(int index,Namespace item) {
    return new NamespaceItemsNested(index, item);
  }
  
  public NodeItemsNested<A> setNewNodeItemLike(int index,Node item) {
    return new NodeItemsNested(index, item);
  }
  
  public PersistentVolumeClaimItemsNested<A> setNewPersistentVolumeClaimItemLike(int index,PersistentVolumeClaim item) {
    return new PersistentVolumeClaimItemsNested(index, item);
  }
  
  public PersistentVolumeItemsNested<A> setNewPersistentVolumeItemLike(int index,PersistentVolume item) {
    return new PersistentVolumeItemsNested(index, item);
  }
  
  public PodItemsNested<A> setNewPodItemLike(int index,Pod item) {
    return new PodItemsNested(index, item);
  }
  
  public PodTemplateItemsNested<A> setNewPodTemplateItemLike(int index,PodTemplate item) {
    return new PodTemplateItemsNested(index, item);
  }
  
  public ReplicationControllerItemsNested<A> setNewReplicationControllerItemLike(int index,ReplicationController item) {
    return new ReplicationControllerItemsNested(index, item);
  }
  
  public ResourceQuotaItemsNested<A> setNewResourceQuotaItemLike(int index,ResourceQuota item) {
    return new ResourceQuotaItemsNested(index, item);
  }
  
  public SecretItemsNested<A> setNewSecretItemLike(int index,Secret item) {
    return new SecretItemsNested(index, item);
  }
  
  public ServiceAccountItemsNested<A> setNewServiceAccountItemLike(int index,ServiceAccount item) {
    return new ServiceAccountItemsNested(index, item);
  }
  
  public ServiceItemsNested<A> setNewServiceItemLike(int index,Service item) {
    return new ServiceItemsNested(index, item);
  }
  
  public A setToItems(int index,HasMetadata item) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    VisitableBuilder<? extends HasMetadata,?> builder = builder(item);
    if (index < 0 || index >= items.size()) {
        _visitables.get("items").add(builder);
        items.add(builder);
    } else {
        _visitables.get("items").add(builder);
        items.set(index, builder);
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
    if (!(items == null) && !(items.isEmpty())) {
        sb.append("items:");
        sb.append(items);
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
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withItems(List<HasMetadata> items) {
    if (items != null) {
        this.items = new ArrayList();
        for (HasMetadata item : items) {
          this.addToItems(item);
        }
    } else {
      this.items = null;
    }
    return (A) this;
  }
  
  public A withItems(HasMetadata... items) {
    if (this.items != null) {
        this.items.clear();
        _visitables.remove("items");
    }
    if (items != null) {
      for (HasMetadata item : items) {
        this.addToItems(item);
      }
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMetadata(ListMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ListMetaBuilder(metadata);
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
  
  public MetadataNested<A> withNewMetadataLike(ListMeta item) {
    return new MetadataNested(item);
  }
  public class APIServiceItemsNested<N> extends APIServiceFluent<APIServiceItemsNested<N>> implements Nested<N>{
  
    APIServiceBuilder builder;
    int index;
  
    APIServiceItemsNested(int index,APIService item) {
      this.index = index;
      this.builder = new APIServiceBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endAPIServiceItem() {
      return and();
    }
    
  }
  public class BindingItemsNested<N> extends BindingFluent<BindingItemsNested<N>> implements Nested<N>{
  
    BindingBuilder builder;
    int index;
  
    BindingItemsNested(int index,Binding item) {
      this.index = index;
      this.builder = new BindingBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endBindingItem() {
      return and();
    }
    
  }
  public class ComponentStatusItemsNested<N> extends ComponentStatusFluent<ComponentStatusItemsNested<N>> implements Nested<N>{
  
    ComponentStatusBuilder builder;
    int index;
  
    ComponentStatusItemsNested(int index,ComponentStatus item) {
      this.index = index;
      this.builder = new ComponentStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endComponentStatusItem() {
      return and();
    }
    
  }
  public class ConfigMapItemsNested<N> extends ConfigMapFluent<ConfigMapItemsNested<N>> implements Nested<N>{
  
    ConfigMapBuilder builder;
    int index;
  
    ConfigMapItemsNested(int index,ConfigMap item) {
      this.index = index;
      this.builder = new ConfigMapBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endConfigMapItem() {
      return and();
    }
    
  }
  public class EndpointsItemsNested<N> extends EndpointsFluent<EndpointsItemsNested<N>> implements Nested<N>{
  
    EndpointsBuilder builder;
    int index;
  
    EndpointsItemsNested(int index,Endpoints item) {
      this.index = index;
      this.builder = new EndpointsBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endEndpointsItem() {
      return and();
    }
    
  }
  public class EventItemsNested<N> extends EventFluent<EventItemsNested<N>> implements Nested<N>{
  
    EventBuilder builder;
    int index;
  
    EventItemsNested(int index,Event item) {
      this.index = index;
      this.builder = new EventBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endEventItem() {
      return and();
    }
    
  }
  public class GenericKubernetesResourceItemsNested<N> extends GenericKubernetesResourceFluent<GenericKubernetesResourceItemsNested<N>> implements Nested<N>{
  
    GenericKubernetesResourceBuilder builder;
    int index;
  
    GenericKubernetesResourceItemsNested(int index,GenericKubernetesResource item) {
      this.index = index;
      this.builder = new GenericKubernetesResourceBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endGenericKubernetesResourceItem() {
      return and();
    }
    
  }
  public class LimitRangeItemsNested<N> extends LimitRangeFluent<LimitRangeItemsNested<N>> implements Nested<N>{
  
    LimitRangeBuilder builder;
    int index;
  
    LimitRangeItemsNested(int index,LimitRange item) {
      this.index = index;
      this.builder = new LimitRangeBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endLimitRangeItem() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ListMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ListMetaBuilder builder;
  
    MetadataNested(ListMeta item) {
      this.builder = new ListMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class NamespaceItemsNested<N> extends NamespaceFluent<NamespaceItemsNested<N>> implements Nested<N>{
  
    NamespaceBuilder builder;
    int index;
  
    NamespaceItemsNested(int index,Namespace item) {
      this.index = index;
      this.builder = new NamespaceBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endNamespaceItem() {
      return and();
    }
    
  }
  public class NodeItemsNested<N> extends NodeFluent<NodeItemsNested<N>> implements Nested<N>{
  
    NodeBuilder builder;
    int index;
  
    NodeItemsNested(int index,Node item) {
      this.index = index;
      this.builder = new NodeBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endNodeItem() {
      return and();
    }
    
  }
  public class PersistentVolumeClaimItemsNested<N> extends PersistentVolumeClaimFluent<PersistentVolumeClaimItemsNested<N>> implements Nested<N>{
  
    PersistentVolumeClaimBuilder builder;
    int index;
  
    PersistentVolumeClaimItemsNested(int index,PersistentVolumeClaim item) {
      this.index = index;
      this.builder = new PersistentVolumeClaimBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endPersistentVolumeClaimItem() {
      return and();
    }
    
  }
  public class PersistentVolumeItemsNested<N> extends PersistentVolumeFluent<PersistentVolumeItemsNested<N>> implements Nested<N>{
  
    PersistentVolumeBuilder builder;
    int index;
  
    PersistentVolumeItemsNested(int index,PersistentVolume item) {
      this.index = index;
      this.builder = new PersistentVolumeBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endPersistentVolumeItem() {
      return and();
    }
    
  }
  public class PodItemsNested<N> extends PodFluent<PodItemsNested<N>> implements Nested<N>{
  
    PodBuilder builder;
    int index;
  
    PodItemsNested(int index,Pod item) {
      this.index = index;
      this.builder = new PodBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endPodItem() {
      return and();
    }
    
  }
  public class PodTemplateItemsNested<N> extends PodTemplateFluent<PodTemplateItemsNested<N>> implements Nested<N>{
  
    PodTemplateBuilder builder;
    int index;
  
    PodTemplateItemsNested(int index,PodTemplate item) {
      this.index = index;
      this.builder = new PodTemplateBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endPodTemplateItem() {
      return and();
    }
    
  }
  public class ReplicationControllerItemsNested<N> extends ReplicationControllerFluent<ReplicationControllerItemsNested<N>> implements Nested<N>{
  
    ReplicationControllerBuilder builder;
    int index;
  
    ReplicationControllerItemsNested(int index,ReplicationController item) {
      this.index = index;
      this.builder = new ReplicationControllerBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endReplicationControllerItem() {
      return and();
    }
    
  }
  public class ResourceQuotaItemsNested<N> extends ResourceQuotaFluent<ResourceQuotaItemsNested<N>> implements Nested<N>{
  
    ResourceQuotaBuilder builder;
    int index;
  
    ResourceQuotaItemsNested(int index,ResourceQuota item) {
      this.index = index;
      this.builder = new ResourceQuotaBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endResourceQuotaItem() {
      return and();
    }
    
  }
  public class SecretItemsNested<N> extends SecretFluent<SecretItemsNested<N>> implements Nested<N>{
  
    SecretBuilder builder;
    int index;
  
    SecretItemsNested(int index,Secret item) {
      this.index = index;
      this.builder = new SecretBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endSecretItem() {
      return and();
    }
    
  }
  public class ServiceAccountItemsNested<N> extends ServiceAccountFluent<ServiceAccountItemsNested<N>> implements Nested<N>{
  
    ServiceAccountBuilder builder;
    int index;
  
    ServiceAccountItemsNested(int index,ServiceAccount item) {
      this.index = index;
      this.builder = new ServiceAccountBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endServiceAccountItem() {
      return and();
    }
    
  }
  public class ServiceItemsNested<N> extends ServiceFluent<ServiceItemsNested<N>> implements Nested<N>{
  
    ServiceBuilder builder;
    int index;
  
    ServiceItemsNested(int index,Service item) {
      this.index = index;
      this.builder = new ServiceBuilder(this, item);
    }
  
    public N and() {
      return (N) KubernetesListFluent.this.setToItems(index, builder.build());
    }
    
    public N endServiceItem() {
      return and();
    }
    
  }
}