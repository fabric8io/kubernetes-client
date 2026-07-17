package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NetworkDataNetworkFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.NetworkDataNetworkFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NetworkDataIPv4Builder> ipv4 = new ArrayList<NetworkDataIPv4Builder>();
  private ArrayList<NetworkDataIPv4DHCPBuilder> ipv4DHCP = new ArrayList<NetworkDataIPv4DHCPBuilder>();
  private ArrayList<NetworkDataIPv6Builder> ipv6 = new ArrayList<NetworkDataIPv6Builder>();
  private ArrayList<NetworkDataIPv6DHCPBuilder> ipv6DHCP = new ArrayList<NetworkDataIPv6DHCPBuilder>();
  private ArrayList<NetworkDataIPv6DHCPBuilder> ipv6SLAAC = new ArrayList<NetworkDataIPv6DHCPBuilder>();

  public NetworkDataNetworkFluent() {
  }
  
  public NetworkDataNetworkFluent(NetworkDataNetwork instance) {
    this.copyInstance(instance);
  }

  public A addAllToIpv4(Collection<NetworkDataIPv4> items) {
    if (this.ipv4 == null) {
      this.ipv4 = new ArrayList();
    }
    for (NetworkDataIPv4 item : items) {
        NetworkDataIPv4Builder builder = new NetworkDataIPv4Builder(item);
        _visitables.get("ipv4").add(builder);
        this.ipv4.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToIpv4DHCP(Collection<NetworkDataIPv4DHCP> items) {
    if (this.ipv4DHCP == null) {
      this.ipv4DHCP = new ArrayList();
    }
    for (NetworkDataIPv4DHCP item : items) {
        NetworkDataIPv4DHCPBuilder builder = new NetworkDataIPv4DHCPBuilder(item);
        _visitables.get("ipv4DHCP").add(builder);
        this.ipv4DHCP.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToIpv6(Collection<NetworkDataIPv6> items) {
    if (this.ipv6 == null) {
      this.ipv6 = new ArrayList();
    }
    for (NetworkDataIPv6 item : items) {
        NetworkDataIPv6Builder builder = new NetworkDataIPv6Builder(item);
        _visitables.get("ipv6").add(builder);
        this.ipv6.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToIpv6DHCP(Collection<NetworkDataIPv6DHCP> items) {
    if (this.ipv6DHCP == null) {
      this.ipv6DHCP = new ArrayList();
    }
    for (NetworkDataIPv6DHCP item : items) {
        NetworkDataIPv6DHCPBuilder builder = new NetworkDataIPv6DHCPBuilder(item);
        _visitables.get("ipv6DHCP").add(builder);
        this.ipv6DHCP.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToIpv6SLAAC(Collection<NetworkDataIPv6DHCP> items) {
    if (this.ipv6SLAAC == null) {
      this.ipv6SLAAC = new ArrayList();
    }
    for (NetworkDataIPv6DHCP item : items) {
        NetworkDataIPv6DHCPBuilder builder = new NetworkDataIPv6DHCPBuilder(item);
        _visitables.get("ipv6SLAAC").add(builder);
        this.ipv6SLAAC.add(builder);
    }
    return (A) this;
  }
  
  public Ipv4Nested<A> addNewIpv4() {
    return new Ipv4Nested(-1, null);
  }
  
  public Ipv4DHCPNested<A> addNewIpv4DHCP() {
    return new Ipv4DHCPNested(-1, null);
  }
  
  public Ipv4DHCPNested<A> addNewIpv4DHCPLike(NetworkDataIPv4DHCP item) {
    return new Ipv4DHCPNested(-1, item);
  }
  
  public Ipv4Nested<A> addNewIpv4Like(NetworkDataIPv4 item) {
    return new Ipv4Nested(-1, item);
  }
  
  public Ipv6Nested<A> addNewIpv6() {
    return new Ipv6Nested(-1, null);
  }
  
  public Ipv6DHCPNested<A> addNewIpv6DHCP() {
    return new Ipv6DHCPNested(-1, null);
  }
  
  public Ipv6DHCPNested<A> addNewIpv6DHCPLike(NetworkDataIPv6DHCP item) {
    return new Ipv6DHCPNested(-1, item);
  }
  
  public Ipv6Nested<A> addNewIpv6Like(NetworkDataIPv6 item) {
    return new Ipv6Nested(-1, item);
  }
  
  public Ipv6SLAACNested<A> addNewIpv6SLAAC() {
    return new Ipv6SLAACNested(-1, null);
  }
  
  public Ipv6SLAACNested<A> addNewIpv6SLAACLike(NetworkDataIPv6DHCP item) {
    return new Ipv6SLAACNested(-1, item);
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
  
  public A addToIpv4(NetworkDataIPv4... items) {
    if (this.ipv4 == null) {
      this.ipv4 = new ArrayList();
    }
    for (NetworkDataIPv4 item : items) {
        NetworkDataIPv4Builder builder = new NetworkDataIPv4Builder(item);
        _visitables.get("ipv4").add(builder);
        this.ipv4.add(builder);
    }
    return (A) this;
  }
  
  public A addToIpv4(int index,NetworkDataIPv4 item) {
    if (this.ipv4 == null) {
      this.ipv4 = new ArrayList();
    }
    NetworkDataIPv4Builder builder = new NetworkDataIPv4Builder(item);
    if (index < 0 || index >= ipv4.size()) {
        _visitables.get("ipv4").add(builder);
        ipv4.add(builder);
    } else {
        _visitables.get("ipv4").add(builder);
        ipv4.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToIpv4DHCP(NetworkDataIPv4DHCP... items) {
    if (this.ipv4DHCP == null) {
      this.ipv4DHCP = new ArrayList();
    }
    for (NetworkDataIPv4DHCP item : items) {
        NetworkDataIPv4DHCPBuilder builder = new NetworkDataIPv4DHCPBuilder(item);
        _visitables.get("ipv4DHCP").add(builder);
        this.ipv4DHCP.add(builder);
    }
    return (A) this;
  }
  
  public A addToIpv4DHCP(int index,NetworkDataIPv4DHCP item) {
    if (this.ipv4DHCP == null) {
      this.ipv4DHCP = new ArrayList();
    }
    NetworkDataIPv4DHCPBuilder builder = new NetworkDataIPv4DHCPBuilder(item);
    if (index < 0 || index >= ipv4DHCP.size()) {
        _visitables.get("ipv4DHCP").add(builder);
        ipv4DHCP.add(builder);
    } else {
        _visitables.get("ipv4DHCP").add(builder);
        ipv4DHCP.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToIpv6(NetworkDataIPv6... items) {
    if (this.ipv6 == null) {
      this.ipv6 = new ArrayList();
    }
    for (NetworkDataIPv6 item : items) {
        NetworkDataIPv6Builder builder = new NetworkDataIPv6Builder(item);
        _visitables.get("ipv6").add(builder);
        this.ipv6.add(builder);
    }
    return (A) this;
  }
  
  public A addToIpv6(int index,NetworkDataIPv6 item) {
    if (this.ipv6 == null) {
      this.ipv6 = new ArrayList();
    }
    NetworkDataIPv6Builder builder = new NetworkDataIPv6Builder(item);
    if (index < 0 || index >= ipv6.size()) {
        _visitables.get("ipv6").add(builder);
        ipv6.add(builder);
    } else {
        _visitables.get("ipv6").add(builder);
        ipv6.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToIpv6DHCP(NetworkDataIPv6DHCP... items) {
    if (this.ipv6DHCP == null) {
      this.ipv6DHCP = new ArrayList();
    }
    for (NetworkDataIPv6DHCP item : items) {
        NetworkDataIPv6DHCPBuilder builder = new NetworkDataIPv6DHCPBuilder(item);
        _visitables.get("ipv6DHCP").add(builder);
        this.ipv6DHCP.add(builder);
    }
    return (A) this;
  }
  
  public A addToIpv6DHCP(int index,NetworkDataIPv6DHCP item) {
    if (this.ipv6DHCP == null) {
      this.ipv6DHCP = new ArrayList();
    }
    NetworkDataIPv6DHCPBuilder builder = new NetworkDataIPv6DHCPBuilder(item);
    if (index < 0 || index >= ipv6DHCP.size()) {
        _visitables.get("ipv6DHCP").add(builder);
        ipv6DHCP.add(builder);
    } else {
        _visitables.get("ipv6DHCP").add(builder);
        ipv6DHCP.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToIpv6SLAAC(NetworkDataIPv6DHCP... items) {
    if (this.ipv6SLAAC == null) {
      this.ipv6SLAAC = new ArrayList();
    }
    for (NetworkDataIPv6DHCP item : items) {
        NetworkDataIPv6DHCPBuilder builder = new NetworkDataIPv6DHCPBuilder(item);
        _visitables.get("ipv6SLAAC").add(builder);
        this.ipv6SLAAC.add(builder);
    }
    return (A) this;
  }
  
  public A addToIpv6SLAAC(int index,NetworkDataIPv6DHCP item) {
    if (this.ipv6SLAAC == null) {
      this.ipv6SLAAC = new ArrayList();
    }
    NetworkDataIPv6DHCPBuilder builder = new NetworkDataIPv6DHCPBuilder(item);
    if (index < 0 || index >= ipv6SLAAC.size()) {
        _visitables.get("ipv6SLAAC").add(builder);
        ipv6SLAAC.add(builder);
    } else {
        _visitables.get("ipv6SLAAC").add(builder);
        ipv6SLAAC.add(index, builder);
    }
    return (A) this;
  }
  
  public NetworkDataIPv4 buildFirstIpv4() {
    return this.ipv4.get(0).build();
  }
  
  public NetworkDataIPv4DHCP buildFirstIpv4DHCP() {
    return this.ipv4DHCP.get(0).build();
  }
  
  public NetworkDataIPv6 buildFirstIpv6() {
    return this.ipv6.get(0).build();
  }
  
  public NetworkDataIPv6DHCP buildFirstIpv6DHCP() {
    return this.ipv6DHCP.get(0).build();
  }
  
  public NetworkDataIPv6DHCP buildFirstIpv6SLAAC() {
    return this.ipv6SLAAC.get(0).build();
  }
  
  public List<NetworkDataIPv4> buildIpv4() {
    return this.ipv4 != null ? build(ipv4) : null;
  }
  
  public NetworkDataIPv4 buildIpv4(int index) {
    return this.ipv4.get(index).build();
  }
  
  public List<NetworkDataIPv4DHCP> buildIpv4DHCP() {
    return this.ipv4DHCP != null ? build(ipv4DHCP) : null;
  }
  
  public NetworkDataIPv4DHCP buildIpv4DHCP(int index) {
    return this.ipv4DHCP.get(index).build();
  }
  
  public List<NetworkDataIPv6> buildIpv6() {
    return this.ipv6 != null ? build(ipv6) : null;
  }
  
  public NetworkDataIPv6 buildIpv6(int index) {
    return this.ipv6.get(index).build();
  }
  
  public List<NetworkDataIPv6DHCP> buildIpv6DHCP() {
    return this.ipv6DHCP != null ? build(ipv6DHCP) : null;
  }
  
  public NetworkDataIPv6DHCP buildIpv6DHCP(int index) {
    return this.ipv6DHCP.get(index).build();
  }
  
  public List<NetworkDataIPv6DHCP> buildIpv6SLAAC() {
    return this.ipv6SLAAC != null ? build(ipv6SLAAC) : null;
  }
  
  public NetworkDataIPv6DHCP buildIpv6SLAAC(int index) {
    return this.ipv6SLAAC.get(index).build();
  }
  
  public NetworkDataIPv4 buildLastIpv4() {
    return this.ipv4.get(ipv4.size() - 1).build();
  }
  
  public NetworkDataIPv4DHCP buildLastIpv4DHCP() {
    return this.ipv4DHCP.get(ipv4DHCP.size() - 1).build();
  }
  
  public NetworkDataIPv6 buildLastIpv6() {
    return this.ipv6.get(ipv6.size() - 1).build();
  }
  
  public NetworkDataIPv6DHCP buildLastIpv6DHCP() {
    return this.ipv6DHCP.get(ipv6DHCP.size() - 1).build();
  }
  
  public NetworkDataIPv6DHCP buildLastIpv6SLAAC() {
    return this.ipv6SLAAC.get(ipv6SLAAC.size() - 1).build();
  }
  
  public NetworkDataIPv4 buildMatchingIpv4(Predicate<NetworkDataIPv4Builder> predicate) {
      for (NetworkDataIPv4Builder item : ipv4) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkDataIPv4DHCP buildMatchingIpv4DHCP(Predicate<NetworkDataIPv4DHCPBuilder> predicate) {
      for (NetworkDataIPv4DHCPBuilder item : ipv4DHCP) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkDataIPv6 buildMatchingIpv6(Predicate<NetworkDataIPv6Builder> predicate) {
      for (NetworkDataIPv6Builder item : ipv6) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkDataIPv6DHCP buildMatchingIpv6DHCP(Predicate<NetworkDataIPv6DHCPBuilder> predicate) {
      for (NetworkDataIPv6DHCPBuilder item : ipv6DHCP) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkDataIPv6DHCP buildMatchingIpv6SLAAC(Predicate<NetworkDataIPv6DHCPBuilder> predicate) {
      for (NetworkDataIPv6DHCPBuilder item : ipv6SLAAC) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(NetworkDataNetwork instance) {
    instance = instance != null ? instance : new NetworkDataNetwork();
    if (instance != null) {
        this.withIpv4(instance.getIpv4());
        this.withIpv4DHCP(instance.getIpv4DHCP());
        this.withIpv6(instance.getIpv6());
        this.withIpv6DHCP(instance.getIpv6DHCP());
        this.withIpv6SLAAC(instance.getIpv6SLAAC());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public Ipv4Nested<A> editFirstIpv4() {
    if (ipv4.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ipv4"));
    }
    return this.setNewIpv4Like(0, this.buildIpv4(0));
  }
  
  public Ipv4DHCPNested<A> editFirstIpv4DHCP() {
    if (ipv4DHCP.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ipv4DHCP"));
    }
    return this.setNewIpv4DHCPLike(0, this.buildIpv4DHCP(0));
  }
  
  public Ipv6Nested<A> editFirstIpv6() {
    if (ipv6.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ipv6"));
    }
    return this.setNewIpv6Like(0, this.buildIpv6(0));
  }
  
  public Ipv6DHCPNested<A> editFirstIpv6DHCP() {
    if (ipv6DHCP.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ipv6DHCP"));
    }
    return this.setNewIpv6DHCPLike(0, this.buildIpv6DHCP(0));
  }
  
  public Ipv6SLAACNested<A> editFirstIpv6SLAAC() {
    if (ipv6SLAAC.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ipv6SLAAC"));
    }
    return this.setNewIpv6SLAACLike(0, this.buildIpv6SLAAC(0));
  }
  
  public Ipv4Nested<A> editIpv4(int index) {
    if (ipv4.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ipv4"));
    }
    return this.setNewIpv4Like(index, this.buildIpv4(index));
  }
  
  public Ipv4DHCPNested<A> editIpv4DHCP(int index) {
    if (ipv4DHCP.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ipv4DHCP"));
    }
    return this.setNewIpv4DHCPLike(index, this.buildIpv4DHCP(index));
  }
  
  public Ipv6Nested<A> editIpv6(int index) {
    if (ipv6.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ipv6"));
    }
    return this.setNewIpv6Like(index, this.buildIpv6(index));
  }
  
  public Ipv6DHCPNested<A> editIpv6DHCP(int index) {
    if (ipv6DHCP.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ipv6DHCP"));
    }
    return this.setNewIpv6DHCPLike(index, this.buildIpv6DHCP(index));
  }
  
  public Ipv6SLAACNested<A> editIpv6SLAAC(int index) {
    if (ipv6SLAAC.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ipv6SLAAC"));
    }
    return this.setNewIpv6SLAACLike(index, this.buildIpv6SLAAC(index));
  }
  
  public Ipv4Nested<A> editLastIpv4() {
    int index = ipv4.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ipv4"));
    }
    return this.setNewIpv4Like(index, this.buildIpv4(index));
  }
  
  public Ipv4DHCPNested<A> editLastIpv4DHCP() {
    int index = ipv4DHCP.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ipv4DHCP"));
    }
    return this.setNewIpv4DHCPLike(index, this.buildIpv4DHCP(index));
  }
  
  public Ipv6Nested<A> editLastIpv6() {
    int index = ipv6.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ipv6"));
    }
    return this.setNewIpv6Like(index, this.buildIpv6(index));
  }
  
  public Ipv6DHCPNested<A> editLastIpv6DHCP() {
    int index = ipv6DHCP.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ipv6DHCP"));
    }
    return this.setNewIpv6DHCPLike(index, this.buildIpv6DHCP(index));
  }
  
  public Ipv6SLAACNested<A> editLastIpv6SLAAC() {
    int index = ipv6SLAAC.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ipv6SLAAC"));
    }
    return this.setNewIpv6SLAACLike(index, this.buildIpv6SLAAC(index));
  }
  
  public Ipv4Nested<A> editMatchingIpv4(Predicate<NetworkDataIPv4Builder> predicate) {
    int index = -1;
    for (int i = 0;i < ipv4.size();i++) {
      if (predicate.test(ipv4.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ipv4"));
    }
    return this.setNewIpv4Like(index, this.buildIpv4(index));
  }
  
  public Ipv4DHCPNested<A> editMatchingIpv4DHCP(Predicate<NetworkDataIPv4DHCPBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ipv4DHCP.size();i++) {
      if (predicate.test(ipv4DHCP.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ipv4DHCP"));
    }
    return this.setNewIpv4DHCPLike(index, this.buildIpv4DHCP(index));
  }
  
  public Ipv6Nested<A> editMatchingIpv6(Predicate<NetworkDataIPv6Builder> predicate) {
    int index = -1;
    for (int i = 0;i < ipv6.size();i++) {
      if (predicate.test(ipv6.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ipv6"));
    }
    return this.setNewIpv6Like(index, this.buildIpv6(index));
  }
  
  public Ipv6DHCPNested<A> editMatchingIpv6DHCP(Predicate<NetworkDataIPv6DHCPBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ipv6DHCP.size();i++) {
      if (predicate.test(ipv6DHCP.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ipv6DHCP"));
    }
    return this.setNewIpv6DHCPLike(index, this.buildIpv6DHCP(index));
  }
  
  public Ipv6SLAACNested<A> editMatchingIpv6SLAAC(Predicate<NetworkDataIPv6DHCPBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ipv6SLAAC.size();i++) {
      if (predicate.test(ipv6SLAAC.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ipv6SLAAC"));
    }
    return this.setNewIpv6SLAACLike(index, this.buildIpv6SLAAC(index));
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
    NetworkDataNetworkFluent that = (NetworkDataNetworkFluent) o;
    if (!(Objects.equals(ipv4, that.ipv4))) {
      return false;
    }
    if (!(Objects.equals(ipv4DHCP, that.ipv4DHCP))) {
      return false;
    }
    if (!(Objects.equals(ipv6, that.ipv6))) {
      return false;
    }
    if (!(Objects.equals(ipv6DHCP, that.ipv6DHCP))) {
      return false;
    }
    if (!(Objects.equals(ipv6SLAAC, that.ipv6SLAAC))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIpv4() {
    return this.ipv4 != null && !(this.ipv4.isEmpty());
  }
  
  public boolean hasIpv4DHCP() {
    return this.ipv4DHCP != null && !(this.ipv4DHCP.isEmpty());
  }
  
  public boolean hasIpv6() {
    return this.ipv6 != null && !(this.ipv6.isEmpty());
  }
  
  public boolean hasIpv6DHCP() {
    return this.ipv6DHCP != null && !(this.ipv6DHCP.isEmpty());
  }
  
  public boolean hasIpv6SLAAC() {
    return this.ipv6SLAAC != null && !(this.ipv6SLAAC.isEmpty());
  }
  
  public boolean hasMatchingIpv4(Predicate<NetworkDataIPv4Builder> predicate) {
      for (NetworkDataIPv4Builder item : ipv4) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIpv4DHCP(Predicate<NetworkDataIPv4DHCPBuilder> predicate) {
      for (NetworkDataIPv4DHCPBuilder item : ipv4DHCP) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIpv6(Predicate<NetworkDataIPv6Builder> predicate) {
      for (NetworkDataIPv6Builder item : ipv6) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIpv6DHCP(Predicate<NetworkDataIPv6DHCPBuilder> predicate) {
      for (NetworkDataIPv6DHCPBuilder item : ipv6DHCP) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIpv6SLAAC(Predicate<NetworkDataIPv6DHCPBuilder> predicate) {
      for (NetworkDataIPv6DHCPBuilder item : ipv6SLAAC) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(ipv4, ipv4DHCP, ipv6, ipv6DHCP, ipv6SLAAC, additionalProperties);
  }
  
  public A removeAllFromIpv4(Collection<NetworkDataIPv4> items) {
    if (this.ipv4 == null) {
      return (A) this;
    }
    for (NetworkDataIPv4 item : items) {
        NetworkDataIPv4Builder builder = new NetworkDataIPv4Builder(item);
        _visitables.get("ipv4").remove(builder);
        this.ipv4.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromIpv4DHCP(Collection<NetworkDataIPv4DHCP> items) {
    if (this.ipv4DHCP == null) {
      return (A) this;
    }
    for (NetworkDataIPv4DHCP item : items) {
        NetworkDataIPv4DHCPBuilder builder = new NetworkDataIPv4DHCPBuilder(item);
        _visitables.get("ipv4DHCP").remove(builder);
        this.ipv4DHCP.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromIpv6(Collection<NetworkDataIPv6> items) {
    if (this.ipv6 == null) {
      return (A) this;
    }
    for (NetworkDataIPv6 item : items) {
        NetworkDataIPv6Builder builder = new NetworkDataIPv6Builder(item);
        _visitables.get("ipv6").remove(builder);
        this.ipv6.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromIpv6DHCP(Collection<NetworkDataIPv6DHCP> items) {
    if (this.ipv6DHCP == null) {
      return (A) this;
    }
    for (NetworkDataIPv6DHCP item : items) {
        NetworkDataIPv6DHCPBuilder builder = new NetworkDataIPv6DHCPBuilder(item);
        _visitables.get("ipv6DHCP").remove(builder);
        this.ipv6DHCP.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromIpv6SLAAC(Collection<NetworkDataIPv6DHCP> items) {
    if (this.ipv6SLAAC == null) {
      return (A) this;
    }
    for (NetworkDataIPv6DHCP item : items) {
        NetworkDataIPv6DHCPBuilder builder = new NetworkDataIPv6DHCPBuilder(item);
        _visitables.get("ipv6SLAAC").remove(builder);
        this.ipv6SLAAC.remove(builder);
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
  
  public A removeFromIpv4(NetworkDataIPv4... items) {
    if (this.ipv4 == null) {
      return (A) this;
    }
    for (NetworkDataIPv4 item : items) {
        NetworkDataIPv4Builder builder = new NetworkDataIPv4Builder(item);
        _visitables.get("ipv4").remove(builder);
        this.ipv4.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromIpv4DHCP(NetworkDataIPv4DHCP... items) {
    if (this.ipv4DHCP == null) {
      return (A) this;
    }
    for (NetworkDataIPv4DHCP item : items) {
        NetworkDataIPv4DHCPBuilder builder = new NetworkDataIPv4DHCPBuilder(item);
        _visitables.get("ipv4DHCP").remove(builder);
        this.ipv4DHCP.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromIpv6(NetworkDataIPv6... items) {
    if (this.ipv6 == null) {
      return (A) this;
    }
    for (NetworkDataIPv6 item : items) {
        NetworkDataIPv6Builder builder = new NetworkDataIPv6Builder(item);
        _visitables.get("ipv6").remove(builder);
        this.ipv6.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromIpv6DHCP(NetworkDataIPv6DHCP... items) {
    if (this.ipv6DHCP == null) {
      return (A) this;
    }
    for (NetworkDataIPv6DHCP item : items) {
        NetworkDataIPv6DHCPBuilder builder = new NetworkDataIPv6DHCPBuilder(item);
        _visitables.get("ipv6DHCP").remove(builder);
        this.ipv6DHCP.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromIpv6SLAAC(NetworkDataIPv6DHCP... items) {
    if (this.ipv6SLAAC == null) {
      return (A) this;
    }
    for (NetworkDataIPv6DHCP item : items) {
        NetworkDataIPv6DHCPBuilder builder = new NetworkDataIPv6DHCPBuilder(item);
        _visitables.get("ipv6SLAAC").remove(builder);
        this.ipv6SLAAC.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromIpv4(Predicate<NetworkDataIPv4Builder> predicate) {
    if (ipv4 == null) {
      return (A) this;
    }
    Iterator<NetworkDataIPv4Builder> each = ipv4.iterator();
    List visitables = _visitables.get("ipv4");
    while (each.hasNext()) {
        NetworkDataIPv4Builder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromIpv4DHCP(Predicate<NetworkDataIPv4DHCPBuilder> predicate) {
    if (ipv4DHCP == null) {
      return (A) this;
    }
    Iterator<NetworkDataIPv4DHCPBuilder> each = ipv4DHCP.iterator();
    List visitables = _visitables.get("ipv4DHCP");
    while (each.hasNext()) {
        NetworkDataIPv4DHCPBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromIpv6(Predicate<NetworkDataIPv6Builder> predicate) {
    if (ipv6 == null) {
      return (A) this;
    }
    Iterator<NetworkDataIPv6Builder> each = ipv6.iterator();
    List visitables = _visitables.get("ipv6");
    while (each.hasNext()) {
        NetworkDataIPv6Builder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromIpv6DHCP(Predicate<NetworkDataIPv6DHCPBuilder> predicate) {
    if (ipv6DHCP == null) {
      return (A) this;
    }
    Iterator<NetworkDataIPv6DHCPBuilder> each = ipv6DHCP.iterator();
    List visitables = _visitables.get("ipv6DHCP");
    while (each.hasNext()) {
        NetworkDataIPv6DHCPBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromIpv6SLAAC(Predicate<NetworkDataIPv6DHCPBuilder> predicate) {
    if (ipv6SLAAC == null) {
      return (A) this;
    }
    Iterator<NetworkDataIPv6DHCPBuilder> each = ipv6SLAAC.iterator();
    List visitables = _visitables.get("ipv6SLAAC");
    while (each.hasNext()) {
        NetworkDataIPv6DHCPBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public Ipv4DHCPNested<A> setNewIpv4DHCPLike(int index,NetworkDataIPv4DHCP item) {
    return new Ipv4DHCPNested(index, item);
  }
  
  public Ipv4Nested<A> setNewIpv4Like(int index,NetworkDataIPv4 item) {
    return new Ipv4Nested(index, item);
  }
  
  public Ipv6DHCPNested<A> setNewIpv6DHCPLike(int index,NetworkDataIPv6DHCP item) {
    return new Ipv6DHCPNested(index, item);
  }
  
  public Ipv6Nested<A> setNewIpv6Like(int index,NetworkDataIPv6 item) {
    return new Ipv6Nested(index, item);
  }
  
  public Ipv6SLAACNested<A> setNewIpv6SLAACLike(int index,NetworkDataIPv6DHCP item) {
    return new Ipv6SLAACNested(index, item);
  }
  
  public A setToIpv4(int index,NetworkDataIPv4 item) {
    if (this.ipv4 == null) {
      this.ipv4 = new ArrayList();
    }
    NetworkDataIPv4Builder builder = new NetworkDataIPv4Builder(item);
    if (index < 0 || index >= ipv4.size()) {
        _visitables.get("ipv4").add(builder);
        ipv4.add(builder);
    } else {
        _visitables.get("ipv4").add(builder);
        ipv4.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToIpv4DHCP(int index,NetworkDataIPv4DHCP item) {
    if (this.ipv4DHCP == null) {
      this.ipv4DHCP = new ArrayList();
    }
    NetworkDataIPv4DHCPBuilder builder = new NetworkDataIPv4DHCPBuilder(item);
    if (index < 0 || index >= ipv4DHCP.size()) {
        _visitables.get("ipv4DHCP").add(builder);
        ipv4DHCP.add(builder);
    } else {
        _visitables.get("ipv4DHCP").add(builder);
        ipv4DHCP.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToIpv6(int index,NetworkDataIPv6 item) {
    if (this.ipv6 == null) {
      this.ipv6 = new ArrayList();
    }
    NetworkDataIPv6Builder builder = new NetworkDataIPv6Builder(item);
    if (index < 0 || index >= ipv6.size()) {
        _visitables.get("ipv6").add(builder);
        ipv6.add(builder);
    } else {
        _visitables.get("ipv6").add(builder);
        ipv6.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToIpv6DHCP(int index,NetworkDataIPv6DHCP item) {
    if (this.ipv6DHCP == null) {
      this.ipv6DHCP = new ArrayList();
    }
    NetworkDataIPv6DHCPBuilder builder = new NetworkDataIPv6DHCPBuilder(item);
    if (index < 0 || index >= ipv6DHCP.size()) {
        _visitables.get("ipv6DHCP").add(builder);
        ipv6DHCP.add(builder);
    } else {
        _visitables.get("ipv6DHCP").add(builder);
        ipv6DHCP.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToIpv6SLAAC(int index,NetworkDataIPv6DHCP item) {
    if (this.ipv6SLAAC == null) {
      this.ipv6SLAAC = new ArrayList();
    }
    NetworkDataIPv6DHCPBuilder builder = new NetworkDataIPv6DHCPBuilder(item);
    if (index < 0 || index >= ipv6SLAAC.size()) {
        _visitables.get("ipv6SLAAC").add(builder);
        ipv6SLAAC.add(builder);
    } else {
        _visitables.get("ipv6SLAAC").add(builder);
        ipv6SLAAC.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(ipv4 == null) && !(ipv4.isEmpty())) {
        sb.append("ipv4:");
        sb.append(ipv4);
        sb.append(",");
    }
    if (!(ipv4DHCP == null) && !(ipv4DHCP.isEmpty())) {
        sb.append("ipv4DHCP:");
        sb.append(ipv4DHCP);
        sb.append(",");
    }
    if (!(ipv6 == null) && !(ipv6.isEmpty())) {
        sb.append("ipv6:");
        sb.append(ipv6);
        sb.append(",");
    }
    if (!(ipv6DHCP == null) && !(ipv6DHCP.isEmpty())) {
        sb.append("ipv6DHCP:");
        sb.append(ipv6DHCP);
        sb.append(",");
    }
    if (!(ipv6SLAAC == null) && !(ipv6SLAAC.isEmpty())) {
        sb.append("ipv6SLAAC:");
        sb.append(ipv6SLAAC);
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
  
  public A withIpv4(List<NetworkDataIPv4> ipv4) {
    if (this.ipv4 != null) {
      this._visitables.get("ipv4").clear();
    }
    if (ipv4 != null) {
        this.ipv4 = new ArrayList();
        for (NetworkDataIPv4 item : ipv4) {
          this.addToIpv4(item);
        }
    } else {
      this.ipv4 = null;
    }
    return (A) this;
  }
  
  public A withIpv4(NetworkDataIPv4... ipv4) {
    if (this.ipv4 != null) {
        this.ipv4.clear();
        _visitables.remove("ipv4");
    }
    if (ipv4 != null) {
      for (NetworkDataIPv4 item : ipv4) {
        this.addToIpv4(item);
      }
    }
    return (A) this;
  }
  
  public A withIpv4DHCP(List<NetworkDataIPv4DHCP> ipv4DHCP) {
    if (this.ipv4DHCP != null) {
      this._visitables.get("ipv4DHCP").clear();
    }
    if (ipv4DHCP != null) {
        this.ipv4DHCP = new ArrayList();
        for (NetworkDataIPv4DHCP item : ipv4DHCP) {
          this.addToIpv4DHCP(item);
        }
    } else {
      this.ipv4DHCP = null;
    }
    return (A) this;
  }
  
  public A withIpv4DHCP(NetworkDataIPv4DHCP... ipv4DHCP) {
    if (this.ipv4DHCP != null) {
        this.ipv4DHCP.clear();
        _visitables.remove("ipv4DHCP");
    }
    if (ipv4DHCP != null) {
      for (NetworkDataIPv4DHCP item : ipv4DHCP) {
        this.addToIpv4DHCP(item);
      }
    }
    return (A) this;
  }
  
  public A withIpv6(List<NetworkDataIPv6> ipv6) {
    if (this.ipv6 != null) {
      this._visitables.get("ipv6").clear();
    }
    if (ipv6 != null) {
        this.ipv6 = new ArrayList();
        for (NetworkDataIPv6 item : ipv6) {
          this.addToIpv6(item);
        }
    } else {
      this.ipv6 = null;
    }
    return (A) this;
  }
  
  public A withIpv6(NetworkDataIPv6... ipv6) {
    if (this.ipv6 != null) {
        this.ipv6.clear();
        _visitables.remove("ipv6");
    }
    if (ipv6 != null) {
      for (NetworkDataIPv6 item : ipv6) {
        this.addToIpv6(item);
      }
    }
    return (A) this;
  }
  
  public A withIpv6DHCP(List<NetworkDataIPv6DHCP> ipv6DHCP) {
    if (this.ipv6DHCP != null) {
      this._visitables.get("ipv6DHCP").clear();
    }
    if (ipv6DHCP != null) {
        this.ipv6DHCP = new ArrayList();
        for (NetworkDataIPv6DHCP item : ipv6DHCP) {
          this.addToIpv6DHCP(item);
        }
    } else {
      this.ipv6DHCP = null;
    }
    return (A) this;
  }
  
  public A withIpv6DHCP(NetworkDataIPv6DHCP... ipv6DHCP) {
    if (this.ipv6DHCP != null) {
        this.ipv6DHCP.clear();
        _visitables.remove("ipv6DHCP");
    }
    if (ipv6DHCP != null) {
      for (NetworkDataIPv6DHCP item : ipv6DHCP) {
        this.addToIpv6DHCP(item);
      }
    }
    return (A) this;
  }
  
  public A withIpv6SLAAC(List<NetworkDataIPv6DHCP> ipv6SLAAC) {
    if (this.ipv6SLAAC != null) {
      this._visitables.get("ipv6SLAAC").clear();
    }
    if (ipv6SLAAC != null) {
        this.ipv6SLAAC = new ArrayList();
        for (NetworkDataIPv6DHCP item : ipv6SLAAC) {
          this.addToIpv6SLAAC(item);
        }
    } else {
      this.ipv6SLAAC = null;
    }
    return (A) this;
  }
  
  public A withIpv6SLAAC(NetworkDataIPv6DHCP... ipv6SLAAC) {
    if (this.ipv6SLAAC != null) {
        this.ipv6SLAAC.clear();
        _visitables.remove("ipv6SLAAC");
    }
    if (ipv6SLAAC != null) {
      for (NetworkDataIPv6DHCP item : ipv6SLAAC) {
        this.addToIpv6SLAAC(item);
      }
    }
    return (A) this;
  }
  public class Ipv4DHCPNested<N> extends NetworkDataIPv4DHCPFluent<Ipv4DHCPNested<N>> implements Nested<N>{
  
    NetworkDataIPv4DHCPBuilder builder;
    int index;
  
    Ipv4DHCPNested(int index,NetworkDataIPv4DHCP item) {
      this.index = index;
      this.builder = new NetworkDataIPv4DHCPBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataNetworkFluent.this.setToIpv4DHCP(index, builder.build());
    }
    
    public N endIpv4DHCP() {
      return and();
    }
    
  }
  public class Ipv4Nested<N> extends NetworkDataIPv4Fluent<Ipv4Nested<N>> implements Nested<N>{
  
    NetworkDataIPv4Builder builder;
    int index;
  
    Ipv4Nested(int index,NetworkDataIPv4 item) {
      this.index = index;
      this.builder = new NetworkDataIPv4Builder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataNetworkFluent.this.setToIpv4(index, builder.build());
    }
    
    public N endIpv4() {
      return and();
    }
    
  }
  public class Ipv6DHCPNested<N> extends NetworkDataIPv6DHCPFluent<Ipv6DHCPNested<N>> implements Nested<N>{
  
    NetworkDataIPv6DHCPBuilder builder;
    int index;
  
    Ipv6DHCPNested(int index,NetworkDataIPv6DHCP item) {
      this.index = index;
      this.builder = new NetworkDataIPv6DHCPBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataNetworkFluent.this.setToIpv6DHCP(index, builder.build());
    }
    
    public N endIpv6DHCP() {
      return and();
    }
    
  }
  public class Ipv6Nested<N> extends NetworkDataIPv6Fluent<Ipv6Nested<N>> implements Nested<N>{
  
    NetworkDataIPv6Builder builder;
    int index;
  
    Ipv6Nested(int index,NetworkDataIPv6 item) {
      this.index = index;
      this.builder = new NetworkDataIPv6Builder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataNetworkFluent.this.setToIpv6(index, builder.build());
    }
    
    public N endIpv6() {
      return and();
    }
    
  }
  public class Ipv6SLAACNested<N> extends NetworkDataIPv6DHCPFluent<Ipv6SLAACNested<N>> implements Nested<N>{
  
    NetworkDataIPv6DHCPBuilder builder;
    int index;
  
    Ipv6SLAACNested(int index,NetworkDataIPv6DHCP item) {
      this.index = index;
      this.builder = new NetworkDataIPv6DHCPBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataNetworkFluent.this.setToIpv6SLAAC(index, builder.build());
    }
    
    public N endIpv6SLAAC() {
      return and();
    }
    
  }
}