
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
 * Message headers can be manipulated when Envoy forwards requests to, or responses from, a destination service. Header manipulation rules can be specified for a specific route destination or for all destinations. The following VirtualService adds a `test` header with the value `true` to requests that are routed to any `reviews` service destination. It also removes the `foo` response header, but only from responses coming from the `v1` subset (version) of the `reviews` service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.prod.svc.cluster.local<br><p> 	http:<br><p> 	- headers:<br><p> 	    request:<br><p> 	      set:<br><p> 	        test: "true"<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v2<br><p> 	    weight: 25<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	    headers:<br><p> 	      response:<br><p> 	        remove:<br><p> 	        - foo<br><p> 	    weight: 75<br><p> <br><p> ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "request",
    "response"
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
public class Headers implements Editable<HeadersBuilder>, KubernetesResource
{

    @JsonProperty("request")
    private HeadersHeaderOperations request;
    @JsonProperty("response")
    private HeadersHeaderOperations response;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Headers() {
    }

    public Headers(HeadersHeaderOperations request, HeadersHeaderOperations response) {
        super();
        this.request = request;
        this.response = response;
    }

    /**
     * Message headers can be manipulated when Envoy forwards requests to, or responses from, a destination service. Header manipulation rules can be specified for a specific route destination or for all destinations. The following VirtualService adds a `test` header with the value `true` to requests that are routed to any `reviews` service destination. It also removes the `foo` response header, but only from responses coming from the `v1` subset (version) of the `reviews` service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.prod.svc.cluster.local<br><p> 	http:<br><p> 	- headers:<br><p> 	    request:<br><p> 	      set:<br><p> 	        test: "true"<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v2<br><p> 	    weight: 25<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	    headers:<br><p> 	      response:<br><p> 	        remove:<br><p> 	        - foo<br><p> 	    weight: 75<br><p> <br><p> ```
     */
    @JsonProperty("request")
    public HeadersHeaderOperations getRequest() {
        return request;
    }

    /**
     * Message headers can be manipulated when Envoy forwards requests to, or responses from, a destination service. Header manipulation rules can be specified for a specific route destination or for all destinations. The following VirtualService adds a `test` header with the value `true` to requests that are routed to any `reviews` service destination. It also removes the `foo` response header, but only from responses coming from the `v1` subset (version) of the `reviews` service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.prod.svc.cluster.local<br><p> 	http:<br><p> 	- headers:<br><p> 	    request:<br><p> 	      set:<br><p> 	        test: "true"<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v2<br><p> 	    weight: 25<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	    headers:<br><p> 	      response:<br><p> 	        remove:<br><p> 	        - foo<br><p> 	    weight: 75<br><p> <br><p> ```
     */
    @JsonProperty("request")
    public void setRequest(HeadersHeaderOperations request) {
        this.request = request;
    }

    /**
     * Message headers can be manipulated when Envoy forwards requests to, or responses from, a destination service. Header manipulation rules can be specified for a specific route destination or for all destinations. The following VirtualService adds a `test` header with the value `true` to requests that are routed to any `reviews` service destination. It also removes the `foo` response header, but only from responses coming from the `v1` subset (version) of the `reviews` service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.prod.svc.cluster.local<br><p> 	http:<br><p> 	- headers:<br><p> 	    request:<br><p> 	      set:<br><p> 	        test: "true"<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v2<br><p> 	    weight: 25<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	    headers:<br><p> 	      response:<br><p> 	        remove:<br><p> 	        - foo<br><p> 	    weight: 75<br><p> <br><p> ```
     */
    @JsonProperty("response")
    public HeadersHeaderOperations getResponse() {
        return response;
    }

    /**
     * Message headers can be manipulated when Envoy forwards requests to, or responses from, a destination service. Header manipulation rules can be specified for a specific route destination or for all destinations. The following VirtualService adds a `test` header with the value `true` to requests that are routed to any `reviews` service destination. It also removes the `foo` response header, but only from responses coming from the `v1` subset (version) of the `reviews` service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: reviews-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- reviews.prod.svc.cluster.local<br><p> 	http:<br><p> 	- headers:<br><p> 	    request:<br><p> 	      set:<br><p> 	        test: "true"<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v2<br><p> 	    weight: 25<br><p> 	  - destination:<br><p> 	      host: reviews.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	    headers:<br><p> 	      response:<br><p> 	        remove:<br><p> 	        - foo<br><p> 	    weight: 75<br><p> <br><p> ```
     */
    @JsonProperty("response")
    public void setResponse(HeadersHeaderOperations response) {
        this.response = response;
    }

    @JsonIgnore
    public HeadersBuilder edit() {
        return new HeadersBuilder(this);
    }

    @JsonIgnore
    public HeadersBuilder toBuilder() {
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
