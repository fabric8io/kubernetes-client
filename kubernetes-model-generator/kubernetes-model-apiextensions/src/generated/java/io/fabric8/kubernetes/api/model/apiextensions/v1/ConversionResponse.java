
package io.fabric8.kubernetes.api.model.apiextensions.v1;

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
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "convertedObjects",
    "result",
    "uid"
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
public class ConversionResponse implements Editable<ConversionResponseBuilder>, KubernetesResource
{

    @JsonProperty("convertedObjects")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForList.class)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Object> convertedObjects = new ArrayList<>();
    @JsonProperty("result")
    private Status result;
    @JsonProperty("uid")
    private String uid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConversionResponse() {
    }

    public ConversionResponse(List<Object> convertedObjects, Status result, String uid) {
        super();
        this.convertedObjects = convertedObjects;
        this.result = result;
        this.uid = uid;
    }

    @JsonProperty("convertedObjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Object> getConvertedObjects() {
        return convertedObjects;
    }

    @JsonProperty("convertedObjects")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForList.class)
    public void setConvertedObjects(List<Object> convertedObjects) {
        this.convertedObjects = convertedObjects;
    }

    @JsonProperty("result")
    public Status getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(Status result) {
        this.result = result;
    }

    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonIgnore
    public ConversionResponseBuilder edit() {
        return new ConversionResponseBuilder(this);
    }

    @JsonIgnore
    public ConversionResponseBuilder toBuilder() {
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
        if (!(o instanceof ConversionResponse)) {
            return false;
        }
        ConversionResponse other = (ConversionResponse) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$convertedObjects = this.getConvertedObjects();
        Object other$convertedObjects = other.getConvertedObjects();
        if (this$convertedObjects == null ? other$convertedObjects != null : !this$convertedObjects.equals(other$convertedObjects)) {
            return false;
        }
        Object this$result = this.getResult();
        Object other$result = other.getResult();
        if (this$result == null ? other$result != null : !this$result.equals(other$result)) {
            return false;
        }
        Object this$uid = this.getUid();
        Object other$uid = other.getUid();
        if (this$uid == null ? other$uid != null : !this$uid.equals(other$uid)) {
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
        return other instanceof ConversionResponse;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $convertedObjects = this.getConvertedObjects();
        result = result * prime + ($convertedObjects == null ? 43 : $convertedObjects.hashCode());
        Object $result = this.getResult();
        result = result * prime + ($result == null ? 43 : $result.hashCode());
        Object $uid = this.getUid();
        result = result * prime + ($uid == null ? 43 : $uid.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConversionResponse(" + "convertedObjects=" + this.getConvertedObjects() + ", result=" + this.getResult() + ", uid=" + this.getUid() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
