
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
 * Load balancing policies to apply for a specific destination. See Envoy's load balancing [documentation](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/load_balancing) for more details.<br><p> <br><p> For example, the following rule uses a round robin load balancing policy for all traffic going to the ratings service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: ROUND_ROBIN<br><p> <br><p> ```<br><p> <br><p> The following example sets up sticky sessions for the ratings service hashing-based load balancer for the same ratings service using the the User cookie as the hash key.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    consistentHash:<br><p> 	      httpCookie:<br><p> 	        name: user<br><p> 	        ttl: 0s<br><p> <br><p> ```
 */
@JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "LbPolicy",
    "localityLbSetting",
    "warmup",
    "warmupDurationSecs"
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
public class LoadBalancerSettings implements Editable<LoadBalancerSettingsBuilder>, KubernetesResource
{

    @JsonProperty("LbPolicy")
    @JsonUnwrapped
    private IsLoadBalancerSettingsLbPolicy lbPolicy;
    @JsonProperty("localityLbSetting")
    private LocalityLoadBalancerSetting localityLbSetting;
    @JsonProperty("warmup")
    private WarmupConfiguration warmup;
    @JsonProperty("warmupDurationSecs")
    private String warmupDurationSecs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LoadBalancerSettings() {
    }

    public LoadBalancerSettings(IsLoadBalancerSettingsLbPolicy lbPolicy, LocalityLoadBalancerSetting localityLbSetting, WarmupConfiguration warmup, String warmupDurationSecs) {
        super();
        this.lbPolicy = lbPolicy;
        this.localityLbSetting = localityLbSetting;
        this.warmup = warmup;
        this.warmupDurationSecs = warmupDurationSecs;
    }

    /**
     * Load balancing policies to apply for a specific destination. See Envoy's load balancing [documentation](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/load_balancing) for more details.<br><p> <br><p> For example, the following rule uses a round robin load balancing policy for all traffic going to the ratings service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: ROUND_ROBIN<br><p> <br><p> ```<br><p> <br><p> The following example sets up sticky sessions for the ratings service hashing-based load balancer for the same ratings service using the the User cookie as the hash key.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    consistentHash:<br><p> 	      httpCookie:<br><p> 	        name: user<br><p> 	        ttl: 0s<br><p> <br><p> ```
     */
    @JsonProperty("LbPolicy")
    @JsonUnwrapped
    public IsLoadBalancerSettingsLbPolicy getLbPolicy() {
        return lbPolicy;
    }

    /**
     * Load balancing policies to apply for a specific destination. See Envoy's load balancing [documentation](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/load_balancing) for more details.<br><p> <br><p> For example, the following rule uses a round robin load balancing policy for all traffic going to the ratings service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: ROUND_ROBIN<br><p> <br><p> ```<br><p> <br><p> The following example sets up sticky sessions for the ratings service hashing-based load balancer for the same ratings service using the the User cookie as the hash key.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    consistentHash:<br><p> 	      httpCookie:<br><p> 	        name: user<br><p> 	        ttl: 0s<br><p> <br><p> ```
     */
    @JsonProperty("LbPolicy")
    public void setLbPolicy(IsLoadBalancerSettingsLbPolicy lbPolicy) {
        this.lbPolicy = lbPolicy;
    }

    /**
     * Load balancing policies to apply for a specific destination. See Envoy's load balancing [documentation](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/load_balancing) for more details.<br><p> <br><p> For example, the following rule uses a round robin load balancing policy for all traffic going to the ratings service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: ROUND_ROBIN<br><p> <br><p> ```<br><p> <br><p> The following example sets up sticky sessions for the ratings service hashing-based load balancer for the same ratings service using the the User cookie as the hash key.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    consistentHash:<br><p> 	      httpCookie:<br><p> 	        name: user<br><p> 	        ttl: 0s<br><p> <br><p> ```
     */
    @JsonProperty("localityLbSetting")
    public LocalityLoadBalancerSetting getLocalityLbSetting() {
        return localityLbSetting;
    }

