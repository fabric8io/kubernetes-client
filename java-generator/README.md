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

### Formatting code

Code formatting is automated but remember to fix the headers before committing, e.g.:

```bash
mvn spotless:apply license:format -f java-generator/pom.xml
```
