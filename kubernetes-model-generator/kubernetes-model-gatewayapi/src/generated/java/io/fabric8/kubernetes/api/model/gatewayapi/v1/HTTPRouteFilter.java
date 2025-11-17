
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
 * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cors",
    "extensionRef",
    "externalAuth",
    "requestHeaderModifier",
    "requestMirror",
    "requestRedirect",
    "responseHeaderModifier",
    "type",
    "urlRewrite"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class HTTPRouteFilter implements Editable<HTTPRouteFilterBuilder>, KubernetesResource
{

    @JsonProperty("cors")
    private HTTPCORSFilter cors;
    @JsonProperty("extensionRef")
    private LocalObjectReference extensionRef;
    @JsonProperty("externalAuth")
    private HTTPExternalAuthFilter externalAuth;
    @JsonProperty("requestHeaderModifier")
    private HTTPHeaderFilter requestHeaderModifier;
    @JsonProperty("requestMirror")
    private HTTPRequestMirrorFilter requestMirror;
    @JsonProperty("requestRedirect")
    private HTTPRequestRedirectFilter requestRedirect;
    @JsonProperty("responseHeaderModifier")
    private HTTPHeaderFilter responseHeaderModifier;
    @JsonProperty("type")
    private String type;
    @JsonProperty("urlRewrite")
    private HTTPURLRewriteFilter urlRewrite;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPRouteFilter() {
    }

    public HTTPRouteFilter(HTTPCORSFilter cors, LocalObjectReference extensionRef, HTTPExternalAuthFilter externalAuth, HTTPHeaderFilter requestHeaderModifier, HTTPRequestMirrorFilter requestMirror, HTTPRequestRedirectFilter requestRedirect, HTTPHeaderFilter responseHeaderModifier, String type, HTTPURLRewriteFilter urlRewrite) {
        super();
        this.cors = cors;
        this.extensionRef = extensionRef;
        this.externalAuth = externalAuth;
        this.requestHeaderModifier = requestHeaderModifier;
        this.requestMirror = requestMirror;
        this.requestRedirect = requestRedirect;
        this.responseHeaderModifier = responseHeaderModifier;
        this.type = type;
        this.urlRewrite = urlRewrite;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("cors")
    public HTTPCORSFilter getCors() {
        return cors;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("cors")
    public void setCors(HTTPCORSFilter cors) {
        this.cors = cors;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("extensionRef")
    public LocalObjectReference getExtensionRef() {
        return extensionRef;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("extensionRef")
    public void setExtensionRef(LocalObjectReference extensionRef) {
        this.extensionRef = extensionRef;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("externalAuth")
    public HTTPExternalAuthFilter getExternalAuth() {
        return externalAuth;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("externalAuth")
    public void setExternalAuth(HTTPExternalAuthFilter externalAuth) {
        this.externalAuth = externalAuth;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("requestHeaderModifier")
    public HTTPHeaderFilter getRequestHeaderModifier() {
        return requestHeaderModifier;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("requestHeaderModifier")
    public void setRequestHeaderModifier(HTTPHeaderFilter requestHeaderModifier) {
        this.requestHeaderModifier = requestHeaderModifier;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("requestMirror")
    public HTTPRequestMirrorFilter getRequestMirror() {
        return requestMirror;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("requestMirror")
    public void setRequestMirror(HTTPRequestMirrorFilter requestMirror) {
        this.requestMirror = requestMirror;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("requestRedirect")
    public HTTPRequestRedirectFilter getRequestRedirect() {
        return requestRedirect;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("requestRedirect")
    public void setRequestRedirect(HTTPRequestRedirectFilter requestRedirect) {
        this.requestRedirect = requestRedirect;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("responseHeaderModifier")
    public HTTPHeaderFilter getResponseHeaderModifier() {
        return responseHeaderModifier;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("responseHeaderModifier")
    public void setResponseHeaderModifier(HTTPHeaderFilter responseHeaderModifier) {
        this.responseHeaderModifier = responseHeaderModifier;
    }

    /**
     * Type identifies the type of filter to apply. As with other API fields, types are classified into three conformance levels:<br><p> <br><p> - Core: Filter types and their corresponding configuration defined by<br><p>   "Support: Core" in this package, e.g. "RequestHeaderModifier". All<br><p>   implementations must support core filters.<br><p> <br><p> - Extended: Filter types and their corresponding configuration defined by<br><p>   "Support: Extended" in this package, e.g. "RequestMirror". Implementers<br><p>   are encouraged to support extended filters.<br><p> <br><p> - Implementation-specific: Filters that are defined and supported by<br><p>   specific vendors.<br><p>   In the future, filters showing convergence in behavior across multiple<br><p>   implementations will be considered for inclusion in extended or core<br><p>   conformance levels. Filter-specific configuration for such filters<br><p>   is specified using the ExtensionRef field. `Type` should be set to<br><p>   "ExtensionRef" for custom filters.<br><p> <br><p> Implementers are encouraged to define custom implementation types to extend the core API with implementation-specific behavior.<br><p> <br><p> If a reference to a custom filter type cannot be resolved, the filter MUST NOT be skipped. Instead, requests that would have been processed by that filter MUST receive a HTTP error response.<br><p> <br><p> Note that values may be added to this enum, implementations must ensure that unknown values will not cause a crash.<br><p> <br><p> Unknown values here must result in the implementation setting the Accepted Condition for the Route to `status: False`, with a Reason of `UnsupportedValue`.<br><p> <br><p> &lt;gateway:experimental:validation:Enum=RequestHeaderModifier;ResponseHeaderModifier;RequestMirror;RequestRedirect;URLRewrite;ExtensionRef;CORS;ExternalAuth&gt;
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type identifies the type of filter to apply. As with other API fields, types are classified into three conformance levels:<br><p> <br><p> - Core: Filter types and their corresponding configuration defined by<br><p>   "Support: Core" in this package, e.g. "RequestHeaderModifier". All<br><p>   implementations must support core filters.<br><p> <br><p> - Extended: Filter types and their corresponding configuration defined by<br><p>   "Support: Extended" in this package, e.g. "RequestMirror". Implementers<br><p>   are encouraged to support extended filters.<br><p> <br><p> - Implementation-specific: Filters that are defined and supported by<br><p>   specific vendors.<br><p>   In the future, filters showing convergence in behavior across multiple<br><p>   implementations will be considered for inclusion in extended or core<br><p>   conformance levels. Filter-specific configuration for such filters<br><p>   is specified using the ExtensionRef field. `Type` should be set to<br><p>   "ExtensionRef" for custom filters.<br><p> <br><p> Implementers are encouraged to define custom implementation types to extend the core API with implementation-specific behavior.<br><p> <br><p> If a reference to a custom filter type cannot be resolved, the filter MUST NOT be skipped. Instead, requests that would have been processed by that filter MUST receive a HTTP error response.<br><p> <br><p> Note that values may be added to this enum, implementations must ensure that unknown values will not cause a crash.<br><p> <br><p> Unknown values here must result in the implementation setting the Accepted Condition for the Route to `status: False`, with a Reason of `UnsupportedValue`.<br><p> <br><p> &lt;gateway:experimental:validation:Enum=RequestHeaderModifier;ResponseHeaderModifier;RequestMirror;RequestRedirect;URLRewrite;ExtensionRef;CORS;ExternalAuth&gt;
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("urlRewrite")
    public HTTPURLRewriteFilter getUrlRewrite() {
        return urlRewrite;
    }

    /**
     * HTTPRouteFilter defines processing steps that must be completed during the request or response lifecycle. HTTPRouteFilters are meant as an extension point to express processing that may be done in Gateway implementations. Some examples include request or response modification, implementing authentication strategies, rate-limiting, and traffic shaping. API guarantee/conformance is defined based on the type of the filter.<br><p> <br><p> &lt;gateway:experimental:validation:XValidation:message="filter.cors must be nil if the filter.type is not CORS",rule="!(has(self.cors) &amp;&amp; self.type != 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.cors must be specified for CORS filter.type",rule="!(!has(self.cors) &amp;&amp; self.type == 'CORS')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be nil if the filter.type is not ExternalAuth",rule="!(has(self.externalAuth) &amp;&amp; self.type != 'ExternalAuth')"&gt; &lt;gateway:experimental:validation:XValidation:message="filter.externalAuth must be specified for ExternalAuth filter.type",rule="!(!has(self.externalAuth) &amp;&amp; self.type == 'ExternalAuth')"&gt;
     */
    @JsonProperty("urlRewrite")
    public void setUrlRewrite(HTTPURLRewriteFilter urlRewrite) {
        this.urlRewrite = urlRewrite;
    }

    @JsonIgnore
    public HTTPRouteFilterBuilder edit() {
        return new HTTPRouteFilterBuilder(this);
    }

    @JsonIgnore
    public HTTPRouteFilterBuilder toBuilder() {
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
