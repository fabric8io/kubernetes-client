package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class ServiceEntryFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ServiceEntryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> addresses = new ArrayList<String>();
  private ArrayList<WorkloadEntryBuilder> endpoints = new ArrayList<WorkloadEntryBuilder>();
  private List<String> exportTo = new ArrayList<String>();
  private List<String> hosts = new ArrayList<String>();
  private ServiceEntryLocation location;
  private ArrayList<ServicePortBuilder> ports = new ArrayList<ServicePortBuilder>();
  private ServiceEntryResolution resolution;
  private List<String> subjectAltNames = new ArrayList<String>();
  private WorkloadSelectorBuilder workloadSelector;

  public ServiceEntryFluent() {
  }
  
  public ServiceEntryFluent(ServiceEntry instance) {
    this.copyInstance(instance);
  }

  public A addAllToAddresses(Collection<String> items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (String item : items) {
      this.addresses.add(item);
    }
    return (A) this;
  }
  
  public A addAllToEndpoints(Collection<WorkloadEntry> items) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList();
    }
    for (WorkloadEntry item : items) {
        WorkloadEntryBuilder builder = new WorkloadEntryBuilder(item);
        _visitables.get("endpoints").add(builder);
        this.endpoints.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToExportTo(Collection<String> items) {
    if (this.exportTo == null) {
      this.exportTo = new ArrayList();
    }
    for (String item : items) {
      this.exportTo.add(item);
    }
    return (A) this;
  }
  
  public A addAllToHosts(Collection<String> items) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    for (String item : items) {
      this.hosts.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPorts(Collection<ServicePort> items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (ServicePort item : items) {
        ServicePortBuilder builder = new ServicePortBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSubjectAltNames(Collection<String> items) {
    if (this.subjectAltNames == null) {
      this.subjectAltNames = new ArrayList();
    }
    for (String item : items) {
      this.subjectAltNames.add(item);
    }
    return (A) this;
  }
  
  public EndpointsNested<A> addNewEndpoint() {
    return new EndpointsNested(-1, null);
  }
  
  public EndpointsNested<A> addNewEndpointLike(WorkloadEntry item) {
    return new EndpointsNested(-1, item);
  }
  
  public PortsNested<A> addNewPort() {
    return new PortsNested(-1, null);
  }
  
  public A addNewPort(String name,Long number,String protocol,Long targetPort) {
    return (A) this.addToPorts(new ServicePort(name, number, protocol, targetPort));
  }
  
  public PortsNested<A> addNewPortLike(ServicePort item) {
    return new PortsNested(-1, item);
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
  
  public A addToAddresses(String... items) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    for (String item : items) {
      this.addresses.add(item);
    }
    return (A) this;
  }
  
  public A addToAddresses(int index,String item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    this.addresses.add(index, item);
    return (A) this;
  }
  
  public A addToEndpoints(WorkloadEntry... items) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList();
    }
    for (WorkloadEntry item : items) {
        WorkloadEntryBuilder builder = new WorkloadEntryBuilder(item);
        _visitables.get("endpoints").add(builder);
        this.endpoints.add(builder);
    }
    return (A) this;
  }
  
  public A addToEndpoints(int index,WorkloadEntry item) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList();
    }
    WorkloadEntryBuilder builder = new WorkloadEntryBuilder(item);
    if (index < 0 || index >= endpoints.size()) {
        _visitables.get("endpoints").add(builder);
        endpoints.add(builder);
    } else {
        _visitables.get("endpoints").add(builder);
        endpoints.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToExportTo(String... items) {
    if (this.exportTo == null) {
      this.exportTo = new ArrayList();
    }
    for (String item : items) {
      this.exportTo.add(item);
    }
    return (A) this;
  }
  
  public A addToExportTo(int index,String item) {
    if (this.exportTo == null) {
      this.exportTo = new ArrayList();
    }
    this.exportTo.add(index, item);
    return (A) this;
  }
  
  public A addToHosts(String... items) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    for (String item : items) {
      this.hosts.add(item);
    }
    return (A) this;
  }
  
  public A addToHosts(int index,String item) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    this.hosts.add(index, item);
    return (A) this;
  }
  
  public A addToPorts(ServicePort... items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (ServicePort item : items) {
        ServicePortBuilder builder = new ServicePortBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public A addToPorts(int index,ServicePort item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    ServicePortBuilder builder = new ServicePortBuilder(item);
    if (index < 0 || index >= ports.size()) {
        _visitables.get("ports").add(builder);
        ports.add(builder);
    } else {
        _visitables.get("ports").add(builder);
        ports.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSubjectAltNames(String... items) {
    if (this.subjectAltNames == null) {
      this.subjectAltNames = new ArrayList();
    }
    for (String item : items) {
      this.subjectAltNames.add(item);
    }
    return (A) this;
  }
  
  public A addToSubjectAltNames(int index,String item) {
    if (this.subjectAltNames == null) {
      this.subjectAltNames = new ArrayList();
    }
    this.subjectAltNames.add(index, item);
    return (A) this;
  }
  
  public WorkloadEntry buildEndpoint(int index) {
    return this.endpoints.get(index).build();
  }
  
  public List<WorkloadEntry> buildEndpoints() {
    return this.endpoints != null ? build(endpoints) : null;
  }
  
  public WorkloadEntry buildFirstEndpoint() {
    return this.endpoints.get(0).build();
  }
  
  public ServicePort buildFirstPort() {
    return this.ports.get(0).build();
  }
  
  public WorkloadEntry buildLastEndpoint() {
    return this.endpoints.get(endpoints.size() - 1).build();
  }
  
  public ServicePort buildLastPort() {
    return this.ports.get(ports.size() - 1).build();
  }
  
  public WorkloadEntry buildMatchingEndpoint(Predicate<WorkloadEntryBuilder> predicate) {
      for (WorkloadEntryBuilder item : endpoints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ServicePort buildMatchingPort(Predicate<ServicePortBuilder> predicate) {
      for (ServicePortBuilder item : ports) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ServicePort buildPort(int index) {
    return this.ports.get(index).build();
  }
  
  public List<ServicePort> buildPorts() {
    return this.ports != null ? build(ports) : null;
  }
  
  public WorkloadSelector buildWorkloadSelector() {
    return this.workloadSelector != null ? this.workloadSelector.build() : null;
  }
  
  protected void copyInstance(ServiceEntry instance) {
    instance = instance != null ? instance : new ServiceEntry();
    if (instance != null) {
        this.withAddresses(instance.getAddresses());
        this.withEndpoints(instance.getEndpoints());
        this.withExportTo(instance.getExportTo());
        this.withHosts(instance.getHosts());
        this.withLocation(instance.getLocation());
        this.withPorts(instance.getPorts());
        this.withResolution(instance.getResolution());
        this.withSubjectAltNames(instance.getSubjectAltNames());
        this.withWorkloadSelector(instance.getWorkloadSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EndpointsNested<A> editEndpoint(int index) {
    if (endpoints.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "endpoints"));
    }
    return this.setNewEndpointLike(index, this.buildEndpoint(index));
  }
  
  public EndpointsNested<A> editFirstEndpoint() {
    if (endpoints.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "endpoints"));
    }
    return this.setNewEndpointLike(0, this.buildEndpoint(0));
  }
  
  public PortsNested<A> editFirstPort() {
    if (ports.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(0, this.buildPort(0));
  }
  
  public EndpointsNested<A> editLastEndpoint() {
    int index = endpoints.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "endpoints"));
    }
    return this.setNewEndpointLike(index, this.buildEndpoint(index));
  }
  
  public PortsNested<A> editLastPort() {
    int index = ports.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public EndpointsNested<A> editMatchingEndpoint(Predicate<WorkloadEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < endpoints.size();i++) {
      if (predicate.test(endpoints.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "endpoints"));
    }
    return this.setNewEndpointLike(index, this.buildEndpoint(index));
  }
  
  public PortsNested<A> editMatchingPort(Predicate<ServicePortBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ports.size();i++) {
      if (predicate.test(ports.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public WorkloadSelectorNested<A> editOrNewWorkloadSelector() {
    return this.withNewWorkloadSelectorLike(Optional.ofNullable(this.buildWorkloadSelector()).orElse(new WorkloadSelectorBuilder().build()));
  }
  
  public WorkloadSelectorNested<A> editOrNewWorkloadSelectorLike(WorkloadSelector item) {
    return this.withNewWorkloadSelectorLike(Optional.ofNullable(this.buildWorkloadSelector()).orElse(item));
  }
  
  public PortsNested<A> editPort(int index) {
    if (ports.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public WorkloadSelectorNested<A> editWorkloadSelector() {
    return this.withNewWorkloadSelectorLike(Optional.ofNullable(this.buildWorkloadSelector()).orElse(null));
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
    ServiceEntryFluent that = (ServiceEntryFluent) o;
    if (!(Objects.equals(addresses, that.addresses))) {
      return false;
    }
    if (!(Objects.equals(endpoints, that.endpoints))) {
      return false;
    }
    if (!(Objects.equals(exportTo, that.exportTo))) {
      return false;
    }
    if (!(Objects.equals(hosts, that.hosts))) {
      return false;
    }
    if (!(Objects.equals(location, that.location))) {
      return false;
    }
    if (!(Objects.equals(ports, that.ports))) {
      return false;
    }
    if (!(Objects.equals(resolution, that.resolution))) {
      return false;
    }
    if (!(Objects.equals(subjectAltNames, that.subjectAltNames))) {
      return false;
    }
    if (!(Objects.equals(workloadSelector, that.workloadSelector))) {
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
  
  public String getAddress(int index) {
    return this.addresses.get(index);
  }
  
  public List<String> getAddresses() {
    return this.addresses;
  }
  
  public List<String> getExportTo() {
    return this.exportTo;
  }
  
  public String getExportTo(int index) {
    return this.exportTo.get(index);
  }
  
  public String getFirstAddress() {
    return this.addresses.get(0);
  }
  
  public String getFirstExportTo() {
    return this.exportTo.get(0);
  }
  
  public String getFirstHost() {
    return this.hosts.get(0);
  }
  
  public String getFirstSubjectAltName() {
    return this.subjectAltNames.get(0);
  }
  
  public String getHost(int index) {
    return this.hosts.get(index);
  }
  
  public List<String> getHosts() {
    return this.hosts;
  }
  
  public String getLastAddress() {
    return this.addresses.get(addresses.size() - 1);
  }
  
  public String getLastExportTo() {
    return this.exportTo.get(exportTo.size() - 1);
  }
  
  public String getLastHost() {
    return this.hosts.get(hosts.size() - 1);
  }
  
  public String getLastSubjectAltName() {
    return this.subjectAltNames.get(subjectAltNames.size() - 1);
  }
  
  public ServiceEntryLocation getLocation() {
    return this.location;
  }
  
  public String getMatchingAddress(Predicate<String> predicate) {
      for (String item : addresses) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingExportTo(Predicate<String> predicate) {
      for (String item : exportTo) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingHost(Predicate<String> predicate) {
      for (String item : hosts) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingSubjectAltName(Predicate<String> predicate) {
      for (String item : subjectAltNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public ServiceEntryResolution getResolution() {
    return this.resolution;
  }
  
  public String getSubjectAltName(int index) {
    return this.subjectAltNames.get(index);
  }
  
  public List<String> getSubjectAltNames() {
    return this.subjectAltNames;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddresses() {
    return this.addresses != null && !(this.addresses.isEmpty());
  }
  
  public boolean hasEndpoints() {
    return this.endpoints != null && !(this.endpoints.isEmpty());
  }
  
  public boolean hasExportTo() {
    return this.exportTo != null && !(this.exportTo.isEmpty());
  }
  
  public boolean hasHosts() {
    return this.hosts != null && !(this.hosts.isEmpty());
  }
  
  public boolean hasLocation() {
    return this.location != null;
  }
  
  public boolean hasMatchingAddress(Predicate<String> predicate) {
      for (String item : addresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEndpoint(Predicate<WorkloadEntryBuilder> predicate) {
      for (WorkloadEntryBuilder item : endpoints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingExportTo(Predicate<String> predicate) {
      for (String item : exportTo) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingHost(Predicate<String> predicate) {
      for (String item : hosts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPort(Predicate<ServicePortBuilder> predicate) {
      for (ServicePortBuilder item : ports) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSubjectAltName(Predicate<String> predicate) {
      for (String item : subjectAltNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPorts() {
    return this.ports != null && !(this.ports.isEmpty());
  }
  
  public boolean hasResolution() {
    return this.resolution != null;
  }
  
  public boolean hasSubjectAltNames() {
    return this.subjectAltNames != null && !(this.subjectAltNames.isEmpty());
  }
  
  public boolean hasWorkloadSelector() {
    return this.workloadSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(addresses, endpoints, exportTo, hosts, location, ports, resolution, subjectAltNames, workloadSelector, additionalProperties);
  }
  
  public A removeAllFromAddresses(Collection<String> items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (String item : items) {
      this.addresses.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromEndpoints(Collection<WorkloadEntry> items) {
    if (this.endpoints == null) {
      return (A) this;
    }
    for (WorkloadEntry item : items) {
        WorkloadEntryBuilder builder = new WorkloadEntryBuilder(item);
        _visitables.get("endpoints").remove(builder);
        this.endpoints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromExportTo(Collection<String> items) {
    if (this.exportTo == null) {
      return (A) this;
    }
    for (String item : items) {
      this.exportTo.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromHosts(Collection<String> items) {
    if (this.hosts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.hosts.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPorts(Collection<ServicePort> items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (ServicePort item : items) {
        ServicePortBuilder builder = new ServicePortBuilder(item);
        _visitables.get("ports").remove(builder);
        this.ports.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSubjectAltNames(Collection<String> items) {
    if (this.subjectAltNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.subjectAltNames.remove(item);
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
  
  public A removeFromAddresses(String... items) {
    if (this.addresses == null) {
      return (A) this;
    }
    for (String item : items) {
      this.addresses.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromEndpoints(WorkloadEntry... items) {
    if (this.endpoints == null) {
      return (A) this;
    }
    for (WorkloadEntry item : items) {
        WorkloadEntryBuilder builder = new WorkloadEntryBuilder(item);
        _visitables.get("endpoints").remove(builder);
        this.endpoints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromExportTo(String... items) {
    if (this.exportTo == null) {
      return (A) this;
    }
    for (String item : items) {
      this.exportTo.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromHosts(String... items) {
    if (this.hosts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.hosts.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPorts(ServicePort... items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (ServicePort item : items) {
        ServicePortBuilder builder = new ServicePortBuilder(item);
        _visitables.get("ports").remove(builder);
        this.ports.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSubjectAltNames(String... items) {
    if (this.subjectAltNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.subjectAltNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEndpoints(Predicate<WorkloadEntryBuilder> predicate) {
    if (endpoints == null) {
      return (A) this;
    }
    Iterator<WorkloadEntryBuilder> each = endpoints.iterator();
    List visitables = _visitables.get("endpoints");
    while (each.hasNext()) {
        WorkloadEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPorts(Predicate<ServicePortBuilder> predicate) {
    if (ports == null) {
      return (A) this;
    }
    Iterator<ServicePortBuilder> each = ports.iterator();
    List visitables = _visitables.get("ports");
    while (each.hasNext()) {
        ServicePortBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EndpointsNested<A> setNewEndpointLike(int index,WorkloadEntry item) {
    return new EndpointsNested(index, item);
  }
  
  public PortsNested<A> setNewPortLike(int index,ServicePort item) {
    return new PortsNested(index, item);
  }
  
  public A setToAddresses(int index,String item) {
    if (this.addresses == null) {
      this.addresses = new ArrayList();
    }
    this.addresses.set(index, item);
    return (A) this;
  }
  
  public A setToEndpoints(int index,WorkloadEntry item) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList();
    }
    WorkloadEntryBuilder builder = new WorkloadEntryBuilder(item);
    if (index < 0 || index >= endpoints.size()) {
        _visitables.get("endpoints").add(builder);
        endpoints.add(builder);
    } else {
        _visitables.get("endpoints").add(builder);
        endpoints.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToExportTo(int index,String item) {
    if (this.exportTo == null) {
      this.exportTo = new ArrayList();
    }
    this.exportTo.set(index, item);
    return (A) this;
  }
  
  public A setToHosts(int index,String item) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    this.hosts.set(index, item);
    return (A) this;
  }
  
  public A setToPorts(int index,ServicePort item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    ServicePortBuilder builder = new ServicePortBuilder(item);
    if (index < 0 || index >= ports.size()) {
        _visitables.get("ports").add(builder);
        ports.add(builder);
    } else {
        _visitables.get("ports").add(builder);
        ports.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSubjectAltNames(int index,String item) {
    if (this.subjectAltNames == null) {
      this.subjectAltNames = new ArrayList();
    }
    this.subjectAltNames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(addresses == null) && !(addresses.isEmpty())) {
        sb.append("addresses:");
        sb.append(addresses);
        sb.append(",");
    }
    if (!(endpoints == null) && !(endpoints.isEmpty())) {
        sb.append("endpoints:");
        sb.append(endpoints);
        sb.append(",");
    }
    if (!(exportTo == null) && !(exportTo.isEmpty())) {
        sb.append("exportTo:");
        sb.append(exportTo);
        sb.append(",");
    }
    if (!(hosts == null) && !(hosts.isEmpty())) {
        sb.append("hosts:");
        sb.append(hosts);
        sb.append(",");
    }
    if (!(location == null)) {
        sb.append("location:");
        sb.append(location);
        sb.append(",");
    }
    if (!(ports == null) && !(ports.isEmpty())) {
        sb.append("ports:");
        sb.append(ports);
        sb.append(",");
    }
    if (!(resolution == null)) {
        sb.append("resolution:");
        sb.append(resolution);
        sb.append(",");
    }
    if (!(subjectAltNames == null) && !(subjectAltNames.isEmpty())) {
        sb.append("subjectAltNames:");
        sb.append(subjectAltNames);
        sb.append(",");
    }
    if (!(workloadSelector == null)) {
        sb.append("workloadSelector:");
        sb.append(workloadSelector);
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
  
  public A withAddresses(List<String> addresses) {
    if (addresses != null) {
        this.addresses = new ArrayList();
        for (String item : addresses) {
          this.addToAddresses(item);
        }
    } else {
      this.addresses = null;
    }
    return (A) this;
  }
  
  public A withAddresses(String... addresses) {
    if (this.addresses != null) {
        this.addresses.clear();
        _visitables.remove("addresses");
    }
    if (addresses != null) {
      for (String item : addresses) {
        this.addToAddresses(item);
      }
    }
    return (A) this;
  }
  
  public A withEndpoints(List<WorkloadEntry> endpoints) {
    if (this.endpoints != null) {
      this._visitables.get("endpoints").clear();
    }
    if (endpoints != null) {
        this.endpoints = new ArrayList();
        for (WorkloadEntry item : endpoints) {
          this.addToEndpoints(item);
        }
    } else {
      this.endpoints = null;
    }
    return (A) this;
  }
  
  public A withEndpoints(WorkloadEntry... endpoints) {
    if (this.endpoints != null) {
        this.endpoints.clear();
        _visitables.remove("endpoints");
    }
    if (endpoints != null) {
      for (WorkloadEntry item : endpoints) {
        this.addToEndpoints(item);
      }
    }
    return (A) this;
  }
  
  public A withExportTo(List<String> exportTo) {
    if (exportTo != null) {
        this.exportTo = new ArrayList();
        for (String item : exportTo) {
          this.addToExportTo(item);
        }
    } else {
      this.exportTo = null;
    }
    return (A) this;
  }
  
  public A withExportTo(String... exportTo) {
    if (this.exportTo != null) {
        this.exportTo.clear();
        _visitables.remove("exportTo");
    }
    if (exportTo != null) {
      for (String item : exportTo) {
        this.addToExportTo(item);
      }
    }
    return (A) this;
  }
  
  public A withHosts(List<String> hosts) {
    if (hosts != null) {
        this.hosts = new ArrayList();
        for (String item : hosts) {
          this.addToHosts(item);
        }
    } else {
      this.hosts = null;
    }
    return (A) this;
  }
  
  public A withHosts(String... hosts) {
    if (this.hosts != null) {
        this.hosts.clear();
        _visitables.remove("hosts");
    }
    if (hosts != null) {
      for (String item : hosts) {
        this.addToHosts(item);
      }
    }
    return (A) this;
  }
  
  public A withLocation(ServiceEntryLocation location) {
    this.location = location;
    return (A) this;
  }
  
  public WorkloadSelectorNested<A> withNewWorkloadSelector() {
    return new WorkloadSelectorNested(null);
  }
  
  public WorkloadSelectorNested<A> withNewWorkloadSelectorLike(WorkloadSelector item) {
    return new WorkloadSelectorNested(item);
  }
  
  public A withPorts(List<ServicePort> ports) {
    if (this.ports != null) {
      this._visitables.get("ports").clear();
    }
    if (ports != null) {
        this.ports = new ArrayList();
        for (ServicePort item : ports) {
          this.addToPorts(item);
        }
    } else {
      this.ports = null;
    }
    return (A) this;
  }
  
  public A withPorts(ServicePort... ports) {
    if (this.ports != null) {
        this.ports.clear();
        _visitables.remove("ports");
    }
    if (ports != null) {
      for (ServicePort item : ports) {
        this.addToPorts(item);
      }
    }
    return (A) this;
  }
  
  public A withResolution(ServiceEntryResolution resolution) {
    this.resolution = resolution;
    return (A) this;
  }
  
  public A withSubjectAltNames(List<String> subjectAltNames) {
    if (subjectAltNames != null) {
        this.subjectAltNames = new ArrayList();
        for (String item : subjectAltNames) {
          this.addToSubjectAltNames(item);
        }
    } else {
      this.subjectAltNames = null;
    }
    return (A) this;
  }
  
  public A withSubjectAltNames(String... subjectAltNames) {
    if (this.subjectAltNames != null) {
        this.subjectAltNames.clear();
        _visitables.remove("subjectAltNames");
    }
    if (subjectAltNames != null) {
      for (String item : subjectAltNames) {
        this.addToSubjectAltNames(item);
      }
    }
    return (A) this;
  }
  
  public A withWorkloadSelector(WorkloadSelector workloadSelector) {
    this._visitables.remove("workloadSelector");
    if (workloadSelector != null) {
        this.workloadSelector = new WorkloadSelectorBuilder(workloadSelector);
        this._visitables.get("workloadSelector").add(this.workloadSelector);
    } else {
        this.workloadSelector = null;
        this._visitables.get("workloadSelector").remove(this.workloadSelector);
    }
    return (A) this;
  }
  public class EndpointsNested<N> extends WorkloadEntryFluent<EndpointsNested<N>> implements Nested<N>{
  
    WorkloadEntryBuilder builder;
    int index;
  
    EndpointsNested(int index,WorkloadEntry item) {
      this.index = index;
      this.builder = new WorkloadEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) ServiceEntryFluent.this.setToEndpoints(index, builder.build());
    }
    
    public N endEndpoint() {
      return and();
    }
    
  }
  public class PortsNested<N> extends ServicePortFluent<PortsNested<N>> implements Nested<N>{
  
    ServicePortBuilder builder;
    int index;
  
    PortsNested(int index,ServicePort item) {
      this.index = index;
      this.builder = new ServicePortBuilder(this, item);
    }
  
    public N and() {
      return (N) ServiceEntryFluent.this.setToPorts(index, builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
  public class WorkloadSelectorNested<N> extends WorkloadSelectorFluent<WorkloadSelectorNested<N>> implements Nested<N>{
  
    WorkloadSelectorBuilder builder;
  
    WorkloadSelectorNested(WorkloadSelector item) {
      this.builder = new WorkloadSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ServiceEntryFluent.this.withWorkloadSelector(builder.build());
    }
    
    public N endWorkloadSelector() {
      return and();
    }
    
  }
}