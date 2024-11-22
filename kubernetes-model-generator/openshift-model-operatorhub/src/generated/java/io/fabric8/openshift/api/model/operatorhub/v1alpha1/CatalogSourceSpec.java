
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
public class CatalogSourceSpec implements Editable<CatalogSourceSpecBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("configMap")
    public String getConfigMap() {
        return configMap;
    }

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

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

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

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

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

    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSecrets() {
        return secrets;
    }

    @JsonProperty("secrets")
    public void setSecrets(List<String> secrets) {
        this.secrets = secrets;
    }

    @JsonProperty("sourceType")
    public String getSourceType() {
        return sourceType;
    }

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
