
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
 * ImageRegistryConfigStorageAzure holds the information to configure the registry to use Azure Blob Storage for backend storage.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accountName",
    "cloudName",
    "container",
    "networkAccess"
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
public class ImageRegistryConfigStorageAzure implements Editable<ImageRegistryConfigStorageAzureBuilder>, KubernetesResource
{

    @JsonProperty("accountName")
    private String accountName;
    @JsonProperty("cloudName")
    private String cloudName;
    @JsonProperty("container")
    private String container;
    @JsonProperty("networkAccess")
    private AzureNetworkAccess networkAccess;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageRegistryConfigStorageAzure() {
    }

    public ImageRegistryConfigStorageAzure(String accountName, String cloudName, String container, AzureNetworkAccess networkAccess) {
        super();
        this.accountName = accountName;
        this.cloudName = cloudName;
        this.container = container;
        this.networkAccess = networkAccess;
    }

    /**
     * accountName defines the account to be used by the registry.
     */
    @JsonProperty("accountName")
    public String getAccountName() {
        return accountName;
    }

    /**
     * accountName defines the account to be used by the registry.
     */
    @JsonProperty("accountName")
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * cloudName is the name of the Azure cloud environment to be used by the registry. If empty, the operator will set it based on the infrastructure object.
     */
    @JsonProperty("cloudName")
    public String getCloudName() {
        return cloudName;
    }

    /**
     * cloudName is the name of the Azure cloud environment to be used by the registry. If empty, the operator will set it based on the infrastructure object.
     */
    @JsonProperty("cloudName")
    public void setCloudName(String cloudName) {
        this.cloudName = cloudName;
    }

    /**
     * container defines Azure's container to be used by registry.
     */
    @JsonProperty("container")
    public String getContainer() {
        return container;
    }

    /**
     * container defines Azure's container to be used by registry.
     */
    @JsonProperty("container")
    public void setContainer(String container) {
        this.container = container;
    }

    /**
     * ImageRegistryConfigStorageAzure holds the information to configure the registry to use Azure Blob Storage for backend storage.
     */
    @JsonProperty("networkAccess")
    public AzureNetworkAccess getNetworkAccess() {
        return networkAccess;
    }

    /**
     * ImageRegistryConfigStorageAzure holds the information to configure the registry to use Azure Blob Storage for backend storage.
     */
    @JsonProperty("networkAccess")
    public void setNetworkAccess(AzureNetworkAccess networkAccess) {
        this.networkAccess = networkAccess;
    }

    @JsonIgnore
    public ImageRegistryConfigStorageAzureBuilder edit() {
        return new ImageRegistryConfigStorageAzureBuilder(this);
    }

    @JsonIgnore
    public ImageRegistryConfigStorageAzureBuilder toBuilder() {
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