    /**
     * Load balancing policies to apply for a specific destination. See Envoy's load balancing [documentation](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/load_balancing) for more details.<br><p> <br><p> For example, the following rule uses a round robin load balancing policy for all traffic going to the ratings service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: ROUND_ROBIN<br><p> <br><p> ```<br><p> <br><p> The following example sets up sticky sessions for the ratings service hashing-based load balancer for the same ratings service using the the User cookie as the hash key.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    consistentHash:<br><p> 	      httpCookie:<br><p> 	        name: user<br><p> 	        ttl: 0s<br><p> <br><p> ```
     */
    @JsonProperty("localityLbSetting")
    public void setLocalityLbSetting(LocalityLoadBalancerSetting localityLbSetting) {
        this.localityLbSetting = localityLbSetting;
    }

    /**
     * Load balancing policies to apply for a specific destination. See Envoy's load balancing [documentation](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/load_balancing) for more details.<br><p> <br><p> For example, the following rule uses a round robin load balancing policy for all traffic going to the ratings service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: ROUND_ROBIN<br><p> <br><p> ```<br><p> <br><p> The following example sets up sticky sessions for the ratings service hashing-based load balancer for the same ratings service using the the User cookie as the hash key.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    consistentHash:<br><p> 	      httpCookie:<br><p> 	        name: user<br><p> 	        ttl: 0s<br><p> <br><p> ```
     */
    @JsonProperty("warmup")
    public WarmupConfiguration getWarmup() {
        return warmup;
    }

    /**
     * Load balancing policies to apply for a specific destination. See Envoy's load balancing [documentation](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/load_balancing) for more details.<br><p> <br><p> For example, the following rule uses a round robin load balancing policy for all traffic going to the ratings service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: ROUND_ROBIN<br><p> <br><p> ```<br><p> <br><p> The following example sets up sticky sessions for the ratings service hashing-based load balancer for the same ratings service using the the User cookie as the hash key.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    consistentHash:<br><p> 	      httpCookie:<br><p> 	        name: user<br><p> 	        ttl: 0s<br><p> <br><p> ```
     */
    @JsonProperty("warmup")
    public void setWarmup(WarmupConfiguration warmup) {
        this.warmup = warmup;
    }

    /**
     * Load balancing policies to apply for a specific destination. See Envoy's load balancing [documentation](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/load_balancing) for more details.<br><p> <br><p> For example, the following rule uses a round robin load balancing policy for all traffic going to the ratings service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: ROUND_ROBIN<br><p> <br><p> ```<br><p> <br><p> The following example sets up sticky sessions for the ratings service hashing-based load balancer for the same ratings service using the the User cookie as the hash key.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    consistentHash:<br><p> 	      httpCookie:<br><p> 	        name: user<br><p> 	        ttl: 0s<br><p> <br><p> ```
     */
    @JsonProperty("warmupDurationSecs")
    public String getWarmupDurationSecs() {
        return warmupDurationSecs;
    }

    /**
     * Load balancing policies to apply for a specific destination. See Envoy's load balancing [documentation](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/load_balancing/load_balancing) for more details.<br><p> <br><p> For example, the following rule uses a round robin load balancing policy for all traffic going to the ratings service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: ROUND_ROBIN<br><p> <br><p> ```<br><p> <br><p> The following example sets up sticky sessions for the ratings service hashing-based load balancer for the same ratings service using the the User cookie as the hash key.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    consistentHash:<br><p> 	      httpCookie:<br><p> 	        name: user<br><p> 	        ttl: 0s<br><p> <br><p> ```
     */
    @JsonProperty("warmupDurationSecs")
    public void setWarmupDurationSecs(String warmupDurationSecs) {
        this.warmupDurationSecs = warmupDurationSecs;
    }

    @JsonIgnore
    public LoadBalancerSettingsBuilder edit() {
        return new LoadBalancerSettingsBuilder(this);
    }

    @JsonIgnore
    public LoadBalancerSettingsBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
