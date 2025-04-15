
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
 * Each routing rule is associated with one or more service versions (see glossary in beginning of document). Weights associated with the version determine the proportion of traffic it receives. For example, the following rule will route 25% of traffic for the "reviews" service to instances with the "v2" tag and the remaining traffic (i.e., 75%) to "v1".<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v2<br><p> 	    weight: 25<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	    weight: 75<br><p> <br><p> ```<br><p> <br><p> # And the associated DestinationRule<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-destination<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	subsets:<br><p> 	- name: v1<br><p> 	  labels:<br><p> 	    version: v1<br><p> 	- name: v2<br><p> 	  labels:<br><p> 	    version: v2<br><p> <br><p> ```<br><p> <br><p> Traffic can also be split across two entirely different services without having to define new subsets. For example, the following rule forwards 25% of traffic to reviews.com to dev.reviews.com<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route-two-domains<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.com<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: dev.reviews.com<br><p> 	    weight: 25<br><p> 	  - destination:<br><p> 	      host: reviews.com<br><p> 	    weight: 75<br><p> <br><p> ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "destination",
    "headers",
    "weight"
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
public class HTTPRouteDestination implements Editable<HTTPRouteDestinationBuilder>, KubernetesResource
{

    @JsonProperty("destination")
    private Destination destination;
    @JsonProperty("headers")
    private Headers headers;
    @JsonProperty("weight")
    private Integer weight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPRouteDestination() {
    }

    public HTTPRouteDestination(Destination destination, Headers headers, Integer weight) {
        super();
        this.destination = destination;
        this.headers = headers;
        this.weight = weight;
    }

    /**
     * Each routing rule is associated with one or more service versions (see glossary in beginning of document). Weights associated with the version determine the proportion of traffic it receives. For example, the following rule will route 25% of traffic for the "reviews" service to instances with the "v2" tag and the remaining traffic (i.e., 75%) to "v1".<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v2<br><p> 	    weight: 25<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	    weight: 75<br><p> <br><p> ```<br><p> <br><p> # And the associated DestinationRule<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-destination<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	subsets:<br><p> 	- name: v1<br><p> 	  labels:<br><p> 	    version: v1<br><p> 	- name: v2<br><p> 	  labels:<br><p> 	    version: v2<br><p> <br><p> ```<br><p> <br><p> Traffic can also be split across two entirely different services without having to define new subsets. For example, the following rule forwards 25% of traffic to reviews.com to dev.reviews.com<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route-two-domains<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.com<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: dev.reviews.com<br><p> 	    weight: 25<br><p> 	  - destination:<br><p> 	      host: reviews.com<br><p> 	    weight: 75<br><p> <br><p> ```
     */
    @JsonProperty("destination")
    public Destination getDestination() {
        return destination;
    }

    /**
     * Each routing rule is associated with one or more service versions (see glossary in beginning of document). Weights associated with the version determine the proportion of traffic it receives. For example, the following rule will route 25% of traffic for the "reviews" service to instances with the "v2" tag and the remaining traffic (i.e., 75%) to "v1".<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v2<br><p> 	    weight: 25<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	    weight: 75<br><p> <br><p> ```<br><p> <br><p> # And the associated DestinationRule<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-destination<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	subsets:<br><p> 	- name: v1<br><p> 	  labels:<br><p> 	    version: v1<br><p> 	- name: v2<br><p> 	  labels:<br><p> 	    version: v2<br><p> <br><p> ```<br><p> <br><p> Traffic can also be split across two entirely different services without having to define new subsets. For example, the following rule forwards 25% of traffic to reviews.com to dev.reviews.com<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route-two-domains<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.com<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: dev.reviews.com<br><p> 	    weight: 25<br><p> 	  - destination:<br><p> 	      host: reviews.com<br><p> 	    weight: 75<br><p> <br><p> ```
     */
    @JsonProperty("destination")
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    /**
     * Each routing rule is associated with one or more service versions (see glossary in beginning of document). Weights associated with the version determine the proportion of traffic it receives. For example, the following rule will route 25% of traffic for the "reviews" service to instances with the "v2" tag and the remaining traffic (i.e., 75%) to "v1".<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v2<br><p> 	    weight: 25<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	    weight: 75<br><p> <br><p> ```<br><p> <br><p> # And the associated DestinationRule<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-destination<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	subsets:<br><p> 	- name: v1<br><p> 	  labels:<br><p> 	    version: v1<br><p> 	- name: v2<br><p> 	  labels:<br><p> 	    version: v2<br><p> <br><p> ```<br><p> <br><p> Traffic can also be split across two entirely different services without having to define new subsets. For example, the following rule forwards 25% of traffic to reviews.com to dev.reviews.com<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route-two-domains<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.com<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: dev.reviews.com<br><p> 	    weight: 25<br><p> 	  - destination:<br><p> 	      host: reviews.com<br><p> 	    weight: 75<br><p> <br><p> ```
     */
    @JsonProperty("headers")
    public Headers getHeaders() {
        return headers;
    }

    /**
     * Each routing rule is associated with one or more service versions (see glossary in beginning of document). Weights associated with the version determine the proportion of traffic it receives. For example, the following rule will route 25% of traffic for the "reviews" service to instances with the "v2" tag and the remaining traffic (i.e., 75%) to "v1".<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v2<br><p> 	    weight: 25<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	    weight: 75<br><p> <br><p> ```<br><p> <br><p> # And the associated DestinationRule<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-destination<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	subsets:<br><p> 	- name: v1<br><p> 	  labels:<br><p> 	    version: v1<br><p> 	- name: v2<br><p> 	  labels:<br><p> 	    version: v2<br><p> <br><p> ```<br><p> <br><p> Traffic can also be split across two entirely different services without having to define new subsets. For example, the following rule forwards 25% of traffic to reviews.com to dev.reviews.com<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route-two-domains<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.com<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: dev.reviews.com<br><p> 	    weight: 25<br><p> 	  - destination:<br><p> 	      host: reviews.com<br><p> 	    weight: 75<br><p> <br><p> ```
     */
    @JsonProperty("headers")
    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    /**
     * Weight specifies the relative proportion of traffic to be forwarded to the destination. A destination will receive `weight/(sum of all weights)` requests. If there is only one destination in a rule, it will receive all traffic. Otherwise, if weight is `0`, the destination will not receive any traffic.
     */
    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    /**
     * Weight specifies the relative proportion of traffic to be forwarded to the destination. A destination will receive `weight/(sum of all weights)` requests. If there is only one destination in a rule, it will receive all traffic. Otherwise, if weight is `0`, the destination will not receive any traffic.
     */
    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonIgnore
    public HTTPRouteDestinationBuilder edit() {
        return new HTTPRouteDestinationBuilder(this);
    }

    @JsonIgnore
    public HTTPRouteDestinationBuilder toBuilder() {
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
