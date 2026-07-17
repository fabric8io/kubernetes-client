package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import io.fabric8.kubernetes.api.model.Quantity;
import java.lang.Integer;
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
public class NutanixMachineProviderConfigFluent<A extends io.fabric8.openshift.api.model.machine.v1.NutanixMachineProviderConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String bootType;
  private ArrayList<NutanixCategoryBuilder> categories = new ArrayList<NutanixCategoryBuilder>();
  private NutanixResourceIdentifierBuilder cluster;
  private LocalObjectReferenceBuilder credentialsSecret;
  private ArrayList<NutanixVMDiskBuilder> dataDisks = new ArrayList<NutanixVMDiskBuilder>();
  private NutanixFailureDomainReferenceBuilder failureDomain;
  private ArrayList<NutanixGPUBuilder> gpus = new ArrayList<NutanixGPUBuilder>();
  private NutanixResourceIdentifierBuilder image;
  private String kind;
  private Quantity memorySize;
  private ObjectMetaBuilder metadata;
  private NutanixResourceIdentifierBuilder project;
  private ArrayList<NutanixResourceIdentifierBuilder> subnets = new ArrayList<NutanixResourceIdentifierBuilder>();
  private Quantity systemDiskSize;
  private LocalObjectReferenceBuilder userDataSecret;
  private Integer vcpuSockets;
  private Integer vcpusPerSocket;

  public NutanixMachineProviderConfigFluent() {
  }
  
  public NutanixMachineProviderConfigFluent(NutanixMachineProviderConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToCategories(Collection<NutanixCategory> items) {
    if (this.categories == null) {
      this.categories = new ArrayList();
    }
    for (NutanixCategory item : items) {
        NutanixCategoryBuilder builder = new NutanixCategoryBuilder(item);
        _visitables.get("categories").add(builder);
        this.categories.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToDataDisks(Collection<NutanixVMDisk> items) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    for (NutanixVMDisk item : items) {
        NutanixVMDiskBuilder builder = new NutanixVMDiskBuilder(item);
        _visitables.get("dataDisks").add(builder);
        this.dataDisks.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToGpus(Collection<NutanixGPU> items) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    for (NutanixGPU item : items) {
        NutanixGPUBuilder builder = new NutanixGPUBuilder(item);
        _visitables.get("gpus").add(builder);
        this.gpus.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSubnets(Collection<NutanixResourceIdentifier> items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (NutanixResourceIdentifier item : items) {
        NutanixResourceIdentifierBuilder builder = new NutanixResourceIdentifierBuilder(item);
        _visitables.get("subnets").add(builder);
        this.subnets.add(builder);
    }
    return (A) this;
  }
  
  public CategoriesNested<A> addNewCategory() {
    return new CategoriesNested(-1, null);
  }
  
  public A addNewCategory(String key,String value) {
    return (A) this.addToCategories(new NutanixCategory(key, value));
  }
  
  public CategoriesNested<A> addNewCategoryLike(NutanixCategory item) {
    return new CategoriesNested(-1, item);
  }
  
  public DataDisksNested<A> addNewDataDisk() {
    return new DataDisksNested(-1, null);
  }
  
  public DataDisksNested<A> addNewDataDiskLike(NutanixVMDisk item) {
    return new DataDisksNested(-1, item);
  }
  
  public GpusNested<A> addNewGpus() {
    return new GpusNested(-1, null);
  }
  
  public A addNewGpus(Integer deviceID,String name,String type) {
    return (A) this.addToGpus(new NutanixGPU(deviceID, name, type));
  }
  
  public GpusNested<A> addNewGpusLike(NutanixGPU item) {
    return new GpusNested(-1, item);
  }
  
  public SubnetsNested<A> addNewSubnet() {
    return new SubnetsNested(-1, null);
  }
  
  public A addNewSubnet(String name,String type,String uuid) {
    return (A) this.addToSubnets(new NutanixResourceIdentifier(name, type, uuid));
  }
  
  public SubnetsNested<A> addNewSubnetLike(NutanixResourceIdentifier item) {
    return new SubnetsNested(-1, item);
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
  
  public A addToCategories(NutanixCategory... items) {
    if (this.categories == null) {
      this.categories = new ArrayList();
    }
    for (NutanixCategory item : items) {
        NutanixCategoryBuilder builder = new NutanixCategoryBuilder(item);
        _visitables.get("categories").add(builder);
        this.categories.add(builder);
    }
    return (A) this;
  }
  
  public A addToCategories(int index,NutanixCategory item) {
    if (this.categories == null) {
      this.categories = new ArrayList();
    }
    NutanixCategoryBuilder builder = new NutanixCategoryBuilder(item);
    if (index < 0 || index >= categories.size()) {
        _visitables.get("categories").add(builder);
        categories.add(builder);
    } else {
        _visitables.get("categories").add(builder);
        categories.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToDataDisks(NutanixVMDisk... items) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    for (NutanixVMDisk item : items) {
        NutanixVMDiskBuilder builder = new NutanixVMDiskBuilder(item);
        _visitables.get("dataDisks").add(builder);
        this.dataDisks.add(builder);
    }
    return (A) this;
  }
  
  public A addToDataDisks(int index,NutanixVMDisk item) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    NutanixVMDiskBuilder builder = new NutanixVMDiskBuilder(item);
    if (index < 0 || index >= dataDisks.size()) {
        _visitables.get("dataDisks").add(builder);
        dataDisks.add(builder);
    } else {
        _visitables.get("dataDisks").add(builder);
        dataDisks.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToGpus(NutanixGPU... items) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    for (NutanixGPU item : items) {
        NutanixGPUBuilder builder = new NutanixGPUBuilder(item);
        _visitables.get("gpus").add(builder);
        this.gpus.add(builder);
    }
    return (A) this;
  }
  
  public A addToGpus(int index,NutanixGPU item) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    NutanixGPUBuilder builder = new NutanixGPUBuilder(item);
    if (index < 0 || index >= gpus.size()) {
        _visitables.get("gpus").add(builder);
        gpus.add(builder);
    } else {
        _visitables.get("gpus").add(builder);
        gpus.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSubnets(NutanixResourceIdentifier... items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (NutanixResourceIdentifier item : items) {
        NutanixResourceIdentifierBuilder builder = new NutanixResourceIdentifierBuilder(item);
        _visitables.get("subnets").add(builder);
        this.subnets.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubnets(int index,NutanixResourceIdentifier item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    NutanixResourceIdentifierBuilder builder = new NutanixResourceIdentifierBuilder(item);
    if (index < 0 || index >= subnets.size()) {
        _visitables.get("subnets").add(builder);
        subnets.add(builder);
    } else {
        _visitables.get("subnets").add(builder);
        subnets.add(index, builder);
    }
    return (A) this;
  }
  
  public List<NutanixCategory> buildCategories() {
    return this.categories != null ? build(categories) : null;
  }
  
  public NutanixCategory buildCategory(int index) {
    return this.categories.get(index).build();
  }
  
  public NutanixResourceIdentifier buildCluster() {
    return this.cluster != null ? this.cluster.build() : null;
  }
  
  public LocalObjectReference buildCredentialsSecret() {
    return this.credentialsSecret != null ? this.credentialsSecret.build() : null;
  }
  
  public NutanixVMDisk buildDataDisk(int index) {
    return this.dataDisks.get(index).build();
  }
  
  public List<NutanixVMDisk> buildDataDisks() {
    return this.dataDisks != null ? build(dataDisks) : null;
  }
  
  public NutanixFailureDomainReference buildFailureDomain() {
    return this.failureDomain != null ? this.failureDomain.build() : null;
  }
  
  public NutanixCategory buildFirstCategory() {
    return this.categories.get(0).build();
  }
  
  public NutanixVMDisk buildFirstDataDisk() {
    return this.dataDisks.get(0).build();
  }
  
  public NutanixGPU buildFirstGpus() {
    return this.gpus.get(0).build();
  }
  
  public NutanixResourceIdentifier buildFirstSubnet() {
    return this.subnets.get(0).build();
  }
  
  public List<NutanixGPU> buildGpus() {
    return this.gpus != null ? build(gpus) : null;
  }
  
  public NutanixGPU buildGpus(int index) {
    return this.gpus.get(index).build();
  }
  
  public NutanixResourceIdentifier buildImage() {
    return this.image != null ? this.image.build() : null;
  }
  
  public NutanixCategory buildLastCategory() {
    return this.categories.get(categories.size() - 1).build();
  }
  
  public NutanixVMDisk buildLastDataDisk() {
    return this.dataDisks.get(dataDisks.size() - 1).build();
  }
  
  public NutanixGPU buildLastGpus() {
    return this.gpus.get(gpus.size() - 1).build();
  }
  
  public NutanixResourceIdentifier buildLastSubnet() {
    return this.subnets.get(subnets.size() - 1).build();
  }
  
  public NutanixCategory buildMatchingCategory(Predicate<NutanixCategoryBuilder> predicate) {
      for (NutanixCategoryBuilder item : categories) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NutanixVMDisk buildMatchingDataDisk(Predicate<NutanixVMDiskBuilder> predicate) {
      for (NutanixVMDiskBuilder item : dataDisks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NutanixGPU buildMatchingGpus(Predicate<NutanixGPUBuilder> predicate) {
      for (NutanixGPUBuilder item : gpus) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NutanixResourceIdentifier buildMatchingSubnet(Predicate<NutanixResourceIdentifierBuilder> predicate) {
      for (NutanixResourceIdentifierBuilder item : subnets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public NutanixResourceIdentifier buildProject() {
    return this.project != null ? this.project.build() : null;
  }
  
  public NutanixResourceIdentifier buildSubnet(int index) {
    return this.subnets.get(index).build();
  }
  
  public List<NutanixResourceIdentifier> buildSubnets() {
    return this.subnets != null ? build(subnets) : null;
  }
  
  public LocalObjectReference buildUserDataSecret() {
    return this.userDataSecret != null ? this.userDataSecret.build() : null;
  }
  
  protected void copyInstance(NutanixMachineProviderConfig instance) {
    instance = instance != null ? instance : new NutanixMachineProviderConfig();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withBootType(instance.getBootType());
        this.withCategories(instance.getCategories());
        this.withCluster(instance.getCluster());
        this.withCredentialsSecret(instance.getCredentialsSecret());
        this.withDataDisks(instance.getDataDisks());
        this.withFailureDomain(instance.getFailureDomain());
        this.withGpus(instance.getGpus());
        this.withImage(instance.getImage());
        this.withKind(instance.getKind());
        this.withMemorySize(instance.getMemorySize());
        this.withMetadata(instance.getMetadata());
        this.withProject(instance.getProject());
        this.withSubnets(instance.getSubnets());
        this.withSystemDiskSize(instance.getSystemDiskSize());
        this.withUserDataSecret(instance.getUserDataSecret());
        this.withVcpuSockets(instance.getVcpuSockets());
        this.withVcpusPerSocket(instance.getVcpusPerSocket());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CategoriesNested<A> editCategory(int index) {
    if (categories.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "categories"));
    }
    return this.setNewCategoryLike(index, this.buildCategory(index));
  }
  
  public ClusterNested<A> editCluster() {
    return this.withNewClusterLike(Optional.ofNullable(this.buildCluster()).orElse(null));
  }
  
  public CredentialsSecretNested<A> editCredentialsSecret() {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(null));
  }
  
  public DataDisksNested<A> editDataDisk(int index) {
    if (dataDisks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dataDisks"));
    }
    return this.setNewDataDiskLike(index, this.buildDataDisk(index));
  }
  
  public FailureDomainNested<A> editFailureDomain() {
    return this.withNewFailureDomainLike(Optional.ofNullable(this.buildFailureDomain()).orElse(null));
  }
  
  public CategoriesNested<A> editFirstCategory() {
    if (categories.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "categories"));
    }
    return this.setNewCategoryLike(0, this.buildCategory(0));
  }
  
  public DataDisksNested<A> editFirstDataDisk() {
    if (dataDisks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dataDisks"));
    }
    return this.setNewDataDiskLike(0, this.buildDataDisk(0));
  }
  
  public GpusNested<A> editFirstGpus() {
    if (gpus.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "gpus"));
    }
    return this.setNewGpusLike(0, this.buildGpus(0));
  }
  
  public SubnetsNested<A> editFirstSubnet() {
    if (subnets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "subnets"));
    }
    return this.setNewSubnetLike(0, this.buildSubnet(0));
  }
  
  public GpusNested<A> editGpus(int index) {
    if (gpus.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "gpus"));
    }
    return this.setNewGpusLike(index, this.buildGpus(index));
  }
  
  public ImageNested<A> editImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(null));
  }
  
  public CategoriesNested<A> editLastCategory() {
    int index = categories.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "categories"));
    }
    return this.setNewCategoryLike(index, this.buildCategory(index));
  }
  
  public DataDisksNested<A> editLastDataDisk() {
    int index = dataDisks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dataDisks"));
    }
    return this.setNewDataDiskLike(index, this.buildDataDisk(index));
  }
  
  public GpusNested<A> editLastGpus() {
    int index = gpus.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "gpus"));
    }
    return this.setNewGpusLike(index, this.buildGpus(index));
  }
  
  public SubnetsNested<A> editLastSubnet() {
    int index = subnets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "subnets"));
    }
    return this.setNewSubnetLike(index, this.buildSubnet(index));
  }
  
  public CategoriesNested<A> editMatchingCategory(Predicate<NutanixCategoryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < categories.size();i++) {
      if (predicate.test(categories.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "categories"));
    }
    return this.setNewCategoryLike(index, this.buildCategory(index));
  }
  
  public DataDisksNested<A> editMatchingDataDisk(Predicate<NutanixVMDiskBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < dataDisks.size();i++) {
      if (predicate.test(dataDisks.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "dataDisks"));
    }
    return this.setNewDataDiskLike(index, this.buildDataDisk(index));
  }
  
  public GpusNested<A> editMatchingGpus(Predicate<NutanixGPUBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < gpus.size();i++) {
      if (predicate.test(gpus.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "gpus"));
    }
    return this.setNewGpusLike(index, this.buildGpus(index));
  }
  
  public SubnetsNested<A> editMatchingSubnet(Predicate<NutanixResourceIdentifierBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < subnets.size();i++) {
      if (predicate.test(subnets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "subnets"));
    }
    return this.setNewSubnetLike(index, this.buildSubnet(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public ClusterNested<A> editOrNewCluster() {
    return this.withNewClusterLike(Optional.ofNullable(this.buildCluster()).orElse(new NutanixResourceIdentifierBuilder().build()));
  }
  
  public ClusterNested<A> editOrNewClusterLike(NutanixResourceIdentifier item) {
    return this.withNewClusterLike(Optional.ofNullable(this.buildCluster()).orElse(item));
  }
  
  public CredentialsSecretNested<A> editOrNewCredentialsSecret() {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public CredentialsSecretNested<A> editOrNewCredentialsSecretLike(LocalObjectReference item) {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(item));
  }
  
  public FailureDomainNested<A> editOrNewFailureDomain() {
    return this.withNewFailureDomainLike(Optional.ofNullable(this.buildFailureDomain()).orElse(new NutanixFailureDomainReferenceBuilder().build()));
  }
  
  public FailureDomainNested<A> editOrNewFailureDomainLike(NutanixFailureDomainReference item) {
    return this.withNewFailureDomainLike(Optional.ofNullable(this.buildFailureDomain()).orElse(item));
  }
  
  public ImageNested<A> editOrNewImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(new NutanixResourceIdentifierBuilder().build()));
  }
  
  public ImageNested<A> editOrNewImageLike(NutanixResourceIdentifier item) {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public ProjectNested<A> editOrNewProject() {
    return this.withNewProjectLike(Optional.ofNullable(this.buildProject()).orElse(new NutanixResourceIdentifierBuilder().build()));
  }
  
  public ProjectNested<A> editOrNewProjectLike(NutanixResourceIdentifier item) {
    return this.withNewProjectLike(Optional.ofNullable(this.buildProject()).orElse(item));
  }
  
  public UserDataSecretNested<A> editOrNewUserDataSecret() {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public UserDataSecretNested<A> editOrNewUserDataSecretLike(LocalObjectReference item) {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(item));
  }
  
  public ProjectNested<A> editProject() {
    return this.withNewProjectLike(Optional.ofNullable(this.buildProject()).orElse(null));
  }
  
  public SubnetsNested<A> editSubnet(int index) {
    if (subnets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "subnets"));
    }
    return this.setNewSubnetLike(index, this.buildSubnet(index));
  }
  
  public UserDataSecretNested<A> editUserDataSecret() {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(null));
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
    NutanixMachineProviderConfigFluent that = (NutanixMachineProviderConfigFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(bootType, that.bootType))) {
      return false;
    }
    if (!(Objects.equals(categories, that.categories))) {
      return false;
    }
    if (!(Objects.equals(cluster, that.cluster))) {
      return false;
    }
    if (!(Objects.equals(credentialsSecret, that.credentialsSecret))) {
      return false;
    }
    if (!(Objects.equals(dataDisks, that.dataDisks))) {
      return false;
    }
    if (!(Objects.equals(failureDomain, that.failureDomain))) {
      return false;
    }
    if (!(Objects.equals(gpus, that.gpus))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(memorySize, that.memorySize))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(project, that.project))) {
      return false;
    }
    if (!(Objects.equals(subnets, that.subnets))) {
      return false;
    }
    if (!(Objects.equals(systemDiskSize, that.systemDiskSize))) {
      return false;
    }
    if (!(Objects.equals(userDataSecret, that.userDataSecret))) {
      return false;
    }
    if (!(Objects.equals(vcpuSockets, that.vcpuSockets))) {
      return false;
    }
    if (!(Objects.equals(vcpusPerSocket, that.vcpusPerSocket))) {
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
  
  public String getBootType() {
    return this.bootType;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public Quantity getMemorySize() {
    return this.memorySize;
  }
  
  public Quantity getSystemDiskSize() {
    return this.systemDiskSize;
  }
  
  public Integer getVcpuSockets() {
    return this.vcpuSockets;
  }
  
  public Integer getVcpusPerSocket() {
    return this.vcpusPerSocket;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasBootType() {
    return this.bootType != null;
  }
  
  public boolean hasCategories() {
    return this.categories != null && !(this.categories.isEmpty());
  }
  
  public boolean hasCluster() {
    return this.cluster != null;
  }
  
  public boolean hasCredentialsSecret() {
    return this.credentialsSecret != null;
  }
  
  public boolean hasDataDisks() {
    return this.dataDisks != null && !(this.dataDisks.isEmpty());
  }
  
  public boolean hasFailureDomain() {
    return this.failureDomain != null;
  }
  
  public boolean hasGpus() {
    return this.gpus != null && !(this.gpus.isEmpty());
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingCategory(Predicate<NutanixCategoryBuilder> predicate) {
      for (NutanixCategoryBuilder item : categories) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDataDisk(Predicate<NutanixVMDiskBuilder> predicate) {
      for (NutanixVMDiskBuilder item : dataDisks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingGpus(Predicate<NutanixGPUBuilder> predicate) {
      for (NutanixGPUBuilder item : gpus) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSubnet(Predicate<NutanixResourceIdentifierBuilder> predicate) {
      for (NutanixResourceIdentifierBuilder item : subnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMemorySize() {
    return this.memorySize != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasProject() {
    return this.project != null;
  }
  
  public boolean hasSubnets() {
    return this.subnets != null && !(this.subnets.isEmpty());
  }
  
  public boolean hasSystemDiskSize() {
    return this.systemDiskSize != null;
  }
  
  public boolean hasUserDataSecret() {
    return this.userDataSecret != null;
  }
  
  public boolean hasVcpuSockets() {
    return this.vcpuSockets != null;
  }
  
  public boolean hasVcpusPerSocket() {
    return this.vcpusPerSocket != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, bootType, categories, cluster, credentialsSecret, dataDisks, failureDomain, gpus, image, kind, memorySize, metadata, project, subnets, systemDiskSize, userDataSecret, vcpuSockets, vcpusPerSocket, additionalProperties);
  }
  
  public A removeAllFromCategories(Collection<NutanixCategory> items) {
    if (this.categories == null) {
      return (A) this;
    }
    for (NutanixCategory item : items) {
        NutanixCategoryBuilder builder = new NutanixCategoryBuilder(item);
        _visitables.get("categories").remove(builder);
        this.categories.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromDataDisks(Collection<NutanixVMDisk> items) {
    if (this.dataDisks == null) {
      return (A) this;
    }
    for (NutanixVMDisk item : items) {
        NutanixVMDiskBuilder builder = new NutanixVMDiskBuilder(item);
        _visitables.get("dataDisks").remove(builder);
        this.dataDisks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromGpus(Collection<NutanixGPU> items) {
    if (this.gpus == null) {
      return (A) this;
    }
    for (NutanixGPU item : items) {
        NutanixGPUBuilder builder = new NutanixGPUBuilder(item);
        _visitables.get("gpus").remove(builder);
        this.gpus.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSubnets(Collection<NutanixResourceIdentifier> items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (NutanixResourceIdentifier item : items) {
        NutanixResourceIdentifierBuilder builder = new NutanixResourceIdentifierBuilder(item);
        _visitables.get("subnets").remove(builder);
        this.subnets.remove(builder);
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
  
  public A removeFromCategories(NutanixCategory... items) {
    if (this.categories == null) {
      return (A) this;
    }
    for (NutanixCategory item : items) {
        NutanixCategoryBuilder builder = new NutanixCategoryBuilder(item);
        _visitables.get("categories").remove(builder);
        this.categories.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromDataDisks(NutanixVMDisk... items) {
    if (this.dataDisks == null) {
      return (A) this;
    }
    for (NutanixVMDisk item : items) {
        NutanixVMDiskBuilder builder = new NutanixVMDiskBuilder(item);
        _visitables.get("dataDisks").remove(builder);
        this.dataDisks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromGpus(NutanixGPU... items) {
    if (this.gpus == null) {
      return (A) this;
    }
    for (NutanixGPU item : items) {
        NutanixGPUBuilder builder = new NutanixGPUBuilder(item);
        _visitables.get("gpus").remove(builder);
        this.gpus.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSubnets(NutanixResourceIdentifier... items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (NutanixResourceIdentifier item : items) {
        NutanixResourceIdentifierBuilder builder = new NutanixResourceIdentifierBuilder(item);
        _visitables.get("subnets").remove(builder);
        this.subnets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCategories(Predicate<NutanixCategoryBuilder> predicate) {
    if (categories == null) {
      return (A) this;
    }
    Iterator<NutanixCategoryBuilder> each = categories.iterator();
    List visitables = _visitables.get("categories");
    while (each.hasNext()) {
        NutanixCategoryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromDataDisks(Predicate<NutanixVMDiskBuilder> predicate) {
    if (dataDisks == null) {
      return (A) this;
    }
    Iterator<NutanixVMDiskBuilder> each = dataDisks.iterator();
    List visitables = _visitables.get("dataDisks");
    while (each.hasNext()) {
        NutanixVMDiskBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromGpus(Predicate<NutanixGPUBuilder> predicate) {
    if (gpus == null) {
      return (A) this;
    }
    Iterator<NutanixGPUBuilder> each = gpus.iterator();
    List visitables = _visitables.get("gpus");
    while (each.hasNext()) {
        NutanixGPUBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubnets(Predicate<NutanixResourceIdentifierBuilder> predicate) {
    if (subnets == null) {
      return (A) this;
    }
    Iterator<NutanixResourceIdentifierBuilder> each = subnets.iterator();
    List visitables = _visitables.get("subnets");
    while (each.hasNext()) {
        NutanixResourceIdentifierBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CategoriesNested<A> setNewCategoryLike(int index,NutanixCategory item) {
    return new CategoriesNested(index, item);
  }
  
  public DataDisksNested<A> setNewDataDiskLike(int index,NutanixVMDisk item) {
    return new DataDisksNested(index, item);
  }
  
  public GpusNested<A> setNewGpusLike(int index,NutanixGPU item) {
    return new GpusNested(index, item);
  }
  
  public SubnetsNested<A> setNewSubnetLike(int index,NutanixResourceIdentifier item) {
    return new SubnetsNested(index, item);
  }
  
  public A setToCategories(int index,NutanixCategory item) {
    if (this.categories == null) {
      this.categories = new ArrayList();
    }
    NutanixCategoryBuilder builder = new NutanixCategoryBuilder(item);
    if (index < 0 || index >= categories.size()) {
        _visitables.get("categories").add(builder);
        categories.add(builder);
    } else {
        _visitables.get("categories").add(builder);
        categories.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToDataDisks(int index,NutanixVMDisk item) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    NutanixVMDiskBuilder builder = new NutanixVMDiskBuilder(item);
    if (index < 0 || index >= dataDisks.size()) {
        _visitables.get("dataDisks").add(builder);
        dataDisks.add(builder);
    } else {
        _visitables.get("dataDisks").add(builder);
        dataDisks.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToGpus(int index,NutanixGPU item) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    NutanixGPUBuilder builder = new NutanixGPUBuilder(item);
    if (index < 0 || index >= gpus.size()) {
        _visitables.get("gpus").add(builder);
        gpus.add(builder);
    } else {
        _visitables.get("gpus").add(builder);
        gpus.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSubnets(int index,NutanixResourceIdentifier item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    NutanixResourceIdentifierBuilder builder = new NutanixResourceIdentifierBuilder(item);
    if (index < 0 || index >= subnets.size()) {
        _visitables.get("subnets").add(builder);
        subnets.add(builder);
    } else {
        _visitables.get("subnets").add(builder);
        subnets.set(index, builder);
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
    if (!(bootType == null)) {
        sb.append("bootType:");
        sb.append(bootType);
        sb.append(",");
    }
    if (!(categories == null) && !(categories.isEmpty())) {
        sb.append("categories:");
        sb.append(categories);
        sb.append(",");
    }
    if (!(cluster == null)) {
        sb.append("cluster:");
        sb.append(cluster);
        sb.append(",");
    }
    if (!(credentialsSecret == null)) {
        sb.append("credentialsSecret:");
        sb.append(credentialsSecret);
        sb.append(",");
    }
    if (!(dataDisks == null) && !(dataDisks.isEmpty())) {
        sb.append("dataDisks:");
        sb.append(dataDisks);
        sb.append(",");
    }
    if (!(failureDomain == null)) {
        sb.append("failureDomain:");
        sb.append(failureDomain);
        sb.append(",");
    }
    if (!(gpus == null) && !(gpus.isEmpty())) {
        sb.append("gpus:");
        sb.append(gpus);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(memorySize == null)) {
        sb.append("memorySize:");
        sb.append(memorySize);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(project == null)) {
        sb.append("project:");
        sb.append(project);
        sb.append(",");
    }
    if (!(subnets == null) && !(subnets.isEmpty())) {
        sb.append("subnets:");
        sb.append(subnets);
        sb.append(",");
    }
    if (!(systemDiskSize == null)) {
        sb.append("systemDiskSize:");
        sb.append(systemDiskSize);
        sb.append(",");
    }
    if (!(userDataSecret == null)) {
        sb.append("userDataSecret:");
        sb.append(userDataSecret);
        sb.append(",");
    }
    if (!(vcpuSockets == null)) {
        sb.append("vcpuSockets:");
        sb.append(vcpuSockets);
        sb.append(",");
    }
    if (!(vcpusPerSocket == null)) {
        sb.append("vcpusPerSocket:");
        sb.append(vcpusPerSocket);
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
  
  public A withBootType(String bootType) {
    this.bootType = bootType;
    return (A) this;
  }
  
  public A withCategories(List<NutanixCategory> categories) {
    if (this.categories != null) {
      this._visitables.get("categories").clear();
    }
    if (categories != null) {
        this.categories = new ArrayList();
        for (NutanixCategory item : categories) {
          this.addToCategories(item);
        }
    } else {
      this.categories = null;
    }
    return (A) this;
  }
  
  public A withCategories(NutanixCategory... categories) {
    if (this.categories != null) {
        this.categories.clear();
        _visitables.remove("categories");
    }
    if (categories != null) {
      for (NutanixCategory item : categories) {
        this.addToCategories(item);
      }
    }
    return (A) this;
  }
  
  public A withCluster(NutanixResourceIdentifier cluster) {
    this._visitables.remove("cluster");
    if (cluster != null) {
        this.cluster = new NutanixResourceIdentifierBuilder(cluster);
        this._visitables.get("cluster").add(this.cluster);
    } else {
        this.cluster = null;
        this._visitables.get("cluster").remove(this.cluster);
    }
    return (A) this;
  }
  
  public A withCredentialsSecret(LocalObjectReference credentialsSecret) {
    this._visitables.remove("credentialsSecret");
    if (credentialsSecret != null) {
        this.credentialsSecret = new LocalObjectReferenceBuilder(credentialsSecret);
        this._visitables.get("credentialsSecret").add(this.credentialsSecret);
    } else {
        this.credentialsSecret = null;
        this._visitables.get("credentialsSecret").remove(this.credentialsSecret);
    }
    return (A) this;
  }
  
  public A withDataDisks(List<NutanixVMDisk> dataDisks) {
    if (this.dataDisks != null) {
      this._visitables.get("dataDisks").clear();
    }
    if (dataDisks != null) {
        this.dataDisks = new ArrayList();
        for (NutanixVMDisk item : dataDisks) {
          this.addToDataDisks(item);
        }
    } else {
      this.dataDisks = null;
    }
    return (A) this;
  }
  
  public A withDataDisks(NutanixVMDisk... dataDisks) {
    if (this.dataDisks != null) {
        this.dataDisks.clear();
        _visitables.remove("dataDisks");
    }
    if (dataDisks != null) {
      for (NutanixVMDisk item : dataDisks) {
        this.addToDataDisks(item);
      }
    }
    return (A) this;
  }
  
  public A withFailureDomain(NutanixFailureDomainReference failureDomain) {
    this._visitables.remove("failureDomain");
    if (failureDomain != null) {
        this.failureDomain = new NutanixFailureDomainReferenceBuilder(failureDomain);
        this._visitables.get("failureDomain").add(this.failureDomain);
    } else {
        this.failureDomain = null;
        this._visitables.get("failureDomain").remove(this.failureDomain);
    }
    return (A) this;
  }
  
  public A withGpus(List<NutanixGPU> gpus) {
    if (this.gpus != null) {
      this._visitables.get("gpus").clear();
    }
    if (gpus != null) {
        this.gpus = new ArrayList();
        for (NutanixGPU item : gpus) {
          this.addToGpus(item);
        }
    } else {
      this.gpus = null;
    }
    return (A) this;
  }
  
  public A withGpus(NutanixGPU... gpus) {
    if (this.gpus != null) {
        this.gpus.clear();
        _visitables.remove("gpus");
    }
    if (gpus != null) {
      for (NutanixGPU item : gpus) {
        this.addToGpus(item);
      }
    }
    return (A) this;
  }
  
  public A withImage(NutanixResourceIdentifier image) {
    this._visitables.remove("image");
    if (image != null) {
        this.image = new NutanixResourceIdentifierBuilder(image);
        this._visitables.get("image").add(this.image);
    } else {
        this.image = null;
        this._visitables.get("image").remove(this.image);
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMemorySize(Quantity memorySize) {
    this.memorySize = memorySize;
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
  
  public ClusterNested<A> withNewCluster() {
    return new ClusterNested(null);
  }
  
  public A withNewCluster(String name,String type,String uuid) {
    return (A) this.withCluster(new NutanixResourceIdentifier(name, type, uuid));
  }
  
  public ClusterNested<A> withNewClusterLike(NutanixResourceIdentifier item) {
    return new ClusterNested(item);
  }
  
  public CredentialsSecretNested<A> withNewCredentialsSecret() {
    return new CredentialsSecretNested(null);
  }
  
  public A withNewCredentialsSecret(String name) {
    return (A) this.withCredentialsSecret(new LocalObjectReference(name));
  }
  
  public CredentialsSecretNested<A> withNewCredentialsSecretLike(LocalObjectReference item) {
    return new CredentialsSecretNested(item);
  }
  
  public FailureDomainNested<A> withNewFailureDomain() {
    return new FailureDomainNested(null);
  }
  
  public A withNewFailureDomain(String name) {
    return (A) this.withFailureDomain(new NutanixFailureDomainReference(name));
  }
  
  public FailureDomainNested<A> withNewFailureDomainLike(NutanixFailureDomainReference item) {
    return new FailureDomainNested(item);
  }
  
  public ImageNested<A> withNewImage() {
    return new ImageNested(null);
  }
  
  public A withNewImage(String name,String type,String uuid) {
    return (A) this.withImage(new NutanixResourceIdentifier(name, type, uuid));
  }
  
  public ImageNested<A> withNewImageLike(NutanixResourceIdentifier item) {
    return new ImageNested(item);
  }
  
  public A withNewMemorySize(String amount) {
    return (A) this.withMemorySize(new Quantity(amount));
  }
  
  public A withNewMemorySize(String amount,String format) {
    return (A) this.withMemorySize(new Quantity(amount, format));
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public ProjectNested<A> withNewProject() {
    return new ProjectNested(null);
  }
  
  public A withNewProject(String name,String type,String uuid) {
    return (A) this.withProject(new NutanixResourceIdentifier(name, type, uuid));
  }
  
  public ProjectNested<A> withNewProjectLike(NutanixResourceIdentifier item) {
    return new ProjectNested(item);
  }
  
  public A withNewSystemDiskSize(String amount) {
    return (A) this.withSystemDiskSize(new Quantity(amount));
  }
  
  public A withNewSystemDiskSize(String amount,String format) {
    return (A) this.withSystemDiskSize(new Quantity(amount, format));
  }
  
  public UserDataSecretNested<A> withNewUserDataSecret() {
    return new UserDataSecretNested(null);
  }
  
  public A withNewUserDataSecret(String name) {
    return (A) this.withUserDataSecret(new LocalObjectReference(name));
  }
  
  public UserDataSecretNested<A> withNewUserDataSecretLike(LocalObjectReference item) {
    return new UserDataSecretNested(item);
  }
  
  public A withProject(NutanixResourceIdentifier project) {
    this._visitables.remove("project");
    if (project != null) {
        this.project = new NutanixResourceIdentifierBuilder(project);
        this._visitables.get("project").add(this.project);
    } else {
        this.project = null;
        this._visitables.get("project").remove(this.project);
    }
    return (A) this;
  }
  
  public A withSubnets(List<NutanixResourceIdentifier> subnets) {
    if (this.subnets != null) {
      this._visitables.get("subnets").clear();
    }
    if (subnets != null) {
        this.subnets = new ArrayList();
        for (NutanixResourceIdentifier item : subnets) {
          this.addToSubnets(item);
        }
    } else {
      this.subnets = null;
    }
    return (A) this;
  }
  
  public A withSubnets(NutanixResourceIdentifier... subnets) {
    if (this.subnets != null) {
        this.subnets.clear();
        _visitables.remove("subnets");
    }
    if (subnets != null) {
      for (NutanixResourceIdentifier item : subnets) {
        this.addToSubnets(item);
      }
    }
    return (A) this;
  }
  
  public A withSystemDiskSize(Quantity systemDiskSize) {
    this.systemDiskSize = systemDiskSize;
    return (A) this;
  }
  
  public A withUserDataSecret(LocalObjectReference userDataSecret) {
    this._visitables.remove("userDataSecret");
    if (userDataSecret != null) {
        this.userDataSecret = new LocalObjectReferenceBuilder(userDataSecret);
        this._visitables.get("userDataSecret").add(this.userDataSecret);
    } else {
        this.userDataSecret = null;
        this._visitables.get("userDataSecret").remove(this.userDataSecret);
    }
    return (A) this;
  }
  
  public A withVcpuSockets(Integer vcpuSockets) {
    this.vcpuSockets = vcpuSockets;
    return (A) this;
  }
  
  public A withVcpusPerSocket(Integer vcpusPerSocket) {
    this.vcpusPerSocket = vcpusPerSocket;
    return (A) this;
  }
  public class CategoriesNested<N> extends NutanixCategoryFluent<CategoriesNested<N>> implements Nested<N>{
  
    NutanixCategoryBuilder builder;
    int index;
  
    CategoriesNested(int index,NutanixCategory item) {
      this.index = index;
      this.builder = new NutanixCategoryBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixMachineProviderConfigFluent.this.setToCategories(index, builder.build());
    }
    
    public N endCategory() {
      return and();
    }
    
  }
  public class ClusterNested<N> extends NutanixResourceIdentifierFluent<ClusterNested<N>> implements Nested<N>{
  
    NutanixResourceIdentifierBuilder builder;
  
    ClusterNested(NutanixResourceIdentifier item) {
      this.builder = new NutanixResourceIdentifierBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixMachineProviderConfigFluent.this.withCluster(builder.build());
    }
    
    public N endCluster() {
      return and();
    }
    
  }
  public class CredentialsSecretNested<N> extends LocalObjectReferenceFluent<CredentialsSecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CredentialsSecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixMachineProviderConfigFluent.this.withCredentialsSecret(builder.build());
    }
    
    public N endCredentialsSecret() {
      return and();
    }
    
  }
  public class DataDisksNested<N> extends NutanixVMDiskFluent<DataDisksNested<N>> implements Nested<N>{
  
    NutanixVMDiskBuilder builder;
    int index;
  
    DataDisksNested(int index,NutanixVMDisk item) {
      this.index = index;
      this.builder = new NutanixVMDiskBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixMachineProviderConfigFluent.this.setToDataDisks(index, builder.build());
    }
    
    public N endDataDisk() {
      return and();
    }
    
  }
  public class FailureDomainNested<N> extends NutanixFailureDomainReferenceFluent<FailureDomainNested<N>> implements Nested<N>{
  
    NutanixFailureDomainReferenceBuilder builder;
  
    FailureDomainNested(NutanixFailureDomainReference item) {
      this.builder = new NutanixFailureDomainReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixMachineProviderConfigFluent.this.withFailureDomain(builder.build());
    }
    
    public N endFailureDomain() {
      return and();
    }
    
  }
  public class GpusNested<N> extends NutanixGPUFluent<GpusNested<N>> implements Nested<N>{
  
    NutanixGPUBuilder builder;
    int index;
  
    GpusNested(int index,NutanixGPU item) {
      this.index = index;
      this.builder = new NutanixGPUBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixMachineProviderConfigFluent.this.setToGpus(index, builder.build());
    }
    
    public N endGpus() {
      return and();
    }
    
  }
  public class ImageNested<N> extends NutanixResourceIdentifierFluent<ImageNested<N>> implements Nested<N>{
  
    NutanixResourceIdentifierBuilder builder;
  
    ImageNested(NutanixResourceIdentifier item) {
      this.builder = new NutanixResourceIdentifierBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixMachineProviderConfigFluent.this.withImage(builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixMachineProviderConfigFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class ProjectNested<N> extends NutanixResourceIdentifierFluent<ProjectNested<N>> implements Nested<N>{
  
    NutanixResourceIdentifierBuilder builder;
  
    ProjectNested(NutanixResourceIdentifier item) {
      this.builder = new NutanixResourceIdentifierBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixMachineProviderConfigFluent.this.withProject(builder.build());
    }
    
    public N endProject() {
      return and();
    }
    
  }
  public class SubnetsNested<N> extends NutanixResourceIdentifierFluent<SubnetsNested<N>> implements Nested<N>{
  
    NutanixResourceIdentifierBuilder builder;
    int index;
  
    SubnetsNested(int index,NutanixResourceIdentifier item) {
      this.index = index;
      this.builder = new NutanixResourceIdentifierBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixMachineProviderConfigFluent.this.setToSubnets(index, builder.build());
    }
    
    public N endSubnet() {
      return and();
    }
    
  }
  public class UserDataSecretNested<N> extends LocalObjectReferenceFluent<UserDataSecretNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    UserDataSecretNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixMachineProviderConfigFluent.this.withUserDataSecret(builder.build());
    }
    
    public N endUserDataSecret() {
      return and();
    }
    
  }
}