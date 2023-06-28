
package io.fabric8.openshift.api.model.installer.vsphere.v1;

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
    "apiVIP",
    "cluster",
    "clusterOSImage",
    "datacenter",
    "defaultDatastore",
    "defaultMachinePlatform",
    "diskType",
    "folder",
    "ingressVIP",
    "network",
    "password",
    "resourcePool",
    "username",
    "vCenter"
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
public class Platform implements KubernetesResource
{

    @JsonProperty("apiVIP")
    private String apiVIP;
    @JsonProperty("cluster")
    private String cluster;
    @JsonProperty("clusterOSImage")
    private String clusterOSImage;
    @JsonProperty("datacenter")
    private String datacenter;
    @JsonProperty("defaultDatastore")
    private String defaultDatastore;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("diskType")
    private String diskType;
    @JsonProperty("folder")
    private String folder;
    @JsonProperty("ingressVIP")
    private String ingressVIP;
    @JsonProperty("network")
    private String network;
    @JsonProperty("password")
    private String password;
    @JsonProperty("resourcePool")
    private String resourcePool;
    @JsonProperty("username")
    private String username;
    @JsonProperty("vCenter")
    private String vCenter;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    public Platform(String apiVIP, String cluster, String clusterOSImage, String datacenter, String defaultDatastore, MachinePool defaultMachinePlatform, String diskType, String folder, String ingressVIP, String network, String password, String resourcePool, String username, String vCenter) {
        super();
        this.apiVIP = apiVIP;
        this.cluster = cluster;
        this.clusterOSImage = clusterOSImage;
        this.datacenter = datacenter;
        this.defaultDatastore = defaultDatastore;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.diskType = diskType;
        this.folder = folder;
        this.ingressVIP = ingressVIP;
        this.network = network;
        this.password = password;
        this.resourcePool = resourcePool;
        this.username = username;
        this.vCenter = vCenter;
    }

    @JsonProperty("apiVIP")
    public String getApiVIP() {
        return apiVIP;
    }

    @JsonProperty("apiVIP")
    public void setApiVIP(String apiVIP) {
        this.apiVIP = apiVIP;
    }

    @JsonProperty("cluster")
    public String getCluster() {
        return cluster;
    }

    @JsonProperty("cluster")
    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    @JsonProperty("clusterOSImage")
    public String getClusterOSImage() {
        return clusterOSImage;
    }

    @JsonProperty("clusterOSImage")
    public void setClusterOSImage(String clusterOSImage) {
        this.clusterOSImage = clusterOSImage;
    }

    @JsonProperty("datacenter")
    public String getDatacenter() {
        return datacenter;
    }

    @JsonProperty("datacenter")
    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    @JsonProperty("defaultDatastore")
    public String getDefaultDatastore() {
        return defaultDatastore;
    }

    @JsonProperty("defaultDatastore")
    public void setDefaultDatastore(String defaultDatastore) {
        this.defaultDatastore = defaultDatastore;
    }

    @JsonProperty("defaultMachinePlatform")
    public MachinePool getDefaultMachinePlatform() {
        return defaultMachinePlatform;
    }

    @JsonProperty("defaultMachinePlatform")
    public void setDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
        this.defaultMachinePlatform = defaultMachinePlatform;
    }

    @JsonProperty("diskType")
    public String getDiskType() {
        return diskType;
    }

    @JsonProperty("diskType")
    public void setDiskType(String diskType) {
        this.diskType = diskType;
    }

    @JsonProperty("folder")
    public String getFolder() {
        return folder;
    }

    @JsonProperty("folder")
    public void setFolder(String folder) {
        this.folder = folder;
    }

    @JsonProperty("ingressVIP")
    public String getIngressVIP() {
        return ingressVIP;
    }

    @JsonProperty("ingressVIP")
    public void setIngressVIP(String ingressVIP) {
        this.ingressVIP = ingressVIP;
    }

    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("resourcePool")
    public String getResourcePool() {
        return resourcePool;
    }

    @JsonProperty("resourcePool")
    public void setResourcePool(String resourcePool) {
        this.resourcePool = resourcePool;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("vCenter")
    public String getVCenter() {
        return vCenter;
    }

    @JsonProperty("vCenter")
    public void setVCenter(String vCenter) {
        this.vCenter = vCenter;
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
