
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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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

/**
 * Locality-weighted load balancing allows administrators to control the distribution of traffic to endpoints based on the localities of where the traffic originates and where it will terminate. These localities are specified using arbitrary labels that designate a hierarchy of localities in {region}/{zone}/{sub-zone} form. For additional detail refer to [Locality Weight](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/locality_weight) The following example shows how to setup locality weights mesh-wide.<br><p> <br><p> Given a mesh with workloads and their service deployed to "us-west/zone1/\&#42;" and "us-west/zone2/\&#42;". This example specifies that when traffic accessing a service originates from workloads in "us-west/zone1/\&#42;", 80% of the traffic will be sent to endpoints in "us-west/zone1/\&#42;", i.e the same zone, and the remaining 20% will go to endpoints in "us-west/zone2/\&#42;". This setup is intended to favor routing traffic to endpoints in the same locality. A similar setting is specified for traffic originating in "us-west/zone2/\&#42;".<br><p> <br><p> ```yaml<br><p> <br><p> 	distribute:<br><p> 	  - from: us-west/zone1/&#42;<br><p> 	    to:<br><p> 	      "us-west/zone1/&#42;": 80<br><p> 	      "us-west/zone2/&#42;": 20<br><p> 	  - from: us-west/zone2/&#42;<br><p> 	    to:<br><p> 	      "us-west/zone1/&#42;": 20<br><p> 	      "us-west/zone2/&#42;": 80<br><p> <br><p> ```<br><p> <br><p> If the goal of the operator is not to distribute load across zones and regions but rather to restrict the regionality of failover to meet other operational requirements an operator can set a 'failover' policy instead of a 'distribute' policy.<br><p> <br><p> The following example sets up a locality failover policy for regions. Assume a service resides in zones within us-east, us-west &amp; eu-west this example specifies that when endpoints within us-east become unhealthy traffic should failover to endpoints in any zone or sub-zone within eu-west and similarly us-west should failover to us-east.<br><p> <br><p> ```yaml<br><p> <br><p> 	failover:<br><p> 	  - from: us-east<br><p> 	    to: eu-west<br><p> 	  - from: us-west<br><p> 	    to: us-east<br><p> <br><p> ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "distribute",
    "enabled",
    "failover",
    "failoverPriority"
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
public class LocalityLoadBalancerSetting implements Editable<LocalityLoadBalancerSettingBuilder>, KubernetesResource
{

    @JsonProperty("distribute")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocalityLoadBalancerSettingDistribute> distribute = new ArrayList<>();
    @JsonProperty("enabled")
    private Boolean enabled;
    @JsonProperty("failover")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocalityLoadBalancerSettingFailover> failover = new ArrayList<>();
    @JsonProperty("failoverPriority")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> failoverPriority = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LocalityLoadBalancerSetting() {
    }

    public LocalityLoadBalancerSetting(List<LocalityLoadBalancerSettingDistribute> distribute, Boolean enabled, List<LocalityLoadBalancerSettingFailover> failover, List<String> failoverPriority) {
        super();
        this.distribute = distribute;
        this.enabled = enabled;
        this.failover = failover;
        this.failoverPriority = failoverPriority;
    }

    /**
     * Optional: only one of distribute, failover or failoverPriority can be set. Explicitly specify loadbalancing weight across different zones and geographical locations. Refer to [Locality weighted load balancing](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/locality_weight) If empty, the locality weight is set according to the endpoints number within it.
     */
    @JsonProperty("distribute")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalityLoadBalancerSettingDistribute> getDistribute() {
        return distribute;
    }

    /**
     * Optional: only one of distribute, failover or failoverPriority can be set. Explicitly specify loadbalancing weight across different zones and geographical locations. Refer to [Locality weighted load balancing](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/locality_weight) If empty, the locality weight is set according to the endpoints number within it.
     */
    @JsonProperty("distribute")
    public void setDistribute(List<LocalityLoadBalancerSettingDistribute> distribute) {
        this.distribute = distribute;
    }

    /**
     * Locality-weighted load balancing allows administrators to control the distribution of traffic to endpoints based on the localities of where the traffic originates and where it will terminate. These localities are specified using arbitrary labels that designate a hierarchy of localities in {region}/{zone}/{sub-zone} form. For additional detail refer to [Locality Weight](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/locality_weight) The following example shows how to setup locality weights mesh-wide.<br><p> <br><p> Given a mesh with workloads and their service deployed to "us-west/zone1/\&#42;" and "us-west/zone2/\&#42;". This example specifies that when traffic accessing a service originates from workloads in "us-west/zone1/\&#42;", 80% of the traffic will be sent to endpoints in "us-west/zone1/\&#42;", i.e the same zone, and the remaining 20% will go to endpoints in "us-west/zone2/\&#42;". This setup is intended to favor routing traffic to endpoints in the same locality. A similar setting is specified for traffic originating in "us-west/zone2/\&#42;".<br><p> <br><p> ```yaml<br><p> <br><p> 	distribute:<br><p> 	  - from: us-west/zone1/&#42;<br><p> 	    to:<br><p> 	      "us-west/zone1/&#42;": 80<br><p> 	      "us-west/zone2/&#42;": 20<br><p> 	  - from: us-west/zone2/&#42;<br><p> 	    to:<br><p> 	      "us-west/zone1/&#42;": 20<br><p> 	      "us-west/zone2/&#42;": 80<br><p> <br><p> ```<br><p> <br><p> If the goal of the operator is not to distribute load across zones and regions but rather to restrict the regionality of failover to meet other operational requirements an operator can set a 'failover' policy instead of a 'distribute' policy.<br><p> <br><p> The following example sets up a locality failover policy for regions. Assume a service resides in zones within us-east, us-west &amp; eu-west this example specifies that when endpoints within us-east become unhealthy traffic should failover to endpoints in any zone or sub-zone within eu-west and similarly us-west should failover to us-east.<br><p> <br><p> ```yaml<br><p> <br><p> 	failover:<br><p> 	  - from: us-east<br><p> 	    to: eu-west<br><p> 	  - from: us-west<br><p> 	    to: us-east<br><p> <br><p> ```
     */
    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Locality-weighted load balancing allows administrators to control the distribution of traffic to endpoints based on the localities of where the traffic originates and where it will terminate. These localities are specified using arbitrary labels that designate a hierarchy of localities in {region}/{zone}/{sub-zone} form. For additional detail refer to [Locality Weight](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/locality_weight) The following example shows how to setup locality weights mesh-wide.<br><p> <br><p> Given a mesh with workloads and their service deployed to "us-west/zone1/\&#42;" and "us-west/zone2/\&#42;". This example specifies that when traffic accessing a service originates from workloads in "us-west/zone1/\&#42;", 80% of the traffic will be sent to endpoints in "us-west/zone1/\&#42;", i.e the same zone, and the remaining 20% will go to endpoints in "us-west/zone2/\&#42;". This setup is intended to favor routing traffic to endpoints in the same locality. A similar setting is specified for traffic originating in "us-west/zone2/\&#42;".<br><p> <br><p> ```yaml<br><p> <br><p> 	distribute:<br><p> 	  - from: us-west/zone1/&#42;<br><p> 	    to:<br><p> 	      "us-west/zone1/&#42;": 80<br><p> 	      "us-west/zone2/&#42;": 20<br><p> 	  - from: us-west/zone2/&#42;<br><p> 	    to:<br><p> 	      "us-west/zone1/&#42;": 20<br><p> 	      "us-west/zone2/&#42;": 80<br><p> <br><p> ```<br><p> <br><p> If the goal of the operator is not to distribute load across zones and regions but rather to restrict the regionality of failover to meet other operational requirements an operator can set a 'failover' policy instead of a 'distribute' policy.<br><p> <br><p> The following example sets up a locality failover policy for regions. Assume a service resides in zones within us-east, us-west &amp; eu-west this example specifies that when endpoints within us-east become unhealthy traffic should failover to endpoints in any zone or sub-zone within eu-west and similarly us-west should failover to us-east.<br><p> <br><p> ```yaml<br><p> <br><p> 	failover:<br><p> 	  - from: us-east<br><p> 	    to: eu-west<br><p> 	  - from: us-west<br><p> 	    to: us-east<br><p> <br><p> ```
     */
    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Optional: only one of distribute, failover or failoverPriority can be set. Explicitly specify the region traffic will land on when endpoints in local region becomes unhealthy. Should be used together with OutlierDetection to detect unhealthy endpoints. Note: if no OutlierDetection specified, this will not take effect.
     */
    @JsonProperty("failover")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalityLoadBalancerSettingFailover> getFailover() {
        return failover;
    }

    /**
     * Optional: only one of distribute, failover or failoverPriority can be set. Explicitly specify the region traffic will land on when endpoints in local region becomes unhealthy. Should be used together with OutlierDetection to detect unhealthy endpoints. Note: if no OutlierDetection specified, this will not take effect.
     */
    @JsonProperty("failover")
    public void setFailover(List<LocalityLoadBalancerSettingFailover> failover) {
        this.failover = failover;
    }

    /**
     * failoverPriority is an ordered list of labels used to sort endpoints to do priority based load balancing. This is to support traffic failover across different groups of endpoints. Two kinds of labels can be specified:<br><p> <br><p>   - Specify only label keys `[key1, key2, key3]`, istio would compare the label values of client with endpoints.<br><p>     Suppose there are total N label keys `[key1, key2, key3, ...keyN]` specified:<br><p> <br><p>     1. Endpoints matching all N labels with the client proxy have priority P(0) i.e. the highest priority.<br><p>     2. Endpoints matching the first N-1 labels with the client proxy have priority P(1) i.e. second highest priority.<br><p>     3. By extension of this logic, endpoints matching only the first label with the client proxy has priority P(N-1) i.e. second lowest priority.<br><p>     4. All the other endpoints have priority P(N) i.e. lowest priority.<br><p> <br><p>   - Specify labels with key and value `[key1=value1, key2=value2, key3=value3]`, istio would compare the labels with endpoints.<br><p>     Suppose there are total N labels `[key1=value1, key2=value2, key3=value3, ...keyN=valueN]` specified:<br><p> <br><p>     1. Endpoints matching all N labels have priority P(0) i.e. the highest priority.<br><p>     2. Endpoints matching the first N-1 labels have priority P(1) i.e. second highest priority.<br><p>     3. By extension of this logic, endpoints matching only the first label has priority P(N-1) i.e. second lowest priority.<br><p>     4. All the other endpoints have priority P(N) i.e. lowest priority.<br><p> <br><p> Note: For a label to be considered for match, the previous labels must match, i.e. nth label would be considered matched only if first n-1 labels match.<br><p> <br><p> It can be any label specified on both client and server workloads. The following labels which have special semantic meaning are also supported:<br><p> <br><p>   - `topology.istio.io/network` is used to match the network metadata of an endpoint, which can be specified by pod/namespace label `topology.istio.io/network`, sidecar env `ISTIO_META_NETWORK` or MeshNetworks.<br><p>   - `topology.istio.io/cluster` is used to match the clusterID of an endpoint, which can be specified by pod label `topology.istio.io/cluster` or pod env `ISTIO_META_CLUSTER_ID`.<br><p>   - `topology.kubernetes.io/region` is used to match the region metadata of an endpoint, which maps to Kubernetes node label `topology.kubernetes.io/region` or the deprecated label `failure-domain.beta.kubernetes.io/region`.<br><p>   - `topology.kubernetes.io/zone` is used to match the zone metadata of an endpoint, which maps to Kubernetes node label `topology.kubernetes.io/zone` or the deprecated label `failure-domain.beta.kubernetes.io/zone`.<br><p>   - `topology.istio.io/subzone` is used to match the subzone metadata of an endpoint, which maps to Istio node label `topology.istio.io/subzone`.<br><p>   - `kubernetes.io/hostname` is used to match the current node of an endpoint, which maps to Kubernetes node label `kubernetes.io/hostname`.<br><p> <br><p> The below topology config indicates the following priority levels:<br><p> <br><p> ```yaml failoverPriority: - "topology.istio.io/network" - "topology.kubernetes.io/region" - "topology.kubernetes.io/zone" - "topology.istio.io/subzone" ```<br><p> <br><p> 1. endpoints match same [network, region, zone, subzone] label with the client proxy have the highest priority. 2. endpoints have same [network, region, zone] label but different [subzone] label with the client proxy have the second highest priority. 3. endpoints have same [network, region] label but different [zone] label with the client proxy have the third highest priority. 4. endpoints have same [network] but different [region] labels with the client proxy have the fourth highest priority. 5. all the other endpoints have the same lowest priority.<br><p> <br><p> Suppose a service associated endpoints reside in multi clusters, the below example represents: 1. endpoints in `clusterA` and has `version=v1` label have P(0) priority. 2. endpoints not in `clusterA` but has `version=v1` label have P(1) priority. 2. all the other endpoints have P(2) priority.<br><p> <br><p> ```yaml failoverPriority: - "version=v1" - "topology.istio.io/cluster=clusterA" ```<br><p> <br><p> Optional: only one of distribute, failover or failoverPriority can be set. And it should be used together with `OutlierDetection` to detect unhealthy endpoints, otherwise has no effect.
     */
    @JsonProperty("failoverPriority")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFailoverPriority() {
        return failoverPriority;
    }

    /**
     * failoverPriority is an ordered list of labels used to sort endpoints to do priority based load balancing. This is to support traffic failover across different groups of endpoints. Two kinds of labels can be specified:<br><p> <br><p>   - Specify only label keys `[key1, key2, key3]`, istio would compare the label values of client with endpoints.<br><p>     Suppose there are total N label keys `[key1, key2, key3, ...keyN]` specified:<br><p> <br><p>     1. Endpoints matching all N labels with the client proxy have priority P(0) i.e. the highest priority.<br><p>     2. Endpoints matching the first N-1 labels with the client proxy have priority P(1) i.e. second highest priority.<br><p>     3. By extension of this logic, endpoints matching only the first label with the client proxy has priority P(N-1) i.e. second lowest priority.<br><p>     4. All the other endpoints have priority P(N) i.e. lowest priority.<br><p> <br><p>   - Specify labels with key and value `[key1=value1, key2=value2, key3=value3]`, istio would compare the labels with endpoints.<br><p>     Suppose there are total N labels `[key1=value1, key2=value2, key3=value3, ...keyN=valueN]` specified:<br><p> <br><p>     1. Endpoints matching all N labels have priority P(0) i.e. the highest priority.<br><p>     2. Endpoints matching the first N-1 labels have priority P(1) i.e. second highest priority.<br><p>     3. By extension of this logic, endpoints matching only the first label has priority P(N-1) i.e. second lowest priority.<br><p>     4. All the other endpoints have priority P(N) i.e. lowest priority.<br><p> <br><p> Note: For a label to be considered for match, the previous labels must match, i.e. nth label would be considered matched only if first n-1 labels match.<br><p> <br><p> It can be any label specified on both client and server workloads. The following labels which have special semantic meaning are also supported:<br><p> <br><p>   - `topology.istio.io/network` is used to match the network metadata of an endpoint, which can be specified by pod/namespace label `topology.istio.io/network`, sidecar env `ISTIO_META_NETWORK` or MeshNetworks.<br><p>   - `topology.istio.io/cluster` is used to match the clusterID of an endpoint, which can be specified by pod label `topology.istio.io/cluster` or pod env `ISTIO_META_CLUSTER_ID`.<br><p>   - `topology.kubernetes.io/region` is used to match the region metadata of an endpoint, which maps to Kubernetes node label `topology.kubernetes.io/region` or the deprecated label `failure-domain.beta.kubernetes.io/region`.<br><p>   - `topology.kubernetes.io/zone` is used to match the zone metadata of an endpoint, which maps to Kubernetes node label `topology.kubernetes.io/zone` or the deprecated label `failure-domain.beta.kubernetes.io/zone`.<br><p>   - `topology.istio.io/subzone` is used to match the subzone metadata of an endpoint, which maps to Istio node label `topology.istio.io/subzone`.<br><p>   - `kubernetes.io/hostname` is used to match the current node of an endpoint, which maps to Kubernetes node label `kubernetes.io/hostname`.<br><p> <br><p> The below topology config indicates the following priority levels:<br><p> <br><p> ```yaml failoverPriority: - "topology.istio.io/network" - "topology.kubernetes.io/region" - "topology.kubernetes.io/zone" - "topology.istio.io/subzone" ```<br><p> <br><p> 1. endpoints match same [network, region, zone, subzone] label with the client proxy have the highest priority. 2. endpoints have same [network, region, zone] label but different [subzone] label with the client proxy have the second highest priority. 3. endpoints have same [network, region] label but different [zone] label with the client proxy have the third highest priority. 4. endpoints have same [network] but different [region] labels with the client proxy have the fourth highest priority. 5. all the other endpoints have the same lowest priority.<br><p> <br><p> Suppose a service associated endpoints reside in multi clusters, the below example represents: 1. endpoints in `clusterA` and has `version=v1` label have P(0) priority. 2. endpoints not in `clusterA` but has `version=v1` label have P(1) priority. 2. all the other endpoints have P(2) priority.<br><p> <br><p> ```yaml failoverPriority: - "version=v1" - "topology.istio.io/cluster=clusterA" ```<br><p> <br><p> Optional: only one of distribute, failover or failoverPriority can be set. And it should be used together with `OutlierDetection` to detect unhealthy endpoints, otherwise has no effect.
     */
    @JsonProperty("failoverPriority")
    public void setFailoverPriority(List<String> failoverPriority) {
        this.failoverPriority = failoverPriority;
    }

    @JsonIgnore
    public LocalityLoadBalancerSettingBuilder edit() {
        return new LocalityLoadBalancerSettingBuilder(this);
    }

    @JsonIgnore
    public LocalityLoadBalancerSettingBuilder toBuilder() {
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
