## Kubernetes Client 6.x

The CI pipeline for the Kubernetes Client 6.x is outdated and no longer functional with the new Sonatype Maven Central.
The main issue is that since the release process requires compiling the project with multiple JDK versions in split processes,
the new `central-publishing-maven-plugin` does not support this workflow.

To be able to still release the Kubernetes Client 6.x, we have to use a manual process.

> [!NOTE]
> The SNAPSHOTs pipeline is still working since the SNAPSHOT release process is similar to that of the OSSRH repository.

### Manual Release Process

#### Build and install the project

Run the following command to build and install the project locally:

```bash
PASSPHRASE=<your_passphrase> ./scripts/6.x-release.sh
```

`PASSPHRASE` is the passphrase for the GPG key used to sign the artifacts.

#### Generate the ZIP bundle

Run the following command to generate the ZIP bundle:

```bash
./scripts/6.x-bundle.sh
```

This will create a ZIP file in a `/tmp/tmp.xxxxxxxxxxx` directory with the name `kubernetes-client-6.x.x-bundle.zip`.

#### Upload the ZIP bundle to Sonatype

Upload the generated ZIP bundle to Sonatype Maven Central using their web interface.

https://central.sonatype.com/publishing/deployments

Ensure that it validates and then click on "Publish".

