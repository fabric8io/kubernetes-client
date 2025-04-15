
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
 * Delay specification is used to inject latency into the request forwarding path. The following example will introduce a 5 second delay in 1 out of every 1000 requests to the "v1" version of the "reviews" service from all pods with label env: prod<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - sourceLabels:<br><p> 	      env: prod<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  fault:<br><p> 	    delay:<br><p> 	      percentage:<br><p> 	        value: 0.1<br><p> 	      fixedDelay: 5s<br><p> <br><p> ```<br><p> <br><p> The _fixedDelay_ field is used to indicate the amount of delay in seconds. The optional _percentage_ field can be used to only delay a certain percentage of requests. If left unspecified, no request will be delayed.
 */
@JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "HttpDelayType",
    "percent",
    "percentage"
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
public class HTTPFaultInjectionDelay implements Editable<HTTPFaultInjectionDelayBuilder>, KubernetesResource
{

    @JsonProperty("HttpDelayType")
    @JsonUnwrapped
    private IsHTTPFaultInjectionDelayHttpDelayType httpDelayType;
    @JsonProperty("percent")
    private Integer percent;
    @JsonProperty("percentage")
    private Percent percentage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPFaultInjectionDelay() {
    }

    public HTTPFaultInjectionDelay(IsHTTPFaultInjectionDelayHttpDelayType httpDelayType, Integer percent, Percent percentage) {
        super();
        this.httpDelayType = httpDelayType;
        this.percent = percent;
        this.percentage = percentage;
    }

    /**
     * Delay specification is used to inject latency into the request forwarding path. The following example will introduce a 5 second delay in 1 out of every 1000 requests to the "v1" version of the "reviews" service from all pods with label env: prod<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - sourceLabels:<br><p> 	      env: prod<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  fault:<br><p> 	    delay:<br><p> 	      percentage:<br><p> 	        value: 0.1<br><p> 	      fixedDelay: 5s<br><p> <br><p> ```<br><p> <br><p> The _fixedDelay_ field is used to indicate the amount of delay in seconds. The optional _percentage_ field can be used to only delay a certain percentage of requests. If left unspecified, no request will be delayed.
     */
    @JsonProperty("HttpDelayType")
    @JsonUnwrapped
    public IsHTTPFaultInjectionDelayHttpDelayType getHttpDelayType() {
        return httpDelayType;
    }

    /**
     * Delay specification is used to inject latency into the request forwarding path. The following example will introduce a 5 second delay in 1 out of every 1000 requests to the "v1" version of the "reviews" service from all pods with label env: prod<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - sourceLabels:<br><p> 	      env: prod<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  fault:<br><p> 	    delay:<br><p> 	      percentage:<br><p> 	        value: 0.1<br><p> 	      fixedDelay: 5s<br><p> <br><p> ```<br><p> <br><p> The _fixedDelay_ field is used to indicate the amount of delay in seconds. The optional _percentage_ field can be used to only delay a certain percentage of requests. If left unspecified, no request will be delayed.
     */
    @JsonProperty("HttpDelayType")
    public void setHttpDelayType(IsHTTPFaultInjectionDelayHttpDelayType httpDelayType) {
        this.httpDelayType = httpDelayType;
    }

    /**
     * Percentage of requests on which the delay will be injected (0-100). Use of integer `percent` value is deprecated. Use the double `percentage` field instead.<br><p> <br><p> Deprecated: Marked as deprecated in networking/v1alpha3/virtual_service.proto.
     */
    @JsonProperty("percent")
    public Integer getPercent() {
        return percent;
    }

    /**
     * Percentage of requests on which the delay will be injected (0-100). Use of integer `percent` value is deprecated. Use the double `percentage` field instead.<br><p> <br><p> Deprecated: Marked as deprecated in networking/v1alpha3/virtual_service.proto.
     */
    @JsonProperty("percent")
    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    /**
     * Delay specification is used to inject latency into the request forwarding path. The following example will introduce a 5 second delay in 1 out of every 1000 requests to the "v1" version of the "reviews" service from all pods with label env: prod<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - sourceLabels:<br><p> 	      env: prod<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  fault:<br><p> 	    delay:<br><p> 	      percentage:<br><p> 	        value: 0.1<br><p> 	      fixedDelay: 5s<br><p> <br><p> ```<br><p> <br><p> The _fixedDelay_ field is used to indicate the amount of delay in seconds. The optional _percentage_ field can be used to only delay a certain percentage of requests. If left unspecified, no request will be delayed.
     */
    @JsonProperty("percentage")
    public Percent getPercentage() {
        return percentage;
    }

    /**
     * Delay specification is used to inject latency into the request forwarding path. The following example will introduce a 5 second delay in 1 out of every 1000 requests to the "v1" version of the "reviews" service from all pods with label env: prod<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - sourceLabels:<br><p> 	      env: prod<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  fault:<br><p> 	    delay:<br><p> 	      percentage:<br><p> 	        value: 0.1<br><p> 	      fixedDelay: 5s<br><p> <br><p> ```<br><p> <br><p> The _fixedDelay_ field is used to indicate the amount of delay in seconds. The optional _percentage_ field can be used to only delay a certain percentage of requests. If left unspecified, no request will be delayed.
     */
    @JsonProperty("percentage")
    public void setPercentage(Percent percentage) {
        this.percentage = percentage;
    }

    @JsonIgnore
    public HTTPFaultInjectionDelayBuilder edit() {
        return new HTTPFaultInjectionDelayBuilder(this);
    }

    @JsonIgnore
    public HTTPFaultInjectionDelayBuilder toBuilder() {
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
