package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import io.fabric8.kubernetes.api.model.Quantity;
import java.lang.Boolean;
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
public class ServiceMonitorSpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.ServiceMonitorSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AttachMetadataBuilder attachMetadata;
  private String bodySizeLimit;
  private Boolean convertClassicHistogramsToNHCB;
  private ArrayList<EndpointBuilder> endpoints = new ArrayList<EndpointBuilder>();
  private String fallbackScrapeProtocol;
  private String jobLabel;
  private Long keepDroppedTargets;
  private Long labelLimit;
  private Long labelNameLengthLimit;
  private Long labelValueLengthLimit;
  private NamespaceSelectorBuilder namespaceSelector;
  private Long nativeHistogramBucketLimit;
  private Quantity nativeHistogramMinBucketFactor;
  private List<String> podTargetLabels = new ArrayList<String>();
  private Long sampleLimit;
  private String scrapeClass;
  private Boolean scrapeClassicHistograms;
  private Boolean scrapeNativeHistograms;
  private List<String> scrapeProtocols = new ArrayList<String>();
  private LabelSelectorBuilder selector;
  private String selectorMechanism;
  private String serviceDiscoveryRole;
  private List<String> targetLabels = new ArrayList<String>();
  private Long targetLimit;

  public ServiceMonitorSpecFluent() {
  }
  
  public ServiceMonitorSpecFluent(ServiceMonitorSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToEndpoints(Collection<Endpoint> items) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList();
    }
    for (Endpoint item : items) {
        EndpointBuilder builder = new EndpointBuilder(item);
        _visitables.get("endpoints").add(builder);
        this.endpoints.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPodTargetLabels(Collection<String> items) {
    if (this.podTargetLabels == null) {
      this.podTargetLabels = new ArrayList();
    }
    for (String item : items) {
      this.podTargetLabels.add(item);
    }
    return (A) this;
  }
  
  public A addAllToScrapeProtocols(Collection<String> items) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    for (String item : items) {
      this.scrapeProtocols.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTargetLabels(Collection<String> items) {
    if (this.targetLabels == null) {
      this.targetLabels = new ArrayList();
    }
    for (String item : items) {
      this.targetLabels.add(item);
    }
    return (A) this;
  }
  
  public EndpointsNested<A> addNewEndpoint() {
    return new EndpointsNested(-1, null);
  }
  
  public EndpointsNested<A> addNewEndpointLike(Endpoint item) {
    return new EndpointsNested(-1, item);
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
  
  public A addToEndpoints(Endpoint... items) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList();
    }
    for (Endpoint item : items) {
        EndpointBuilder builder = new EndpointBuilder(item);
        _visitables.get("endpoints").add(builder);
        this.endpoints.add(builder);
    }
    return (A) this;
  }
  
  public A addToEndpoints(int index,Endpoint item) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList();
    }
    EndpointBuilder builder = new EndpointBuilder(item);
    if (index < 0 || index >= endpoints.size()) {
        _visitables.get("endpoints").add(builder);
        endpoints.add(builder);
    } else {
        _visitables.get("endpoints").add(builder);
        endpoints.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPodTargetLabels(String... items) {
    if (this.podTargetLabels == null) {
      this.podTargetLabels = new ArrayList();
    }
    for (String item : items) {
      this.podTargetLabels.add(item);
    }
    return (A) this;
  }
  
  public A addToPodTargetLabels(int index,String item) {
    if (this.podTargetLabels == null) {
      this.podTargetLabels = new ArrayList();
    }
    this.podTargetLabels.add(index, item);
    return (A) this;
  }
  
  public A addToScrapeProtocols(String... items) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    for (String item : items) {
      this.scrapeProtocols.add(item);
    }
    return (A) this;
  }
  
  public A addToScrapeProtocols(int index,String item) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    this.scrapeProtocols.add(index, item);
    return (A) this;
  }
  
  public A addToTargetLabels(String... items) {
    if (this.targetLabels == null) {
      this.targetLabels = new ArrayList();
    }
    for (String item : items) {
      this.targetLabels.add(item);
    }
    return (A) this;
  }
  
  public A addToTargetLabels(int index,String item) {
    if (this.targetLabels == null) {
      this.targetLabels = new ArrayList();
    }
    this.targetLabels.add(index, item);
    return (A) this;
  }
  
  public AttachMetadata buildAttachMetadata() {
    return this.attachMetadata != null ? this.attachMetadata.build() : null;
  }
  
  public Endpoint buildEndpoint(int index) {
    return this.endpoints.get(index).build();
  }
  
  public List<Endpoint> buildEndpoints() {
    return this.endpoints != null ? build(endpoints) : null;
  }
  
  public Endpoint buildFirstEndpoint() {
    return this.endpoints.get(0).build();
  }
  
  public Endpoint buildLastEndpoint() {
    return this.endpoints.get(endpoints.size() - 1).build();
  }
  
  public Endpoint buildMatchingEndpoint(Predicate<EndpointBuilder> predicate) {
      for (EndpointBuilder item : endpoints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NamespaceSelector buildNamespaceSelector() {
    return this.namespaceSelector != null ? this.namespaceSelector.build() : null;
  }
  
  public LabelSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(ServiceMonitorSpec instance) {
    instance = instance != null ? instance : new ServiceMonitorSpec();
    if (instance != null) {
        this.withAttachMetadata(instance.getAttachMetadata());
        this.withBodySizeLimit(instance.getBodySizeLimit());
        this.withConvertClassicHistogramsToNHCB(instance.getConvertClassicHistogramsToNHCB());
        this.withEndpoints(instance.getEndpoints());
        this.withFallbackScrapeProtocol(instance.getFallbackScrapeProtocol());
        this.withJobLabel(instance.getJobLabel());
        this.withKeepDroppedTargets(instance.getKeepDroppedTargets());
        this.withLabelLimit(instance.getLabelLimit());
        this.withLabelNameLengthLimit(instance.getLabelNameLengthLimit());
        this.withLabelValueLengthLimit(instance.getLabelValueLengthLimit());
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withNativeHistogramBucketLimit(instance.getNativeHistogramBucketLimit());
        this.withNativeHistogramMinBucketFactor(instance.getNativeHistogramMinBucketFactor());
        this.withPodTargetLabels(instance.getPodTargetLabels());
        this.withSampleLimit(instance.getSampleLimit());
        this.withScrapeClass(instance.getScrapeClass());
        this.withScrapeClassicHistograms(instance.getScrapeClassicHistograms());
        this.withScrapeNativeHistograms(instance.getScrapeNativeHistograms());
        this.withScrapeProtocols(instance.getScrapeProtocols());
        this.withSelector(instance.getSelector());
        this.withSelectorMechanism(instance.getSelectorMechanism());
        this.withServiceDiscoveryRole(instance.getServiceDiscoveryRole());
        this.withTargetLabels(instance.getTargetLabels());
        this.withTargetLimit(instance.getTargetLimit());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AttachMetadataNested<A> editAttachMetadata() {
    return this.withNewAttachMetadataLike(Optional.ofNullable(this.buildAttachMetadata()).orElse(null));
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
  
  public EndpointsNested<A> editLastEndpoint() {
    int index = endpoints.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "endpoints"));
    }
    return this.setNewEndpointLike(index, this.buildEndpoint(index));
  }
  
  public EndpointsNested<A> editMatchingEndpoint(Predicate<EndpointBuilder> predicate) {
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
  
  public NamespaceSelectorNested<A> editNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(null));
  }
  
  public AttachMetadataNested<A> editOrNewAttachMetadata() {
    return this.withNewAttachMetadataLike(Optional.ofNullable(this.buildAttachMetadata()).orElse(new AttachMetadataBuilder().build()));
  }
  
  public AttachMetadataNested<A> editOrNewAttachMetadataLike(AttachMetadata item) {
    return this.withNewAttachMetadataLike(Optional.ofNullable(this.buildAttachMetadata()).orElse(item));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(new NamespaceSelectorBuilder().build()));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelectorLike(NamespaceSelector item) {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(LabelSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
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
    ServiceMonitorSpecFluent that = (ServiceMonitorSpecFluent) o;
    if (!(Objects.equals(attachMetadata, that.attachMetadata))) {
      return false;
    }
    if (!(Objects.equals(bodySizeLimit, that.bodySizeLimit))) {
      return false;
    }
    if (!(Objects.equals(convertClassicHistogramsToNHCB, that.convertClassicHistogramsToNHCB))) {
      return false;
    }
    if (!(Objects.equals(endpoints, that.endpoints))) {
      return false;
    }
    if (!(Objects.equals(fallbackScrapeProtocol, that.fallbackScrapeProtocol))) {
      return false;
    }
    if (!(Objects.equals(jobLabel, that.jobLabel))) {
      return false;
    }
    if (!(Objects.equals(keepDroppedTargets, that.keepDroppedTargets))) {
      return false;
    }
    if (!(Objects.equals(labelLimit, that.labelLimit))) {
      return false;
    }
    if (!(Objects.equals(labelNameLengthLimit, that.labelNameLengthLimit))) {
      return false;
    }
    if (!(Objects.equals(labelValueLengthLimit, that.labelValueLengthLimit))) {
      return false;
    }
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(nativeHistogramBucketLimit, that.nativeHistogramBucketLimit))) {
      return false;
    }
    if (!(Objects.equals(nativeHistogramMinBucketFactor, that.nativeHistogramMinBucketFactor))) {
      return false;
    }
    if (!(Objects.equals(podTargetLabels, that.podTargetLabels))) {
      return false;
    }
    if (!(Objects.equals(sampleLimit, that.sampleLimit))) {
      return false;
    }
    if (!(Objects.equals(scrapeClass, that.scrapeClass))) {
      return false;
    }
    if (!(Objects.equals(scrapeClassicHistograms, that.scrapeClassicHistograms))) {
      return false;
    }
    if (!(Objects.equals(scrapeNativeHistograms, that.scrapeNativeHistograms))) {
      return false;
    }
    if (!(Objects.equals(scrapeProtocols, that.scrapeProtocols))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(selectorMechanism, that.selectorMechanism))) {
      return false;
    }
    if (!(Objects.equals(serviceDiscoveryRole, that.serviceDiscoveryRole))) {
      return false;
    }
    if (!(Objects.equals(targetLabels, that.targetLabels))) {
      return false;
    }
    if (!(Objects.equals(targetLimit, that.targetLimit))) {
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
  
  public String getBodySizeLimit() {
    return this.bodySizeLimit;
  }
  
  public Boolean getConvertClassicHistogramsToNHCB() {
    return this.convertClassicHistogramsToNHCB;
  }
  
  public String getFallbackScrapeProtocol() {
    return this.fallbackScrapeProtocol;
  }
  
  public String getFirstPodTargetLabel() {
    return this.podTargetLabels.get(0);
  }
  
  public String getFirstScrapeProtocol() {
    return this.scrapeProtocols.get(0);
  }
  
  public String getFirstTargetLabel() {
    return this.targetLabels.get(0);
  }
  
  public String getJobLabel() {
    return this.jobLabel;
  }
  
  public Long getKeepDroppedTargets() {
    return this.keepDroppedTargets;
  }
  
  public Long getLabelLimit() {
    return this.labelLimit;
  }
  
  public Long getLabelNameLengthLimit() {
    return this.labelNameLengthLimit;
  }
  
  public Long getLabelValueLengthLimit() {
    return this.labelValueLengthLimit;
  }
  
  public String getLastPodTargetLabel() {
    return this.podTargetLabels.get(podTargetLabels.size() - 1);
  }
  
  public String getLastScrapeProtocol() {
    return this.scrapeProtocols.get(scrapeProtocols.size() - 1);
  }
  
  public String getLastTargetLabel() {
    return this.targetLabels.get(targetLabels.size() - 1);
  }
  
  public String getMatchingPodTargetLabel(Predicate<String> predicate) {
      for (String item : podTargetLabels) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingScrapeProtocol(Predicate<String> predicate) {
      for (String item : scrapeProtocols) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingTargetLabel(Predicate<String> predicate) {
      for (String item : targetLabels) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getNativeHistogramBucketLimit() {
    return this.nativeHistogramBucketLimit;
  }
  
  public Quantity getNativeHistogramMinBucketFactor() {
    return this.nativeHistogramMinBucketFactor;
  }
  
  public String getPodTargetLabel(int index) {
    return this.podTargetLabels.get(index);
  }
  
  public List<String> getPodTargetLabels() {
    return this.podTargetLabels;
  }
  
  public Long getSampleLimit() {
    return this.sampleLimit;
  }
  
  public String getScrapeClass() {
    return this.scrapeClass;
  }
  
  public Boolean getScrapeClassicHistograms() {
    return this.scrapeClassicHistograms;
  }
  
  public Boolean getScrapeNativeHistograms() {
    return this.scrapeNativeHistograms;
  }
  
  public String getScrapeProtocol(int index) {
    return this.scrapeProtocols.get(index);
  }
  
  public List<String> getScrapeProtocols() {
    return this.scrapeProtocols;
  }
  
  public String getSelectorMechanism() {
    return this.selectorMechanism;
  }
  
  public String getServiceDiscoveryRole() {
    return this.serviceDiscoveryRole;
  }
  
  public String getTargetLabel(int index) {
    return this.targetLabels.get(index);
  }
  
  public List<String> getTargetLabels() {
    return this.targetLabels;
  }
  
  public Long getTargetLimit() {
    return this.targetLimit;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttachMetadata() {
    return this.attachMetadata != null;
  }
  
  public boolean hasBodySizeLimit() {
    return this.bodySizeLimit != null;
  }
  
  public boolean hasConvertClassicHistogramsToNHCB() {
    return this.convertClassicHistogramsToNHCB != null;
  }
  
  public boolean hasEndpoints() {
    return this.endpoints != null && !(this.endpoints.isEmpty());
  }
  
  public boolean hasFallbackScrapeProtocol() {
    return this.fallbackScrapeProtocol != null;
  }
  
  public boolean hasJobLabel() {
    return this.jobLabel != null;
  }
  
  public boolean hasKeepDroppedTargets() {
    return this.keepDroppedTargets != null;
  }
  
  public boolean hasLabelLimit() {
    return this.labelLimit != null;
  }
  
  public boolean hasLabelNameLengthLimit() {
    return this.labelNameLengthLimit != null;
  }
  
  public boolean hasLabelValueLengthLimit() {
    return this.labelValueLengthLimit != null;
  }
  
  public boolean hasMatchingEndpoint(Predicate<EndpointBuilder> predicate) {
      for (EndpointBuilder item : endpoints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPodTargetLabel(Predicate<String> predicate) {
      for (String item : podTargetLabels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingScrapeProtocol(Predicate<String> predicate) {
      for (String item : scrapeProtocols) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTargetLabel(Predicate<String> predicate) {
      for (String item : targetLabels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasNativeHistogramBucketLimit() {
    return this.nativeHistogramBucketLimit != null;
  }
  
  public boolean hasNativeHistogramMinBucketFactor() {
    return this.nativeHistogramMinBucketFactor != null;
  }
  
  public boolean hasPodTargetLabels() {
    return this.podTargetLabels != null && !(this.podTargetLabels.isEmpty());
  }
  
  public boolean hasSampleLimit() {
    return this.sampleLimit != null;
  }
  
  public boolean hasScrapeClass() {
    return this.scrapeClass != null;
  }
  
  public boolean hasScrapeClassicHistograms() {
    return this.scrapeClassicHistograms != null;
  }
  
  public boolean hasScrapeNativeHistograms() {
    return this.scrapeNativeHistograms != null;
  }
  
  public boolean hasScrapeProtocols() {
    return this.scrapeProtocols != null && !(this.scrapeProtocols.isEmpty());
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasSelectorMechanism() {
    return this.selectorMechanism != null;
  }
  
  public boolean hasServiceDiscoveryRole() {
    return this.serviceDiscoveryRole != null;
  }
  
  public boolean hasTargetLabels() {
    return this.targetLabels != null && !(this.targetLabels.isEmpty());
  }
  
  public boolean hasTargetLimit() {
    return this.targetLimit != null;
  }
  
  public int hashCode() {
    return Objects.hash(attachMetadata, bodySizeLimit, convertClassicHistogramsToNHCB, endpoints, fallbackScrapeProtocol, jobLabel, keepDroppedTargets, labelLimit, labelNameLengthLimit, labelValueLengthLimit, namespaceSelector, nativeHistogramBucketLimit, nativeHistogramMinBucketFactor, podTargetLabels, sampleLimit, scrapeClass, scrapeClassicHistograms, scrapeNativeHistograms, scrapeProtocols, selector, selectorMechanism, serviceDiscoveryRole, targetLabels, targetLimit, additionalProperties);
  }
  
  public A removeAllFromEndpoints(Collection<Endpoint> items) {
    if (this.endpoints == null) {
      return (A) this;
    }
    for (Endpoint item : items) {
        EndpointBuilder builder = new EndpointBuilder(item);
        _visitables.get("endpoints").remove(builder);
        this.endpoints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPodTargetLabels(Collection<String> items) {
    if (this.podTargetLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.podTargetLabels.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromScrapeProtocols(Collection<String> items) {
    if (this.scrapeProtocols == null) {
      return (A) this;
    }
    for (String item : items) {
      this.scrapeProtocols.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTargetLabels(Collection<String> items) {
    if (this.targetLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.targetLabels.remove(item);
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
  
  public A removeFromEndpoints(Endpoint... items) {
    if (this.endpoints == null) {
      return (A) this;
    }
    for (Endpoint item : items) {
        EndpointBuilder builder = new EndpointBuilder(item);
        _visitables.get("endpoints").remove(builder);
        this.endpoints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPodTargetLabels(String... items) {
    if (this.podTargetLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.podTargetLabels.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromScrapeProtocols(String... items) {
    if (this.scrapeProtocols == null) {
      return (A) this;
    }
    for (String item : items) {
      this.scrapeProtocols.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTargetLabels(String... items) {
    if (this.targetLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.targetLabels.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEndpoints(Predicate<EndpointBuilder> predicate) {
    if (endpoints == null) {
      return (A) this;
    }
    Iterator<EndpointBuilder> each = endpoints.iterator();
    List visitables = _visitables.get("endpoints");
    while (each.hasNext()) {
        EndpointBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EndpointsNested<A> setNewEndpointLike(int index,Endpoint item) {
    return new EndpointsNested(index, item);
  }
  
  public A setToEndpoints(int index,Endpoint item) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList();
    }
    EndpointBuilder builder = new EndpointBuilder(item);
    if (index < 0 || index >= endpoints.size()) {
        _visitables.get("endpoints").add(builder);
        endpoints.add(builder);
    } else {
        _visitables.get("endpoints").add(builder);
        endpoints.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPodTargetLabels(int index,String item) {
    if (this.podTargetLabels == null) {
      this.podTargetLabels = new ArrayList();
    }
    this.podTargetLabels.set(index, item);
    return (A) this;
  }
  
  public A setToScrapeProtocols(int index,String item) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    this.scrapeProtocols.set(index, item);
    return (A) this;
  }
  
  public A setToTargetLabels(int index,String item) {
    if (this.targetLabels == null) {
      this.targetLabels = new ArrayList();
    }
    this.targetLabels.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(attachMetadata == null)) {
        sb.append("attachMetadata:");
        sb.append(attachMetadata);
        sb.append(",");
    }
    if (!(bodySizeLimit == null)) {
        sb.append("bodySizeLimit:");
        sb.append(bodySizeLimit);
        sb.append(",");
    }
    if (!(convertClassicHistogramsToNHCB == null)) {
        sb.append("convertClassicHistogramsToNHCB:");
        sb.append(convertClassicHistogramsToNHCB);
        sb.append(",");
    }
    if (!(endpoints == null) && !(endpoints.isEmpty())) {
        sb.append("endpoints:");
        sb.append(endpoints);
        sb.append(",");
    }
    if (!(fallbackScrapeProtocol == null)) {
        sb.append("fallbackScrapeProtocol:");
        sb.append(fallbackScrapeProtocol);
        sb.append(",");
    }
    if (!(jobLabel == null)) {
        sb.append("jobLabel:");
        sb.append(jobLabel);
        sb.append(",");
    }
    if (!(keepDroppedTargets == null)) {
        sb.append("keepDroppedTargets:");
        sb.append(keepDroppedTargets);
        sb.append(",");
    }
    if (!(labelLimit == null)) {
        sb.append("labelLimit:");
        sb.append(labelLimit);
        sb.append(",");
    }
    if (!(labelNameLengthLimit == null)) {
        sb.append("labelNameLengthLimit:");
        sb.append(labelNameLengthLimit);
        sb.append(",");
    }
    if (!(labelValueLengthLimit == null)) {
        sb.append("labelValueLengthLimit:");
        sb.append(labelValueLengthLimit);
        sb.append(",");
    }
    if (!(namespaceSelector == null)) {
        sb.append("namespaceSelector:");
        sb.append(namespaceSelector);
        sb.append(",");
    }
    if (!(nativeHistogramBucketLimit == null)) {
        sb.append("nativeHistogramBucketLimit:");
        sb.append(nativeHistogramBucketLimit);
        sb.append(",");
    }
    if (!(nativeHistogramMinBucketFactor == null)) {
        sb.append("nativeHistogramMinBucketFactor:");
        sb.append(nativeHistogramMinBucketFactor);
        sb.append(",");
    }
    if (!(podTargetLabels == null) && !(podTargetLabels.isEmpty())) {
        sb.append("podTargetLabels:");
        sb.append(podTargetLabels);
        sb.append(",");
    }
    if (!(sampleLimit == null)) {
        sb.append("sampleLimit:");
        sb.append(sampleLimit);
        sb.append(",");
    }
    if (!(scrapeClass == null)) {
        sb.append("scrapeClass:");
        sb.append(scrapeClass);
        sb.append(",");
    }
    if (!(scrapeClassicHistograms == null)) {
        sb.append("scrapeClassicHistograms:");
        sb.append(scrapeClassicHistograms);
        sb.append(",");
    }
    if (!(scrapeNativeHistograms == null)) {
        sb.append("scrapeNativeHistograms:");
        sb.append(scrapeNativeHistograms);
        sb.append(",");
    }
    if (!(scrapeProtocols == null) && !(scrapeProtocols.isEmpty())) {
        sb.append("scrapeProtocols:");
        sb.append(scrapeProtocols);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(selectorMechanism == null)) {
        sb.append("selectorMechanism:");
        sb.append(selectorMechanism);
        sb.append(",");
    }
    if (!(serviceDiscoveryRole == null)) {
        sb.append("serviceDiscoveryRole:");
        sb.append(serviceDiscoveryRole);
        sb.append(",");
    }
    if (!(targetLabels == null) && !(targetLabels.isEmpty())) {
        sb.append("targetLabels:");
        sb.append(targetLabels);
        sb.append(",");
    }
    if (!(targetLimit == null)) {
        sb.append("targetLimit:");
        sb.append(targetLimit);
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
  
  public A withAttachMetadata(AttachMetadata attachMetadata) {
    this._visitables.remove("attachMetadata");
    if (attachMetadata != null) {
        this.attachMetadata = new AttachMetadataBuilder(attachMetadata);
        this._visitables.get("attachMetadata").add(this.attachMetadata);
    } else {
        this.attachMetadata = null;
        this._visitables.get("attachMetadata").remove(this.attachMetadata);
    }
    return (A) this;
  }
  
  public A withBodySizeLimit(String bodySizeLimit) {
    this.bodySizeLimit = bodySizeLimit;
    return (A) this;
  }
  
  public A withConvertClassicHistogramsToNHCB() {
    return withConvertClassicHistogramsToNHCB(true);
  }
  
  public A withConvertClassicHistogramsToNHCB(Boolean convertClassicHistogramsToNHCB) {
    this.convertClassicHistogramsToNHCB = convertClassicHistogramsToNHCB;
    return (A) this;
  }
  
  public A withEndpoints(List<Endpoint> endpoints) {
    if (this.endpoints != null) {
      this._visitables.get("endpoints").clear();
    }
    if (endpoints != null) {
        this.endpoints = new ArrayList();
        for (Endpoint item : endpoints) {
          this.addToEndpoints(item);
        }
    } else {
      this.endpoints = null;
    }
    return (A) this;
  }
  
  public A withEndpoints(Endpoint... endpoints) {
    if (this.endpoints != null) {
        this.endpoints.clear();
        _visitables.remove("endpoints");
    }
    if (endpoints != null) {
      for (Endpoint item : endpoints) {
        this.addToEndpoints(item);
      }
    }
    return (A) this;
  }
  
  public A withFallbackScrapeProtocol(String fallbackScrapeProtocol) {
    this.fallbackScrapeProtocol = fallbackScrapeProtocol;
    return (A) this;
  }
  
  public A withJobLabel(String jobLabel) {
    this.jobLabel = jobLabel;
    return (A) this;
  }
  
  public A withKeepDroppedTargets(Long keepDroppedTargets) {
    this.keepDroppedTargets = keepDroppedTargets;
    return (A) this;
  }
  
  public A withLabelLimit(Long labelLimit) {
    this.labelLimit = labelLimit;
    return (A) this;
  }
  
  public A withLabelNameLengthLimit(Long labelNameLengthLimit) {
    this.labelNameLengthLimit = labelNameLengthLimit;
    return (A) this;
  }
  
  public A withLabelValueLengthLimit(Long labelValueLengthLimit) {
    this.labelValueLengthLimit = labelValueLengthLimit;
    return (A) this;
  }
  
  public A withNamespaceSelector(NamespaceSelector namespaceSelector) {
    this._visitables.remove("namespaceSelector");
    if (namespaceSelector != null) {
        this.namespaceSelector = new NamespaceSelectorBuilder(namespaceSelector);
        this._visitables.get("namespaceSelector").add(this.namespaceSelector);
    } else {
        this.namespaceSelector = null;
        this._visitables.get("namespaceSelector").remove(this.namespaceSelector);
    }
    return (A) this;
  }
  
  public A withNativeHistogramBucketLimit(Long nativeHistogramBucketLimit) {
    this.nativeHistogramBucketLimit = nativeHistogramBucketLimit;
    return (A) this;
  }
  
  public A withNativeHistogramMinBucketFactor(Quantity nativeHistogramMinBucketFactor) {
    this.nativeHistogramMinBucketFactor = nativeHistogramMinBucketFactor;
    return (A) this;
  }
  
  public AttachMetadataNested<A> withNewAttachMetadata() {
    return new AttachMetadataNested(null);
  }
  
  public A withNewAttachMetadata(Boolean node) {
    return (A) this.withAttachMetadata(new AttachMetadata(node));
  }
  
  public AttachMetadataNested<A> withNewAttachMetadataLike(AttachMetadata item) {
    return new AttachMetadataNested(item);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelector() {
    return new NamespaceSelectorNested(null);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelectorLike(NamespaceSelector item) {
    return new NamespaceSelectorNested(item);
  }
  
  public A withNewNativeHistogramMinBucketFactor(String amount) {
    return (A) this.withNativeHistogramMinBucketFactor(new Quantity(amount));
  }
  
  public A withNewNativeHistogramMinBucketFactor(String amount,String format) {
    return (A) this.withNativeHistogramMinBucketFactor(new Quantity(amount, format));
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(LabelSelector item) {
    return new SelectorNested(item);
  }
  
  public A withPodTargetLabels(List<String> podTargetLabels) {
    if (podTargetLabels != null) {
        this.podTargetLabels = new ArrayList();
        for (String item : podTargetLabels) {
          this.addToPodTargetLabels(item);
        }
    } else {
      this.podTargetLabels = null;
    }
    return (A) this;
  }
  
  public A withPodTargetLabels(String... podTargetLabels) {
    if (this.podTargetLabels != null) {
        this.podTargetLabels.clear();
        _visitables.remove("podTargetLabels");
    }
    if (podTargetLabels != null) {
      for (String item : podTargetLabels) {
        this.addToPodTargetLabels(item);
      }
    }
    return (A) this;
  }
  
  public A withSampleLimit(Long sampleLimit) {
    this.sampleLimit = sampleLimit;
    return (A) this;
  }
  
  public A withScrapeClass(String scrapeClass) {
    this.scrapeClass = scrapeClass;
    return (A) this;
  }
  
  public A withScrapeClassicHistograms() {
    return withScrapeClassicHistograms(true);
  }
  
  public A withScrapeClassicHistograms(Boolean scrapeClassicHistograms) {
    this.scrapeClassicHistograms = scrapeClassicHistograms;
    return (A) this;
  }
  
  public A withScrapeNativeHistograms() {
    return withScrapeNativeHistograms(true);
  }
  
  public A withScrapeNativeHistograms(Boolean scrapeNativeHistograms) {
    this.scrapeNativeHistograms = scrapeNativeHistograms;
    return (A) this;
  }
  
  public A withScrapeProtocols(List<String> scrapeProtocols) {
    if (scrapeProtocols != null) {
        this.scrapeProtocols = new ArrayList();
        for (String item : scrapeProtocols) {
          this.addToScrapeProtocols(item);
        }
    } else {
      this.scrapeProtocols = null;
    }
    return (A) this;
  }
  
  public A withScrapeProtocols(String... scrapeProtocols) {
    if (this.scrapeProtocols != null) {
        this.scrapeProtocols.clear();
        _visitables.remove("scrapeProtocols");
    }
    if (scrapeProtocols != null) {
      for (String item : scrapeProtocols) {
        this.addToScrapeProtocols(item);
      }
    }
    return (A) this;
  }
  
  public A withSelector(LabelSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new LabelSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  
  public A withSelectorMechanism(String selectorMechanism) {
    this.selectorMechanism = selectorMechanism;
    return (A) this;
  }
  
  public A withServiceDiscoveryRole(String serviceDiscoveryRole) {
    this.serviceDiscoveryRole = serviceDiscoveryRole;
    return (A) this;
  }
  
  public A withTargetLabels(List<String> targetLabels) {
    if (targetLabels != null) {
        this.targetLabels = new ArrayList();
        for (String item : targetLabels) {
          this.addToTargetLabels(item);
        }
    } else {
      this.targetLabels = null;
    }
    return (A) this;
  }
  
  public A withTargetLabels(String... targetLabels) {
    if (this.targetLabels != null) {
        this.targetLabels.clear();
        _visitables.remove("targetLabels");
    }
    if (targetLabels != null) {
      for (String item : targetLabels) {
        this.addToTargetLabels(item);
      }
    }
    return (A) this;
  }
  
  public A withTargetLimit(Long targetLimit) {
    this.targetLimit = targetLimit;
    return (A) this;
  }
  public class AttachMetadataNested<N> extends AttachMetadataFluent<AttachMetadataNested<N>> implements Nested<N>{
  
    AttachMetadataBuilder builder;
  
    AttachMetadataNested(AttachMetadata item) {
      this.builder = new AttachMetadataBuilder(this, item);
    }
  
    public N and() {
      return (N) ServiceMonitorSpecFluent.this.withAttachMetadata(builder.build());
    }
    
    public N endAttachMetadata() {
      return and();
    }
    
  }
  public class EndpointsNested<N> extends EndpointFluent<EndpointsNested<N>> implements Nested<N>{
  
    EndpointBuilder builder;
    int index;
  
    EndpointsNested(int index,Endpoint item) {
      this.index = index;
      this.builder = new EndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) ServiceMonitorSpecFluent.this.setToEndpoints(index, builder.build());
    }
    
    public N endEndpoint() {
      return and();
    }
    
  }
  public class NamespaceSelectorNested<N> extends NamespaceSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    NamespaceSelectorBuilder builder;
  
    NamespaceSelectorNested(NamespaceSelector item) {
      this.builder = new NamespaceSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ServiceMonitorSpecFluent.this.withNamespaceSelector(builder.build());
    }
    
    public N endNamespaceSelector() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends LabelSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    SelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ServiceMonitorSpecFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}