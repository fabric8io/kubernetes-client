
package io.fabric8.openshift.api.model.hive.vsphere.v1;

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
    "certificatesSecretRef",
    "cluster",
    "credentialsSecretRef",
    "datacenter",
    "defaultDatastore",
    "folder",
    "network",
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class Platform implements KubernetesResource
{

    @JsonProperty("certificatesSecretRef")
    private io.fabric8.kubernetes.api.model.LocalObjectReference certificatesSecretRef;
    @JsonProperty("cluster")
    private String cluster;
    @JsonProperty("credentialsSecretRef")
    private io.fabric8.kubernetes.api.model.LocalObjectReference credentialsSecretRef;
    @JsonProperty("datacenter")
    private String datacenter;
    @JsonProperty("defaultDatastore")
    private String defaultDatastore;
    @JsonProperty("folder")
    private String folder;
    @JsonProperty("network")
    private String network;
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

    public Platform(io.fabric8.kubernetes.api.model.LocalObjectReference certificatesSecretRef, String cluster, io.fabric8.kubernetes.api.model.LocalObjectReference credentialsSecretRef, String datacenter, String defaultDatastore, String folder, String network, String vCenter) {
        super();
        this.certificatesSecretRef = certificatesSecretRef;
        this.cluster = cluster;
        this.credentialsSecretRef = credentialsSecretRef;
        this.datacenter = datacenter;
        this.defaultDatastore = defaultDatastore;
        this.folder = folder;
        this.network = network;
        this.vCenter = vCenter;
    }

    @JsonProperty("certificatesSecretRef")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getCertificatesSecretRef() {
        return certificatesSecretRef;
    }

    @JsonProperty("certificatesSecretRef")
    public void setCertificatesSecretRef(io.fabric8.kubernetes.api.model.LocalObjectReference certificatesSecretRef) {
        this.certificatesSecretRef = certificatesSecretRef;
    }

    @JsonProperty("cluster")
    public String getCluster() {
        return cluster;
    }

    @JsonProperty("cluster")
    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    @JsonProperty("credentialsSecretRef")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getCredentialsSecretRef() {
        return credentialsSecretRef;
    }

    @JsonProperty("credentialsSecretRef")
    public void setCredentialsSecretRef(io.fabric8.kubernetes.api.model.LocalObjectReference credentialsSecretRef) {
        this.credentialsSecretRef = credentialsSecretRef;
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

    @JsonProperty("folder")
    public String getFolder() {
        return folder;
    }

    @JsonProperty("folder")
    public void setFolder(String folder) {
        this.folder = folder;
    }

    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
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
