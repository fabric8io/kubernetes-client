
package io.fabric8.openshift.api.model.installer.vsphere.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * VCenters contains information on individual vcenter.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "password",
    "username",
    "vCenter"
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
public class VCenters implements Editable<VCentersBuilder>, KubernetesResource
{

    @JsonProperty("password")
    private String password;
    @JsonProperty("username")
    private String username;
    @JsonProperty("vCenter")
    private String vCenter;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VCenters() {
    }

    public VCenters(String password, String username, String vCenter) {
        super();
        this.password = password;
        this.username = username;
        this.vCenter = vCenter;
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
    public VCentersBuilder edit() {
        return new VCentersBuilder(this);
    }

    @JsonIgnore
    public VCentersBuilder toBuilder() {
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
