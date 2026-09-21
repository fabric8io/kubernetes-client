
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * Zone Aware Load Balancer automatically routes traffic to endpoints in the same availability zone as the downstream proxy, reducing cross-zone latency and inter-zone data transfer costs. Unlike [LocalityLoadBalancerSetting](#LocalityLoadBalancerSetting), which requires explicitly specifying traffic weights per locality, Zone Aware Load Balancer automatically calculates routing percentages based on the relative number of upstream endpoints in each zone — no manual distribution configuration is needed.<br><p> <br><p> When the local zone has proportionally fewer endpoints than the share of traffic it would need to absorb, Envoy automatically overflows the excess to other zones rather than overloading local endpoints.<br><p> <br><p> Additionally Zone Aware Load Balancer always partitions endpoints by region: the proxy's own region forms the highest-priority tier and Envoy's automatic zone balancing operates only among the endpoints within that region. Endpoints in other regions form lower-priority failover tiers that receive traffic only when the local region is unhealthy or runs out of capacity. The `failover` and `failoverPriority` fields only influence how those lower tiers are ordered; the regional partitioning itself is always applied whenever zone-aware load balancing is enabled.<br><p> <br><p> For proxies to activate Zone Aware Load Balancer all of the following conditions are needed:<br><p> <br><p>   - The downstream proxy is configured with  `ISTIO_META_ENABLE_SELF_DISCOVERY=true`<br><p>     (set via `proxyMetadata`).<br><p>   - The upstream cluster spans more than one zone.<br><p>   - The upstream cluster has at least `minClusterSize` hosts (default 6) in the local region.<br><p>   - There is at least one healthy endpoint in the local zone.<br><p> <br><p> If any of these conditions are not met, Envoy falls back to the configured load balancing policy (e.g. round-robin or least-request) across all endpoints in the local region.<br><p> <br><p> For additional details on the algorithm, refer to Envoy's [Zone Aware Routing](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/zone_aware) documentation.<br><p> <br><p> Note: Zone Aware Load Balancer is not supported on Ambient mode.<br><p> <br><p> The following example enables zone-aware load balancing for the ratings service:<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: ratings-zone-aware<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: ROUND_ROBIN<br><p> 	    zoneAwareLbSetting:<br><p> 	      enabled: true<br><p> <br><p> ```<br><p> <br><p> The following example adds a cross-region failover policy so that when all endpoints in `us-east` become unhealthy, traffic fails over to `eu-west` instead of any region globally:<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: ratings-zone-aware-failover<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: LEAST_REQUEST<br><p> 	    zoneAwareLbSetting:<br><p> 	      enabled: true<br><p> 	      failover:<br><p> 	        - from: us-east<br><p> 	          to: eu-west<br><p> 	        - from: us-west<br><p> 	          to: us-east<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 5<br><p> 	    interval: 30s<br><p> 	    baseEjectionTime: 30s<br><p> <br><p> ```
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "enabled",
    "failover",
    "failoverPriority",
    "minClusterSize"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ZoneAwareLoadBalancerSetting implements Editable<ZoneAwareLoadBalancerSettingBuilder>, KubernetesResource
{

    @JsonProperty("enabled")
    private Boolean enabled;
    @JsonProperty("failover")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ZoneAwareLoadBalancerSettingFailover> failover = new ArrayList<>();
    @JsonProperty("failoverPriority")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> failoverPriority = new ArrayList<>();
    @JsonProperty("minClusterSize")
    private Integer minClusterSize;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ZoneAwareLoadBalancerSetting() {
    }

    public ZoneAwareLoadBalancerSetting(Boolean enabled, List<ZoneAwareLoadBalancerSettingFailover> failover, List<String> failoverPriority, Integer minClusterSize) {
        super();
        this.enabled = enabled;
        this.failover = failover;
        this.failoverPriority = failoverPriority;
        this.minClusterSize = minClusterSize;
    }

    /**
     * Zone Aware Load Balancer automatically routes traffic to endpoints in the same availability zone as the downstream proxy, reducing cross-zone latency and inter-zone data transfer costs. Unlike [LocalityLoadBalancerSetting](#LocalityLoadBalancerSetting), which requires explicitly specifying traffic weights per locality, Zone Aware Load Balancer automatically calculates routing percentages based on the relative number of upstream endpoints in each zone — no manual distribution configuration is needed.<br><p> <br><p> When the local zone has proportionally fewer endpoints than the share of traffic it would need to absorb, Envoy automatically overflows the excess to other zones rather than overloading local endpoints.<br><p> <br><p> Additionally Zone Aware Load Balancer always partitions endpoints by region: the proxy's own region forms the highest-priority tier and Envoy's automatic zone balancing operates only among the endpoints within that region. Endpoints in other regions form lower-priority failover tiers that receive traffic only when the local region is unhealthy or runs out of capacity. The `failover` and `failoverPriority` fields only influence how those lower tiers are ordered; the regional partitioning itself is always applied whenever zone-aware load balancing is enabled.<br><p> <br><p> For proxies to activate Zone Aware Load Balancer all of the following conditions are needed:<br><p> <br><p>   - The downstream proxy is configured with  `ISTIO_META_ENABLE_SELF_DISCOVERY=true`<br><p>     (set via `proxyMetadata`).<br><p>   - The upstream cluster spans more than one zone.<br><p>   - The upstream cluster has at least `minClusterSize` hosts (default 6) in the local region.<br><p>   - There is at least one healthy endpoint in the local zone.<br><p> <br><p> If any of these conditions are not met, Envoy falls back to the configured load balancing policy (e.g. round-robin or least-request) across all endpoints in the local region.<br><p> <br><p> For additional details on the algorithm, refer to Envoy's [Zone Aware Routing](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/zone_aware) documentation.<br><p> <br><p> Note: Zone Aware Load Balancer is not supported on Ambient mode.<br><p> <br><p> The following example enables zone-aware load balancing for the ratings service:<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: ratings-zone-aware<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: ROUND_ROBIN<br><p> 	    zoneAwareLbSetting:<br><p> 	      enabled: true<br><p> <br><p> ```<br><p> <br><p> The following example adds a cross-region failover policy so that when all endpoints in `us-east` become unhealthy, traffic fails over to `eu-west` instead of any region globally:<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: ratings-zone-aware-failover<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: LEAST_REQUEST<br><p> 	    zoneAwareLbSetting:<br><p> 	      enabled: true<br><p> 	      failover:<br><p> 	        - from: us-east<br><p> 	          to: eu-west<br><p> 	        - from: us-west<br><p> 	          to: us-east<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 5<br><p> 	    interval: 30s<br><p> 	    baseEjectionTime: 30s<br><p> <br><p> ```
     */
    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Zone Aware Load Balancer automatically routes traffic to endpoints in the same availability zone as the downstream proxy, reducing cross-zone latency and inter-zone data transfer costs. Unlike [LocalityLoadBalancerSetting](#LocalityLoadBalancerSetting), which requires explicitly specifying traffic weights per locality, Zone Aware Load Balancer automatically calculates routing percentages based on the relative number of upstream endpoints in each zone — no manual distribution configuration is needed.<br><p> <br><p> When the local zone has proportionally fewer endpoints than the share of traffic it would need to absorb, Envoy automatically overflows the excess to other zones rather than overloading local endpoints.<br><p> <br><p> Additionally Zone Aware Load Balancer always partitions endpoints by region: the proxy's own region forms the highest-priority tier and Envoy's automatic zone balancing operates only among the endpoints within that region. Endpoints in other regions form lower-priority failover tiers that receive traffic only when the local region is unhealthy or runs out of capacity. The `failover` and `failoverPriority` fields only influence how those lower tiers are ordered; the regional partitioning itself is always applied whenever zone-aware load balancing is enabled.<br><p> <br><p> For proxies to activate Zone Aware Load Balancer all of the following conditions are needed:<br><p> <br><p>   - The downstream proxy is configured with  `ISTIO_META_ENABLE_SELF_DISCOVERY=true`<br><p>     (set via `proxyMetadata`).<br><p>   - The upstream cluster spans more than one zone.<br><p>   - The upstream cluster has at least `minClusterSize` hosts (default 6) in the local region.<br><p>   - There is at least one healthy endpoint in the local zone.<br><p> <br><p> If any of these conditions are not met, Envoy falls back to the configured load balancing policy (e.g. round-robin or least-request) across all endpoints in the local region.<br><p> <br><p> For additional details on the algorithm, refer to Envoy's [Zone Aware Routing](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/zone_aware) documentation.<br><p> <br><p> Note: Zone Aware Load Balancer is not supported on Ambient mode.<br><p> <br><p> The following example enables zone-aware load balancing for the ratings service:<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: ratings-zone-aware<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: ROUND_ROBIN<br><p> 	    zoneAwareLbSetting:<br><p> 	      enabled: true<br><p> <br><p> ```<br><p> <br><p> The following example adds a cross-region failover policy so that when all endpoints in `us-east` become unhealthy, traffic fails over to `eu-west` instead of any region globally:<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: ratings-zone-aware-failover<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: LEAST_REQUEST<br><p> 	    zoneAwareLbSetting:<br><p> 	      enabled: true<br><p> 	      failover:<br><p> 	        - from: us-east<br><p> 	          to: eu-west<br><p> 	        - from: us-west<br><p> 	          to: us-east<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 5<br><p> 	    interval: 30s<br><p> 	    baseEjectionTime: 30s<br><p> <br><p> ```
     */
    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Optional. Explicitly specifies the region traffic will land on when the endpoints in the local region become unhealthy. Regional partitioning is always applied; this field only customizes the ordering of the cross-region tiers. It may be used on its own, or together with `failoverPriority`, in which case it orders the regional tiers applied on top of the label-based priorities. For this to be effective consider one of the following: - Use together with `OutlierDetection` to detect unhealthy endpoints in the local zone so that traffic fails over to other zones according to the specified priority. - Enable `PILOT_SEND_UNHEALTHY_ENDPOINTS` to allow Envoy to know when endpoints in the local zone are unhealthy and failover according to the specified priority.
     */
    @JsonProperty("failover")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ZoneAwareLoadBalancerSettingFailover> getFailover() {
        return failover;
    }

    /**
     * Optional. Explicitly specifies the region traffic will land on when the endpoints in the local region become unhealthy. Regional partitioning is always applied; this field only customizes the ordering of the cross-region tiers. It may be used on its own, or together with `failoverPriority`, in which case it orders the regional tiers applied on top of the label-based priorities. For this to be effective consider one of the following: - Use together with `OutlierDetection` to detect unhealthy endpoints in the local zone so that traffic fails over to other zones according to the specified priority. - Enable `PILOT_SEND_UNHEALTHY_ENDPOINTS` to allow Envoy to know when endpoints in the local zone are unhealthy and failover according to the specified priority.
     */
    @JsonProperty("failover")
    public void setFailover(List<ZoneAwareLoadBalancerSettingFailover> failover) {
        this.failover = failover;
    }

    /**
     * failoverPriority is an ordered list of labels used to sort endpoints for priority-based load balancing. This supports traffic failover across different groups of endpoints and complements the automatic zone-level routing by allowing label-based priority tiers on top of it.<br><p> <br><p> Regional partitioning is always applied in addition to these labels: within each tier produced by `failoverPriority`, endpoints in the proxy's own region are preferred over endpoints in other regions (ordered by `failover` when it is also set). Because region-, zone-, and subzone-level routing are all handled automatically, `failoverPriority` must not include the `topology.kubernetes.io/region`, `topology.kubernetes.io/zone`, or `topology.istio.io/subzone` labels.<br><p> <br><p> Two kinds of labels can be specified:<br><p> <br><p>   - Specify only label keys `[key1, key2, key3]`, istio would compare the label values of client with endpoints.<br><p>     Suppose there are total N label keys `[key1, key2, key3, ...keyN]` specified:<br><p> <br><p>     1. Endpoints matching all N labels with the client proxy have priority P(0) i.e. the highest priority.<br><p>     2. Endpoints matching the first N-1 labels with the client proxy have priority P(1) i.e. second highest priority.<br><p>     3. By extension of this logic, endpoints matching only the first label with the client proxy has priority P(N-1) i.e. second lowest priority.<br><p>     4. All the other endpoints have priority P(N) i.e. lowest priority.<br><p> <br><p>   - Specify labels with key and value `[key1=value1, key2=value2, key3=value3]`, istio would compare the labels with endpoints.<br><p>     Suppose there are total N labels `[key1=value1, key2=value2, key3=value3, ...keyN=valueN]` specified:<br><p> <br><p>     1. Endpoints matching all N labels have priority P(0) i.e. the highest priority.<br><p>     2. Endpoints matching the first N-1 labels have priority P(1) i.e. second highest priority.<br><p>     3. By extension of this logic, endpoints matching only the first label has priority P(N-1) i.e. second lowest priority.<br><p>     4. All the other endpoints have priority P(N) i.e. lowest priority.<br><p> <br><p> Note: For a label to be considered for match, the previous labels must match, i.e. nth label would be considered matched only if first n-1 labels match.<br><p> <br><p> It can be any label specified on both client and server workloads. The following labels which have special semantic meaning are also supported:<br><p> <br><p>   - `topology.istio.io/network` is used to match the network metadata of an endpoint, which can be specified by pod/namespace label `topology.istio.io/network`, sidecar env `ISTIO_META_NETWORK` or MeshNetworks.<br><p>   - `topology.istio.io/cluster` is used to match the clusterID of an endpoint, which can be specified by pod label `topology.istio.io/cluster` or pod env `ISTIO_META_CLUSTER_ID`.<br><p>   - `topology.kubernetes.io/region` is used to match the region metadata of an endpoint, which maps to Kubernetes node label `topology.kubernetes.io/region` or the deprecated label `failure-domain.beta.kubernetes.io/region`.<br><p>   - `topology.kubernetes.io/zone` is used to match the zone metadata of an endpoint, which maps to Kubernetes node label `topology.kubernetes.io/zone` or the deprecated label `failure-domain.beta.kubernetes.io/zone`.<br><p>   - `kubernetes.io/hostname` is used to match the current node of an endpoint, which maps to Kubernetes node label `kubernetes.io/hostname`.<br><p> <br><p> The below topology config indicates the following priority levels:<br><p> <br><p> ```yaml failoverPriority: - "topology.istio.io/network" - "topology.kubernetes.io/region" - "topology.kubernetes.io/zone" ```<br><p> <br><p> 1. endpoints match same [network, region, zone] label with the client proxy have the highest priority. 2. endpoints have same [network, region] label but different [zone] label with the client proxy have the second highest priority. 3. endpoints have same [network] but different [region] labels with the client proxy have the third highest priority. 4. all the other endpoints have the same lowest priority.<br><p> <br><p> Suppose a service associated endpoints reside in multi clusters, the below example represents: 1. endpoints in `clusterA` and has `version=v1` label have P(0) priority. 2. endpoints not in `clusterA` but has `version=v1` label have P(1) priority. 3. all the other endpoints have P(2) priority.<br><p> <br><p> ```yaml failoverPriority: - "version=v1" - "topology.istio.io/cluster=clusterA" ```<br><p> <br><p> Optional. May be combined with `failover` (which then orders the regional tiers applied on top of these label-based priorities). For this to be effective consider one of the following: - Use together with `OutlierDetection` to detect unhealthy endpoints in the local zone so that traffic fails over to other zones according to the specified priority. - Enable `PILOT_SEND_UNHEALTHY_ENDPOINTS` to allow Envoy to know when endpoints in the local zone are unhealthy and failover according to the specified priority.
     */
    @JsonProperty("failoverPriority")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFailoverPriority() {
        return failoverPriority;
    }

    /**
     * failoverPriority is an ordered list of labels used to sort endpoints for priority-based load balancing. This supports traffic failover across different groups of endpoints and complements the automatic zone-level routing by allowing label-based priority tiers on top of it.<br><p> <br><p> Regional partitioning is always applied in addition to these labels: within each tier produced by `failoverPriority`, endpoints in the proxy's own region are preferred over endpoints in other regions (ordered by `failover` when it is also set). Because region-, zone-, and subzone-level routing are all handled automatically, `failoverPriority` must not include the `topology.kubernetes.io/region`, `topology.kubernetes.io/zone`, or `topology.istio.io/subzone` labels.<br><p> <br><p> Two kinds of labels can be specified:<br><p> <br><p>   - Specify only label keys `[key1, key2, key3]`, istio would compare the label values of client with endpoints.<br><p>     Suppose there are total N label keys `[key1, key2, key3, ...keyN]` specified:<br><p> <br><p>     1. Endpoints matching all N labels with the client proxy have priority P(0) i.e. the highest priority.<br><p>     2. Endpoints matching the first N-1 labels with the client proxy have priority P(1) i.e. second highest priority.<br><p>     3. By extension of this logic, endpoints matching only the first label with the client proxy has priority P(N-1) i.e. second lowest priority.<br><p>     4. All the other endpoints have priority P(N) i.e. lowest priority.<br><p> <br><p>   - Specify labels with key and value `[key1=value1, key2=value2, key3=value3]`, istio would compare the labels with endpoints.<br><p>     Suppose there are total N labels `[key1=value1, key2=value2, key3=value3, ...keyN=valueN]` specified:<br><p> <br><p>     1. Endpoints matching all N labels have priority P(0) i.e. the highest priority.<br><p>     2. Endpoints matching the first N-1 labels have priority P(1) i.e. second highest priority.<br><p>     3. By extension of this logic, endpoints matching only the first label has priority P(N-1) i.e. second lowest priority.<br><p>     4. All the other endpoints have priority P(N) i.e. lowest priority.<br><p> <br><p> Note: For a label to be considered for match, the previous labels must match, i.e. nth label would be considered matched only if first n-1 labels match.<br><p> <br><p> It can be any label specified on both client and server workloads. The following labels which have special semantic meaning are also supported:<br><p> <br><p>   - `topology.istio.io/network` is used to match the network metadata of an endpoint, which can be specified by pod/namespace label `topology.istio.io/network`, sidecar env `ISTIO_META_NETWORK` or MeshNetworks.<br><p>   - `topology.istio.io/cluster` is used to match the clusterID of an endpoint, which can be specified by pod label `topology.istio.io/cluster` or pod env `ISTIO_META_CLUSTER_ID`.<br><p>   - `topology.kubernetes.io/region` is used to match the region metadata of an endpoint, which maps to Kubernetes node label `topology.kubernetes.io/region` or the deprecated label `failure-domain.beta.kubernetes.io/region`.<br><p>   - `topology.kubernetes.io/zone` is used to match the zone metadata of an endpoint, which maps to Kubernetes node label `topology.kubernetes.io/zone` or the deprecated label `failure-domain.beta.kubernetes.io/zone`.<br><p>   - `kubernetes.io/hostname` is used to match the current node of an endpoint, which maps to Kubernetes node label `kubernetes.io/hostname`.<br><p> <br><p> The below topology config indicates the following priority levels:<br><p> <br><p> ```yaml failoverPriority: - "topology.istio.io/network" - "topology.kubernetes.io/region" - "topology.kubernetes.io/zone" ```<br><p> <br><p> 1. endpoints match same [network, region, zone] label with the client proxy have the highest priority. 2. endpoints have same [network, region] label but different [zone] label with the client proxy have the second highest priority. 3. endpoints have same [network] but different [region] labels with the client proxy have the third highest priority. 4. all the other endpoints have the same lowest priority.<br><p> <br><p> Suppose a service associated endpoints reside in multi clusters, the below example represents: 1. endpoints in `clusterA` and has `version=v1` label have P(0) priority. 2. endpoints not in `clusterA` but has `version=v1` label have P(1) priority. 3. all the other endpoints have P(2) priority.<br><p> <br><p> ```yaml failoverPriority: - "version=v1" - "topology.istio.io/cluster=clusterA" ```<br><p> <br><p> Optional. May be combined with `failover` (which then orders the regional tiers applied on top of these label-based priorities). For this to be effective consider one of the following: - Use together with `OutlierDetection` to detect unhealthy endpoints in the local zone so that traffic fails over to other zones according to the specified priority. - Enable `PILOT_SEND_UNHEALTHY_ENDPOINTS` to allow Envoy to know when endpoints in the local zone are unhealthy and failover according to the specified priority.
     */
    @JsonProperty("failoverPriority")
    public void setFailoverPriority(List<String> failoverPriority) {
        this.failoverPriority = failoverPriority;
    }

    /**
     * Zone Aware Load Balancer automatically routes traffic to endpoints in the same availability zone as the downstream proxy, reducing cross-zone latency and inter-zone data transfer costs. Unlike [LocalityLoadBalancerSetting](#LocalityLoadBalancerSetting), which requires explicitly specifying traffic weights per locality, Zone Aware Load Balancer automatically calculates routing percentages based on the relative number of upstream endpoints in each zone — no manual distribution configuration is needed.<br><p> <br><p> When the local zone has proportionally fewer endpoints than the share of traffic it would need to absorb, Envoy automatically overflows the excess to other zones rather than overloading local endpoints.<br><p> <br><p> Additionally Zone Aware Load Balancer always partitions endpoints by region: the proxy's own region forms the highest-priority tier and Envoy's automatic zone balancing operates only among the endpoints within that region. Endpoints in other regions form lower-priority failover tiers that receive traffic only when the local region is unhealthy or runs out of capacity. The `failover` and `failoverPriority` fields only influence how those lower tiers are ordered; the regional partitioning itself is always applied whenever zone-aware load balancing is enabled.<br><p> <br><p> For proxies to activate Zone Aware Load Balancer all of the following conditions are needed:<br><p> <br><p>   - The downstream proxy is configured with  `ISTIO_META_ENABLE_SELF_DISCOVERY=true`<br><p>     (set via `proxyMetadata`).<br><p>   - The upstream cluster spans more than one zone.<br><p>   - The upstream cluster has at least `minClusterSize` hosts (default 6) in the local region.<br><p>   - There is at least one healthy endpoint in the local zone.<br><p> <br><p> If any of these conditions are not met, Envoy falls back to the configured load balancing policy (e.g. round-robin or least-request) across all endpoints in the local region.<br><p> <br><p> For additional details on the algorithm, refer to Envoy's [Zone Aware Routing](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/zone_aware) documentation.<br><p> <br><p> Note: Zone Aware Load Balancer is not supported on Ambient mode.<br><p> <br><p> The following example enables zone-aware load balancing for the ratings service:<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: ratings-zone-aware<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: ROUND_ROBIN<br><p> 	    zoneAwareLbSetting:<br><p> 	      enabled: true<br><p> <br><p> ```<br><p> <br><p> The following example adds a cross-region failover policy so that when all endpoints in `us-east` become unhealthy, traffic fails over to `eu-west` instead of any region globally:<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: ratings-zone-aware-failover<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: LEAST_REQUEST<br><p> 	    zoneAwareLbSetting:<br><p> 	      enabled: true<br><p> 	      failover:<br><p> 	        - from: us-east<br><p> 	          to: eu-west<br><p> 	        - from: us-west<br><p> 	          to: us-east<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 5<br><p> 	    interval: 30s<br><p> 	    baseEjectionTime: 30s<br><p> <br><p> ```
     */
    @JsonProperty("minClusterSize")
    public Integer getMinClusterSize() {
        return minClusterSize;
    }

    /**
     * Zone Aware Load Balancer automatically routes traffic to endpoints in the same availability zone as the downstream proxy, reducing cross-zone latency and inter-zone data transfer costs. Unlike [LocalityLoadBalancerSetting](#LocalityLoadBalancerSetting), which requires explicitly specifying traffic weights per locality, Zone Aware Load Balancer automatically calculates routing percentages based on the relative number of upstream endpoints in each zone — no manual distribution configuration is needed.<br><p> <br><p> When the local zone has proportionally fewer endpoints than the share of traffic it would need to absorb, Envoy automatically overflows the excess to other zones rather than overloading local endpoints.<br><p> <br><p> Additionally Zone Aware Load Balancer always partitions endpoints by region: the proxy's own region forms the highest-priority tier and Envoy's automatic zone balancing operates only among the endpoints within that region. Endpoints in other regions form lower-priority failover tiers that receive traffic only when the local region is unhealthy or runs out of capacity. The `failover` and `failoverPriority` fields only influence how those lower tiers are ordered; the regional partitioning itself is always applied whenever zone-aware load balancing is enabled.<br><p> <br><p> For proxies to activate Zone Aware Load Balancer all of the following conditions are needed:<br><p> <br><p>   - The downstream proxy is configured with  `ISTIO_META_ENABLE_SELF_DISCOVERY=true`<br><p>     (set via `proxyMetadata`).<br><p>   - The upstream cluster spans more than one zone.<br><p>   - The upstream cluster has at least `minClusterSize` hosts (default 6) in the local region.<br><p>   - There is at least one healthy endpoint in the local zone.<br><p> <br><p> If any of these conditions are not met, Envoy falls back to the configured load balancing policy (e.g. round-robin or least-request) across all endpoints in the local region.<br><p> <br><p> For additional details on the algorithm, refer to Envoy's [Zone Aware Routing](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/zone_aware) documentation.<br><p> <br><p> Note: Zone Aware Load Balancer is not supported on Ambient mode.<br><p> <br><p> The following example enables zone-aware load balancing for the ratings service:<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: ratings-zone-aware<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: ROUND_ROBIN<br><p> 	    zoneAwareLbSetting:<br><p> 	      enabled: true<br><p> <br><p> ```<br><p> <br><p> The following example adds a cross-region failover policy so that when all endpoints in `us-east` become unhealthy, traffic fails over to `eu-west` instead of any region globally:<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: ratings-zone-aware-failover<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: LEAST_REQUEST<br><p> 	    zoneAwareLbSetting:<br><p> 	      enabled: true<br><p> 	      failover:<br><p> 	        - from: us-east<br><p> 	          to: eu-west<br><p> 	        - from: us-west<br><p> 	          to: us-east<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 5<br><p> 	    interval: 30s<br><p> 	    baseEjectionTime: 30s<br><p> <br><p> ```
     */
    @JsonProperty("minClusterSize")
    public void setMinClusterSize(Integer minClusterSize) {
        this.minClusterSize = minClusterSize;
    }

    @JsonIgnore
    public ZoneAwareLoadBalancerSettingBuilder edit() {
        return new ZoneAwareLoadBalancerSettingBuilder(this);
    }

    @JsonIgnore
    public ZoneAwareLoadBalancerSettingBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
