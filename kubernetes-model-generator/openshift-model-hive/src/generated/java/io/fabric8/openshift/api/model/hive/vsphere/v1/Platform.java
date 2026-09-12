
package io.fabric8.openshift.api.model.hive.vsphere.v1;

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
 * Platform stores any global configuration used for vSphere platforms.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "certificatesSecretRef",
    "cluster",
    "credentialsSecretRef",
    "datacenter",
    "defaultDatastore",
    "folder",
    "network",
    "vCenter"
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
public class Platform implements Editable<PlatformBuilder>, KubernetesResource
{

    @JsonProperty("certificatesSecretRef")
    private LocalObjectReference certificatesSecretRef;
    @JsonProperty("cluster")
    private String cluster;
    @JsonProperty("credentialsSecretRef")
    private LocalObjectReference credentialsSecretRef;
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
     */
    public Platform() {
    }

    public Platform(LocalObjectReference certificatesSecretRef, String cluster, LocalObjectReference credentialsSecretRef, String datacenter, String defaultDatastore, String folder, String network, String vCenter) {
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

    /**
     * Platform stores any global configuration used for vSphere platforms.
     */
    @JsonProperty("certificatesSecretRef")
    public LocalObjectReference getCertificatesSecretRef() {
        return certificatesSecretRef;
    }

    /**
     * Platform stores any global configuration used for vSphere platforms.
     */
    @JsonProperty("certificatesSecretRef")
    public void setCertificatesSecretRef(LocalObjectReference certificatesSecretRef) {
        this.certificatesSecretRef = certificatesSecretRef;
    }

    /**
     * Cluster is the name of the cluster virtual machines will be cloned into.
     */
    @JsonProperty("cluster")
    public String getCluster() {
        return cluster;
    }

    /**
     * Cluster is the name of the cluster virtual machines will be cloned into.
     */
    @JsonProperty("cluster")
    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    /**
     * Platform stores any global configuration used for vSphere platforms.
     */
    @JsonProperty("credentialsSecretRef")
    public LocalObjectReference getCredentialsSecretRef() {
        return credentialsSecretRef;
    }

    /**
     * Platform stores any global configuration used for vSphere platforms.
     */
    @JsonProperty("credentialsSecretRef")
    public void setCredentialsSecretRef(LocalObjectReference credentialsSecretRef) {
        this.credentialsSecretRef = credentialsSecretRef;
    }

    /**
     * Datacenter is the name of the datacenter to use in the vCenter.
     */
    @JsonProperty("datacenter")
    public String getDatacenter() {
        return datacenter;
    }

    /**
     * Datacenter is the name of the datacenter to use in the vCenter.
     */
    @JsonProperty("datacenter")
    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    /**
     * DefaultDatastore is the default datastore to use for provisioning volumes.
     */
    @JsonProperty("defaultDatastore")
    public String getDefaultDatastore() {
        return defaultDatastore;
    }

    /**
     * DefaultDatastore is the default datastore to use for provisioning volumes.
     */
    @JsonProperty("defaultDatastore")
    public void setDefaultDatastore(String defaultDatastore) {
        this.defaultDatastore = defaultDatastore;
    }

    /**
     * Folder is the name of the folder that will be used and/or created for virtual machines.
     */
    @JsonProperty("folder")
    public String getFolder() {
        return folder;
    }

    /**
     * Folder is the name of the folder that will be used and/or created for virtual machines.
     */
    @JsonProperty("folder")
    public void setFolder(String folder) {
        this.folder = folder;
    }

    /**
     * Network specifies the name of the network to be used by the cluster.
     */
    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    /**
     * Network specifies the name of the network to be used by the cluster.
     */
    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * VCenter is the domain name or IP address of the vCenter.
     */
    @JsonProperty("vCenter")
    public String getVCenter() {
        return vCenter;
    }

    /**
     * VCenter is the domain name or IP address of the vCenter.
     */
    @JsonProperty("vCenter")
    public void setVCenter(String vCenter) {
        this.vCenter = vCenter;
    }

    @JsonIgnore
    public PlatformBuilder edit() {
        return new PlatformBuilder(this);
    }

    @JsonIgnore
    public PlatformBuilder toBuilder() {
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
        if (!(o instanceof Platform)) {
            return false;
        }
        Platform other = (Platform) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$certificatesSecretRef = this.getCertificatesSecretRef();
        Object other$certificatesSecretRef = other.getCertificatesSecretRef();
        if (this$certificatesSecretRef == null ? other$certificatesSecretRef != null : !this$certificatesSecretRef.equals(other$certificatesSecretRef)) {
            return false;
        }
        Object this$cluster = this.getCluster();
        Object other$cluster = other.getCluster();
        if (this$cluster == null ? other$cluster != null : !this$cluster.equals(other$cluster)) {
            return false;
        }
        Object this$credentialsSecretRef = this.getCredentialsSecretRef();
        Object other$credentialsSecretRef = other.getCredentialsSecretRef();
        if (this$credentialsSecretRef == null ? other$credentialsSecretRef != null : !this$credentialsSecretRef.equals(other$credentialsSecretRef)) {
            return false;
        }
        Object this$datacenter = this.getDatacenter();
        Object other$datacenter = other.getDatacenter();
        if (this$datacenter == null ? other$datacenter != null : !this$datacenter.equals(other$datacenter)) {
            return false;
        }
        Object this$defaultDatastore = this.getDefaultDatastore();
        Object other$defaultDatastore = other.getDefaultDatastore();
        if (this$defaultDatastore == null ? other$defaultDatastore != null : !this$defaultDatastore.equals(other$defaultDatastore)) {
            return false;
        }
        Object this$folder = this.getFolder();
        Object other$folder = other.getFolder();
        if (this$folder == null ? other$folder != null : !this$folder.equals(other$folder)) {
            return false;
        }
        Object this$network = this.getNetwork();
        Object other$network = other.getNetwork();
        if (this$network == null ? other$network != null : !this$network.equals(other$network)) {
            return false;
        }
        Object this$vCenter = this.getVCenter();
        Object other$vCenter = other.getVCenter();
        if (this$vCenter == null ? other$vCenter != null : !this$vCenter.equals(other$vCenter)) {
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
        return other instanceof Platform;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $certificatesSecretRef = this.getCertificatesSecretRef();
        result = result * prime + ($certificatesSecretRef == null ? 43 : $certificatesSecretRef.hashCode());
        Object $cluster = this.getCluster();
        result = result * prime + ($cluster == null ? 43 : $cluster.hashCode());
        Object $credentialsSecretRef = this.getCredentialsSecretRef();
        result = result * prime + ($credentialsSecretRef == null ? 43 : $credentialsSecretRef.hashCode());
        Object $datacenter = this.getDatacenter();
        result = result * prime + ($datacenter == null ? 43 : $datacenter.hashCode());
        Object $defaultDatastore = this.getDefaultDatastore();
        result = result * prime + ($defaultDatastore == null ? 43 : $defaultDatastore.hashCode());
        Object $folder = this.getFolder();
        result = result * prime + ($folder == null ? 43 : $folder.hashCode());
        Object $network = this.getNetwork();
        result = result * prime + ($network == null ? 43 : $network.hashCode());
        Object $vCenter = this.getVCenter();
        result = result * prime + ($vCenter == null ? 43 : $vCenter.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Platform(" + "certificatesSecretRef=" + this.getCertificatesSecretRef() + ", cluster=" + this.getCluster() + ", credentialsSecretRef=" + this.getCredentialsSecretRef() + ", datacenter=" + this.getDatacenter() + ", defaultDatastore=" + this.getDefaultDatastore() + ", folder=" + this.getFolder() + ", network=" + this.getNetwork() + ", vCenter=" + this.getVCenter() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
