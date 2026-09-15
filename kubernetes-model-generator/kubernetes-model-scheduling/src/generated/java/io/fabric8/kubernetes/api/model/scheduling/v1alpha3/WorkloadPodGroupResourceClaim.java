
package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

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
 * WorkloadPodGroupResourceClaim references a dynamic resource claim that is shared across pods in the group.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "resourceClaimName",
    "resourceClaimTemplateName"
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
public class WorkloadPodGroupResourceClaim implements Editable<WorkloadPodGroupResourceClaimBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("resourceClaimName")
    private String resourceClaimName;
    @JsonProperty("resourceClaimTemplateName")
    private String resourceClaimTemplateName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WorkloadPodGroupResourceClaim() {
    }

    public WorkloadPodGroupResourceClaim(String name, String resourceClaimName, String resourceClaimTemplateName) {
        super();
        this.name = name;
        this.resourceClaimName = resourceClaimName;
        this.resourceClaimTemplateName = resourceClaimTemplateName;
    }

    /**
     * name uniquely identifies this resource claim inside the group. This field is required. It must be a DNS_LABEL.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name uniquely identifies this resource claim inside the group. This field is required. It must be a DNS_LABEL.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * resourceClaimName is the name of a ResourceClaim object in the same namespace. This field is optional. If it is not specified, no resource claim is used. If set, it must be a DNS subdomain.
     */
    @JsonProperty("resourceClaimName")
    public String getResourceClaimName() {
        return resourceClaimName;
    }

    /**
     * resourceClaimName is the name of a ResourceClaim object in the same namespace. This field is optional. If it is not specified, no resource claim is used. If set, it must be a DNS subdomain.
     */
    @JsonProperty("resourceClaimName")
    public void setResourceClaimName(String resourceClaimName) {
        this.resourceClaimName = resourceClaimName;
    }

    /**
     * resourceClaimTemplateName is the name of a ResourceClaimTemplate object in the same namespace. This field is optional. If it is not specified, no resource claim template is used. If set, it must be a DNS subdomain.
     */
    @JsonProperty("resourceClaimTemplateName")
    public String getResourceClaimTemplateName() {
        return resourceClaimTemplateName;
    }

    /**
     * resourceClaimTemplateName is the name of a ResourceClaimTemplate object in the same namespace. This field is optional. If it is not specified, no resource claim template is used. If set, it must be a DNS subdomain.
     */
    @JsonProperty("resourceClaimTemplateName")
    public void setResourceClaimTemplateName(String resourceClaimTemplateName) {
        this.resourceClaimTemplateName = resourceClaimTemplateName;
    }

    @JsonIgnore
    public WorkloadPodGroupResourceClaimBuilder edit() {
        return new WorkloadPodGroupResourceClaimBuilder(this);
    }

    @JsonIgnore
    public WorkloadPodGroupResourceClaimBuilder toBuilder() {
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
        if (!(o instanceof WorkloadPodGroupResourceClaim)) {
            return false;
        }
        WorkloadPodGroupResourceClaim other = (WorkloadPodGroupResourceClaim) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$resourceClaimName = this.getResourceClaimName();
        Object other$resourceClaimName = other.getResourceClaimName();
        if (this$resourceClaimName == null ? other$resourceClaimName != null : !this$resourceClaimName.equals(other$resourceClaimName)) {
            return false;
        }
        Object this$resourceClaimTemplateName = this.getResourceClaimTemplateName();
        Object other$resourceClaimTemplateName = other.getResourceClaimTemplateName();
        if (this$resourceClaimTemplateName == null ? other$resourceClaimTemplateName != null : !this$resourceClaimTemplateName.equals(other$resourceClaimTemplateName)) {
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
        return other instanceof WorkloadPodGroupResourceClaim;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $resourceClaimName = this.getResourceClaimName();
        result = result * prime + ($resourceClaimName == null ? 43 : $resourceClaimName.hashCode());
        Object $resourceClaimTemplateName = this.getResourceClaimTemplateName();
        result = result * prime + ($resourceClaimTemplateName == null ? 43 : $resourceClaimTemplateName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WorkloadPodGroupResourceClaim(" + "name=" + this.getName() + ", resourceClaimName=" + this.getResourceClaimName() + ", resourceClaimTemplateName=" + this.getResourceClaimTemplateName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
