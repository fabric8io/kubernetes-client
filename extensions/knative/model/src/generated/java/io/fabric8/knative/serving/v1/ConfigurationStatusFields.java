
package io.fabric8.knative.serving.v1;

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

/**
 * ConfigurationStatusFields holds the fields of Configuration's status that are not generally shared.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "latestCreatedRevisionName",
    "latestReadyRevisionName"
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
public class ConfigurationStatusFields implements Editable<ConfigurationStatusFieldsBuilder>, KubernetesResource
{

    @JsonProperty("latestCreatedRevisionName")
    private String latestCreatedRevisionName;
    @JsonProperty("latestReadyRevisionName")
    private String latestReadyRevisionName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConfigurationStatusFields() {
    }

    public ConfigurationStatusFields(String latestCreatedRevisionName, String latestReadyRevisionName) {
        super();
        this.latestCreatedRevisionName = latestCreatedRevisionName;
        this.latestReadyRevisionName = latestReadyRevisionName;
    }

    /**
     * LatestCreatedRevisionName is the last revision that was created from this Configuration. It might not be ready yet, for that use LatestReadyRevisionName.
     */
    @JsonProperty("latestCreatedRevisionName")
    public String getLatestCreatedRevisionName() {
        return latestCreatedRevisionName;
    }

    /**
     * LatestCreatedRevisionName is the last revision that was created from this Configuration. It might not be ready yet, for that use LatestReadyRevisionName.
     */
    @JsonProperty("latestCreatedRevisionName")
    public void setLatestCreatedRevisionName(String latestCreatedRevisionName) {
        this.latestCreatedRevisionName = latestCreatedRevisionName;
    }

    /**
     * LatestReadyRevisionName holds the name of the latest Revision stamped out from this Configuration that has had its "Ready" condition become "True".
     */
    @JsonProperty("latestReadyRevisionName")
    public String getLatestReadyRevisionName() {
        return latestReadyRevisionName;
    }

    /**
     * LatestReadyRevisionName holds the name of the latest Revision stamped out from this Configuration that has had its "Ready" condition become "True".
     */
    @JsonProperty("latestReadyRevisionName")
    public void setLatestReadyRevisionName(String latestReadyRevisionName) {
        this.latestReadyRevisionName = latestReadyRevisionName;
    }

    @JsonIgnore
    public ConfigurationStatusFieldsBuilder edit() {
        return new ConfigurationStatusFieldsBuilder(this);
    }

    @JsonIgnore
    public ConfigurationStatusFieldsBuilder toBuilder() {
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
        if (!(o instanceof ConfigurationStatusFields)) {
            return false;
        }
        ConfigurationStatusFields other = (ConfigurationStatusFields) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$latestCreatedRevisionName = this.getLatestCreatedRevisionName();
        Object other$latestCreatedRevisionName = other.getLatestCreatedRevisionName();
        if (this$latestCreatedRevisionName == null ? other$latestCreatedRevisionName != null : !this$latestCreatedRevisionName.equals(other$latestCreatedRevisionName)) {
            return false;
        }
        Object this$latestReadyRevisionName = this.getLatestReadyRevisionName();
        Object other$latestReadyRevisionName = other.getLatestReadyRevisionName();
        if (this$latestReadyRevisionName == null ? other$latestReadyRevisionName != null : !this$latestReadyRevisionName.equals(other$latestReadyRevisionName)) {
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
        return other instanceof ConfigurationStatusFields;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $latestCreatedRevisionName = this.getLatestCreatedRevisionName();
        result = result * prime + ($latestCreatedRevisionName == null ? 43 : $latestCreatedRevisionName.hashCode());
        Object $latestReadyRevisionName = this.getLatestReadyRevisionName();
        result = result * prime + ($latestReadyRevisionName == null ? 43 : $latestReadyRevisionName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConfigurationStatusFields(" + "latestCreatedRevisionName=" + this.getLatestCreatedRevisionName() + ", latestReadyRevisionName=" + this.getLatestReadyRevisionName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
