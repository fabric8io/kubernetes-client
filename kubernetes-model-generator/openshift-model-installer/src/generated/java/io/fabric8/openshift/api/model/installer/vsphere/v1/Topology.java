
package io.fabric8.openshift.api.model.installer.vsphere.v1;

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
    "computeCluster",
    "datacenter",
    "datastore",
    "folder",
    "networks",
    "resourcePool",
    "tagIDs",
    "template"
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
public class Topology implements Editable<TopologyBuilder> , KubernetesResource
{

    @JsonProperty("computeCluster")
    private String computeCluster;
    @JsonProperty("datacenter")
    private String datacenter;
    @JsonProperty("datastore")
    private String datastore;
    @JsonProperty("folder")
    private String folder;
    @JsonProperty("networks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> networks = new ArrayList<>();
    @JsonProperty("resourcePool")
    private String resourcePool;
    @JsonProperty("tagIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> tagIDs = new ArrayList<>();
    @JsonProperty("template")
    private String template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Topology() {
    }

    public Topology(String computeCluster, String datacenter, String datastore, String folder, List<String> networks, String resourcePool, List<String> tagIDs, String template) {
        super();
        this.computeCluster = computeCluster;
        this.datacenter = datacenter;
        this.datastore = datastore;
        this.folder = folder;
        this.networks = networks;
        this.resourcePool = resourcePool;
        this.tagIDs = tagIDs;
        this.template = template;
    }

    @JsonProperty("computeCluster")
    public String getComputeCluster() {
        return computeCluster;
    }

    @JsonProperty("computeCluster")
    public void setComputeCluster(String computeCluster) {
        this.computeCluster = computeCluster;
    }

    @JsonProperty("datacenter")
    public String getDatacenter() {
        return datacenter;
    }

    @JsonProperty("datacenter")
    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    @JsonProperty("datastore")
    public String getDatastore() {
        return datastore;
    }

    @JsonProperty("datastore")
    public void setDatastore(String datastore) {
        this.datastore = datastore;
    }

    @JsonProperty("folder")
    public String getFolder() {
        return folder;
    }

    @JsonProperty("folder")
    public void setFolder(String folder) {
        this.folder = folder;
    }

    @JsonProperty("networks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNetworks() {
        return networks;
    }

    @JsonProperty("networks")
    public void setNetworks(List<String> networks) {
        this.networks = networks;
    }

    @JsonProperty("resourcePool")
    public String getResourcePool() {
        return resourcePool;
    }

    @JsonProperty("resourcePool")
    public void setResourcePool(String resourcePool) {
        this.resourcePool = resourcePool;
    }

    @JsonProperty("tagIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTagIDs() {
        return tagIDs;
    }

    @JsonProperty("tagIDs")
    public void setTagIDs(List<String> tagIDs) {
        this.tagIDs = tagIDs;
    }

    @JsonProperty("template")
    public String getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonIgnore
    public TopologyBuilder edit() {
        return new TopologyBuilder(this);
    }

    @JsonIgnore
    public TopologyBuilder toBuilder() {
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
