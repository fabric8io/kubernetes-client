
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

/**
 * A subset of endpoints of a service. Subsets can be used for scenarios like A/B testing, or routing to a specific version of a service. Refer to [VirtualService](https://istio.io/docs/reference/config/networking/virtual-service/#VirtualService) documentation for examples of using subsets in these scenarios. In addition, traffic policies defined at the service-level can be overridden at a subset-level. The following rule uses a round robin load balancing policy for all traffic going to a subset named testversion that is composed of endpoints (e.g., pods) with labels (version:v3).<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: LEAST_REQUEST<br><p> 	subsets:<br><p> 	- name: testversion<br><p> 	  labels:<br><p> 	    version: v3<br><p> 	  trafficPolicy:<br><p> 	    loadBalancer:<br><p> 	      simple: ROUND_ROBIN<br><p> <br><p> ```<br><p> <br><p> &#42;&#42;Note:&#42;&#42; Policies specified for subsets will not take effect until a route rule explicitly sends traffic to this subset.<br><p> <br><p> One or more labels are typically required to identify the subset destination, however, when the corresponding DestinationRule represents a host that supports multiple SNI hosts (e.g., an egress gateway), a subset without labels may be meaningful. In this case a traffic policy with [ClientTLSSettings](#ClientTLSSettings) can be used to identify a specific SNI host corresponding to the named subset.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "labels",
    "name",
    "trafficPolicy"
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
public class Subset implements Editable<SubsetBuilder>, KubernetesResource
{

    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("trafficPolicy")
    private TrafficPolicy trafficPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Subset() {
    }

    public Subset(Map<String, String> labels, String name, TrafficPolicy trafficPolicy) {
        super();
        this.labels = labels;
        this.name = name;
        this.trafficPolicy = trafficPolicy;
    }

    /**
     * Labels apply a filter over the endpoints of a service in the service registry. See route rules for examples of usage.
     */
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * Labels apply a filter over the endpoints of a service in the service registry. See route rules for examples of usage.
     */
    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    /**
     * Name of the subset. The service name and the subset name can be used for traffic splitting in a route rule.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the subset. The service name and the subset name can be used for traffic splitting in a route rule.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A subset of endpoints of a service. Subsets can be used for scenarios like A/B testing, or routing to a specific version of a service. Refer to [VirtualService](https://istio.io/docs/reference/config/networking/virtual-service/#VirtualService) documentation for examples of using subsets in these scenarios. In addition, traffic policies defined at the service-level can be overridden at a subset-level. The following rule uses a round robin load balancing policy for all traffic going to a subset named testversion that is composed of endpoints (e.g., pods) with labels (version:v3).<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: LEAST_REQUEST<br><p> 	subsets:<br><p> 	- name: testversion<br><p> 	  labels:<br><p> 	    version: v3<br><p> 	  trafficPolicy:<br><p> 	    loadBalancer:<br><p> 	      simple: ROUND_ROBIN<br><p> <br><p> ```<br><p> <br><p> &#42;&#42;Note:&#42;&#42; Policies specified for subsets will not take effect until a route rule explicitly sends traffic to this subset.<br><p> <br><p> One or more labels are typically required to identify the subset destination, however, when the corresponding DestinationRule represents a host that supports multiple SNI hosts (e.g., an egress gateway), a subset without labels may be meaningful. In this case a traffic policy with [ClientTLSSettings](#ClientTLSSettings) can be used to identify a specific SNI host corresponding to the named subset.
     */
    @JsonProperty("trafficPolicy")
    public TrafficPolicy getTrafficPolicy() {
        return trafficPolicy;
    }

    /**
     * A subset of endpoints of a service. Subsets can be used for scenarios like A/B testing, or routing to a specific version of a service. Refer to [VirtualService](https://istio.io/docs/reference/config/networking/virtual-service/#VirtualService) documentation for examples of using subsets in these scenarios. In addition, traffic policies defined at the service-level can be overridden at a subset-level. The following rule uses a round robin load balancing policy for all traffic going to a subset named testversion that is composed of endpoints (e.g., pods) with labels (version:v3).<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: bookinfo-ratings<br><p> <br><p> spec:<br><p> <br><p> 	host: ratings.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  loadBalancer:<br><p> 	    simple: LEAST_REQUEST<br><p> 	subsets:<br><p> 	- name: testversion<br><p> 	  labels:<br><p> 	    version: v3<br><p> 	  trafficPolicy:<br><p> 	    loadBalancer:<br><p> 	      simple: ROUND_ROBIN<br><p> <br><p> ```<br><p> <br><p> &#42;&#42;Note:&#42;&#42; Policies specified for subsets will not take effect until a route rule explicitly sends traffic to this subset.<br><p> <br><p> One or more labels are typically required to identify the subset destination, however, when the corresponding DestinationRule represents a host that supports multiple SNI hosts (e.g., an egress gateway), a subset without labels may be meaningful. In this case a traffic policy with [ClientTLSSettings](#ClientTLSSettings) can be used to identify a specific SNI host corresponding to the named subset.
     */
    @JsonProperty("trafficPolicy")
    public void setTrafficPolicy(TrafficPolicy trafficPolicy) {
        this.trafficPolicy = trafficPolicy;
    }

    @JsonIgnore
    public SubsetBuilder edit() {
        return new SubsetBuilder(this);
    }

    @JsonIgnore
    public SubsetBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Subset)) {
            return false;
        }
        Subset other = (Subset) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$labels = this.getLabels();
        Object other$labels = other.getLabels();
        if (this$labels == null ? other$labels != null : !this$labels.equals(other$labels)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$trafficPolicy = this.getTrafficPolicy();
        Object other$trafficPolicy = other.getTrafficPolicy();
        if (this$trafficPolicy == null ? other$trafficPolicy != null : !this$trafficPolicy.equals(other$trafficPolicy)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Subset;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $labels = this.getLabels();
        result = result * prime + ($labels == null ? 43 : $labels.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $trafficPolicy = this.getTrafficPolicy();
        result = result * prime + ($trafficPolicy == null ? 43 : $trafficPolicy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Subset(" + "labels=" + this.getLabels() + ", name=" + this.getName() + ", trafficPolicy=" + this.getTrafficPolicy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
