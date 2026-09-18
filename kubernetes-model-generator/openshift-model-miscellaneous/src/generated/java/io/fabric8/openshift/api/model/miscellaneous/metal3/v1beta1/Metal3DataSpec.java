
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
import io.fabric8.kubernetes.api.model.SecretReference;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Metal3DataSpec defines the desired state of Metal3Data.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claim",
    "index",
    "metaData",
    "networkData",
    "template",
    "templateReference"
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
public class Metal3DataSpec implements Editable<Metal3DataSpecBuilder>, KubernetesResource
{

    @JsonProperty("claim")
    private ObjectReference claim;
    @JsonProperty("index")
    private Integer index;
    @JsonProperty("metaData")
    private SecretReference metaData;
    @JsonProperty("networkData")
    private SecretReference networkData;
    @JsonProperty("template")
    private ObjectReference template;
    @JsonProperty("templateReference")
    private String templateReference;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metal3DataSpec() {
    }

    public Metal3DataSpec(ObjectReference claim, Integer index, SecretReference metaData, SecretReference networkData, ObjectReference template, String templateReference) {
        super();
        this.claim = claim;
        this.index = index;
        this.metaData = metaData;
        this.networkData = networkData;
        this.template = template;
        this.templateReference = templateReference;
    }

    /**
     * Metal3DataSpec defines the desired state of Metal3Data.
     */
    @JsonProperty("claim")
    public ObjectReference getClaim() {
        return claim;
    }

    /**
     * Metal3DataSpec defines the desired state of Metal3Data.
     */
    @JsonProperty("claim")
    public void setClaim(ObjectReference claim) {
        this.claim = claim;
    }

    /**
     * Index stores the index value of this instance in the Metal3DataTemplate.
     */
    @JsonProperty("index")
    public Integer getIndex() {
        return index;
    }

    /**
     * Index stores the index value of this instance in the Metal3DataTemplate.
     */
    @JsonProperty("index")
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * Metal3DataSpec defines the desired state of Metal3Data.
     */
    @JsonProperty("metaData")
    public SecretReference getMetaData() {
        return metaData;
    }

    /**
     * Metal3DataSpec defines the desired state of Metal3Data.
     */
    @JsonProperty("metaData")
    public void setMetaData(SecretReference metaData) {
        this.metaData = metaData;
    }

    /**
     * Metal3DataSpec defines the desired state of Metal3Data.
     */
    @JsonProperty("networkData")
    public SecretReference getNetworkData() {
        return networkData;
    }

    /**
     * Metal3DataSpec defines the desired state of Metal3Data.
     */
    @JsonProperty("networkData")
    public void setNetworkData(SecretReference networkData) {
        this.networkData = networkData;
    }

    /**
     * Metal3DataSpec defines the desired state of Metal3Data.
     */
    @JsonProperty("template")
    public ObjectReference getTemplate() {
        return template;
    }

    /**
     * Metal3DataSpec defines the desired state of Metal3Data.
     */
    @JsonProperty("template")
    public void setTemplate(ObjectReference template) {
        this.template = template;
    }

    /**
     * TemplateReference refers to the Template the Metal3MachineTemplate refers to. It can be matched against the key or it may also point to the name of the template Metal3Data refers to.<br><p> <br><p> Deprecated: This field is deprecated and will be removed in a future release.
     */
    @JsonProperty("templateReference")
    public String getTemplateReference() {
        return templateReference;
    }

    /**
     * TemplateReference refers to the Template the Metal3MachineTemplate refers to. It can be matched against the key or it may also point to the name of the template Metal3Data refers to.<br><p> <br><p> Deprecated: This field is deprecated and will be removed in a future release.
     */
    @JsonProperty("templateReference")
    public void setTemplateReference(String templateReference) {
        this.templateReference = templateReference;
    }

    @JsonIgnore
    public Metal3DataSpecBuilder edit() {
        return new Metal3DataSpecBuilder(this);
    }

    @JsonIgnore
    public Metal3DataSpecBuilder toBuilder() {
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
        if (!(o instanceof Metal3DataSpec)) {
            return false;
        }
        Metal3DataSpec other = (Metal3DataSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$claim = this.getClaim();
        Object other$claim = other.getClaim();
        if (this$claim == null ? other$claim != null : !this$claim.equals(other$claim)) {
            return false;
        }
        Object this$index = this.getIndex();
        Object other$index = other.getIndex();
        if (this$index == null ? other$index != null : !this$index.equals(other$index)) {
            return false;
        }
        Object this$metaData = this.getMetaData();
        Object other$metaData = other.getMetaData();
        if (this$metaData == null ? other$metaData != null : !this$metaData.equals(other$metaData)) {
            return false;
        }
        Object this$networkData = this.getNetworkData();
        Object other$networkData = other.getNetworkData();
        if (this$networkData == null ? other$networkData != null : !this$networkData.equals(other$networkData)) {
            return false;
        }
        Object this$template = this.getTemplate();
        Object other$template = other.getTemplate();
        if (this$template == null ? other$template != null : !this$template.equals(other$template)) {
            return false;
        }
        Object this$templateReference = this.getTemplateReference();
        Object other$templateReference = other.getTemplateReference();
        if (this$templateReference == null ? other$templateReference != null : !this$templateReference.equals(other$templateReference)) {
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
        return other instanceof Metal3DataSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $claim = this.getClaim();
        result = result * prime + ($claim == null ? 43 : $claim.hashCode());
        Object $index = this.getIndex();
        result = result * prime + ($index == null ? 43 : $index.hashCode());
        Object $metaData = this.getMetaData();
        result = result * prime + ($metaData == null ? 43 : $metaData.hashCode());
        Object $networkData = this.getNetworkData();
        result = result * prime + ($networkData == null ? 43 : $networkData.hashCode());
        Object $template = this.getTemplate();
        result = result * prime + ($template == null ? 43 : $template.hashCode());
        Object $templateReference = this.getTemplateReference();
        result = result * prime + ($templateReference == null ? 43 : $templateReference.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Metal3DataSpec(" + "claim=" + this.getClaim() + ", index=" + this.getIndex() + ", metaData=" + this.getMetaData() + ", networkData=" + this.getNetworkData() + ", template=" + this.getTemplate() + ", templateReference=" + this.getTemplateReference() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
