
package io.fabric8.openshift.api.model.operator.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "destination",
    "httpCaptureCookies",
    "httpCaptureHeaders",
    "httpLogFormat"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class AccessLogging implements KubernetesResource
{

    @JsonProperty("destination")
    private LoggingDestination destination;
    @JsonProperty("httpCaptureCookies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressControllerCaptureHTTPCookie> httpCaptureCookies = new ArrayList<IngressControllerCaptureHTTPCookie>();
    @JsonProperty("httpCaptureHeaders")
    private IngressControllerCaptureHTTPHeaders httpCaptureHeaders;
    @JsonProperty("httpLogFormat")
    private String httpLogFormat;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AccessLogging() {
    }

    /**
     * 
     * @param httpLogFormat
     * @param httpCaptureHeaders
     * @param destination
     * @param httpCaptureCookies
     */
    public AccessLogging(LoggingDestination destination, List<IngressControllerCaptureHTTPCookie> httpCaptureCookies, IngressControllerCaptureHTTPHeaders httpCaptureHeaders, String httpLogFormat) {
        super();
        this.destination = destination;
        this.httpCaptureCookies = httpCaptureCookies;
        this.httpCaptureHeaders = httpCaptureHeaders;
        this.httpLogFormat = httpLogFormat;
    }

    @JsonProperty("destination")
    public LoggingDestination getDestination() {
        return destination;
    }

    @JsonProperty("destination")
    public void setDestination(LoggingDestination destination) {
        this.destination = destination;
    }

    @JsonProperty("httpCaptureCookies")
    public List<IngressControllerCaptureHTTPCookie> getHttpCaptureCookies() {
        return httpCaptureCookies;
    }

    @JsonProperty("httpCaptureCookies")
    public void setHttpCaptureCookies(List<IngressControllerCaptureHTTPCookie> httpCaptureCookies) {
        this.httpCaptureCookies = httpCaptureCookies;
    }

    @JsonProperty("httpCaptureHeaders")
    public IngressControllerCaptureHTTPHeaders getHttpCaptureHeaders() {
        return httpCaptureHeaders;
    }

    @JsonProperty("httpCaptureHeaders")
    public void setHttpCaptureHeaders(IngressControllerCaptureHTTPHeaders httpCaptureHeaders) {
        this.httpCaptureHeaders = httpCaptureHeaders;
    }

    @JsonProperty("httpLogFormat")
    public String getHttpLogFormat() {
        return httpLogFormat;
    }

    @JsonProperty("httpLogFormat")
    public void setHttpLogFormat(String httpLogFormat) {
        this.httpLogFormat = httpLogFormat;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
