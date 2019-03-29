package io.fabric8.kubernetes.client.dsl.base;

public class CustomResourceDefinitionContext {
  private String name;
  private String group;
  private String scope;
  private String plural;
  private String version;

  public String getName() { return name; }

  public String getGroup() {
    return group;
  }

  public String getScope() {
    return scope;
  }

  public String getPlural() {
    return plural;
  }

  public String getVersion() {
    return version;
  }

  public static class Builder {
    private CustomResourceDefinitionContext customResourceDefinitionContext;

    public Builder() {
      this.customResourceDefinitionContext = new CustomResourceDefinitionContext();
    }

    public Builder withName(String name) {
      this.customResourceDefinitionContext.name = name;
      return this;
    }

    public Builder withGroup(String group) {
      this.customResourceDefinitionContext.group = group;
      return this;
    }

    public Builder withScope(String scope) {
      this.customResourceDefinitionContext.scope = scope;
      return this;
    }

    public Builder withPlural(String plural) {
      this.customResourceDefinitionContext.plural = plural;
      return this;
    }

    public Builder withVersion(String version) {
      this.customResourceDefinitionContext.version = version;
      return this;
    }

    public CustomResourceDefinitionContext build() {
      return this.customResourceDefinitionContext;
    }
  }


}
