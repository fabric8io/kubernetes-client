
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "configMap",
    "description",
    "displayName",
    "grpcPodConfig",
    "icon",
    "image",
    "priority",
    "publisher",
    "secrets",
    "sourceType",
    "updateStrategy"
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
public class CatalogSourceSpec implements Editable<CatalogSourceSpecBuilder>, KubernetesResource
{

    @JsonProperty("address")
    private String address;
    @JsonProperty("configMap")
    private String configMap;
    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("grpcPodConfig")
    private GrpcPodConfig grpcPodConfig;
    @JsonProperty("icon")
    private Icon icon;
    @JsonProperty("image")
    private String image;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> secrets = new ArrayList<>();
    @JsonProperty("sourceType")
    private String sourceType;
    @JsonProperty("updateStrategy")
    private UpdateStrategy updateStrategy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CatalogSourceSpec() {
    }

    public CatalogSourceSpec(String address, String configMap, String description, String displayName, GrpcPodConfig grpcPodConfig, Icon icon, String image, Integer priority, String publisher, List<String> secrets, String sourceType, UpdateStrategy updateStrategy) {
        super();
        this.address = address;
        this.configMap = configMap;
        this.description = description;
        this.displayName = displayName;
        this.grpcPodConfig = grpcPodConfig;
        this.icon = icon;
        this.image = image;
        this.priority = priority;
        this.publisher = publisher;
        this.secrets = secrets;
        this.sourceType = sourceType;
        this.updateStrategy = updateStrategy;
    }

    /**
     * Address is a host that OLM can use to connect to a pre-existing registry. Format: &lt;registry-host or ip&gt;:&lt;port&gt; Only used when SourceType = SourceTypeGrpc. Ignored when the Image field is set.
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * Address is a host that OLM can use to connect to a pre-existing registry. Format: &lt;registry-host or ip&gt;:&lt;port&gt; Only used when SourceType = SourceTypeGrpc. Ignored when the Image field is set.
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * ConfigMap is the name of the ConfigMap to be used to back a configmap-server registry. Only used when SourceType = SourceTypeConfigmap or SourceTypeInternal.
     */
    @JsonProperty("configMap")
    public String getConfigMap() {
        return configMap;
    }

