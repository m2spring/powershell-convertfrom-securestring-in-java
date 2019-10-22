# Code snippets for [PowerShell ConvertFrom-SecureString in Java?](https://stackoverflow.com/questions/58423051/powershell-convertfrom-securestring-in-java) post on stackoverlow.

## Running the PowerShell script ([on Linux](https://docs.microsoft.com/en-us/powershell/scripting/install/installing-powershell-core-on-linux?view=powershell-6))

```
$ pwsh -file encrypt.ps1
secret   : banana
encrypted: 76492d1116743f0423413b16050a5345MgB8AGMANgA4AGQANwBCAHgALwB3AFYAdQB0AFIAcwBDAFUAOQBOADAAVgBFAHcAPQA9AHwANgAyAGYAMABiAGIAMgA5ADAANwAzAGYANABhAGIAYwAzAGUAMwBkADMAOQAzADIAZAA5AGQAYgAyAGYAYQA4AA==
decrypted: banana
```

## Running the Java draft (as JUnit):

```
$ mvn --quiet test
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running org.example.EncryptionTest
secret   : banana
encrypted: Sqz3oV4uGJDUGYQChYmDmA==
decrypted: banana
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.33 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
```
