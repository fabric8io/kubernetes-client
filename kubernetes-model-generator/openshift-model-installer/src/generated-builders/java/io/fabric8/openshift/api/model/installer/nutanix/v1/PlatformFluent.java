package io.fabric8.openshift.api.model.installer.nutanix.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.config.v1.NutanixPlatformLoadBalancer;
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
public class PlatformFluent<A extends io.fabric8.openshift.api.model.installer.nutanix.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVIP;
  private List<String> apiVIPs = new ArrayList<String>();
  private String clusterOSImage;
  private MachinePoolBuilder defaultMachinePlatform;
  private ArrayList<FailureDomainBuilder> failureDomains = new ArrayList<FailureDomainBuilder>();
  private String ingressVIP;
  private List<String> ingressVIPs = new ArrayList<String>();
  private NutanixPlatformLoadBalancer loadBalancer;
  private String preloadedOSImageName;
  private Integer prismAPICallTimeout;
  private PrismCentralBuilder prismCentral;
  private ArrayList<PrismElementBuilder> prismElements = new ArrayList<PrismElementBuilder>();
  private List<String> subnetUUIDs = new ArrayList<String>();

  public PlatformFluent() {
  }
  
  public PlatformFluent(Platform instance) {
    this.copyInstance(instance);
  }

  public A addAllToApiVIPs(Collection<String> items) {
    if (this.apiVIPs == null) {
      this.apiVIPs = new ArrayList();
    }
    for (String item : items) {
      this.apiVIPs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToFailureDomains(Collection<FailureDomain> items) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    for (FailureDomain item : items) {
        FailureDomainBuilder builder = new FailureDomainBuilder(item);
        _visitables.get("failureDomains").add(builder);
        this.failureDomains.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToIngressVIPs(Collection<String> items) {
    if (this.ingressVIPs == null) {
      this.ingressVIPs = new ArrayList();
    }
    for (String item : items) {
      this.ingressVIPs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPrismElements(Collection<PrismElement> items) {
    if (this.prismElements == null) {
      this.prismElements = new ArrayList();
    }
    for (PrismElement item : items) {
        PrismElementBuilder builder = new PrismElementBuilder(item);
        _visitables.get("prismElements").add(builder);
        this.prismElements.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSubnetUUIDs(Collection<String> items) {
    if (this.subnetUUIDs == null) {
      this.subnetUUIDs = new ArrayList();
    }
    for (String item : items) {
      this.subnetUUIDs.add(item);
    }
    return (A) this;
  }
  
  public FailureDomainsNested<A> addNewFailureDomain() {
    return new FailureDomainsNested(-1, null);
  }
  
  public FailureDomainsNested<A> addNewFailureDomainLike(FailureDomain item) {
    return new FailureDomainsNested(-1, item);
  }
  
  public PrismElementsNested<A> addNewPrismElement() {
    return new PrismElementsNested(-1, null);
  }
  
  public PrismElementsNested<A> addNewPrismElementLike(PrismElement item) {
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
  
  public A addToApiVIPs(String... items) {
    if (this.apiVIPs == null) {
      this.apiVIPs = new ArrayList();
    }
    for (String item : items) {
      this.apiVIPs.add(item);
    }
    return (A) this;
  }
  
  public A addToApiVIPs(int index,String item) {
    if (this.apiVIPs == null) {
      this.apiVIPs = new ArrayList();
    }
    this.apiVIPs.add(index, item);
    return (A) this;
  }
  
  public A addToFailureDomains(FailureDomain... items) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    for (FailureDomain item : items) {
        FailureDomainBuilder builder = new FailureDomainBuilder(item);
        _visitables.get("failureDomains").add(builder);
        this.failureDomains.add(builder);
    }
    return (A) this;
  }
  
  public A addToFailureDomains(int index,FailureDomain item) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    FailureDomainBuilder builder = new FailureDomainBuilder(item);
    if (index < 0 || index >= failureDomains.size()) {
        _visitables.get("failureDomains").add(builder);
        failureDomains.add(builder);
    } else {
        _visitables.get("failureDomains").add(builder);
        failureDomains.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToIngressVIPs(String... items) {
    if (this.ingressVIPs == null) {
      this.ingressVIPs = new ArrayList();
    }
    for (String item : items) {
      this.ingressVIPs.add(item);
    }
    return (A) this;
  }
  
  public A addToIngressVIPs(int index,String item) {
    if (this.ingressVIPs == null) {
      this.ingressVIPs = new ArrayList();
    }
    this.ingressVIPs.add(index, item);
    return (A) this;
  }
  
  public A addToPrismElements(PrismElement... items) {
    if (this.prismElements == null) {
      this.prismElements = new ArrayList();
    }
    for (PrismElement item : items) {
        PrismElementBuilder builder = new PrismElementBuilder(item);
        _visitables.get("prismElements").add(builder);
        this.prismElements.add(builder);
    }
    return (A) this;
  }
  
  public A addToPrismElements(int index,PrismElement item) {
    if (this.prismElements == null) {
      this.prismElements = new ArrayList();
    }
    PrismElementBuilder builder = new PrismElementBuilder(item);
    if (index < 0 || index >= prismElements.size()) {
        _visitables.get("prismElements").add(builder);
        prismElements.add(builder);
    } else {
        _visitables.get("prismElements").add(builder);
        prismElements.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSubnetUUIDs(String... items) {
    if (this.subnetUUIDs == null) {
      this.subnetUUIDs = new ArrayList();
    }
    for (String item : items) {
      this.subnetUUIDs.add(item);
    }
    return (A) this;
  }
  
  public A addToSubnetUUIDs(int index,String item) {
    if (this.subnetUUIDs == null) {
      this.subnetUUIDs = new ArrayList();
    }
    this.subnetUUIDs.add(index, item);
    return (A) this;
  }
  
  public MachinePool buildDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null ? this.defaultMachinePlatform.build() : null;
  }
  
  public FailureDomain buildFailureDomain(int index) {
    return this.failureDomains.get(index).build();
  }
  
  public List<FailureDomain> buildFailureDomains() {
    return this.failureDomains != null ? build(failureDomains) : null;
  }
  
  public FailureDomain buildFirstFailureDomain() {
    return this.failureDomains.get(0).build();
  }
  
  public PrismElement buildFirstPrismElement() {
    return this.prismElements.get(0).build();
  }
  
  public FailureDomain buildLastFailureDomain() {
    return this.failureDomains.get(failureDomains.size() - 1).build();
  }
  
  public PrismElement buildLastPrismElement() {
    return this.prismElements.get(prismElements.size() - 1).build();
  }
  
  public FailureDomain buildMatchingFailureDomain(Predicate<FailureDomainBuilder> predicate) {
      for (FailureDomainBuilder item : failureDomains) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PrismElement buildMatchingPrismElement(Predicate<PrismElementBuilder> predicate) {
      for (PrismElementBuilder item : prismElements) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PrismCentral buildPrismCentral() {
    return this.prismCentral != null ? this.prismCentral.build() : null;
  }
  
  public PrismElement buildPrismElement(int index) {
    return this.prismElements.get(index).build();
  }
  
  public List<PrismElement> buildPrismElements() {
    return this.prismElements != null ? build(prismElements) : null;
  }
  
  protected void copyInstance(Platform instance) {
    instance = instance != null ? instance : new Platform();
    if (instance != null) {
        this.withApiVIP(instance.getApiVIP());
        this.withApiVIPs(instance.getApiVIPs());
        this.withClusterOSImage(instance.getClusterOSImage());
        this.withDefaultMachinePlatform(instance.getDefaultMachinePlatform());
        this.withFailureDomains(instance.getFailureDomains());
        this.withIngressVIP(instance.getIngressVIP());
        this.withIngressVIPs(instance.getIngressVIPs());
        this.withLoadBalancer(instance.getLoadBalancer());
        this.withPreloadedOSImageName(instance.getPreloadedOSImageName());
        this.withPrismAPICallTimeout(instance.getPrismAPICallTimeout());
        this.withPrismCentral(instance.getPrismCentral());
        this.withPrismElements(instance.getPrismElements());
        this.withSubnetUUIDs(instance.getSubnetUUIDs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DefaultMachinePlatformNested<A> editDefaultMachinePlatform() {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(null));
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
  
  public FailureDomainsNested<A> editMatchingFailureDomain(Predicate<FailureDomainBuilder> predicate) {
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
  
  public PrismElementsNested<A> editMatchingPrismElement(Predicate<PrismElementBuilder> predicate) {
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
  
  public DefaultMachinePlatformNested<A> editOrNewDefaultMachinePlatform() {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(new MachinePoolBuilder().build()));
  }
  
  public DefaultMachinePlatformNested<A> editOrNewDefaultMachinePlatformLike(MachinePool item) {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(item));
  }
  
  public PrismCentralNested<A> editOrNewPrismCentral() {
    return this.withNewPrismCentralLike(Optional.ofNullable(this.buildPrismCentral()).orElse(new PrismCentralBuilder().build()));
  }
  
  public PrismCentralNested<A> editOrNewPrismCentralLike(PrismCentral item) {
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
    PlatformFluent that = (PlatformFluent) o;
    if (!(Objects.equals(apiVIP, that.apiVIP))) {
      return false;
    }
    if (!(Objects.equals(apiVIPs, that.apiVIPs))) {
      return false;
    }
    if (!(Objects.equals(clusterOSImage, that.clusterOSImage))) {
      return false;
    }
    if (!(Objects.equals(defaultMachinePlatform, that.defaultMachinePlatform))) {
      return false;
    }
    if (!(Objects.equals(failureDomains, that.failureDomains))) {
      return false;
    }
    if (!(Objects.equals(ingressVIP, that.ingressVIP))) {
      return false;
    }
    if (!(Objects.equals(ingressVIPs, that.ingressVIPs))) {
      return false;
    }
    if (!(Objects.equals(loadBalancer, that.loadBalancer))) {
      return false;
    }
    if (!(Objects.equals(preloadedOSImageName, that.preloadedOSImageName))) {
      return false;
    }
    if (!(Objects.equals(prismAPICallTimeout, that.prismAPICallTimeout))) {
      return false;
    }
    if (!(Objects.equals(prismCentral, that.prismCentral))) {
      return false;
    }
    if (!(Objects.equals(prismElements, that.prismElements))) {
      return false;
    }
    if (!(Objects.equals(subnetUUIDs, that.subnetUUIDs))) {
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
  
  public String getApiVIP() {
    return this.apiVIP;
  }
  
  public String getApiVIP(int index) {
    return this.apiVIPs.get(index);
  }
  
  public List<String> getApiVIPs() {
    return this.apiVIPs;
  }
  
  public String getClusterOSImage() {
    return this.clusterOSImage;
  }
  
  public String getFirstApiVIP() {
    return this.apiVIPs.get(0);
  }
  
  public String getFirstIngressVIP() {
    return this.ingressVIPs.get(0);
  }
  
  public String getFirstSubnetUUID() {
    return this.subnetUUIDs.get(0);
  }
  
  public String getIngressVIP() {
    return this.ingressVIP;
  }
  
  public String getIngressVIP(int index) {
    return this.ingressVIPs.get(index);
  }
  
  public List<String> getIngressVIPs() {
    return this.ingressVIPs;
  }
  
  public String getLastApiVIP() {
    return this.apiVIPs.get(apiVIPs.size() - 1);
  }
  
  public String getLastIngressVIP() {
    return this.ingressVIPs.get(ingressVIPs.size() - 1);
  }
  
  public String getLastSubnetUUID() {
    return this.subnetUUIDs.get(subnetUUIDs.size() - 1);
  }
  
  public NutanixPlatformLoadBalancer getLoadBalancer() {
    return this.loadBalancer;
  }
  
  public String getMatchingApiVIP(Predicate<String> predicate) {
      for (String item : apiVIPs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingIngressVIP(Predicate<String> predicate) {
      for (String item : ingressVIPs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingSubnetUUID(Predicate<String> predicate) {
      for (String item : subnetUUIDs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPreloadedOSImageName() {
    return this.preloadedOSImageName;
  }
  
  public Integer getPrismAPICallTimeout() {
    return this.prismAPICallTimeout;
  }
  
  public String getSubnetUUID(int index) {
    return this.subnetUUIDs.get(index);
  }
  
  public List<String> getSubnetUUIDs() {
    return this.subnetUUIDs;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVIP() {
    return this.apiVIP != null;
  }
  
  public boolean hasApiVIPs() {
    return this.apiVIPs != null && !(this.apiVIPs.isEmpty());
  }
  
  public boolean hasClusterOSImage() {
    return this.clusterOSImage != null;
  }
  
  public boolean hasDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null;
  }
  
  public boolean hasFailureDomains() {
    return this.failureDomains != null && !(this.failureDomains.isEmpty());
  }
  
  public boolean hasIngressVIP() {
    return this.ingressVIP != null;
  }
  
  public boolean hasIngressVIPs() {
    return this.ingressVIPs != null && !(this.ingressVIPs.isEmpty());
  }
  
  public boolean hasLoadBalancer() {
    return this.loadBalancer != null;
  }
  
  public boolean hasMatchingApiVIP(Predicate<String> predicate) {
      for (String item : apiVIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFailureDomain(Predicate<FailureDomainBuilder> predicate) {
      for (FailureDomainBuilder item : failureDomains) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIngressVIP(Predicate<String> predicate) {
      for (String item : ingressVIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPrismElement(Predicate<PrismElementBuilder> predicate) {
      for (PrismElementBuilder item : prismElements) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSubnetUUID(Predicate<String> predicate) {
      for (String item : subnetUUIDs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPreloadedOSImageName() {
    return this.preloadedOSImageName != null;
  }
  
  public boolean hasPrismAPICallTimeout() {
    return this.prismAPICallTimeout != null;
  }
  
  public boolean hasPrismCentral() {
    return this.prismCentral != null;
  }
  
  public boolean hasPrismElements() {
    return this.prismElements != null && !(this.prismElements.isEmpty());
  }
  
  public boolean hasSubnetUUIDs() {
    return this.subnetUUIDs != null && !(this.subnetUUIDs.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVIP, apiVIPs, clusterOSImage, defaultMachinePlatform, failureDomains, ingressVIP, ingressVIPs, loadBalancer, preloadedOSImageName, prismAPICallTimeout, prismCentral, prismElements, subnetUUIDs, additionalProperties);
  }
  
  public A removeAllFromApiVIPs(Collection<String> items) {
    if (this.apiVIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiVIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromFailureDomains(Collection<FailureDomain> items) {
    if (this.failureDomains == null) {
      return (A) this;
    }
    for (FailureDomain item : items) {
        FailureDomainBuilder builder = new FailureDomainBuilder(item);
        _visitables.get("failureDomains").remove(builder);
        this.failureDomains.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromIngressVIPs(Collection<String> items) {
    if (this.ingressVIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ingressVIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPrismElements(Collection<PrismElement> items) {
    if (this.prismElements == null) {
      return (A) this;
    }
    for (PrismElement item : items) {
        PrismElementBuilder builder = new PrismElementBuilder(item);
        _visitables.get("prismElements").remove(builder);
        this.prismElements.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSubnetUUIDs(Collection<String> items) {
    if (this.subnetUUIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.subnetUUIDs.remove(item);
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
  
  public A removeFromApiVIPs(String... items) {
    if (this.apiVIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.apiVIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromFailureDomains(FailureDomain... items) {
    if (this.failureDomains == null) {
      return (A) this;
    }
    for (FailureDomain item : items) {
        FailureDomainBuilder builder = new FailureDomainBuilder(item);
        _visitables.get("failureDomains").remove(builder);
        this.failureDomains.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromIngressVIPs(String... items) {
    if (this.ingressVIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ingressVIPs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPrismElements(PrismElement... items) {
    if (this.prismElements == null) {
      return (A) this;
    }
    for (PrismElement item : items) {
        PrismElementBuilder builder = new PrismElementBuilder(item);
        _visitables.get("prismElements").remove(builder);
        this.prismElements.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSubnetUUIDs(String... items) {
    if (this.subnetUUIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.subnetUUIDs.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFailureDomains(Predicate<FailureDomainBuilder> predicate) {
    if (failureDomains == null) {
      return (A) this;
    }
    Iterator<FailureDomainBuilder> each = failureDomains.iterator();
    List visitables = _visitables.get("failureDomains");
    while (each.hasNext()) {
        FailureDomainBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPrismElements(Predicate<PrismElementBuilder> predicate) {
    if (prismElements == null) {
      return (A) this;
    }
    Iterator<PrismElementBuilder> each = prismElements.iterator();
    List visitables = _visitables.get("prismElements");
    while (each.hasNext()) {
        PrismElementBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FailureDomainsNested<A> setNewFailureDomainLike(int index,FailureDomain item) {
    return new FailureDomainsNested(index, item);
  }
  
  public PrismElementsNested<A> setNewPrismElementLike(int index,PrismElement item) {
    return new PrismElementsNested(index, item);
  }
  
  public A setToApiVIPs(int index,String item) {
    if (this.apiVIPs == null) {
      this.apiVIPs = new ArrayList();
    }
    this.apiVIPs.set(index, item);
    return (A) this;
  }
  
  public A setToFailureDomains(int index,FailureDomain item) {
    if (this.failureDomains == null) {
      this.failureDomains = new ArrayList();
    }
    FailureDomainBuilder builder = new FailureDomainBuilder(item);
    if (index < 0 || index >= failureDomains.size()) {
        _visitables.get("failureDomains").add(builder);
        failureDomains.add(builder);
    } else {
        _visitables.get("failureDomains").add(builder);
        failureDomains.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToIngressVIPs(int index,String item) {
    if (this.ingressVIPs == null) {
      this.ingressVIPs = new ArrayList();
    }
    this.ingressVIPs.set(index, item);
    return (A) this;
  }
  
  public A setToPrismElements(int index,PrismElement item) {
    if (this.prismElements == null) {
      this.prismElements = new ArrayList();
    }
    PrismElementBuilder builder = new PrismElementBuilder(item);
    if (index < 0 || index >= prismElements.size()) {
        _visitables.get("prismElements").add(builder);
        prismElements.add(builder);
    } else {
        _visitables.get("prismElements").add(builder);
        prismElements.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSubnetUUIDs(int index,String item) {
    if (this.subnetUUIDs == null) {
      this.subnetUUIDs = new ArrayList();
    }
    this.subnetUUIDs.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVIP == null)) {
        sb.append("apiVIP:");
        sb.append(apiVIP);
        sb.append(",");
    }
    if (!(apiVIPs == null) && !(apiVIPs.isEmpty())) {
        sb.append("apiVIPs:");
        sb.append(apiVIPs);
        sb.append(",");
    }
    if (!(clusterOSImage == null)) {
        sb.append("clusterOSImage:");
        sb.append(clusterOSImage);
        sb.append(",");
    }
    if (!(defaultMachinePlatform == null)) {
        sb.append("defaultMachinePlatform:");
        sb.append(defaultMachinePlatform);
        sb.append(",");
    }
    if (!(failureDomains == null) && !(failureDomains.isEmpty())) {
        sb.append("failureDomains:");
        sb.append(failureDomains);
        sb.append(",");
    }
    if (!(ingressVIP == null)) {
        sb.append("ingressVIP:");
        sb.append(ingressVIP);
        sb.append(",");
    }
    if (!(ingressVIPs == null) && !(ingressVIPs.isEmpty())) {
        sb.append("ingressVIPs:");
        sb.append(ingressVIPs);
        sb.append(",");
    }
    if (!(loadBalancer == null)) {
        sb.append("loadBalancer:");
        sb.append(loadBalancer);
        sb.append(",");
    }
    if (!(preloadedOSImageName == null)) {
        sb.append("preloadedOSImageName:");
        sb.append(preloadedOSImageName);
        sb.append(",");
    }
    if (!(prismAPICallTimeout == null)) {
        sb.append("prismAPICallTimeout:");
        sb.append(prismAPICallTimeout);
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
    if (!(subnetUUIDs == null) && !(subnetUUIDs.isEmpty())) {
        sb.append("subnetUUIDs:");
        sb.append(subnetUUIDs);
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
  
  public A withApiVIP(String apiVIP) {
    this.apiVIP = apiVIP;
    return (A) this;
  }
  
  public A withApiVIPs(List<String> apiVIPs) {
    if (apiVIPs != null) {
        this.apiVIPs = new ArrayList();
        for (String item : apiVIPs) {
          this.addToApiVIPs(item);
        }
    } else {
      this.apiVIPs = null;
    }
    return (A) this;
  }
  
  public A withApiVIPs(String... apiVIPs) {
    if (this.apiVIPs != null) {
        this.apiVIPs.clear();
        _visitables.remove("apiVIPs");
    }
    if (apiVIPs != null) {
      for (String item : apiVIPs) {
        this.addToApiVIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withClusterOSImage(String clusterOSImage) {
    this.clusterOSImage = clusterOSImage;
    return (A) this;
  }
  
  public A withDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
    this._visitables.remove("defaultMachinePlatform");
    if (defaultMachinePlatform != null) {
        this.defaultMachinePlatform = new MachinePoolBuilder(defaultMachinePlatform);
        this._visitables.get("defaultMachinePlatform").add(this.defaultMachinePlatform);
    } else {
        this.defaultMachinePlatform = null;
        this._visitables.get("defaultMachinePlatform").remove(this.defaultMachinePlatform);
    }
    return (A) this;
  }
  
  public A withFailureDomains(List<FailureDomain> failureDomains) {
    if (this.failureDomains != null) {
      this._visitables.get("failureDomains").clear();
    }
    if (failureDomains != null) {
        this.failureDomains = new ArrayList();
        for (FailureDomain item : failureDomains) {
          this.addToFailureDomains(item);
        }
    } else {
      this.failureDomains = null;
    }
    return (A) this;
  }
  
  public A withFailureDomains(FailureDomain... failureDomains) {
    if (this.failureDomains != null) {
        this.failureDomains.clear();
        _visitables.remove("failureDomains");
    }
    if (failureDomains != null) {
      for (FailureDomain item : failureDomains) {
        this.addToFailureDomains(item);
      }
    }
    return (A) this;
  }
  
  public A withIngressVIP(String ingressVIP) {
    this.ingressVIP = ingressVIP;
    return (A) this;
  }
  
  public A withIngressVIPs(List<String> ingressVIPs) {
    if (ingressVIPs != null) {
        this.ingressVIPs = new ArrayList();
        for (String item : ingressVIPs) {
          this.addToIngressVIPs(item);
        }
    } else {
      this.ingressVIPs = null;
    }
    return (A) this;
  }
  
  public A withIngressVIPs(String... ingressVIPs) {
    if (this.ingressVIPs != null) {
        this.ingressVIPs.clear();
        _visitables.remove("ingressVIPs");
    }
    if (ingressVIPs != null) {
      for (String item : ingressVIPs) {
        this.addToIngressVIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withLoadBalancer(NutanixPlatformLoadBalancer loadBalancer) {
    this.loadBalancer = loadBalancer;
    return (A) this;
  }
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatform() {
    return new DefaultMachinePlatformNested(null);
  }
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatformLike(MachinePool item) {
    return new DefaultMachinePlatformNested(item);
  }
  
  public A withNewLoadBalancer(String type) {
    return (A) this.withLoadBalancer(new NutanixPlatformLoadBalancer(type));
  }
  
  public PrismCentralNested<A> withNewPrismCentral() {
    return new PrismCentralNested(null);
  }
  
  public PrismCentralNested<A> withNewPrismCentralLike(PrismCentral item) {
    return new PrismCentralNested(item);
  }
  
  public A withPreloadedOSImageName(String preloadedOSImageName) {
    this.preloadedOSImageName = preloadedOSImageName;
    return (A) this;
  }
  
  public A withPrismAPICallTimeout(Integer prismAPICallTimeout) {
    this.prismAPICallTimeout = prismAPICallTimeout;
    return (A) this;
  }
  
  public A withPrismCentral(PrismCentral prismCentral) {
    this._visitables.remove("prismCentral");
    if (prismCentral != null) {
        this.prismCentral = new PrismCentralBuilder(prismCentral);
        this._visitables.get("prismCentral").add(this.prismCentral);
    } else {
        this.prismCentral = null;
        this._visitables.get("prismCentral").remove(this.prismCentral);
    }
    return (A) this;
  }
  
  public A withPrismElements(List<PrismElement> prismElements) {
    if (this.prismElements != null) {
      this._visitables.get("prismElements").clear();
    }
    if (prismElements != null) {
        this.prismElements = new ArrayList();
        for (PrismElement item : prismElements) {
          this.addToPrismElements(item);
        }
    } else {
      this.prismElements = null;
    }
    return (A) this;
  }
  
  public A withPrismElements(PrismElement... prismElements) {
    if (this.prismElements != null) {
        this.prismElements.clear();
        _visitables.remove("prismElements");
    }
    if (prismElements != null) {
      for (PrismElement item : prismElements) {
        this.addToPrismElements(item);
      }
    }
    return (A) this;
  }
  
  public A withSubnetUUIDs(List<String> subnetUUIDs) {
    if (subnetUUIDs != null) {
        this.subnetUUIDs = new ArrayList();
        for (String item : subnetUUIDs) {
          this.addToSubnetUUIDs(item);
        }
    } else {
      this.subnetUUIDs = null;
    }
    return (A) this;
  }
  
  public A withSubnetUUIDs(String... subnetUUIDs) {
    if (this.subnetUUIDs != null) {
        this.subnetUUIDs.clear();
        _visitables.remove("subnetUUIDs");
    }
    if (subnetUUIDs != null) {
      for (String item : subnetUUIDs) {
        this.addToSubnetUUIDs(item);
      }
    }
    return (A) this;
  }
  public class DefaultMachinePlatformNested<N> extends MachinePoolFluent<DefaultMachinePlatformNested<N>> implements Nested<N>{
  
    MachinePoolBuilder builder;
  
    DefaultMachinePlatformNested(MachinePool item) {
      this.builder = new MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withDefaultMachinePlatform(builder.build());
    }
    
    public N endDefaultMachinePlatform() {
      return and();
    }
    
  }
  public class FailureDomainsNested<N> extends FailureDomainFluent<FailureDomainsNested<N>> implements Nested<N>{
  
    FailureDomainBuilder builder;
    int index;
  
    FailureDomainsNested(int index,FailureDomain item) {
      this.index = index;
      this.builder = new FailureDomainBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.setToFailureDomains(index, builder.build());
    }
    
    public N endFailureDomain() {
      return and();
    }
    
  }
  public class PrismCentralNested<N> extends PrismCentralFluent<PrismCentralNested<N>> implements Nested<N>{
  
    PrismCentralBuilder builder;
  
    PrismCentralNested(PrismCentral item) {
      this.builder = new PrismCentralBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withPrismCentral(builder.build());
    }
    
    public N endPrismCentral() {
      return and();
    }
    
  }
  public class PrismElementsNested<N> extends PrismElementFluent<PrismElementsNested<N>> implements Nested<N>{
  
    PrismElementBuilder builder;
    int index;
  
    PrismElementsNested(int index,PrismElement item) {
      this.index = index;
      this.builder = new PrismElementBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.setToPrismElements(index, builder.build());
    }
    
    public N endPrismElement() {
      return and();
    }
    
  }
}