# Common Tasks

## Running Examples

Examples are in the `kubernetes-examples` module.

```bash
cd kubernetes-examples
mvn exec:java -Dexec.mainClass="io.fabric8.kubernetes.examples.ListPods"
```

## Adding a New Resource Type

1. Define model class with builders in `kubernetes-model-generator`.
2. Add DSL interface in `kubernetes-client-api`.
3. Implement it in `kubernetes-client`.
4. Add tests in `kubernetes-tests`.

## Working with Custom Resources

```java
// Define the custom resource class
@Group("example.com")
@Version("v1")
public class MyResource extends CustomResource<MySpec, MyStatus>
    implements Namespaced {}

// Use with client
MixedOperation<MyResource, KubernetesResourceList<MyResource>, Resource<MyResource>>
    myResources = client.resources(MyResource.class);

myResources.inNamespace("ns").create(new MyResource());
```

## Generating CRDs from Java

See `/doc/CRD-generator.md`.

```bash
mvn io.fabric8:crd-generator-maven-plugin:generate
```

## Generating Java from CRDs

See `/doc/java-generation-from-CRD.md`.

```bash
mvn io.fabric8:java-generator-maven-plugin:generate
```

## Regenerating Model Classes

Use the make target when possible:

```bash
make generate-model
```

Use Maven directly when the task specifically requires it:

```bash
cd kubernetes-model-generator
mvn -Pgenerate clean install
```

## Updating CHANGELOG

When adding features or fixing bugs, update `CHANGELOG.md` in the root
directory.
