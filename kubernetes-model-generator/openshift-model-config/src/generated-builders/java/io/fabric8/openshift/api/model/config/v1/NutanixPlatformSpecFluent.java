package io.fabric8.openshift.api.model.config.v1;

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
public class NutanixPlatformSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.NutanixPlatformSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NutanixFailureDomainBuilder> failureDomains = new ArrayList<NutanixFailureDomainBuilder>();
  private NutanixPrismEndpointBuilder prismCentral;
  private ArrayList<NutanixPrismElementEndpointBuilder> prismElements = new ArrayList<NutanixPrismElementEndpointBuilder>();

  public NutanixPlatformSpecFluent() {
  }
  
  public NutanixPlatformSpecFluent(NutanixPlatformSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToFailureDomains(Collection<NutanixFailureDomain> items) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    for (NutanixFailureDomain item : items) {
        NutanixFailureDomainBuilder builder = new NutanixFailureDomainBuilder(item);
        _visitables.get("failureDomains").add(builder);
        this.failureDomains.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPrismElements(Collection<NutanixPrismElementEndpoint> items) {
    if (this.prismElements == null) {
      this.prismElements = new ArrayList();
    }
    for (NutanixPrismElementEndpoint item : items) {
        NutanixPrismElementEndpointBuilder builder = new NutanixPrismElementEndpointBuilder(item);
        _visitables.get("prismElements").add(builder);
        this.prismElements.add(builder);
    }
    return (A) this;
  }
  
  public FailureDomainsNested<A> addNewFailureDomain() {
    return new FailureDomainsNested(-1, null);
  }
  
  public FailureDomainsNested<A> addNewFailureDomainLike(NutanixFailureDomain item) {
    return new FailureDomainsNested(-1, item);
  }
  
  public PrismElementsNested<A> addNewPrismElement() {
    return new PrismElementsNested(-1, null);
  }
  
  public PrismElementsNested<A> addNewPrismElementLike(NutanixPrismElementEndpoint item) {
    return new PrismElementsNested(-1, item);
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
  
  public A addToFailureDomains(NutanixFailureDomain... items) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    for (NutanixFailureDomain item : items) {
        NutanixFailureDomainBuilder builder = new NutanixFailureDomainBuilder(item);
        _visitables.get("failureDomains").add(builder);
        this.failureDomains.add(builder);
    }
    return (A) this;
  }
  
  public A addToFailureDomains(int index,NutanixFailureDomain item) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    NutanixFailureDomainBuilder builder = new NutanixFailureDomainBuilder(item);
    if (index < 0 || index >= failureDomains.size()) {
        _visitables.get("failureDomains").add(builder);
        failureDomains.add(builder);
    } else {
        _visitables.get("failureDomains").add(builder);
        failureDomains.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPrismElements(NutanixPrismElementEndpoint... items) {
    if (this.prismElements == null) {
      this.prismElements = new ArrayList();
    }
    for (NutanixPrismElementEndpoint item : items) {
        NutanixPrismElementEndpointBuilder builder = new NutanixPrismElementEndpointBuilder(item);
        _visitables.get("prismElements").add(builder);
        this.prismElements.add(builder);
    }
    return (A) this;
  }
  
  public A addToPrismElements(int index,NutanixPrismElementEndpoint item) {
    if (this.prismElements == null) {
      this.prismElements = new ArrayList();
    }
    NutanixPrismElementEndpointBuilder builder = new NutanixPrismElementEndpointBuilder(item);
    if (index < 0 || index >= prismElements.size()) {
        _visitables.get("prismElements").add(builder);
        prismElements.add(builder);
    } else {
        _visitables.get("prismElements").add(builder);
        prismElements.add(index, builder);
    }
    return (A) this;
  }
  
  public NutanixFailureDomain buildFailureDomain(int index) {
    return this.failureDomains.get(index).build();
  }
  
  public List<NutanixFailureDomain> buildFailureDomains() {
    return this.failureDomains != null ? build(failureDomains) : null;
  }
  
  public NutanixFailureDomain buildFirstFailureDomain() {
    return this.failureDomains.get(0).build();
  }
  
  public NutanixPrismElementEndpoint buildFirstPrismElement() {
    return this.prismElements.get(0).build();
  }
  
  public NutanixFailureDomain buildLastFailureDomain() {
    return this.failureDomains.get(failureDomains.size() - 1).build();
  }
  
  public NutanixPrismElementEndpoint buildLastPrismElement() {
    return this.prismElements.get(prismElements.size() - 1).build();
  }
  
  public NutanixFailureDomain buildMatchingFailureDomain(Predicate<NutanixFailureDomainBuilder> predicate) {
      for (NutanixFailureDomainBuilder item : failureDomains) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NutanixPrismElementEndpoint buildMatchingPrismElement(Predicate<NutanixPrismElementEndpointBuilder> predicate) {
      for (NutanixPrismElementEndpointBuilder item : prismElements) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NutanixPrismEndpoint buildPrismCentral() {
    return this.prismCentral != null ? this.prismCentral.build() : null;
  }
  
  public NutanixPrismElementEndpoint buildPrismElement(int index) {
    return this.prismElements.get(index).build();
  }
  
  public List<NutanixPrismElementEndpoint> buildPrismElements() {
    return this.prismElements != null ? build(prismElements) : null;
  }
  
  protected void copyInstance(NutanixPlatformSpec instance) {
    instance = instance != null ? instance : new NutanixPlatformSpec();
    if (instance != null) {
        this.withFailureDomains(instance.getFailureDomains());
        this.withPrismCentral(instance.getPrismCentral());
        this.withPrismElements(instance.getPrismElements());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FailureDomainsNested<A> editFailureDomain(int index) {
    if (failureDomains.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "failureDomains"));
    }
    return this.setNewFailureDomainLike(index, this.buildFailureDomain(index));
  }
  
  public FailureDomainsNested<A> editFirstFailureDomain() {
    if (failureDomains.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "failureDomains"));
    }
    return this.setNewFailureDomainLike(0, this.buildFailureDomain(0));
  }
  
  public PrismElementsNested<A> editFirstPrismElement() {
    if (prismElements.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "prismElements"));
    }
    return this.setNewPrismElementLike(0, this.buildPrismElement(0));
  }
  
  public FailureDomainsNested<A> editLastFailureDomain() {
    int index = failureDomains.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "failureDomains"));
    }
    return this.setNewFailureDomainLike(index, this.buildFailureDomain(index));
  }
  
  public PrismElementsNested<A> editLastPrismElement() {
    int index = prismElements.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "prismElements"));
    }
    return this.setNewPrismElementLike(index, this.buildPrismElement(index));
  }
  
  public FailureDomainsNested<A> editMatchingFailureDomain(Predicate<NutanixFailureDomainBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < failureDomains.size();i++) {
      if (predicate.test(failureDomains.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "failureDomains"));
    }
    return this.setNewFailureDomainLike(index, this.buildFailureDomain(index));
  }
  
  public PrismElementsNested<A> editMatchingPrismElement(Predicate<NutanixPrismElementEndpointBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < prismElements.size();i++) {
      if (predicate.test(prismElements.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "prismElements"));
    }
    return this.setNewPrismElementLike(index, this.buildPrismElement(index));
  }
  
  public PrismCentralNested<A> editOrNewPrismCentral() {
    return this.withNewPrismCentralLike(Optional.ofNullable(this.buildPrismCentral()).orElse(new NutanixPrismEndpointBuilder().build()));
  }
  
  public PrismCentralNested<A> editOrNewPrismCentralLike(NutanixPrismEndpoint item) {
    return this.withNewPrismCentralLike(Optional.ofNullable(this.buildPrismCentral()).orElse(item));
  }
  
  public PrismCentralNested<A> editPrismCentral() {
    return this.withNewPrismCentralLike(Optional.ofNullable(this.buildPrismCentral()).orElse(null));
  }
  
  public PrismElementsNested<A> editPrismElement(int index) {
    if (prismElements.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "prismElements"));
    }
    return this.setNewPrismElementLike(index, this.buildPrismElement(index));
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
    NutanixPlatformSpecFluent that = (NutanixPlatformSpecFluent) o;
    if (!(Objects.equals(failureDomains, that.failureDomains))) {
      return false;
    }
    if (!(Objects.equals(prismCentral, that.prismCentral))) {
      return false;
    }
    if (!(Objects.equals(prismElements, that.prismElements))) {
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
  
  public boolean hasFailureDomains() {
    return this.failureDomains != null && !(this.failureDomains.isEmpty());
  }
  
  public boolean hasMatchingFailureDomain(Predicate<NutanixFailureDomainBuilder> predicate) {
      for (NutanixFailureDomainBuilder item : failureDomains) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPrismElement(Predicate<NutanixPrismElementEndpointBuilder> predicate) {
      for (NutanixPrismElementEndpointBuilder item : prismElements) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPrismCentral() {
    return this.prismCentral != null;
  }
  
  public boolean hasPrismElements() {
    return this.prismElements != null && !(this.prismElements.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(failureDomains, prismCentral, prismElements, additionalProperties);
  }
  
  public A removeAllFromFailureDomains(Collection<NutanixFailureDomain> items) {
    if (this.failureDomains == null) {
      return (A) this;
    }
    for (NutanixFailureDomain item : items) {
        NutanixFailureDomainBuilder builder = new NutanixFailureDomainBuilder(item);
        _visitables.get("failureDomains").remove(builder);
        this.failureDomains.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPrismElements(Collection<NutanixPrismElementEndpoint> items) {
    if (this.prismElements == null) {
      return (A) this;
    }
    for (NutanixPrismElementEndpoint item : items) {
        NutanixPrismElementEndpointBuilder builder = new NutanixPrismElementEndpointBuilder(item);
        _visitables.get("prismElements").remove(builder);
        this.prismElements.remove(builder);
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
  
  public A removeFromFailureDomains(NutanixFailureDomain... items) {
    if (this.failureDomains == null) {
      return (A) this;
    }
    for (NutanixFailureDomain item : items) {
        NutanixFailureDomainBuilder builder = new NutanixFailureDomainBuilder(item);
        _visitables.get("failureDomains").remove(builder);
        this.failureDomains.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPrismElements(NutanixPrismElementEndpoint... items) {
    if (this.prismElements == null) {
      return (A) this;
    }
    for (NutanixPrismElementEndpoint item : items) {
        NutanixPrismElementEndpointBuilder builder = new NutanixPrismElementEndpointBuilder(item);
        _visitables.get("prismElements").remove(builder);
        this.prismElements.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFailureDomains(Predicate<NutanixFailureDomainBuilder> predicate) {
    if (failureDomains == null) {
      return (A) this;
    }
    Iterator<NutanixFailureDomainBuilder> each = failureDomains.iterator();
    List visitables = _visitables.get("failureDomains");
    while (each.hasNext()) {
        NutanixFailureDomainBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPrismElements(Predicate<NutanixPrismElementEndpointBuilder> predicate) {
    if (prismElements == null) {
      return (A) this;
    }
    Iterator<NutanixPrismElementEndpointBuilder> each = prismElements.iterator();
    List visitables = _visitables.get("prismElements");
    while (each.hasNext()) {
        NutanixPrismElementEndpointBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FailureDomainsNested<A> setNewFailureDomainLike(int index,NutanixFailureDomain item) {
    return new FailureDomainsNested(index, item);
  }
  
  public PrismElementsNested<A> setNewPrismElementLike(int index,NutanixPrismElementEndpoint item) {
    return new PrismElementsNested(index, item);
  }
  
  public A setToFailureDomains(int index,NutanixFailureDomain item) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    NutanixFailureDomainBuilder builder = new NutanixFailureDomainBuilder(item);
    if (index < 0 || index >= failureDomains.size()) {
        _visitables.get("failureDomains").add(builder);
        failureDomains.add(builder);
    } else {
        _visitables.get("failureDomains").add(builder);
        failureDomains.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPrismElements(int index,NutanixPrismElementEndpoint item) {
    if (this.prismElements == null) {
      this.prismElements = new ArrayList();
    }
    NutanixPrismElementEndpointBuilder builder = new NutanixPrismElementEndpointBuilder(item);
    if (index < 0 || index >= prismElements.size()) {
        _visitables.get("prismElements").add(builder);
        prismElements.add(builder);
    } else {
        _visitables.get("prismElements").add(builder);
        prismElements.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(failureDomains == null) && !(failureDomains.isEmpty())) {
        sb.append("failureDomains:");
        sb.append(failureDomains);
        sb.append(",");
    }
    if (!(prismCentral == null)) {
        sb.append("prismCentral:");
        sb.append(prismCentral);
        sb.append(",");
    }
    if (!(prismElements == null) && !(prismElements.isEmpty())) {
        sb.append("prismElements:");
        sb.append(prismElements);
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
  
  public A withFailureDomains(List<NutanixFailureDomain> failureDomains) {
    if (this.failureDomains != null) {
      this._visitables.get("failureDomains").clear();
    }
    if (failureDomains != null) {
        this.failureDomains = new ArrayList();
        for (NutanixFailureDomain item : failureDomains) {
          this.addToFailureDomains(item);
        }
    } else {
      this.failureDomains = null;
    }
    return (A) this;
  }
  
  public A withFailureDomains(NutanixFailureDomain... failureDomains) {
    if (this.failureDomains != null) {
        this.failureDomains.clear();
        _visitables.remove("failureDomains");
    }
    if (failureDomains != null) {
      for (NutanixFailureDomain item : failureDomains) {
        this.addToFailureDomains(item);
      }
    }
    return (A) this;
  }
  
  public PrismCentralNested<A> withNewPrismCentral() {
    return new PrismCentralNested(null);
  }
  
  public A withNewPrismCentral(String address,Integer port) {
    return (A) this.withPrismCentral(new NutanixPrismEndpoint(address, port));
  }
  
  public PrismCentralNested<A> withNewPrismCentralLike(NutanixPrismEndpoint item) {
    return new PrismCentralNested(item);
  }
  
  public A withPrismCentral(NutanixPrismEndpoint prismCentral) {
    this._visitables.remove("prismCentral");
    if (prismCentral != null) {
        this.prismCentral = new NutanixPrismEndpointBuilder(prismCentral);
        this._visitables.get("prismCentral").add(this.prismCentral);
    } else {
        this.prismCentral = null;
        this._visitables.get("prismCentral").remove(this.prismCentral);
    }
    return (A) this;
  }
  
  public A withPrismElements(List<NutanixPrismElementEndpoint> prismElements) {
    if (this.prismElements != null) {
      this._visitables.get("prismElements").clear();
    }
    if (prismElements != null) {
        this.prismElements = new ArrayList();
        for (NutanixPrismElementEndpoint item : prismElements) {
          this.addToPrismElements(item);
        }
    } else {
      this.prismElements = null;
    }
    return (A) this;
  }
  
  public A withPrismElements(NutanixPrismElementEndpoint... prismElements) {
    if (this.prismElements != null) {
        this.prismElements.clear();
        _visitables.remove("prismElements");
    }
    if (prismElements != null) {
      for (NutanixPrismElementEndpoint item : prismElements) {
        this.addToPrismElements(item);
      }
    }
    return (A) this;
  }
  public class FailureDomainsNested<N> extends NutanixFailureDomainFluent<FailureDomainsNested<N>> implements Nested<N>{
  
    NutanixFailureDomainBuilder builder;
    int index;
  
    FailureDomainsNested(int index,NutanixFailureDomain item) {
      this.index = index;
      this.builder = new NutanixFailureDomainBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixPlatformSpecFluent.this.setToFailureDomains(index, builder.build());
    }
    
    public N endFailureDomain() {
      return and();
    }
    
  }
  public class PrismCentralNested<N> extends NutanixPrismEndpointFluent<PrismCentralNested<N>> implements Nested<N>{
  
    NutanixPrismEndpointBuilder builder;
  
    PrismCentralNested(NutanixPrismEndpoint item) {
      this.builder = new NutanixPrismEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixPlatformSpecFluent.this.withPrismCentral(builder.build());
    }
    
    public N endPrismCentral() {
      return and();
    }
    
  }
  public class PrismElementsNested<N> extends NutanixPrismElementEndpointFluent<PrismElementsNested<N>> implements Nested<N>{
  
    NutanixPrismElementEndpointBuilder builder;
    int index;
  
    PrismElementsNested(int index,NutanixPrismElementEndpoint item) {
      this.index = index;
      this.builder = new NutanixPrismElementEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) NutanixPlatformSpecFluent.this.setToPrismElements(index, builder.build());
    }
    
    public N endPrismElement() {
      return and();
    }
    
  }
}