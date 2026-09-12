
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Log)) {
            return false;
        }
        Log other = (Log) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$level = this.getLevel();
        Object other$level = other.getLevel();
        if (this$level == null ? other$level != null : !this$level.equals(other$level)) {
            return false;
        }
        Object this$logMask = this.getLogMask();
        Object other$logMask = other.getLogMask();
        if (this$logMask == null ? other$logMask != null : !this$logMask.equals(other$logMask)) {
            return false;
        }
        Object this$loggerName = this.getLoggerName();
        Object other$loggerName = other.getLoggerName();
        if (this$loggerName == null ? other$loggerName != null : !this$loggerName.equals(other$loggerName)) {
            return false;
        }
        Object this$marker = this.getMarker();
        Object other$marker = other.getMarker();
        if (this$marker == null ? other$marker != null : !this$marker.equals(other$marker)) {
            return false;
        }
        Object this$multiline = this.getMultiline();
        Object other$multiline = other.getMultiline();
        if (this$multiline == null ? other$multiline != null : !this$multiline.equals(other$multiline)) {
            return false;
        }
        Object this$showAllProperties = this.getShowAllProperties();
        Object other$showAllProperties = other.getShowAllProperties();
        if (this$showAllProperties == null ? other$showAllProperties != null : !this$showAllProperties.equals(other$showAllProperties)) {
            return false;
        }
        Object this$showBody = this.getShowBody();
        Object other$showBody = other.getShowBody();
        if (this$showBody == null ? other$showBody != null : !this$showBody.equals(other$showBody)) {
            return false;
        }
        Object this$showBodyType = this.getShowBodyType();
        Object other$showBodyType = other.getShowBodyType();
        if (this$showBodyType == null ? other$showBodyType != null : !this$showBodyType.equals(other$showBodyType)) {
            return false;
        }
        Object this$showCachedStreams = this.getShowCachedStreams();
        Object other$showCachedStreams = other.getShowCachedStreams();
        if (this$showCachedStreams == null ? other$showCachedStreams != null : !this$showCachedStreams.equals(other$showCachedStreams)) {
            return false;
        }
        Object this$showExchangePattern = this.getShowExchangePattern();
        Object other$showExchangePattern = other.getShowExchangePattern();
        if (this$showExchangePattern == null ? other$showExchangePattern != null : !this$showExchangePattern.equals(other$showExchangePattern)) {
            return false;
        }
        Object this$showHeaders = this.getShowHeaders();
        Object other$showHeaders = other.getShowHeaders();
        if (this$showHeaders == null ? other$showHeaders != null : !this$showHeaders.equals(other$showHeaders)) {
            return false;
        }
        Object this$showProperties = this.getShowProperties();
        Object other$showProperties = other.getShowProperties();
        if (this$showProperties == null ? other$showProperties != null : !this$showProperties.equals(other$showProperties)) {
            return false;
        }
        Object this$showStreams = this.getShowStreams();
        Object other$showStreams = other.getShowStreams();
        if (this$showStreams == null ? other$showStreams != null : !this$showStreams.equals(other$showStreams)) {
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
        return other instanceof Log;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $level = this.getLevel();
        result = result * prime + ($level == null ? 43 : $level.hashCode());
        Object $logMask = this.getLogMask();
        result = result * prime + ($logMask == null ? 43 : $logMask.hashCode());
        Object $loggerName = this.getLoggerName();
        result = result * prime + ($loggerName == null ? 43 : $loggerName.hashCode());
        Object $marker = this.getMarker();
        result = result * prime + ($marker == null ? 43 : $marker.hashCode());
        Object $multiline = this.getMultiline();
        result = result * prime + ($multiline == null ? 43 : $multiline.hashCode());
        Object $showAllProperties = this.getShowAllProperties();
        result = result * prime + ($showAllProperties == null ? 43 : $showAllProperties.hashCode());
        Object $showBody = this.getShowBody();
        result = result * prime + ($showBody == null ? 43 : $showBody.hashCode());
        Object $showBodyType = this.getShowBodyType();
        result = result * prime + ($showBodyType == null ? 43 : $showBodyType.hashCode());
        Object $showCachedStreams = this.getShowCachedStreams();
        result = result * prime + ($showCachedStreams == null ? 43 : $showCachedStreams.hashCode());
        Object $showExchangePattern = this.getShowExchangePattern();
        result = result * prime + ($showExchangePattern == null ? 43 : $showExchangePattern.hashCode());
        Object $showHeaders = this.getShowHeaders();
        result = result * prime + ($showHeaders == null ? 43 : $showHeaders.hashCode());
        Object $showProperties = this.getShowProperties();
        result = result * prime + ($showProperties == null ? 43 : $showProperties.hashCode());
        Object $showStreams = this.getShowStreams();
        result = result * prime + ($showStreams == null ? 43 : $showStreams.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Log(" + "level=" + this.getLevel() + ", logMask=" + this.getLogMask() + ", loggerName=" + this.getLoggerName() + ", marker=" + this.getMarker() + ", multiline=" + this.getMultiline() + ", showAllProperties=" + this.getShowAllProperties() + ", showBody=" + this.getShowBody() + ", showBodyType=" + this.getShowBodyType() + ", showCachedStreams=" + this.getShowCachedStreams() + ", showExchangePattern=" + this.getShowExchangePattern() + ", showHeaders=" + this.getShowHeaders() + ", showProperties=" + this.getShowProperties() + ", showStreams=" + this.getShowStreams() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
