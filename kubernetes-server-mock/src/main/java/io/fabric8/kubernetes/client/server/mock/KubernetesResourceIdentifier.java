package io.fabric8.kubernetes.client.server.mock;

class KubernetesResourceIdentifier {
  private final String name;
  private final String kind;
  private final String namespace;

  public KubernetesResourceIdentifier(String name, String kind, String namespace) {
    this.name = name;
    this.kind = kind;
    this.namespace = namespace;
  }

  public KubernetesResourceIdentifier(String name, String kind) {
    this(name, kind, null);
  }

  public boolean matches(String name, String kind, String namespace) {
    return this.name.equals(name) && this.kind.equals(kind) && this.namespace.equals(namespace);
  }

  public boolean matches(String name, String kind) {
    return this.name.equals(name) && this.kind.equals(kind);
  }
}
