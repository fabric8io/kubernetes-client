
package io.fabric8.openshift.api.model.monitoring.v1beta1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configMap",
    "secret"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class AlertmanagerConfigSpecRPCHCTCCa_1 implements Editable<AlertmanagerConfigSpecRPCHCTCCa_1Builder> , KubernetesResource
{

    @JsonProperty("configMap")
    private AlertmanagerConfigSpecRPCHCTCCConfigMap_2 configMap;
    @JsonProperty("secret")
    private AlertmanagerConfigSpecRPCHCTCCSecret_2 secret;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerConfigSpecRPCHCTCCa_1() {
    }

    public AlertmanagerConfigSpecRPCHCTCCa_1(AlertmanagerConfigSpecRPCHCTCCConfigMap_2 configMap, AlertmanagerConfigSpecRPCHCTCCSecret_2 secret) {
        super();
        this.configMap = configMap;
        this.secret = secret;
    }

    @JsonProperty("configMap")
    public AlertmanagerConfigSpecRPCHCTCCConfigMap_2 getConfigMap() {
        return configMap;
    }

    @JsonProperty("configMap")
    public void setConfigMap(AlertmanagerConfigSpecRPCHCTCCConfigMap_2 configMap) {
        this.configMap = configMap;
    }

    @JsonProperty("secret")
    public AlertmanagerConfigSpecRPCHCTCCSecret_2 getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(AlertmanagerConfigSpecRPCHCTCCSecret_2 secret) {
        this.secret = secret;
    }

    @JsonIgnore
    public AlertmanagerConfigSpecRPCHCTCCa_1Builder edit() {
        return new AlertmanagerConfigSpecRPCHCTCCa_1Builder(this);
    }

    @JsonIgnore
    public AlertmanagerConfigSpecRPCHCTCCa_1Builder toBuilder() {
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
