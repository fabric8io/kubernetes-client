package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class HardwareDetailsFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.HardwareDetailsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CPUBuilder cpu;
  private FirmwareBuilder firmware;
  private String hostname;
  private ArrayList<NICBuilder> nics = new ArrayList<NICBuilder>();
  private Integer ramMebibytes;
  private ArrayList<StorageBuilder> storage = new ArrayList<StorageBuilder>();
  private HardwareSystemVendorBuilder systemVendor;

  public HardwareDetailsFluent() {
  }
  
  public HardwareDetailsFluent(HardwareDetails instance) {
    this.copyInstance(instance);
  }

  public A addAllToNics(Collection<NIC> items) {
    if (this.nics == null) {
      this.nics = new ArrayList();
    }
    for (NIC item : items) {
        NICBuilder builder = new NICBuilder(item);
        _visitables.get("nics").add(builder);
        this.nics.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToStorage(Collection<Storage> items) {
    if (this.storage == null) {
      this.storage = new ArrayList();
    }
    for (Storage item : items) {
        StorageBuilder builder = new StorageBuilder(item);
        _visitables.get("storage").add(builder);
        this.storage.add(builder);
    }
    return (A) this;
  }
  
  public NicsNested<A> addNewNic() {
    return new NicsNested(-1, null);
  }
  
  public NicsNested<A> addNewNicLike(NIC item) {
    return new NicsNested(-1, item);
  }
  
  public StorageNested<A> addNewStorage() {
    return new StorageNested(-1, null);
  }
  
  public StorageNested<A> addNewStorageLike(Storage item) {
    return new StorageNested(-1, item);
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
  
  public A addToNics(NIC... items) {
    if (this.nics == null) {
      this.nics = new ArrayList();
    }
    for (NIC item : items) {
        NICBuilder builder = new NICBuilder(item);
        _visitables.get("nics").add(builder);
        this.nics.add(builder);
    }
    return (A) this;
  }
  
  public A addToNics(int index,NIC item) {
    if (this.nics == null) {
      this.nics = new ArrayList();
    }
    NICBuilder builder = new NICBuilder(item);
    if (index < 0 || index >= nics.size()) {
        _visitables.get("nics").add(builder);
        nics.add(builder);
    } else {
        _visitables.get("nics").add(builder);
        nics.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToStorage(Storage... items) {
    if (this.storage == null) {
      this.storage = new ArrayList();
    }
    for (Storage item : items) {
        StorageBuilder builder = new StorageBuilder(item);
        _visitables.get("storage").add(builder);
        this.storage.add(builder);
    }
    return (A) this;
  }
  
  public A addToStorage(int index,Storage item) {
    if (this.storage == null) {
      this.storage = new ArrayList();
    }
    StorageBuilder builder = new StorageBuilder(item);
    if (index < 0 || index >= storage.size()) {
        _visitables.get("storage").add(builder);
        storage.add(builder);
    } else {
        _visitables.get("storage").add(builder);
        storage.add(index, builder);
    }
    return (A) this;
  }
  
  public CPU buildCpu() {
    return this.cpu != null ? this.cpu.build() : null;
  }
  
  public Firmware buildFirmware() {
    return this.firmware != null ? this.firmware.build() : null;
  }
  
  public NIC buildFirstNic() {
    return this.nics.get(0).build();
  }
  
  public Storage buildFirstStorage() {
    return this.storage.get(0).build();
  }
  
  public NIC buildLastNic() {
    return this.nics.get(nics.size() - 1).build();
  }
  
  public Storage buildLastStorage() {
    return this.storage.get(storage.size() - 1).build();
  }
  
  public NIC buildMatchingNic(Predicate<NICBuilder> predicate) {
      for (NICBuilder item : nics) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Storage buildMatchingStorage(Predicate<StorageBuilder> predicate) {
      for (StorageBuilder item : storage) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NIC buildNic(int index) {
    return this.nics.get(index).build();
  }
  
  public List<NIC> buildNics() {
    return this.nics != null ? build(nics) : null;
  }
  
  public List<Storage> buildStorage() {
    return this.storage != null ? build(storage) : null;
  }
  
  public Storage buildStorage(int index) {
    return this.storage.get(index).build();
  }
  
  public HardwareSystemVendor buildSystemVendor() {
    return this.systemVendor != null ? this.systemVendor.build() : null;
  }
  
  protected void copyInstance(HardwareDetails instance) {
    instance = instance != null ? instance : new HardwareDetails();
    if (instance != null) {
        this.withCpu(instance.getCpu());
        this.withFirmware(instance.getFirmware());
        this.withHostname(instance.getHostname());
        this.withNics(instance.getNics());
        this.withRamMebibytes(instance.getRamMebibytes());
        this.withStorage(instance.getStorage());
        this.withSystemVendor(instance.getSystemVendor());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CpuNested<A> editCpu() {
    return this.withNewCpuLike(Optional.ofNullable(this.buildCpu()).orElse(null));
  }
  
  public FirmwareNested<A> editFirmware() {
    return this.withNewFirmwareLike(Optional.ofNullable(this.buildFirmware()).orElse(null));
  }
  
  public NicsNested<A> editFirstNic() {
    if (nics.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "nics"));
    }
    return this.setNewNicLike(0, this.buildNic(0));
  }
  
  public StorageNested<A> editFirstStorage() {
    if (storage.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "storage"));
    }
    return this.setNewStorageLike(0, this.buildStorage(0));
  }
  
  public NicsNested<A> editLastNic() {
    int index = nics.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "nics"));
    }
    return this.setNewNicLike(index, this.buildNic(index));
  }
  
  public StorageNested<A> editLastStorage() {
    int index = storage.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "storage"));
    }
    return this.setNewStorageLike(index, this.buildStorage(index));
  }
  
  public NicsNested<A> editMatchingNic(Predicate<NICBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < nics.size();i++) {
      if (predicate.test(nics.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "nics"));
    }
    return this.setNewNicLike(index, this.buildNic(index));
  }
  
  public StorageNested<A> editMatchingStorage(Predicate<StorageBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < storage.size();i++) {
      if (predicate.test(storage.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "storage"));
    }
    return this.setNewStorageLike(index, this.buildStorage(index));
  }
  
  public NicsNested<A> editNic(int index) {
    if (nics.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "nics"));
    }
    return this.setNewNicLike(index, this.buildNic(index));
  }
  
  public CpuNested<A> editOrNewCpu() {
    return this.withNewCpuLike(Optional.ofNullable(this.buildCpu()).orElse(new CPUBuilder().build()));
  }
  
  public CpuNested<A> editOrNewCpuLike(CPU item) {
    return this.withNewCpuLike(Optional.ofNullable(this.buildCpu()).orElse(item));
  }
  
  public FirmwareNested<A> editOrNewFirmware() {
    return this.withNewFirmwareLike(Optional.ofNullable(this.buildFirmware()).orElse(new FirmwareBuilder().build()));
  }
  
  public FirmwareNested<A> editOrNewFirmwareLike(Firmware item) {
    return this.withNewFirmwareLike(Optional.ofNullable(this.buildFirmware()).orElse(item));
  }
  
  public SystemVendorNested<A> editOrNewSystemVendor() {
    return this.withNewSystemVendorLike(Optional.ofNullable(this.buildSystemVendor()).orElse(new HardwareSystemVendorBuilder().build()));
  }
  
  public SystemVendorNested<A> editOrNewSystemVendorLike(HardwareSystemVendor item) {
    return this.withNewSystemVendorLike(Optional.ofNullable(this.buildSystemVendor()).orElse(item));
  }
  
  public StorageNested<A> editStorage(int index) {
    if (storage.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "storage"));
    }
    return this.setNewStorageLike(index, this.buildStorage(index));
  }
  
  public SystemVendorNested<A> editSystemVendor() {
    return this.withNewSystemVendorLike(Optional.ofNullable(this.buildSystemVendor()).orElse(null));
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
    HardwareDetailsFluent that = (HardwareDetailsFluent) o;
    if (!(Objects.equals(cpu, that.cpu))) {
      return false;
    }
    if (!(Objects.equals(firmware, that.firmware))) {
      return false;
    }
    if (!(Objects.equals(hostname, that.hostname))) {
      return false;
    }
    if (!(Objects.equals(nics, that.nics))) {
      return false;
    }
    if (!(Objects.equals(ramMebibytes, that.ramMebibytes))) {
      return false;
    }
    if (!(Objects.equals(storage, that.storage))) {
      return false;
    }
    if (!(Objects.equals(systemVendor, that.systemVendor))) {
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
  
  public String getHostname() {
    return this.hostname;
  }
  
  public Integer getRamMebibytes() {
    return this.ramMebibytes;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCpu() {
    return this.cpu != null;
  }
  
  public boolean hasFirmware() {
    return this.firmware != null;
  }
  
  public boolean hasHostname() {
    return this.hostname != null;
  }
  
  public boolean hasMatchingNic(Predicate<NICBuilder> predicate) {
      for (NICBuilder item : nics) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStorage(Predicate<StorageBuilder> predicate) {
      for (StorageBuilder item : storage) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNics() {
    return this.nics != null && !(this.nics.isEmpty());
  }
  
  public boolean hasRamMebibytes() {
    return this.ramMebibytes != null;
  }
  
  public boolean hasStorage() {
    return this.storage != null && !(this.storage.isEmpty());
  }
  
  public boolean hasSystemVendor() {
    return this.systemVendor != null;
  }
  
  public int hashCode() {
    return Objects.hash(cpu, firmware, hostname, nics, ramMebibytes, storage, systemVendor, additionalProperties);
  }
  
  public A removeAllFromNics(Collection<NIC> items) {
    if (this.nics == null) {
      return (A) this;
    }
    for (NIC item : items) {
        NICBuilder builder = new NICBuilder(item);
        _visitables.get("nics").remove(builder);
        this.nics.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromStorage(Collection<Storage> items) {
    if (this.storage == null) {
      return (A) this;
    }
    for (Storage item : items) {
        StorageBuilder builder = new StorageBuilder(item);
        _visitables.get("storage").remove(builder);
        this.storage.remove(builder);
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
  
  public A removeFromNics(NIC... items) {
    if (this.nics == null) {
      return (A) this;
    }
    for (NIC item : items) {
        NICBuilder builder = new NICBuilder(item);
        _visitables.get("nics").remove(builder);
        this.nics.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromStorage(Storage... items) {
    if (this.storage == null) {
      return (A) this;
    }
    for (Storage item : items) {
        StorageBuilder builder = new StorageBuilder(item);
        _visitables.get("storage").remove(builder);
        this.storage.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromNics(Predicate<NICBuilder> predicate) {
    if (nics == null) {
      return (A) this;
    }
    Iterator<NICBuilder> each = nics.iterator();
    List visitables = _visitables.get("nics");
    while (each.hasNext()) {
        NICBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromStorage(Predicate<StorageBuilder> predicate) {
    if (storage == null) {
      return (A) this;
    }
    Iterator<StorageBuilder> each = storage.iterator();
    List visitables = _visitables.get("storage");
    while (each.hasNext()) {
        StorageBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public NicsNested<A> setNewNicLike(int index,NIC item) {
    return new NicsNested(index, item);
  }
  
  public StorageNested<A> setNewStorageLike(int index,Storage item) {
    return new StorageNested(index, item);
  }
  
  public A setToNics(int index,NIC item) {
    if (this.nics == null) {
      this.nics = new ArrayList();
    }
    NICBuilder builder = new NICBuilder(item);
    if (index < 0 || index >= nics.size()) {
        _visitables.get("nics").add(builder);
        nics.add(builder);
    } else {
        _visitables.get("nics").add(builder);
        nics.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToStorage(int index,Storage item) {
    if (this.storage == null) {
      this.storage = new ArrayList();
    }
    StorageBuilder builder = new StorageBuilder(item);
    if (index < 0 || index >= storage.size()) {
        _visitables.get("storage").add(builder);
        storage.add(builder);
    } else {
        _visitables.get("storage").add(builder);
        storage.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cpu == null)) {
        sb.append("cpu:");
        sb.append(cpu);
        sb.append(",");
    }
    if (!(firmware == null)) {
        sb.append("firmware:");
        sb.append(firmware);
        sb.append(",");
    }
    if (!(hostname == null)) {
        sb.append("hostname:");
        sb.append(hostname);
        sb.append(",");
    }
    if (!(nics == null) && !(nics.isEmpty())) {
        sb.append("nics:");
        sb.append(nics);
        sb.append(",");
    }
    if (!(ramMebibytes == null)) {
        sb.append("ramMebibytes:");
        sb.append(ramMebibytes);
        sb.append(",");
    }
    if (!(storage == null) && !(storage.isEmpty())) {
        sb.append("storage:");
        sb.append(storage);
        sb.append(",");
    }
    if (!(systemVendor == null)) {
        sb.append("systemVendor:");
        sb.append(systemVendor);
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
  
  public A withCpu(CPU cpu) {
    this._visitables.remove("cpu");
    if (cpu != null) {
        this.cpu = new CPUBuilder(cpu);
        this._visitables.get("cpu").add(this.cpu);
    } else {
        this.cpu = null;
        this._visitables.get("cpu").remove(this.cpu);
    }
    return (A) this;
  }
  
  public A withFirmware(Firmware firmware) {
    this._visitables.remove("firmware");
    if (firmware != null) {
        this.firmware = new FirmwareBuilder(firmware);
        this._visitables.get("firmware").add(this.firmware);
    } else {
        this.firmware = null;
        this._visitables.get("firmware").remove(this.firmware);
    }
    return (A) this;
  }
  
  public A withHostname(String hostname) {
    this.hostname = hostname;
    return (A) this;
  }
  
  public CpuNested<A> withNewCpu() {
    return new CpuNested(null);
  }
  
  public CpuNested<A> withNewCpuLike(CPU item) {
    return new CpuNested(item);
  }
  
  public FirmwareNested<A> withNewFirmware() {
    return new FirmwareNested(null);
  }
  
  public FirmwareNested<A> withNewFirmwareLike(Firmware item) {
    return new FirmwareNested(item);
  }
  
  public SystemVendorNested<A> withNewSystemVendor() {
    return new SystemVendorNested(null);
  }
  
  public A withNewSystemVendor(String manufacturer,String productName,String serialNumber) {
    return (A) this.withSystemVendor(new HardwareSystemVendor(manufacturer, productName, serialNumber));
  }
  
  public SystemVendorNested<A> withNewSystemVendorLike(HardwareSystemVendor item) {
    return new SystemVendorNested(item);
  }
  
  public A withNics(List<NIC> nics) {
    if (this.nics != null) {
      this._visitables.get("nics").clear();
    }
    if (nics != null) {
        this.nics = new ArrayList();
        for (NIC item : nics) {
          this.addToNics(item);
        }
    } else {
      this.nics = null;
    }
    return (A) this;
  }
  
  public A withNics(NIC... nics) {
    if (this.nics != null) {
        this.nics.clear();
        _visitables.remove("nics");
    }
    if (nics != null) {
      for (NIC item : nics) {
        this.addToNics(item);
      }
    }
    return (A) this;
  }
  
  public A withRamMebibytes(Integer ramMebibytes) {
    this.ramMebibytes = ramMebibytes;
    return (A) this;
  }
  
  public A withStorage(List<Storage> storage) {
    if (this.storage != null) {
      this._visitables.get("storage").clear();
    }
    if (storage != null) {
        this.storage = new ArrayList();
        for (Storage item : storage) {
          this.addToStorage(item);
        }
    } else {
      this.storage = null;
    }
    return (A) this;
  }
  
  public A withStorage(Storage... storage) {
    if (this.storage != null) {
        this.storage.clear();
        _visitables.remove("storage");
    }
    if (storage != null) {
      for (Storage item : storage) {
        this.addToStorage(item);
      }
    }
    return (A) this;
  }
  
  public A withSystemVendor(HardwareSystemVendor systemVendor) {
    this._visitables.remove("systemVendor");
    if (systemVendor != null) {
        this.systemVendor = new HardwareSystemVendorBuilder(systemVendor);
        this._visitables.get("systemVendor").add(this.systemVendor);
    } else {
        this.systemVendor = null;
        this._visitables.get("systemVendor").remove(this.systemVendor);
    }
    return (A) this;
  }
  public class CpuNested<N> extends CPUFluent<CpuNested<N>> implements Nested<N>{
  
    CPUBuilder builder;
  
    CpuNested(CPU item) {
      this.builder = new CPUBuilder(this, item);
    }
  
    public N and() {
      return (N) HardwareDetailsFluent.this.withCpu(builder.build());
    }
    
    public N endCpu() {
      return and();
    }
    
  }
  public class FirmwareNested<N> extends FirmwareFluent<FirmwareNested<N>> implements Nested<N>{
  
    FirmwareBuilder builder;
  
    FirmwareNested(Firmware item) {
      this.builder = new FirmwareBuilder(this, item);
    }
  
    public N and() {
      return (N) HardwareDetailsFluent.this.withFirmware(builder.build());
    }
    
    public N endFirmware() {
      return and();
    }
    
  }
  public class NicsNested<N> extends NICFluent<NicsNested<N>> implements Nested<N>{
  
    NICBuilder builder;
    int index;
  
    NicsNested(int index,NIC item) {
      this.index = index;
      this.builder = new NICBuilder(this, item);
    }
  
    public N and() {
      return (N) HardwareDetailsFluent.this.setToNics(index, builder.build());
    }
    
    public N endNic() {
      return and();
    }
    
  }
  public class StorageNested<N> extends StorageFluent<StorageNested<N>> implements Nested<N>{
  
    StorageBuilder builder;
    int index;
  
    StorageNested(int index,Storage item) {
      this.index = index;
      this.builder = new StorageBuilder(this, item);
    }
  
    public N and() {
      return (N) HardwareDetailsFluent.this.setToStorage(index, builder.build());
    }
    
    public N endStorage() {
      return and();
    }
    
  }
  public class SystemVendorNested<N> extends HardwareSystemVendorFluent<SystemVendorNested<N>> implements Nested<N>{
  
    HardwareSystemVendorBuilder builder;
  
    SystemVendorNested(HardwareSystemVendor item) {
      this.builder = new HardwareSystemVendorBuilder(this, item);
    }
  
    public N and() {
      return (N) HardwareDetailsFluent.this.withSystemVendor(builder.build());
    }
    
    public N endSystemVendor() {
      return and();
    }
    
  }
}