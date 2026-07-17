package io.fabric8.openshift.api.model.installer.v1;

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
public class NetworkingFluent<A extends io.fabric8.openshift.api.model.installer.v1.NetworkingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ClusterNetworkEntryBuilder> clusterNetwork = new ArrayList<ClusterNetworkEntryBuilder>();
  private ArrayList<ClusterNetworkEntryBuilder> clusterNetworkList = new ArrayList<ClusterNetworkEntryBuilder>();
  private Long clusterNetworkMTU;
  private String machineCIDR;
  private ArrayList<MachineNetworkEntryBuilder> machineNetwork = new ArrayList<MachineNetworkEntryBuilder>();
  private String networkType;
  private OVNKubernetesConfigBuilder ovnKubernetesConfig;
  private String serviceCIDR;
  private List<String> serviceNetwork = new ArrayList<String>();
  private String type;

  public NetworkingFluent() {
  }
  
  public NetworkingFluent(Networking instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusterNetwork(Collection<ClusterNetworkEntry> items) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").add(builder);
        this.clusterNetwork.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToClusterNetworkList(Collection<ClusterNetworkEntry> items) {
    if (this.clusterNetworkList == null) {
      this.clusterNetworkList = new ArrayList();
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetworkList").add(builder);
        this.clusterNetworkList.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMachineNetwork(Collection<MachineNetworkEntry> items) {
    if (this.machineNetwork == null) {
      this.machineNetwork = new ArrayList();
    }
    for (MachineNetworkEntry item : items) {
        MachineNetworkEntryBuilder builder = new MachineNetworkEntryBuilder(item);
        _visitables.get("machineNetwork").add(builder);
        this.machineNetwork.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToServiceNetwork(Collection<String> items) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    for (String item : items) {
      this.serviceNetwork.add(item);
    }
    return (A) this;
  }
  
  public ClusterNetworkNested<A> addNewClusterNetwork() {
    return new ClusterNetworkNested(-1, null);
  }
  
  public A addNewClusterNetwork(String cidr,Integer hostPrefix,Integer hostSubnetLength) {
    return (A) this.addToClusterNetwork(new ClusterNetworkEntry(cidr, hostPrefix, hostSubnetLength));
  }
  
  public ClusterNetworkNested<A> addNewClusterNetworkLike(ClusterNetworkEntry item) {
    return new ClusterNetworkNested(-1, item);
  }
  
  public ClusterNetworkListNested<A> addNewClusterNetworkList() {
    return new ClusterNetworkListNested(-1, null);
  }
  
  public A addNewClusterNetworkList(String cidr,Integer hostPrefix,Integer hostSubnetLength) {
    return (A) this.addToClusterNetworkList(new ClusterNetworkEntry(cidr, hostPrefix, hostSubnetLength));
  }
  
  public ClusterNetworkListNested<A> addNewClusterNetworkListLike(ClusterNetworkEntry item) {
    return new ClusterNetworkListNested(-1, item);
  }
  
  public MachineNetworkNested<A> addNewMachineNetwork() {
    return new MachineNetworkNested(-1, null);
  }
  
  public A addNewMachineNetwork(String cidr) {
    return (A) this.addToMachineNetwork(new MachineNetworkEntry(cidr));
  }
  
  public MachineNetworkNested<A> addNewMachineNetworkLike(MachineNetworkEntry item) {
    return new MachineNetworkNested(-1, item);
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
  
  public A addToClusterNetwork(ClusterNetworkEntry... items) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").add(builder);
        this.clusterNetwork.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusterNetwork(int index,ClusterNetworkEntry item) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
    if (index < 0 || index >= clusterNetwork.size()) {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.add(builder);
    } else {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToClusterNetworkList(ClusterNetworkEntry... items) {
    if (this.clusterNetworkList == null) {
      this.clusterNetworkList = new ArrayList();
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetworkList").add(builder);
        this.clusterNetworkList.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusterNetworkList(int index,ClusterNetworkEntry item) {
    if (this.clusterNetworkList == null) {
      this.clusterNetworkList = new ArrayList();
    }
    ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
    if (index < 0 || index >= clusterNetworkList.size()) {
        _visitables.get("clusterNetworkList").add(builder);
        clusterNetworkList.add(builder);
    } else {
        _visitables.get("clusterNetworkList").add(builder);
        clusterNetworkList.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMachineNetwork(MachineNetworkEntry... items) {
    if (this.machineNetwork == null) {
      this.machineNetwork = new ArrayList();
    }
    for (MachineNetworkEntry item : items) {
        MachineNetworkEntryBuilder builder = new MachineNetworkEntryBuilder(item);
        _visitables.get("machineNetwork").add(builder);
        this.machineNetwork.add(builder);
    }
    return (A) this;
  }
  
  public A addToMachineNetwork(int index,MachineNetworkEntry item) {
    if (this.machineNetwork == null) {
      this.machineNetwork = new ArrayList();
    }
    MachineNetworkEntryBuilder builder = new MachineNetworkEntryBuilder(item);
    if (index < 0 || index >= machineNetwork.size()) {
        _visitables.get("machineNetwork").add(builder);
        machineNetwork.add(builder);
    } else {
        _visitables.get("machineNetwork").add(builder);
        machineNetwork.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToServiceNetwork(String... items) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    for (String item : items) {
      this.serviceNetwork.add(item);
    }
    return (A) this;
  }
  
  public A addToServiceNetwork(int index,String item) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    this.serviceNetwork.add(index, item);
    return (A) this;
  }
  
  public List<ClusterNetworkEntry> buildClusterNetwork() {
    return this.clusterNetwork != null ? build(clusterNetwork) : null;
  }
  
  public ClusterNetworkEntry buildClusterNetwork(int index) {
    return this.clusterNetwork.get(index).build();
  }
  
  public List<ClusterNetworkEntry> buildClusterNetworkList() {
    return this.clusterNetworkList != null ? build(clusterNetworkList) : null;
  }
  
  public ClusterNetworkEntry buildClusterNetworkList(int index) {
    return this.clusterNetworkList.get(index).build();
  }
  
  public ClusterNetworkEntry buildFirstClusterNetwork() {
    return this.clusterNetwork.get(0).build();
  }
  
  public ClusterNetworkEntry buildFirstClusterNetworkList() {
    return this.clusterNetworkList.get(0).build();
  }
  
  public MachineNetworkEntry buildFirstMachineNetwork() {
    return this.machineNetwork.get(0).build();
  }
  
  public ClusterNetworkEntry buildLastClusterNetwork() {
    return this.clusterNetwork.get(clusterNetwork.size() - 1).build();
  }
  
  public ClusterNetworkEntry buildLastClusterNetworkList() {
    return this.clusterNetworkList.get(clusterNetworkList.size() - 1).build();
  }
  
  public MachineNetworkEntry buildLastMachineNetwork() {
    return this.machineNetwork.get(machineNetwork.size() - 1).build();
  }
  
  public List<MachineNetworkEntry> buildMachineNetwork() {
    return this.machineNetwork != null ? build(machineNetwork) : null;
  }
  
  public MachineNetworkEntry buildMachineNetwork(int index) {
    return this.machineNetwork.get(index).build();
  }
  
  public ClusterNetworkEntry buildMatchingClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
      for (ClusterNetworkEntryBuilder item : clusterNetwork) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClusterNetworkEntry buildMatchingClusterNetworkList(Predicate<ClusterNetworkEntryBuilder> predicate) {
      for (ClusterNetworkEntryBuilder item : clusterNetworkList) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MachineNetworkEntry buildMatchingMachineNetwork(Predicate<MachineNetworkEntryBuilder> predicate) {
      for (MachineNetworkEntryBuilder item : machineNetwork) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OVNKubernetesConfig buildOvnKubernetesConfig() {
    return this.ovnKubernetesConfig != null ? this.ovnKubernetesConfig.build() : null;
  }
  
  protected void copyInstance(Networking instance) {
    instance = instance != null ? instance : new Networking();
    if (instance != null) {
        this.withClusterNetwork(instance.getClusterNetwork());
        this.withClusterNetworkMTU(instance.getClusterNetworkMTU());
        this.withMachineCIDR(instance.getMachineCIDR());
        this.withMachineNetwork(instance.getMachineNetwork());
        this.withNetworkType(instance.getNetworkType());
        this.withOvnKubernetesConfig(instance.getOvnKubernetesConfig());
        this.withServiceCIDR(instance.getServiceCIDR());
        this.withServiceNetwork(instance.getServiceNetwork());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterNetworkNested<A> editClusterNetwork(int index) {
    if (clusterNetwork.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(index, this.buildClusterNetwork(index));
  }
  
  public ClusterNetworkListNested<A> editClusterNetworkList(int index) {
    if (clusterNetworkList.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusterNetworkList"));
    }
    return this.setNewClusterNetworkListLike(index, this.buildClusterNetworkList(index));
  }
  
  public ClusterNetworkNested<A> editFirstClusterNetwork() {
    if (clusterNetwork.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(0, this.buildClusterNetwork(0));
  }
  
  public ClusterNetworkListNested<A> editFirstClusterNetworkList() {
    if (clusterNetworkList.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusterNetworkList"));
    }
    return this.setNewClusterNetworkListLike(0, this.buildClusterNetworkList(0));
  }
  
  public MachineNetworkNested<A> editFirstMachineNetwork() {
    if (machineNetwork.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "machineNetwork"));
    }
    return this.setNewMachineNetworkLike(0, this.buildMachineNetwork(0));
  }
  
  public ClusterNetworkNested<A> editLastClusterNetwork() {
    int index = clusterNetwork.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(index, this.buildClusterNetwork(index));
  }
  
  public ClusterNetworkListNested<A> editLastClusterNetworkList() {
    int index = clusterNetworkList.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusterNetworkList"));
    }
    return this.setNewClusterNetworkListLike(index, this.buildClusterNetworkList(index));
  }
  
  public MachineNetworkNested<A> editLastMachineNetwork() {
    int index = machineNetwork.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "machineNetwork"));
    }
    return this.setNewMachineNetworkLike(index, this.buildMachineNetwork(index));
  }
  
  public MachineNetworkNested<A> editMachineNetwork(int index) {
    if (machineNetwork.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "machineNetwork"));
    }
    return this.setNewMachineNetworkLike(index, this.buildMachineNetwork(index));
  }
  
  public ClusterNetworkNested<A> editMatchingClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusterNetwork.size();i++) {
      if (predicate.test(clusterNetwork.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(index, this.buildClusterNetwork(index));
  }
  
  public ClusterNetworkListNested<A> editMatchingClusterNetworkList(Predicate<ClusterNetworkEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusterNetworkList.size();i++) {
      if (predicate.test(clusterNetworkList.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusterNetworkList"));
    }
    return this.setNewClusterNetworkListLike(index, this.buildClusterNetworkList(index));
  }
  
  public MachineNetworkNested<A> editMatchingMachineNetwork(Predicate<MachineNetworkEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < machineNetwork.size();i++) {
      if (predicate.test(machineNetwork.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "machineNetwork"));
    }
    return this.setNewMachineNetworkLike(index, this.buildMachineNetwork(index));
  }
  
  public OvnKubernetesConfigNested<A> editOrNewOvnKubernetesConfig() {
    return this.withNewOvnKubernetesConfigLike(Optional.ofNullable(this.buildOvnKubernetesConfig()).orElse(new OVNKubernetesConfigBuilder().build()));
  }
  
  public OvnKubernetesConfigNested<A> editOrNewOvnKubernetesConfigLike(OVNKubernetesConfig item) {
    return this.withNewOvnKubernetesConfigLike(Optional.ofNullable(this.buildOvnKubernetesConfig()).orElse(item));
  }
  
  public OvnKubernetesConfigNested<A> editOvnKubernetesConfig() {
    return this.withNewOvnKubernetesConfigLike(Optional.ofNullable(this.buildOvnKubernetesConfig()).orElse(null));
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
    NetworkingFluent that = (NetworkingFluent) o;
    if (!(Objects.equals(clusterNetwork, that.clusterNetwork))) {
      return false;
    }
    if (!(Objects.equals(clusterNetworkMTU, that.clusterNetworkMTU))) {
      return false;
    }
    if (!(Objects.equals(clusterNetworkList, that.clusterNetworkList))) {
      return false;
    }
    if (!(Objects.equals(machineCIDR, that.machineCIDR))) {
      return false;
    }
    if (!(Objects.equals(machineNetwork, that.machineNetwork))) {
      return false;
    }
    if (!(Objects.equals(networkType, that.networkType))) {
      return false;
    }
    if (!(Objects.equals(ovnKubernetesConfig, that.ovnKubernetesConfig))) {
      return false;
    }
    if (!(Objects.equals(serviceCIDR, that.serviceCIDR))) {
      return false;
    }
    if (!(Objects.equals(serviceNetwork, that.serviceNetwork))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public Long getClusterNetworkMTU() {
    return this.clusterNetworkMTU;
  }
  
  public String getFirstServiceNetwork() {
    return this.serviceNetwork.get(0);
  }
  
  public String getLastServiceNetwork() {
    return this.serviceNetwork.get(serviceNetwork.size() - 1);
  }
  
  public String getMachineCIDR() {
    return this.machineCIDR;
  }
  
  public String getMatchingServiceNetwork(Predicate<String> predicate) {
      for (String item : serviceNetwork) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNetworkType() {
    return this.networkType;
  }
  
  public String getServiceCIDR() {
    return this.serviceCIDR;
  }
  
  public List<String> getServiceNetwork() {
    return this.serviceNetwork;
  }
  
  public String getServiceNetwork(int index) {
    return this.serviceNetwork.get(index);
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterNetwork() {
    return this.clusterNetwork != null && !(this.clusterNetwork.isEmpty());
  }
  
  public boolean hasClusterNetworkList() {
    return this.clusterNetworkList != null && !(this.clusterNetworkList.isEmpty());
  }
  
  public boolean hasClusterNetworkMTU() {
    return this.clusterNetworkMTU != null;
  }
  
  public boolean hasMachineCIDR() {
    return this.machineCIDR != null;
  }
  
  public boolean hasMachineNetwork() {
    return this.machineNetwork != null && !(this.machineNetwork.isEmpty());
  }
  
  public boolean hasMatchingClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
      for (ClusterNetworkEntryBuilder item : clusterNetwork) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingClusterNetworkList(Predicate<ClusterNetworkEntryBuilder> predicate) {
      for (ClusterNetworkEntryBuilder item : clusterNetworkList) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMachineNetwork(Predicate<MachineNetworkEntryBuilder> predicate) {
      for (MachineNetworkEntryBuilder item : machineNetwork) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingServiceNetwork(Predicate<String> predicate) {
      for (String item : serviceNetwork) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetworkType() {
    return this.networkType != null;
  }
  
  public boolean hasOvnKubernetesConfig() {
    return this.ovnKubernetesConfig != null;
  }
  
  public boolean hasServiceCIDR() {
    return this.serviceCIDR != null;
  }
  
  public boolean hasServiceNetwork() {
    return this.serviceNetwork != null && !(this.serviceNetwork.isEmpty());
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusterNetwork, clusterNetworkMTU, clusterNetworkList, machineCIDR, machineNetwork, networkType, ovnKubernetesConfig, serviceCIDR, serviceNetwork, type, additionalProperties);
  }
  
  public A removeAllFromClusterNetwork(Collection<ClusterNetworkEntry> items) {
    if (this.clusterNetwork == null) {
      return (A) this;
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").remove(builder);
        this.clusterNetwork.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromClusterNetworkList(Collection<ClusterNetworkEntry> items) {
    if (this.clusterNetworkList == null) {
      return (A) this;
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetworkList").remove(builder);
        this.clusterNetworkList.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMachineNetwork(Collection<MachineNetworkEntry> items) {
    if (this.machineNetwork == null) {
      return (A) this;
    }
    for (MachineNetworkEntry item : items) {
        MachineNetworkEntryBuilder builder = new MachineNetworkEntryBuilder(item);
        _visitables.get("machineNetwork").remove(builder);
        this.machineNetwork.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromServiceNetwork(Collection<String> items) {
    if (this.serviceNetwork == null) {
      return (A) this;
    }
    for (String item : items) {
      this.serviceNetwork.remove(item);
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
  
  public A removeFromClusterNetwork(ClusterNetworkEntry... items) {
    if (this.clusterNetwork == null) {
      return (A) this;
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").remove(builder);
        this.clusterNetwork.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromClusterNetworkList(ClusterNetworkEntry... items) {
    if (this.clusterNetworkList == null) {
      return (A) this;
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetworkList").remove(builder);
        this.clusterNetworkList.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMachineNetwork(MachineNetworkEntry... items) {
    if (this.machineNetwork == null) {
      return (A) this;
    }
    for (MachineNetworkEntry item : items) {
        MachineNetworkEntryBuilder builder = new MachineNetworkEntryBuilder(item);
        _visitables.get("machineNetwork").remove(builder);
        this.machineNetwork.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromServiceNetwork(String... items) {
    if (this.serviceNetwork == null) {
      return (A) this;
    }
    for (String item : items) {
      this.serviceNetwork.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
    if (clusterNetwork == null) {
      return (A) this;
    }
    Iterator<ClusterNetworkEntryBuilder> each = clusterNetwork.iterator();
    List visitables = _visitables.get("clusterNetwork");
    while (each.hasNext()) {
        ClusterNetworkEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromClusterNetworkList(Predicate<ClusterNetworkEntryBuilder> predicate) {
    if (clusterNetworkList == null) {
      return (A) this;
    }
    Iterator<ClusterNetworkEntryBuilder> each = clusterNetworkList.iterator();
    List visitables = _visitables.get("clusterNetworkList");
    while (each.hasNext()) {
        ClusterNetworkEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromMachineNetwork(Predicate<MachineNetworkEntryBuilder> predicate) {
    if (machineNetwork == null) {
      return (A) this;
    }
    Iterator<MachineNetworkEntryBuilder> each = machineNetwork.iterator();
    List visitables = _visitables.get("machineNetwork");
    while (each.hasNext()) {
        MachineNetworkEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ClusterNetworkNested<A> setNewClusterNetworkLike(int index,ClusterNetworkEntry item) {
    return new ClusterNetworkNested(index, item);
  }
  
  public ClusterNetworkListNested<A> setNewClusterNetworkListLike(int index,ClusterNetworkEntry item) {
    return new ClusterNetworkListNested(index, item);
  }
  
  public MachineNetworkNested<A> setNewMachineNetworkLike(int index,MachineNetworkEntry item) {
    return new MachineNetworkNested(index, item);
  }
  
  public A setToClusterNetwork(int index,ClusterNetworkEntry item) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
    if (index < 0 || index >= clusterNetwork.size()) {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.add(builder);
    } else {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToClusterNetworkList(int index,ClusterNetworkEntry item) {
    if (this.clusterNetworkList == null) {
      this.clusterNetworkList = new ArrayList();
    }
    ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
    if (index < 0 || index >= clusterNetworkList.size()) {
        _visitables.get("clusterNetworkList").add(builder);
        clusterNetworkList.add(builder);
    } else {
        _visitables.get("clusterNetworkList").add(builder);
        clusterNetworkList.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMachineNetwork(int index,MachineNetworkEntry item) {
    if (this.machineNetwork == null) {
      this.machineNetwork = new ArrayList();
    }
    MachineNetworkEntryBuilder builder = new MachineNetworkEntryBuilder(item);
    if (index < 0 || index >= machineNetwork.size()) {
        _visitables.get("machineNetwork").add(builder);
        machineNetwork.add(builder);
    } else {
        _visitables.get("machineNetwork").add(builder);
        machineNetwork.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToServiceNetwork(int index,String item) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    this.serviceNetwork.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterNetwork == null) && !(clusterNetwork.isEmpty())) {
        sb.append("clusterNetwork:");
        sb.append(clusterNetwork);
        sb.append(",");
    }
    if (!(clusterNetworkMTU == null)) {
        sb.append("clusterNetworkMTU:");
        sb.append(clusterNetworkMTU);
        sb.append(",");
    }
    if (!(clusterNetworkList == null) && !(clusterNetworkList.isEmpty())) {
        sb.append("clusterNetworkList:");
        sb.append(clusterNetworkList);
        sb.append(",");
    }
    if (!(machineCIDR == null)) {
        sb.append("machineCIDR:");
        sb.append(machineCIDR);
        sb.append(",");
    }
    if (!(machineNetwork == null) && !(machineNetwork.isEmpty())) {
        sb.append("machineNetwork:");
        sb.append(machineNetwork);
        sb.append(",");
    }
    if (!(networkType == null)) {
        sb.append("networkType:");
        sb.append(networkType);
        sb.append(",");
    }
    if (!(ovnKubernetesConfig == null)) {
        sb.append("ovnKubernetesConfig:");
        sb.append(ovnKubernetesConfig);
        sb.append(",");
    }
    if (!(serviceCIDR == null)) {
        sb.append("serviceCIDR:");
        sb.append(serviceCIDR);
        sb.append(",");
    }
    if (!(serviceNetwork == null) && !(serviceNetwork.isEmpty())) {
        sb.append("serviceNetwork:");
        sb.append(serviceNetwork);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withClusterNetwork(List<ClusterNetworkEntry> clusterNetwork) {
    if (this.clusterNetwork != null) {
      this._visitables.get("clusterNetwork").clear();
    }
    if (clusterNetwork != null) {
        this.clusterNetwork = new ArrayList();
        for (ClusterNetworkEntry item : clusterNetwork) {
          this.addToClusterNetwork(item);
        }
    } else {
      this.clusterNetwork = null;
    }
    return (A) this;
  }
  
  public A withClusterNetwork(ClusterNetworkEntry... clusterNetwork) {
    if (this.clusterNetwork != null) {
        this.clusterNetwork.clear();
        _visitables.remove("clusterNetwork");
    }
    if (clusterNetwork != null) {
      for (ClusterNetworkEntry item : clusterNetwork) {
        this.addToClusterNetwork(item);
      }
    }
    return (A) this;
  }
  
  public A withClusterNetworkList(List<ClusterNetworkEntry> clusterNetworkList) {
    if (this.clusterNetworkList != null) {
      this._visitables.get("clusterNetworkList").clear();
    }
    if (clusterNetworkList != null) {
        this.clusterNetworkList = new ArrayList();
        for (ClusterNetworkEntry item : clusterNetworkList) {
          this.addToClusterNetworkList(item);
        }
    } else {
      this.clusterNetworkList = null;
    }
    return (A) this;
  }
  
  public A withClusterNetworkList(ClusterNetworkEntry... clusterNetworkList) {
    if (this.clusterNetworkList != null) {
        this.clusterNetworkList.clear();
        _visitables.remove("clusterNetworkList");
    }
    if (clusterNetworkList != null) {
      for (ClusterNetworkEntry item : clusterNetworkList) {
        this.addToClusterNetworkList(item);
      }
    }
    return (A) this;
  }
  
  public A withClusterNetworkMTU(Long clusterNetworkMTU) {
    this.clusterNetworkMTU = clusterNetworkMTU;
    return (A) this;
  }
  
  public A withMachineCIDR(String machineCIDR) {
    this.machineCIDR = machineCIDR;
    return (A) this;
  }
  
  public A withMachineNetwork(List<MachineNetworkEntry> machineNetwork) {
    if (this.machineNetwork != null) {
      this._visitables.get("machineNetwork").clear();
    }
    if (machineNetwork != null) {
        this.machineNetwork = new ArrayList();
        for (MachineNetworkEntry item : machineNetwork) {
          this.addToMachineNetwork(item);
        }
    } else {
      this.machineNetwork = null;
    }
    return (A) this;
  }
  
  public A withMachineNetwork(MachineNetworkEntry... machineNetwork) {
    if (this.machineNetwork != null) {
        this.machineNetwork.clear();
        _visitables.remove("machineNetwork");
    }
    if (machineNetwork != null) {
      for (MachineNetworkEntry item : machineNetwork) {
        this.addToMachineNetwork(item);
      }
    }
    return (A) this;
  }
  
  public A withNetworkType(String networkType) {
    this.networkType = networkType;
    return (A) this;
  }
  
  public OvnKubernetesConfigNested<A> withNewOvnKubernetesConfig() {
    return new OvnKubernetesConfigNested(null);
  }
  
  public OvnKubernetesConfigNested<A> withNewOvnKubernetesConfigLike(OVNKubernetesConfig item) {
    return new OvnKubernetesConfigNested(item);
  }
  
  public A withOvnKubernetesConfig(OVNKubernetesConfig ovnKubernetesConfig) {
    this._visitables.remove("ovnKubernetesConfig");
    if (ovnKubernetesConfig != null) {
        this.ovnKubernetesConfig = new OVNKubernetesConfigBuilder(ovnKubernetesConfig);
        this._visitables.get("ovnKubernetesConfig").add(this.ovnKubernetesConfig);
    } else {
        this.ovnKubernetesConfig = null;
        this._visitables.get("ovnKubernetesConfig").remove(this.ovnKubernetesConfig);
    }
    return (A) this;
  }
  
  public A withServiceCIDR(String serviceCIDR) {
    this.serviceCIDR = serviceCIDR;
    return (A) this;
  }
  
  public A withServiceNetwork(List<String> serviceNetwork) {
    if (serviceNetwork != null) {
        this.serviceNetwork = new ArrayList();
        for (String item : serviceNetwork) {
          this.addToServiceNetwork(item);
        }
    } else {
      this.serviceNetwork = null;
    }
    return (A) this;
  }
  
  public A withServiceNetwork(String... serviceNetwork) {
    if (this.serviceNetwork != null) {
        this.serviceNetwork.clear();
        _visitables.remove("serviceNetwork");
    }
    if (serviceNetwork != null) {
      for (String item : serviceNetwork) {
        this.addToServiceNetwork(item);
      }
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ClusterNetworkListNested<N> extends ClusterNetworkEntryFluent<ClusterNetworkListNested<N>> implements Nested<N>{
  
    ClusterNetworkEntryBuilder builder;
    int index;
  
    ClusterNetworkListNested(int index,ClusterNetworkEntry item) {
      this.index = index;
      this.builder = new ClusterNetworkEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkingFluent.this.setToClusterNetworkList(index, builder.build());
    }
    
    public N endClusterNetworkList() {
      return and();
    }
    
  }
  public class ClusterNetworkNested<N> extends ClusterNetworkEntryFluent<ClusterNetworkNested<N>> implements Nested<N>{
  
    ClusterNetworkEntryBuilder builder;
    int index;
  
    ClusterNetworkNested(int index,ClusterNetworkEntry item) {
      this.index = index;
      this.builder = new ClusterNetworkEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkingFluent.this.setToClusterNetwork(index, builder.build());
    }
    
    public N endClusterNetwork() {
      return and();
    }
    
  }
  public class MachineNetworkNested<N> extends MachineNetworkEntryFluent<MachineNetworkNested<N>> implements Nested<N>{
  
    MachineNetworkEntryBuilder builder;
    int index;
  
    MachineNetworkNested(int index,MachineNetworkEntry item) {
      this.index = index;
      this.builder = new MachineNetworkEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkingFluent.this.setToMachineNetwork(index, builder.build());
    }
    
    public N endMachineNetwork() {
      return and();
    }
    
  }
  public class OvnKubernetesConfigNested<N> extends OVNKubernetesConfigFluent<OvnKubernetesConfigNested<N>> implements Nested<N>{
  
    OVNKubernetesConfigBuilder builder;
  
    OvnKubernetesConfigNested(OVNKubernetesConfig item) {
      this.builder = new OVNKubernetesConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkingFluent.this.withOvnKubernetesConfig(builder.build());
    }
    
    public N endOvnKubernetesConfig() {
      return and();
    }
    
  }
}