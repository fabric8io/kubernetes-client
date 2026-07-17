package io.fabric8.openshift.api.model.installer.nutanix.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.machine.v1.NutanixCategory;
import io.fabric8.openshift.api.model.machine.v1.NutanixGPU;
import io.fabric8.openshift.api.model.machine.v1.NutanixResourceIdentifier;
import java.lang.Integer;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class MachinePoolFluent<A extends io.fabric8.openshift.api.model.installer.nutanix.v1.MachinePoolFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String bootType;
  private List<NutanixCategory> categories = new ArrayList<NutanixCategory>();
  private Long coresPerSocket;
  private Long cpus;
  private ArrayList<DataDiskBuilder> dataDisks = new ArrayList<DataDiskBuilder>();
  private List<String> failureDomains = new ArrayList<String>();
  private List<NutanixGPU> gpus = new ArrayList<NutanixGPU>();
  private Long memoryMiB;
  private OSDiskBuilder osDisk;
  private NutanixResourceIdentifier project;

  public MachinePoolFluent() {
  }
  
  public MachinePoolFluent(MachinePool instance) {
    this.copyInstance(instance);
  }

  public A addAllToCategories(Collection<NutanixCategory> items) {
    if (this.categories == null) {
      this.categories = new ArrayList();
    }
    for (NutanixCategory item : items) {
      this.categories.add(item);
    }
    return (A) this;
  }
  
  public A addAllToDataDisks(Collection<DataDisk> items) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    for (DataDisk item : items) {
        DataDiskBuilder builder = new DataDiskBuilder(item);
        _visitables.get("dataDisks").add(builder);
        this.dataDisks.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFailureDomains(Collection<String> items) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    for (String item : items) {
      this.failureDomains.add(item);
    }
    return (A) this;
  }
  
  public A addAllToGpus(Collection<NutanixGPU> items) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    for (NutanixGPU item : items) {
      this.gpus.add(item);
    }
    return (A) this;
  }
  
  public A addNewCategory(String key,String value) {
    return (A) this.addToCategories(new NutanixCategory(key, value));
  }
  
  public DataDisksNested<A> addNewDataDisk() {
    return new DataDisksNested(-1, null);
  }
  
  public DataDisksNested<A> addNewDataDiskLike(DataDisk item) {
    return new DataDisksNested(-1, item);
  }
  
  public A addNewGpus(Integer deviceID,String name,String type) {
    return (A) this.addToGpus(new NutanixGPU(deviceID, name, type));
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
      this.categories.add(item);
    }
    return (A) this;
  }
  
  public A addToCategories(int index,NutanixCategory item) {
    if (this.categories == null) {
      this.categories = new ArrayList();
    }
    this.categories.add(index, item);
    return (A) this;
  }
  
  public A addToDataDisks(DataDisk... items) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    for (DataDisk item : items) {
        DataDiskBuilder builder = new DataDiskBuilder(item);
        _visitables.get("dataDisks").add(builder);
        this.dataDisks.add(builder);
    }
    return (A) this;
  }
  
  public A addToDataDisks(int index,DataDisk item) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    DataDiskBuilder builder = new DataDiskBuilder(item);
    if (index < 0 || index >= dataDisks.size()) {
        _visitables.get("dataDisks").add(builder);
        dataDisks.add(builder);
    } else {
        _visitables.get("dataDisks").add(builder);
        dataDisks.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToFailureDomains(String... items) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    for (String item : items) {
      this.failureDomains.add(item);
    }
    return (A) this;
  }
  
  public A addToFailureDomains(int index,String item) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    this.failureDomains.add(index, item);
    return (A) this;
  }
  
  public A addToGpus(NutanixGPU... items) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    for (NutanixGPU item : items) {
      this.gpus.add(item);
    }
    return (A) this;
  }
  
  public A addToGpus(int index,NutanixGPU item) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    this.gpus.add(index, item);
    return (A) this;
  }
  
  public DataDisk buildDataDisk(int index) {
    return this.dataDisks.get(index).build();
  }
  
  public List<DataDisk> buildDataDisks() {
    return this.dataDisks != null ? build(dataDisks) : null;
  }
  
  public DataDisk buildFirstDataDisk() {
    return this.dataDisks.get(0).build();
  }
  
  public DataDisk buildLastDataDisk() {
    return this.dataDisks.get(dataDisks.size() - 1).build();
  }
  
  public DataDisk buildMatchingDataDisk(Predicate<DataDiskBuilder> predicate) {
      for (DataDiskBuilder item : dataDisks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OSDisk buildOsDisk() {
    return this.osDisk != null ? this.osDisk.build() : null;
  }
  
  protected void copyInstance(MachinePool instance) {
    instance = instance != null ? instance : new MachinePool();
    if (instance != null) {
        this.withBootType(instance.getBootType());
        this.withCategories(instance.getCategories());
        this.withCoresPerSocket(instance.getCoresPerSocket());
        this.withCpus(instance.getCpus());
        this.withDataDisks(instance.getDataDisks());
        this.withFailureDomains(instance.getFailureDomains());
        this.withGpus(instance.getGpus());
        this.withMemoryMiB(instance.getMemoryMiB());
        this.withOsDisk(instance.getOsDisk());
        this.withProject(instance.getProject());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DataDisksNested<A> editDataDisk(int index) {
    if (dataDisks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dataDisks"));
    }
    return this.setNewDataDiskLike(index, this.buildDataDisk(index));
  }
  
  public DataDisksNested<A> editFirstDataDisk() {
    if (dataDisks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dataDisks"));
    }
    return this.setNewDataDiskLike(0, this.buildDataDisk(0));
  }
  
  public DataDisksNested<A> editLastDataDisk() {
    int index = dataDisks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dataDisks"));
    }
    return this.setNewDataDiskLike(index, this.buildDataDisk(index));
  }
  
  public DataDisksNested<A> editMatchingDataDisk(Predicate<DataDiskBuilder> predicate) {
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
  
  public OsDiskNested<A> editOrNewOsDisk() {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(new OSDiskBuilder().build()));
  }
  
  public OsDiskNested<A> editOrNewOsDiskLike(OSDisk item) {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(item));
  }
  
  public OsDiskNested<A> editOsDisk() {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(null));
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
    MachinePoolFluent that = (MachinePoolFluent) o;
    if (!(Objects.equals(bootType, that.bootType))) {
      return false;
    }
    if (!(Objects.equals(categories, that.categories))) {
      return false;
    }
    if (!(Objects.equals(coresPerSocket, that.coresPerSocket))) {
      return false;
    }
    if (!(Objects.equals(cpus, that.cpus))) {
      return false;
    }
    if (!(Objects.equals(dataDisks, that.dataDisks))) {
      return false;
    }
    if (!(Objects.equals(failureDomains, that.failureDomains))) {
      return false;
    }
    if (!(Objects.equals(gpus, that.gpus))) {
      return false;
    }
    if (!(Objects.equals(memoryMiB, that.memoryMiB))) {
      return false;
    }
    if (!(Objects.equals(osDisk, that.osDisk))) {
      return false;
    }
    if (!(Objects.equals(project, that.project))) {
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
  
  public String getBootType() {
    return this.bootType;
  }
  
  public List<NutanixCategory> getCategories() {
    return this.categories;
  }
  
  public NutanixCategory getCategory(int index) {
    return this.categories.get(index);
  }
  
  public Long getCoresPerSocket() {
    return this.coresPerSocket;
  }
  
  public Long getCpus() {
    return this.cpus;
  }
  
  public String getFailureDomain(int index) {
    return this.failureDomains.get(index);
  }
  
  public List<String> getFailureDomains() {
    return this.failureDomains;
  }
  
  public NutanixCategory getFirstCategory() {
    return this.categories.get(0);
  }
  
  public String getFirstFailureDomain() {
    return this.failureDomains.get(0);
  }
  
  public NutanixGPU getFirstGpus() {
    return this.gpus.get(0);
  }
  
  public List<NutanixGPU> getGpus() {
    return this.gpus;
  }
  
  public NutanixGPU getGpus(int index) {
    return this.gpus.get(index);
  }
  
  public NutanixCategory getLastCategory() {
    return this.categories.get(categories.size() - 1);
  }
  
  public String getLastFailureDomain() {
    return this.failureDomains.get(failureDomains.size() - 1);
  }
  
  public NutanixGPU getLastGpus() {
    return this.gpus.get(gpus.size() - 1);
  }
  
  public NutanixCategory getMatchingCategory(Predicate<NutanixCategory> predicate) {
      for (NutanixCategory item : categories) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingFailureDomain(Predicate<String> predicate) {
      for (String item : failureDomains) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public NutanixGPU getMatchingGpus(Predicate<NutanixGPU> predicate) {
      for (NutanixGPU item : gpus) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getMemoryMiB() {
    return this.memoryMiB;
  }
  
  public NutanixResourceIdentifier getProject() {
    return this.project;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBootType() {
    return this.bootType != null;
  }
  
  public boolean hasCategories() {
    return this.categories != null && !(this.categories.isEmpty());
  }
  
  public boolean hasCoresPerSocket() {
    return this.coresPerSocket != null;
  }
  
  public boolean hasCpus() {
    return this.cpus != null;
  }
  
  public boolean hasDataDisks() {
    return this.dataDisks != null && !(this.dataDisks.isEmpty());
  }
  
  public boolean hasFailureDomains() {
    return this.failureDomains != null && !(this.failureDomains.isEmpty());
  }
  
  public boolean hasGpus() {
    return this.gpus != null && !(this.gpus.isEmpty());
  }
  
  public boolean hasMatchingCategory(Predicate<NutanixCategory> predicate) {
      for (NutanixCategory item : categories) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingDataDisk(Predicate<DataDiskBuilder> predicate) {
      for (DataDiskBuilder item : dataDisks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFailureDomain(Predicate<String> predicate) {
      for (String item : failureDomains) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingGpus(Predicate<NutanixGPU> predicate) {
      for (NutanixGPU item : gpus) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMemoryMiB() {
    return this.memoryMiB != null;
  }
  
  public boolean hasOsDisk() {
    return this.osDisk != null;
  }
  
  public boolean hasProject() {
    return this.project != null;
  }
  
  public int hashCode() {
    return Objects.hash(bootType, categories, coresPerSocket, cpus, dataDisks, failureDomains, gpus, memoryMiB, osDisk, project, additionalProperties);
  }
  
  public A removeAllFromCategories(Collection<NutanixCategory> items) {
    if (this.categories == null) {
      return (A) this;
    }
    for (NutanixCategory item : items) {
      this.categories.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromDataDisks(Collection<DataDisk> items) {
    if (this.dataDisks == null) {
      return (A) this;
    }
    for (DataDisk item : items) {
        DataDiskBuilder builder = new DataDiskBuilder(item);
        _visitables.get("dataDisks").remove(builder);
        this.dataDisks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFailureDomains(Collection<String> items) {
    if (this.failureDomains == null) {
      return (A) this;
    }
    for (String item : items) {
      this.failureDomains.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromGpus(Collection<NutanixGPU> items) {
    if (this.gpus == null) {
      return (A) this;
    }
    for (NutanixGPU item : items) {
      this.gpus.remove(item);
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
      this.categories.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromDataDisks(DataDisk... items) {
    if (this.dataDisks == null) {
      return (A) this;
    }
    for (DataDisk item : items) {
        DataDiskBuilder builder = new DataDiskBuilder(item);
        _visitables.get("dataDisks").remove(builder);
        this.dataDisks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromFailureDomains(String... items) {
    if (this.failureDomains == null) {
      return (A) this;
    }
    for (String item : items) {
      this.failureDomains.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromGpus(NutanixGPU... items) {
    if (this.gpus == null) {
      return (A) this;
    }
    for (NutanixGPU item : items) {
      this.gpus.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDataDisks(Predicate<DataDiskBuilder> predicate) {
    if (dataDisks == null) {
      return (A) this;
    }
    Iterator<DataDiskBuilder> each = dataDisks.iterator();
    List visitables = _visitables.get("dataDisks");
    while (each.hasNext()) {
        DataDiskBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DataDisksNested<A> setNewDataDiskLike(int index,DataDisk item) {
    return new DataDisksNested(index, item);
  }
  
  public A setToCategories(int index,NutanixCategory item) {
    if (this.categories == null) {
      this.categories = new ArrayList();
    }
    this.categories.set(index, item);
    return (A) this;
  }
  
  public A setToDataDisks(int index,DataDisk item) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    DataDiskBuilder builder = new DataDiskBuilder(item);
    if (index < 0 || index >= dataDisks.size()) {
        _visitables.get("dataDisks").add(builder);
        dataDisks.add(builder);
    } else {
        _visitables.get("dataDisks").add(builder);
        dataDisks.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFailureDomains(int index,String item) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    this.failureDomains.set(index, item);
    return (A) this;
  }
  
  public A setToGpus(int index,NutanixGPU item) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    this.gpus.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(coresPerSocket == null)) {
        sb.append("coresPerSocket:");
        sb.append(coresPerSocket);
        sb.append(",");
    }
    if (!(cpus == null)) {
        sb.append("cpus:");
        sb.append(cpus);
        sb.append(",");
    }
    if (!(dataDisks == null) && !(dataDisks.isEmpty())) {
        sb.append("dataDisks:");
        sb.append(dataDisks);
        sb.append(",");
    }
    if (!(failureDomains == null) && !(failureDomains.isEmpty())) {
        sb.append("failureDomains:");
        sb.append(failureDomains);
        sb.append(",");
    }
    if (!(gpus == null) && !(gpus.isEmpty())) {
        sb.append("gpus:");
        sb.append(gpus);
        sb.append(",");
    }
    if (!(memoryMiB == null)) {
        sb.append("memoryMiB:");
        sb.append(memoryMiB);
        sb.append(",");
    }
    if (!(osDisk == null)) {
        sb.append("osDisk:");
        sb.append(osDisk);
        sb.append(",");
    }
    if (!(project == null)) {
        sb.append("project:");
        sb.append(project);
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
  
  public A withBootType(String bootType) {
    this.bootType = bootType;
    return (A) this;
  }
  
  public A withCategories(List<NutanixCategory> categories) {
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
  
  public A withCoresPerSocket(Long coresPerSocket) {
    this.coresPerSocket = coresPerSocket;
    return (A) this;
  }
  
  public A withCpus(Long cpus) {
    this.cpus = cpus;
    return (A) this;
  }
  
  public A withDataDisks(List<DataDisk> dataDisks) {
    if (this.dataDisks != null) {
      this._visitables.get("dataDisks").clear();
    }
    if (dataDisks != null) {
        this.dataDisks = new ArrayList();
        for (DataDisk item : dataDisks) {
          this.addToDataDisks(item);
        }
    } else {
      this.dataDisks = null;
    }
    return (A) this;
  }
  
  public A withDataDisks(DataDisk... dataDisks) {
    if (this.dataDisks != null) {
        this.dataDisks.clear();
        _visitables.remove("dataDisks");
    }
    if (dataDisks != null) {
      for (DataDisk item : dataDisks) {
        this.addToDataDisks(item);
      }
    }
    return (A) this;
  }
  
  public A withFailureDomains(List<String> failureDomains) {
    if (failureDomains != null) {
        this.failureDomains = new ArrayList();
        for (String item : failureDomains) {
          this.addToFailureDomains(item);
        }
    } else {
      this.failureDomains = null;
    }
    return (A) this;
  }
  
  public A withFailureDomains(String... failureDomains) {
    if (this.failureDomains != null) {
        this.failureDomains.clear();
        _visitables.remove("failureDomains");
    }
    if (failureDomains != null) {
      for (String item : failureDomains) {
        this.addToFailureDomains(item);
      }
    }
    return (A) this;
  }
  
  public A withGpus(List<NutanixGPU> gpus) {
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
  
  public A withMemoryMiB(Long memoryMiB) {
    this.memoryMiB = memoryMiB;
    return (A) this;
  }
  
  public OsDiskNested<A> withNewOsDisk() {
    return new OsDiskNested(null);
  }
  
  public A withNewOsDisk(Long diskSizeGiB) {
    return (A) this.withOsDisk(new OSDisk(diskSizeGiB));
  }
  
  public OsDiskNested<A> withNewOsDiskLike(OSDisk item) {
    return new OsDiskNested(item);
  }
  
  public A withNewProject(String name,String type,String uuid) {
    return (A) this.withProject(new NutanixResourceIdentifier(name, type, uuid));
  }
  
  public A withOsDisk(OSDisk osDisk) {
    this._visitables.remove("osDisk");
    if (osDisk != null) {
        this.osDisk = new OSDiskBuilder(osDisk);
        this._visitables.get("osDisk").add(this.osDisk);
    } else {
        this.osDisk = null;
        this._visitables.get("osDisk").remove(this.osDisk);
    }
    return (A) this;
  }
  
  public A withProject(NutanixResourceIdentifier project) {
    this.project = project;
    return (A) this;
  }
  public class DataDisksNested<N> extends DataDiskFluent<DataDisksNested<N>> implements Nested<N>{
  
    DataDiskBuilder builder;
    int index;
  
    DataDisksNested(int index,DataDisk item) {
      this.index = index;
      this.builder = new DataDiskBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolFluent.this.setToDataDisks(index, builder.build());
    }
    
    public N endDataDisk() {
      return and();
    }
    
  }
  public class OsDiskNested<N> extends OSDiskFluent<OsDiskNested<N>> implements Nested<N>{
  
    OSDiskBuilder builder;
  
    OsDiskNested(OSDisk item) {
      this.builder = new OSDiskBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolFluent.this.withOsDisk(builder.build());
    }
    
    public N endOsDisk() {
      return and();
    }
    
  }
}