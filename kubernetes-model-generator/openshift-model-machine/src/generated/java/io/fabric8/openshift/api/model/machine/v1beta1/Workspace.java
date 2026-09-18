
package io.fabric8.openshift.api.model.machine.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * WorkspaceConfig defines a workspace configuration for the vSphere cloud provider.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "datacenter",
    "datastore",
    "folder",
    "resourcePool",
    "server",
    "vmGroup"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class Workspace implements Editable<WorkspaceBuilder>, KubernetesResource
{

    @JsonProperty("datacenter")
    private String datacenter;
    @JsonProperty("datastore")
    private String datastore;
    @JsonProperty("folder")
    private String folder;
    @JsonProperty("resourcePool")
    private String resourcePool;
    @JsonProperty("server")
    private String server;
    @JsonProperty("vmGroup")
    private String vmGroup;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Workspace() {
    }

    public Workspace(String datacenter, String datastore, String folder, String resourcePool, String server, String vmGroup) {
        super();
        this.datacenter = datacenter;
        this.datastore = datastore;
        this.folder = folder;
        this.resourcePool = resourcePool;
        this.server = server;
        this.vmGroup = vmGroup;
    }

    /**
     * datacenter is the datacenter in which VMs are created/located.
     */
    @JsonProperty("datacenter")
    public String getDatacenter() {
        return datacenter;
    }

    /**
     * datacenter is the datacenter in which VMs are created/located.
     */
    @JsonProperty("datacenter")
    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    /**
     * datastore is the datastore in which VMs are created/located.
     */
    @JsonProperty("datastore")
    public String getDatastore() {
        return datastore;
    }

    /**
     * datastore is the datastore in which VMs are created/located.
     */
    @JsonProperty("datastore")
    public void setDatastore(String datastore) {
        this.datastore = datastore;
    }

    /**
     * folder is the folder in which VMs are created/located.
     */
    @JsonProperty("folder")
    public String getFolder() {
        return folder;
    }

    /**
     * folder is the folder in which VMs are created/located.
     */
    @JsonProperty("folder")
    public void setFolder(String folder) {
        this.folder = folder;
    }

    /**
     * resourcePool is the resource pool in which VMs are created/located.
     */
    @JsonProperty("resourcePool")
    public String getResourcePool() {
        return resourcePool;
    }

    /**
     * resourcePool is the resource pool in which VMs are created/located.
     */
    @JsonProperty("resourcePool")
    public void setResourcePool(String resourcePool) {
        this.resourcePool = resourcePool;
    }

    /**
     * server is the IP address or FQDN of the vSphere endpoint.
     */
    @JsonProperty("server")
    public String getServer() {
        return server;
    }

    /**
     * server is the IP address or FQDN of the vSphere endpoint.
     */
    @JsonProperty("server")
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * vmGroup is the cluster vm group in which virtual machines will be added for vm host group based zonal.
     */
    @JsonProperty("vmGroup")
    public String getVmGroup() {
        return vmGroup;
    }

    /**
     * vmGroup is the cluster vm group in which virtual machines will be added for vm host group based zonal.
     */
    @JsonProperty("vmGroup")
    public void setVmGroup(String vmGroup) {
        this.vmGroup = vmGroup;
    }

    @JsonIgnore
    public WorkspaceBuilder edit() {
        return new WorkspaceBuilder(this);
    }

    @JsonIgnore
    public WorkspaceBuilder toBuilder() {
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
        if (!(o instanceof Workspace)) {
            return false;
        }
        Workspace other = (Workspace) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$datacenter = this.getDatacenter();
        Object other$datacenter = other.getDatacenter();
        if (this$datacenter == null ? other$datacenter != null : !this$datacenter.equals(other$datacenter)) {
            return false;
        }
        Object this$datastore = this.getDatastore();
        Object other$datastore = other.getDatastore();
        if (this$datastore == null ? other$datastore != null : !this$datastore.equals(other$datastore)) {
            return false;
        }
        Object this$folder = this.getFolder();
        Object other$folder = other.getFolder();
        if (this$folder == null ? other$folder != null : !this$folder.equals(other$folder)) {
            return false;
        }
        Object this$resourcePool = this.getResourcePool();
        Object other$resourcePool = other.getResourcePool();
        if (this$resourcePool == null ? other$resourcePool != null : !this$resourcePool.equals(other$resourcePool)) {
            return false;
        }
        Object this$server = this.getServer();
        Object other$server = other.getServer();
        if (this$server == null ? other$server != null : !this$server.equals(other$server)) {
            return false;
        }
        Object this$vmGroup = this.getVmGroup();
        Object other$vmGroup = other.getVmGroup();
        if (this$vmGroup == null ? other$vmGroup != null : !this$vmGroup.equals(other$vmGroup)) {
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
        return other instanceof Workspace;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $datacenter = this.getDatacenter();
        result = result * prime + ($datacenter == null ? 43 : $datacenter.hashCode());
        Object $datastore = this.getDatastore();
        result = result * prime + ($datastore == null ? 43 : $datastore.hashCode());
        Object $folder = this.getFolder();
        result = result * prime + ($folder == null ? 43 : $folder.hashCode());
        Object $resourcePool = this.getResourcePool();
        result = result * prime + ($resourcePool == null ? 43 : $resourcePool.hashCode());
        Object $server = this.getServer();
        result = result * prime + ($server == null ? 43 : $server.hashCode());
        Object $vmGroup = this.getVmGroup();
        result = result * prime + ($vmGroup == null ? 43 : $vmGroup.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Workspace(" + "datacenter=" + this.getDatacenter() + ", datastore=" + this.getDatastore() + ", folder=" + this.getFolder() + ", resourcePool=" + this.getResourcePool() + ", server=" + this.getServer() + ", vmGroup=" + this.getVmGroup() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
