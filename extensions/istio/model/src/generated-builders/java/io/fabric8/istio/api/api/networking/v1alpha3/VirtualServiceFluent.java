package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class VirtualServiceFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.VirtualServiceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> exportTo = new ArrayList<String>();
  private List<String> gateways = new ArrayList<String>();
  private List<String> hosts = new ArrayList<String>();
  private ArrayList<HTTPRouteBuilder> http = new ArrayList<HTTPRouteBuilder>();
  private ArrayList<TCPRouteBuilder> tcp = new ArrayList<TCPRouteBuilder>();
  private ArrayList<TLSRouteBuilder> tls = new ArrayList<TLSRouteBuilder>();

  public VirtualServiceFluent() {
  }
  
  public VirtualServiceFluent(VirtualService instance) {
    this.copyInstance(instance);
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
  
  public A addAllToGateways(Collection<String> items) {
    if (this.gateways == null) {
      this.gateways = new ArrayList();
    }
    for (String item : items) {
      this.gateways.add(item);
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
  
  public A addAllToHttp(Collection<HTTPRoute> items) {
    if (this.http == null) {
      this.http = new ArrayList();
    }
    for (HTTPRoute item : items) {
        HTTPRouteBuilder builder = new HTTPRouteBuilder(item);
        _visitables.get("http").add(builder);
        this.http.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTcp(Collection<TCPRoute> items) {
    if (this.tcp == null) {
      this.tcp = new ArrayList();
    }
    for (TCPRoute item : items) {
        TCPRouteBuilder builder = new TCPRouteBuilder(item);
        _visitables.get("tcp").add(builder);
        this.tcp.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTls(Collection<TLSRoute> items) {
    if (this.tls == null) {
      this.tls = new ArrayList();
    }
    for (TLSRoute item : items) {
        TLSRouteBuilder builder = new TLSRouteBuilder(item);
        _visitables.get("tls").add(builder);
        this.tls.add(builder);
    }
    return (A) this;
  }
  
  public HttpNested<A> addNewHttp() {
    return new HttpNested(-1, null);
  }
  
  public HttpNested<A> addNewHttpLike(HTTPRoute item) {
    return new HttpNested(-1, item);
  }
  
  public TcpNested<A> addNewTcp() {
    return new TcpNested(-1, null);
  }
  
  public TcpNested<A> addNewTcpLike(TCPRoute item) {
    return new TcpNested(-1, item);
  }
  
  public TlsNested<A> addNewTl() {
    return new TlsNested(-1, null);
  }
  
  public TlsNested<A> addNewTlLike(TLSRoute item) {
    return new TlsNested(-1, item);
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
  
  public A addToGateways(String... items) {
    if (this.gateways == null) {
      this.gateways = new ArrayList();
    }
    for (String item : items) {
      this.gateways.add(item);
    }
    return (A) this;
  }
  
  public A addToGateways(int index,String item) {
    if (this.gateways == null) {
      this.gateways = new ArrayList();
    }
    this.gateways.add(index, item);
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
  
  public A addToHttp(HTTPRoute... items) {
    if (this.http == null) {
      this.http = new ArrayList();
    }
    for (HTTPRoute item : items) {
        HTTPRouteBuilder builder = new HTTPRouteBuilder(item);
        _visitables.get("http").add(builder);
        this.http.add(builder);
    }
    return (A) this;
  }
  
  public A addToHttp(int index,HTTPRoute item) {
    if (this.http == null) {
      this.http = new ArrayList();
    }
    HTTPRouteBuilder builder = new HTTPRouteBuilder(item);
    if (index < 0 || index >= http.size()) {
        _visitables.get("http").add(builder);
        http.add(builder);
    } else {
        _visitables.get("http").add(builder);
        http.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTcp(TCPRoute... items) {
    if (this.tcp == null) {
      this.tcp = new ArrayList();
    }
    for (TCPRoute item : items) {
        TCPRouteBuilder builder = new TCPRouteBuilder(item);
        _visitables.get("tcp").add(builder);
        this.tcp.add(builder);
    }
    return (A) this;
  }
  
  public A addToTcp(int index,TCPRoute item) {
    if (this.tcp == null) {
      this.tcp = new ArrayList();
    }
    TCPRouteBuilder builder = new TCPRouteBuilder(item);
    if (index < 0 || index >= tcp.size()) {
        _visitables.get("tcp").add(builder);
        tcp.add(builder);
    } else {
        _visitables.get("tcp").add(builder);
        tcp.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTls(TLSRoute... items) {
    if (this.tls == null) {
      this.tls = new ArrayList();
    }
    for (TLSRoute item : items) {
        TLSRouteBuilder builder = new TLSRouteBuilder(item);
        _visitables.get("tls").add(builder);
        this.tls.add(builder);
    }
    return (A) this;
  }
  
  public A addToTls(int index,TLSRoute item) {
    if (this.tls == null) {
      this.tls = new ArrayList();
    }
    TLSRouteBuilder builder = new TLSRouteBuilder(item);
    if (index < 0 || index >= tls.size()) {
        _visitables.get("tls").add(builder);
        tls.add(builder);
    } else {
        _visitables.get("tls").add(builder);
        tls.add(index, builder);
    }
    return (A) this;
  }
  
  public HTTPRoute buildFirstHttp() {
    return this.http.get(0).build();
  }
  
  public TCPRoute buildFirstTcp() {
    return this.tcp.get(0).build();
  }
  
  public TLSRoute buildFirstTl() {
    return this.tls.get(0).build();
  }
  
  public List<HTTPRoute> buildHttp() {
    return this.http != null ? build(http) : null;
  }
  
  public HTTPRoute buildHttp(int index) {
    return this.http.get(index).build();
  }
  
  public HTTPRoute buildLastHttp() {
    return this.http.get(http.size() - 1).build();
  }
  
  public TCPRoute buildLastTcp() {
    return this.tcp.get(tcp.size() - 1).build();
  }
  
  public TLSRoute buildLastTl() {
    return this.tls.get(tls.size() - 1).build();
  }
  
  public HTTPRoute buildMatchingHttp(Predicate<HTTPRouteBuilder> predicate) {
      for (HTTPRouteBuilder item : http) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TCPRoute buildMatchingTcp(Predicate<TCPRouteBuilder> predicate) {
      for (TCPRouteBuilder item : tcp) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TLSRoute buildMatchingTl(Predicate<TLSRouteBuilder> predicate) {
      for (TLSRouteBuilder item : tls) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<TCPRoute> buildTcp() {
    return this.tcp != null ? build(tcp) : null;
  }
  
  public TCPRoute buildTcp(int index) {
    return this.tcp.get(index).build();
  }
  
  public TLSRoute buildTl(int index) {
    return this.tls.get(index).build();
  }
  
  public List<TLSRoute> buildTls() {
    return this.tls != null ? build(tls) : null;
  }
  
  protected void copyInstance(VirtualService instance) {
    instance = instance != null ? instance : new VirtualService();
    if (instance != null) {
        this.withExportTo(instance.getExportTo());
        this.withGateways(instance.getGateways());
        this.withHosts(instance.getHosts());
        this.withHttp(instance.getHttp());
        this.withTcp(instance.getTcp());
        this.withTls(instance.getTls());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HttpNested<A> editFirstHttp() {
    if (http.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "http"));
    }
    return this.setNewHttpLike(0, this.buildHttp(0));
  }
  
  public TcpNested<A> editFirstTcp() {
    if (tcp.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tcp"));
    }
    return this.setNewTcpLike(0, this.buildTcp(0));
  }
  
  public TlsNested<A> editFirstTl() {
    if (tls.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tls"));
    }
    return this.setNewTlLike(0, this.buildTl(0));
  }
  
  public HttpNested<A> editHttp(int index) {
    if (http.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "http"));
    }
    return this.setNewHttpLike(index, this.buildHttp(index));
  }
  
  public HttpNested<A> editLastHttp() {
    int index = http.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "http"));
    }
    return this.setNewHttpLike(index, this.buildHttp(index));
  }
  
  public TcpNested<A> editLastTcp() {
    int index = tcp.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tcp"));
    }
    return this.setNewTcpLike(index, this.buildTcp(index));
  }
  
  public TlsNested<A> editLastTl() {
    int index = tls.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tls"));
    }
    return this.setNewTlLike(index, this.buildTl(index));
  }
  
  public HttpNested<A> editMatchingHttp(Predicate<HTTPRouteBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < http.size();i++) {
      if (predicate.test(http.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "http"));
    }
    return this.setNewHttpLike(index, this.buildHttp(index));
  }
  
  public TcpNested<A> editMatchingTcp(Predicate<TCPRouteBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tcp.size();i++) {
      if (predicate.test(tcp.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tcp"));
    }
    return this.setNewTcpLike(index, this.buildTcp(index));
  }
  
  public TlsNested<A> editMatchingTl(Predicate<TLSRouteBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tls.size();i++) {
      if (predicate.test(tls.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tls"));
    }
    return this.setNewTlLike(index, this.buildTl(index));
  }
  
  public TcpNested<A> editTcp(int index) {
    if (tcp.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tcp"));
    }
    return this.setNewTcpLike(index, this.buildTcp(index));
  }
  
  public TlsNested<A> editTl(int index) {
    if (tls.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tls"));
    }
    return this.setNewTlLike(index, this.buildTl(index));
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
    VirtualServiceFluent that = (VirtualServiceFluent) o;
    if (!(Objects.equals(exportTo, that.exportTo))) {
      return false;
    }
    if (!(Objects.equals(gateways, that.gateways))) {
      return false;
    }
    if (!(Objects.equals(hosts, that.hosts))) {
      return false;
    }
    if (!(Objects.equals(http, that.http))) {
      return false;
    }
    if (!(Objects.equals(tcp, that.tcp))) {
      return false;
    }
    if (!(Objects.equals(tls, that.tls))) {
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
  
  public List<String> getExportTo() {
    return this.exportTo;
  }
  
  public String getExportTo(int index) {
    return this.exportTo.get(index);
  }
  
  public String getFirstExportTo() {
    return this.exportTo.get(0);
  }
  
  public String getFirstGateway() {
    return this.gateways.get(0);
  }
  
  public String getFirstHost() {
    return this.hosts.get(0);
  }
  
  public String getGateway(int index) {
    return this.gateways.get(index);
  }
  
  public List<String> getGateways() {
    return this.gateways;
  }
  
  public String getHost(int index) {
    return this.hosts.get(index);
  }
  
  public List<String> getHosts() {
    return this.hosts;
  }
  
  public String getLastExportTo() {
    return this.exportTo.get(exportTo.size() - 1);
  }
  
  public String getLastGateway() {
    return this.gateways.get(gateways.size() - 1);
  }
  
  public String getLastHost() {
    return this.hosts.get(hosts.size() - 1);
  }
  
  public String getMatchingExportTo(Predicate<String> predicate) {
      for (String item : exportTo) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingGateway(Predicate<String> predicate) {
      for (String item : gateways) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExportTo() {
    return this.exportTo != null && !(this.exportTo.isEmpty());
  }
  
  public boolean hasGateways() {
    return this.gateways != null && !(this.gateways.isEmpty());
  }
  
  public boolean hasHosts() {
    return this.hosts != null && !(this.hosts.isEmpty());
  }
  
  public boolean hasHttp() {
    return this.http != null && !(this.http.isEmpty());
  }
  
  public boolean hasMatchingExportTo(Predicate<String> predicate) {
      for (String item : exportTo) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingGateway(Predicate<String> predicate) {
      for (String item : gateways) {
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
  
  public boolean hasMatchingHttp(Predicate<HTTPRouteBuilder> predicate) {
      for (HTTPRouteBuilder item : http) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTcp(Predicate<TCPRouteBuilder> predicate) {
      for (TCPRouteBuilder item : tcp) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTl(Predicate<TLSRouteBuilder> predicate) {
      for (TLSRouteBuilder item : tls) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTcp() {
    return this.tcp != null && !(this.tcp.isEmpty());
  }
  
  public boolean hasTls() {
    return this.tls != null && !(this.tls.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(exportTo, gateways, hosts, http, tcp, tls, additionalProperties);
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
  
  public A removeAllFromGateways(Collection<String> items) {
    if (this.gateways == null) {
      return (A) this;
    }
    for (String item : items) {
      this.gateways.remove(item);
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
  
  public A removeAllFromHttp(Collection<HTTPRoute> items) {
    if (this.http == null) {
      return (A) this;
    }
    for (HTTPRoute item : items) {
        HTTPRouteBuilder builder = new HTTPRouteBuilder(item);
        _visitables.get("http").remove(builder);
        this.http.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTcp(Collection<TCPRoute> items) {
    if (this.tcp == null) {
      return (A) this;
    }
    for (TCPRoute item : items) {
        TCPRouteBuilder builder = new TCPRouteBuilder(item);
        _visitables.get("tcp").remove(builder);
        this.tcp.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTls(Collection<TLSRoute> items) {
    if (this.tls == null) {
      return (A) this;
    }
    for (TLSRoute item : items) {
        TLSRouteBuilder builder = new TLSRouteBuilder(item);
        _visitables.get("tls").remove(builder);
        this.tls.remove(builder);
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
  
  public A removeFromExportTo(String... items) {
    if (this.exportTo == null) {
      return (A) this;
    }
    for (String item : items) {
      this.exportTo.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromGateways(String... items) {
    if (this.gateways == null) {
      return (A) this;
    }
    for (String item : items) {
      this.gateways.remove(item);
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
  
  public A removeFromHttp(HTTPRoute... items) {
    if (this.http == null) {
      return (A) this;
    }
    for (HTTPRoute item : items) {
        HTTPRouteBuilder builder = new HTTPRouteBuilder(item);
        _visitables.get("http").remove(builder);
        this.http.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTcp(TCPRoute... items) {
    if (this.tcp == null) {
      return (A) this;
    }
    for (TCPRoute item : items) {
        TCPRouteBuilder builder = new TCPRouteBuilder(item);
        _visitables.get("tcp").remove(builder);
        this.tcp.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTls(TLSRoute... items) {
    if (this.tls == null) {
      return (A) this;
    }
    for (TLSRoute item : items) {
        TLSRouteBuilder builder = new TLSRouteBuilder(item);
        _visitables.get("tls").remove(builder);
        this.tls.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromHttp(Predicate<HTTPRouteBuilder> predicate) {
    if (http == null) {
      return (A) this;
    }
    Iterator<HTTPRouteBuilder> each = http.iterator();
    List visitables = _visitables.get("http");
    while (each.hasNext()) {
        HTTPRouteBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTcp(Predicate<TCPRouteBuilder> predicate) {
    if (tcp == null) {
      return (A) this;
    }
    Iterator<TCPRouteBuilder> each = tcp.iterator();
    List visitables = _visitables.get("tcp");
    while (each.hasNext()) {
        TCPRouteBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTls(Predicate<TLSRouteBuilder> predicate) {
    if (tls == null) {
      return (A) this;
    }
    Iterator<TLSRouteBuilder> each = tls.iterator();
    List visitables = _visitables.get("tls");
    while (each.hasNext()) {
        TLSRouteBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public HttpNested<A> setNewHttpLike(int index,HTTPRoute item) {
    return new HttpNested(index, item);
  }
  
  public TcpNested<A> setNewTcpLike(int index,TCPRoute item) {
    return new TcpNested(index, item);
  }
  
  public TlsNested<A> setNewTlLike(int index,TLSRoute item) {
    return new TlsNested(index, item);
  }
  
  public A setToExportTo(int index,String item) {
    if (this.exportTo == null) {
      this.exportTo = new ArrayList();
    }
    this.exportTo.set(index, item);
    return (A) this;
  }
  
  public A setToGateways(int index,String item) {
    if (this.gateways == null) {
      this.gateways = new ArrayList();
    }
    this.gateways.set(index, item);
    return (A) this;
  }
  
  public A setToHosts(int index,String item) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    this.hosts.set(index, item);
    return (A) this;
  }
  
  public A setToHttp(int index,HTTPRoute item) {
    if (this.http == null) {
      this.http = new ArrayList();
    }
    HTTPRouteBuilder builder = new HTTPRouteBuilder(item);
    if (index < 0 || index >= http.size()) {
        _visitables.get("http").add(builder);
        http.add(builder);
    } else {
        _visitables.get("http").add(builder);
        http.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTcp(int index,TCPRoute item) {
    if (this.tcp == null) {
      this.tcp = new ArrayList();
    }
    TCPRouteBuilder builder = new TCPRouteBuilder(item);
    if (index < 0 || index >= tcp.size()) {
        _visitables.get("tcp").add(builder);
        tcp.add(builder);
    } else {
        _visitables.get("tcp").add(builder);
        tcp.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTls(int index,TLSRoute item) {
    if (this.tls == null) {
      this.tls = new ArrayList();
    }
    TLSRouteBuilder builder = new TLSRouteBuilder(item);
    if (index < 0 || index >= tls.size()) {
        _visitables.get("tls").add(builder);
        tls.add(builder);
    } else {
        _visitables.get("tls").add(builder);
        tls.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(exportTo == null) && !(exportTo.isEmpty())) {
        sb.append("exportTo:");
        sb.append(exportTo);
        sb.append(",");
    }
    if (!(gateways == null) && !(gateways.isEmpty())) {
        sb.append("gateways:");
        sb.append(gateways);
        sb.append(",");
    }
    if (!(hosts == null) && !(hosts.isEmpty())) {
        sb.append("hosts:");
        sb.append(hosts);
        sb.append(",");
    }
    if (!(http == null) && !(http.isEmpty())) {
        sb.append("http:");
        sb.append(http);
        sb.append(",");
    }
    if (!(tcp == null) && !(tcp.isEmpty())) {
        sb.append("tcp:");
        sb.append(tcp);
        sb.append(",");
    }
    if (!(tls == null) && !(tls.isEmpty())) {
        sb.append("tls:");
        sb.append(tls);
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
  
  public A withGateways(List<String> gateways) {
    if (gateways != null) {
        this.gateways = new ArrayList();
        for (String item : gateways) {
          this.addToGateways(item);
        }
    } else {
      this.gateways = null;
    }
    return (A) this;
  }
  
  public A withGateways(String... gateways) {
    if (this.gateways != null) {
        this.gateways.clear();
        _visitables.remove("gateways");
    }
    if (gateways != null) {
      for (String item : gateways) {
        this.addToGateways(item);
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
  
  public A withHttp(List<HTTPRoute> http) {
    if (this.http != null) {
      this._visitables.get("http").clear();
    }
    if (http != null) {
        this.http = new ArrayList();
        for (HTTPRoute item : http) {
          this.addToHttp(item);
        }
    } else {
      this.http = null;
    }
    return (A) this;
  }
  
  public A withHttp(HTTPRoute... http) {
    if (this.http != null) {
        this.http.clear();
        _visitables.remove("http");
    }
    if (http != null) {
      for (HTTPRoute item : http) {
        this.addToHttp(item);
      }
    }
    return (A) this;
  }
  
  public A withTcp(List<TCPRoute> tcp) {
    if (this.tcp != null) {
      this._visitables.get("tcp").clear();
    }
    if (tcp != null) {
        this.tcp = new ArrayList();
        for (TCPRoute item : tcp) {
          this.addToTcp(item);
        }
    } else {
      this.tcp = null;
    }
    return (A) this;
  }
  
  public A withTcp(TCPRoute... tcp) {
    if (this.tcp != null) {
        this.tcp.clear();
        _visitables.remove("tcp");
    }
    if (tcp != null) {
      for (TCPRoute item : tcp) {
        this.addToTcp(item);
      }
    }
    return (A) this;
  }
  
  public A withTls(List<TLSRoute> tls) {
    if (this.tls != null) {
      this._visitables.get("tls").clear();
    }
    if (tls != null) {
        this.tls = new ArrayList();
        for (TLSRoute item : tls) {
          this.addToTls(item);
        }
    } else {
      this.tls = null;
    }
    return (A) this;
  }
  
  public A withTls(TLSRoute... tls) {
    if (this.tls != null) {
        this.tls.clear();
        _visitables.remove("tls");
    }
    if (tls != null) {
      for (TLSRoute item : tls) {
        this.addToTls(item);
      }
    }
    return (A) this;
  }
  public class HttpNested<N> extends HTTPRouteFluent<HttpNested<N>> implements Nested<N>{
  
    HTTPRouteBuilder builder;
    int index;
  
    HttpNested(int index,HTTPRoute item) {
      this.index = index;
      this.builder = new HTTPRouteBuilder(this, item);
    }
  
    public N and() {
      return (N) VirtualServiceFluent.this.setToHttp(index, builder.build());
    }
    
    public N endHttp() {
      return and();
    }
    
  }
  public class TcpNested<N> extends TCPRouteFluent<TcpNested<N>> implements Nested<N>{
  
    TCPRouteBuilder builder;
    int index;
  
    TcpNested(int index,TCPRoute item) {
      this.index = index;
      this.builder = new TCPRouteBuilder(this, item);
    }
  
    public N and() {
      return (N) VirtualServiceFluent.this.setToTcp(index, builder.build());
    }
    
    public N endTcp() {
      return and();
    }
    
  }
  public class TlsNested<N> extends TLSRouteFluent<TlsNested<N>> implements Nested<N>{
  
    TLSRouteBuilder builder;
    int index;
  
    TlsNested(int index,TLSRoute item) {
      this.index = index;
      this.builder = new TLSRouteBuilder(this, item);
    }
  
    public N and() {
      return (N) VirtualServiceFluent.this.setToTls(index, builder.build());
    }
    
    public N endTl() {
      return and();
    }
    
  }
}