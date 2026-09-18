
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * FirmwareSchemaSpec defines the desired state of FirmwareSchema.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hardwareModel",
    "hardwareVendor",
    "schema"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class FirmwareSchemaSpec implements Editable<FirmwareSchemaSpecBuilder>, KubernetesResource
{

    @JsonProperty("hardwareModel")
    private String hardwareModel;
    @JsonProperty("hardwareVendor")
    private String hardwareVendor;
    @JsonProperty("schema")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, SettingSchema> schema = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FirmwareSchemaSpec() {
    }

    public FirmwareSchemaSpec(String hardwareModel, String hardwareVendor, Map<String, SettingSchema> schema) {
        super();
        this.hardwareModel = hardwareModel;
        this.hardwareVendor = hardwareVendor;
        this.schema = schema;
    }

    /**
     * The hardware model associated with this schema
     */
    @JsonProperty("hardwareModel")
    public String getHardwareModel() {
        return hardwareModel;
    }

    /**
     * The hardware model associated with this schema
     */
    @JsonProperty("hardwareModel")
    public void setHardwareModel(String hardwareModel) {
        this.hardwareModel = hardwareModel;
    }

    /**
     * The hardware vendor associated with this schema
     */
    @JsonProperty("hardwareVendor")
    public String getHardwareVendor() {
        return hardwareVendor;
    }

    /**
     * The hardware vendor associated with this schema
     */
    @JsonProperty("hardwareVendor")
    public void setHardwareVendor(String hardwareVendor) {
        this.hardwareVendor = hardwareVendor;
    }

    /**
     * Map of firmware name to schema
     */
    @JsonProperty("schema")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, SettingSchema> getSchema() {
        return schema;
    }

    /**
     * Map of firmware name to schema
     */
    @JsonProperty("schema")
    public void setSchema(Map<String, SettingSchema> schema) {
        this.schema = schema;
    }

    @JsonIgnore
    public FirmwareSchemaSpecBuilder edit() {
        return new FirmwareSchemaSpecBuilder(this);
    }

    @JsonIgnore
    public FirmwareSchemaSpecBuilder toBuilder() {
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
        if (!(o instanceof FirmwareSchemaSpec)) {
            return false;
        }
        FirmwareSchemaSpec other = (FirmwareSchemaSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$hardwareModel = this.getHardwareModel();
        Object other$hardwareModel = other.getHardwareModel();
        if (this$hardwareModel == null ? other$hardwareModel != null : !this$hardwareModel.equals(other$hardwareModel)) {
            return false;
        }
        Object this$hardwareVendor = this.getHardwareVendor();
        Object other$hardwareVendor = other.getHardwareVendor();
        if (this$hardwareVendor == null ? other$hardwareVendor != null : !this$hardwareVendor.equals(other$hardwareVendor)) {
            return false;
        }
        Object this$schema = this.getSchema();
        Object other$schema = other.getSchema();
        if (this$schema == null ? other$schema != null : !this$schema.equals(other$schema)) {
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
        return other instanceof FirmwareSchemaSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $hardwareModel = this.getHardwareModel();
        result = result * prime + ($hardwareModel == null ? 43 : $hardwareModel.hashCode());
        Object $hardwareVendor = this.getHardwareVendor();
        result = result * prime + ($hardwareVendor == null ? 43 : $hardwareVendor.hashCode());
        Object $schema = this.getSchema();
        result = result * prime + ($schema == null ? 43 : $schema.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FirmwareSchemaSpec(" + "hardwareModel=" + this.getHardwareModel() + ", hardwareVendor=" + this.getHardwareVendor() + ", schema=" + this.getSchema() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
