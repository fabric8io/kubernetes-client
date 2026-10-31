package io.fabric8.openshift.api.model.hive.vsphere.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.openshift.api.model.installer.vsphere.v1.DataDisk;
import io.fabric8.openshift.api.model.installer.vsphere.v1.OSDisk;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class MachinePoolFluent<A extends io.fabric8.openshift.api.model.hive.vsphere.v1.MachinePoolFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer coresPerSocket;
  private Integer cpus;
  private List<DataDisk> dataDisks = new ArrayList<DataDisk>();
  private Long memoryMB;
  private OSDisk osDisk;
  private String resourcePool;
  private List<String> tagIDs = new ArrayList<String>();
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
      this.dataDisks.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTagIDs(Collection<String> items) {
    if (this.tagIDs == null) {
      this.tagIDs = new ArrayList();
    }
    for (String item : items) {
      this.tagIDs.add(item);
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
  
  public A addNewDataDisk(String name,String provisioningMode,Integer sizeGiB) {
    return (A) this.addToDataDisks(new DataDisk(name, provisioningMode, sizeGiB));
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
      this.dataDisks.add(item);
    }
    return (A) this;
  }
  
  public A addToDataDisks(int index,DataDisk item) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    this.dataDisks.add(index, item);
    return (A) this;
  }
  
  public A addToTagIDs(String... items) {
    if (this.tagIDs == null) {
      this.tagIDs = new ArrayList();
    }
    for (String item : items) {
      this.tagIDs.add(item);
    }
    return (A) this;
  }
  
  public A addToTagIDs(int index,String item) {
    if (this.tagIDs == null) {
      this.tagIDs = new ArrayList();
    }
    this.tagIDs.add(index, item);
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
  
  protected void copyInstance(MachinePool instance) {
    instance = instance != null ? instance : new MachinePool();
    if (instance != null) {
        this.withCoresPerSocket(instance.getCoresPerSocket());
        this.withCpus(instance.getCpus());
        this.withDataDisks(instance.getDataDisks());
        this.withMemoryMB(instance.getMemoryMB());
        this.withOsDisk(instance.getOsDisk());
        this.withResourcePool(instance.getResourcePool());
        this.withTagIDs(instance.getTagIDs());
        this.withZones(instance.getZones());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    if (!(Objects.equals(resourcePool, that.resourcePool))) {
      return false;
    }
    if (!(Objects.equals(tagIDs, that.tagIDs))) {
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
  
  public DataDisk getDataDisk(int index) {
    return this.dataDisks.get(index);
  }
  
  public List<DataDisk> getDataDisks() {
    return this.dataDisks;
  }
  
  public DataDisk getFirstDataDisk() {
    return this.dataDisks.get(0);
  }
  
  public String getFirstTagID() {
    return this.tagIDs.get(0);
  }
  
  public String getFirstZone() {
    return this.zones.get(0);
  }
  
  public DataDisk getLastDataDisk() {
    return this.dataDisks.get(dataDisks.size() - 1);
  }
  
  public String getLastTagID() {
    return this.tagIDs.get(tagIDs.size() - 1);
  }
  
  public String getLastZone() {
    return this.zones.get(zones.size() - 1);
  }
  
  public DataDisk getMatchingDataDisk(Predicate<DataDisk> predicate) {
      for (DataDisk item : dataDisks) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingTagID(Predicate<String> predicate) {
      for (String item : tagIDs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
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
  
  public OSDisk getOsDisk() {
    return this.osDisk;
  }
  
  public String getResourcePool() {
    return this.resourcePool;
  }
  
  public String getTagID(int index) {
    return this.tagIDs.get(index);
  }
  
  public List<String> getTagIDs() {
    return this.tagIDs;
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
  
  public boolean hasMatchingDataDisk(Predicate<DataDisk> predicate) {
      for (DataDisk item : dataDisks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTagID(Predicate<String> predicate) {
      for (String item : tagIDs) {
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
  
  public boolean hasResourcePool() {
    return this.resourcePool != null;
  }
  
  public boolean hasTagIDs() {
    return this.tagIDs != null && !(this.tagIDs.isEmpty());
  }
  
  public boolean hasZones() {
    return this.zones != null && !(this.zones.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(coresPerSocket, cpus, dataDisks, memoryMB, osDisk, resourcePool, tagIDs, zones, additionalProperties);
  }
  
  public A removeAllFromDataDisks(Collection<DataDisk> items) {
    if (this.dataDisks == null) {
      return (A) this;
    }
    for (DataDisk item : items) {
      this.dataDisks.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTagIDs(Collection<String> items) {
    if (this.tagIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tagIDs.remove(item);
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
      this.dataDisks.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTagIDs(String... items) {
    if (this.tagIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tagIDs.remove(item);
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
  
  public A setToDataDisks(int index,DataDisk item) {
    if (this.dataDisks == null) {
      this.dataDisks = new ArrayList();
    }
    this.dataDisks.set(index, item);
    return (A) this;
  }
  
  public A setToTagIDs(int index,String item) {
    if (this.tagIDs == null) {
      this.tagIDs = new ArrayList();
    }
    this.tagIDs.set(index, item);
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
    if (!(resourcePool == null)) {
        sb.append("resourcePool:");
        sb.append(resourcePool);
        sb.append(",");
    }
    if (!(tagIDs == null) && !(tagIDs.isEmpty())) {
        sb.append("tagIDs:");
        sb.append(tagIDs);
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
  
  public A withNewOsDisk(Integer diskSizeGB) {
    return (A) this.withOsDisk(new OSDisk(diskSizeGB));
  }
  
  public A withOsDisk(OSDisk osDisk) {
    this.osDisk = osDisk;
    return (A) this;
  }
  
  public A withResourcePool(String resourcePool) {
    this.resourcePool = resourcePool;
    return (A) this;
  }
  
  public A withTagIDs(List<String> tagIDs) {
    if (tagIDs != null) {
        this.tagIDs = new ArrayList();
        for (String item : tagIDs) {
          this.addToTagIDs(item);
        }
    } else {
      this.tagIDs = null;
    }
    return (A) this;
  }
  
  public A withTagIDs(String... tagIDs) {
    if (this.tagIDs != null) {
        this.tagIDs.clear();
        _visitables.remove("tagIDs");
    }
    if (tagIDs != null) {
      for (String item : tagIDs) {
        this.addToTagIDs(item);
      }
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
  
}