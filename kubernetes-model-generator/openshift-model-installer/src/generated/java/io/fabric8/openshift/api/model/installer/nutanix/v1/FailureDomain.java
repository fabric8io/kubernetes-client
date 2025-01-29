
package io.fabric8.openshift.api.model.installer.nutanix.v1;

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

/**
 * FailureDomain configures failure domain information for the Nutanix platform.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dataSourceImages",
    "name",
    "prismElement",
    "storageContainers",
    "subnetUUIDs"
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
public class FailureDomain implements Editable<FailureDomainBuilder>, KubernetesResource
{

    @JsonProperty("dataSourceImages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StorageResourceReference> dataSourceImages = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("prismElement")
    private PrismElement prismElement;
    @JsonProperty("storageContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StorageResourceReference> storageContainers = new ArrayList<>();
    @JsonProperty("subnetUUIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> subnetUUIDs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FailureDomain() {
    }

    public FailureDomain(List<StorageResourceReference> dataSourceImages, String name, PrismElement prismElement, List<StorageResourceReference> storageContainers, List<String> subnetUUIDs) {
        super();
        this.dataSourceImages = dataSourceImages;
        this.name = name;
        this.prismElement = prismElement;
        this.storageContainers = storageContainers;
        this.subnetUUIDs = subnetUUIDs;
    }

    /**
     * DataSourceImages identifies the datasource images in the Prism Element.
     */
    @JsonProperty("dataSourceImages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StorageResourceReference> getDataSourceImages() {
        return dataSourceImages;
    }

    /**
     * DataSourceImages identifies the datasource images in the Prism Element.
     */
    @JsonProperty("dataSourceImages")
    public void setDataSourceImages(List<StorageResourceReference> dataSourceImages) {
        this.dataSourceImages = dataSourceImages;
    }

    /**
     * Name defines the unique name of a failure domain.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name defines the unique name of a failure domain.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * FailureDomain configures failure domain information for the Nutanix platform.
     */
    @JsonProperty("prismElement")
    public PrismElement getPrismElement() {
        return prismElement;
    }

    /**
     * FailureDomain configures failure domain information for the Nutanix platform.
     */
    @JsonProperty("prismElement")
    public void setPrismElement(PrismElement prismElement) {
        this.prismElement = prismElement;
    }

    /**
     * StorageContainers identifies the storage containers in the Prism Element.
     */
    @JsonProperty("storageContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StorageResourceReference> getStorageContainers() {
        return storageContainers;
    }

    /**
     * StorageContainers identifies the storage containers in the Prism Element.
     */
    @JsonProperty("storageContainers")
    public void setStorageContainers(List<StorageResourceReference> storageContainers) {
        this.storageContainers = storageContainers;
    }

    /**
     * SubnetUUIDs identifies the network subnets of the Prism Element. Currently we only support one subnet for a failure domain.
     */
    @JsonProperty("subnetUUIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSubnetUUIDs() {
        return subnetUUIDs;
    }

    /**
     * SubnetUUIDs identifies the network subnets of the Prism Element. Currently we only support one subnet for a failure domain.
     */
    @JsonProperty("subnetUUIDs")
    public void setSubnetUUIDs(List<String> subnetUUIDs) {
        this.subnetUUIDs = subnetUUIDs;
    }

    @JsonIgnore
    public FailureDomainBuilder edit() {
        return new FailureDomainBuilder(this);
    }

    @JsonIgnore
    public FailureDomainBuilder toBuilder() {
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