    /**
     * ConfigMap is the name of the ConfigMap to be used to back a configmap-server registry. Only used when SourceType = SourceTypeConfigmap or SourceTypeInternal.
     */
    @JsonProperty("configMap")
    public void setConfigMap(String configMap) {
        this.configMap = configMap;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Metadata
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Metadata
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("grpcPodConfig")
    public GrpcPodConfig getGrpcPodConfig() {
        return grpcPodConfig;
    }

    @JsonProperty("grpcPodConfig")
    public void setGrpcPodConfig(GrpcPodConfig grpcPodConfig) {
        this.grpcPodConfig = grpcPodConfig;
    }

    @JsonProperty("icon")
    public Icon getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     * Image is an operator-registry container image to instantiate a registry-server with. Only used when SourceType = SourceTypeGrpc. If present, the address field is ignored.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * Image is an operator-registry container image to instantiate a registry-server with. Only used when SourceType = SourceTypeGrpc. If present, the address field is ignored.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Priority field assigns a weight to the catalog source to prioritize them so that it can be consumed by the dependency resolver. Usage: Higher weight indicates that this catalog source is preferred over lower weighted catalog sources during dependency resolution. The range of the priority value can go from positive to negative in the range of int32. The default value to a catalog source with unassigned priority would be 0. The catalog source with the same priority values will be ranked lexicographically based on its name.
     */
    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    /**
     * Priority field assigns a weight to the catalog source to prioritize them so that it can be consumed by the dependency resolver. Usage: Higher weight indicates that this catalog source is preferred over lower weighted catalog sources during dependency resolution. The range of the priority value can go from positive to negative in the range of int32. The default value to a catalog source with unassigned priority would be 0. The catalog source with the same priority values will be ranked lexicographically based on its name.
     */
    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Secrets represent set of secrets that can be used to access the contents of the catalog. It is best to keep this list small, since each will need to be tried for every catalog entry.
     */
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSecrets() {
        return secrets;
    }

    /**
     * Secrets represent set of secrets that can be used to access the contents of the catalog. It is best to keep this list small, since each will need to be tried for every catalog entry.
     */
    @JsonProperty("secrets")
    public void setSecrets(List<String> secrets) {
        this.secrets = secrets;
    }

    /**
     * SourceType is the type of source
     */
    @JsonProperty("sourceType")
    public String getSourceType() {
        return sourceType;
    }

    /**
     * SourceType is the type of source
     */
    @JsonProperty("sourceType")
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    @JsonProperty("updateStrategy")
    public UpdateStrategy getUpdateStrategy() {
        return updateStrategy;
    }

    @JsonProperty("updateStrategy")
    public void setUpdateStrategy(UpdateStrategy updateStrategy) {
        this.updateStrategy = updateStrategy;
    }

    @JsonIgnore
    public CatalogSourceSpecBuilder edit() {
        return new CatalogSourceSpecBuilder(this);
    }

    @JsonIgnore
    public CatalogSourceSpecBuilder toBuilder() {
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
        if (!(o instanceof CatalogSourceSpec)) {
            return false;
        }
        CatalogSourceSpec other = (CatalogSourceSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$address = this.getAddress();
        Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) {
            return false;
        }
        Object this$configMap = this.getConfigMap();
        Object other$configMap = other.getConfigMap();
        if (this$configMap == null ? other$configMap != null : !this$configMap.equals(other$configMap)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$displayName = this.getDisplayName();
        Object other$displayName = other.getDisplayName();
        if (this$displayName == null ? other$displayName != null : !this$displayName.equals(other$displayName)) {
            return false;
        }
        Object this$grpcPodConfig = this.getGrpcPodConfig();
        Object other$grpcPodConfig = other.getGrpcPodConfig();
        if (this$grpcPodConfig == null ? other$grpcPodConfig != null : !this$grpcPodConfig.equals(other$grpcPodConfig)) {
            return false;
        }
        Object this$icon = this.getIcon();
        Object other$icon = other.getIcon();
        if (this$icon == null ? other$icon != null : !this$icon.equals(other$icon)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$priority = this.getPriority();
        Object other$priority = other.getPriority();
        if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority)) {
            return false;
        }
        Object this$publisher = this.getPublisher();
        Object other$publisher = other.getPublisher();
        if (this$publisher == null ? other$publisher != null : !this$publisher.equals(other$publisher)) {
            return false;
        }
        Object this$secrets = this.getSecrets();
        Object other$secrets = other.getSecrets();
        if (this$secrets == null ? other$secrets != null : !this$secrets.equals(other$secrets)) {
            return false;
        }
        Object this$sourceType = this.getSourceType();
        Object other$sourceType = other.getSourceType();
        if (this$sourceType == null ? other$sourceType != null : !this$sourceType.equals(other$sourceType)) {
            return false;
        }
        Object this$updateStrategy = this.getUpdateStrategy();
        Object other$updateStrategy = other.getUpdateStrategy();
        if (this$updateStrategy == null ? other$updateStrategy != null : !this$updateStrategy.equals(other$updateStrategy)) {
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
        return other instanceof CatalogSourceSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $address = this.getAddress();
        result = result * prime + ($address == null ? 43 : $address.hashCode());
        Object $configMap = this.getConfigMap();
        result = result * prime + ($configMap == null ? 43 : $configMap.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $displayName = this.getDisplayName();
        result = result * prime + ($displayName == null ? 43 : $displayName.hashCode());
        Object $grpcPodConfig = this.getGrpcPodConfig();
        result = result * prime + ($grpcPodConfig == null ? 43 : $grpcPodConfig.hashCode());
        Object $icon = this.getIcon();
        result = result * prime + ($icon == null ? 43 : $icon.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $priority = this.getPriority();
        result = result * prime + ($priority == null ? 43 : $priority.hashCode());
        Object $publisher = this.getPublisher();
        result = result * prime + ($publisher == null ? 43 : $publisher.hashCode());
        Object $secrets = this.getSecrets();
        result = result * prime + ($secrets == null ? 43 : $secrets.hashCode());
        Object $sourceType = this.getSourceType();
        result = result * prime + ($sourceType == null ? 43 : $sourceType.hashCode());
        Object $updateStrategy = this.getUpdateStrategy();
        result = result * prime + ($updateStrategy == null ? 43 : $updateStrategy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CatalogSourceSpec(" + "address=" + this.getAddress() + ", configMap=" + this.getConfigMap() + ", description=" + this.getDescription() + ", displayName=" + this.getDisplayName() + ", grpcPodConfig=" + this.getGrpcPodConfig() + ", icon=" + this.getIcon() + ", image=" + this.getImage() + ", priority=" + this.getPriority() + ", publisher=" + this.getPublisher() + ", secrets=" + this.getSecrets() + ", sourceType=" + this.getSourceType() + ", updateStrategy=" + this.getUpdateStrategy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
