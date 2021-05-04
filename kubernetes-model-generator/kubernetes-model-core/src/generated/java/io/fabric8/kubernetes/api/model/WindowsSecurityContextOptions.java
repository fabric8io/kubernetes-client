
package io.fabric8.kubernetes.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "gmsaCredentialSpec",
    "gmsaCredentialSpecName",
    "runAsUserName"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class WindowsSecurityContextOptions implements KubernetesResource
{

    @JsonProperty("gmsaCredentialSpec")
    private String gmsaCredentialSpec;
    @JsonProperty("gmsaCredentialSpecName")
    private String gmsaCredentialSpecName;
    @JsonProperty("runAsUserName")
    private String runAsUserName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WindowsSecurityContextOptions() {
    }

    /**
     * 
     * @param gmsaCredentialSpec
     * @param runAsUserName
     * @param gmsaCredentialSpecName
     */
    public WindowsSecurityContextOptions(String gmsaCredentialSpec, String gmsaCredentialSpecName, String runAsUserName) {
        super();
        this.gmsaCredentialSpec = gmsaCredentialSpec;
        this.gmsaCredentialSpecName = gmsaCredentialSpecName;
        this.runAsUserName = runAsUserName;
    }

    @JsonProperty("gmsaCredentialSpec")
    public String getGmsaCredentialSpec() {
        return gmsaCredentialSpec;
    }

    @JsonProperty("gmsaCredentialSpec")
    public void setGmsaCredentialSpec(String gmsaCredentialSpec) {
        this.gmsaCredentialSpec = gmsaCredentialSpec;
    }

    @JsonProperty("gmsaCredentialSpecName")
    public String getGmsaCredentialSpecName() {
        return gmsaCredentialSpecName;
    }

    @JsonProperty("gmsaCredentialSpecName")
    public void setGmsaCredentialSpecName(String gmsaCredentialSpecName) {
        this.gmsaCredentialSpecName = gmsaCredentialSpecName;
    }

    @JsonProperty("runAsUserName")
    public String getRunAsUserName() {
        return runAsUserName;
    }

    @JsonProperty("runAsUserName")
    public void setRunAsUserName(String runAsUserName) {
        this.runAsUserName = runAsUserName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
