
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
 * HTTPDirectResponse can be used to send a fixed response to clients. For example, the following rule returns a fixed 503 status with a body to requests for /v1/getProductRatings API.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      exact: /v1/getProductRatings<br><p> 	  directResponse:<br><p> 	    status: 503<br><p> 	    body:<br><p> 	      string: "unknown error"<br><p> 	...<br><p> <br><p> ```<br><p> <br><p> It is also possible to specify a binary response body. This is mostly useful for non text-based protocols such as gRPC.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      exact: /v1/getProductRatings<br><p> 	  directResponse:<br><p> 	    status: 503<br><p> 	    body:<br><p> 	      bytes: "dW5rbm93biBlcnJvcg==" # "unknown error" in base64<br><p> 	...<br><p> <br><p> ```<br><p> <br><p> It is good practice to add headers in the HTTPRoute as well as the direct_response, for example to specify the returned Content-Type.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      exact: /v1/getProductRatings<br><p> 	  directResponse:<br><p> 	    status: 503<br><p> 	    body:<br><p> 	      string: "{\"error\": \"unknown error\"}"<br><p> 	  headers:<br><p> 	    response:<br><p> 	      set:<br><p> 	        content-type: "text/plain"<br><p> 	...<br><p> <br><p> ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "body",
    "status"
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
public class HTTPDirectResponse implements Editable<HTTPDirectResponseBuilder>, KubernetesResource
{

    @JsonProperty("body")
    private HTTPBody body;
    @JsonProperty("status")
    private Long status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPDirectResponse() {
    }

    public HTTPDirectResponse(HTTPBody body, Long status) {
        super();
        this.body = body;
        this.status = status;
    }

    /**
     * HTTPDirectResponse can be used to send a fixed response to clients. For example, the following rule returns a fixed 503 status with a body to requests for /v1/getProductRatings API.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      exact: /v1/getProductRatings<br><p> 	  directResponse:<br><p> 	    status: 503<br><p> 	    body:<br><p> 	      string: "unknown error"<br><p> 	...<br><p> <br><p> ```<br><p> <br><p> It is also possible to specify a binary response body. This is mostly useful for non text-based protocols such as gRPC.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      exact: /v1/getProductRatings<br><p> 	  directResponse:<br><p> 	    status: 503<br><p> 	    body:<br><p> 	      bytes: "dW5rbm93biBlcnJvcg==" # "unknown error" in base64<br><p> 	...<br><p> <br><p> ```<br><p> <br><p> It is good practice to add headers in the HTTPRoute as well as the direct_response, for example to specify the returned Content-Type.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      exact: /v1/getProductRatings<br><p> 	  directResponse:<br><p> 	    status: 503<br><p> 	    body:<br><p> 	      string: "{\"error\": \"unknown error\"}"<br><p> 	  headers:<br><p> 	    response:<br><p> 	      set:<br><p> 	        content-type: "text/plain"<br><p> 	...<br><p> <br><p> ```
     */
    @JsonProperty("body")
    public HTTPBody getBody() {
        return body;
    }

    /**
     * HTTPDirectResponse can be used to send a fixed response to clients. For example, the following rule returns a fixed 503 status with a body to requests for /v1/getProductRatings API.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      exact: /v1/getProductRatings<br><p> 	  directResponse:<br><p> 	    status: 503<br><p> 	    body:<br><p> 	      string: "unknown error"<br><p> 	...<br><p> <br><p> ```<br><p> <br><p> It is also possible to specify a binary response body. This is mostly useful for non text-based protocols such as gRPC.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      exact: /v1/getProductRatings<br><p> 	  directResponse:<br><p> 	    status: 503<br><p> 	    body:<br><p> 	      bytes: "dW5rbm93biBlcnJvcg==" # "unknown error" in base64<br><p> 	...<br><p> <br><p> ```<br><p> <br><p> It is good practice to add headers in the HTTPRoute as well as the direct_response, for example to specify the returned Content-Type.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      exact: /v1/getProductRatings<br><p> 	  directResponse:<br><p> 	    status: 503<br><p> 	    body:<br><p> 	      string: "{\"error\": \"unknown error\"}"<br><p> 	  headers:<br><p> 	    response:<br><p> 	      set:<br><p> 	        content-type: "text/plain"<br><p> 	...<br><p> <br><p> ```
     */
    @JsonProperty("body")
    public void setBody(HTTPBody body) {
        this.body = body;
    }

    /**
     * Specifies the HTTP response status to be returned.
     */
    @JsonProperty("status")
    public Long getStatus() {
        return status;
    }

    /**
     * Specifies the HTTP response status to be returned.
     */
    @JsonProperty("status")
    public void setStatus(Long status) {
        this.status = status;
    }

    @JsonIgnore
    public HTTPDirectResponseBuilder edit() {
        return new HTTPDirectResponseBuilder(this);
    }

    @JsonIgnore
    public HTTPDirectResponseBuilder toBuilder() {
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
