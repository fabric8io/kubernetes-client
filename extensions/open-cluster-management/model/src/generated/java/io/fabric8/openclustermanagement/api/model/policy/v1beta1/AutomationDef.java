
package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

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
    "extra_vars",
    "jobTtl",
    "name",
    "policyViolationsLimit",
    "secret",
    "type"
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
public class AutomationDef implements Editable<AutomationDefBuilder>, KubernetesResource
{

    @JsonProperty("extra_vars")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object extraVars;
    @JsonProperty("jobTtl")
    private Integer jobTtl;
    @JsonProperty("name")
    private String name;
    @JsonProperty("policyViolationsLimit")
    private Integer policyViolationsLimit;
    @JsonProperty("secret")
    private String secret;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AutomationDef() {
    }

    public AutomationDef(Object extraVars, Integer jobTtl, String name, Integer policyViolationsLimit, String secret, String type) {
        super();
        this.extraVars = extraVars;
        this.jobTtl = jobTtl;
        this.name = name;
        this.policyViolationsLimit = policyViolationsLimit;
        this.secret = secret;
        this.type = type;
    }

    @JsonProperty("extra_vars")
    public Object getExtraVars() {
        return extraVars;
    }

    @JsonProperty("extra_vars")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setExtraVars(Object extraVars) {
        this.extraVars = extraVars;
    }

    @JsonProperty("jobTtl")
    public Integer getJobTtl() {
        return jobTtl;
    }

    @JsonProperty("jobTtl")
    public void setJobTtl(Integer jobTtl) {
        this.jobTtl = jobTtl;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("policyViolationsLimit")
    public Integer getPolicyViolationsLimit() {
        return policyViolationsLimit;
    }

    @JsonProperty("policyViolationsLimit")
    public void setPolicyViolationsLimit(Integer policyViolationsLimit) {
        this.policyViolationsLimit = policyViolationsLimit;
    }

    @JsonProperty("secret")
    public String getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(String secret) {
        this.secret = secret;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public AutomationDefBuilder edit() {
        return new AutomationDefBuilder(this);
    }

    @JsonIgnore
    public AutomationDefBuilder toBuilder() {
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
