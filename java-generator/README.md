# Java generator (early preview release)

## Disclaimer

This is an early preview of a Java generator from CRD and
there might still be issues in the generated sources.
Please give it a try and report any issue you might find.

### Usage

The `java-generator` is distributed as a tiny CLI application, you can obtain it by running:

```
mvn clean package -f cli/pom.xml
```

The produced executable will be `cli/target/java-gen` and it provides basic configuration options:

```bash
Usage: java-gen [-hV] -crd=<crdFile> -dest=<destFolder>
      -crd, --custom-resource-definition=<crdFile>
                  The file with the CustomResourceDefinition to use
      -dest, --destination-folder=<destFolder>
                  The folder to write the generated sources
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
```

### Docker

The above CLI can also be packaged as a container into a running Docker daemon by running:

```
mvn -Pdocker clean package -f cli/pom.xml
```

Afterwards, a CRD can be mounted into the container and used to generate output. Example usage

```sh
$ mkdir k8s-java-gen
$ docker run --rm \
  -v /path/to/crd.yaml:/workdir/crd.yaml:ro \
  -v $PWD/k8s-java-gen:/out \
  fabric8io/java-generator-cli \
  --custom-resource-definition=/workdir/crd.yaml --destination-folder=/out
$ ls -lR k8s-java-gen # see generated files
```

### Formatting code

Code formatting is automated but remember to fix the headers before committing:

```bash
mvn license:format -f java-generator/pom.xml
```
