
package io.fabric8.openshift.api.model.installer.gcp.v1;

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

/**
 * MachinePool stores the configuration for a machine pool installed on GCP.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "confidentialCompute",
    "onHostMaintenance",
    "osDisk",
    "osImage",
    "secureBoot",
    "serviceAccount",
    "tags",
    "type",
    "zones"
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
public class MachinePool implements Editable<MachinePoolBuilder>, KubernetesResource
{

    @JsonProperty("confidentialCompute")
    private String confidentialCompute;
    @JsonProperty("onHostMaintenance")
    private String onHostMaintenance;
    @JsonProperty("osDisk")
    private OSDisk osDisk;
    @JsonProperty("osImage")
    private OSImage osImage;
    @JsonProperty("secureBoot")
    private String secureBoot;
    @JsonProperty("serviceAccount")
    private String serviceAccount;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> tags = new ArrayList<>();
    @JsonProperty("type")
    private String type;
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> zones = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePool() {
    }

    public MachinePool(String confidentialCompute, String onHostMaintenance, OSDisk osDisk, OSImage osImage, String secureBoot, String serviceAccount, List<String> tags, String type, List<String> zones) {
        super();
        this.confidentialCompute = confidentialCompute;
        this.onHostMaintenance = onHostMaintenance;
        this.osDisk = osDisk;
        this.osImage = osImage;
        this.secureBoot = secureBoot;
        this.serviceAccount = serviceAccount;
        this.tags = tags;
        this.type = type;
        this.zones = zones;
    }

    /**
     * confidentialCompute is an optional field defining whether the instance should have Confidential Computing enabled or not, and the Confidential Computing technology of choice.<br><p>     With Disabled, Confidential Computing is disabled.<br><p>     With Enabled, Confidential Computing is enabled with no preference on the<br><p> Confidential Computing technology. The platform chooses a default i.e. AMD SEV, which is subject to change over time.<br><p>     With AMDEncryptedVirtualization, Confidential Computing is enabled with<br><p> AMD Secure Encrypted Virtualization (AMD SEV).<br><p>     With AMDEncryptedVirtualizationNestedPaging, Confidential Computing is<br><p> enabled with AMD Secure Encrypted Virtualization Secure Nested Paging (AMD SEV-SNP).<br><p>     With IntelTrustedDomainExtensions, Confidential Computing is enabled with<br><p> Intel Trusted Domain Extensions (Intel TDX).<br><p>     If any value other than Disabled is set, a machine type and region that supports<br><p> Confidential Computing must be specified. Machine series and regions supporting Confidential Computing technologies can be checked at https://cloud.google.com/confidential-computing/confidential-vm/docs/supported-configurations#machine-type-cpu-zone<br><p>     If any value other than Disabled is set, onHostMaintenance is required to be set<br><p> to "Terminate".
     */
    @JsonProperty("confidentialCompute")
    public String getConfidentialCompute() {
        return confidentialCompute;
    }

    /**
     * confidentialCompute is an optional field defining whether the instance should have Confidential Computing enabled or not, and the Confidential Computing technology of choice.<br><p>     With Disabled, Confidential Computing is disabled.<br><p>     With Enabled, Confidential Computing is enabled with no preference on the<br><p> Confidential Computing technology. The platform chooses a default i.e. AMD SEV, which is subject to change over time.<br><p>     With AMDEncryptedVirtualization, Confidential Computing is enabled with<br><p> AMD Secure Encrypted Virtualization (AMD SEV).<br><p>     With AMDEncryptedVirtualizationNestedPaging, Confidential Computing is<br><p> enabled with AMD Secure Encrypted Virtualization Secure Nested Paging (AMD SEV-SNP).<br><p>     With IntelTrustedDomainExtensions, Confidential Computing is enabled with<br><p> Intel Trusted Domain Extensions (Intel TDX).<br><p>     If any value other than Disabled is set, a machine type and region that supports<br><p> Confidential Computing must be specified. Machine series and regions supporting Confidential Computing technologies can be checked at https://cloud.google.com/confidential-computing/confidential-vm/docs/supported-configurations#machine-type-cpu-zone<br><p>     If any value other than Disabled is set, onHostMaintenance is required to be set<br><p> to "Terminate".
     */
    @JsonProperty("confidentialCompute")
    public void setConfidentialCompute(String confidentialCompute) {
        this.confidentialCompute = confidentialCompute;
    }

    /**
     * OnHostMaintenance determines the behavior when a maintenance event occurs that might cause the instance to reboot. Allowed values are "Migrate" and "Terminate". If omitted, the platform chooses a default, which is subject to change over time, currently that default is "Migrate".
     */
    @JsonProperty("onHostMaintenance")
    public String getOnHostMaintenance() {
        return onHostMaintenance;
    }

    /**
     * OnHostMaintenance determines the behavior when a maintenance event occurs that might cause the instance to reboot. Allowed values are "Migrate" and "Terminate". If omitted, the platform chooses a default, which is subject to change over time, currently that default is "Migrate".
     */
    @JsonProperty("onHostMaintenance")
    public void setOnHostMaintenance(String onHostMaintenance) {
        this.onHostMaintenance = onHostMaintenance;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on GCP.
     */
    @JsonProperty("osDisk")
    public OSDisk getOsDisk() {
        return osDisk;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on GCP.
     */
    @JsonProperty("osDisk")
    public void setOsDisk(OSDisk osDisk) {
        this.osDisk = osDisk;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on GCP.
     */
    @JsonProperty("osImage")
    public OSImage getOsImage() {
        return osImage;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on GCP.
     */
    @JsonProperty("osImage")
    public void setOsImage(OSImage osImage) {
        this.osImage = osImage;
    }

    /**
     * SecureBoot Defines whether the instance should have secure boot enabled. secure boot Verify the digital signature of all boot components, and halt the boot process if signature verification fails. If omitted, the platform chooses a default, which is subject to change over time, currently that default is false.
     */
    @JsonProperty("secureBoot")
    public String getSecureBoot() {
        return secureBoot;
    }

    /**
     * SecureBoot Defines whether the instance should have secure boot enabled. secure boot Verify the digital signature of all boot components, and halt the boot process if signature verification fails. If omitted, the platform chooses a default, which is subject to change over time, currently that default is false.
     */
    @JsonProperty("secureBoot")
    public void setSecureBoot(String secureBoot) {
        this.secureBoot = secureBoot;
    }

    /**
     * ServiceAccount is the email of a gcp service account to be used during installations. The provided service account can be attached to both control-plane nodes and worker nodes in order to provide the permissions required by the cloud provider.
     */
    @JsonProperty("serviceAccount")
    public String getServiceAccount() {
        return serviceAccount;
    }

    /**
     * ServiceAccount is the email of a gcp service account to be used during installations. The provided service account can be attached to both control-plane nodes and worker nodes in order to provide the permissions required by the cloud provider.
     */
    @JsonProperty("serviceAccount")
    public void setServiceAccount(String serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    /**
     * Tags defines a set of network tags which will be added to instances in the machineset
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTags() {
        return tags;
    }

    /**
     * Tags defines a set of network tags which will be added to instances in the machineset
     */
    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * InstanceType defines the GCP instance type. eg. n1-standard-4
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * InstanceType defines the GCP instance type. eg. n1-standard-4
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Zones is list of availability zones that can be used.
     */
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getZones() {
        return zones;
    }

    /**
     * Zones is list of availability zones that can be used.
     */
    @JsonProperty("zones")
    public void setZones(List<String> zones) {
        this.zones = zones;
    }

    @JsonIgnore
    public MachinePoolBuilder edit() {
        return new MachinePoolBuilder(this);
    }

    @JsonIgnore
    public MachinePoolBuilder toBuilder() {
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
        if (!(o instanceof MachinePool)) {
            return false;
        }
        MachinePool other = (MachinePool) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$confidentialCompute = this.getConfidentialCompute();
        Object other$confidentialCompute = other.getConfidentialCompute();
        if (this$confidentialCompute == null ? other$confidentialCompute != null : !this$confidentialCompute.equals(other$confidentialCompute)) {
            return false;
        }
        Object this$onHostMaintenance = this.getOnHostMaintenance();
        Object other$onHostMaintenance = other.getOnHostMaintenance();
        if (this$onHostMaintenance == null ? other$onHostMaintenance != null : !this$onHostMaintenance.equals(other$onHostMaintenance)) {
            return false;
        }
        Object this$osDisk = this.getOsDisk();
        Object other$osDisk = other.getOsDisk();
        if (this$osDisk == null ? other$osDisk != null : !this$osDisk.equals(other$osDisk)) {
            return false;
        }
        Object this$osImage = this.getOsImage();
        Object other$osImage = other.getOsImage();
        if (this$osImage == null ? other$osImage != null : !this$osImage.equals(other$osImage)) {
            return false;
        }
        Object this$secureBoot = this.getSecureBoot();
        Object other$secureBoot = other.getSecureBoot();
        if (this$secureBoot == null ? other$secureBoot != null : !this$secureBoot.equals(other$secureBoot)) {
            return false;
        }
        Object this$serviceAccount = this.getServiceAccount();
        Object other$serviceAccount = other.getServiceAccount();
        if (this$serviceAccount == null ? other$serviceAccount != null : !this$serviceAccount.equals(other$serviceAccount)) {
            return false;
        }
        Object this$tags = this.getTags();
        Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$zones = this.getZones();
        Object other$zones = other.getZones();
        if (this$zones == null ? other$zones != null : !this$zones.equals(other$zones)) {
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
        return other instanceof MachinePool;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $confidentialCompute = this.getConfidentialCompute();
        result = result * prime + ($confidentialCompute == null ? 43 : $confidentialCompute.hashCode());
        Object $onHostMaintenance = this.getOnHostMaintenance();
        result = result * prime + ($onHostMaintenance == null ? 43 : $onHostMaintenance.hashCode());
        Object $osDisk = this.getOsDisk();
        result = result * prime + ($osDisk == null ? 43 : $osDisk.hashCode());
        Object $osImage = this.getOsImage();
        result = result * prime + ($osImage == null ? 43 : $osImage.hashCode());
        Object $secureBoot = this.getSecureBoot();
        result = result * prime + ($secureBoot == null ? 43 : $secureBoot.hashCode());
        Object $serviceAccount = this.getServiceAccount();
        result = result * prime + ($serviceAccount == null ? 43 : $serviceAccount.hashCode());
        Object $tags = this.getTags();
        result = result * prime + ($tags == null ? 43 : $tags.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $zones = this.getZones();
        result = result * prime + ($zones == null ? 43 : $zones.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachinePool(" + "confidentialCompute=" + this.getConfidentialCompute() + ", onHostMaintenance=" + this.getOnHostMaintenance() + ", osDisk=" + this.getOsDisk() + ", osImage=" + this.getOsImage() + ", secureBoot=" + this.getSecureBoot() + ", serviceAccount=" + this.getServiceAccount() + ", tags=" + this.getTags() + ", type=" + this.getType() + ", zones=" + this.getZones() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
