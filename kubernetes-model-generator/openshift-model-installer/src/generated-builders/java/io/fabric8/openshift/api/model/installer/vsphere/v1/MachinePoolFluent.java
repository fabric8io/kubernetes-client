package io.fabric8.openshift.api.model.installer.vsphere.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class MachinePoolFluent<A extends io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePoolFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer coresPerSocket;
  private Integer cpus;
  private ArrayList<DataDiskBuilder> dataDisks = new ArrayList<DataDiskBuilder>();
  private Long memoryMB;
  private OSDiskBuilder osDisk;
  private List<String> zones = new ArrayList<String>();

  public MachinePoolFluent() {
  }
  
  public MachinePoolFluent(MachinePool instance) {
    this.copyInstance(instance);
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
  
  public A addAllToZones(Collection<String> items) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    for (String item : items) {
      this.zones.add(item);
    }
    return (A) this;
  }
  
  public DataDisksNested<A> addNewDataDisk() {
    return new DataDisksNested(-1, null);
  }
  
  public A addNewDataDisk(String name,String provisioningMode,Integer sizeGiB) {
    return (A) this.addToDataDisks(new DataDisk(name, provisioningMode, sizeGiB));
  }
  
  public DataDisksNested<A> addNewDataDiskLike(DataDisk item) {
    return new DataDisksNested(-1, item);
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
  
  public A addToZones(String... items) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    for (String item : items) {
      this.zones.add(item);
    }
    return (A) this;
  }
  
  public A addToZones(int index,String item) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    this.zones.add(index, item);
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
        this.withCoresPerSocket(instance.getCoresPerSocket());
        this.withCpus(instance.getCpus());
        this.withDataDisks(instance.getDataDisks());
        this.withMemoryMB(instance.getMemoryMB());
        this.withOsDisk(instance.getOsDisk());
        this.withZones(instance.getZones());
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
    if (!(Objects.equals(coresPerSocket, that.coresPerSocket))) {
      return false;
    }
    if (!(Objects.equals(cpus, that.cpus))) {
      return false;
    }
    if (!(Objects.equals(dataDisks, that.dataDisks))) {
      return false;
    }
    if (!(Objects.equals(memoryMB, that.memoryMB))) {
      return false;
    }
    if (!(Objects.equals(osDisk, that.osDisk))) {
      return false;
    }
    if (!(Objects.equals(zones, that.zones))) {
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
  
  public Integer getCoresPerSocket() {
    return this.coresPerSocket;
  }
  
  public Integer getCpus() {
    return this.cpus;
  }
  
  public String getFirstZone() {
    return this.zones.get(0);
  }
  
  public String getLastZone() {
    return this.zones.get(zones.size() - 1);
  }
  
  public String getMatchingZone(Predicate<String> predicate) {
      for (String item : zones) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getMemoryMB() {
    return this.memoryMB;
  }
  
  public String getZone(int index) {
    return this.zones.get(index);
  }
  
  public List<String> getZones() {
    return this.zones;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
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
  
  public boolean hasMatchingDataDisk(Predicate<DataDiskBuilder> predicate) {
      for (DataDiskBuilder item : dataDisks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingZone(Predicate<String> predicate) {
      for (String item : zones) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMemoryMB() {
    return this.memoryMB != null;
  }
  
  public boolean hasOsDisk() {
    return this.osDisk != null;
  }
  
  public boolean hasZones() {
    return this.zones != null && !(this.zones.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(coresPerSocket, cpus, dataDisks, memoryMB, osDisk, zones, additionalProperties);
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
  
  public A removeAllFromZones(Collection<String> items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.zones.remove(item);
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
  
  public A removeFromZones(String... items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.zones.remove(item);
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
  
  public A setToZones(int index,String item) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    this.zones.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(memoryMB == null)) {
        sb.append("memoryMB:");
        sb.append(memoryMB);
        sb.append(",");
    }
    if (!(osDisk == null)) {
        sb.append("osDisk:");
        sb.append(osDisk);
        sb.append(",");
    }
    if (!(zones == null) && !(zones.isEmpty())) {
        sb.append("zones:");
        sb.append(zones);
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
  
  public A withCoresPerSocket(Integer coresPerSocket) {
    this.coresPerSocket = coresPerSocket;
    return (A) this;
  }
  
  public A withCpus(Integer cpus) {
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
  
  public A withMemoryMB(Long memoryMB) {
    this.memoryMB = memoryMB;
    return (A) this;
  }
  
  public OsDiskNested<A> withNewOsDisk() {
    return new OsDiskNested(null);
  }
  
  public A withNewOsDisk(Integer diskSizeGB) {
    return (A) this.withOsDisk(new OSDisk(diskSizeGB));
  }
  
  public OsDiskNested<A> withNewOsDiskLike(OSDisk item) {
    return new OsDiskNested(item);
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
  
  public A withZones(List<String> zones) {
    if (zones != null) {
        this.zones = new ArrayList();
        for (String item : zones) {
          this.addToZones(item);
        }
    } else {
      this.zones = null;
    }
    return (A) this;
  }
  
  public A withZones(String... zones) {
    if (this.zones != null) {
        this.zones.clear();
        _visitables.remove("zones");
    }
    if (zones != null) {
      for (String item : zones) {
        this.addToZones(item);
      }
    }
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