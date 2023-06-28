
package io.fabric8.openshift.api.model.clusterautoscaling.v1;

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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "delayAfterAdd",
    "delayAfterDelete",
    "delayAfterFailure",
    "enabled",
    "unneededTime"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ScaleDownConfig implements KubernetesResource
{

    @JsonProperty("delayAfterAdd")
    private String delayAfterAdd;
    @JsonProperty("delayAfterDelete")
    private String delayAfterDelete;
    @JsonProperty("delayAfterFailure")
    private String delayAfterFailure;
    @JsonProperty("enabled")
    private Boolean enabled;
    @JsonProperty("unneededTime")
    private String unneededTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ScaleDownConfig() {
    }

    public ScaleDownConfig(String delayAfterAdd, String delayAfterDelete, String delayAfterFailure, Boolean enabled, String unneededTime) {
        super();
        this.delayAfterAdd = delayAfterAdd;
        this.delayAfterDelete = delayAfterDelete;
        this.delayAfterFailure = delayAfterFailure;
        this.enabled = enabled;
        this.unneededTime = unneededTime;
    }

    @JsonProperty("delayAfterAdd")
    public String getDelayAfterAdd() {
        return delayAfterAdd;
    }

    @JsonProperty("delayAfterAdd")
    public void setDelayAfterAdd(String delayAfterAdd) {
        this.delayAfterAdd = delayAfterAdd;
    }

    @JsonProperty("delayAfterDelete")
    public String getDelayAfterDelete() {
        return delayAfterDelete;
    }

    @JsonProperty("delayAfterDelete")
    public void setDelayAfterDelete(String delayAfterDelete) {
        this.delayAfterDelete = delayAfterDelete;
    }

    @JsonProperty("delayAfterFailure")
    public String getDelayAfterFailure() {
        return delayAfterFailure;
    }

    @JsonProperty("delayAfterFailure")
    public void setDelayAfterFailure(String delayAfterFailure) {
        this.delayAfterFailure = delayAfterFailure;
    }

    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @JsonProperty("unneededTime")
    public String getUnneededTime() {
        return unneededTime;
    }

    @JsonProperty("unneededTime")
    public void setUnneededTime(String unneededTime) {
        this.unneededTime = unneededTime;
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
