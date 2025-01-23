
package io.fabric8.knative.sinks.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
     * 
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

    @JsonProperty("level")
    public String getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(String level) {
        this.level = level;
    }

    @JsonProperty("logMask")
    public Boolean getLogMask() {
        return logMask;
    }

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

    @JsonProperty("marker")
    public String getMarker() {
        return marker;
    }

    @JsonProperty("marker")
    public void setMarker(String marker) {
        this.marker = marker;
    }

    @JsonProperty("multiline")
    public Boolean getMultiline() {
        return multiline;
    }

    @JsonProperty("multiline")
    public void setMultiline(Boolean multiline) {
        this.multiline = multiline;
    }

    @JsonProperty("showAllProperties")
    public Boolean getShowAllProperties() {
        return showAllProperties;
    }

    @JsonProperty("showAllProperties")
    public void setShowAllProperties(Boolean showAllProperties) {
        this.showAllProperties = showAllProperties;
    }

    @JsonProperty("showBody")
    public Boolean getShowBody() {
        return showBody;
    }

    @JsonProperty("showBody")
    public void setShowBody(Boolean showBody) {
        this.showBody = showBody;
    }

    @JsonProperty("showBodyType")
    public Boolean getShowBodyType() {
        return showBodyType;
    }

    @JsonProperty("showBodyType")
    public void setShowBodyType(Boolean showBodyType) {
        this.showBodyType = showBodyType;
    }

    @JsonProperty("showCachedStreams")
    public Boolean getShowCachedStreams() {
        return showCachedStreams;
    }

    @JsonProperty("showCachedStreams")
    public void setShowCachedStreams(Boolean showCachedStreams) {
        this.showCachedStreams = showCachedStreams;
    }

    @JsonProperty("showExchangePattern")
    public Boolean getShowExchangePattern() {
        return showExchangePattern;
    }

    @JsonProperty("showExchangePattern")
    public void setShowExchangePattern(Boolean showExchangePattern) {
        this.showExchangePattern = showExchangePattern;
    }

    @JsonProperty("showHeaders")
    public Boolean getShowHeaders() {
        return showHeaders;
    }

    @JsonProperty("showHeaders")
    public void setShowHeaders(Boolean showHeaders) {
        this.showHeaders = showHeaders;
    }

    @JsonProperty("showProperties")
    public Boolean getShowProperties() {
        return showProperties;
    }

    @JsonProperty("showProperties")
    public void setShowProperties(Boolean showProperties) {
        this.showProperties = showProperties;
    }

    @JsonProperty("showStreams")
    public Boolean getShowStreams() {
        return showStreams;
    }

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
