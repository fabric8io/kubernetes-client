
package io.fabric8.openshift.api.model.installer.vsphere.v1;

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
 * Metadata contains vSphere metadata (e.g. for uninstalling the cluster).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "VCenters",
    "password",
    "terraform_platform",
    "username",
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
public class Metadata implements Editable<MetadataBuilder>, KubernetesResource
{

    @JsonProperty("VCenters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VCenters> vCenters = new ArrayList<>();
    @JsonProperty("password")
    private String password;
    @JsonProperty("terraform_platform")
    private String terraformPlatform;
    @JsonProperty("username")
    private String username;
    @JsonProperty("vCenter")
    private String vCenter;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metadata() {
    }

    public Metadata(List<VCenters> vCenters, String password, String terraformPlatform, String username, String vCenter) {
        super();
        this.vCenters = vCenters;
        this.password = password;
        this.terraformPlatform = terraformPlatform;
        this.username = username;
        this.vCenter = vCenter;
    }

    /**
     * VCenters collection of vcenters when multi vcenter support is enabled
     */
    @JsonProperty("VCenters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VCenters> getVCenters() {
        return vCenters;
    }

    /**
     * VCenters collection of vcenters when multi vcenter support is enabled
     */
    @JsonProperty("VCenters")
    public void setVCenters(List<VCenters> vCenters) {
        this.vCenters = vCenters;
    }

    /**
     * Password is the password for the user to use to connect to the vCenter.
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * Password is the password for the user to use to connect to the vCenter.
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * TerraformPlatform is the type...
     */
    @JsonProperty("terraform_platform")
    public String getTerraformPlatform() {
        return terraformPlatform;
    }

    /**
     * TerraformPlatform is the type...
     */
    @JsonProperty("terraform_platform")
    public void setTerraformPlatform(String terraformPlatform) {
        this.terraformPlatform = terraformPlatform;
    }

    /**
     * Username is the name of the user to use to connect to the vCenter.
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * Username is the name of the user to use to connect to the vCenter.
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
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
    public MetadataBuilder edit() {
        return new MetadataBuilder(this);
    }

    @JsonIgnore
    public MetadataBuilder toBuilder() {
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
        if (!(o instanceof Metadata)) {
            return false;
        }
        Metadata other = (Metadata) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$vCenters = this.getVCenters();
        Object other$vCenters = other.getVCenters();
        if (this$vCenters == null ? other$vCenters != null : !this$vCenters.equals(other$vCenters)) {
            return false;
        }
        Object this$password = this.getPassword();
        Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        Object this$terraformPlatform = this.getTerraformPlatform();
        Object other$terraformPlatform = other.getTerraformPlatform();
        if (this$terraformPlatform == null ? other$terraformPlatform != null : !this$terraformPlatform.equals(other$terraformPlatform)) {
            return false;
        }
        Object this$username = this.getUsername();
        Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) {
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
        return other instanceof Metadata;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $vCenters = this.getVCenters();
        result = result * prime + ($vCenters == null ? 43 : $vCenters.hashCode());
        Object $password = this.getPassword();
        result = result * prime + ($password == null ? 43 : $password.hashCode());
        Object $terraformPlatform = this.getTerraformPlatform();
        result = result * prime + ($terraformPlatform == null ? 43 : $terraformPlatform.hashCode());
        Object $username = this.getUsername();
        result = result * prime + ($username == null ? 43 : $username.hashCode());
        Object $vCenter = this.getVCenter();
        result = result * prime + ($vCenter == null ? 43 : $vCenter.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Metadata(" + "vCenters=" + this.getVCenters() + ", password=" + this.getPassword() + ", terraformPlatform=" + this.getTerraformPlatform() + ", username=" + this.getUsername() + ", vCenter=" + this.getVCenter() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
