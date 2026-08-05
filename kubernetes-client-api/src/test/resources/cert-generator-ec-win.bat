@REM Fixed sample ECDSA client certificate/key for unit tests.
@echo off
echo {
echo   "kind": "ExecCredential",
echo   "apiVersion": "client.authentication.k8s.io/v1",
echo   "spec": {},
echo   "status": {
echo     "clientCertificateData": "-----BEGIN CERTIFICATE-----\nMIICUDCCATigAwIBAgIRAP5Y0VEn43LepIIhGBgZCm4wDQYJKoZIhvcNAQELBQAw\nFTETMBEGA1UEAxMKbWluaWt1YmVDQTAeFw0yMTExMDEwOTIyMThaFw0yMjExMDEw\nOTIyMThaMCUxEzARBgNVBAoTCmRldmVsb3BlcnMxDjAMBgNVBAMTBXV6YWlyMFkw\nEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEkAMD3WlBNsN0tiNCZSC8gK/5O4rxmkgj\n953kvWgv11/AorgxDFZpr2+azYJAN6ZNt8hXoBlsrBtDDzKnfPJszqNWMFQwDgYD\nVR0PAQH/BAQDAgWgMBMGA1UdJQQMMAoGCCsGAQUFBwMCMAwGA1UdEwEB/wQCMAAw\nHwYDVR0jBBgwFoAU4qycWT5q7c/4OgWIHdKILxBhjS8wDQYJKoZIhvcNAQELBQAD\nggEBANTomS4AL4z0cxd0KZQhts2ADlbgJQUmI7TU8+I70qoQhdvFC3xFuQM3KHVQ\nkt4amj+ahz74ZMGB8FH7SHvdLdb9yIsZQJttw6MVyrC3/GavRBQM3KwAB0CVMEQf\nRL/PYTXJSmPiicQH9BLUW9RzJwP4gnIlEj2yjLnAPyilH4LSiBvjE93nPBHdY0SF\n/v1/Jy3pnpcih05eHahFtMrE3FH1YaVCL2ncUGif//x9TNhR7WX2w0+X+fqY4w0Q\n4xmJCGW/DvYqBGqavdEYU1FMXvlhqQkRueYOGbU8P2VlhU5qd0Wdfdg8FokkdozL\nRUgkCbcwxOTea1Lit2iuDGzJezI=\n-----END CERTIFICATE-----\n",
echo     "clientKeyData": "-----BEGIN EC PRIVATE KEY-----\nMHcCAQEEIICkeBChzRrBMifb5r9rzdq4FphWRzPz1eDmRTnqBugJoAoGCCqGSM49\nAwEHoUQDQgAEkAMD3WlBNsN0tiNCZSC8gK/5O4rxmkgj953kvWgv11/AorgxDFZp\nr2+azYJAN6ZNt8hXoBlsrBtDDzKnfPJszg==\n-----END EC PRIVATE KEY-----\n"
echo   }
echo }
