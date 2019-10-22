$key = 202,144,73,88,228,1,7,104,95,212,137,87,125,201,80,75,53,18,39,108,60,218,212,151,239,241,34,117,106,184,212,179

$secret = "banana"
Write-Output "secret   : $($secret)"

# encrypt
$secretSecured = ConvertTo-SecureString $secret -AsPlainText -Force
$encrypted = ConvertFrom-SecureString -secureString $secretSecured -key $key
Write-Output "encrypted: $($encrypted)"

# decrypt
$secure = $encrypted | ConvertTo-SecureString -key $key
$bstr = [System.Runtime.InteropServices.Marshal]::SecureStringToBSTR($secure)
$decrypted = [System.Runtime.InteropServices.Marshal]::PtrToStringAuto($bstr)
Write-Output "decrypted: $($decrypted)"
