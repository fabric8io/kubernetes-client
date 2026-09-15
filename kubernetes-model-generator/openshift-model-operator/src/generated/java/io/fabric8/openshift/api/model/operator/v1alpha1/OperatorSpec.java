
package io.fabric8.openshift.api.model.operator.v1alpha1;

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
 * OperatorSpec contains common fields for an operator to need.  It is intended to be anonymous included inside of the Spec struct for you particular operator. DEPRECATED: Use v1.OperatorSpec instead
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "imagePullPolicy",
    "imagePullSpec",
    "logging",
    "managementState",
    "version"
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
public class OperatorSpec implements Editable<OperatorSpecBuilder>, KubernetesResource
{

    @JsonProperty("imagePullPolicy")
    private String imagePullPolicy;
    @JsonProperty("imagePullSpec")
    private String imagePullSpec;
    @JsonProperty("logging")
    private LoggingConfig logging;
    @JsonProperty("managementState")
    private String managementState;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OperatorSpec() {
    }

    public OperatorSpec(String imagePullPolicy, String imagePullSpec, LoggingConfig logging, String managementState, String version) {
        super();
        this.imagePullPolicy = imagePullPolicy;
        this.imagePullSpec = imagePullSpec;
        this.logging = logging;
        this.managementState = managementState;
        this.version = version;
    }

    /**
     * imagePullPolicy specifies the image pull policy. One of Always, Never, IfNotPresent. Defaults to Always if :latest tag is specified, or IfNotPresent otherwise.
     */
    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    /**
     * imagePullPolicy specifies the image pull policy. One of Always, Never, IfNotPresent. Defaults to Always if :latest tag is specified, or IfNotPresent otherwise.
     */
    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    /**
     * imagePullSpec is the image to use for the component.
     */
    @JsonProperty("imagePullSpec")
    public String getImagePullSpec() {
        return imagePullSpec;
    }

    /**
     * imagePullSpec is the image to use for the component.
     */
    @JsonProperty("imagePullSpec")
    public void setImagePullSpec(String imagePullSpec) {
        this.imagePullSpec = imagePullSpec;
    }

    /**
     * OperatorSpec contains common fields for an operator to need.  It is intended to be anonymous included inside of the Spec struct for you particular operator. DEPRECATED: Use v1.OperatorSpec instead
     */
    @JsonProperty("logging")
    public LoggingConfig getLogging() {
        return logging;
    }

    /**
     * OperatorSpec contains common fields for an operator to need.  It is intended to be anonymous included inside of the Spec struct for you particular operator. DEPRECATED: Use v1.OperatorSpec instead
     */
    @JsonProperty("logging")
    public void setLogging(LoggingConfig logging) {
        this.logging = logging;
    }

    /**
     * managementState indicates whether and how the operator should manage the component
     */
    @JsonProperty("managementState")
    public String getManagementState() {
        return managementState;
    }

    /**
     * managementState indicates whether and how the operator should manage the component
     */
    @JsonProperty("managementState")
    public void setManagementState(String managementState) {
        this.managementState = managementState;
    }

    /**
     * version is the desired state in major.minor.micro-patch.  Usually patch is ignored.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version is the desired state in major.minor.micro-patch.  Usually patch is ignored.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public OperatorSpecBuilder edit() {
        return new OperatorSpecBuilder(this);
    }

    @JsonIgnore
    public OperatorSpecBuilder toBuilder() {
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
        if (!(o instanceof OperatorSpec)) {
            return false;
        }
        OperatorSpec other = (OperatorSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$imagePullPolicy = this.getImagePullPolicy();
        Object other$imagePullPolicy = other.getImagePullPolicy();
        if (this$imagePullPolicy == null ? other$imagePullPolicy != null : !this$imagePullPolicy.equals(other$imagePullPolicy)) {
            return false;
        }
        Object this$imagePullSpec = this.getImagePullSpec();
        Object other$imagePullSpec = other.getImagePullSpec();
        if (this$imagePullSpec == null ? other$imagePullSpec != null : !this$imagePullSpec.equals(other$imagePullSpec)) {
            return false;
        }
        Object this$logging = this.getLogging();
        Object other$logging = other.getLogging();
        if (this$logging == null ? other$logging != null : !this$logging.equals(other$logging)) {
            return false;
        }
        Object this$managementState = this.getManagementState();
        Object other$managementState = other.getManagementState();
        if (this$managementState == null ? other$managementState != null : !this$managementState.equals(other$managementState)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
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
        return other instanceof OperatorSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $imagePullPolicy = this.getImagePullPolicy();
        result = result * prime + ($imagePullPolicy == null ? 43 : $imagePullPolicy.hashCode());
        Object $imagePullSpec = this.getImagePullSpec();
        result = result * prime + ($imagePullSpec == null ? 43 : $imagePullSpec.hashCode());
        Object $logging = this.getLogging();
        result = result * prime + ($logging == null ? 43 : $logging.hashCode());
        Object $managementState = this.getManagementState();
        result = result * prime + ($managementState == null ? 43 : $managementState.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OperatorSpec(" + "imagePullPolicy=" + this.getImagePullPolicy() + ", imagePullSpec=" + this.getImagePullSpec() + ", logging=" + this.getLogging() + ", managementState=" + this.getManagementState() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
