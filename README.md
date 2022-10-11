# jwt-demo-postmethodcredentials
Demo Spring backend using Spring security to do 3 things:

 1. Validate authentication requests against MySQL db.
 2. Generate and return JWT on successful authentication.
 3. Check all other incoming requests for valid JWT before serving.
## setup
 1. Generate a new public/private keypair in src/main/resources/certs.

    `# create rsa key pair`
    
    `openssl genrsa -out keypair.pem 2048`

    `# extract public key`
    
    `openssl rsa -in keypair.pem -pubout -out public.pem`
    
    `# create private key in PKCS#8 format`
    
    `openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem`

 2. Add the following lines to application.properties (in addition to your spring datasource)

`rsa.private-key=classpath:certs/private.pem`

`rsa.public-key=classpath:certs/public.pem`
## credits
- Dan Vega https://www.youtube.com/watch?v=UaB-0e76LdQ Spring Boot Spring Security JWT: How to authenticate with a username and password
- Dan Vega https://www.youtube.com/watch?v=KYNR5js2cXE Spring Security JWT: How to secure your Spring Boot REST APIs with JSON Web Tokens
