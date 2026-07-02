package io.fabric8.kubernetes.api.model;

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
public class PodStatusFluent<A extends io.fabric8.kubernetes.api.model.PodStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,Quantity> allocatedResources;
  private ArrayList<PodConditionBuilder> conditions = new ArrayList<PodConditionBuilder>();
  private ArrayList<ContainerStatusBuilder> containerStatuses = new ArrayList<ContainerStatusBuilder>();
  private ArrayList<ContainerStatusBuilder> ephemeralContainerStatuses = new ArrayList<ContainerStatusBuilder>();
  private PodExtendedResourceClaimStatusBuilder extendedResourceClaimStatus;
  private String hostIP;
  private ArrayList<HostIPBuilder> hostIPs = new ArrayList<HostIPBuilder>();
  private ArrayList<ContainerStatusBuilder> initContainerStatuses = new ArrayList<ContainerStatusBuilder>();
  private String message;
  private ArrayList<NodeAllocatableResourceClaimStatusBuilder> nodeAllocatableResourceClaimStatuses = new ArrayList<NodeAllocatableResourceClaimStatusBuilder>();
  private String nominatedNodeName;
  private Long observedGeneration;
  private String phase;
  private String podIP;
  private ArrayList<PodIPBuilder> podIPs = new ArrayList<PodIPBuilder>();
  private String qosClass;
  private String reason;
  private String resize;
  private ArrayList<PodResourceClaimStatusBuilder> resourceClaimStatuses = new ArrayList<PodResourceClaimStatusBuilder>();
  private ResourceRequirementsBuilder resources;
  private String startTime;

  public PodStatusFluent() {
  }
  
  public PodStatusFluent(PodStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<PodCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (PodCondition item : items) {
        PodConditionBuilder builder = new PodConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToContainerStatuses(Collection<ContainerStatus> items) {
    if (this.containerStatuses == null) {
      this.containerStatuses = new ArrayList();
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("containerStatuses").add(builder);
        this.containerStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToEphemeralContainerStatuses(Collection<ContainerStatus> items) {
    if (this.ephemeralContainerStatuses == null) {
      this.ephemeralContainerStatuses = new ArrayList();
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("ephemeralContainerStatuses").add(builder);
        this.ephemeralContainerStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToHostIPs(Collection<HostIP> items) {
    if (this.hostIPs == null) {
      this.hostIPs = new ArrayList();
    }
    for (HostIP item : items) {
        HostIPBuilder builder = new HostIPBuilder(item);
        _visitables.get("hostIPs").add(builder);
        this.hostIPs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToInitContainerStatuses(Collection<ContainerStatus> items) {
    if (this.initContainerStatuses == null) {
      this.initContainerStatuses = new ArrayList();
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("initContainerStatuses").add(builder);
        this.initContainerStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToNodeAllocatableResourceClaimStatuses(Collection<NodeAllocatableResourceClaimStatus> items) {
    if (this.nodeAllocatableResourceClaimStatuses == null) {
      this.nodeAllocatableResourceClaimStatuses = new ArrayList();
    }
    for (NodeAllocatableResourceClaimStatus item : items) {
        NodeAllocatableResourceClaimStatusBuilder builder = new NodeAllocatableResourceClaimStatusBuilder(item);
        _visitables.get("nodeAllocatableResourceClaimStatuses").add(builder);
        this.nodeAllocatableResourceClaimStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPodIPs(Collection<PodIP> items) {
    if (this.podIPs == null) {
      this.podIPs = new ArrayList();
    }
    for (PodIP item : items) {
        PodIPBuilder builder = new PodIPBuilder(item);
        _visitables.get("podIPs").add(builder);
        this.podIPs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResourceClaimStatuses(Collection<PodResourceClaimStatus> items) {
    if (this.resourceClaimStatuses == null) {
      this.resourceClaimStatuses = new ArrayList();
    }
    for (PodResourceClaimStatus item : items) {
        PodResourceClaimStatusBuilder builder = new PodResourceClaimStatusBuilder(item);
        _visitables.get("resourceClaimStatuses").add(builder);
        this.resourceClaimStatuses.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(PodCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public ContainerStatusesNested<A> addNewContainerStatus() {
    return new ContainerStatusesNested(-1, null);
  }
  
  public ContainerStatusesNested<A> addNewContainerStatusLike(ContainerStatus item) {
    return new ContainerStatusesNested(-1, item);
  }
  
  public EphemeralContainerStatusesNested<A> addNewEphemeralContainerStatus() {
    return new EphemeralContainerStatusesNested(-1, null);
  }
  
  public EphemeralContainerStatusesNested<A> addNewEphemeralContainerStatusLike(ContainerStatus item) {
    return new EphemeralContainerStatusesNested(-1, item);
  }
  
  public HostIPsNested<A> addNewHostIP() {
    return new HostIPsNested(-1, null);
  }
  
  public A addNewHostIP(String ip) {
    return (A) this.addToHostIPs(new HostIP(ip));
  }
  
  public HostIPsNested<A> addNewHostIPLike(HostIP item) {
    return new HostIPsNested(-1, item);
  }
  
  public InitContainerStatusesNested<A> addNewInitContainerStatus() {
    return new InitContainerStatusesNested(-1, null);
  }
  
  public InitContainerStatusesNested<A> addNewInitContainerStatusLike(ContainerStatus item) {
    return new InitContainerStatusesNested(-1, item);
  }
  
  public NodeAllocatableResourceClaimStatusesNested<A> addNewNodeAllocatableResourceClaimStatus() {
    return new NodeAllocatableResourceClaimStatusesNested(-1, null);
  }
  
  public NodeAllocatableResourceClaimStatusesNested<A> addNewNodeAllocatableResourceClaimStatusLike(NodeAllocatableResourceClaimStatus item) {
    return new NodeAllocatableResourceClaimStatusesNested(-1, item);
  }
  
  public PodIPsNested<A> addNewPodIP() {
    return new PodIPsNested(-1, null);
  }
  
  public A addNewPodIP(String ip) {
    return (A) this.addToPodIPs(new PodIP(ip));
  }
  
  public PodIPsNested<A> addNewPodIPLike(PodIP item) {
    return new PodIPsNested(-1, item);
  }
  
  public ResourceClaimStatusesNested<A> addNewResourceClaimStatus() {
    return new ResourceClaimStatusesNested(-1, null);
  }
  
  public A addNewResourceClaimStatus(String name,String resourceClaimName) {
    return (A) this.addToResourceClaimStatuses(new PodResourceClaimStatus(name, resourceClaimName));
  }
  
  public ResourceClaimStatusesNested<A> addNewResourceClaimStatusLike(PodResourceClaimStatus item) {
    return new ResourceClaimStatusesNested(-1, item);
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
  
  public A addToAllocatedResources(Map<String,Quantity> map) {
    if (this.allocatedResources == null && map != null) {
      this.allocatedResources = new LinkedHashMap();
    }
    if (map != null) {
      this.allocatedResources.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAllocatedResources(String key,Quantity value) {
    if (this.allocatedResources == null && key != null && value != null) {
      this.allocatedResources = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.allocatedResources.put(key, value);
    }
    return (A) this;
  }
  
  public A addToConditions(PodCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (PodCondition item : items) {
        PodConditionBuilder builder = new PodConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,PodCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    PodConditionBuilder builder = new PodConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToContainerStatuses(ContainerStatus... items) {
    if (this.containerStatuses == null) {
      this.containerStatuses = new ArrayList();
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("containerStatuses").add(builder);
        this.containerStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addToContainerStatuses(int index,ContainerStatus item) {
    if (this.containerStatuses == null) {
      this.containerStatuses = new ArrayList();
    }
    ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
    if (index < 0 || index >= containerStatuses.size()) {
        _visitables.get("containerStatuses").add(builder);
        containerStatuses.add(builder);
    } else {
        _visitables.get("containerStatuses").add(builder);
        containerStatuses.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToEphemeralContainerStatuses(ContainerStatus... items) {
    if (this.ephemeralContainerStatuses == null) {
      this.ephemeralContainerStatuses = new ArrayList();
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("ephemeralContainerStatuses").add(builder);
        this.ephemeralContainerStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addToEphemeralContainerStatuses(int index,ContainerStatus item) {
    if (this.ephemeralContainerStatuses == null) {
      this.ephemeralContainerStatuses = new ArrayList();
    }
    ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
    if (index < 0 || index >= ephemeralContainerStatuses.size()) {
        _visitables.get("ephemeralContainerStatuses").add(builder);
        ephemeralContainerStatuses.add(builder);
    } else {
        _visitables.get("ephemeralContainerStatuses").add(builder);
        ephemeralContainerStatuses.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToHostIPs(HostIP... items) {
    if (this.hostIPs == null) {
      this.hostIPs = new ArrayList();
    }
    for (HostIP item : items) {
        HostIPBuilder builder = new HostIPBuilder(item);
        _visitables.get("hostIPs").add(builder);
        this.hostIPs.add(builder);
    }
    return (A) this;
  }
  
  public A addToHostIPs(int index,HostIP item) {
    if (this.hostIPs == null) {
      this.hostIPs = new ArrayList();
    }
    HostIPBuilder builder = new HostIPBuilder(item);
    if (index < 0 || index >= hostIPs.size()) {
        _visitables.get("hostIPs").add(builder);
        hostIPs.add(builder);
    } else {
        _visitables.get("hostIPs").add(builder);
        hostIPs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToInitContainerStatuses(ContainerStatus... items) {
    if (this.initContainerStatuses == null) {
      this.initContainerStatuses = new ArrayList();
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("initContainerStatuses").add(builder);
        this.initContainerStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addToInitContainerStatuses(int index,ContainerStatus item) {
    if (this.initContainerStatuses == null) {
      this.initContainerStatuses = new ArrayList();
    }
    ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
    if (index < 0 || index >= initContainerStatuses.size()) {
        _visitables.get("initContainerStatuses").add(builder);
        initContainerStatuses.add(builder);
    } else {
        _visitables.get("initContainerStatuses").add(builder);
        initContainerStatuses.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToNodeAllocatableResourceClaimStatuses(NodeAllocatableResourceClaimStatus... items) {
    if (this.nodeAllocatableResourceClaimStatuses == null) {
      this.nodeAllocatableResourceClaimStatuses = new ArrayList();
    }
    for (NodeAllocatableResourceClaimStatus item : items) {
        NodeAllocatableResourceClaimStatusBuilder builder = new NodeAllocatableResourceClaimStatusBuilder(item);
        _visitables.get("nodeAllocatableResourceClaimStatuses").add(builder);
        this.nodeAllocatableResourceClaimStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addToNodeAllocatableResourceClaimStatuses(int index,NodeAllocatableResourceClaimStatus item) {
    if (this.nodeAllocatableResourceClaimStatuses == null) {
      this.nodeAllocatableResourceClaimStatuses = new ArrayList();
    }
    NodeAllocatableResourceClaimStatusBuilder builder = new NodeAllocatableResourceClaimStatusBuilder(item);
    if (index < 0 || index >= nodeAllocatableResourceClaimStatuses.size()) {
        _visitables.get("nodeAllocatableResourceClaimStatuses").add(builder);
        nodeAllocatableResourceClaimStatuses.add(builder);
    } else {
        _visitables.get("nodeAllocatableResourceClaimStatuses").add(builder);
        nodeAllocatableResourceClaimStatuses.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPodIPs(PodIP... items) {
    if (this.podIPs == null) {
      this.podIPs = new ArrayList();
    }
    for (PodIP item : items) {
        PodIPBuilder builder = new PodIPBuilder(item);
        _visitables.get("podIPs").add(builder);
        this.podIPs.add(builder);
    }
    return (A) this;
  }
  
  public A addToPodIPs(int index,PodIP item) {
    if (this.podIPs == null) {
      this.podIPs = new ArrayList();
    }
    PodIPBuilder builder = new PodIPBuilder(item);
    if (index < 0 || index >= podIPs.size()) {
        _visitables.get("podIPs").add(builder);
        podIPs.add(builder);
    } else {
        _visitables.get("podIPs").add(builder);
        podIPs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResourceClaimStatuses(PodResourceClaimStatus... items) {
    if (this.resourceClaimStatuses == null) {
      this.resourceClaimStatuses = new ArrayList();
    }
    for (PodResourceClaimStatus item : items) {
        PodResourceClaimStatusBuilder builder = new PodResourceClaimStatusBuilder(item);
        _visitables.get("resourceClaimStatuses").add(builder);
        this.resourceClaimStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addToResourceClaimStatuses(int index,PodResourceClaimStatus item) {
    if (this.resourceClaimStatuses == null) {
      this.resourceClaimStatuses = new ArrayList();
    }
    PodResourceClaimStatusBuilder builder = new PodResourceClaimStatusBuilder(item);
    if (index < 0 || index >= resourceClaimStatuses.size()) {
        _visitables.get("resourceClaimStatuses").add(builder);
        resourceClaimStatuses.add(builder);
    } else {
        _visitables.get("resourceClaimStatuses").add(builder);
        resourceClaimStatuses.add(index, builder);
    }
    return (A) this;
  }
  
  public PodCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<PodCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public ContainerStatus buildContainerStatus(int index) {
    return this.containerStatuses.get(index).build();
  }
  
  public List<ContainerStatus> buildContainerStatuses() {
    return this.containerStatuses != null ? build(containerStatuses) : null;
  }
  
  public ContainerStatus buildEphemeralContainerStatus(int index) {
    return this.ephemeralContainerStatuses.get(index).build();
  }
  
  public List<ContainerStatus> buildEphemeralContainerStatuses() {
    return this.ephemeralContainerStatuses != null ? build(ephemeralContainerStatuses) : null;
  }
  
  public PodExtendedResourceClaimStatus buildExtendedResourceClaimStatus() {
    return this.extendedResourceClaimStatus != null ? this.extendedResourceClaimStatus.build() : null;
  }
  
  public PodCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public ContainerStatus buildFirstContainerStatus() {
    return this.containerStatuses.get(0).build();
  }
  
  public ContainerStatus buildFirstEphemeralContainerStatus() {
    return this.ephemeralContainerStatuses.get(0).build();
  }
  
  public HostIP buildFirstHostIP() {
    return this.hostIPs.get(0).build();
  }
  
  public ContainerStatus buildFirstInitContainerStatus() {
    return this.initContainerStatuses.get(0).build();
  }
  
  public NodeAllocatableResourceClaimStatus buildFirstNodeAllocatableResourceClaimStatus() {
    return this.nodeAllocatableResourceClaimStatuses.get(0).build();
  }
  
  public PodIP buildFirstPodIP() {
    return this.podIPs.get(0).build();
  }
  
  public PodResourceClaimStatus buildFirstResourceClaimStatus() {
    return this.resourceClaimStatuses.get(0).build();
  }
  
  public HostIP buildHostIP(int index) {
    return this.hostIPs.get(index).build();
  }
  
  public List<HostIP> buildHostIPs() {
    return this.hostIPs != null ? build(hostIPs) : null;
  }
  
  public ContainerStatus buildInitContainerStatus(int index) {
    return this.initContainerStatuses.get(index).build();
  }
  
  public List<ContainerStatus> buildInitContainerStatuses() {
    return this.initContainerStatuses != null ? build(initContainerStatuses) : null;
  }
  
  public PodCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public ContainerStatus buildLastContainerStatus() {
    return this.containerStatuses.get(containerStatuses.size() - 1).build();
  }
  
  public ContainerStatus buildLastEphemeralContainerStatus() {
    return this.ephemeralContainerStatuses.get(ephemeralContainerStatuses.size() - 1).build();
  }
  
  public HostIP buildLastHostIP() {
    return this.hostIPs.get(hostIPs.size() - 1).build();
  }
  
  public ContainerStatus buildLastInitContainerStatus() {
    return this.initContainerStatuses.get(initContainerStatuses.size() - 1).build();
  }
  
  public NodeAllocatableResourceClaimStatus buildLastNodeAllocatableResourceClaimStatus() {
    return this.nodeAllocatableResourceClaimStatuses.get(nodeAllocatableResourceClaimStatuses.size() - 1).build();
  }
  
  public PodIP buildLastPodIP() {
    return this.podIPs.get(podIPs.size() - 1).build();
  }
  
  public PodResourceClaimStatus buildLastResourceClaimStatus() {
    return this.resourceClaimStatuses.get(resourceClaimStatuses.size() - 1).build();
  }
  
  public PodCondition buildMatchingCondition(Predicate<PodConditionBuilder> predicate) {
      for (PodConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ContainerStatus buildMatchingContainerStatus(Predicate<ContainerStatusBuilder> predicate) {
      for (ContainerStatusBuilder item : containerStatuses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ContainerStatus buildMatchingEphemeralContainerStatus(Predicate<ContainerStatusBuilder> predicate) {
      for (ContainerStatusBuilder item : ephemeralContainerStatuses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HostIP buildMatchingHostIP(Predicate<HostIPBuilder> predicate) {
      for (HostIPBuilder item : hostIPs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ContainerStatus buildMatchingInitContainerStatus(Predicate<ContainerStatusBuilder> predicate) {
      for (ContainerStatusBuilder item : initContainerStatuses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NodeAllocatableResourceClaimStatus buildMatchingNodeAllocatableResourceClaimStatus(Predicate<NodeAllocatableResourceClaimStatusBuilder> predicate) {
      for (NodeAllocatableResourceClaimStatusBuilder item : nodeAllocatableResourceClaimStatuses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PodIP buildMatchingPodIP(Predicate<PodIPBuilder> predicate) {
      for (PodIPBuilder item : podIPs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PodResourceClaimStatus buildMatchingResourceClaimStatus(Predicate<PodResourceClaimStatusBuilder> predicate) {
      for (PodResourceClaimStatusBuilder item : resourceClaimStatuses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NodeAllocatableResourceClaimStatus buildNodeAllocatableResourceClaimStatus(int index) {
    return this.nodeAllocatableResourceClaimStatuses.get(index).build();
  }
  
  public List<NodeAllocatableResourceClaimStatus> buildNodeAllocatableResourceClaimStatuses() {
    return this.nodeAllocatableResourceClaimStatuses != null ? build(nodeAllocatableResourceClaimStatuses) : null;
  }
  
  public PodIP buildPodIP(int index) {
    return this.podIPs.get(index).build();
  }
  
  public List<PodIP> buildPodIPs() {
    return this.podIPs != null ? build(podIPs) : null;
  }
  
  public PodResourceClaimStatus buildResourceClaimStatus(int index) {
    return this.resourceClaimStatuses.get(index).build();
  }
  
  public List<PodResourceClaimStatus> buildResourceClaimStatuses() {
    return this.resourceClaimStatuses != null ? build(resourceClaimStatuses) : null;
  }
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  protected void copyInstance(PodStatus instance) {
    instance = instance != null ? instance : new PodStatus();
    if (instance != null) {
        this.withAllocatedResources(instance.getAllocatedResources());
        this.withConditions(instance.getConditions());
        this.withContainerStatuses(instance.getContainerStatuses());
        this.withEphemeralContainerStatuses(instance.getEphemeralContainerStatuses());
        this.withExtendedResourceClaimStatus(instance.getExtendedResourceClaimStatus());
        this.withHostIP(instance.getHostIP());
        this.withHostIPs(instance.getHostIPs());
        this.withInitContainerStatuses(instance.getInitContainerStatuses());
        this.withMessage(instance.getMessage());
        this.withNodeAllocatableResourceClaimStatuses(instance.getNodeAllocatableResourceClaimStatuses());
        this.withNominatedNodeName(instance.getNominatedNodeName());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withPhase(instance.getPhase());
        this.withPodIP(instance.getPodIP());
        this.withPodIPs(instance.getPodIPs());
        this.withQosClass(instance.getQosClass());
        this.withReason(instance.getReason());
        this.withResize(instance.getResize());
        this.withResourceClaimStatuses(instance.getResourceClaimStatuses());
        this.withResources(instance.getResources());
        this.withStartTime(instance.getStartTime());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ContainerStatusesNested<A> editContainerStatus(int index) {
    if (containerStatuses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "containerStatuses"));
    }
    return this.setNewContainerStatusLike(index, this.buildContainerStatus(index));
  }
  
  public EphemeralContainerStatusesNested<A> editEphemeralContainerStatus(int index) {
    if (ephemeralContainerStatuses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ephemeralContainerStatuses"));
    }
    return this.setNewEphemeralContainerStatusLike(index, this.buildEphemeralContainerStatus(index));
  }
  
  public ExtendedResourceClaimStatusNested<A> editExtendedResourceClaimStatus() {
    return this.withNewExtendedResourceClaimStatusLike(Optional.ofNullable(this.buildExtendedResourceClaimStatus()).orElse(null));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public ContainerStatusesNested<A> editFirstContainerStatus() {
    if (containerStatuses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "containerStatuses"));
    }
    return this.setNewContainerStatusLike(0, this.buildContainerStatus(0));
  }
  
  public EphemeralContainerStatusesNested<A> editFirstEphemeralContainerStatus() {
    if (ephemeralContainerStatuses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ephemeralContainerStatuses"));
    }
    return this.setNewEphemeralContainerStatusLike(0, this.buildEphemeralContainerStatus(0));
  }
  
  public HostIPsNested<A> editFirstHostIP() {
    if (hostIPs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "hostIPs"));
    }
    return this.setNewHostIPLike(0, this.buildHostIP(0));
  }
  
  public InitContainerStatusesNested<A> editFirstInitContainerStatus() {
    if (initContainerStatuses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "initContainerStatuses"));
    }
    return this.setNewInitContainerStatusLike(0, this.buildInitContainerStatus(0));
  }
  
  public NodeAllocatableResourceClaimStatusesNested<A> editFirstNodeAllocatableResourceClaimStatus() {
    if (nodeAllocatableResourceClaimStatuses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "nodeAllocatableResourceClaimStatuses"));
    }
    return this.setNewNodeAllocatableResourceClaimStatusLike(0, this.buildNodeAllocatableResourceClaimStatus(0));
  }
  
  public PodIPsNested<A> editFirstPodIP() {
    if (podIPs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "podIPs"));
    }
    return this.setNewPodIPLike(0, this.buildPodIP(0));
  }
  
  public ResourceClaimStatusesNested<A> editFirstResourceClaimStatus() {
    if (resourceClaimStatuses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resourceClaimStatuses"));
    }
    return this.setNewResourceClaimStatusLike(0, this.buildResourceClaimStatus(0));
  }
  
  public HostIPsNested<A> editHostIP(int index) {
    if (hostIPs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "hostIPs"));
    }
    return this.setNewHostIPLike(index, this.buildHostIP(index));
  }
  
  public InitContainerStatusesNested<A> editInitContainerStatus(int index) {
    if (initContainerStatuses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "initContainerStatuses"));
    }
    return this.setNewInitContainerStatusLike(index, this.buildInitContainerStatus(index));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ContainerStatusesNested<A> editLastContainerStatus() {
    int index = containerStatuses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "containerStatuses"));
    }
    return this.setNewContainerStatusLike(index, this.buildContainerStatus(index));
  }
  
  public EphemeralContainerStatusesNested<A> editLastEphemeralContainerStatus() {
    int index = ephemeralContainerStatuses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ephemeralContainerStatuses"));
    }
    return this.setNewEphemeralContainerStatusLike(index, this.buildEphemeralContainerStatus(index));
  }
  
  public HostIPsNested<A> editLastHostIP() {
    int index = hostIPs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "hostIPs"));
    }
    return this.setNewHostIPLike(index, this.buildHostIP(index));
  }
  
  public InitContainerStatusesNested<A> editLastInitContainerStatus() {
    int index = initContainerStatuses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "initContainerStatuses"));
    }
    return this.setNewInitContainerStatusLike(index, this.buildInitContainerStatus(index));
  }
  
  public NodeAllocatableResourceClaimStatusesNested<A> editLastNodeAllocatableResourceClaimStatus() {
    int index = nodeAllocatableResourceClaimStatuses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "nodeAllocatableResourceClaimStatuses"));
    }
    return this.setNewNodeAllocatableResourceClaimStatusLike(index, this.buildNodeAllocatableResourceClaimStatus(index));
  }
  
  public PodIPsNested<A> editLastPodIP() {
    int index = podIPs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "podIPs"));
    }
    return this.setNewPodIPLike(index, this.buildPodIP(index));
  }
  
  public ResourceClaimStatusesNested<A> editLastResourceClaimStatus() {
    int index = resourceClaimStatuses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resourceClaimStatuses"));
    }
    return this.setNewResourceClaimStatusLike(index, this.buildResourceClaimStatus(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<PodConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ContainerStatusesNested<A> editMatchingContainerStatus(Predicate<ContainerStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < containerStatuses.size();i++) {
      if (predicate.test(containerStatuses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "containerStatuses"));
    }
    return this.setNewContainerStatusLike(index, this.buildContainerStatus(index));
  }
  
  public EphemeralContainerStatusesNested<A> editMatchingEphemeralContainerStatus(Predicate<ContainerStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ephemeralContainerStatuses.size();i++) {
      if (predicate.test(ephemeralContainerStatuses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ephemeralContainerStatuses"));
    }
    return this.setNewEphemeralContainerStatusLike(index, this.buildEphemeralContainerStatus(index));
  }
  
  public HostIPsNested<A> editMatchingHostIP(Predicate<HostIPBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < hostIPs.size();i++) {
      if (predicate.test(hostIPs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "hostIPs"));
    }
    return this.setNewHostIPLike(index, this.buildHostIP(index));
  }
  
  public InitContainerStatusesNested<A> editMatchingInitContainerStatus(Predicate<ContainerStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < initContainerStatuses.size();i++) {
      if (predicate.test(initContainerStatuses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "initContainerStatuses"));
    }
    return this.setNewInitContainerStatusLike(index, this.buildInitContainerStatus(index));
  }
  
  public NodeAllocatableResourceClaimStatusesNested<A> editMatchingNodeAllocatableResourceClaimStatus(Predicate<NodeAllocatableResourceClaimStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < nodeAllocatableResourceClaimStatuses.size();i++) {
      if (predicate.test(nodeAllocatableResourceClaimStatuses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "nodeAllocatableResourceClaimStatuses"));
    }
    return this.setNewNodeAllocatableResourceClaimStatusLike(index, this.buildNodeAllocatableResourceClaimStatus(index));
  }
  
  public PodIPsNested<A> editMatchingPodIP(Predicate<PodIPBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < podIPs.size();i++) {
      if (predicate.test(podIPs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "podIPs"));
    }
    return this.setNewPodIPLike(index, this.buildPodIP(index));
  }
  
  public ResourceClaimStatusesNested<A> editMatchingResourceClaimStatus(Predicate<PodResourceClaimStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resourceClaimStatuses.size();i++) {
      if (predicate.test(resourceClaimStatuses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resourceClaimStatuses"));
    }
    return this.setNewResourceClaimStatusLike(index, this.buildResourceClaimStatus(index));
  }
  
  public NodeAllocatableResourceClaimStatusesNested<A> editNodeAllocatableResourceClaimStatus(int index) {
    if (nodeAllocatableResourceClaimStatuses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "nodeAllocatableResourceClaimStatuses"));
    }
    return this.setNewNodeAllocatableResourceClaimStatusLike(index, this.buildNodeAllocatableResourceClaimStatus(index));
  }
  
  public ExtendedResourceClaimStatusNested<A> editOrNewExtendedResourceClaimStatus() {
    return this.withNewExtendedResourceClaimStatusLike(Optional.ofNullable(this.buildExtendedResourceClaimStatus()).orElse(new PodExtendedResourceClaimStatusBuilder().build()));
  }
  
  public ExtendedResourceClaimStatusNested<A> editOrNewExtendedResourceClaimStatusLike(PodExtendedResourceClaimStatus item) {
    return this.withNewExtendedResourceClaimStatusLike(Optional.ofNullable(this.buildExtendedResourceClaimStatus()).orElse(item));
  }
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(ResourceRequirements item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public PodIPsNested<A> editPodIP(int index) {
    if (podIPs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "podIPs"));
    }
    return this.setNewPodIPLike(index, this.buildPodIP(index));
  }
  
  public ResourceClaimStatusesNested<A> editResourceClaimStatus(int index) {
    if (resourceClaimStatuses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resourceClaimStatuses"));
    }
    return this.setNewResourceClaimStatusLike(index, this.buildResourceClaimStatus(index));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
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
    PodStatusFluent that = (PodStatusFluent) o;
    if (!(Objects.equals(allocatedResources, that.allocatedResources))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(containerStatuses, that.containerStatuses))) {
      return false;
    }
    if (!(Objects.equals(ephemeralContainerStatuses, that.ephemeralContainerStatuses))) {
      return false;
    }
    if (!(Objects.equals(extendedResourceClaimStatus, that.extendedResourceClaimStatus))) {
      return false;
    }
    if (!(Objects.equals(hostIP, that.hostIP))) {
      return false;
    }
    if (!(Objects.equals(hostIPs, that.hostIPs))) {
      return false;
    }
    if (!(Objects.equals(initContainerStatuses, that.initContainerStatuses))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(nodeAllocatableResourceClaimStatuses, that.nodeAllocatableResourceClaimStatuses))) {
      return false;
    }
    if (!(Objects.equals(nominatedNodeName, that.nominatedNodeName))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
      return false;
    }
    if (!(Objects.equals(podIP, that.podIP))) {
      return false;
    }
    if (!(Objects.equals(podIPs, that.podIPs))) {
      return false;
    }
    if (!(Objects.equals(qosClass, that.qosClass))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
      return false;
    }
    if (!(Objects.equals(resize, that.resize))) {
      return false;
    }
    if (!(Objects.equals(resourceClaimStatuses, that.resourceClaimStatuses))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(startTime, that.startTime))) {
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
  
  public Map<String,Quantity> getAllocatedResources() {
    return this.allocatedResources;
  }
  
  public String getHostIP() {
    return this.hostIP;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getNominatedNodeName() {
    return this.nominatedNodeName;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public String getPhase() {
    return this.phase;
  }
  
  public String getPodIP() {
    return this.podIP;
  }
  
  public String getQosClass() {
    return this.qosClass;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public String getResize() {
    return this.resize;
  }
  
  public String getStartTime() {
    return this.startTime;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllocatedResources() {
    return this.allocatedResources != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasContainerStatuses() {
    return this.containerStatuses != null && !(this.containerStatuses.isEmpty());
  }
  
  public boolean hasEphemeralContainerStatuses() {
    return this.ephemeralContainerStatuses != null && !(this.ephemeralContainerStatuses.isEmpty());
  }
  
  public boolean hasExtendedResourceClaimStatus() {
    return this.extendedResourceClaimStatus != null;
  }
  
  public boolean hasHostIP() {
    return this.hostIP != null;
  }
  
  public boolean hasHostIPs() {
    return this.hostIPs != null && !(this.hostIPs.isEmpty());
  }
  
  public boolean hasInitContainerStatuses() {
    return this.initContainerStatuses != null && !(this.initContainerStatuses.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<PodConditionBuilder> predicate) {
      for (PodConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingContainerStatus(Predicate<ContainerStatusBuilder> predicate) {
      for (ContainerStatusBuilder item : containerStatuses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEphemeralContainerStatus(Predicate<ContainerStatusBuilder> predicate) {
      for (ContainerStatusBuilder item : ephemeralContainerStatuses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingHostIP(Predicate<HostIPBuilder> predicate) {
      for (HostIPBuilder item : hostIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingInitContainerStatus(Predicate<ContainerStatusBuilder> predicate) {
      for (ContainerStatusBuilder item : initContainerStatuses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNodeAllocatableResourceClaimStatus(Predicate<NodeAllocatableResourceClaimStatusBuilder> predicate) {
      for (NodeAllocatableResourceClaimStatusBuilder item : nodeAllocatableResourceClaimStatuses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPodIP(Predicate<PodIPBuilder> predicate) {
      for (PodIPBuilder item : podIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResourceClaimStatus(Predicate<PodResourceClaimStatusBuilder> predicate) {
      for (PodResourceClaimStatusBuilder item : resourceClaimStatuses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasNodeAllocatableResourceClaimStatuses() {
    return this.nodeAllocatableResourceClaimStatuses != null && !(this.nodeAllocatableResourceClaimStatuses.isEmpty());
  }
  
  public boolean hasNominatedNodeName() {
    return this.nominatedNodeName != null;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public boolean hasPodIP() {
    return this.podIP != null;
  }
  
  public boolean hasPodIPs() {
    return this.podIPs != null && !(this.podIPs.isEmpty());
  }
  
  public boolean hasQosClass() {
    return this.qosClass != null;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public boolean hasResize() {
    return this.resize != null;
  }
  
  public boolean hasResourceClaimStatuses() {
    return this.resourceClaimStatuses != null && !(this.resourceClaimStatuses.isEmpty());
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasStartTime() {
    return this.startTime != null;
  }
  
  public int hashCode() {
    return Objects.hash(allocatedResources, conditions, containerStatuses, ephemeralContainerStatuses, extendedResourceClaimStatus, hostIP, hostIPs, initContainerStatuses, message, nodeAllocatableResourceClaimStatuses, nominatedNodeName, observedGeneration, phase, podIP, podIPs, qosClass, reason, resize, resourceClaimStatuses, resources, startTime, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<PodCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (PodCondition item : items) {
        PodConditionBuilder builder = new PodConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromContainerStatuses(Collection<ContainerStatus> items) {
    if (this.containerStatuses == null) {
      return (A) this;
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("containerStatuses").remove(builder);
        this.containerStatuses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromEphemeralContainerStatuses(Collection<ContainerStatus> items) {
    if (this.ephemeralContainerStatuses == null) {
      return (A) this;
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("ephemeralContainerStatuses").remove(builder);
        this.ephemeralContainerStatuses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromHostIPs(Collection<HostIP> items) {
    if (this.hostIPs == null) {
      return (A) this;
    }
    for (HostIP item : items) {
        HostIPBuilder builder = new HostIPBuilder(item);
        _visitables.get("hostIPs").remove(builder);
        this.hostIPs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromInitContainerStatuses(Collection<ContainerStatus> items) {
    if (this.initContainerStatuses == null) {
      return (A) this;
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("initContainerStatuses").remove(builder);
        this.initContainerStatuses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromNodeAllocatableResourceClaimStatuses(Collection<NodeAllocatableResourceClaimStatus> items) {
    if (this.nodeAllocatableResourceClaimStatuses == null) {
      return (A) this;
    }
    for (NodeAllocatableResourceClaimStatus item : items) {
        NodeAllocatableResourceClaimStatusBuilder builder = new NodeAllocatableResourceClaimStatusBuilder(item);
        _visitables.get("nodeAllocatableResourceClaimStatuses").remove(builder);
        this.nodeAllocatableResourceClaimStatuses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPodIPs(Collection<PodIP> items) {
    if (this.podIPs == null) {
      return (A) this;
    }
    for (PodIP item : items) {
        PodIPBuilder builder = new PodIPBuilder(item);
        _visitables.get("podIPs").remove(builder);
        this.podIPs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResourceClaimStatuses(Collection<PodResourceClaimStatus> items) {
    if (this.resourceClaimStatuses == null) {
      return (A) this;
    }
    for (PodResourceClaimStatus item : items) {
        PodResourceClaimStatusBuilder builder = new PodResourceClaimStatusBuilder(item);
        _visitables.get("resourceClaimStatuses").remove(builder);
        this.resourceClaimStatuses.remove(builder);
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
  
  public A removeFromAllocatedResources(String key) {
    if (this.allocatedResources == null) {
      return (A) this;
    }
    if (key != null && this.allocatedResources != null) {
      this.allocatedResources.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAllocatedResources(Map<String,Quantity> map) {
    if (this.allocatedResources == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.allocatedResources != null) {
          this.allocatedResources.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromConditions(PodCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (PodCondition item : items) {
        PodConditionBuilder builder = new PodConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromContainerStatuses(ContainerStatus... items) {
    if (this.containerStatuses == null) {
      return (A) this;
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("containerStatuses").remove(builder);
        this.containerStatuses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromEphemeralContainerStatuses(ContainerStatus... items) {
    if (this.ephemeralContainerStatuses == null) {
      return (A) this;
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("ephemeralContainerStatuses").remove(builder);
        this.ephemeralContainerStatuses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromHostIPs(HostIP... items) {
    if (this.hostIPs == null) {
      return (A) this;
    }
    for (HostIP item : items) {
        HostIPBuilder builder = new HostIPBuilder(item);
        _visitables.get("hostIPs").remove(builder);
        this.hostIPs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromInitContainerStatuses(ContainerStatus... items) {
    if (this.initContainerStatuses == null) {
      return (A) this;
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("initContainerStatuses").remove(builder);
        this.initContainerStatuses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromNodeAllocatableResourceClaimStatuses(NodeAllocatableResourceClaimStatus... items) {
    if (this.nodeAllocatableResourceClaimStatuses == null) {
      return (A) this;
    }
    for (NodeAllocatableResourceClaimStatus item : items) {
        NodeAllocatableResourceClaimStatusBuilder builder = new NodeAllocatableResourceClaimStatusBuilder(item);
        _visitables.get("nodeAllocatableResourceClaimStatuses").remove(builder);
        this.nodeAllocatableResourceClaimStatuses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPodIPs(PodIP... items) {
    if (this.podIPs == null) {
      return (A) this;
    }
    for (PodIP item : items) {
        PodIPBuilder builder = new PodIPBuilder(item);
        _visitables.get("podIPs").remove(builder);
        this.podIPs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResourceClaimStatuses(PodResourceClaimStatus... items) {
    if (this.resourceClaimStatuses == null) {
      return (A) this;
    }
    for (PodResourceClaimStatus item : items) {
        PodResourceClaimStatusBuilder builder = new PodResourceClaimStatusBuilder(item);
        _visitables.get("resourceClaimStatuses").remove(builder);
        this.resourceClaimStatuses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<PodConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<PodConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        PodConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromContainerStatuses(Predicate<ContainerStatusBuilder> predicate) {
    if (containerStatuses == null) {
      return (A) this;
    }
    Iterator<ContainerStatusBuilder> each = containerStatuses.iterator();
    List visitables = _visitables.get("containerStatuses");
    while (each.hasNext()) {
        ContainerStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromEphemeralContainerStatuses(Predicate<ContainerStatusBuilder> predicate) {
    if (ephemeralContainerStatuses == null) {
      return (A) this;
    }
    Iterator<ContainerStatusBuilder> each = ephemeralContainerStatuses.iterator();
    List visitables = _visitables.get("ephemeralContainerStatuses");
    while (each.hasNext()) {
        ContainerStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromHostIPs(Predicate<HostIPBuilder> predicate) {
    if (hostIPs == null) {
      return (A) this;
    }
    Iterator<HostIPBuilder> each = hostIPs.iterator();
    List visitables = _visitables.get("hostIPs");
    while (each.hasNext()) {
        HostIPBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromInitContainerStatuses(Predicate<ContainerStatusBuilder> predicate) {
    if (initContainerStatuses == null) {
      return (A) this;
    }
    Iterator<ContainerStatusBuilder> each = initContainerStatuses.iterator();
    List visitables = _visitables.get("initContainerStatuses");
    while (each.hasNext()) {
        ContainerStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromNodeAllocatableResourceClaimStatuses(Predicate<NodeAllocatableResourceClaimStatusBuilder> predicate) {
    if (nodeAllocatableResourceClaimStatuses == null) {
      return (A) this;
    }
    Iterator<NodeAllocatableResourceClaimStatusBuilder> each = nodeAllocatableResourceClaimStatuses.iterator();
    List visitables = _visitables.get("nodeAllocatableResourceClaimStatuses");
    while (each.hasNext()) {
        NodeAllocatableResourceClaimStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPodIPs(Predicate<PodIPBuilder> predicate) {
    if (podIPs == null) {
      return (A) this;
    }
    Iterator<PodIPBuilder> each = podIPs.iterator();
    List visitables = _visitables.get("podIPs");
    while (each.hasNext()) {
        PodIPBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResourceClaimStatuses(Predicate<PodResourceClaimStatusBuilder> predicate) {
    if (resourceClaimStatuses == null) {
      return (A) this;
    }
    Iterator<PodResourceClaimStatusBuilder> each = resourceClaimStatuses.iterator();
    List visitables = _visitables.get("resourceClaimStatuses");
    while (each.hasNext()) {
        PodResourceClaimStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,PodCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public ContainerStatusesNested<A> setNewContainerStatusLike(int index,ContainerStatus item) {
    return new ContainerStatusesNested(index, item);
  }
  
  public EphemeralContainerStatusesNested<A> setNewEphemeralContainerStatusLike(int index,ContainerStatus item) {
    return new EphemeralContainerStatusesNested(index, item);
  }
  
  public HostIPsNested<A> setNewHostIPLike(int index,HostIP item) {
    return new HostIPsNested(index, item);
  }
  
  public InitContainerStatusesNested<A> setNewInitContainerStatusLike(int index,ContainerStatus item) {
    return new InitContainerStatusesNested(index, item);
  }
  
  public NodeAllocatableResourceClaimStatusesNested<A> setNewNodeAllocatableResourceClaimStatusLike(int index,NodeAllocatableResourceClaimStatus item) {
    return new NodeAllocatableResourceClaimStatusesNested(index, item);
  }
  
  public PodIPsNested<A> setNewPodIPLike(int index,PodIP item) {
    return new PodIPsNested(index, item);
  }
  
  public ResourceClaimStatusesNested<A> setNewResourceClaimStatusLike(int index,PodResourceClaimStatus item) {
    return new ResourceClaimStatusesNested(index, item);
  }
  
  public A setToConditions(int index,PodCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    PodConditionBuilder builder = new PodConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToContainerStatuses(int index,ContainerStatus item) {
    if (this.containerStatuses == null) {
      this.containerStatuses = new ArrayList();
    }
    ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
    if (index < 0 || index >= containerStatuses.size()) {
        _visitables.get("containerStatuses").add(builder);
        containerStatuses.add(builder);
    } else {
        _visitables.get("containerStatuses").add(builder);
        containerStatuses.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToEphemeralContainerStatuses(int index,ContainerStatus item) {
    if (this.ephemeralContainerStatuses == null) {
      this.ephemeralContainerStatuses = new ArrayList();
    }
    ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
    if (index < 0 || index >= ephemeralContainerStatuses.size()) {
        _visitables.get("ephemeralContainerStatuses").add(builder);
        ephemeralContainerStatuses.add(builder);
    } else {
        _visitables.get("ephemeralContainerStatuses").add(builder);
        ephemeralContainerStatuses.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToHostIPs(int index,HostIP item) {
    if (this.hostIPs == null) {
      this.hostIPs = new ArrayList();
    }
    HostIPBuilder builder = new HostIPBuilder(item);
    if (index < 0 || index >= hostIPs.size()) {
        _visitables.get("hostIPs").add(builder);
        hostIPs.add(builder);
    } else {
        _visitables.get("hostIPs").add(builder);
        hostIPs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToInitContainerStatuses(int index,ContainerStatus item) {
    if (this.initContainerStatuses == null) {
      this.initContainerStatuses = new ArrayList();
    }
    ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
    if (index < 0 || index >= initContainerStatuses.size()) {
        _visitables.get("initContainerStatuses").add(builder);
        initContainerStatuses.add(builder);
    } else {
        _visitables.get("initContainerStatuses").add(builder);
        initContainerStatuses.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToNodeAllocatableResourceClaimStatuses(int index,NodeAllocatableResourceClaimStatus item) {
    if (this.nodeAllocatableResourceClaimStatuses == null) {
      this.nodeAllocatableResourceClaimStatuses = new ArrayList();
    }
    NodeAllocatableResourceClaimStatusBuilder builder = new NodeAllocatableResourceClaimStatusBuilder(item);
    if (index < 0 || index >= nodeAllocatableResourceClaimStatuses.size()) {
        _visitables.get("nodeAllocatableResourceClaimStatuses").add(builder);
        nodeAllocatableResourceClaimStatuses.add(builder);
    } else {
        _visitables.get("nodeAllocatableResourceClaimStatuses").add(builder);
        nodeAllocatableResourceClaimStatuses.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPodIPs(int index,PodIP item) {
    if (this.podIPs == null) {
      this.podIPs = new ArrayList();
    }
    PodIPBuilder builder = new PodIPBuilder(item);
    if (index < 0 || index >= podIPs.size()) {
        _visitables.get("podIPs").add(builder);
        podIPs.add(builder);
    } else {
        _visitables.get("podIPs").add(builder);
        podIPs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResourceClaimStatuses(int index,PodResourceClaimStatus item) {
    if (this.resourceClaimStatuses == null) {
      this.resourceClaimStatuses = new ArrayList();
    }
    PodResourceClaimStatusBuilder builder = new PodResourceClaimStatusBuilder(item);
    if (index < 0 || index >= resourceClaimStatuses.size()) {
        _visitables.get("resourceClaimStatuses").add(builder);
        resourceClaimStatuses.add(builder);
    } else {
        _visitables.get("resourceClaimStatuses").add(builder);
        resourceClaimStatuses.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(allocatedResources == null) && !(allocatedResources.isEmpty())) {
        sb.append("allocatedResources:");
        sb.append(allocatedResources);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(containerStatuses == null) && !(containerStatuses.isEmpty())) {
        sb.append("containerStatuses:");
        sb.append(containerStatuses);
        sb.append(",");
    }
    if (!(ephemeralContainerStatuses == null) && !(ephemeralContainerStatuses.isEmpty())) {
        sb.append("ephemeralContainerStatuses:");
        sb.append(ephemeralContainerStatuses);
        sb.append(",");
    }
    if (!(extendedResourceClaimStatus == null)) {
        sb.append("extendedResourceClaimStatus:");
        sb.append(extendedResourceClaimStatus);
        sb.append(",");
    }
    if (!(hostIP == null)) {
        sb.append("hostIP:");
        sb.append(hostIP);
        sb.append(",");
    }
    if (!(hostIPs == null) && !(hostIPs.isEmpty())) {
        sb.append("hostIPs:");
        sb.append(hostIPs);
        sb.append(",");
    }
    if (!(initContainerStatuses == null) && !(initContainerStatuses.isEmpty())) {
        sb.append("initContainerStatuses:");
        sb.append(initContainerStatuses);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(nodeAllocatableResourceClaimStatuses == null) && !(nodeAllocatableResourceClaimStatuses.isEmpty())) {
        sb.append("nodeAllocatableResourceClaimStatuses:");
        sb.append(nodeAllocatableResourceClaimStatuses);
        sb.append(",");
    }
    if (!(nominatedNodeName == null)) {
        sb.append("nominatedNodeName:");
        sb.append(nominatedNodeName);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
        sb.append(",");
    }
    if (!(podIP == null)) {
        sb.append("podIP:");
        sb.append(podIP);
        sb.append(",");
    }
    if (!(podIPs == null) && !(podIPs.isEmpty())) {
        sb.append("podIPs:");
        sb.append(podIPs);
        sb.append(",");
    }
    if (!(qosClass == null)) {
        sb.append("qosClass:");
        sb.append(qosClass);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
        sb.append(",");
    }
    if (!(resize == null)) {
        sb.append("resize:");
        sb.append(resize);
        sb.append(",");
    }
    if (!(resourceClaimStatuses == null) && !(resourceClaimStatuses.isEmpty())) {
        sb.append("resourceClaimStatuses:");
        sb.append(resourceClaimStatuses);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(startTime == null)) {
        sb.append("startTime:");
        sb.append(startTime);
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
  
  public <K,V>A withAllocatedResources(Map<String,Quantity> allocatedResources) {
    if (allocatedResources == null) {
      this.allocatedResources = null;
    } else {
      this.allocatedResources = new LinkedHashMap(allocatedResources);
    }
    return (A) this;
  }
  
  public A withConditions(List<PodCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (PodCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(PodCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (PodCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withContainerStatuses(List<ContainerStatus> containerStatuses) {
    if (this.containerStatuses != null) {
      this._visitables.get("containerStatuses").clear();
    }
    if (containerStatuses != null) {
        this.containerStatuses = new ArrayList();
        for (ContainerStatus item : containerStatuses) {
          this.addToContainerStatuses(item);
        }
    } else {
      this.containerStatuses = null;
    }
    return (A) this;
  }
  
  public A withContainerStatuses(ContainerStatus... containerStatuses) {
    if (this.containerStatuses != null) {
        this.containerStatuses.clear();
        _visitables.remove("containerStatuses");
    }
    if (containerStatuses != null) {
      for (ContainerStatus item : containerStatuses) {
        this.addToContainerStatuses(item);
      }
    }
    return (A) this;
  }
  
  public A withEphemeralContainerStatuses(List<ContainerStatus> ephemeralContainerStatuses) {
    if (this.ephemeralContainerStatuses != null) {
      this._visitables.get("ephemeralContainerStatuses").clear();
    }
    if (ephemeralContainerStatuses != null) {
        this.ephemeralContainerStatuses = new ArrayList();
        for (ContainerStatus item : ephemeralContainerStatuses) {
          this.addToEphemeralContainerStatuses(item);
        }
    } else {
      this.ephemeralContainerStatuses = null;
    }
    return (A) this;
  }
  
  public A withEphemeralContainerStatuses(ContainerStatus... ephemeralContainerStatuses) {
    if (this.ephemeralContainerStatuses != null) {
        this.ephemeralContainerStatuses.clear();
        _visitables.remove("ephemeralContainerStatuses");
    }
    if (ephemeralContainerStatuses != null) {
      for (ContainerStatus item : ephemeralContainerStatuses) {
        this.addToEphemeralContainerStatuses(item);
      }
    }
    return (A) this;
  }
  
  public A withExtendedResourceClaimStatus(PodExtendedResourceClaimStatus extendedResourceClaimStatus) {
    this._visitables.remove("extendedResourceClaimStatus");
    if (extendedResourceClaimStatus != null) {
        this.extendedResourceClaimStatus = new PodExtendedResourceClaimStatusBuilder(extendedResourceClaimStatus);
        this._visitables.get("extendedResourceClaimStatus").add(this.extendedResourceClaimStatus);
    } else {
        this.extendedResourceClaimStatus = null;
        this._visitables.get("extendedResourceClaimStatus").remove(this.extendedResourceClaimStatus);
    }
    return (A) this;
  }
  
  public A withHostIP(String hostIP) {
    this.hostIP = hostIP;
    return (A) this;
  }
  
  public A withHostIPs(List<HostIP> hostIPs) {
    if (this.hostIPs != null) {
      this._visitables.get("hostIPs").clear();
    }
    if (hostIPs != null) {
        this.hostIPs = new ArrayList();
        for (HostIP item : hostIPs) {
          this.addToHostIPs(item);
        }
    } else {
      this.hostIPs = null;
    }
    return (A) this;
  }
  
  public A withHostIPs(HostIP... hostIPs) {
    if (this.hostIPs != null) {
        this.hostIPs.clear();
        _visitables.remove("hostIPs");
    }
    if (hostIPs != null) {
      for (HostIP item : hostIPs) {
        this.addToHostIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withInitContainerStatuses(List<ContainerStatus> initContainerStatuses) {
    if (this.initContainerStatuses != null) {
      this._visitables.get("initContainerStatuses").clear();
    }
    if (initContainerStatuses != null) {
        this.initContainerStatuses = new ArrayList();
        for (ContainerStatus item : initContainerStatuses) {
          this.addToInitContainerStatuses(item);
        }
    } else {
      this.initContainerStatuses = null;
    }
    return (A) this;
  }
  
  public A withInitContainerStatuses(ContainerStatus... initContainerStatuses) {
    if (this.initContainerStatuses != null) {
        this.initContainerStatuses.clear();
        _visitables.remove("initContainerStatuses");
    }
    if (initContainerStatuses != null) {
      for (ContainerStatus item : initContainerStatuses) {
        this.addToInitContainerStatuses(item);
      }
    }
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public ExtendedResourceClaimStatusNested<A> withNewExtendedResourceClaimStatus() {
    return new ExtendedResourceClaimStatusNested(null);
  }
  
  public ExtendedResourceClaimStatusNested<A> withNewExtendedResourceClaimStatusLike(PodExtendedResourceClaimStatus item) {
    return new ExtendedResourceClaimStatusNested(item);
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public A withNodeAllocatableResourceClaimStatuses(List<NodeAllocatableResourceClaimStatus> nodeAllocatableResourceClaimStatuses) {
    if (this.nodeAllocatableResourceClaimStatuses != null) {
      this._visitables.get("nodeAllocatableResourceClaimStatuses").clear();
    }
    if (nodeAllocatableResourceClaimStatuses != null) {
        this.nodeAllocatableResourceClaimStatuses = new ArrayList();
        for (NodeAllocatableResourceClaimStatus item : nodeAllocatableResourceClaimStatuses) {
          this.addToNodeAllocatableResourceClaimStatuses(item);
        }
    } else {
      this.nodeAllocatableResourceClaimStatuses = null;
    }
    return (A) this;
  }
  
  public A withNodeAllocatableResourceClaimStatuses(NodeAllocatableResourceClaimStatus... nodeAllocatableResourceClaimStatuses) {
    if (this.nodeAllocatableResourceClaimStatuses != null) {
        this.nodeAllocatableResourceClaimStatuses.clear();
        _visitables.remove("nodeAllocatableResourceClaimStatuses");
    }
    if (nodeAllocatableResourceClaimStatuses != null) {
      for (NodeAllocatableResourceClaimStatus item : nodeAllocatableResourceClaimStatuses) {
        this.addToNodeAllocatableResourceClaimStatuses(item);
      }
    }
    return (A) this;
  }
  
  public A withNominatedNodeName(String nominatedNodeName) {
    this.nominatedNodeName = nominatedNodeName;
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withPhase(String phase) {
    this.phase = phase;
    return (A) this;
  }
  
  public A withPodIP(String podIP) {
    this.podIP = podIP;
    return (A) this;
  }
  
  public A withPodIPs(List<PodIP> podIPs) {
    if (this.podIPs != null) {
      this._visitables.get("podIPs").clear();
    }
    if (podIPs != null) {
        this.podIPs = new ArrayList();
        for (PodIP item : podIPs) {
          this.addToPodIPs(item);
        }
    } else {
      this.podIPs = null;
    }
    return (A) this;
  }
  
  public A withPodIPs(PodIP... podIPs) {
    if (this.podIPs != null) {
        this.podIPs.clear();
        _visitables.remove("podIPs");
    }
    if (podIPs != null) {
      for (PodIP item : podIPs) {
        this.addToPodIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withQosClass(String qosClass) {
    this.qosClass = qosClass;
    return (A) this;
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
  public A withResize(String resize) {
    this.resize = resize;
    return (A) this;
  }
  
  public A withResourceClaimStatuses(List<PodResourceClaimStatus> resourceClaimStatuses) {
    if (this.resourceClaimStatuses != null) {
      this._visitables.get("resourceClaimStatuses").clear();
    }
    if (resourceClaimStatuses != null) {
        this.resourceClaimStatuses = new ArrayList();
        for (PodResourceClaimStatus item : resourceClaimStatuses) {
          this.addToResourceClaimStatuses(item);
        }
    } else {
      this.resourceClaimStatuses = null;
    }
    return (A) this;
  }
  
  public A withResourceClaimStatuses(PodResourceClaimStatus... resourceClaimStatuses) {
    if (this.resourceClaimStatuses != null) {
        this.resourceClaimStatuses.clear();
        _visitables.remove("resourceClaimStatuses");
    }
    if (resourceClaimStatuses != null) {
      for (PodResourceClaimStatus item : resourceClaimStatuses) {
        this.addToResourceClaimStatuses(item);
      }
    }
    return (A) this;
  }
  
  public A withResources(ResourceRequirements resources) {
    this._visitables.remove("resources");
    if (resources != null) {
        this.resources = new ResourceRequirementsBuilder(resources);
        this._visitables.get("resources").add(this.resources);
    } else {
        this.resources = null;
        this._visitables.get("resources").remove(this.resources);
    }
    return (A) this;
  }
  
  public A withStartTime(String startTime) {
    this.startTime = startTime;
    return (A) this;
  }
  public class ConditionsNested<N> extends PodConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    PodConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,PodCondition item) {
      this.index = index;
      this.builder = new PodConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) PodStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class ContainerStatusesNested<N> extends ContainerStatusFluent<ContainerStatusesNested<N>> implements Nested<N>{
  
    ContainerStatusBuilder builder;
    int index;
  
    ContainerStatusesNested(int index,ContainerStatus item) {
      this.index = index;
      this.builder = new ContainerStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PodStatusFluent.this.setToContainerStatuses(index, builder.build());
    }
    
    public N endContainerStatus() {
      return and();
    }
    
  }
  public class EphemeralContainerStatusesNested<N> extends ContainerStatusFluent<EphemeralContainerStatusesNested<N>> implements Nested<N>{
  
    ContainerStatusBuilder builder;
    int index;
  
    EphemeralContainerStatusesNested(int index,ContainerStatus item) {
      this.index = index;
      this.builder = new ContainerStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PodStatusFluent.this.setToEphemeralContainerStatuses(index, builder.build());
    }
    
    public N endEphemeralContainerStatus() {
      return and();
    }
    
  }
  public class ExtendedResourceClaimStatusNested<N> extends PodExtendedResourceClaimStatusFluent<ExtendedResourceClaimStatusNested<N>> implements Nested<N>{
  
    PodExtendedResourceClaimStatusBuilder builder;
  
    ExtendedResourceClaimStatusNested(PodExtendedResourceClaimStatus item) {
      this.builder = new PodExtendedResourceClaimStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PodStatusFluent.this.withExtendedResourceClaimStatus(builder.build());
    }
    
    public N endExtendedResourceClaimStatus() {
      return and();
    }
    
  }
  public class HostIPsNested<N> extends HostIPFluent<HostIPsNested<N>> implements Nested<N>{
  
    HostIPBuilder builder;
    int index;
  
    HostIPsNested(int index,HostIP item) {
      this.index = index;
      this.builder = new HostIPBuilder(this, item);
    }
  
    public N and() {
      return (N) PodStatusFluent.this.setToHostIPs(index, builder.build());
    }
    
    public N endHostIP() {
      return and();
    }
    
  }
  public class InitContainerStatusesNested<N> extends ContainerStatusFluent<InitContainerStatusesNested<N>> implements Nested<N>{
  
    ContainerStatusBuilder builder;
    int index;
  
    InitContainerStatusesNested(int index,ContainerStatus item) {
      this.index = index;
      this.builder = new ContainerStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PodStatusFluent.this.setToInitContainerStatuses(index, builder.build());
    }
    
    public N endInitContainerStatus() {
      return and();
    }
    
  }
  public class NodeAllocatableResourceClaimStatusesNested<N> extends NodeAllocatableResourceClaimStatusFluent<NodeAllocatableResourceClaimStatusesNested<N>> implements Nested<N>{
  
    NodeAllocatableResourceClaimStatusBuilder builder;
    int index;
  
    NodeAllocatableResourceClaimStatusesNested(int index,NodeAllocatableResourceClaimStatus item) {
      this.index = index;
      this.builder = new NodeAllocatableResourceClaimStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PodStatusFluent.this.setToNodeAllocatableResourceClaimStatuses(index, builder.build());
    }
    
    public N endNodeAllocatableResourceClaimStatus() {
      return and();
    }
    
  }
  public class PodIPsNested<N> extends PodIPFluent<PodIPsNested<N>> implements Nested<N>{
  
    PodIPBuilder builder;
    int index;
  
    PodIPsNested(int index,PodIP item) {
      this.index = index;
      this.builder = new PodIPBuilder(this, item);
    }
  
    public N and() {
      return (N) PodStatusFluent.this.setToPodIPs(index, builder.build());
    }
    
    public N endPodIP() {
      return and();
    }
    
  }
  public class ResourceClaimStatusesNested<N> extends PodResourceClaimStatusFluent<ResourceClaimStatusesNested<N>> implements Nested<N>{
  
    PodResourceClaimStatusBuilder builder;
    int index;
  
    ResourceClaimStatusesNested(int index,PodResourceClaimStatus item) {
      this.index = index;
      this.builder = new PodResourceClaimStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PodStatusFluent.this.setToResourceClaimStatuses(index, builder.build());
    }
    
    public N endResourceClaimStatus() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) PodStatusFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
}