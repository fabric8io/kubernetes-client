
package io.fabric8.knative.sinks.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "level",
    "logMask",
    "loggerName",
    "marker",
    "multiline",
    "showAllProperties",
    "showBody",
    "showBodyType",
    "showCachedStreams",
    "showExchangePattern",
    "showHeaders",
    "showProperties",
    "showStreams"
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
public class Log implements Editable<LogBuilder>, KubernetesResource
{

    @JsonProperty("level")
    private String level;
    @JsonProperty("logMask")
    private Boolean logMask;
    @JsonProperty("loggerName")
    private String loggerName;
    @JsonProperty("marker")
    private String marker;
    @JsonProperty("multiline")
    private Boolean multiline;
    @JsonProperty("showAllProperties")
    private Boolean showAllProperties;
    @JsonProperty("showBody")
    private Boolean showBody;
    @JsonProperty("showBodyType")
    private Boolean showBodyType;
    @JsonProperty("showCachedStreams")
    private Boolean showCachedStreams;
    @JsonProperty("showExchangePattern")
    private Boolean showExchangePattern;
    @JsonProperty("showHeaders")
    private Boolean showHeaders;
    @JsonProperty("showProperties")
    private Boolean showProperties;
    @JsonProperty("showStreams")
    private Boolean showStreams;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Log() {
    }

    public Log(String level, Boolean logMask, String loggerName, String marker, Boolean multiline, Boolean showAllProperties, Boolean showBody, Boolean showBodyType, Boolean showCachedStreams, Boolean showExchangePattern, Boolean showHeaders, Boolean showProperties, Boolean showStreams) {
        super();
        this.level = level;
        this.logMask = logMask;
        this.loggerName = loggerName;
        this.marker = marker;
        this.multiline = multiline;
        this.showAllProperties = showAllProperties;
        this.showBody = showBody;
        this.showBodyType = showBodyType;
        this.showCachedStreams = showCachedStreams;
        this.showExchangePattern = showExchangePattern;
        this.showHeaders = showHeaders;
        this.showProperties = showProperties;
        this.showStreams = showStreams;
    }

    /**
     * Name of the logging category to use
     */
    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    /**
     * Name of the logging category to use
     */
    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Logging level to use
     */
    @JsonProperty("logMask")
    public Boolean getLogMask() {
        return logMask;
    }

    /**
     * Logging level to use
     */
    @JsonProperty("logMask")
    public void setLogMask(Boolean logMask) {
        this.logMask = logMask;
    }

    @JsonProperty("loggerName")
    public String getLoggerName() {
        return loggerName;
    }

    @JsonProperty("loggerName")
    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    /**
     * Mask sensitive information in the log
     */
    @JsonProperty("marker")
    public String getMarker() {
        return marker;
    }

    /**
     * Mask sensitive information in the log
     */
    @JsonProperty("marker")
    public void setMarker(String marker) {
        this.marker = marker;
    }

    /**
     * An optional Marker name to use
     */
    @JsonProperty("multiline")
    public Boolean getMultiline() {
        return multiline;
    }

    /**
     * An optional Marker name to use
     */
    @JsonProperty("multiline")
    public void setMultiline(Boolean multiline) {
        this.multiline = multiline;
    }

    /**
     * If enabled, outputs each information on a newline
     */
    @JsonProperty("showAllProperties")
    public Boolean getShowAllProperties() {
        return showAllProperties;
    }

    /**
     * If enabled, outputs each information on a newline
     */
    @JsonProperty("showAllProperties")
    public void setShowAllProperties(Boolean showAllProperties) {
        this.showAllProperties = showAllProperties;
    }

    /**
     * Show all of the exchange properties (both internal and custom)
     */
    @JsonProperty("showBody")
    public Boolean getShowBody() {
        return showBody;
    }

    /**
     * Show all of the exchange properties (both internal and custom)
     */
    @JsonProperty("showBody")
    public void setShowBody(Boolean showBody) {
        this.showBody = showBody;
    }

    /**
     * Show the message body
     */
    @JsonProperty("showBodyType")
    public Boolean getShowBodyType() {
        return showBodyType;
    }

    /**
     * Show the message body
     */
    @JsonProperty("showBodyType")
    public void setShowBodyType(Boolean showBodyType) {
        this.showBodyType = showBodyType;
    }

    /**
     * Show the stream bodies
     */
    @JsonProperty("showCachedStreams")
    public Boolean getShowCachedStreams() {
        return showCachedStreams;
    }

    /**
     * Show the stream bodies
     */
    @JsonProperty("showCachedStreams")
    public void setShowCachedStreams(Boolean showCachedStreams) {
        this.showCachedStreams = showCachedStreams;
    }

    /**
     * Show the body Java type
     */
    @JsonProperty("showExchangePattern")
    public Boolean getShowExchangePattern() {
        return showExchangePattern;
    }

    /**
     * Show the body Java type
     */
    @JsonProperty("showExchangePattern")
    public void setShowExchangePattern(Boolean showExchangePattern) {
        this.showExchangePattern = showExchangePattern;
    }

    /**
     * Show the Message Exchange Pattern (MEP)
     */
    @JsonProperty("showHeaders")
    public Boolean getShowHeaders() {
        return showHeaders;
    }

    /**
     * Show the Message Exchange Pattern (MEP)
     */
    @JsonProperty("showHeaders")
    public void setShowHeaders(Boolean showHeaders) {
        this.showHeaders = showHeaders;
    }

    /**
     * Show the headers received
     */
    @JsonProperty("showProperties")
    public Boolean getShowProperties() {
        return showProperties;
    }

    /**
     * Show the headers received
     */
    @JsonProperty("showProperties")
    public void setShowProperties(Boolean showProperties) {
        this.showProperties = showProperties;
    }

    /**
     * Show the exchange properties (only custom)
     */
    @JsonProperty("showStreams")
    public Boolean getShowStreams() {
        return showStreams;
    }

    /**
     * Show the exchange properties (only custom)
     */
    @JsonProperty("showStreams")
    public void setShowStreams(Boolean showStreams) {
        this.showStreams = showStreams;
    }

    @JsonIgnore
    public LogBuilder edit() {
        return new LogBuilder(this);
    }

    @JsonIgnore
    public LogBuilder toBuilder() {
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
