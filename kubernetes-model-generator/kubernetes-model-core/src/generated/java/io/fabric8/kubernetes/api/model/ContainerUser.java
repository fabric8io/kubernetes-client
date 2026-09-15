
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * ContainerUser represents user identity information
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "linux"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ContainerUser implements Editable<ContainerUserBuilder>, KubernetesResource
{

    @JsonProperty("linux")
    private LinuxContainerUser linux;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ContainerUser() {
    }

    public ContainerUser(LinuxContainerUser linux) {
        super();
        this.linux = linux;
    }

    /**
     * ContainerUser represents user identity information
     */
    @JsonProperty("linux")
    public LinuxContainerUser getLinux() {
        return linux;
    }

    /**
     * ContainerUser represents user identity information
     */
    @JsonProperty("linux")
    public void setLinux(LinuxContainerUser linux) {
        this.linux = linux;
    }

    @JsonIgnore
    public ContainerUserBuilder edit() {
        return new ContainerUserBuilder(this);
    }

    @JsonIgnore
    public ContainerUserBuilder toBuilder() {
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
        if (!(o instanceof ContainerUser)) {
            return false;
        }
        ContainerUser other = (ContainerUser) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$linux = this.getLinux();
        Object other$linux = other.getLinux();
        if (this$linux == null ? other$linux != null : !this$linux.equals(other$linux)) {
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
        return other instanceof ContainerUser;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $linux = this.getLinux();
        result = result * prime + ($linux == null ? 43 : $linux.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ContainerUser(" + "linux=" + this.getLinux() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
