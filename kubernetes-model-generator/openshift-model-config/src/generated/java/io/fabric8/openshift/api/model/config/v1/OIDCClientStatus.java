
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
import io.fabric8.kubernetes.api.model.Condition;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "componentName",
    "componentNamespace",
    "conditions",
    "consumingUsers",
    "currentOIDCClients"
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
public class OIDCClientStatus implements Editable<OIDCClientStatusBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("componentName")
    public String getComponentName() {
        return componentName;
    }

    @JsonProperty("componentName")
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    @JsonProperty("componentNamespace")
    public String getComponentNamespace() {
        return componentNamespace;
    }

    @JsonProperty("componentNamespace")
    public void setComponentNamespace(String componentNamespace) {
        this.componentNamespace = componentNamespace;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("consumingUsers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getConsumingUsers() {
        return consumingUsers;
    }

    @JsonProperty("consumingUsers")
    public void setConsumingUsers(List<String> consumingUsers) {
        this.consumingUsers = consumingUsers;
    }

    @JsonProperty("currentOIDCClients")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OIDCClientReference> getCurrentOIDCClients() {
        return currentOIDCClients;
    }

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
