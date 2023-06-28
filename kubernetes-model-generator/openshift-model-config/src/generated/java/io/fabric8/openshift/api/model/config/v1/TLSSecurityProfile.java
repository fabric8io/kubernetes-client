
package io.fabric8.openshift.api.model.config.v1;

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
    "custom",
    "intermediate",
    "modern",
    "old",
    "type"
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
public class TLSSecurityProfile implements KubernetesResource
{

    @JsonProperty("custom")
    private CustomTLSProfile custom;
    @JsonProperty("intermediate")
    private IntermediateTLSProfile intermediate;
    @JsonProperty("modern")
    private ModernTLSProfile modern;
    @JsonProperty("old")
    private OldTLSProfile old;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TLSSecurityProfile() {
    }

    public TLSSecurityProfile(CustomTLSProfile custom, IntermediateTLSProfile intermediate, ModernTLSProfile modern, OldTLSProfile old, String type) {
        super();
        this.custom = custom;
        this.intermediate = intermediate;
        this.modern = modern;
        this.old = old;
        this.type = type;
    }

    @JsonProperty("custom")
    public CustomTLSProfile getCustom() {
        return custom;
    }

    @JsonProperty("custom")
    public void setCustom(CustomTLSProfile custom) {
        this.custom = custom;
    }

    @JsonProperty("intermediate")
    public IntermediateTLSProfile getIntermediate() {
        return intermediate;
    }

    @JsonProperty("intermediate")
    public void setIntermediate(IntermediateTLSProfile intermediate) {
        this.intermediate = intermediate;
    }

    @JsonProperty("modern")
    public ModernTLSProfile getModern() {
        return modern;
    }

    @JsonProperty("modern")
    public void setModern(ModernTLSProfile modern) {
        this.modern = modern;
    }

    @JsonProperty("old")
    public OldTLSProfile getOld() {
        return old;
    }

    @JsonProperty("old")
    public void setOld(OldTLSProfile old) {
        this.old = old;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
