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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class SidecarFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.SidecarFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<IstioEgressListenerBuilder> egress = new ArrayList<IstioEgressListenerBuilder>();
  private ConnectionPoolSettingsBuilder inboundConnectionPool;
  private ArrayList<IstioIngressListenerBuilder> ingress = new ArrayList<IstioIngressListenerBuilder>();
  private OutboundTrafficPolicyBuilder outboundTrafficPolicy;
  private WorkloadSelectorBuilder workloadSelector;

  public SidecarFluent() {
  }
  
  public SidecarFluent(Sidecar instance) {
    this.copyInstance(instance);
  }

  public A addAllToEgress(Collection<IstioEgressListener> items) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    for (IstioEgressListener item : items) {
        IstioEgressListenerBuilder builder = new IstioEgressListenerBuilder(item);
        _visitables.get("egress").add(builder);
        this.egress.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToIngress(Collection<IstioIngressListener> items) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    for (IstioIngressListener item : items) {
        IstioIngressListenerBuilder builder = new IstioIngressListenerBuilder(item);
        _visitables.get("ingress").add(builder);
        this.ingress.add(builder);
    }
    return (A) this;
  }
  
  public EgressNested<A> addNewEgress() {
    return new EgressNested(-1, null);
  }
  
  public EgressNested<A> addNewEgressLike(IstioEgressListener item) {
    return new EgressNested(-1, item);
  }
  
  public IngressNested<A> addNewIngress() {
    return new IngressNested(-1, null);
  }
  
  public IngressNested<A> addNewIngressLike(IstioIngressListener item) {
    return new IngressNested(-1, item);
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
  
  public A addToEgress(IstioEgressListener... items) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    for (IstioEgressListener item : items) {
        IstioEgressListenerBuilder builder = new IstioEgressListenerBuilder(item);
        _visitables.get("egress").add(builder);
        this.egress.add(builder);
    }
    return (A) this;
  }
  
  public A addToEgress(int index,IstioEgressListener item) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    IstioEgressListenerBuilder builder = new IstioEgressListenerBuilder(item);
    if (index < 0 || index >= egress.size()) {
        _visitables.get("egress").add(builder);
        egress.add(builder);
    } else {
        _visitables.get("egress").add(builder);
        egress.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToIngress(IstioIngressListener... items) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    for (IstioIngressListener item : items) {
        IstioIngressListenerBuilder builder = new IstioIngressListenerBuilder(item);
        _visitables.get("ingress").add(builder);
        this.ingress.add(builder);
    }
    return (A) this;
  }
  
  public A addToIngress(int index,IstioIngressListener item) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    IstioIngressListenerBuilder builder = new IstioIngressListenerBuilder(item);
    if (index < 0 || index >= ingress.size()) {
        _visitables.get("ingress").add(builder);
        ingress.add(builder);
    } else {
        _visitables.get("ingress").add(builder);
        ingress.add(index, builder);
    }
    return (A) this;
  }
  
  public List<IstioEgressListener> buildEgress() {
    return this.egress != null ? build(egress) : null;
  }
  
  public IstioEgressListener buildEgress(int index) {
    return this.egress.get(index).build();
  }
  
  public IstioEgressListener buildFirstEgress() {
    return this.egress.get(0).build();
  }
  
  public IstioIngressListener buildFirstIngress() {
    return this.ingress.get(0).build();
  }
  
  public ConnectionPoolSettings buildInboundConnectionPool() {
    return this.inboundConnectionPool != null ? this.inboundConnectionPool.build() : null;
  }
  
  public List<IstioIngressListener> buildIngress() {
    return this.ingress != null ? build(ingress) : null;
  }
  
  public IstioIngressListener buildIngress(int index) {
    return this.ingress.get(index).build();
  }
  
  public IstioEgressListener buildLastEgress() {
    return this.egress.get(egress.size() - 1).build();
  }
  
  public IstioIngressListener buildLastIngress() {
    return this.ingress.get(ingress.size() - 1).build();
  }
  
  public IstioEgressListener buildMatchingEgress(Predicate<IstioEgressListenerBuilder> predicate) {
      for (IstioEgressListenerBuilder item : egress) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public IstioIngressListener buildMatchingIngress(Predicate<IstioIngressListenerBuilder> predicate) {
      for (IstioIngressListenerBuilder item : ingress) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OutboundTrafficPolicy buildOutboundTrafficPolicy() {
    return this.outboundTrafficPolicy != null ? this.outboundTrafficPolicy.build() : null;
  }
  
  public WorkloadSelector buildWorkloadSelector() {
    return this.workloadSelector != null ? this.workloadSelector.build() : null;
  }
  
  protected void copyInstance(Sidecar instance) {
    instance = instance != null ? instance : new Sidecar();
    if (instance != null) {
        this.withEgress(instance.getEgress());
        this.withInboundConnectionPool(instance.getInboundConnectionPool());
        this.withIngress(instance.getIngress());
        this.withOutboundTrafficPolicy(instance.getOutboundTrafficPolicy());
        this.withWorkloadSelector(instance.getWorkloadSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EgressNested<A> editEgress(int index) {
    if (egress.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "egress"));
    }
    return this.setNewEgressLike(index, this.buildEgress(index));
  }
  
  public EgressNested<A> editFirstEgress() {
    if (egress.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "egress"));
    }
    return this.setNewEgressLike(0, this.buildEgress(0));
  }
  
  public IngressNested<A> editFirstIngress() {
    if (ingress.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ingress"));
    }
    return this.setNewIngressLike(0, this.buildIngress(0));
  }
  
  public InboundConnectionPoolNested<A> editInboundConnectionPool() {
    return this.withNewInboundConnectionPoolLike(Optional.ofNullable(this.buildInboundConnectionPool()).orElse(null));
  }
  
  public IngressNested<A> editIngress(int index) {
    if (ingress.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ingress"));
    }
    return this.setNewIngressLike(index, this.buildIngress(index));
  }
  
  public EgressNested<A> editLastEgress() {
    int index = egress.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "egress"));
    }
    return this.setNewEgressLike(index, this.buildEgress(index));
  }
  
  public IngressNested<A> editLastIngress() {
    int index = ingress.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ingress"));
    }
    return this.setNewIngressLike(index, this.buildIngress(index));
  }
  
  public EgressNested<A> editMatchingEgress(Predicate<IstioEgressListenerBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < egress.size();i++) {
      if (predicate.test(egress.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "egress"));
    }
    return this.setNewEgressLike(index, this.buildEgress(index));
  }
  
  public IngressNested<A> editMatchingIngress(Predicate<IstioIngressListenerBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ingress.size();i++) {
      if (predicate.test(ingress.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ingress"));
    }
    return this.setNewIngressLike(index, this.buildIngress(index));
  }
  
  public InboundConnectionPoolNested<A> editOrNewInboundConnectionPool() {
    return this.withNewInboundConnectionPoolLike(Optional.ofNullable(this.buildInboundConnectionPool()).orElse(new ConnectionPoolSettingsBuilder().build()));
  }
  
  public InboundConnectionPoolNested<A> editOrNewInboundConnectionPoolLike(ConnectionPoolSettings item) {
    return this.withNewInboundConnectionPoolLike(Optional.ofNullable(this.buildInboundConnectionPool()).orElse(item));
  }
  
  public OutboundTrafficPolicyNested<A> editOrNewOutboundTrafficPolicy() {
    return this.withNewOutboundTrafficPolicyLike(Optional.ofNullable(this.buildOutboundTrafficPolicy()).orElse(new OutboundTrafficPolicyBuilder().build()));
  }
  
  public OutboundTrafficPolicyNested<A> editOrNewOutboundTrafficPolicyLike(OutboundTrafficPolicy item) {
    return this.withNewOutboundTrafficPolicyLike(Optional.ofNullable(this.buildOutboundTrafficPolicy()).orElse(item));
  }
  
  public WorkloadSelectorNested<A> editOrNewWorkloadSelector() {
    return this.withNewWorkloadSelectorLike(Optional.ofNullable(this.buildWorkloadSelector()).orElse(new WorkloadSelectorBuilder().build()));
  }
  
  public WorkloadSelectorNested<A> editOrNewWorkloadSelectorLike(WorkloadSelector item) {
    return this.withNewWorkloadSelectorLike(Optional.ofNullable(this.buildWorkloadSelector()).orElse(item));
  }
  
  public OutboundTrafficPolicyNested<A> editOutboundTrafficPolicy() {
    return this.withNewOutboundTrafficPolicyLike(Optional.ofNullable(this.buildOutboundTrafficPolicy()).orElse(null));
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
    SidecarFluent that = (SidecarFluent) o;
    if (!(Objects.equals(egress, that.egress))) {
      return false;
    }
    if (!(Objects.equals(inboundConnectionPool, that.inboundConnectionPool))) {
      return false;
    }
    if (!(Objects.equals(ingress, that.ingress))) {
      return false;
    }
    if (!(Objects.equals(outboundTrafficPolicy, that.outboundTrafficPolicy))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEgress() {
    return this.egress != null && !(this.egress.isEmpty());
  }
  
  public boolean hasInboundConnectionPool() {
    return this.inboundConnectionPool != null;
  }
  
  public boolean hasIngress() {
    return this.ingress != null && !(this.ingress.isEmpty());
  }
  
  public boolean hasMatchingEgress(Predicate<IstioEgressListenerBuilder> predicate) {
      for (IstioEgressListenerBuilder item : egress) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIngress(Predicate<IstioIngressListenerBuilder> predicate) {
      for (IstioIngressListenerBuilder item : ingress) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOutboundTrafficPolicy() {
    return this.outboundTrafficPolicy != null;
  }
  
  public boolean hasWorkloadSelector() {
    return this.workloadSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(egress, inboundConnectionPool, ingress, outboundTrafficPolicy, workloadSelector, additionalProperties);
  }
  
  public A removeAllFromEgress(Collection<IstioEgressListener> items) {
    if (this.egress == null) {
      return (A) this;
    }
    for (IstioEgressListener item : items) {
        IstioEgressListenerBuilder builder = new IstioEgressListenerBuilder(item);
        _visitables.get("egress").remove(builder);
        this.egress.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromIngress(Collection<IstioIngressListener> items) {
    if (this.ingress == null) {
      return (A) this;
    }
    for (IstioIngressListener item : items) {
        IstioIngressListenerBuilder builder = new IstioIngressListenerBuilder(item);
        _visitables.get("ingress").remove(builder);
        this.ingress.remove(builder);
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
  
  public A removeFromEgress(IstioEgressListener... items) {
    if (this.egress == null) {
      return (A) this;
    }
    for (IstioEgressListener item : items) {
        IstioEgressListenerBuilder builder = new IstioEgressListenerBuilder(item);
        _visitables.get("egress").remove(builder);
        this.egress.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromIngress(IstioIngressListener... items) {
    if (this.ingress == null) {
      return (A) this;
    }
    for (IstioIngressListener item : items) {
        IstioIngressListenerBuilder builder = new IstioIngressListenerBuilder(item);
        _visitables.get("ingress").remove(builder);
        this.ingress.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEgress(Predicate<IstioEgressListenerBuilder> predicate) {
    if (egress == null) {
      return (A) this;
    }
    Iterator<IstioEgressListenerBuilder> each = egress.iterator();
    List visitables = _visitables.get("egress");
    while (each.hasNext()) {
        IstioEgressListenerBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromIngress(Predicate<IstioIngressListenerBuilder> predicate) {
    if (ingress == null) {
      return (A) this;
    }
    Iterator<IstioIngressListenerBuilder> each = ingress.iterator();
    List visitables = _visitables.get("ingress");
    while (each.hasNext()) {
        IstioIngressListenerBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EgressNested<A> setNewEgressLike(int index,IstioEgressListener item) {
    return new EgressNested(index, item);
  }
  
  public IngressNested<A> setNewIngressLike(int index,IstioIngressListener item) {
    return new IngressNested(index, item);
  }
  
  public A setToEgress(int index,IstioEgressListener item) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    IstioEgressListenerBuilder builder = new IstioEgressListenerBuilder(item);
    if (index < 0 || index >= egress.size()) {
        _visitables.get("egress").add(builder);
        egress.add(builder);
    } else {
        _visitables.get("egress").add(builder);
        egress.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToIngress(int index,IstioIngressListener item) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    IstioIngressListenerBuilder builder = new IstioIngressListenerBuilder(item);
    if (index < 0 || index >= ingress.size()) {
        _visitables.get("ingress").add(builder);
        ingress.add(builder);
    } else {
        _visitables.get("ingress").add(builder);
        ingress.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(egress == null) && !(egress.isEmpty())) {
        sb.append("egress:");
        sb.append(egress);
        sb.append(",");
    }
    if (!(inboundConnectionPool == null)) {
        sb.append("inboundConnectionPool:");
        sb.append(inboundConnectionPool);
        sb.append(",");
    }
    if (!(ingress == null) && !(ingress.isEmpty())) {
        sb.append("ingress:");
        sb.append(ingress);
        sb.append(",");
    }
    if (!(outboundTrafficPolicy == null)) {
        sb.append("outboundTrafficPolicy:");
        sb.append(outboundTrafficPolicy);
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
  
  public A withEgress(List<IstioEgressListener> egress) {
    if (this.egress != null) {
      this._visitables.get("egress").clear();
    }
    if (egress != null) {
        this.egress = new ArrayList();
        for (IstioEgressListener item : egress) {
          this.addToEgress(item);
        }
    } else {
      this.egress = null;
    }
    return (A) this;
  }
  
  public A withEgress(IstioEgressListener... egress) {
    if (this.egress != null) {
        this.egress.clear();
        _visitables.remove("egress");
    }
    if (egress != null) {
      for (IstioEgressListener item : egress) {
        this.addToEgress(item);
      }
    }
    return (A) this;
  }
  
  public A withInboundConnectionPool(ConnectionPoolSettings inboundConnectionPool) {
    this._visitables.remove("inboundConnectionPool");
    if (inboundConnectionPool != null) {
        this.inboundConnectionPool = new ConnectionPoolSettingsBuilder(inboundConnectionPool);
        this._visitables.get("inboundConnectionPool").add(this.inboundConnectionPool);
    } else {
        this.inboundConnectionPool = null;
        this._visitables.get("inboundConnectionPool").remove(this.inboundConnectionPool);
    }
    return (A) this;
  }
  
  public A withIngress(List<IstioIngressListener> ingress) {
    if (this.ingress != null) {
      this._visitables.get("ingress").clear();
    }
    if (ingress != null) {
        this.ingress = new ArrayList();
        for (IstioIngressListener item : ingress) {
          this.addToIngress(item);
        }
    } else {
      this.ingress = null;
    }
    return (A) this;
  }
  
  public A withIngress(IstioIngressListener... ingress) {
    if (this.ingress != null) {
        this.ingress.clear();
        _visitables.remove("ingress");
    }
    if (ingress != null) {
      for (IstioIngressListener item : ingress) {
        this.addToIngress(item);
      }
    }
    return (A) this;
  }
  
  public InboundConnectionPoolNested<A> withNewInboundConnectionPool() {
    return new InboundConnectionPoolNested(null);
  }
  
  public InboundConnectionPoolNested<A> withNewInboundConnectionPoolLike(ConnectionPoolSettings item) {
    return new InboundConnectionPoolNested(item);
  }
  
  public OutboundTrafficPolicyNested<A> withNewOutboundTrafficPolicy() {
    return new OutboundTrafficPolicyNested(null);
  }
  
  public OutboundTrafficPolicyNested<A> withNewOutboundTrafficPolicyLike(OutboundTrafficPolicy item) {
    return new OutboundTrafficPolicyNested(item);
  }
  
  public WorkloadSelectorNested<A> withNewWorkloadSelector() {
    return new WorkloadSelectorNested(null);
  }
  
  public WorkloadSelectorNested<A> withNewWorkloadSelectorLike(WorkloadSelector item) {
    return new WorkloadSelectorNested(item);
  }
  
  public A withOutboundTrafficPolicy(OutboundTrafficPolicy outboundTrafficPolicy) {
    this._visitables.remove("outboundTrafficPolicy");
    if (outboundTrafficPolicy != null) {
        this.outboundTrafficPolicy = new OutboundTrafficPolicyBuilder(outboundTrafficPolicy);
        this._visitables.get("outboundTrafficPolicy").add(this.outboundTrafficPolicy);
    } else {
        this.outboundTrafficPolicy = null;
        this._visitables.get("outboundTrafficPolicy").remove(this.outboundTrafficPolicy);
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
  public class EgressNested<N> extends IstioEgressListenerFluent<EgressNested<N>> implements Nested<N>{
  
    IstioEgressListenerBuilder builder;
    int index;
  
    EgressNested(int index,IstioEgressListener item) {
      this.index = index;
      this.builder = new IstioEgressListenerBuilder(this, item);
    }
  
    public N and() {
      return (N) SidecarFluent.this.setToEgress(index, builder.build());
    }
    
    public N endEgress() {
      return and();
    }
    
  }
  public class InboundConnectionPoolNested<N> extends ConnectionPoolSettingsFluent<InboundConnectionPoolNested<N>> implements Nested<N>{
  
    ConnectionPoolSettingsBuilder builder;
  
    InboundConnectionPoolNested(ConnectionPoolSettings item) {
      this.builder = new ConnectionPoolSettingsBuilder(this, item);
    }
  
    public N and() {
      return (N) SidecarFluent.this.withInboundConnectionPool(builder.build());
    }
    
    public N endInboundConnectionPool() {
      return and();
    }
    
  }
  public class IngressNested<N> extends IstioIngressListenerFluent<IngressNested<N>> implements Nested<N>{
  
    IstioIngressListenerBuilder builder;
    int index;
  
    IngressNested(int index,IstioIngressListener item) {
      this.index = index;
      this.builder = new IstioIngressListenerBuilder(this, item);
    }
  
    public N and() {
      return (N) SidecarFluent.this.setToIngress(index, builder.build());
    }
    
    public N endIngress() {
      return and();
    }
    
  }
  public class OutboundTrafficPolicyNested<N> extends OutboundTrafficPolicyFluent<OutboundTrafficPolicyNested<N>> implements Nested<N>{
  
    OutboundTrafficPolicyBuilder builder;
  
    OutboundTrafficPolicyNested(OutboundTrafficPolicy item) {
      this.builder = new OutboundTrafficPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) SidecarFluent.this.withOutboundTrafficPolicy(builder.build());
    }
    
    public N endOutboundTrafficPolicy() {
      return and();
    }
    
  }
  public class WorkloadSelectorNested<N> extends WorkloadSelectorFluent<WorkloadSelectorNested<N>> implements Nested<N>{
  
    WorkloadSelectorBuilder builder;
  
    WorkloadSelectorNested(WorkloadSelector item) {
      this.builder = new WorkloadSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) SidecarFluent.this.withWorkloadSelector(builder.build());
    }
    
    public N endWorkloadSelector() {
      return and();
    }
    
  }
}