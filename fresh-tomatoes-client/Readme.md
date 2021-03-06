# Fresh Tomatoes Client
This module holds the client code related to the Fresh Tomatoes movie review app. 
  
## Technology and Framework
AngularJs with Material design

## Prerequisites
NodeJs, npm, nginx

## Setup instructions
clone the repository and navigate to the client's directory
```
    git clone https://github.com/tarahs/fresh-tomatoes.git
    cd fresh-tomatoes/fresh-tomatoes-client
  ```  
The module includes package.json which has all the dependencies needed. Install all packages by entering the command: 
```
npm install
```
The module includes gulpfile.js which has the gulp tasks configured to generate the distribution file. Run the following command inorder to generate the distribution files.
```
gulp
```
In order to run it on webserver, setup nginx with following configuration:

```
server{
        listen       8081;
        server_name     localhost;
        location    /api/ {
            expires -1;
            proxy_pass http://127.0.0.1:8080/fresh-tomatoes/api/v1/; # URL where the server app runs
        }
        location / {
            root /path/to/fresh-tomatoes-client;
            index /dist/index.html;
        }
    }
```
restart nginx after the above configuraiton changes
```
sudo nginx -s reload
```
load the UI from the browser
``` http://localhost:8081 ```


## Client Capabilities
  - View list of movies and ratings.
  - Search movies by movie name.
  - View movie details by cliking on movie name in horizontal list view.
  - Offline Capability to perform the above functionalities.
