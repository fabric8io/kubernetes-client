package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NetworkStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.NetworkStatusFluent<A>> extends BaseFluent<A>{

  private Boolean _default;
  private String _interface;
  private Map<String,Object> additionalProperties;
  private DeviceInfoBuilder deviceInfo;
  private DNSBuilder dns;
  private List<String> gateway = new ArrayList<String>();
  private List<String> ips = new ArrayList<String>();
  private String mac;
  private Integer mtu;
  private String name;

  public NetworkStatusFluent() {
  }
  
  public NetworkStatusFluent(NetworkStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToGateway(Collection<String> items) {
    if (this.gateway == null) {
      this.gateway = new ArrayList();
    }
    for (String item : items) {
      this.gateway.add(item);
    }
    return (A) this;
  }
  
  public A addAllToIps(Collection<String> items) {
    if (this.ips == null) {
      this.ips = new ArrayList();
    }
    for (String item : items) {
      this.ips.add(item);
    }
    return (A) this;
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
  
  public A addToGateway(String... items) {
    if (this.gateway == null) {
      this.gateway = new ArrayList();
    }
    for (String item : items) {
      this.gateway.add(item);
    }
    return (A) this;
  }
  
  public A addToGateway(int index,String item) {
    if (this.gateway == null) {
      this.gateway = new ArrayList();
    }
    this.gateway.add(index, item);
    return (A) this;
  }
  
  public A addToIps(String... items) {
    if (this.ips == null) {
      this.ips = new ArrayList();
    }
    for (String item : items) {
      this.ips.add(item);
    }
    return (A) this;
  }
  
  public A addToIps(int index,String item) {
    if (this.ips == null) {
      this.ips = new ArrayList();
    }
    this.ips.add(index, item);
    return (A) this;
  }
  
  public DeviceInfo buildDeviceInfo() {
    return this.deviceInfo != null ? this.deviceInfo.build() : null;
  }
  
  public DNS buildDns() {
    return this.dns != null ? this.dns.build() : null;
  }
  
  protected void copyInstance(NetworkStatus instance) {
    instance = instance != null ? instance : new NetworkStatus();
    if (instance != null) {
        this.withDefault(instance.getDefault());
        this.withDeviceInfo(instance.getDeviceInfo());
        this.withDns(instance.getDns());
        this.withGateway(instance.getGateway());
        this.withInterface(instance.getInterface());
        this.withIps(instance.getIps());
        this.withMac(instance.getMac());
        this.withMtu(instance.getMtu());
        this.withName(instance.getName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DeviceInfoNested<A> editDeviceInfo() {
    return this.withNewDeviceInfoLike(Optional.ofNullable(this.buildDeviceInfo()).orElse(null));
  }
  
  public DnsNested<A> editDns() {
    return this.withNewDnsLike(Optional.ofNullable(this.buildDns()).orElse(null));
  }
  
  public DeviceInfoNested<A> editOrNewDeviceInfo() {
    return this.withNewDeviceInfoLike(Optional.ofNullable(this.buildDeviceInfo()).orElse(new DeviceInfoBuilder().build()));
  }
  
  public DeviceInfoNested<A> editOrNewDeviceInfoLike(DeviceInfo item) {
    return this.withNewDeviceInfoLike(Optional.ofNullable(this.buildDeviceInfo()).orElse(item));
  }
  
  public DnsNested<A> editOrNewDns() {
    return this.withNewDnsLike(Optional.ofNullable(this.buildDns()).orElse(new DNSBuilder().build()));
  }
  
  public DnsNested<A> editOrNewDnsLike(DNS item) {
    return this.withNewDnsLike(Optional.ofNullable(this.buildDns()).orElse(item));
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
    NetworkStatusFluent that = (NetworkStatusFluent) o;
    if (!(Objects.equals(_default, that._default))) {
      return false;
    }
    if (!(Objects.equals(deviceInfo, that.deviceInfo))) {
      return false;
    }
    if (!(Objects.equals(dns, that.dns))) {
      return false;
    }
    if (!(Objects.equals(gateway, that.gateway))) {
      return false;
    }
    if (!(Objects.equals(_interface, that._interface))) {
      return false;
    }
    if (!(Objects.equals(ips, that.ips))) {
      return false;
    }
    if (!(Objects.equals(mac, that.mac))) {
      return false;
    }
    if (!(Objects.equals(mtu, that.mtu))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public Boolean getDefault() {
    return this._default;
  }
  
  public String getFirstGateway() {
    return this.gateway.get(0);
  }
  
  public String getFirstIp() {
    return this.ips.get(0);
  }
  
  public List<String> getGateway() {
    return this.gateway;
  }
  
  public String getGateway(int index) {
    return this.gateway.get(index);
  }
  
  public String getInterface() {
    return this._interface;
  }
  
  public String getIp(int index) {
    return this.ips.get(index);
  }
  
  public List<String> getIps() {
    return this.ips;
  }
  
  public String getLastGateway() {
    return this.gateway.get(gateway.size() - 1);
  }
  
  public String getLastIp() {
    return this.ips.get(ips.size() - 1);
  }
  
  public String getMac() {
    return this.mac;
  }
  
  public String getMatchingGateway(Predicate<String> predicate) {
      for (String item : gateway) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingIp(Predicate<String> predicate) {
      for (String item : ips) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMtu() {
    return this.mtu;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDefault() {
    return this._default != null;
  }
  
  public boolean hasDeviceInfo() {
    return this.deviceInfo != null;
  }
  
  public boolean hasDns() {
    return this.dns != null;
  }
  
  public boolean hasGateway() {
    return this.gateway != null && !(this.gateway.isEmpty());
  }
  
  public boolean hasInterface() {
    return this._interface != null;
  }
  
  public boolean hasIps() {
    return this.ips != null && !(this.ips.isEmpty());
  }
  
  public boolean hasMac() {
    return this.mac != null;
  }
  
  public boolean hasMatchingGateway(Predicate<String> predicate) {
      for (String item : gateway) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIp(Predicate<String> predicate) {
      for (String item : ips) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMtu() {
    return this.mtu != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(_default, deviceInfo, dns, gateway, _interface, ips, mac, mtu, name, additionalProperties);
  }
  
  public A removeAllFromGateway(Collection<String> items) {
    if (this.gateway == null) {
      return (A) this;
    }
    for (String item : items) {
      this.gateway.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromIps(Collection<String> items) {
    if (this.ips == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ips.remove(item);
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
  
  public A removeFromGateway(String... items) {
    if (this.gateway == null) {
      return (A) this;
    }
    for (String item : items) {
      this.gateway.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromIps(String... items) {
    if (this.ips == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ips.remove(item);
    }
    return (A) this;
  }
  
  public A setToGateway(int index,String item) {
    if (this.gateway == null) {
      this.gateway = new ArrayList();
    }
    this.gateway.set(index, item);
    return (A) this;
  }
  
  public A setToIps(int index,String item) {
    if (this.ips == null) {
      this.ips = new ArrayList();
    }
    this.ips.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(_default == null)) {
        sb.append("_default:");
        sb.append(_default);
        sb.append(",");
    }
    if (!(deviceInfo == null)) {
        sb.append("deviceInfo:");
        sb.append(deviceInfo);
        sb.append(",");
    }
    if (!(dns == null)) {
        sb.append("dns:");
        sb.append(dns);
        sb.append(",");
    }
    if (!(gateway == null) && !(gateway.isEmpty())) {
        sb.append("gateway:");
        sb.append(gateway);
        sb.append(",");
    }
    if (!(_interface == null)) {
        sb.append("_interface:");
        sb.append(_interface);
        sb.append(",");
    }
    if (!(ips == null) && !(ips.isEmpty())) {
        sb.append("ips:");
        sb.append(ips);
        sb.append(",");
    }
    if (!(mac == null)) {
        sb.append("mac:");
        sb.append(mac);
        sb.append(",");
    }
    if (!(mtu == null)) {
        sb.append("mtu:");
        sb.append(mtu);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withDefault() {
    return withDefault(true);
  }
  
  public A withDefault(Boolean _default) {
    this._default = _default;
    return (A) this;
  }
  
  public A withDeviceInfo(DeviceInfo deviceInfo) {
    this._visitables.remove("deviceInfo");
    if (deviceInfo != null) {
        this.deviceInfo = new DeviceInfoBuilder(deviceInfo);
        this._visitables.get("deviceInfo").add(this.deviceInfo);
    } else {
        this.deviceInfo = null;
        this._visitables.get("deviceInfo").remove(this.deviceInfo);
    }
    return (A) this;
  }
  
  public A withDns(DNS dns) {
    this._visitables.remove("dns");
    if (dns != null) {
        this.dns = new DNSBuilder(dns);
        this._visitables.get("dns").add(this.dns);
    } else {
        this.dns = null;
        this._visitables.get("dns").remove(this.dns);
    }
    return (A) this;
  }
  
  public A withGateway(List<String> gateway) {
    if (gateway != null) {
        this.gateway = new ArrayList();
        for (String item : gateway) {
          this.addToGateway(item);
        }
    } else {
      this.gateway = null;
    }
    return (A) this;
  }
  
  public A withGateway(String... gateway) {
    if (this.gateway != null) {
        this.gateway.clear();
        _visitables.remove("gateway");
    }
    if (gateway != null) {
      for (String item : gateway) {
        this.addToGateway(item);
      }
    }
    return (A) this;
  }
  
  public A withInterface(String _interface) {
    this._interface = _interface;
    return (A) this;
  }
  
  public A withIps(List<String> ips) {
    if (ips != null) {
        this.ips = new ArrayList();
        for (String item : ips) {
          this.addToIps(item);
        }
    } else {
      this.ips = null;
    }
    return (A) this;
  }
  
  public A withIps(String... ips) {
    if (this.ips != null) {
        this.ips.clear();
        _visitables.remove("ips");
    }
    if (ips != null) {
      for (String item : ips) {
        this.addToIps(item);
      }
    }
    return (A) this;
  }
  
  public A withMac(String mac) {
    this.mac = mac;
    return (A) this;
  }
  
  public A withMtu(Integer mtu) {
    this.mtu = mtu;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public DeviceInfoNested<A> withNewDeviceInfo() {
    return new DeviceInfoNested(null);
  }
  
  public DeviceInfoNested<A> withNewDeviceInfoLike(DeviceInfo item) {
    return new DeviceInfoNested(item);
  }
  
  public DnsNested<A> withNewDns() {
    return new DnsNested(null);
  }
  
  public DnsNested<A> withNewDnsLike(DNS item) {
    return new DnsNested(item);
  }
  public class DeviceInfoNested<N> extends DeviceInfoFluent<DeviceInfoNested<N>> implements Nested<N>{
  
    DeviceInfoBuilder builder;
  
    DeviceInfoNested(DeviceInfo item) {
      this.builder = new DeviceInfoBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkStatusFluent.this.withDeviceInfo(builder.build());
    }
    
    public N endDeviceInfo() {
      return and();
    }
    
  }
  public class DnsNested<N> extends DNSFluent<DnsNested<N>> implements Nested<N>{
  
    DNSBuilder builder;
  
    DnsNested(DNS item) {
      this.builder = new DNSBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkStatusFluent.this.withDns(builder.build());
    }
    
    public N endDns() {
      return and();
    }
    
  }
}