
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
 * HTTPRedirect can be used to send a 301 redirect response to the caller, where the Authority/Host and the URI in the response can be swapped with the specified values. For example, the following rule redirects requests for /v1/getProductRatings API on the ratings service to /v1/bookRatings provided by the bookratings service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      exact: /v1/getProductRatings<br><p> 	  redirect:<br><p> 	    uri: /v1/bookRatings<br><p> 	    authority: newratings.default.svc.cluster.local<br><p> 	...<br><p> <br><p> ```
 */
@JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "RedirectPort",
    "authority",
    "redirectCode",
    "scheme",
    "uri"
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
public class HTTPRedirect implements Editable<HTTPRedirectBuilder>, KubernetesResource
{

    @JsonProperty("RedirectPort")
    @JsonUnwrapped
    private IsHTTPRedirectRedirectPort redirectPort;
    @JsonProperty("authority")
    private String authority;
    @JsonProperty("redirectCode")
    private Long redirectCode;
    @JsonProperty("scheme")
    private String scheme;
    @JsonProperty("uri")
    private String uri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPRedirect() {
    }

    public HTTPRedirect(IsHTTPRedirectRedirectPort redirectPort, String authority, Long redirectCode, String scheme, String uri) {
        super();
        this.redirectPort = redirectPort;
        this.authority = authority;
        this.redirectCode = redirectCode;
        this.scheme = scheme;
        this.uri = uri;
    }

    /**
     * HTTPRedirect can be used to send a 301 redirect response to the caller, where the Authority/Host and the URI in the response can be swapped with the specified values. For example, the following rule redirects requests for /v1/getProductRatings API on the ratings service to /v1/bookRatings provided by the bookratings service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      exact: /v1/getProductRatings<br><p> 	  redirect:<br><p> 	    uri: /v1/bookRatings<br><p> 	    authority: newratings.default.svc.cluster.local<br><p> 	...<br><p> <br><p> ```
     */
    @JsonProperty("RedirectPort")
    @JsonUnwrapped
    public IsHTTPRedirectRedirectPort getRedirectPort() {
        return redirectPort;
    }

    /**
     * HTTPRedirect can be used to send a 301 redirect response to the caller, where the Authority/Host and the URI in the response can be swapped with the specified values. For example, the following rule redirects requests for /v1/getProductRatings API on the ratings service to /v1/bookRatings provided by the bookratings service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      exact: /v1/getProductRatings<br><p> 	  redirect:<br><p> 	    uri: /v1/bookRatings<br><p> 	    authority: newratings.default.svc.cluster.local<br><p> 	...<br><p> <br><p> ```
     */
    @JsonProperty("RedirectPort")
    public void setRedirectPort(IsHTTPRedirectRedirectPort redirectPort) {
        this.redirectPort = redirectPort;
    }

    /**
     * On a redirect, overwrite the Authority/Host portion of the URL with this value.
     */
    @JsonProperty("authority")
    public String getAuthority() {
        return authority;
    }

    /**
     * On a redirect, overwrite the Authority/Host portion of the URL with this value.
     */
    @JsonProperty("authority")
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * On a redirect, Specifies the HTTP status code to use in the redirect response. The default response code is MOVED_PERMANENTLY (301).
     */
    @JsonProperty("redirectCode")
    public Long getRedirectCode() {
        return redirectCode;
    }

    /**
     * On a redirect, Specifies the HTTP status code to use in the redirect response. The default response code is MOVED_PERMANENTLY (301).
     */
    @JsonProperty("redirectCode")
    public void setRedirectCode(Long redirectCode) {
        this.redirectCode = redirectCode;
    }

    /**
     * On a redirect, overwrite the scheme portion of the URL with this value. For example, `http` or `https`. If unset, the original scheme will be used. If `derivePort` is set to `FROM_PROTOCOL_DEFAULT`, this will impact the port used as well
     */
    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    /**
     * On a redirect, overwrite the scheme portion of the URL with this value. For example, `http` or `https`. If unset, the original scheme will be used. If `derivePort` is set to `FROM_PROTOCOL_DEFAULT`, this will impact the port used as well
     */
    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    /**
     * On a redirect, overwrite the Path portion of the URL with this value. Note that the entire path will be replaced, irrespective of the request URI being matched as an exact path or prefix.
     */
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    /**
     * On a redirect, overwrite the Path portion of the URL with this value. Note that the entire path will be replaced, irrespective of the request URI being matched as an exact path or prefix.
     */
    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonIgnore
    public HTTPRedirectBuilder edit() {
        return new HTTPRedirectBuilder(this);
    }

    @JsonIgnore
    public HTTPRedirectBuilder toBuilder() {
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
