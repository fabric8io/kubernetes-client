
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "baseEjectionTime",
    "consecutive5xxErrors",
    "consecutiveErrors",
    "consecutiveGatewayErrors",
    "consecutiveLocalOriginFailures",
    "interval",
    "maxEjectionPercent",
    "minHealthPercent",
    "splitExternalLocalOriginErrors"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class OutlierDetection implements KubernetesResource
{

    @JsonProperty("baseEjectionTime")
    private String baseEjectionTime;
    @JsonProperty("consecutive5xxErrors")
    private Integer consecutive5xxErrors;
    @JsonProperty("consecutiveErrors")
    private Integer consecutiveErrors;
    @JsonProperty("consecutiveGatewayErrors")
    private Integer consecutiveGatewayErrors;
    @JsonProperty("consecutiveLocalOriginFailures")
    private Integer consecutiveLocalOriginFailures;
    @JsonProperty("interval")
    private String interval;
    @JsonProperty("maxEjectionPercent")
    private Integer maxEjectionPercent;
    @JsonProperty("minHealthPercent")
    private Integer minHealthPercent;
    @JsonProperty("splitExternalLocalOriginErrors")
    private Boolean splitExternalLocalOriginErrors;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OutlierDetection() {
    }

    /**
     * 
     * @param minHealthPercent
     * @param splitExternalLocalOriginErrors
     * @param baseEjectionTime
     * @param consecutive5xxErrors
     * @param consecutiveErrors
     * @param consecutiveGatewayErrors
     * @param consecutiveLocalOriginFailures
     * @param interval
     * @param maxEjectionPercent
     */
    public OutlierDetection(String baseEjectionTime, Integer consecutive5xxErrors, Integer consecutiveErrors, Integer consecutiveGatewayErrors, Integer consecutiveLocalOriginFailures, String interval, Integer maxEjectionPercent, Integer minHealthPercent, Boolean splitExternalLocalOriginErrors) {
        super();
        this.baseEjectionTime = baseEjectionTime;
        this.consecutive5xxErrors = consecutive5xxErrors;
        this.consecutiveErrors = consecutiveErrors;
        this.consecutiveGatewayErrors = consecutiveGatewayErrors;
        this.consecutiveLocalOriginFailures = consecutiveLocalOriginFailures;
        this.interval = interval;
        this.maxEjectionPercent = maxEjectionPercent;
        this.minHealthPercent = minHealthPercent;
        this.splitExternalLocalOriginErrors = splitExternalLocalOriginErrors;
    }

    @JsonProperty("baseEjectionTime")
    public String getBaseEjectionTime() {
        return baseEjectionTime;
    }

    @JsonProperty("baseEjectionTime")
    public void setBaseEjectionTime(String baseEjectionTime) {
        this.baseEjectionTime = baseEjectionTime;
    }

    @JsonProperty("consecutive5xxErrors")
    public Integer getConsecutive5xxErrors() {
        return consecutive5xxErrors;
    }

    @JsonProperty("consecutive5xxErrors")
    public void setConsecutive5xxErrors(Integer consecutive5xxErrors) {
        this.consecutive5xxErrors = consecutive5xxErrors;
    }

    @JsonProperty("consecutiveErrors")
    public Integer getConsecutiveErrors() {
        return consecutiveErrors;
    }

    @JsonProperty("consecutiveErrors")
    public void setConsecutiveErrors(Integer consecutiveErrors) {
        this.consecutiveErrors = consecutiveErrors;
    }

    @JsonProperty("consecutiveGatewayErrors")
    public Integer getConsecutiveGatewayErrors() {
        return consecutiveGatewayErrors;
    }

    @JsonProperty("consecutiveGatewayErrors")
    public void setConsecutiveGatewayErrors(Integer consecutiveGatewayErrors) {
        this.consecutiveGatewayErrors = consecutiveGatewayErrors;
    }

    @JsonProperty("consecutiveLocalOriginFailures")
    public Integer getConsecutiveLocalOriginFailures() {
        return consecutiveLocalOriginFailures;
    }

    @JsonProperty("consecutiveLocalOriginFailures")
    public void setConsecutiveLocalOriginFailures(Integer consecutiveLocalOriginFailures) {
        this.consecutiveLocalOriginFailures = consecutiveLocalOriginFailures;
    }

    @JsonProperty("interval")
    public String getInterval() {
        return interval;
    }

    @JsonProperty("interval")
    public void setInterval(String interval) {
        this.interval = interval;
    }

    @JsonProperty("maxEjectionPercent")
    public Integer getMaxEjectionPercent() {
        return maxEjectionPercent;
    }

    @JsonProperty("maxEjectionPercent")
    public void setMaxEjectionPercent(Integer maxEjectionPercent) {
        this.maxEjectionPercent = maxEjectionPercent;
    }

    @JsonProperty("minHealthPercent")
    public Integer getMinHealthPercent() {
        return minHealthPercent;
    }

    @JsonProperty("minHealthPercent")
    public void setMinHealthPercent(Integer minHealthPercent) {
        this.minHealthPercent = minHealthPercent;
    }

    @JsonProperty("splitExternalLocalOriginErrors")
    public Boolean getSplitExternalLocalOriginErrors() {
        return splitExternalLocalOriginErrors;
    }

    @JsonProperty("splitExternalLocalOriginErrors")
    public void setSplitExternalLocalOriginErrors(Boolean splitExternalLocalOriginErrors) {
        this.splitExternalLocalOriginErrors = splitExternalLocalOriginErrors;
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
