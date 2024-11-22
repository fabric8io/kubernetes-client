
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "args",
    "command",
    "env",
    "installHint",
    "interactiveMode",
    "provideClusterInfo"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ExecConfig implements Editable<ExecConfigBuilder> , KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("args")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> args = new ArrayList<>();
    @JsonProperty("command")
    private String command;
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ExecEnvVar> env = new ArrayList<>();
    @JsonProperty("installHint")
    private String installHint;
    @JsonProperty("interactiveMode")
    private String interactiveMode;
    @JsonProperty("provideClusterInfo")
    private Boolean provideClusterInfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExecConfig() {
    }

    public ExecConfig(String apiVersion, List<String> args, String command, List<ExecEnvVar> env, String installHint, String interactiveMode, Boolean provideClusterInfo) {
        super();
        this.apiVersion = apiVersion;
        this.args = args;
        this.command = command;
        this.env = env;
        this.installHint = installHint;
        this.interactiveMode = interactiveMode;
        this.provideClusterInfo = provideClusterInfo;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("args")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getArgs() {
        return args;
    }

    @JsonProperty("args")
    public void setArgs(List<String> args) {
        this.args = args;
    }

    @JsonProperty("command")
    public String getCommand() {
        return command;
    }

    @JsonProperty("command")
    public void setCommand(String command) {
        this.command = command;
    }

    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ExecEnvVar> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<ExecEnvVar> env) {
        this.env = env;
    }

    @JsonProperty("installHint")
    public String getInstallHint() {
        return installHint;
    }

    @JsonProperty("installHint")
    public void setInstallHint(String installHint) {
        this.installHint = installHint;
    }

    @JsonProperty("interactiveMode")
    public String getInteractiveMode() {
        return interactiveMode;
    }

    @JsonProperty("interactiveMode")
    public void setInteractiveMode(String interactiveMode) {
        this.interactiveMode = interactiveMode;
    }

    @JsonProperty("provideClusterInfo")
    public Boolean getProvideClusterInfo() {
        return provideClusterInfo;
    }

    @JsonProperty("provideClusterInfo")
    public void setProvideClusterInfo(Boolean provideClusterInfo) {
        this.provideClusterInfo = provideClusterInfo;
    }

    @JsonIgnore
    public ExecConfigBuilder edit() {
        return new ExecConfigBuilder(this);
    }

    @JsonIgnore
    public ExecConfigBuilder toBuilder() {
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
