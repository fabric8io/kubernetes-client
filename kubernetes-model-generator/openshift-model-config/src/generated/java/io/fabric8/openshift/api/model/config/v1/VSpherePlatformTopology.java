
package io.fabric8.openshift.api.model.config.v1;

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
 * VSpherePlatformTopology holds the required and optional vCenter objects - datacenter, computeCluster, networks, datastore and resourcePool - to provision virtual machines.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "computeCluster",
    "datacenter",
    "datastore",
    "folder",
    "networks",
    "resourcePool",
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
public class VSpherePlatformTopology implements Editable<VSpherePlatformTopologyBuilder>, KubernetesResource
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
    @JsonProperty("template")
    private String template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VSpherePlatformTopology() {
    }

    public VSpherePlatformTopology(String computeCluster, String datacenter, String datastore, String folder, List<String> networks, String resourcePool, String template) {
        super();
        this.computeCluster = computeCluster;
        this.datacenter = datacenter;
        this.datastore = datastore;
        this.folder = folder;
        this.networks = networks;
        this.resourcePool = resourcePool;
        this.template = template;
    }

    /**
     * computeCluster the absolute path of the vCenter cluster in which virtual machine will be located. The absolute path is of the form /&lt;datacenter&gt;/host/&lt;cluster&gt;. The maximum length of the path is 2048 characters.
     */
    @JsonProperty("computeCluster")
    public String getComputeCluster() {
        return computeCluster;
    }

    /**
     * computeCluster the absolute path of the vCenter cluster in which virtual machine will be located. The absolute path is of the form /&lt;datacenter&gt;/host/&lt;cluster&gt;. The maximum length of the path is 2048 characters.
     */
    @JsonProperty("computeCluster")
    public void setComputeCluster(String computeCluster) {
        this.computeCluster = computeCluster;
    }

    /**
     * datacenter is the name of vCenter datacenter in which virtual machines will be located. The maximum length of the datacenter name is 80 characters.
     */
    @JsonProperty("datacenter")
    public String getDatacenter() {
        return datacenter;
    }

    /**
     * datacenter is the name of vCenter datacenter in which virtual machines will be located. The maximum length of the datacenter name is 80 characters.
     */
    @JsonProperty("datacenter")
    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    /**
     * datastore is the absolute path of the datastore in which the virtual machine is located. The absolute path is of the form /&lt;datacenter&gt;/datastore/&lt;datastore&gt; The maximum length of the path is 2048 characters.
     */
    @JsonProperty("datastore")
    public String getDatastore() {
        return datastore;
    }

    /**
     * datastore is the absolute path of the datastore in which the virtual machine is located. The absolute path is of the form /&lt;datacenter&gt;/datastore/&lt;datastore&gt; The maximum length of the path is 2048 characters.
     */
    @JsonProperty("datastore")
    public void setDatastore(String datastore) {
        this.datastore = datastore;
    }

    /**
     * folder is the absolute path of the folder where virtual machines are located. The absolute path is of the form /&lt;datacenter&gt;/vm/&lt;folder&gt;. The maximum length of the path is 2048 characters.
     */
    @JsonProperty("folder")
    public String getFolder() {
        return folder;
    }

    /**
     * folder is the absolute path of the folder where virtual machines are located. The absolute path is of the form /&lt;datacenter&gt;/vm/&lt;folder&gt;. The maximum length of the path is 2048 characters.
     */
    @JsonProperty("folder")
    public void setFolder(String folder) {
        this.folder = folder;
    }

    /**
     * networks is the list of port group network names within this failure domain. If feature gate VSphereMultiNetworks is enabled, up to 10 network adapters may be defined. 10 is the maximum number of virtual network devices which may be attached to a VM as defined by: https://configmax.esp.vmware.com/guest?vmwareproduct=vSphere&amp;release=vSphere%208.0&amp;categories=1-0 The available networks (port groups) can be listed using `govc ls 'network/&#42;'` Networks should be in the form of an absolute path: /&lt;datacenter&gt;/network/&lt;portgroup&gt;.
     */
    @JsonProperty("networks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNetworks() {
        return networks;
    }

    /**
     * networks is the list of port group network names within this failure domain. If feature gate VSphereMultiNetworks is enabled, up to 10 network adapters may be defined. 10 is the maximum number of virtual network devices which may be attached to a VM as defined by: https://configmax.esp.vmware.com/guest?vmwareproduct=vSphere&amp;release=vSphere%208.0&amp;categories=1-0 The available networks (port groups) can be listed using `govc ls 'network/&#42;'` Networks should be in the form of an absolute path: /&lt;datacenter&gt;/network/&lt;portgroup&gt;.
     */
    @JsonProperty("networks")
    public void setNetworks(List<String> networks) {
        this.networks = networks;
    }

    /**
     * resourcePool is the absolute path of the resource pool where virtual machines will be created. The absolute path is of the form /&lt;datacenter&gt;/host/&lt;cluster&gt;/Resources/&lt;resourcepool&gt;. The maximum length of the path is 2048 characters.
     */
    @JsonProperty("resourcePool")
    public String getResourcePool() {
        return resourcePool;
    }

    /**
     * resourcePool is the absolute path of the resource pool where virtual machines will be created. The absolute path is of the form /&lt;datacenter&gt;/host/&lt;cluster&gt;/Resources/&lt;resourcepool&gt;. The maximum length of the path is 2048 characters.
     */
    @JsonProperty("resourcePool")
    public void setResourcePool(String resourcePool) {
        this.resourcePool = resourcePool;
    }

    /**
     * template is the full inventory path of the virtual machine or template that will be cloned when creating new machines in this failure domain. The maximum length of the path is 2048 characters.<br><p> <br><p> When omitted, the template will be calculated by the control plane machineset operator based on the region and zone defined in VSpherePlatformFailureDomainSpec. For example, for zone=zonea, region=region1, and infrastructure name=test, the template path would be calculated as /&lt;datacenter&gt;/vm/test-rhcos-region1-zonea.
     */
    @JsonProperty("template")
    public String getTemplate() {
        return template;
    }

    /**
     * template is the full inventory path of the virtual machine or template that will be cloned when creating new machines in this failure domain. The maximum length of the path is 2048 characters.<br><p> <br><p> When omitted, the template will be calculated by the control plane machineset operator based on the region and zone defined in VSpherePlatformFailureDomainSpec. For example, for zone=zonea, region=region1, and infrastructure name=test, the template path would be calculated as /&lt;datacenter&gt;/vm/test-rhcos-region1-zonea.
     */
    @JsonProperty("template")
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonIgnore
    public VSpherePlatformTopologyBuilder edit() {
        return new VSpherePlatformTopologyBuilder(this);
    }

    @JsonIgnore
    public VSpherePlatformTopologyBuilder toBuilder() {
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
