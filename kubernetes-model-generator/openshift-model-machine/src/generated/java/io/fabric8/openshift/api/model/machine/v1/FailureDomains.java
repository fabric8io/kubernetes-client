
package io.fabric8.openshift.api.model.machine.v1;

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
 * FailureDomain represents the different configurations required to spread Machines across failure domains on different platforms.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "azure",
    "gcp",
    "nutanix",
    "openstack",
    "platform",
    "vsphere"
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
public class FailureDomains implements Editable<FailureDomainsBuilder>, KubernetesResource
{

    @JsonProperty("aws")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AWSFailureDomain> aws = new ArrayList<>();
    @JsonProperty("azure")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AzureFailureDomain> azure = new ArrayList<>();
    @JsonProperty("gcp")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GCPFailureDomain> gcp = new ArrayList<>();
    @JsonProperty("nutanix")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NutanixFailureDomainReference> nutanix = new ArrayList<>();
    @JsonProperty("openstack")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OpenStackFailureDomain> openstack = new ArrayList<>();
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("vsphere")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VSphereFailureDomain> vsphere = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FailureDomains() {
    }

    public FailureDomains(List<AWSFailureDomain> aws, List<AzureFailureDomain> azure, List<GCPFailureDomain> gcp, List<NutanixFailureDomainReference> nutanix, List<OpenStackFailureDomain> openstack, String platform, List<VSphereFailureDomain> vsphere) {
        super();
        this.aws = aws;
        this.azure = azure;
        this.gcp = gcp;
        this.nutanix = nutanix;
        this.openstack = openstack;
        this.platform = platform;
        this.vsphere = vsphere;
    }

    /**
     * aws configures failure domain information for the AWS platform.
     */
    @JsonProperty("aws")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AWSFailureDomain> getAws() {
        return aws;
    }

    /**
     * aws configures failure domain information for the AWS platform.
     */
    @JsonProperty("aws")
    public void setAws(List<AWSFailureDomain> aws) {
        this.aws = aws;
    }

    /**
     * azure configures failure domain information for the Azure platform.
     */
    @JsonProperty("azure")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AzureFailureDomain> getAzure() {
        return azure;
    }

    /**
     * azure configures failure domain information for the Azure platform.
     */
    @JsonProperty("azure")
    public void setAzure(List<AzureFailureDomain> azure) {
        this.azure = azure;
    }

    /**
     * gcp configures failure domain information for the GCP platform.
     */
    @JsonProperty("gcp")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GCPFailureDomain> getGcp() {
        return gcp;
    }

    /**
     * gcp configures failure domain information for the GCP platform.
     */
    @JsonProperty("gcp")
    public void setGcp(List<GCPFailureDomain> gcp) {
        this.gcp = gcp;
    }

    /**
     * nutanix configures failure domain information for the Nutanix platform.
     */
    @JsonProperty("nutanix")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NutanixFailureDomainReference> getNutanix() {
        return nutanix;
    }

    /**
     * nutanix configures failure domain information for the Nutanix platform.
     */
    @JsonProperty("nutanix")
    public void setNutanix(List<NutanixFailureDomainReference> nutanix) {
        this.nutanix = nutanix;
    }

    /**
     * openstack configures failure domain information for the OpenStack platform.
     */
    @JsonProperty("openstack")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OpenStackFailureDomain> getOpenstack() {
        return openstack;
    }

    /**
     * openstack configures failure domain information for the OpenStack platform.
     */
    @JsonProperty("openstack")
    public void setOpenstack(List<OpenStackFailureDomain> openstack) {
        this.openstack = openstack;
    }

    /**
     * platform identifies the platform for which the FailureDomain represents. Currently supported values are AWS, Azure, GCP, OpenStack, VSphere and Nutanix.
     */
    @JsonProperty("platform")
    public String getPlatform() {
        return platform;
    }

    /**
     * platform identifies the platform for which the FailureDomain represents. Currently supported values are AWS, Azure, GCP, OpenStack, VSphere and Nutanix.
     */
    @JsonProperty("platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * vsphere configures failure domain information for the VSphere platform.
     */
    @JsonProperty("vsphere")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VSphereFailureDomain> getVsphere() {
        return vsphere;
    }

    /**
     * vsphere configures failure domain information for the VSphere platform.
     */
    @JsonProperty("vsphere")
    public void setVsphere(List<VSphereFailureDomain> vsphere) {
        this.vsphere = vsphere;
    }

    @JsonIgnore
    public FailureDomainsBuilder edit() {
        return new FailureDomainsBuilder(this);
    }

    @JsonIgnore
    public FailureDomainsBuilder toBuilder() {
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
        if (!(o instanceof FailureDomains)) {
            return false;
        }
        FailureDomains other = (FailureDomains) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$aws = this.getAws();
        Object other$aws = other.getAws();
        if (this$aws == null ? other$aws != null : !this$aws.equals(other$aws)) {
            return false;
        }
        Object this$azure = this.getAzure();
        Object other$azure = other.getAzure();
        if (this$azure == null ? other$azure != null : !this$azure.equals(other$azure)) {
            return false;
        }
        Object this$gcp = this.getGcp();
        Object other$gcp = other.getGcp();
        if (this$gcp == null ? other$gcp != null : !this$gcp.equals(other$gcp)) {
            return false;
        }
        Object this$nutanix = this.getNutanix();
        Object other$nutanix = other.getNutanix();
        if (this$nutanix == null ? other$nutanix != null : !this$nutanix.equals(other$nutanix)) {
            return false;
        }
        Object this$openstack = this.getOpenstack();
        Object other$openstack = other.getOpenstack();
        if (this$openstack == null ? other$openstack != null : !this$openstack.equals(other$openstack)) {
            return false;
        }
        Object this$platform = this.getPlatform();
        Object other$platform = other.getPlatform();
        if (this$platform == null ? other$platform != null : !this$platform.equals(other$platform)) {
            return false;
        }
        Object this$vsphere = this.getVsphere();
        Object other$vsphere = other.getVsphere();
        if (this$vsphere == null ? other$vsphere != null : !this$vsphere.equals(other$vsphere)) {
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
        return other instanceof FailureDomains;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $aws = this.getAws();
        result = result * prime + ($aws == null ? 43 : $aws.hashCode());
        Object $azure = this.getAzure();
        result = result * prime + ($azure == null ? 43 : $azure.hashCode());
        Object $gcp = this.getGcp();
        result = result * prime + ($gcp == null ? 43 : $gcp.hashCode());
        Object $nutanix = this.getNutanix();
        result = result * prime + ($nutanix == null ? 43 : $nutanix.hashCode());
        Object $openstack = this.getOpenstack();
        result = result * prime + ($openstack == null ? 43 : $openstack.hashCode());
        Object $platform = this.getPlatform();
        result = result * prime + ($platform == null ? 43 : $platform.hashCode());
        Object $vsphere = this.getVsphere();
        result = result * prime + ($vsphere == null ? 43 : $vsphere.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FailureDomains(" + "aws=" + this.getAws() + ", azure=" + this.getAzure() + ", gcp=" + this.getGcp() + ", nutanix=" + this.getNutanix() + ", openstack=" + this.getOpenstack() + ", platform=" + this.getPlatform() + ", vsphere=" + this.getVsphere() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
