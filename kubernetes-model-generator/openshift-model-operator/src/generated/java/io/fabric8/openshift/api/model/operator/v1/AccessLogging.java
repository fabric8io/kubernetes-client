
package io.fabric8.openshift.api.model.operator.v1;

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
 * AccessLogging describes how client requests should be logged.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "destination",
    "httpCaptureCookies",
    "httpCaptureHeaders",
    "httpLogFormat",
    "logEmptyRequests"
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
public class AccessLogging implements Editable<AccessLoggingBuilder>, KubernetesResource
{

    @JsonProperty("destination")
    private LoggingDestination destination;
    @JsonProperty("httpCaptureCookies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressControllerCaptureHTTPCookie> httpCaptureCookies = new ArrayList<>();
    @JsonProperty("httpCaptureHeaders")
    private IngressControllerCaptureHTTPHeaders httpCaptureHeaders;
    @JsonProperty("httpLogFormat")
    private String httpLogFormat;
    @JsonProperty("logEmptyRequests")
    private String logEmptyRequests;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AccessLogging() {
    }

    public AccessLogging(LoggingDestination destination, List<IngressControllerCaptureHTTPCookie> httpCaptureCookies, IngressControllerCaptureHTTPHeaders httpCaptureHeaders, String httpLogFormat, String logEmptyRequests) {
        super();
        this.destination = destination;
        this.httpCaptureCookies = httpCaptureCookies;
        this.httpCaptureHeaders = httpCaptureHeaders;
        this.httpLogFormat = httpLogFormat;
        this.logEmptyRequests = logEmptyRequests;
    }

    /**
     * AccessLogging describes how client requests should be logged.
     */
    @JsonProperty("destination")
    public LoggingDestination getDestination() {
        return destination;
    }

    /**
     * AccessLogging describes how client requests should be logged.
     */
    @JsonProperty("destination")
    public void setDestination(LoggingDestination destination) {
        this.destination = destination;
    }

    /**
     * httpCaptureCookies specifies HTTP cookies that should be captured in access logs.  If this field is empty, no cookies are captured.
     */
    @JsonProperty("httpCaptureCookies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IngressControllerCaptureHTTPCookie> getHttpCaptureCookies() {
        return httpCaptureCookies;
    }

    /**
     * httpCaptureCookies specifies HTTP cookies that should be captured in access logs.  If this field is empty, no cookies are captured.
     */
    @JsonProperty("httpCaptureCookies")
    public void setHttpCaptureCookies(List<IngressControllerCaptureHTTPCookie> httpCaptureCookies) {
        this.httpCaptureCookies = httpCaptureCookies;
    }

    /**
     * AccessLogging describes how client requests should be logged.
     */
    @JsonProperty("httpCaptureHeaders")
    public IngressControllerCaptureHTTPHeaders getHttpCaptureHeaders() {
        return httpCaptureHeaders;
    }

    /**
     * AccessLogging describes how client requests should be logged.
     */
    @JsonProperty("httpCaptureHeaders")
    public void setHttpCaptureHeaders(IngressControllerCaptureHTTPHeaders httpCaptureHeaders) {
        this.httpCaptureHeaders = httpCaptureHeaders;
    }

    /**
     * httpLogFormat specifies the format of the log message for an HTTP request.<br><p> <br><p> If this field is empty, log messages use the implementation's default HTTP log format.  For HAProxy's default HTTP log format, see the HAProxy documentation: http://cbonte.github.io/haproxy-dconv/2.0/configuration.html#8.2.3<br><p> <br><p> Note that this format only applies to cleartext HTTP connections and to secure HTTP connections for which the ingress controller terminates encryption (that is, edge-terminated or reencrypt connections).  It does not affect the log format for TLS passthrough connections.
     */
    @JsonProperty("httpLogFormat")
    public String getHttpLogFormat() {
        return httpLogFormat;
    }

    /**
     * httpLogFormat specifies the format of the log message for an HTTP request.<br><p> <br><p> If this field is empty, log messages use the implementation's default HTTP log format.  For HAProxy's default HTTP log format, see the HAProxy documentation: http://cbonte.github.io/haproxy-dconv/2.0/configuration.html#8.2.3<br><p> <br><p> Note that this format only applies to cleartext HTTP connections and to secure HTTP connections for which the ingress controller terminates encryption (that is, edge-terminated or reencrypt connections).  It does not affect the log format for TLS passthrough connections.
     */
    @JsonProperty("httpLogFormat")
    public void setHttpLogFormat(String httpLogFormat) {
        this.httpLogFormat = httpLogFormat;
    }

    /**
     * logEmptyRequests specifies how connections on which no request is received should be logged.  Typically, these empty requests come from load balancers' health probes or Web browsers' speculative connections ("preconnect"), in which case logging these requests may be undesirable.  However, these requests may also be caused by network errors, in which case logging empty requests may be useful for diagnosing the errors.  In addition, these requests may be caused by port scans, in which case logging empty requests may aid in detecting intrusion attempts.  Allowed values for this field are "Log" and "Ignore".  The default value is "Log".
     */
    @JsonProperty("logEmptyRequests")
    public String getLogEmptyRequests() {
        return logEmptyRequests;
    }

    /**
     * logEmptyRequests specifies how connections on which no request is received should be logged.  Typically, these empty requests come from load balancers' health probes or Web browsers' speculative connections ("preconnect"), in which case logging these requests may be undesirable.  However, these requests may also be caused by network errors, in which case logging empty requests may be useful for diagnosing the errors.  In addition, these requests may be caused by port scans, in which case logging empty requests may aid in detecting intrusion attempts.  Allowed values for this field are "Log" and "Ignore".  The default value is "Log".
     */
    @JsonProperty("logEmptyRequests")
    public void setLogEmptyRequests(String logEmptyRequests) {
        this.logEmptyRequests = logEmptyRequests;
    }

    @JsonIgnore
    public AccessLoggingBuilder edit() {
        return new AccessLoggingBuilder(this);
    }

    @JsonIgnore
    public AccessLoggingBuilder toBuilder() {
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
