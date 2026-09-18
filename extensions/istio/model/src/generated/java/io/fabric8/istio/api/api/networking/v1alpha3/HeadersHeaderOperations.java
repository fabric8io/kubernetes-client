
package io.fabric8.istio.api.api.networking.v1alpha3;

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

/**
 * HeaderOperations Describes the header manipulations to apply
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "add",
    "remove",
    "set"
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
public class HeadersHeaderOperations implements Editable<HeadersHeaderOperationsBuilder>, KubernetesResource
{

    @JsonProperty("add")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> add = new LinkedHashMap<>();
    @JsonProperty("remove")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> remove = new ArrayList<>();
    @JsonProperty("set")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> set = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HeadersHeaderOperations() {
    }

    public HeadersHeaderOperations(Map<String, String> add, List<String> remove, Map<String, String> set) {
        super();
        this.add = add;
        this.remove = remove;
        this.set = set;
    }

    /**
     * Append the given values to the headers specified by keys (will create a comma-separated list of values)
     */
    @JsonProperty("add")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAdd() {
        return add;
    }

    /**
     * Append the given values to the headers specified by keys (will create a comma-separated list of values)
     */
    @JsonProperty("add")
    public void setAdd(Map<String, String> add) {
        this.add = add;
    }

    /**
     * Remove the specified headers
     */
    @JsonProperty("remove")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRemove() {
        return remove;
    }

    /**
     * Remove the specified headers
     */
    @JsonProperty("remove")
    public void setRemove(List<String> remove) {
        this.remove = remove;
    }

    /**
     * Overwrite the headers specified by key with the given values
     */
    @JsonProperty("set")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getSet() {
        return set;
    }

    /**
     * Overwrite the headers specified by key with the given values
     */
    @JsonProperty("set")
    public void setSet(Map<String, String> set) {
        this.set = set;
    }

    @JsonIgnore
    public HeadersHeaderOperationsBuilder edit() {
        return new HeadersHeaderOperationsBuilder(this);
    }

    @JsonIgnore
    public HeadersHeaderOperationsBuilder toBuilder() {
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
        if (!(o instanceof HeadersHeaderOperations)) {
            return false;
        }
        HeadersHeaderOperations other = (HeadersHeaderOperations) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$add = this.getAdd();
        Object other$add = other.getAdd();
        if (this$add == null ? other$add != null : !this$add.equals(other$add)) {
            return false;
        }
        Object this$remove = this.getRemove();
        Object other$remove = other.getRemove();
        if (this$remove == null ? other$remove != null : !this$remove.equals(other$remove)) {
            return false;
        }
        Object this$set = this.getSet();
        Object other$set = other.getSet();
        if (this$set == null ? other$set != null : !this$set.equals(other$set)) {
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
        return other instanceof HeadersHeaderOperations;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $add = this.getAdd();
        result = result * prime + ($add == null ? 43 : $add.hashCode());
        Object $remove = this.getRemove();
        result = result * prime + ($remove == null ? 43 : $remove.hashCode());
        Object $set = this.getSet();
        result = result * prime + ($set == null ? 43 : $set.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HeadersHeaderOperations(" + "add=" + this.getAdd() + ", remove=" + this.getRemove() + ", set=" + this.getSet() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
