package io.fabric8.openshift.api.model.installer.nutanix.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class FailureDomainFluent<A extends io.fabric8.openshift.api.model.installer.nutanix.v1.FailureDomainFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<StorageResourceReferenceBuilder> dataSourceImages = new ArrayList<StorageResourceReferenceBuilder>();
  private String name;
  private PrismElementBuilder prismElement;
  private ArrayList<StorageResourceReferenceBuilder> storageContainers = new ArrayList<StorageResourceReferenceBuilder>();
  private List<String> subnetUUIDs = new ArrayList<String>();

  public FailureDomainFluent() {
  }
  
  public FailureDomainFluent(FailureDomain instance) {
    this.copyInstance(instance);
  }

  public A addAllToDataSourceImages(Collection<StorageResourceReference> items) {
    if (this.dataSourceImages == null) {
      this.dataSourceImages = new ArrayList();
    }
    for (StorageResourceReference item : items) {
        StorageResourceReferenceBuilder builder = new StorageResourceReferenceBuilder(item);
        _visitables.get("dataSourceImages").add(builder);
        this.dataSourceImages.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToStorageContainers(Collection<StorageResourceReference> items) {
    if (this.storageContainers == null) {
      this.storageContainers = new ArrayList();
    }
    for (StorageResourceReference item : items) {
        StorageResourceReferenceBuilder builder = new StorageResourceReferenceBuilder(item);
        _visitables.get("storageContainers").add(builder);
        this.storageContainers.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSubnetUUIDs(Collection<String> items) {
    if (this.subnetUUIDs == null) {
      this.subnetUUIDs = new ArrayList();
    }
    for (String item : items) {
      this.subnetUUIDs.add(item);
    }
    return (A) this;
  }
  
  public DataSourceImagesNested<A> addNewDataSourceImage() {
    return new DataSourceImagesNested(-1, null);
  }
  
  public A addNewDataSourceImage(String name,String referenceName,String uuid) {
    return (A) this.addToDataSourceImages(new StorageResourceReference(name, referenceName, uuid));
  }
  
  public DataSourceImagesNested<A> addNewDataSourceImageLike(StorageResourceReference item) {
    return new DataSourceImagesNested(-1, item);
  }
  
  public StorageContainersNested<A> addNewStorageContainer() {
    return new StorageContainersNested(-1, null);
  }
  
  public A addNewStorageContainer(String name,String referenceName,String uuid) {
    return (A) this.addToStorageContainers(new StorageResourceReference(name, referenceName, uuid));
  }
  
  public StorageContainersNested<A> addNewStorageContainerLike(StorageResourceReference item) {
    return new StorageContainersNested(-1, item);
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
  
  public A addToDataSourceImages(StorageResourceReference... items) {
    if (this.dataSourceImages == null) {
      this.dataSourceImages = new ArrayList();
    }
    for (StorageResourceReference item : items) {
        StorageResourceReferenceBuilder builder = new StorageResourceReferenceBuilder(item);
        _visitables.get("dataSourceImages").add(builder);
        this.dataSourceImages.add(builder);
    }
    return (A) this;
  }
  
  public A addToDataSourceImages(int index,StorageResourceReference item) {
    if (this.dataSourceImages == null) {
      this.dataSourceImages = new ArrayList();
    }
    StorageResourceReferenceBuilder builder = new StorageResourceReferenceBuilder(item);
    if (index < 0 || index >= dataSourceImages.size()) {
        _visitables.get("dataSourceImages").add(builder);
        dataSourceImages.add(builder);
    } else {
        _visitables.get("dataSourceImages").add(builder);
        dataSourceImages.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToStorageContainers(StorageResourceReference... items) {
    if (this.storageContainers == null) {
      this.storageContainers = new ArrayList();
    }
    for (StorageResourceReference item : items) {
        StorageResourceReferenceBuilder builder = new StorageResourceReferenceBuilder(item);
        _visitables.get("storageContainers").add(builder);
        this.storageContainers.add(builder);
    }
    return (A) this;
  }
  
  public A addToStorageContainers(int index,StorageResourceReference item) {
    if (this.storageContainers == null) {
      this.storageContainers = new ArrayList();
    }
    StorageResourceReferenceBuilder builder = new StorageResourceReferenceBuilder(item);
    if (index < 0 || index >= storageContainers.size()) {
        _visitables.get("storageContainers").add(builder);
        storageContainers.add(builder);
    } else {
        _visitables.get("storageContainers").add(builder);
        storageContainers.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSubnetUUIDs(String... items) {
    if (this.subnetUUIDs == null) {
      this.subnetUUIDs = new ArrayList();
    }
    for (String item : items) {
      this.subnetUUIDs.add(item);
    }
    return (A) this;
  }
  
  public A addToSubnetUUIDs(int index,String item) {
    if (this.subnetUUIDs == null) {
      this.subnetUUIDs = new ArrayList();
    }
    this.subnetUUIDs.add(index, item);
    return (A) this;
  }
  
  public StorageResourceReference buildDataSourceImage(int index) {
    return this.dataSourceImages.get(index).build();
  }
  
  public List<StorageResourceReference> buildDataSourceImages() {
    return this.dataSourceImages != null ? build(dataSourceImages) : null;
  }
  
  public StorageResourceReference buildFirstDataSourceImage() {
    return this.dataSourceImages.get(0).build();
  }
  
  public StorageResourceReference buildFirstStorageContainer() {
    return this.storageContainers.get(0).build();
  }
  
  public StorageResourceReference buildLastDataSourceImage() {
    return this.dataSourceImages.get(dataSourceImages.size() - 1).build();
  }
  
  public StorageResourceReference buildLastStorageContainer() {
    return this.storageContainers.get(storageContainers.size() - 1).build();
  }
  
  public StorageResourceReference buildMatchingDataSourceImage(Predicate<StorageResourceReferenceBuilder> predicate) {
      for (StorageResourceReferenceBuilder item : dataSourceImages) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public StorageResourceReference buildMatchingStorageContainer(Predicate<StorageResourceReferenceBuilder> predicate) {
      for (StorageResourceReferenceBuilder item : storageContainers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PrismElement buildPrismElement() {
    return this.prismElement != null ? this.prismElement.build() : null;
  }
  
  public StorageResourceReference buildStorageContainer(int index) {
    return this.storageContainers.get(index).build();
  }
  
  public List<StorageResourceReference> buildStorageContainers() {
    return this.storageContainers != null ? build(storageContainers) : null;
  }
  
  protected void copyInstance(FailureDomain instance) {
    instance = instance != null ? instance : new FailureDomain();
    if (instance != null) {
        this.withDataSourceImages(instance.getDataSourceImages());
        this.withName(instance.getName());
        this.withPrismElement(instance.getPrismElement());
        this.withStorageContainers(instance.getStorageContainers());
        this.withSubnetUUIDs(instance.getSubnetUUIDs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DataSourceImagesNested<A> editDataSourceImage(int index) {
    if (dataSourceImages.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dataSourceImages"));
    }
    return this.setNewDataSourceImageLike(index, this.buildDataSourceImage(index));
  }
  
  public DataSourceImagesNested<A> editFirstDataSourceImage() {
    if (dataSourceImages.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dataSourceImages"));
    }
    return this.setNewDataSourceImageLike(0, this.buildDataSourceImage(0));
  }
  
  public StorageContainersNested<A> editFirstStorageContainer() {
    if (storageContainers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "storageContainers"));
    }
    return this.setNewStorageContainerLike(0, this.buildStorageContainer(0));
  }
  
  public DataSourceImagesNested<A> editLastDataSourceImage() {
    int index = dataSourceImages.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dataSourceImages"));
    }
    return this.setNewDataSourceImageLike(index, this.buildDataSourceImage(index));
  }
  
  public StorageContainersNested<A> editLastStorageContainer() {
    int index = storageContainers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "storageContainers"));
    }
    return this.setNewStorageContainerLike(index, this.buildStorageContainer(index));
  }
  
  public DataSourceImagesNested<A> editMatchingDataSourceImage(Predicate<StorageResourceReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < dataSourceImages.size();i++) {
      if (predicate.test(dataSourceImages.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "dataSourceImages"));
    }
    return this.setNewDataSourceImageLike(index, this.buildDataSourceImage(index));
  }
  
  public StorageContainersNested<A> editMatchingStorageContainer(Predicate<StorageResourceReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < storageContainers.size();i++) {
      if (predicate.test(storageContainers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "storageContainers"));
    }
    return this.setNewStorageContainerLike(index, this.buildStorageContainer(index));
  }
  
  public PrismElementNested<A> editOrNewPrismElement() {
    return this.withNewPrismElementLike(Optional.ofNullable(this.buildPrismElement()).orElse(new PrismElementBuilder().build()));
  }
  
  public PrismElementNested<A> editOrNewPrismElementLike(PrismElement item) {
    return this.withNewPrismElementLike(Optional.ofNullable(this.buildPrismElement()).orElse(item));
  }
  
  public PrismElementNested<A> editPrismElement() {
    return this.withNewPrismElementLike(Optional.ofNullable(this.buildPrismElement()).orElse(null));
  }
  
  public StorageContainersNested<A> editStorageContainer(int index) {
    if (storageContainers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "storageContainers"));
    }
    return this.setNewStorageContainerLike(index, this.buildStorageContainer(index));
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
    FailureDomainFluent that = (FailureDomainFluent) o;
    if (!(Objects.equals(dataSourceImages, that.dataSourceImages))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(prismElement, that.prismElement))) {
      return false;
    }
    if (!(Objects.equals(storageContainers, that.storageContainers))) {
      return false;
    }
    if (!(Objects.equals(subnetUUIDs, that.subnetUUIDs))) {
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
  
  public String getFirstSubnetUUID() {
    return this.subnetUUIDs.get(0);
  }
  
  public String getLastSubnetUUID() {
    return this.subnetUUIDs.get(subnetUUIDs.size() - 1);
  }
  
  public String getMatchingSubnetUUID(Predicate<String> predicate) {
      for (String item : subnetUUIDs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getSubnetUUID(int index) {
    return this.subnetUUIDs.get(index);
  }
  
  public List<String> getSubnetUUIDs() {
    return this.subnetUUIDs;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDataSourceImages() {
    return this.dataSourceImages != null && !(this.dataSourceImages.isEmpty());
  }
  
  public boolean hasMatchingDataSourceImage(Predicate<StorageResourceReferenceBuilder> predicate) {
      for (StorageResourceReferenceBuilder item : dataSourceImages) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStorageContainer(Predicate<StorageResourceReferenceBuilder> predicate) {
      for (StorageResourceReferenceBuilder item : storageContainers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSubnetUUID(Predicate<String> predicate) {
      for (String item : subnetUUIDs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPrismElement() {
    return this.prismElement != null;
  }
  
  public boolean hasStorageContainers() {
    return this.storageContainers != null && !(this.storageContainers.isEmpty());
  }
  
  public boolean hasSubnetUUIDs() {
    return this.subnetUUIDs != null && !(this.subnetUUIDs.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(dataSourceImages, name, prismElement, storageContainers, subnetUUIDs, additionalProperties);
  }
  
  public A removeAllFromDataSourceImages(Collection<StorageResourceReference> items) {
    if (this.dataSourceImages == null) {
      return (A) this;
    }
    for (StorageResourceReference item : items) {
        StorageResourceReferenceBuilder builder = new StorageResourceReferenceBuilder(item);
        _visitables.get("dataSourceImages").remove(builder);
        this.dataSourceImages.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromStorageContainers(Collection<StorageResourceReference> items) {
    if (this.storageContainers == null) {
      return (A) this;
    }
    for (StorageResourceReference item : items) {
        StorageResourceReferenceBuilder builder = new StorageResourceReferenceBuilder(item);
        _visitables.get("storageContainers").remove(builder);
        this.storageContainers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSubnetUUIDs(Collection<String> items) {
    if (this.subnetUUIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.subnetUUIDs.remove(item);
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
  
  public A removeFromDataSourceImages(StorageResourceReference... items) {
    if (this.dataSourceImages == null) {
      return (A) this;
    }
    for (StorageResourceReference item : items) {
        StorageResourceReferenceBuilder builder = new StorageResourceReferenceBuilder(item);
        _visitables.get("dataSourceImages").remove(builder);
        this.dataSourceImages.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromStorageContainers(StorageResourceReference... items) {
    if (this.storageContainers == null) {
      return (A) this;
    }
    for (StorageResourceReference item : items) {
        StorageResourceReferenceBuilder builder = new StorageResourceReferenceBuilder(item);
        _visitables.get("storageContainers").remove(builder);
        this.storageContainers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSubnetUUIDs(String... items) {
    if (this.subnetUUIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.subnetUUIDs.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDataSourceImages(Predicate<StorageResourceReferenceBuilder> predicate) {
    if (dataSourceImages == null) {
      return (A) this;
    }
    Iterator<StorageResourceReferenceBuilder> each = dataSourceImages.iterator();
    List visitables = _visitables.get("dataSourceImages");
    while (each.hasNext()) {
        StorageResourceReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromStorageContainers(Predicate<StorageResourceReferenceBuilder> predicate) {
    if (storageContainers == null) {
      return (A) this;
    }
    Iterator<StorageResourceReferenceBuilder> each = storageContainers.iterator();
    List visitables = _visitables.get("storageContainers");
    while (each.hasNext()) {
        StorageResourceReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DataSourceImagesNested<A> setNewDataSourceImageLike(int index,StorageResourceReference item) {
    return new DataSourceImagesNested(index, item);
  }
  
  public StorageContainersNested<A> setNewStorageContainerLike(int index,StorageResourceReference item) {
    return new StorageContainersNested(index, item);
  }
  
  public A setToDataSourceImages(int index,StorageResourceReference item) {
    if (this.dataSourceImages == null) {
      this.dataSourceImages = new ArrayList();
    }
    StorageResourceReferenceBuilder builder = new StorageResourceReferenceBuilder(item);
    if (index < 0 || index >= dataSourceImages.size()) {
        _visitables.get("dataSourceImages").add(builder);
        dataSourceImages.add(builder);
    } else {
        _visitables.get("dataSourceImages").add(builder);
        dataSourceImages.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToStorageContainers(int index,StorageResourceReference item) {
    if (this.storageContainers == null) {
      this.storageContainers = new ArrayList();
    }
    StorageResourceReferenceBuilder builder = new StorageResourceReferenceBuilder(item);
    if (index < 0 || index >= storageContainers.size()) {
        _visitables.get("storageContainers").add(builder);
        storageContainers.add(builder);
    } else {
        _visitables.get("storageContainers").add(builder);
        storageContainers.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSubnetUUIDs(int index,String item) {
    if (this.subnetUUIDs == null) {
      this.subnetUUIDs = new ArrayList();
    }
    this.subnetUUIDs.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(dataSourceImages == null) && !(dataSourceImages.isEmpty())) {
        sb.append("dataSourceImages:");
        sb.append(dataSourceImages);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(prismElement == null)) {
        sb.append("prismElement:");
        sb.append(prismElement);
        sb.append(",");
    }
    if (!(storageContainers == null) && !(storageContainers.isEmpty())) {
        sb.append("storageContainers:");
        sb.append(storageContainers);
        sb.append(",");
    }
    if (!(subnetUUIDs == null) && !(subnetUUIDs.isEmpty())) {
        sb.append("subnetUUIDs:");
        sb.append(subnetUUIDs);
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
  
  public A withDataSourceImages(List<StorageResourceReference> dataSourceImages) {
    if (this.dataSourceImages != null) {
      this._visitables.get("dataSourceImages").clear();
    }
    if (dataSourceImages != null) {
        this.dataSourceImages = new ArrayList();
        for (StorageResourceReference item : dataSourceImages) {
          this.addToDataSourceImages(item);
        }
    } else {
      this.dataSourceImages = null;
    }
    return (A) this;
  }
  
  public A withDataSourceImages(StorageResourceReference... dataSourceImages) {
    if (this.dataSourceImages != null) {
        this.dataSourceImages.clear();
        _visitables.remove("dataSourceImages");
    }
    if (dataSourceImages != null) {
      for (StorageResourceReference item : dataSourceImages) {
        this.addToDataSourceImages(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public PrismElementNested<A> withNewPrismElement() {
    return new PrismElementNested(null);
  }
  
  public PrismElementNested<A> withNewPrismElementLike(PrismElement item) {
    return new PrismElementNested(item);
  }
  
  public A withPrismElement(PrismElement prismElement) {
    this._visitables.remove("prismElement");
    if (prismElement != null) {
        this.prismElement = new PrismElementBuilder(prismElement);
        this._visitables.get("prismElement").add(this.prismElement);
    } else {
        this.prismElement = null;
        this._visitables.get("prismElement").remove(this.prismElement);
    }
    return (A) this;
  }
  
  public A withStorageContainers(List<StorageResourceReference> storageContainers) {
    if (this.storageContainers != null) {
      this._visitables.get("storageContainers").clear();
    }
    if (storageContainers != null) {
        this.storageContainers = new ArrayList();
        for (StorageResourceReference item : storageContainers) {
          this.addToStorageContainers(item);
        }
    } else {
      this.storageContainers = null;
    }
    return (A) this;
  }
  
  public A withStorageContainers(StorageResourceReference... storageContainers) {
    if (this.storageContainers != null) {
        this.storageContainers.clear();
        _visitables.remove("storageContainers");
    }
    if (storageContainers != null) {
      for (StorageResourceReference item : storageContainers) {
        this.addToStorageContainers(item);
      }
    }
    return (A) this;
  }
  
  public A withSubnetUUIDs(List<String> subnetUUIDs) {
    if (subnetUUIDs != null) {
        this.subnetUUIDs = new ArrayList();
        for (String item : subnetUUIDs) {
          this.addToSubnetUUIDs(item);
        }
    } else {
      this.subnetUUIDs = null;
    }
    return (A) this;
  }
  
  public A withSubnetUUIDs(String... subnetUUIDs) {
    if (this.subnetUUIDs != null) {
        this.subnetUUIDs.clear();
        _visitables.remove("subnetUUIDs");
    }
    if (subnetUUIDs != null) {
      for (String item : subnetUUIDs) {
        this.addToSubnetUUIDs(item);
      }
    }
    return (A) this;
  }
  public class DataSourceImagesNested<N> extends StorageResourceReferenceFluent<DataSourceImagesNested<N>> implements Nested<N>{
  
    StorageResourceReferenceBuilder builder;
    int index;
  
    DataSourceImagesNested(int index,StorageResourceReference item) {
      this.index = index;
      this.builder = new StorageResourceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) FailureDomainFluent.this.setToDataSourceImages(index, builder.build());
    }
    
    public N endDataSourceImage() {
      return and();
    }
    
  }
  public class PrismElementNested<N> extends PrismElementFluent<PrismElementNested<N>> implements Nested<N>{
  
    PrismElementBuilder builder;
  
    PrismElementNested(PrismElement item) {
      this.builder = new PrismElementBuilder(this, item);
    }
  
    public N and() {
      return (N) FailureDomainFluent.this.withPrismElement(builder.build());
    }
    
    public N endPrismElement() {
      return and();
    }
    
  }
  public class StorageContainersNested<N> extends StorageResourceReferenceFluent<StorageContainersNested<N>> implements Nested<N>{
  
    StorageResourceReferenceBuilder builder;
    int index;
  
    StorageContainersNested(int index,StorageResourceReference item) {
      this.index = index;
      this.builder = new StorageResourceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) FailureDomainFluent.this.setToStorageContainers(index, builder.build());
    }
    
    public N endStorageContainer() {
      return and();
    }
    
  }
}