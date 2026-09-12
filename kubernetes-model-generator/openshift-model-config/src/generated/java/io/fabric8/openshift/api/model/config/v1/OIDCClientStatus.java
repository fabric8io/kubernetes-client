
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.Condition;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * OIDCClientStatus represents the current state of platform components and how they interact with the configured identity providers.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "componentName",
    "componentNamespace",
    "conditions",
    "consumingUsers",
    "currentOIDCClients"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class OIDCClientStatus implements Editable<OIDCClientStatusBuilder>, KubernetesResource
{

    @JsonProperty("componentName")
    private String componentName;
    @JsonProperty("componentNamespace")
    private String componentNamespace;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("consumingUsers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> consumingUsers = new ArrayList<>();
    @JsonProperty("currentOIDCClients")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OIDCClientReference> currentOIDCClients = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OIDCClientStatus() {
    }

    public OIDCClientStatus(String componentName, String componentNamespace, List<Condition> conditions, List<String> consumingUsers, List<OIDCClientReference> currentOIDCClients) {
        super();
        this.componentName = componentName;
        this.componentNamespace = componentNamespace;
        this.conditions = conditions;
        this.consumingUsers = consumingUsers;
        this.currentOIDCClients = currentOIDCClients;
    }

    /**
     * componentName is a required field that specifies the name of the platform component using the identity provider as an authentication mode. It is used in combination with componentNamespace as a unique identifier.<br><p> <br><p> componentName must not be an empty string ("") and must not exceed 256 characters in length.
     */
    @JsonProperty("componentName")
    public String getComponentName() {
        return componentName;
    }

    /**
     * componentName is a required field that specifies the name of the platform component using the identity provider as an authentication mode. It is used in combination with componentNamespace as a unique identifier.<br><p> <br><p> componentName must not be an empty string ("") and must not exceed 256 characters in length.
     */
    @JsonProperty("componentName")
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    /**
     * componentNamespace is a required field that specifies the namespace in which the platform component using the identity provider as an authentication mode is running. It is used in combination with componentName as a unique identifier.<br><p> <br><p> componentNamespace must not be an empty string ("") and must not exceed 63 characters in length.
     */
    @JsonProperty("componentNamespace")
    public String getComponentNamespace() {
        return componentNamespace;
    }

    /**
     * componentNamespace is a required field that specifies the namespace in which the platform component using the identity provider as an authentication mode is running. It is used in combination with componentName as a unique identifier.<br><p> <br><p> componentNamespace must not be an empty string ("") and must not exceed 63 characters in length.
     */
    @JsonProperty("componentNamespace")
    public void setComponentNamespace(String componentNamespace) {
        this.componentNamespace = componentNamespace;
    }

    /**
     * conditions are used to communicate the state of the `oidcClients` entry.<br><p> <br><p> Supported conditions include Available, Degraded and Progressing.<br><p> <br><p> If Available is true, the component is successfully using the configured client. If Degraded is true, that means something has gone wrong trying to handle the client configuration. If Progressing is true, that means the component is taking some action related to the `oidcClients` entry.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions are used to communicate the state of the `oidcClients` entry.<br><p> <br><p> Supported conditions include Available, Degraded and Progressing.<br><p> <br><p> If Available is true, the component is successfully using the configured client. If Degraded is true, that means something has gone wrong trying to handle the client configuration. If Progressing is true, that means the component is taking some action related to the `oidcClients` entry.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * consumingUsers is an optional list of ServiceAccounts requiring read permissions on the `clientSecret` secret.<br><p> <br><p> consumingUsers must not exceed 5 entries.
     */
    @JsonProperty("consumingUsers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getConsumingUsers() {
        return consumingUsers;
    }

    /**
     * consumingUsers is an optional list of ServiceAccounts requiring read permissions on the `clientSecret` secret.<br><p> <br><p> consumingUsers must not exceed 5 entries.
     */
    @JsonProperty("consumingUsers")
    public void setConsumingUsers(List<String> consumingUsers) {
        this.consumingUsers = consumingUsers;
    }

    /**
     * currentOIDCClients is an optional list of clients that the component is currently using. Entries must have unique issuerURL/clientID pairs.
     */
    @JsonProperty("currentOIDCClients")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OIDCClientReference> getCurrentOIDCClients() {
        return currentOIDCClients;
    }

    /**
     * currentOIDCClients is an optional list of clients that the component is currently using. Entries must have unique issuerURL/clientID pairs.
     */
    @JsonProperty("currentOIDCClients")
    public void setCurrentOIDCClients(List<OIDCClientReference> currentOIDCClients) {
        this.currentOIDCClients = currentOIDCClients;
    }

    @JsonIgnore
    public OIDCClientStatusBuilder edit() {
        return new OIDCClientStatusBuilder(this);
    }

    @JsonIgnore
    public OIDCClientStatusBuilder toBuilder() {
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
        if (!(o instanceof OIDCClientStatus)) {
            return false;
        }
        OIDCClientStatus other = (OIDCClientStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$componentName = this.getComponentName();
        Object other$componentName = other.getComponentName();
        if (this$componentName == null ? other$componentName != null : !this$componentName.equals(other$componentName)) {
            return false;
        }
        Object this$componentNamespace = this.getComponentNamespace();
        Object other$componentNamespace = other.getComponentNamespace();
        if (this$componentNamespace == null ? other$componentNamespace != null : !this$componentNamespace.equals(other$componentNamespace)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$consumingUsers = this.getConsumingUsers();
        Object other$consumingUsers = other.getConsumingUsers();
        if (this$consumingUsers == null ? other$consumingUsers != null : !this$consumingUsers.equals(other$consumingUsers)) {
            return false;
        }
        Object this$currentOIDCClients = this.getCurrentOIDCClients();
        Object other$currentOIDCClients = other.getCurrentOIDCClients();
        if (this$currentOIDCClients == null ? other$currentOIDCClients != null : !this$currentOIDCClients.equals(other$currentOIDCClients)) {
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
        return other instanceof OIDCClientStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $componentName = this.getComponentName();
        result = result * prime + ($componentName == null ? 43 : $componentName.hashCode());
        Object $componentNamespace = this.getComponentNamespace();
        result = result * prime + ($componentNamespace == null ? 43 : $componentNamespace.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $consumingUsers = this.getConsumingUsers();
        result = result * prime + ($consumingUsers == null ? 43 : $consumingUsers.hashCode());
        Object $currentOIDCClients = this.getCurrentOIDCClients();
        result = result * prime + ($currentOIDCClients == null ? 43 : $currentOIDCClients.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OIDCClientStatus(" + "componentName=" + this.getComponentName() + ", componentNamespace=" + this.getComponentNamespace() + ", conditions=" + this.getConditions() + ", consumingUsers=" + this.getConsumingUsers() + ", currentOIDCClients=" + this.getCurrentOIDCClients() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
