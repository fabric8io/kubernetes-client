
package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

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

/**
 * Mutation specifies the CEL expression which is used to apply the Mutation.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "applyConfiguration",
    "jsonPatch",
    "patchType"
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
public class Mutation implements Editable<MutationBuilder>, KubernetesResource
{

    @JsonProperty("applyConfiguration")
    private ApplyConfiguration applyConfiguration;
    @JsonProperty("jsonPatch")
    private JSONPatch jsonPatch;
    @JsonProperty("patchType")
    private String patchType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Mutation() {
    }

    public Mutation(ApplyConfiguration applyConfiguration, JSONPatch jsonPatch, String patchType) {
        super();
        this.applyConfiguration = applyConfiguration;
        this.jsonPatch = jsonPatch;
        this.patchType = patchType;
    }

    /**
     * Mutation specifies the CEL expression which is used to apply the Mutation.
     */
    @JsonProperty("applyConfiguration")
    public ApplyConfiguration getApplyConfiguration() {
        return applyConfiguration;
    }

    /**
     * Mutation specifies the CEL expression which is used to apply the Mutation.
     */
    @JsonProperty("applyConfiguration")
    public void setApplyConfiguration(ApplyConfiguration applyConfiguration) {
        this.applyConfiguration = applyConfiguration;
    }

    /**
     * Mutation specifies the CEL expression which is used to apply the Mutation.
     */
    @JsonProperty("jsonPatch")
    public JSONPatch getJsonPatch() {
        return jsonPatch;
    }

    /**
     * Mutation specifies the CEL expression which is used to apply the Mutation.
     */
    @JsonProperty("jsonPatch")
    public void setJsonPatch(JSONPatch jsonPatch) {
        this.jsonPatch = jsonPatch;
    }

    /**
     * patchType indicates the patch strategy used. Allowed values are "ApplyConfiguration" and "JSONPatch". Required.
     */
    @JsonProperty("patchType")
    public String getPatchType() {
        return patchType;
    }

    /**
     * patchType indicates the patch strategy used. Allowed values are "ApplyConfiguration" and "JSONPatch". Required.
     */
    @JsonProperty("patchType")
    public void setPatchType(String patchType) {
        this.patchType = patchType;
    }

    @JsonIgnore
    public MutationBuilder edit() {
        return new MutationBuilder(this);
    }

    @JsonIgnore
    public MutationBuilder toBuilder() {
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
